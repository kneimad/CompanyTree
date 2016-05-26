public class CompanyTreeTest {

//    @Test
//    public void buildTree() {
//        //---------------------------------------------------------------------------------------------------
//        System.out.println("Company tree: Maven + Hibernate + MySQL");
//        Transaction tx = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Collection<CompEntity> list;
//
//        try{
//            tx = session.beginTransaction();
//
//            list = (Collection<CompEntity>) session.createCriteria(CompEntity.class).list();
//            for (CompEntity o : list) {
//                System.out.println(o.getId() + "\t" + o.getName() + "\t" + o.getEarning()  + "\t" + o.getParentId());
//            }
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//
//        }
//        System.out.println("\nEND DB connect Hibernate + MySQL\n\n");

        //CompanyTree comTree = new CompanyTree(list);

        //---------------------------------------------------------------------------------------------------
//        Map<String, CompanyNode> allCompanies = new HashMap<>();
//
//        CompanyNode root = new CompanyNode("C_1", 1, null);
//
//        allCompanies.put("C_1", root);
//        allCompanies.put("C_2", new CompanyNode("C_2", 2, allCompanies.get("C_1")));
//        allCompanies.put("C_3", new CompanyNode("C_3", 3, allCompanies.get("C_2")));
//        allCompanies.put("C_4", new CompanyNode("C_4", 4, allCompanies.get("C_1")));
//        allCompanies.put("C_5", new CompanyNode("C_5", 5, allCompanies.get("C_2")));
//        allCompanies.put("C_6", new CompanyNode("C_6", 6, allCompanies.get("C_4")));
//        allCompanies.put("C_7", new CompanyNode("C_7", 7, allCompanies.get("C_6")));
//
//        List<CompanyNode> companyNodeList = Lists.newArrayList(allCompanies.values());
//        Collections.shuffle(companyNodeList);
//
//        for (CompanyNode companyNode : companyNodeList) {
//            Optional.ofNullable(companyNode.getParent()).ifPresent(
//                    parent -> parent.addChild(companyNode)
//            );
//        }
//
//        root.calculateFullEarnings();
//
//        printCompany(root, "");
//        System.out.println("\n\n");
//        Collection<CompanyNode> c_4 = CompanyTree.getAllChildren(allCompanies.get("C_2"));
//        for (CompanyNode companyNode : c_4) {
//            System.out.println(companyNode.getName());
//        }
//    }

//    private void printCompany(CompanyNode companyNode, String indent) {
//        System.out.println(indent + companyNode.getName() + " | " + companyNode.getEarnings() + " | " + companyNode.getFullEarnings());
//        for (CompanyNode child : companyNode.getChildren()) {
//            printCompany(child, indent + "  ");
//        }
//    }
}
