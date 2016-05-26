package server.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import server.entity.CompEntity;

public class CompanyTree {
    private final static int ROOT_ID = 0;
    private Map<Integer, CompanyNode> allCompanies;
    private Collection<CompanyNode> root;

    public CompanyTree(Collection<CompEntity> companyRecords) {
        root = new ArrayList<>();
        allCompanies =
                companyRecords.stream().map(CompanyNode::new).collect(Collectors.toMap(
                        node -> node.getCompanyRecord().getId(),
                        node -> node
                ));
        allCompanies.values().forEach(this::processParent);

        root.forEach(CompanyNode::calculateFullEarnings);

    }

    public Collection<CompanyNode> getRoot() {
        return root;
    }

    public CompanyNode getNode(Integer id) {
        return allCompanies.get(id);
    }

    private void processParent(CompanyNode company) {
        int parentId = company.getCompanyRecord().getParentId();
        if (parentId == ROOT_ID) {
            root.add(company);
        } else {
            allCompanies.get(parentId).addChild(company);
        }
    }

    public Collection<CompanyNode> getAllChildren(CompanyNode company) {
        return fillAllChildren(company, new ArrayList<>());
    }

    private Collection<CompanyNode> fillAllChildren(CompanyNode company, Collection<CompanyNode> children) {
        for (CompanyNode child : company.getChildren()) {
            children.add(child);
            fillAllChildren(child, children);
        }
        return children;
    }

    public Collection<CompanyNode> getChildren(CompanyNode company) {
        return fillChildren(company, new ArrayList<>());
    }

    private Collection<CompanyNode> fillChildren(CompanyNode company, Collection<CompanyNode> children) {
        for (CompanyNode child : company.getChildren()) {
            children.add(child);
        }
        return children;
    }
}
