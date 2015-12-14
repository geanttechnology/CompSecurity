// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.r;
import com.facebook.ads.internal.view.d;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            a, k, b

public class l extends a
{

    private static final String b = com/facebook/ads/internal/adapters/l.getSimpleName();
    private final d c;
    private k d;
    private boolean e;

    public l(Context context, d d1, b b1)
    {
        super(context, b1);
        c = d1;
    }

    static d a(l l1)
    {
        return l1.c;
    }

    private void a(Map map)
    {
        String s;
        if (d != null)
        {
            if (!r.a(s = d.f()))
            {
                (new o(map)).execute(new String[] {
                    s
                });
                return;
            }
        }
    }

    static k b(l l1)
    {
        return l1.d;
    }

    static String e()
    {
        return b;
    }

    public void a(k k1)
    {
        d = k1;
    }

    protected void b()
    {
        if (d == null)
        {
            return;
        }
        if (c != null && !r.a(d.g()))
        {
            if (c.b())
            {
                Log.w(b, "Webview already destroyed, cannot send impression");
            } else
            {
                c.loadUrl((new StringBuilder()).append("javascript:").append(d.g()).toString());
            }
        }
        a(Collections.singletonMap("evt", "native_imp"));
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (e) goto _L2; else goto _L1
_L1:
        k k1 = d;
        if (k1 != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        e = true;
        if (c != null && !r.a(d.e()))
        {
            c.post(new _cls1());
        }
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        a(Collections.singletonMap("evt", "interstitial_displayed"));
    }


    private class _cls1
        implements Runnable
    {

        final l a;

        public void run()
        {
            if (l.a(a).b())
            {
                Log.w(l.e(), "Webview already destroyed, cannot activate");
                return;
            } else
            {
                l.a(a).loadUrl((new StringBuilder()).append("javascript:").append(l.b(a).e()).toString());
                return;
            }
        }

        _cls1()
        {
            a = l.this;
            super();
        }
    }

}
