// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

public class c
{

    private AppLovinAdSize a;
    private AppLovinAdType b;

    public c(AppLovinAd applovinad)
    {
        a = applovinad.getSize();
        b = applovinad.getType();
    }

    public c(AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype)
    {
        a = applovinadsize;
        b = applovinadtype;
    }

    public AppLovinAdSize a()
    {
        return a;
    }

    public AppLovinAdType b()
    {
        return b;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (c)obj;
        if (a == null ? ((c) (obj)).a != null : !a.equals(((c) (obj)).a)) goto _L4; else goto _L3
_L4:
        return false;
_L3:
        if (b == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (b.equals(((c) (obj)).b)) goto _L1; else goto _L4
        if (((c) (obj)).b != null) goto _L4; else goto _L5
_L5:
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (a != null)
        {
            i = a.hashCode();
        } else
        {
            i = 0;
        }
        if (b != null)
        {
            j = b.hashCode();
        }
        return i * 31 + j;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AdSpec{size=").append(a).append(", type=").append(b).append('}').toString();
    }
}
