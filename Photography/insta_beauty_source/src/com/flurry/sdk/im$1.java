// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            kb, im, jk, kg, 
//            js, ka

class it>
    implements kb
{

    final im a;

    public void a(jk jk1)
    {
        kg.a(4, im.a(a), (new StringBuilder()).append("onNetworkStateChanged : isNetworkEnable = ").append(jk1.a).toString());
        class _cls1
            implements Runnable
        {

            final im._cls1 a;

            public void run()
            {
                io.a().c();
            }

            _cls1()
            {
                a = im._cls1.this;
                super();
            }
        }

        if (jk1.a)
        {
            js.a().b(new _cls1());
        }
    }

    public volatile void a(ka ka)
    {
        a((jk)ka);
    }

    _cls1(im im1)
    {
        a = im1;
        super();
    }
}
