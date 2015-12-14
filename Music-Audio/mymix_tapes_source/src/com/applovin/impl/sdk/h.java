// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.applovin.impl.sdk:
//            i, AppLovinAdServiceImpl, e

class h
    implements AppLovinAdLoadListener
{

    final AppLovinAdServiceImpl a;
    private final i b;

    private h(AppLovinAdServiceImpl applovinadserviceimpl, i j)
    {
        a = applovinadserviceimpl;
        super();
        b = j;
    }

    h(AppLovinAdServiceImpl applovinadserviceimpl, i j, e e)
    {
        this(applovinadserviceimpl, j);
    }

    public void adReceived(AppLovinAd applovinad)
    {
        Object obj1 = b.b;
        obj1;
        JVM INSTR monitorenter ;
        if (!AppLovinAdServiceImpl.a(a, b.a)) goto _L2; else goto _L1
_L1:
        long l = AppLovinAdServiceImpl.b(a, b.a);
        if (l <= 0L) goto _L4; else goto _L3
_L3:
        b.d = l * 1000L + System.currentTimeMillis();
_L6:
        b.c = applovinad;
_L7:
        Object obj;
        HashSet hashset;
        hashset = new HashSet(i.a(b));
        i.a(b).clear();
        obj = new HashSet(i.b(b));
        b.e = false;
        obj1;
        JVM INSTR monitorexit ;
        AppLovinAdServiceImpl.c(a, b.a);
        for (obj1 = hashset.iterator(); ((Iterator) (obj1)).hasNext();)
        {
            AppLovinAdLoadListener applovinadloadlistener = (AppLovinAdLoadListener)((Iterator) (obj1)).next();
            try
            {
                applovinadloadlistener.adReceived(applovinad);
            }
            catch (Throwable throwable1)
            {
                AppLovinAdServiceImpl.b(a).e("AppLovinAdService", "Unable to notify listener about a newly loaded ad", throwable1);
            }
        }

        break MISSING_BLOCK_LABEL_248;
_L4:
        if (l != 0L) goto _L6; else goto _L5
_L5:
        b.d = 0x7fffffffffffffffL;
          goto _L6
        applovinad;
        obj1;
        JVM INSTR monitorexit ;
        throw applovinad;
_L2:
        b.c = null;
        b.d = 0L;
          goto _L7
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            AppLovinAdUpdateListener applovinadupdatelistener = (AppLovinAdUpdateListener)((Iterator) (obj)).next();
            try
            {
                applovinadupdatelistener.adUpdated(applovinad);
            }
            catch (Throwable throwable)
            {
                AppLovinAdServiceImpl.b(a).e("AppLovinAdService", "Unable to notify listener about an updated loaded ad", throwable);
            }
        }

        return;
          goto _L6
    }

    public void failedToReceiveAd(int j)
    {
        HashSet hashset;
        synchronized (b.b)
        {
            hashset = new HashSet(i.a(b));
            i.a(b).clear();
            b.e = false;
        }
        for (obj = hashset.iterator(); ((Iterator) (obj)).hasNext();)
        {
            AppLovinAdLoadListener applovinadloadlistener = (AppLovinAdLoadListener)((Iterator) (obj)).next();
            try
            {
                applovinadloadlistener.failedToReceiveAd(j);
            }
            catch (Throwable throwable)
            {
                AppLovinAdServiceImpl.b(a).e("AppLovinAdService", "Unable to notify listener about ad load failure", throwable);
            }
        }

        break MISSING_BLOCK_LABEL_109;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
