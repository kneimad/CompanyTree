package server.servlets;

/**
 * Created by Damien on 24.05.2016.
 */

import server.core.Manager;
import server.dao.Data;
import server.dao.LocalDataImpl;
import server.util.ConverterJSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/ajax"})
public class AjaxTree extends HttpServlet {
    private Data data;
    private final static String CREATE = "create";
    private final static String RENAME = "rename";
    private final static String REMOVE = "remove";

    @Override
    public void init() throws ServletException {
        super.init();
        data = LocalDataImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        String nodeId = request.getParameter("id");
        String companyName = request.getParameter("companyName");
        String earning = request.getParameter("earning");
        String command = request.getParameter("command");
        PrintWriter out = response.getWriter();
        if(paramNullOrEmpty(command)) command = "default";
        System.out.println("Command: " + command + " node " + nodeId);
        Manager manager = Manager.getInstance();
        if (!paramNullOrEmpty(nodeId)) {
            switch (command) {
                case CREATE:
                    manager.createCompany(Integer.valueOf(nodeId), companyName, Integer.valueOf(earning));
                    break;
                case RENAME:
                    manager.renameCompany(Integer.valueOf(nodeId), companyName);
                    break;
                case REMOVE:
                    manager.removeCompany(Integer.valueOf(nodeId));
                    break;
                default:
                    sendTree(nodeId, out);
            }
        }
    }

    public void sendTree(String nodeId, PrintWriter out){
        try {
            if (nodeId.equals("0")) {
                out.println(ConverterJSON.toJSON_String(data.getRoot(), true));
            } else
                out.println(ConverterJSON.toJSON_String(data.getById(nodeId), false));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public boolean paramNullOrEmpty(String s){
        return !(s!=null && !s.isEmpty());
    }
}

/*

package server.servlets;

import server.dao.Data;
import server.dao.LocalDataImpl;
import server.util.ConverterJSON;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/api")
public class CompanyAction {
    private static Data data;
    static {
        data = LocalDataImpl.getInstance();
    }

    @Path("/company/{id}")
    @DELETE
    public Response removeCompany(@PathParam("id") Integer id){
        return Response.status(200).build();
    }

    @Path("/company")
    @GET
    public Response getCompany(@QueryParam("id") Integer id){
        StringBuilder out = new StringBuilder();
        try {
            if (id == 0) {
                out.append(ConverterJSON.toJSON_String(data.getRoot(), true));
            } else
                out.append(ConverterJSON.toJSON_String(data.getById(id.toString()), false));

        } catch (IOException e) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(out.toString()).build();
    }
}
 */