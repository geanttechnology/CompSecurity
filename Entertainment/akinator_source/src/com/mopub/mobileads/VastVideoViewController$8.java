// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.mopub.network.TrackingRequest;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastIconConfig

class val.context
    implements ckListener
{

    final VastVideoViewController this$0;
    final Context val$context;
    final VastIconConfig val$vastIconConfig;

    public void onVastWebViewClick()
    {
        TrackingRequest.makeVastTrackingHttpRequest(val$vastIconConfig.getClickTrackingUris(), null, Integer.valueOf(getCurrentPosition()), getNetworkMediaFileUrl(), val$context);
        val$vastIconConfig.handleClick(getContext(), null);
    }

    ckListener()
    {
        this$0 = final_vastvideoviewcontroller;
        val$vastIconConfig = vasticonconfig;
        val$context = Context.this;
        super();
    }
}
