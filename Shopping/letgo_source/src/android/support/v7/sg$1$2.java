// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            sg, pm, si, nt, 
//            ns, mt

class a
    implements a
{

    final a a;

    public void run()
    {
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class android/support/v7/sg$1

/* anonymous class */
    static final class sg._cls1
        implements Runnable
    {

        final pm a;
        final si b;
        final nt c;
        final ns d;
        final String e;

        public void run()
        {
            pm.d d1 = a.b();
            b.a(d1);
            c.a(d, new String[] {
                "rwc"
            });
            d1.a(new sg._cls1._cls1(c.a()), new sg._cls1._cls2(this));
        }

            
            {
                a = pm1;
                b = si1;
                c = nt1;
                d = ns;
                e = s;
                super();
            }

        // Unreferenced inner class android/support/v7/sg$1$1

/* anonymous class */
        class sg._cls1._cls1
            implements uf.c
        {

            final ns a;
            final sg._cls1 b;

            public void a(mt mt1)
            {
                b.c.a(a, new String[] {
                    "jsf"
                });
                b.c.b();
                mt1.a("/invalidRequest", b.b.c);
                mt1.a("/loadAdURL", b.b.d);
                try
                {
                    mt1.a("AFMA_buildAdURL", b.e);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (mt mt1)
                {
                    zzb.zzb("Error requesting an ad url", mt1);
                }
            }

            public void zzc(Object obj)
            {
                a((mt)obj);
            }

                    
                    {
                        b = sg._cls1.this;
                        a = ns;
                        super();
                    }
        }

    }

}
