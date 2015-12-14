// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseQuery

static class or
{

    static final int $SwitchMap$com$parse$ParseQuery$CachePolicy[];

    static 
    {
        $SwitchMap$com$parse$ParseQuery$CachePolicy = new int[hePolicy.values().length];
        try
        {
            $SwitchMap$com$parse$ParseQuery$CachePolicy[hePolicy.IGNORE_CACHE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$parse$ParseQuery$CachePolicy[hePolicy.NETWORK_ONLY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$parse$ParseQuery$CachePolicy[hePolicy.CACHE_ONLY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$parse$ParseQuery$CachePolicy[hePolicy.CACHE_ELSE_NETWORK.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$parse$ParseQuery$CachePolicy[hePolicy.NETWORK_ELSE_CACHE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$parse$ParseQuery$CachePolicy[hePolicy.CACHE_THEN_NETWORK.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
