// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.mopub.network.TrackingRequest;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastCompanionAdConfig

class val.context
    implements ckListener
{

    final VastVideoViewController this$0;
    final Context val$context;
    final VastCompanionAdConfig val$vastCompanionAdConfig;

    public void onVastWebViewClick()
    {
        broadcastAction("com.mopub.action.interstitial.click");
        TrackingRequest.makeVastTrackingHttpRequest(val$vastCompanionAdConfig.getClickTrackers(), null, Integer.valueOf(VastVideoViewController.access$300(VastVideoViewController.this)), null, val$context);
        val$vastCompanionAdConfig.handleClick(val$context, 1, null);
    }

    ckListener()
    {
        this$0 = final_vastvideoviewcontroller;
        val$vastCompanionAdConfig = vastcompanionadconfig;
        val$context = Context.this;
        super();
    }
}
