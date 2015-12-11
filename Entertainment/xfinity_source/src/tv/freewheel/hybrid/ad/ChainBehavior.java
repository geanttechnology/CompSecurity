// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import tv.freewheel.hybrid.ad.state.AdState;
import tv.freewheel.hybrid.ad.state.SlotState;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            PlayChainBehavior, PreloadChainBehavior, AdInstance

public abstract class ChainBehavior
{

    private static ChainBehavior playBehavior = null;
    private static ChainBehavior preloadBehavior = null;

    public ChainBehavior()
    {
    }

    public static ChainBehavior getPlayBehavior()
    {
        if (playBehavior == null)
        {
            playBehavior = new PlayChainBehavior();
        }
        return playBehavior;
    }

    public static ChainBehavior getPreloadBehavior()
    {
        if (preloadBehavior == null)
        {
            preloadBehavior = new PreloadChainBehavior();
        }
        return preloadBehavior;
    }

    public abstract boolean isChainStopper(AdInstance adinstance);

    public abstract boolean isDestState(AdState adstate);

    public abstract SlotState relatedSlotState();

}
