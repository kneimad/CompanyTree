package server.dao;

import server.core.Manager;
import server.entity.CompEntity;
import server.tree.CompanyNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Damien on 24.05.2016.
 */
// Singleton
public class LocalDataImpl implements Data  {

    private static LocalDataImpl ourInstance;
    private static Manager manager = Manager.getInstance();

    public static LocalDataImpl getInstance() {
        if(ourInstance == null)
            ourInstance =  new LocalDataImpl();
        return ourInstance;
    }

    private LocalDataImpl() {
    }

    @Override
    public Map getRoot() {
        Map result = new HashMap();
        Collection<CompanyNode> comCol = manager.getCompanyTree().getRoot();
        for (CompanyNode companyNode : comCol) {
            result.put(companyNode.getId(), companyNode);
        }
         return result;
    }

    @Override
    public Map getById(String parentId) {
        Map result = new HashMap();
        Collection<CompanyNode> comCol = manager.getCompanyTree().getChildren(manager.getCompanyTree().getNode(Integer.parseInt(parentId)));
        for (CompanyNode companyNode : comCol) {
            result.put(companyNode.getId(), companyNode);
        }
        return result;
    }
}
