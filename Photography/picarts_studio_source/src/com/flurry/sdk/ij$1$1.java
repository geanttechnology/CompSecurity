// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            il, jx, ij, jh, 
//            kc, jo, jw

class >
    implements Runnable
{

    final > a;

    public void run()
    {
        il.a().c();
    }

    >(> >)
    {
        a = >;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/ij$1

/* anonymous class */
    class ij._cls1
        implements jx
    {

        final ij a;

        public void a(jh jh1)
        {
            kc.a(4, ij.a(a), (new StringBuilder("onNetworkStateChanged : isNetworkEnable = ")).append(jh1.a).toString());
            if (jh1.a)
            {
                jo.a().b(new ij._cls1._cls1(this));
            }
        }

        public volatile void a(jw jw)
        {
            a((jh)jw);
        }

            
            {
                a = ij1;
                super();
            }
    }

}
