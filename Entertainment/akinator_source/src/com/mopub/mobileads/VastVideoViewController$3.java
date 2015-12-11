// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastVideoConfig, VastVideoView, VastVideoProgressBarWidget, 
//            VastVideoGradientStripWidget, VastVideoCtaButtonWidget, VastCompanionAdConfig

class val.context
    implements android.media.stener
{

    final VastVideoViewController this$0;
    final Context val$context;
    final VastVideoView val$videoView;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        VastVideoViewController.access$1300(VastVideoViewController.this);
        makeVideoInteractable();
        videoCompleted(false);
        VastVideoViewController.access$202(VastVideoViewController.this, true);
        if (!VastVideoViewController.access$1400(VastVideoViewController.this) && VastVideoViewController.access$400(VastVideoViewController.this).getRemainingProgressTrackerCount() == 0)
        {
            VastVideoViewController.access$400(VastVideoViewController.this).handleComplete(getContext(), getCurrentPosition());
        }
        val$videoView.setVisibility(4);
        VastVideoViewController.access$1000(VastVideoViewController.this).setVisibility(8);
        VastVideoViewController.access$1500(VastVideoViewController.this).setVisibility(8);
        VastVideoViewController.access$1600(VastVideoViewController.this).notifyVideoComplete();
        VastVideoViewController.access$1700(VastVideoViewController.this).notifyVideoComplete();
        VastVideoViewController.access$1800(VastVideoViewController.this).notifyVideoComplete();
        if (VastVideoViewController.access$700(VastVideoViewController.this) != null)
        {
            if (val$context.getResources().getConfiguration().orientation == 1)
            {
                VastVideoViewController.access$1900(VastVideoViewController.this).setVisibility(0);
            } else
            {
                VastVideoViewController.access$2000(VastVideoViewController.this).setVisibility(0);
            }
            VastVideoViewController.access$700(VastVideoViewController.this).handleImpression(val$context, VastVideoViewController.access$300(VastVideoViewController.this));
        } else
        if (VastVideoViewController.access$800(VastVideoViewController.this).getDrawable() != null)
        {
            VastVideoViewController.access$800(VastVideoViewController.this).setVisibility(0);
            return;
        }
    }

    et()
    {
        this$0 = final_vastvideoviewcontroller;
        val$videoView = vastvideoview;
        val$context = Context.this;
        super();
    }
}
