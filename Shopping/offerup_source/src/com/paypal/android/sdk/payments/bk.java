// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalTouchActivity, be, bl, PayPalService

final class bk
    implements ServiceConnection
{

    final PayPalTouchActivity a;

    bk(PayPalTouchActivity paypaltouchactivity)
    {
        a = paypaltouchactivity;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        (new StringBuilder()).append(PayPalTouchActivity.a()).append(".onServiceConnected");
        if (a.isFinishing())
        {
            (new StringBuilder()).append(PayPalTouchActivity.a()).append(".onServiceConnected exit - isFinishing");
        } else
        {
            PayPalTouchActivity.a(a, ((be)ibinder).a);
            if (PayPalTouchActivity.b(a).a(new bl(this)))
            {
                PayPalTouchActivity.a(a);
                return;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        PayPalTouchActivity.a(a, null);
        PayPalTouchActivity.a();
    }
}
