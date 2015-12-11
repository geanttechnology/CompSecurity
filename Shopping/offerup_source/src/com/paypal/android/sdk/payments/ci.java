// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.paypal.android.sdk.payments:
//            ca, be, cj, PayPalService

final class ci
    implements ServiceConnection
{

    final ca a;

    ci(ca ca1)
    {
        a = ca1;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        (new StringBuilder()).append(ca.b()).append(".onServiceConnected");
        a.a = ((be)ibinder).a;
        if (a.a.a(new cj(this)))
        {
            ca.d(a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        a.a = null;
    }
}
