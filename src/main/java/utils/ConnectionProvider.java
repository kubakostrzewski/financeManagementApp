package utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

    private static DataSource dataSource;

    public static DataSource getDataSource(){
        if (dataSource == null){
            try {
                Context initialContext = new InitialContext();
                Context envContext = (Context) initialContext.lookup("java:comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/financemanagement");
            }catch (NamingException e){
                System.out.println("------ PROBLEM IN \"getDataSource()\" METHOD IN \"ConnectionProvider\" CLASS");
                e.printStackTrace();
            }
        }
        return dataSource;
    }

}
