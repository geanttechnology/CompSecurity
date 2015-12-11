// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.flurry.android.caching.ObjectData;

// Referenced classes of package com.flurry.android:
//            CacheDBOperations, dw, av

public class CacheDBServerOperations extends CacheDBOperations
{

    public CacheDBServerOperations(Context context, String s)
    {
        cD = dw.e(context, s);
        TAG = "CacheServerOperationsDB";
        cE = "serverDataTable";
    }

    public ObjectData getObjectById(String s)
    {
        Cursor cursor = cD.getReadableDatabase().query(cE, null, null, null, null, null, null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        ObjectData objectdata;
        int i = cursor.getColumnIndex("objectsId");
        int j = cursor.getColumnIndex("objectsLocalId");
        int k = cursor.getColumnIndex("collectionName");
        int l = cursor.getColumnIndex("key");
        int i1 = cursor.getColumnIndex("value");
        ObjectData objectdata1 = null;
        do
        {
label0:
            {
                String s3 = cursor.getString(i);
                String s5 = cursor.getString(j);
                String s4 = cursor.getString(k);
                String s1 = cursor.getString(l);
                String s2 = cursor.getString(i1);
                if (!s.equals(s3))
                {
                    objectdata = objectdata1;
                    if (!s.equals(s5))
                    {
                        break label0;
                    }
                }
                objectdata = objectdata1;
                if (objectdata1 == null)
                {
                    if (TextUtils.isEmpty(s4))
                    {
                        objectdata = new ObjectData(s3);
                    } else
                    {
                        objectdata = new ObjectData(s3, s4);
                    }
                }
                objectdata.addKeyValue(s1, s2);
            }
            objectdata1 = objectdata;
        } while (cursor.moveToNext());
_L4:
        cursor.close();
        return objectdata;
_L2:
        objectdata = null;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
