// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class LocalStateDao
{
    static final class LocalStateDaoHelper extends SQLiteOpenHelper
    {

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            GLogger.d(LocalStateDao.TAG, "Created localstate Table", new Object[0]);
            sqlitedatabase.execSQL("CREATE TABLE localstate (key TEXT PRIMARY KEY, value INTEGER);");
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            GLogger.d(LocalStateDao.TAG, (new StringBuilder()).append("Upgrading localstate from version ").append(i).append(" to ").append(j).toString(), new Object[0]);
            sqlitedatabase.execSQL("DROP TABLE localstate;");
            onCreate(sqlitedatabase);
        }

        public LocalStateDaoHelper(Context context)
        {
            super(context, "localstate.db", null, 1);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/LocalStateDao.getName();
    private final LocalStateDaoHelper daoOpenHelper;

    public LocalStateDao(Context context)
    {
        daoOpenHelper = new LocalStateDaoHelper(context);
    }

    protected void finalize()
    {
        daoOpenHelper.close();
    }

    public String getValue(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = null;
        Cursor cursor1 = daoOpenHelper.getReadableDatabase().query("localstate", new String[] {
            "value"
        }, "key = ?", new String[] {
            s
        }, null, null, null);
        if (cursor1 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor1;
        if (!cursor1.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor = cursor1;
        s1 = cursor1.getString(cursor1.getColumnIndexOrThrow("value"));
        s = s1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        cursor1.close();
        s = s1;
_L5:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = s1;
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        s = s1;
          goto _L5
        s;
        throw s;
        s;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        cursor.close();
        throw s;
    }

    public boolean setValue(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        SQLiteDatabase sqlitedatabase = daoOpenHelper.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("key", s);
        contentvalues.put("value", s1);
        l = sqlitedatabase.insertWithOnConflict("localstate", null, contentvalues, 5);
        boolean flag;
        if (l != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }


}
