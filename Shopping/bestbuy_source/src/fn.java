// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

class fn extends SQLiteOpenHelper
{

    private Context a;

    public fn(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
    {
        super(context, s, cursorfactory, i);
        a = context;
    }

    private boolean a(String s, SQLiteDatabase sqlitedatabase)
    {
        s = "select * from SQLITE_MASTER where tbl_name='?'".replace("?", s);
        boolean flag1 = false;
        s = sqlitedatabase.rawQuery(s, null);
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.getCount() > 0)
            {
                s.close();
                flag = true;
            }
        }
        if (s != null && !s.isClosed())
        {
            s.close();
        }
        return flag;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            if (!a("user_profile", sqlitedatabase))
            {
                sqlitedatabase.execSQL(fp.a);
            }
            if (!a("store_appointment_time", sqlitedatabase))
            {
                sqlitedatabase.execSQL(fp.b);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            gs.e(getClass().getName(), (new StringBuilder()).append("SQLLiteException in oncreate ").append(sqlitedatabase.getMessage()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            gs.e(getClass().getName(), (new StringBuilder()).append("SQLException in oncreate ").append(sqlitedatabase.getMessage()).toString());
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        try
        {
            if (!a("user_profile", sqlitedatabase))
            {
                sqlitedatabase.execSQL(fp.a);
            }
            if (!a("store_appointment_time", sqlitedatabase))
            {
                sqlitedatabase.execSQL(fp.b);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            gs.e(getClass().getName(), (new StringBuilder()).append("SQLLiteException in onUpgrade ").append(sqlitedatabase.getMessage()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            gs.e(getClass().getName(), (new StringBuilder()).append("SQLException in onUpgrade ").append(sqlitedatabase.getMessage()).toString());
        }
    }
}
