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

final class by extends CacheDBOperations
{

    public by(Context context, String s)
    {
        cD = dw.e(context, s);
        TAG = "PendingOperationsDB";
        cE = "pendingDataTable";
    }

    final ObjectData getObjectById(String s)
    {
        Cursor cursor = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        if (cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("objectsId");
            int j = cursor.getColumnIndex("collectionName");
            int k = cursor.getColumnIndex("key");
            int l = cursor.getColumnIndex("value");
            String s1 = null;
            do
            {
                String s4 = cursor.getString(i);
                String s5 = cursor.getString(j);
                String s2 = cursor.getString(k);
                String s3 = cursor.getString(l);
                s = s1;
                if (s1 == null)
                {
                    if (TextUtils.isEmpty(s5))
                    {
                        s = new ObjectData(s4);
                    } else
                    {
                        s = new ObjectData(s4, s5);
                    }
                }
                s.addKeyValue(s2, s3);
                s1 = s;
            } while (cursor.moveToNext());
        } else
        {
            s = null;
        }
        cursor.close();
        return s;
    }
}
