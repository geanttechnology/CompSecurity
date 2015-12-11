// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            fy, ch, cj, fp, 
//            fx, hq

class it>
    implements fy
{

    final ch a;

    public void a(cj cj1)
    {
        if (ch.f(a) == cj1.a)
        {
            fp.a().b(new hq() {

                final ch._cls5 a;

                public void safeRun()
                {
                    ch.g(a.a);
                }

            
            {
                a = ch._cls5.this;
                super();
            }
            });
        } else
        if (ch.h(a) == cj1.a)
        {
            fp.a().b(new hq(cj1) {

                final cj a;
                final ch._cls5 b;

                public void safeRun()
                {
                    ch.a(b.a, a.c);
                }

            
            {
                b = ch._cls5.this;
                a = cj1;
                super();
            }
            });
            return;
        }
    }

    public void notify(fx fx)
    {
        a((cj)fx);
    }

    nit>(ch ch1)
    {
        a = ch1;
        super();
    }
}
