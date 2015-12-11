// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.internal:
//            gp, ha, fw, gd

public final class ga extends gp
{

    private fw a;

    public ga(fw fw1)
    {
        a = fw1;
    }

    public final void a(int i, IBinder ibinder, Bundle bundle)
    {
        ha.a("onPostInitComplete can be called only once per call to getServiceFromBroker", a);
        fw fw1 = a;
        fw1.b.sendMessage(fw1.b.obtainMessage(1, new gd(fw1, i, ibinder, bundle)));
        a = null;
    }
}
