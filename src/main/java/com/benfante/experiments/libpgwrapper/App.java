package com.benfante.experiments.libpgwrapper;

import com.benfante.experiments.libpqwrapper.swig.ConnStatusType;
import com.benfante.experiments.libpqwrapper.swig.ExecStatusType;
import com.benfante.experiments.libpqwrapper.swig.SWIGTYPE_p_pg_conn;
import com.benfante.experiments.libpqwrapper.swig.SWIGTYPE_p_pg_result;
import com.benfante.experiments.libpqwrapper.swig.pq;

public class App {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("pqswig");
        System.out.println("PQ Library Version: " + pq.PQlibVersion());
        SWIGTYPE_p_pg_conn connection = connectToPostgres("localhost", "5432", "test", "test", "test");

        SWIGTYPE_p_pg_result res = selectAllPerson(connection);

        printTuples(res);

        pq.PQclear(res);

        pq.PQfinish(connection);
    }

    private static SWIGTYPE_p_pg_conn connectToPostgres(String host, String port, String db, String username, String password) {
        SWIGTYPE_p_pg_conn connection = pq.PQconnectdb("postgresql://" + username + ":" + password + "@" + host + ":" + port + "/" + db);
        if (pq.PQstatus(connection) != ConnStatusType.CONNECTION_OK) {
            System.out.println("Connection to database failed: " + pq.PQerrorMessage(connection));
            exitNicely(connection);
        }
        return connection;
    }

    private static SWIGTYPE_p_pg_result selectAllPerson(SWIGTYPE_p_pg_conn connection) {
        SWIGTYPE_p_pg_result res = pq.PQexec(connection, "SELECT * FROM person");
        if (pq.PQresultStatus(res) != ExecStatusType.PGRES_TUPLES_OK) {
            System.out.println("SELECT failed: " + pq.PQerrorMessage(connection));
            pq.PQclear(res);
            exitNicely(connection);
        }
        return res;
    }

    private static void exitNicely(SWIGTYPE_p_pg_conn connection) {
        pq.PQfinish(connection);
        System.exit(0);
    }

    private static void printTuples(SWIGTYPE_p_pg_result res) {
        int nTuples = pq.PQntuples(res);
        int nFields = pq.PQnfields(res);
        for (int i = 0; i < nFields; i++) {
            System.out.printf("%-15s|", pq.PQfname(res, i));
        }
        System.out.println("");
        for (int i = 0; i < nTuples; i++) {
            for (int j = 0; j < nFields; j++) {
                System.out.printf("%-15s|", pq.PQgetvalue(res, i, j));
            }
            System.out.println("");
        }
    }
}
