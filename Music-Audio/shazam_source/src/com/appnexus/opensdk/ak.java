// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import com.appnexus.opensdk.b.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

// Referenced classes of package com.appnexus.opensdk:
//            ao, ai, d, ar, 
//            aq, aa, ag, b, 
//            ap, i, g, z, 
//            r, al

final class ak extends ao
{

    private final WeakReference a;
    private ag d;

    ak(ai ai1)
    {
        a = new WeakReference(ai1);
    }

    public final void a(aq aq1)
    {
        e();
        ai ai1 = (ai)a.get();
        if (ai1 != null)
        {
            ai1.c.a(aq1);
        }
    }

    public final void a(ar ar1)
    {
        Object obj;
        boolean flag;
label0:
        {
            boolean flag1 = true;
            obj = (ai)a.get();
            if (obj != null)
            {
                if (ar1 != null && ar1.f)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (super.b == null || super.b.isEmpty())
                {
                    flag1 = false;
                }
                if (flag || flag1)
                {
                    break label0;
                }
                com.appnexus.opensdk.b.b.d(b.f, com.appnexus.opensdk.b.b.a(an.d.response_no_ads));
                ((ai) (obj)).c.a(aq.c);
            }
            return;
        }
        if (flag)
        {
            super.b = ar1.d;
        }
        if (super.b != null && !super.b.isEmpty())
        {
            obj = f();
            if (obj != null && ar1 != null)
            {
                obj.g = ar1.e;
            }
            d = new ag(((aa) (obj)), this);
            return;
        } else
        {
            ar1 = (com.appnexus.opensdk.b)ar1.h;
            com.appnexus.opensdk.b.b.b(b.k, com.appnexus.opensdk.b.b.a(an.d.get_opens_native_browser, ((ai) (obj)).b.c));
            ar1.v = ((ai) (obj)).b.c;
            a(new i(ar1) {

                final com.appnexus.opensdk.b a;
                final ak b;

                public final z a()
                {
                    return z.c;
                }

                public final boolean b()
                {
                    return false;
                }

                public final r c()
                {
                    return null;
                }

                public final al d()
                {
                    return a;
                }

                public final void e()
                {
                    a.c();
                }

            
            {
                b = ak.this;
                a = b1;
                super();
            }
            });
            return;
        }
    }

    public final void a(i j)
    {
        e();
        if (d != null)
        {
            d = null;
        }
        ai ai1 = (ai)a.get();
        if (ai1 != null)
        {
            ai1.c.a(j);
            return;
        } else
        {
            j.e();
            return;
        }
    }

    public final ap b()
    {
        ai ai1 = (ai)a.get();
        if (ai1 != null)
        {
            return ai1.b;
        } else
        {
            return null;
        }
    }

    public final void c()
    {
        if (c != null)
        {
            c.cancel(true);
            c = null;
        }
        super.b = null;
        if (d != null)
        {
            ag ag1 = d;
            ag1.e = true;
            ag1.a();
            d = null;
        }
        a.clear();
    }
}
