// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.util.Log;
import com.flurry.android.AppCloudResponse;
import com.flurry.android.AppCloudResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android.caching:
//            b, m

final class k
    implements AppCloudResponseHandler
{

    private b fo;

    k(b b1)
    {
        fo = b1;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse == null) goto _L2; else goto _L1
_L1:
        if (!appcloudresponse.isSuccessful()) goto _L4; else goto _L3
_L3:
        b.a(fo, appcloudresponse.getResponse().getString("_id"));
        Log.d("Trestle", (new StringBuilder()).append("Created object").append(appcloudresponse.getResponse().getString("_id")).toString());
        b.a(fo).it = 701;
_L5:
        b.a(fo).iu = appcloudresponse;
_L2:
        synchronized (b.b(fo))
        {
            b.b(fo).notifyAll();
        }
        return;
_L4:
        Log.d("Trestle", (new StringBuilder()).append("Created object Fail: ").append(appcloudresponse.getResponseMessage()).toString());
        b.a(fo).it = 731;
          goto _L5
        appcloudresponse;
        appcloudresponse.printStackTrace();
          goto _L2
        exception;
        appcloudresponse;
        JVM INSTR monitorexit ;
        throw exception;
          goto _L5
    }
}
