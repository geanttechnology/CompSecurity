// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;


// Referenced classes of package com.smule.android.network.managers:
//            PurchasesManager, v, w

class inPacksListener
    implements inPacksListener
{

    final w a;
    final Runnable b;
    final PurchasesManager c;

    public void handleResponse(v v1)
    {
        if (v1.a())
        {
            PurchasesManager.a(c, v1.mCoinPacks);
            a.a(PurchasesManager.a(c));
            return;
        } else
        {
            b.run();
            return;
        }
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((v)obj);
    }
}
