// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType
{

    public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
    public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");
    private final String a;

    public AppLovinAdType(String s)
    {
        a = s;
    }

    public static Set allTypes()
    {
        HashSet hashset = new HashSet(2);
        hashset.add(REGULAR);
        hashset.add(INCENTIVIZED);
        return hashset;
    }

    public static AppLovinAdType fromString(String s)
    {
        if (s.toUpperCase(Locale.ENGLISH).equals(INCENTIVIZED.getLabel()))
        {
            return INCENTIVIZED;
        } else
        {
            return REGULAR;
        }
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
        obj = (AppLovinAdType)obj;
        if (a == null) goto _L4; else goto _L3
_L3:
        if (a.equals(((AppLovinAdType) (obj)).a)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((AppLovinAdType) (obj)).a == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public String getLabel()
    {
        return a.toUpperCase(Locale.ENGLISH);
    }

    public int hashCode()
    {
        if (a != null)
        {
            return a.hashCode();
        } else
        {
            return 0;
        }
    }

    public String toString()
    {
        return getLabel();
    }

}
