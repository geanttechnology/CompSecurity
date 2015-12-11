// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import java.util.HashMap;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, CacheSyncManager, at, 
//            az, dc

final class bg
    implements AppCloudResponseHandler
{

    private String de;
    private CacheSyncManager df;

    bg(CacheSyncManager cachesyncmanager, String s)
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
            CacheSyncManager.a(df).w(de);
            CacheSyncManager.b(df).w(de);
            CacheSyncManager.c(df).s(de);
            AppCloudResponseHandler appcloudresponsehandler = (AppCloudResponseHandler)CacheSyncManager.b().get(de);
            if (appcloudresponsehandler != null)
            {
                appcloudresponsehandler.handleResponse(appcloudresponse);
            }
            CacheSyncManager.b().remove(de);
            return;
        } else
        {
            Log.e("CacheSyncManager", "DELETE didn't proceed");
            return;
        }
    }
}
