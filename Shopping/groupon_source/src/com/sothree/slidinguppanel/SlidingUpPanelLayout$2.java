// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sothree.slidinguppanel;


// Referenced classes of package com.sothree.slidinguppanel:
//            SlidingUpPanelLayout

static class nelState
{

    static final int $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[];

    static 
    {
        $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState = new int[nelState.values().length];
        try
        {
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[nelState.EXPANDED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[nelState.ANCHORED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[nelState.HIDDEN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[nelState.COLLAPSED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
