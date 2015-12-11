// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.sponsorpay.utils:
//            SPParametersProvider

public class SponsorPayParametersProvider
{

    private static SponsorPayParametersProvider INSTANCE = new SponsorPayParametersProvider();
    private Set providers;

    private SponsorPayParametersProvider()
    {
        providers = new HashSet();
    }

    private boolean addNewProvider(SPParametersProvider spparametersprovider)
    {
        return providers.add(spparametersprovider);
    }

    public static boolean addParametersProvider(SPParametersProvider spparametersprovider)
    {
        boolean flag;
        synchronized (INSTANCE)
        {
            flag = INSTANCE.addNewProvider(spparametersprovider);
        }
        return flag;
        spparametersprovider;
        sponsorpayparametersprovider;
        JVM INSTR monitorexit ;
        throw spparametersprovider;
    }

    public static Map getParameters()
    {
        Object obj;
label0:
        {
            Map map;
            synchronized (INSTANCE)
            {
                obj = INSTANCE.getProviders();
                if (((Set) (obj)).size() != 0)
                {
                    break label0;
                }
                map = Collections.emptyMap();
            }
            return map;
        }
        HashMap hashmap;
        hashmap = new HashMap();
        obj = ((Set) (obj)).iterator();
_L1:
        if (((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        sponsorpayparametersprovider;
        JVM INSTR monitorexit ;
        return hashmap;
        hashmap.putAll(((SPParametersProvider)((Iterator) (obj)).next()).getParameters());
          goto _L1
        exception;
        sponsorpayparametersprovider;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Set getProviders()
    {
        return providers;
    }

    public static boolean removeParametersProvider(SPParametersProvider spparametersprovider)
    {
        boolean flag;
        synchronized (INSTANCE)
        {
            flag = INSTANCE.removeProvider(spparametersprovider);
        }
        return flag;
        spparametersprovider;
        sponsorpayparametersprovider;
        JVM INSTR monitorexit ;
        throw spparametersprovider;
    }

    private boolean removeProvider(SPParametersProvider spparametersprovider)
    {
        return providers.remove(spparametersprovider);
    }

}
