// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import net.tsz.afinal.UtilChen;

public class MySqliteOpenHelper extends SQLiteOpenHelper
{

    private static MySqliteOpenHelper dbHelper;
    private String aa;
    private String defaultSql;
    private String defaultTableName;
    private Context mContext;
    private Object obj;

    private MySqliteOpenHelper(Context context, String s, Object obj1, String s1, String s2)
    {
        super(context, s, null, 2);
        aa = " ALTER TABLE downloadtask2 ADD COLUMN is_official text";
        mContext = context;
        obj = obj1;
        defaultTableName = s1;
        defaultSql = s2;
    }

    public static MySqliteOpenHelper create(Context context, String s, Object obj1, String s1, String s2)
    {
        net/tsz/afinal/db/sqlite/MySqliteOpenHelper;
        JVM INSTR monitorenter ;
        if (dbHelper == null)
        {
            dbHelper = new MySqliteOpenHelper(context, s, obj1, s1, s2);
        }
        context = dbHelper;
        net/tsz/afinal/db/sqlite/MySqliteOpenHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private boolean isExistField(SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append("name = '").append(s).append("' AND sql LIKE '%").append(s1).append("%'");
        s1 = null;
        s = null;
        sqlitedatabase = sqlitedatabase.query("sqlite_master", null, stringbuilder.toString(), null, null, null, null);
        s = sqlitedatabase;
        s1 = sqlitedatabase;
        int i = sqlitedatabase.getCount();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return flag;
        sqlitedatabase;
        s1 = s;
        sqlitedatabase.printStackTrace();
        if (s != null)
        {
            s.close();
        }
        return false;
        sqlitedatabase;
        if (s1 != null)
        {
            s1.close();
        }
        throw sqlitedatabase;
    }

    public SQLiteDatabase getDb()
    {
        return getWritableDatabase();
    }

    public void initDB(SQLiteDatabase sqlitedatabase)
    {
        UtilChen.addTab(defaultTableName, sqlitedatabase, obj);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (!TextUtils.isEmpty(defaultSql))
        {
            sqlitedatabase.execSQL(defaultSql);
        } else
        if (obj != null)
        {
            initDB(sqlitedatabase);
            return;
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        try
        {
            if (!isExistField(sqlitedatabase, "downloadtask2", "is_official"))
            {
                sqlitedatabase.execSQL(aa);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            return;
        }
    }
}
