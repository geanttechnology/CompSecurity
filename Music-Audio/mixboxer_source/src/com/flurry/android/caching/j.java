// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.util.Log;
import com.flurry.android.AppCloudResponse;
import com.flurry.android.AppCloudResponseHandler;

// Referenced classes of package com.flurry.android.caching:
//            b, m

final class j
    implements AppCloudResponseHandler
{

    private b fo;

    j(b b1)
    {
        fo = b1;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse != null)
        {
            if (appcloudresponse.isSuccessful())
            {
                Log.d("Trestle", (new StringBuilder()).append("Get object").append(appcloudresponse.toString()).toString());
                b.a(fo).it = 701;
            } else
            {
                Log.d("Trestle", (new StringBuilder()).append("get Fail: ").append(appcloudresponse.getResponseMessage().toString()).toString());
                b.a(fo).it = 731;
            }
            b.a(fo).iu = appcloudresponse;
        }
        synchronized (b.b(fo))
        {
            b.b(fo).notifyAll();
        }
        return;
        exception;
        appcloudresponse;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
