// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.Context;
import android.content.Intent;
import com.paypal.android.sdk.a;
import com.paypal.android.sdk.cs;
import com.paypal.android.sdk.cv;
import com.paypal.android.sdk.dl;
import com.paypal.android.sdk.dn;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalService, br, az, e

final class ay
    implements Runnable
{

    private Context a;

    ay(Context context)
    {
        a = context;
        super();
    }

    public final void run()
    {
        PayPalService.v();
        Object obj = a;
        new br();
        obj = new a(((Context) (obj)), "AndroidBasePrefs");
        dl.a(((a) (obj)));
        dn.a(((a) (obj)));
        String s;
        for (Iterator iterator = (new az()).iterator(); iterator.hasNext(); cs.a(s))
        {
            s = (String)iterator.next();
            cv cv1 = new cv(((a) (obj)), s);
            cv1.a();
            cv1.b();
        }

        obj = new Intent("com.paypal.android.sdk.clearAllUserData");
        com.paypal.android.sdk.payments.e.a(a).a(((Intent) (obj)));
        PayPalService.v();
    }
}
