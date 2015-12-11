// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tapjoy.TJConnectListener;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.tapjoy.internal:
//            df, TapjoyConnectAutoRetry

final class <init> extends df
{

    final TapjoyConnectAutoRetry a;
    private boolean b;
    private boolean c;
    private Context d;
    private BroadcastReceiver e = new BroadcastReceiver() {

        final TapjoyConnectAutoRetry.b a;

        public final void onReceive(Context context, Intent intent)
        {
            a.a.b();
        }

            
            {
                a = TapjoyConnectAutoRetry.b.this;
                super();
            }
    };

    static boolean a(<init> <init>1)
    {
        <init>1.c = true;
        return true;
    }

    private void j()
    {
        d.unregisterReceiver(e);
    }

    protected final void a()
    {
        TapjoyConnectAutoRetry tapjoyconnectautoretry = a;
        e e1 = c;
        e e2 = b;
        TapjoyConnectAutoRetry.a(tapjoyconnectautoretry, e1);
    }

    protected final void b()
    {
        d = TapjoyConnectAutoRetry.b(a).a;
        IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        d.registerReceiver(e, intentfilter);
_L1:
        Object obj;
        if (b)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        obj = new CountDownLatch(1);
        b b1 = TapjoyConnectAutoRetry.b(a);
        if (a.a(b1.a, b1.b, b1.c, new TJConnectListener(((CountDownLatch) (obj))) {

        final CountDownLatch a;
        final TapjoyConnectAutoRetry.b b;

        public final void onConnectFailure()
        {
            a.countDown();
        }

        public final void onConnectSuccess()
        {
            TapjoyConnectAutoRetry.b.a(b);
            a.countDown();
        }

            
            {
                b = TapjoyConnectAutoRetry.b.this;
                a = countdownlatch;
                super();
            }
    }))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        TapjoyConnectAutoRetry.a(a, false);
        j();
        return;
        Exception exception;
        b b2;
        b b3;
        try
        {
            ((CountDownLatch) (obj)).await();
        }
        catch (InterruptedException interruptedexception) { }
        if (!c)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = a;
        b2 = e;
        b3 = c;
        TapjoyConnectAutoRetry.a(((TapjoyConnectAutoRetry) (obj)), b2);
        TapjoyConnectAutoRetry.a(a, true);
        j();
        return;
        TapjoyConnectAutoRetry.a(a, false);
        long l = Math.max(TapjoyConnectAutoRetry.c(a), 1000L);
        TapjoyConnectAutoRetry.a(a, Math.min(l << 2, 0x36ee80L));
        a.a(l);
          goto _L1
        exception;
        j();
        throw exception;
        j();
        return;
    }

    protected final void c()
    {
        if (TapjoyConnectAutoRetry.a(a) == this)
        {
            TapjoyConnectAutoRetry.a(a, null);
        }
        if (a.a() == c)
        {
            TapjoyConnectAutoRetry tapjoyconnectautoretry = a;
            j j1 = a;
            j j2 = c;
            TapjoyConnectAutoRetry.a(tapjoyconnectautoretry, j1);
        }
    }

    protected final void d()
    {
        b = true;
        a.b();
    }

    private _cls2.a(TapjoyConnectAutoRetry tapjoyconnectautoretry)
    {
        a = tapjoyconnectautoretry;
        super();
    }

    a(TapjoyConnectAutoRetry tapjoyconnectautoretry, byte byte0)
    {
        this(tapjoyconnectautoretry);
    }
}
