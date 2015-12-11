// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            sg, pm, si, nt, 
//            ns, mt

static final class e
    implements Runnable
{

    final pm a;
    final si b;
    final nt c;
    final ns d;
    final String e;

    public void run()
    {
        e e1 = a.b();
        b.a(e1);
        c.a(d, new String[] {
            "rwc"
        });
        e1.a(new uf.c(c.a()) {

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
        }, new uf.a() {

            final sg._cls1 a;

            public void run()
            {
            }

            
            {
                a = sg._cls1.this;
                super();
            }
        });
    }

    _cls2.a(pm pm1, si si1, nt nt1, ns ns, String s)
    {
        a = pm1;
        b = si1;
        c = nt1;
        d = ns;
        e = s;
        super();
    }
}
