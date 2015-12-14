// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.util.Log;
import com.targetspot.android.sdk.ui.AdPopup;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdClientImpl, AdManager, LoggingManager, AdBreak

class dler extends com.targetspot.android.sdk.util.Handler
{

    final AdClientImpl this$0;

    public void onPlaybackComplete()
    {
        AdManager.getInstance().getLogger().logImpression(AdClientImpl.access$500(AdClientImpl.this).segment);
        if (AdClientImpl.access$600(AdClientImpl.this).nextSegment(AdClientImpl.access$500(AdClientImpl.this)))
        {
            Log.d("AdClient", (new StringBuilder()).append("Switching ads, pos ").append(AdClientImpl.access$500(AdClientImpl.this).beginning).toString());
            startAudio(AdClientImpl.access$600(AdClientImpl.this), AdClientImpl.access$500(AdClientImpl.this).beginning);
            if (AdClientImpl.access$700(AdClientImpl.this) != null)
            {
                AdClientImpl.access$700(AdClientImpl.this).setPosition(AdClientImpl.access$500(AdClientImpl.this));
            }
            return;
        } else
        {
            AdClientImpl.access$100(AdClientImpl.this);
            stopAd(1);
            return;
        }
    }

    public void onPlaybackError()
    {
        AdClientImpl.access$100(AdClientImpl.this);
        sendPlaybackError(-1, new Exception("Ad playback error"));
    }

    Position()
    {
        this$0 = AdClientImpl.this;
        super();
    }
}
