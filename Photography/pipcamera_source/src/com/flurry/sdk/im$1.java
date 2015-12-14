// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            kb, im, jk, kg, 
//            js, ka, io

class it>
    implements kb
{

    final im a;

    public void a(jk jk1)
    {
        kg.a(4, im.a(a), (new StringBuilder()).append("onNetworkStateChanged : isNetworkEnable = ").append(jk1.a).toString());
        if (jk1.a)
        {
            js.a().b(new Runnable() {

                final im._cls1 a;

                public void run()
                {
                    io.a().c();
                }

            
            {
                a = im._cls1.this;
                super();
            }
            });
        }
    }

    public volatile void a(ka ka)
    {
        a((jk)ka);
    }

    it>(im im1)
    {
        a = im1;
        super();
    }
}
