// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            jx, ij, jh, kc, 
//            jo, jw, il

class it>
    implements jx
{

    final ij a;

    public void a(jh jh1)
    {
        kc.a(4, ij.a(a), (new StringBuilder("onNetworkStateChanged : isNetworkEnable = ")).append(jh1.a).toString());
        if (jh1.a)
        {
            jo.a().b(new Runnable() {

                final ij._cls1 a;

                public void run()
                {
                    il.a().c();
                }

            
            {
                a = ij._cls1.this;
                super();
            }
            });
        }
    }

    public volatile void a(jw jw)
    {
        a((jh)jw);
    }

    it>(ij ij1)
    {
        a = ij1;
        super();
    }
}
