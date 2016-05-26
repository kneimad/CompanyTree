package server.entity;

//import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Damien on 23.05.2016.
 */
public class CompEntity {

    private int id;
    private String name;
    private int parentId;
    private int earning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompEntity that = (CompEntity) o;

        if (id != that.id) return false;
        if (earning != that.earning) return false;
        if (parentId != that.parentId) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + earning;
        result = 31 * result + parentId;
        return result;
    }
}
