// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            jx, jc, lc, jo, 
//            jw, lr

class it>
    implements jx
{

    final jc a;

    public volatile void a(jw jw)
    {
        a((lc)jw);
    }

    public void a(lc lc1)
    {
        a[lc1.c.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (a.c())
        {
            jo.a().b(new lr() {

                final jc._cls1 a;

                public void a()
                {
                    jc.a(a.a);
                }

            
            {
                a = jc._cls1.this;
                super();
            }
            });
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    nit>(jc jc1)
    {
        a = jc1;
        super();
    }
}
