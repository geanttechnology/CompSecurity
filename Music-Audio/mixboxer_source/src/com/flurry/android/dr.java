// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.flurry.android.caching.ObjectData;
import java.util.Vector;
import org.apache.http.NameValuePair;

// Referenced classes of package com.flurry.android:
//            CacheDBOperations, AppCloudSearch, AppCloudUser, FlurryAppCloud, 
//            r, av

abstract class dr
{

    protected CacheDBOperations fB;

    dr()
    {
        fB = null;
    }

    protected boolean a(String s, String s1, String s2, String s3)
    {
        if (!s1.equals(fB.getValueByKey(s, s2, s3)))
        {
            b(s2, s, s1);
            AppCloudSearch.onMakeSearchNotValidForCollection(s3);
            fB.updateItem(s, s1, s2, s3);
            return true;
        } else
        {
            return false;
        }
    }

    public final String aI()
    {
        fB.readAll();
        return "";
    }

    public final void b(ObjectData objectdata)
    {
        int i = 0;
        while (i < objectdata.getKeyValues().size()) 
        {
            String s = ((NameValuePair)objectdata.getKeyValues().get(i)).getName();
            String s1 = ((NameValuePair)objectdata.getKeyValues().get(i)).getValue();
            if (objectdata.isUser())
            {
                a(s, s1, objectdata.getId(), null);
            } else
            {
                a(s, s1, objectdata.getId(), objectdata.getCollectionName());
            }
            i++;
        }
    }

    protected final void b(String s, String s1, String s2)
    {
        if (AppCloudUser.getCurrentUser() != null && TextUtils.equals(AppCloudUser.getCurrentUser().getId(), s))
        {
            AppCloudUser.getCurrentUser().set(s1, s2);
        }
        if (FlurryAppCloud.F() != null)
        {
            r.a(s, s1, s2);
        }
    }

    public final void c(String s, String s1, String s2)
    {
        fB.c(s, s1, s2);
    }

    public final boolean c(String s, String s1, String s2, String s3)
    {
        return a(s, s1, s2, s3);
    }

    public final ObjectData getObjectById(String s)
    {
        return fB.getObjectById(s);
    }

    public final boolean isUserObject(String s)
    {
        return fB.isUserObject(s);
    }

    public final ObjectData w(String s)
    {
        CacheDBOperations cachedboperations = fB;
        Cursor cursor = cachedboperations.cD.getReadableDatabase().query(cachedboperations.cE, null, (new StringBuilder()).append("objectsId='").append(s).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        if (cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("primery_key_id");
            int j = cursor.getColumnIndex("objectsId");
            int k = cursor.getColumnIndex("collectionName");
            int l = cursor.getColumnIndex("key");
            int i1 = cursor.getColumnIndex("value");
            String s1 = null;
            do
            {
                int j1 = cursor.getInt(i);
                String s4 = cursor.getString(j);
                String s5 = cursor.getString(k);
                String s2 = cursor.getString(l);
                String s3 = cursor.getString(i1);
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
                cachedboperations.e(j1);
                s1 = s;
            } while (cursor.moveToNext());
        } else
        {
            s = null;
        }
        cursor.close();
        return s;
    }

    public final boolean x(String s)
    {
        return fB.contains(s);
    }
}
