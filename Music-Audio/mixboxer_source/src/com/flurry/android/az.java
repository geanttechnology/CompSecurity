// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import com.flurry.android.caching.ObjectData;
import java.util.Vector;
import org.apache.http.NameValuePair;

// Referenced classes of package com.flurry.android:
//            dr, CacheDBServerOperations, bm, CacheDBOperations, 
//            AppCloudSearch

final class az extends dr
{

    public az(Context context, String s)
    {
        fB = new CacheDBServerOperations(context, s);
    }

    public final void a(String s, String s1, String s2, String s3, String s4)
    {
        s3 = new bm(s, s1, s2, s3, s4);
        if (!fB.hasKeyValueObject(s3))
        {
            fB.addItem(s3);
            b(s2, s, s1);
            AppCloudSearch.onMakeSearchNotValidForCollection(s4);
            return;
        }
        s3 = getObjectById(s2);
        for (int i = 0; i < s3.getKeyValuesListSize(); i++)
        {
            if (((NameValuePair)s3.getKeyValues().get(i)).getName().equals(s) && !((NameValuePair)s3.getKeyValues().get(i)).getValue().equals(s1))
            {
                b(s2, s, s1);
                AppCloudSearch.onMakeSearchNotValidForCollection(s4);
            }
        }

        fB.updateItem(s, s1, s2, s4);
    }

    public final boolean b(String s, String s1, String s2, String s3)
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
