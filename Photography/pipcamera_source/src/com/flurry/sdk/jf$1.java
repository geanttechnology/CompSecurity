// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            kb, jf, lg, js, 
//            ka, ly

class it>
    implements kb
{

    final jf a;

    public volatile void a(ka ka)
    {
        a((lg)ka);
    }

    public void a(lg lg1)
    {
        a[lg1.c.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (a.c())
        {
            js.a().b(new ly() {

                final jf._cls1 a;

                public void a()
                {
                    jf.a(a.a);
                }

            
            {
                a = jf._cls1.this;
                super();
            }
            });
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    nit>(jf jf1)
    {
        a = jf1;
        super();
    }
}
