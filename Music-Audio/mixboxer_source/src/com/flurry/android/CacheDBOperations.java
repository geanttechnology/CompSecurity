// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.flurry.android.caching.ObjectData;
import java.util.ArrayList;

// Referenced classes of package com.flurry.android:
//            al, av, bm

public abstract class CacheDBOperations extends al
{

    protected String TAG;

    public CacheDBOperations()
    {
    }

    public void addItem(bm bm1)
    {
        Log.d(TAG, (new StringBuilder()).append("--- Insert in ").append(cE).append(" : ---").toString());
        SQLiteDatabase sqlitedatabase = cD.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        String s = bm1.dE;
        String s1 = bm1.dF;
        String s2 = bm1.dG;
        String s3 = bm1.dC;
        bm1 = bm1.dD;
        contentvalues.put("objectsId", s);
        contentvalues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        contentvalues.put("objectsLocalId", s1);
        contentvalues.put("collectionName", s2);
        contentvalues.put("key", s3);
        contentvalues.put("value", bm1);
        sqlitedatabase.insert(cE, null, contentvalues);
    }

    final void c(String s, String s1, String s2)
    {
        s2 = cD.getWritableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s2).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        if (!s2.moveToFirst()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        i = s2.getColumnIndex("primery_key_id");
        j = s2.getColumnIndex("key");
        k = s2.getColumnIndex("value");
_L5:
        String s3;
        String s4;
        int l;
        l = s2.getInt(i);
        s3 = s2.getString(j);
        s4 = s2.getString(k);
        if (!s3.equals(s) || !s4.equals(s1)) goto _L4; else goto _L3
_L3:
        e(l);
        Log.e(TAG, (new StringBuilder()).append("removed as not modified (key, value) = ( ").append(s).append(" ; ").append(s1).append(" );").toString());
_L2:
        s2.close();
        return;
_L4:
        if (s2.moveToNext()) goto _L5; else goto _L2
    }

    public volatile void clearTable()
    {
        super.clearTable();
    }

    public volatile boolean contains(String s)
    {
        return super.contains(s);
    }

    final void e(int i)
    {
        cD.getWritableDatabase().delete(cE, (new StringBuilder()).append("primery_key_id='").append(i).append("'").toString(), null);
    }

    public ArrayList getData()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = cD.getReadableDatabase().query(cE, null, null, null, null, null, "objectsId ASC, julianday(timestamp)");
        if (cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("objectsId");
            int j = cursor.getColumnIndex("objectsLocalId");
            int k = cursor.getColumnIndex("collectionName");
            int l = cursor.getColumnIndex("key");
            int i1 = cursor.getColumnIndex("value");
            do
            {
                arraylist.add(new bm(cursor.getString(l), cursor.getString(i1), cursor.getString(i), cursor.getString(j), cursor.getString(k)));
            } while (cursor.moveToNext());
        } else
        {
            Log.w(TAG, (new StringBuilder()).append("TABLE ").append(cE).append(" IS EMPTY").toString());
        }
        cursor.close();
        return arraylist;
    }

    abstract ObjectData getObjectById(String s);

    public String getValueByKey(String s, String s1, String s2)
    {
        Object obj;
        Cursor cursor;
        obj = null;
        cursor = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s1).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        s1 = obj;
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        i = cursor.getColumnIndex("key");
        j = cursor.getColumnIndex("value");
        k = cursor.getColumnIndex("collectionName");
_L4:
        s1 = cursor.getString(k);
        String s3 = cursor.getString(i);
        if (!TextUtils.isEmpty(s1) && s1.equals(s2) && s3.equals(s))
        {
            s1 = cursor.getString(j);
        } else
        {
            if (!TextUtils.isEmpty(s1) || !TextUtils.isEmpty(s2) || !s3.equals(s))
            {
                continue; /* Loop/switch isn't completed */
            }
            s1 = cursor.getString(j);
        }
_L2:
        cursor.close();
        return s1;
        if (cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        s1 = obj;
          goto _L2
        if (true) goto _L4; else goto _L5
_L5:
    }

    public boolean hasKey(String s)
    {
        s = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("key='").append(s).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        boolean flag;
        if (s.moveToFirst())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.close();
        return flag;
    }

    public boolean hasKeyValueObject(bm bm1)
    {
        String s;
        s = bm1.dE;
        bm1 = bm1.dC;
        bm1 = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("key='").append(bm1).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        if (!bm1.moveToFirst()) goto _L2; else goto _L1
_L1:
        int i = bm1.getColumnIndex("objectsId");
_L3:
        boolean flag;
        if (!bm1.getString(i).equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
_L4:
        bm1.close();
        return flag;
        if (bm1.moveToNext()) goto _L3; else goto _L2
_L2:
        flag = false;
          goto _L4
    }

    public volatile boolean isEmpty()
    {
        return super.isEmpty();
    }

    public boolean isUserObject(String s)
    {
        s = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        boolean flag;
        if (s.moveToFirst())
        {
            int i = s.getColumnIndex("collectionName");
            do
            {
                if (TextUtils.isEmpty(s.getString(i)))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } while (s.moveToNext());
        } else
        {
            flag = false;
        }
        s.close();
        return flag;
    }

    public void readAll()
    {
        Cursor cursor = cD.getReadableDatabase().query(cE, null, null, null, null, null, "objectsId ASC, julianday(timestamp)");
        if (cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("primery_key_id");
            int j = cursor.getColumnIndex("timestamp");
            int k = cursor.getColumnIndex("objectsId");
            int l = cursor.getColumnIndex("objectsLocalId");
            int i1 = cursor.getColumnIndex("collectionName");
            int j1 = cursor.getColumnIndex("key");
            int k1 = cursor.getColumnIndex("value");
            do
            {
                Log.w(TAG, (new StringBuilder()).append("ID = ").append(cursor.getInt(i)).append(", timestamp = ").append(cursor.getLong(j)).append(", id = ").append(cursor.getString(k)).append(", local_id = ").append(cursor.getString(l)).append(", collection_name = ").append(cursor.getString(i1)).append(", key = ").append(cursor.getString(j1)).append(", value = ").append(cursor.getString(k1)).toString());
            } while (cursor.moveToNext());
        } else
        {
            Log.w(TAG, (new StringBuilder()).append("TABLE ").append(cE).append(" IS EMPTY").toString());
        }
        cursor.close();
    }

    public volatile int size()
    {
        return super.size();
    }

    public void updateItem(String s, String s1, String s2, String s3)
    {
        Cursor cursor;
        Log.d(TAG, (new StringBuilder()).append("--- update item in ").append(cE).append(": ---").toString());
        cursor = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s2).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = cursor.getColumnIndex("primery_key_id");
        j = cursor.getColumnIndex("key");
_L3:
        boolean flag;
        int k = cursor.getInt(i);
        if (!cursor.getString(j).equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        SQLiteDatabase sqlitedatabase = cD.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("objectsId", s2);
        contentvalues.put("objectsLocalId", null);
        contentvalues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        contentvalues.put("collectionName", s3);
        contentvalues.put("key", s);
        contentvalues.put("value", s1);
        sqlitedatabase.update(cE, contentvalues, (new StringBuilder()).append("primery_key_id='").append(k).append("'").toString(), null);
        flag = true;
_L4:
        if (!flag)
        {
            addItem(new bm(s, s1, s2, null, s3));
        }
        cursor.close();
        return;
        if (cursor.moveToNext()) goto _L3; else goto _L2
_L2:
        flag = false;
          goto _L4
    }
}
