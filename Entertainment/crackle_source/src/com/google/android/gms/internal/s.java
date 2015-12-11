// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            ct, cs, v, r

public final class s
{

    private final Runnable ep;
    private v eq;
    private boolean er;

    public s(r r)
    {
        er = false;
        ep = new Runnable(r) {

            private final WeakReference es;
            final r et;
            final s eu;

            public void run()
            {
                s.a(eu, false);
                r r1 = (r)es.get();
                if (r1 != null)
                {
                    r1.b(s.a(eu));
                }
            }

            
            {
                eu = s.this;
                et = r1;
                super();
                es = new WeakReference(et);
            }
        };
    }

    static v a(s s1)
    {
        return s1.eq;
    }

    static boolean a(s s1, boolean flag)
    {
        s1.er = flag;
        return flag;
    }

    public void a(v v, long l)
    {
        if (er)
        {
            ct.v("An ad refresh is already scheduled.");
            return;
        } else
        {
            ct.t((new StringBuilder()).append("Scheduling ad refresh ").append(l).append(" milliseconds from now.").toString());
            eq = v;
            er = true;
            cs.iI.postDelayed(ep, l);
            return;
        }
    }

    public void cancel()
    {
        cs.iI.removeCallbacks(ep);
    }

    public void d(v v)
    {
        a(v, 60000L);
    }
}
