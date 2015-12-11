// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.caching.ObjectData;
import java.util.HashMap;
import java.util.Vector;
import org.apache.http.NameValuePair;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, CacheSyncManager, at, 
//            az, dc

final class be
    implements AppCloudResponseHandler
{

    private String de;
    private CacheSyncManager df;
    private Vector dj;

    be(CacheSyncManager cachesyncmanager, String s, Vector vector)
    {
        df = cachesyncmanager;
        de = s;
        dj = vector;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse.isSuccessful())
        {
            if (CacheSyncManager.a(df).getObjectById(de).getKeyValues().equals(dj))
            {
                Object obj = CacheSyncManager.a(df).w(de);
                CacheSyncManager.b(df).b(((ObjectData) (obj)));
                CacheSyncManager.c(df).s(de);
                obj = (AppCloudResponseHandler)CacheSyncManager.b().get(de);
                if (obj != null)
                {
                    ((AppCloudResponseHandler) (obj)).handleResponse(appcloudresponse);
                }
                CacheSyncManager.b().remove(de);
                return;
            }
            Log.e("CacheSyncManager", "Data was changed during request to server");
            appcloudresponse = CacheSyncManager.a(df).getObjectById(de).getKeyValues();
            for (int i = 0; i < dj.size(); i++)
            {
                if (appcloudresponse.contains(dj.get(i)))
                {
                    CacheSyncManager.a(df).c(((NameValuePair)dj.get(i)).getName(), ((NameValuePair)dj.get(i)).getValue(), de);
                }
            }

            df.synchronize();
            return;
        } else
        {
            Log.e("CacheSyncManager", "MODIFY didn't proceed");
            return;
        }
    }
}
