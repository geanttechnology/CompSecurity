// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.caching.ObjectData;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.flurry.android:
//            gi, er, go, ev, 
//            eg, AppCloudResponseHandler

final class fk
{

    private ExecutorService eD;

    public fk()
    {
        eD = null;
        eD = Executors.newSingleThreadExecutor();
    }

    public final void a(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        eD.execute(new gi(objectdata, appcloudresponsehandler));
    }

    public final void b(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        eD.execute(new er(objectdata, appcloudresponsehandler));
    }

    public final void c(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        eD.execute(new go(objectdata, appcloudresponsehandler));
    }

    public final void d(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        eD.execute(new ev(objectdata, appcloudresponsehandler));
    }

    public final void e(String s, String s1, String s2)
    {
        eD.execute(new eg(s, s1, s2, null));
    }
}
