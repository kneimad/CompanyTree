package server.core;


import server.dao.CompanyDao;
import server.tree.CompanyNode;
import server.tree.CompanyTree;
import server.entity.CompEntity;

import java.util.Collection;

public class Manager {
    private static Manager ourInstance;
    private final CompanyDao companyDao;
    private CompanyTree companyTree;
    private Collection<CompEntity> companyRecords;

    private Manager() {
        this.companyDao = new CompanyDao();
        refreshCompanyData();
    }

    public static Manager getInstance() {
        if( ourInstance == null)
            ourInstance =  new Manager();
        return ourInstance;
    }

    public void removeCompany(int companyId) {
        companyDao.removeCompany(companyId);
        refreshCompanyData();
    }

    public void renameCompany(int companyId, String newCompanyName) {
        companyDao.renameCompany(companyId, newCompanyName);
        refreshCompanyData();
    }

    public void createCompany(int parentId, String companyName, int earning) {
        companyDao.createCompany(parentId, companyName, earning);
        refreshCompanyData();
    }

    public void refreshCompanyData() {
        companyRecords = companyDao.readCompanies();
        companyTree = new CompanyTree(companyRecords);
        Collection<CompanyNode> root = companyTree.getRoot();
        for (CompanyNode companyNode : root) {
            printCompanyBranch(companyNode, "");
        }
    }

    private void printCompanyBranch(CompanyNode companyNode, String indent) {
        CompEntity companyRecord = companyNode.getCompanyRecord();
        System.out.println(indent + companyRecord.getName() + " | " + companyRecord.getEarning() + " | " + companyNode.getFullEarnings());
        for (CompanyNode child : companyNode.getChildren()) {
            printCompanyBranch(child, indent + "  ");
        }
    }

    public CompanyTree getCompanyTree() {
        return companyTree;
    }

    public Collection<CompEntity> getCompanyRecords() {
        return companyRecords;
    }
}
