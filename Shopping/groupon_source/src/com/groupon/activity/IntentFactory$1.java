// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            IntentFactory

static class yments
{

    static final int $SwitchMap$com$groupon$Channel[];
    static final int $SwitchMap$com$groupon$activity$IntentFactory$Payments[];

    static 
    {
        $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.HOTELS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.MARKET_RATE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.OCCASIONS.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.FEATURED.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.COUPONS.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$groupon$activity$IntentFactory$Payments = new int[yments.values().length];
        try
        {
            $SwitchMap$com$groupon$activity$IntentFactory$Payments[yments.MAESTRO.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$activity$IntentFactory$Payments[yments.MAESTROUK.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
