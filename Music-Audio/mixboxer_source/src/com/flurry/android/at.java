// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.caching.ObjectData;
import java.util.UUID;
import java.util.Vector;
import org.apache.http.NameValuePair;

// Referenced classes of package com.flurry.android:
//            dr, by, bm, CacheDBOperations

final class at extends dr
{

    public at(Context context, String s)
    {
        fB = new by(context, s);
    }

    public final String a(ObjectData objectdata)
    {
        String s;
        int i;
        if (TextUtils.isEmpty(objectdata.getId()))
        {
            s = UUID.randomUUID().toString();
        } else
        {
            s = objectdata.getId();
        }
        for (i = 0; i < objectdata.getKeyValuesListSize(); i++)
        {
            fB.addItem(new bm(((NameValuePair)objectdata.getKeyValues().get(i)).getName(), ((NameValuePair)objectdata.getKeyValues().get(i)).getValue(), s, null, objectdata.getCollectionName()));
        }

        return s;
    }

    protected final boolean a(String s, String s1, String s2, String s3)
    {
        if (!s1.equals(fB.getValueByKey(s, s2, s3)))
        {
            b(s2, s, s1);
            fB.updateItem(s, s1, s2, s3);
            return true;
        } else
        {
            return false;
        }
    }
}
