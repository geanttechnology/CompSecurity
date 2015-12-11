// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.fa;
import com.paypal.android.sdk.fh;
import com.paypal.android.sdk.fi;
import com.paypal.android.sdk.fj;
import com.paypal.android.sdk.fk;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

// Referenced classes of package com.paypal.android.sdk.payments:
//            ao, PayPalService, a, aq, 
//            ax, PayPalAuthorization, LoginActivity, FuturePaymentInfoActivity, 
//            br, an, bf

public final class c extends Activity
{

    private static final String a = com/paypal/android/sdk/payments/c.getSimpleName();
    private Date b;
    private Timer c;
    private PayPalService d;
    private final ServiceConnection e = new ao(this);
    private boolean f;

    public c()
    {
    }

    static PayPalService a(c c1, PayPalService paypalservice)
    {
        c1.d = paypalservice;
        return paypalservice;
    }

    static bf a(c c1)
    {
        return c1.c();
    }

    static String a()
    {
        return a;
    }

    static Timer a(c c1, Timer timer)
    {
        c1.c = timer;
        return timer;
    }

    static PayPalService b(c c1)
    {
        return c1.d;
    }

    private void b()
    {
        com.paypal.android.sdk.payments.a.a(this, d.e());
    }

    private bf c()
    {
        return new aq(this);
    }

    static void c(c c1)
    {
        if (c1.d.e() == null)
        {
            Log.e(a, "Service state invalid.  Did you start the PayPalService?");
            c1.setResult(2);
            c1.finish();
            return;
        }
        ax ax1 = new ax(c1.getIntent(), c1.d.e(), false);
        if (!ax1.e())
        {
            Log.e(a, "Service extras invalid.  Please see the docs.");
            c1.setResult(2);
            c1.finish();
            return;
        }
        if (!ax1.a())
        {
            Log.e(a, "Extras invalid.  Please see the docs.");
            c1.setResult(2);
            c1.finish();
            return;
        }
        if (c1.d.j())
        {
            c1.b();
            return;
        } else
        {
            Calendar calendar = Calendar.getInstance();
            calendar.add(13, 1);
            c1.b = calendar.getTime();
            c1.d.a(c1.c(), false);
            return;
        }
    }

    static Date d(c c1)
    {
        return c1.b;
    }

    static void e(c c1)
    {
        c1.b();
    }

    static Timer f(c c1)
    {
        return c1.c;
    }

    public final void finish()
    {
        super.finish();
        (new StringBuilder()).append(a).append(".finish");
    }

    protected final void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        (new StringBuilder()).append(a).append(".onActivityResult");
        if (i != 1) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch -1 0: default 56
    //                   -1 89
    //                   0 84;
           goto _L3 _L4 _L5
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        Log.wtf(a, (new StringBuilder("unexpected request code ")).append(i).append(" call it a cancel").toString());
_L2:
        finish();
        return;
_L4:
        if (intent != null)
        {
            intent = (PayPalAuthorization)intent.getParcelableExtra("com.paypal.android.sdk.authorization");
            if (intent != null)
            {
                Intent intent1 = new Intent();
                intent1.putExtra("com.paypal.android.sdk.authorization", intent);
                setResult(-1, intent1);
            } else
            {
                Log.e(a, "result was OK, have data, but no authorization state in bundle, oops");
            }
        } else
        {
            Log.e(a, "result was OK, no intent data, oops");
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        (new StringBuilder()).append(a).append(".onCreate");
        (new fk(this)).a();
        (new fj(this)).a();
        (new fi(this)).a(Arrays.asList(new String[] {
            com/paypal/android/sdk/payments/c.getName(), com/paypal/android/sdk/payments/LoginActivity.getName(), com/paypal/android/sdk/payments/FuturePaymentInfoActivity.getName(), com/paypal/android/sdk/payments/a.getName()
        }));
        f = bindService(br.a(this), e, 1);
        dd.b(this);
        dd.a(this);
        bundle = new fh(this);
        setContentView(((fh) (bundle)).a);
        ((fh) (bundle)).b.setText(ex.a(fa.y));
        br.a(this, null, fa.y);
    }

    protected final Dialog onCreateDialog(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            return br.a(this, fa.bc, bundle, i);

        case 2: // '\002'
            return br.a(this, new an(this));

        case 3: // '\003'
            return br.a(this, fa.be, bundle, i);
        }
    }

    protected final void onDestroy()
    {
        (new StringBuilder()).append(a).append(".onDestroy");
        if (d != null)
        {
            d.o();
            d.r();
        }
        if (f)
        {
            unbindService(e);
            f = false;
        }
        super.onDestroy();
    }

}
