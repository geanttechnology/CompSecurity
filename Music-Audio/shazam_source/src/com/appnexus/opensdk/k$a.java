// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.Handler;
import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            d, k, i, z, 
//            aq, r, ae, f

private final class a
    implements d
{

    Handler a;
    final k b;

    public final void a()
    {
        a.post(new Runnable() {

            final k.a a;

            public final void run()
            {
                if (k.a(a.b) != null)
                {
                    k.a(a.b).b();
                }
            }

            
            {
                a = k.a.this;
                super();
            }
        });
    }

    public final void a(aq aq1)
    {
        a.post(new Runnable(aq1) {

            final aq a;
            final k.a b;

            public final void run()
            {
                if (k.a(b.b) != null)
                {
                    k.a(b.b).a();
                }
            }

            
            {
                b = k.a.this;
                a = aq1;
                super();
            }
        });
    }

    public final void a(i j)
    {
        if (j.a().equals(z.a) || j.a().equals(com.appnexus.opensdk.z.b))
        {
            a.post(new Runnable(j) {

                final i a;
                final k.a b;

                public final void run()
                {
                    b.b.setCreativeWidth(a.c().d());
                    b.b.setCreativeHeight(a.c().e());
                    if (a.b())
                    {
                        try
                        {
                            b.b.a((ae)a.c());
                        }
                        catch (ClassCastException classcastexception)
                        {
                            com.appnexus.opensdk.b.b.e(b.b, "The SDK shouldn't fail downcasts to MediatedDisplayable in AdView");
                        }
                    } else
                    {
                        b.b.a(a.c());
                    }
                    if (k.a(b.b) != null)
                    {
                        k.a(b.b).a(b.b);
                    }
                }

            
            {
                b = k.a.this;
                a = j;
                super();
            }
            });
            return;
        } else
        {
            a(aq.f);
            return;
        }
    }

    public final void a(String s, String s1)
    {
        a.post(new Runnable(s, s1) {

            final String a;
            final String b;
            final k.a c;

            public final void run()
            {
            }

            
            {
                c = k.a.this;
                a = s;
                b = s1;
                super();
            }
        });
    }

    public final void b()
    {
        a.post(new Runnable() {

            final k.a a;

            public final void run()
            {
                if (k.a(a.b) != null)
                {
                    k.a(a.b).c();
                }
            }

            
            {
                a = k.a.this;
                super();
            }
        });
    }

    public final void c()
    {
        a.post(new Runnable() {

            final k.a a;

            public final void run()
            {
                if (k.a(a.b) != null)
                {
                    k.a(a.b).d();
                }
            }

            
            {
                a = k.a.this;
                super();
            }
        });
    }

    public _cls6.b(k k1, Handler handler)
    {
        b = k1;
        super();
        a = handler;
    }
}
