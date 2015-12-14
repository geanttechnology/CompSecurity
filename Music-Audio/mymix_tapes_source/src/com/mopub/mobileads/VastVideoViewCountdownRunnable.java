// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;

// Referenced classes of package com.mopub.mobileads:
//            RepeatingHandlerRunnable, VastVideoViewController

public class VastVideoViewCountdownRunnable extends RepeatingHandlerRunnable
{

    private final VastVideoViewController mVideoViewController;

    public VastVideoViewCountdownRunnable(VastVideoViewController vastvideoviewcontroller, Handler handler)
    {
        super(handler);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(vastvideoviewcontroller);
        mVideoViewController = vastvideoviewcontroller;
    }

    public void doWork()
    {
        mVideoViewController.updateCountdown();
        if (mVideoViewController.shouldBeInteractable())
        {
            mVideoViewController.makeVideoInteractable();
        }
    }
}
