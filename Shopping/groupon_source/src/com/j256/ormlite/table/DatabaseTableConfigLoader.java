// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.j256.ormlite.table:
//            DatabaseTableConfig

public class DatabaseTableConfigLoader
{

    public static DatabaseTableConfig fromReader(BufferedReader bufferedreader)
        throws SQLException
    {
        DatabaseTableConfig databasetableconfig = new DatabaseTableConfig();
        boolean flag = false;
        do
        {
            String s;
            try
            {
                s = bufferedreader.readLine();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", bufferedreader);
            }
            while (s == null || s.equals("# --table-end--")) 
            {
                if (flag)
                {
                    return databasetableconfig;
                } else
                {
                    return null;
                }
            }
            if (s.equals("# --table-fields-start--"))
            {
                readFields(bufferedreader, databasetableconfig);
            } else
            if (s.length() != 0 && !s.startsWith("#") && !s.equals("# --table-start--"))
            {
                String as[] = s.split("=", -2);
                if (as.length != 2)
                {
                    throw new SQLException((new StringBuilder()).append("DatabaseTableConfig reading from stream cannot parse line: ").append(s).toString());
                }
                readTableField(databasetableconfig, as[0], as[1]);
                flag = true;
            }
        } while (true);
    }

    public static List loadDatabaseConfigFromReader(BufferedReader bufferedreader)
        throws SQLException
    {
        ArrayList arraylist = new ArrayList();
        do
        {
            DatabaseTableConfig databasetableconfig = fromReader(bufferedreader);
            if (databasetableconfig == null)
            {
                return arraylist;
            }
            arraylist.add(databasetableconfig);
        } while (true);
    }

    private static void readFields(BufferedReader bufferedreader, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        ArrayList arraylist = new ArrayList();
_L5:
        Object obj;
        try
        {
            obj = bufferedreader.readLine();
        }
        // Misplaced declaration of an exception variable
        catch (BufferedReader bufferedreader)
        {
            throw SqlExceptionUtil.create("Could not read next field from config file", bufferedreader);
        }
        if (obj != null && !((String) (obj)).equals("# --table-fields-end--")) goto _L2; else goto _L1
_L1:
        databasetableconfig.setFieldConfigs(arraylist);
        return;
_L2:
        if ((obj = DatabaseFieldConfigLoader.fromReader(bufferedreader)) == null) goto _L1; else goto _L3
_L3:
        arraylist.add(obj);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static void readTableField(DatabaseTableConfig databasetableconfig, String s, String s1)
    {
        if (!s.equals("dataClass"))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        databasetableconfig.setDataClass(Class.forName(s1));
_L1:
        return;
        databasetableconfig;
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown class specified for dataClass: ").append(s1).toString());
        if (s.equals("tableName"))
        {
            databasetableconfig.setTableName(s1);
            return;
        }
          goto _L1
    }
}
