package server.dao;

import java.util.Map;

/**
 * Created by Damien on 24.05.2016.
 */
public interface Data {
    public Map getRoot();
    public Map getById(String parentId);
}
