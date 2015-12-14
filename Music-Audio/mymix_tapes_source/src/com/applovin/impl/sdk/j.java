// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, AppLovinAdServiceImpl, i, h

class j extends bv
{

    final AppLovinAdServiceImpl a;
    private final AppLovinAdSize b;

    public j(AppLovinAdServiceImpl applovinadserviceimpl, AppLovinAdSize applovinadsize)
    {
        a = applovinadserviceimpl;
        super("UpdateAdTask", AppLovinAdServiceImpl.c(applovinadserviceimpl));
        b = applovinadsize;
    }

    public void run()
    {
        i k;
        boolean flag1;
        flag1 = true;
        k = (i)((Map)AppLovinAdServiceImpl.d(a).get(AppLovinAdType.REGULAR)).get(b);
        Object obj = k.b;
        obj;
        JVM INSTR monitorenter ;
        boolean flag2;
        boolean flag3;
        flag2 = AppLovinAdServiceImpl.a(a, b);
        flag3 = AppLovinAdServiceImpl.e(a);
        Exception exception;
        boolean flag;
        if (!i.b(k).isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (System.currentTimeMillis() <= k.d)
        {
            flag1 = false;
        }
        if (!flag2 || !flag || !flag1 || !flag3)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        if (!k.e)
        {
            k.e = true;
            AppLovinAdServiceImpl.a(a, b, AppLovinAdType.REGULAR, new h(a, k, null));
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
