package server.core;

public class Main {

    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        manager.refreshCompanyData();
    }
}
