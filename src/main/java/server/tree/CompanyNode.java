package server.tree;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import server.entity.CompEntity;

public class CompanyNode {
    private final transient CompEntity companyRecord;
    @JsonProperty("fullEarnings")
    private int fullEarnings;
    private final transient Collection<CompanyNode> children;

    public CompanyNode(CompEntity companyRecord) {
        this.companyRecord = companyRecord;
        this.children = new ArrayList<>();
    }

    public CompEntity getCompanyRecord() {
        return companyRecord;
    }

    public int getFullEarnings() {
        return fullEarnings;
    }

    public int getId() {
        return companyRecord.getId();
    }
    @JsonProperty("text")
    public String getCompanyName() {
        return companyRecord.getName() + "  |  " + companyRecord.getEarning() + "  |  "  + fullEarnings;
    }

    public void calculateFullEarnings() {
        fullEarnings = companyRecord.getEarning();
        for (CompanyNode child : children) {
            child.calculateFullEarnings();
            fullEarnings += child.getFullEarnings();
        }
    }
    @JsonProperty ("children")
    public boolean children() {
        return !children.isEmpty();
    }

    public Collection<CompanyNode> getChildren() {
        return children;
    }

    public void addChild(CompanyNode childCompanyNode) {
        children.add(childCompanyNode);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("companyRecord", companyRecord)
                .add("fullEarnings", fullEarnings)
                .add("children", children)
                .toString();
    }
}
