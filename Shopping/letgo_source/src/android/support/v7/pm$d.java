// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            ug, pm, mu, mt

public static class e extends ug
{

    private final Object d = new Object();
    private final b e;
    private boolean f;

    static e a(e e1)
    {
        return e1.e;
    }

    public void a()
    {
label0:
        {
            synchronized (d)
            {
                if (!f)
                {
                    break label0;
                }
            }
            return;
        }
        f = true;
        a(new uf.c() {

            final pm.d a;

            public void a(mt mt1)
            {
                zzb.v("Ending javascript session.");
                ((mu)mt1).a();
            }

            public void zzc(Object obj1)
            {
                a((mt)obj1);
            }

            
            {
                a = pm.d.this;
                super();
            }
        }, ((_cls1.a) (new <init>())));
        a(new uf.c() {

            final pm.d a;

            public void a(mt mt1)
            {
                zzb.v("Releasing engine reference.");
                pm.d.a(a).b();
            }

            public void zzc(Object obj1)
            {
                a((mt)obj1);
            }

            
            {
                a = pm.d.this;
                super();
            }
        }, new uf.a() {

            final pm.d a;

            public void run()
            {
                pm.d.a(a).b();
            }

            
            {
                a = pm.d.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public _cls3.a(_cls3.a a1)
    {
        e = a1;
    }
}
