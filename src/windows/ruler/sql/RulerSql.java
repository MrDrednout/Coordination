package windows.ruler.sql;

import codesoftware.ora.connect.SQLConnect;

import java.sql.CallableStatement;

/**
 * Created by coole on 23.04.2017.
 */
public class RulerSql {

    SQLConnect MS = new SQLConnect();

    public String executeCreateUser(String f, String i, String o, String logg, String pass, int flg_block) {
        String j = null;
        try {
            CallableStatement cstmt = SQLConnect.c.prepareCall("begin U_COLLECTOR.program_restruct (?, ?); end;");
            cstmt.setString("F", f);
            cstmt.registerOutParameter("WRONG", java.sql.Types.INTEGER);
            cstmt.execute();
            cstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }
}
