// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.mygroupons;

import com.groupon.MyGrouponsTabs;

// Referenced classes of package com.groupon.adapter.mygroupons:
//            MyGrouponsPagesCreator

static class 
{

    static final int $SwitchMap$com$groupon$MyGrouponsTabs[];

    static 
    {
        $SwitchMap$com$groupon$MyGrouponsTabs = new int[MyGrouponsTabs.values().length];
        try
        {
            $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.AVAILABLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.EXPIRING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.NEARBY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.ALL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
