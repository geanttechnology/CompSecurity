// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchResult

static class ayout.PanelState
{

    static final int $SwitchMap$com$groupon$Channel[];
    static final int $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[];

    static 
    {
        $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState = new int[com.sothree.slidinguppanel.PanelState.values().length];
        try
        {
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[com.sothree.slidinguppanel.PanelState.ANCHORED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[com.sothree.slidinguppanel.PanelState.HIDDEN.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[com.sothree.slidinguppanel.PanelState.EXPANDED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
