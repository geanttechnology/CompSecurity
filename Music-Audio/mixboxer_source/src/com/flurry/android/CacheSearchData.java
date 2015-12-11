// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.UUID;

// Referenced classes of package com.flurry.android:
//            al, dw, av

public class CacheSearchData extends al
{

    private static String TAG = "CacheSearchData";

    public CacheSearchData(Context context, String s)
    {
        cD = dw.e(context, s);
        cE = "searchRequestsTable";
    }

    public String addItem(String s, String s1, long l)
    {
        Log.d(TAG, (new StringBuilder()).append("--- Insert in ").append(cE).append(": ---").toString());
        SQLiteDatabase sqlitedatabase = cD.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        String s2 = UUID.randomUUID().toString();
        contentvalues.put("searchPredicat", s);
        contentvalues.put("collectionName", s1);
        contentvalues.put("timestamp", Long.valueOf(l));
        contentvalues.put("objectsId", s2);
        l = sqlitedatabase.insert(cE, null, contentvalues);
        Log.d(TAG, (new StringBuilder()).append("row inserted, ID = ").append(l).toString());
        readAll();
        return s2;
    }

    public volatile void clearTable()
    {
        super.clearTable();
    }

    public String contains(String s, String s1)
    {
        Object obj;
        Cursor cursor;
        obj = null;
        cursor = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("searchPredicat='").append(s).append("'").toString(), null, null, null, null);
        s = obj;
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = cursor.getColumnIndex("objectsId");
        j = cursor.getColumnIndex("collectionName");
_L4:
        String s2;
        s = cursor.getString(i);
        s2 = cursor.getString(j);
        break MISSING_BLOCK_LABEL_102;
_L2:
        do
        {
            do
            {
                cursor.close();
                return s;
            } while (TextUtils.isEmpty(s2) && TextUtils.isEmpty(s1) || s2 != null && s1 != null && s2.equals(s1));
            if (cursor.moveToNext())
            {
                continue;
            }
            s = obj;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile boolean contains(String s)
    {
        return super.contains(s);
    }

    public Object[] getIdsAssociatedWithCollectionName(String s)
    {
        SQLiteDatabase sqlitedatabase = cD.getReadableDatabase();
        HashSet hashset = new HashSet();
        s = sqlitedatabase.query(cE, null, (new StringBuilder()).append("collectionName='").append(s).append("'").toString(), null, null, null, null);
        if (s.moveToFirst())
        {
            int i = s.getColumnIndex("objectsId");
            do
            {
                hashset.add(s.getString(i));
            } while (s.moveToNext());
        }
        s.close();
        return hashset.toArray();
    }

    public volatile boolean isEmpty()
    {
        return super.isEmpty();
    }

    public void readAll()
    {
        Cursor cursor = cD.getReadableDatabase().query(cE, null, null, null, null, null, null);
        if (cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("searchPredicat");
            int j = cursor.getColumnIndex("collectionName");
            int k = cursor.getColumnIndex("timestamp");
            int l = cursor.getColumnIndex("objectsId");
            do
            {
                Log.w(TAG, (new StringBuilder()).append("predicat = ").append(cursor.getString(i)).append(", collection_name = ").append(cursor.getString(j)).append(", timestamp = ").append(cursor.getString(k)).append(", id = ").append(cursor.getString(l)).toString());
            } while (cursor.moveToNext());
        } else
        {
            Log.w(TAG, "TABLE IS EMPTY");
        }
        cursor.close();
    }

    public void removeByCollectionName(String s)
    {
        cD.getWritableDatabase().delete(cE, (new StringBuilder()).append("collectionName='").append(s).append("'").toString(), null);
    }

    public volatile int size()
    {
        return super.size();
    }

}
