// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl

abstract class bv
    implements Runnable
{

    final String e;
    protected final AppLovinSdkImpl f;
    final AppLovinLogger g;
    final Context h;

    bv(String s, AppLovinSdkImpl applovinsdkimpl)
    {
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        f = applovinsdkimpl;
        if (s == null)
        {
            s = getClass().getSimpleName();
        }
        e = s;
        g = applovinsdkimpl.getLogger();
        h = applovinsdkimpl.getApplicationContext();
    }

    String a()
    {
        return e;
    }

    void b()
    {
    }
}
