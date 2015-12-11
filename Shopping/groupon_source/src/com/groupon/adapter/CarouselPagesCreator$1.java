// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import com.groupon.Channel;

// Referenced classes of package com.groupon.adapter:
//            CarouselPagesCreator

static class 
{

    static final int $SwitchMap$com$groupon$Channel[];

    static 
    {
        $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.FEATURED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.OCCASIONS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.HOTELS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.COUPONS.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
