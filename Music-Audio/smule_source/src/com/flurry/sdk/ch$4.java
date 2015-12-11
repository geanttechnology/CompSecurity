// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            fy, ch, fp, ad, 
//            fx, hq

class it>
    implements fy
{

    final ch a;

    public void a(ad ad1)
    {
        fp.a().b(new hq(ad1) {

            final ad a;
            final ch._cls4 b;

            public void safeRun()
            {
                ch.a(b.a, a.a, a.b);
            }

            
            {
                b = ch._cls4.this;
                a = ad1;
                super();
            }
        });
    }

    public void notify(fx fx)
    {
        a((ad)fx);
    }

    nit>(ch ch1)
    {
        a = ch1;
        super();
    }
}
