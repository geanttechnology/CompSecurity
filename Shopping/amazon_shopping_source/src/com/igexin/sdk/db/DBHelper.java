// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.igexin.sdk.Consts;

public class DBHelper extends SQLiteOpenHelper
{

    SQLiteDatabase db;

    public DBHelper(Context context)
    {
        super(context, Consts.DB_NAME, null, Consts.DB_VERSION);
        db = null;
    }

    private String createSQL(String as[], String as1[], int i)
    {
        StringBuffer stringbuffer = new StringBuffer(" ");
        if (as.length == 1)
        {
            for (int j = 0; j < i; j++)
            {
                stringbuffer.append((new StringBuilder()).append(as[0]).append(" = '").append(as1[j]).append("'").toString());
                if (j < i - 1)
                {
                    stringbuffer.append(" or ");
                }
            }

        } else
        {
            for (int k = 0; k < i; k++)
            {
                stringbuffer.append((new StringBuilder()).append(as[k]).append(" = '").append(as1[k]).append("'").toString());
                if (k < i - 1)
                {
                    stringbuffer.append(" and ");
                }
            }

        }
        return stringbuffer.toString();
    }

    private String del_SQL(String s, String s1)
    {
        return (new StringBuffer((new StringBuilder()).append("delete from ").append(s).append(" where ").append(s1).toString())).toString();
    }

    public void delete(String s, String as[], String as1[])
    {
        db = getWritableDatabase();
        db.beginTransaction();
        if (as != null) goto _L2; else goto _L1
_L1:
        db.delete(s, null, null);
_L3:
        db.setTransactionSuccessful();
        db.endTransaction();
        return;
_L2:
        if (as.length != 1)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        if (as1.length != 1)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        db.delete(s, (new StringBuilder()).append(as[0]).append(" = ?").toString(), as1);
          goto _L3
        s;
        s.printStackTrace();
        db.endTransaction();
        return;
        db.execSQL(del_SQL(s, createSQL(as, as1, as1.length)));
          goto _L3
        s;
        db.endTransaction();
        throw s;
        db.execSQL(del_SQL(s, createSQL(as, as1, as.length)));
          goto _L3
    }

    public void insert(String s, ContentValues contentvalues)
    {
        db = getWritableDatabase();
        db.beginTransaction();
        try
        {
            db.insert(s, null, contentvalues);
            db.setTransactionSuccessful();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            db.endTransaction();
            return;
        }
        finally
        {
            db.endTransaction();
        }
        db.endTransaction();
        return;
        throw s;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        sqlitedatabase.execSQL("create table if not exists config (id integer primary key,name text,value text)");
        sqlitedatabase.execSQL("create table if not exists runtime (id integer primary key,name text,value text)");
        sqlitedatabase.execSQL("create table if not exists image(id integer primary key autoincrement, imageurl text, imagesrc text, taskid text, createtime bigint)");
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        sqlitedatabase.endTransaction();
        return;
        obj;
        sqlitedatabase.endTransaction();
        throw obj;
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("drop table if exists config");
        sqlitedatabase.execSQL("drop table if exists runtime");
        sqlitedatabase.execSQL("drop table if exists image");
        onCreate(sqlitedatabase);
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4)
    {
        String s5;
        Object obj;
        obj = null;
        s5 = obj;
        db = getReadableDatabase();
        s5 = obj;
        db.beginTransaction();
        s5 = obj;
        s = db.query(s, as, s1, as1, s2, s3, s4);
        s5 = s;
        db.setTransactionSuccessful();
        db.endTransaction();
        return s;
        s;
        s.printStackTrace();
        db.endTransaction();
        return s5;
        s;
        db.endTransaction();
        throw s;
    }

    public Cursor query(String s, String as[], String as1[], String as2[], String s1)
    {
        Object obj;
        obj = null;
        db = getReadableDatabase();
        db.beginTransaction();
        if (as != null) goto _L2; else goto _L1
_L1:
        String s2 = obj;
        s = db.query(s, as2, null, null, null, null, s1);
_L3:
        s2 = s;
        db.setTransactionSuccessful();
        db.endTransaction();
        return s;
_L2:
        s2 = obj;
        if (as.length != 1)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        s2 = obj;
        if (as1.length != 1)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s2 = obj;
        s = db.query(s, as2, (new StringBuilder()).append(as[0]).append("= ?").toString(), as1, null, null, s1);
          goto _L3
        s2 = obj;
        s = db.query(s, as2, createSQL(as, as1, as1.length), null, null, null, s1);
          goto _L3
        s2 = obj;
        s = db.query(s, as2, createSQL(as, as1, as.length), null, null, null, s1);
          goto _L3
        s;
        s.printStackTrace();
        db.endTransaction();
        return s2;
        s;
        db.endTransaction();
        throw s;
    }
}
