// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackListener;

// Referenced classes of package com.applovin.impl.sdk:
//            bm, bo

class bn
    implements AppLovinPostbackListener
{

    final bo a;
    final bm b;

    bn(bm bm1, bo bo)
    {
        b = bm1;
        a = bo;
        super();
    }

    public void onPostbackFailure(String s, int i)
    {
        bm.a(b).i("PersistentPostbackManager", (new StringBuilder()).append("Failed to submit postback with errorCode ").append(i).append(". Will retry later...  Postback: ").append(a).toString());
        bm.b(b, a);
    }

    public void onPostbackSuccess(String s)
    {
        bm.a(b, a);
        bm.a(b).d("PersistentPostbackManager", (new StringBuilder()).append("Successfully submitted postback: ").append(a).toString());
        b.b();
    }
}
