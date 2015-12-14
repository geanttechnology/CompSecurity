// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;


// Referenced classes of package com.applovin.impl.sdk:
//            bv, AppLovinSdkImpl, r, cj

public class ci extends bv
{

    private final cj a;

    public ci(AppLovinSdkImpl applovinsdkimpl, cj cj1)
    {
        super("TaskCollectAdvertisingId", applovinsdkimpl);
        a = cj1;
    }

    public void run()
    {
        s s = f.getDataCollector().c();
        a.a(s);
    }
}
