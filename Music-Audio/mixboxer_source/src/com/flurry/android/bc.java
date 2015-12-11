// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.caching.ObjectData;
import java.util.HashMap;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, CacheSyncManager, at, 
//            az, dc

final class bc
    implements AppCloudResponseHandler
{

    private String de;
    private CacheSyncManager df;

    bc(CacheSyncManager cachesyncmanager, String s, boolean flag)
    {
        df = cachesyncmanager;
        de = s;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse.isSuccessful())
        {
            Object obj = CacheSyncManager.a(df).w(de);
            ((ObjectData) (obj)).setId(appcloudresponse.getResponse().getString("_id"));
            az az1 = CacheSyncManager.b(df);
            String s = de;
            int i = 0;
            while (i < ((ObjectData) (obj)).getKeyValues().size()) 
            {
                String s1 = ((NameValuePair)((ObjectData) (obj)).getKeyValues().get(i)).getName();
                String s2 = ((NameValuePair)((ObjectData) (obj)).getKeyValues().get(i)).getValue();
                String s3 = ((ObjectData) (obj)).getId();
                if (((ObjectData) (obj)).isUser())
                {
                    az1.a(s1, s2, s3, s, null);
                } else
                {
                    az1.a(s1, s2, s3, s, ((ObjectData) (obj)).getCollectionName());
                }
                i++;
            }
            CacheSyncManager.c(df).s(de);
            obj = (AppCloudResponseHandler)CacheSyncManager.b().get(de);
            if (obj != null)
            {
                ((AppCloudResponseHandler) (obj)).handleResponse(appcloudresponse);
            }
            CacheSyncManager.b().remove(de);
            return;
        }
        if (appcloudresponse.getResponseMessage().equals("account already exists for email"))
        {
            CacheSyncManager.a(df).w(de);
            CacheSyncManager.c(df).s(de);
            AppCloudResponseHandler appcloudresponsehandler = (AppCloudResponseHandler)CacheSyncManager.b().get(de);
            if (appcloudresponsehandler != null)
            {
                appcloudresponsehandler.handleResponse(appcloudresponse);
            }
            CacheSyncManager.b().remove(de);
        }
        Log.e("CacheSyncManager", "CREATE didn't proceed");
    }
}
