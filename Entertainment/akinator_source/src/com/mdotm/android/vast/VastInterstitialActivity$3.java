// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import android.view.View;
import com.mdotm.android.listener.InterstitialActionListener;

// Referenced classes of package com.mdotm.android.vast:
//            VastInterstitialActivity, VastVideoView, VastAd

class this._cls0
    implements android.view.ctivity._cls3
{

    final VastInterstitialActivity this$0;

    public void onClick(View view)
    {
        VastInterstitialActivity.access$4(VastInterstitialActivity.this).skipVideo();
        if (!VastInterstitialActivity.access$5(VastInterstitialActivity.this) && VastInterstitialActivity.access$6(VastInterstitialActivity.this).liniearAndCompanion)
        {
            if (VastInterstitialActivity.access$4(VastInterstitialActivity.this).isPlaying())
            {
                VastInterstitialActivity.access$4(VastInterstitialActivity.this).stopVideo();
            }
            VastInterstitialActivity.access$7(VastInterstitialActivity.this);
            if (VastInterstitialActivity.access$8(VastInterstitialActivity.this) && !VastInterstitialActivity.access$9())
            {
                VastInterstitialActivity.access$10(VastInterstitialActivity.this).onRewardedVideoComplete(true, VastInterstitialActivity.access$11(VastInterstitialActivity.this));
                VastInterstitialActivity.access$12(VastInterstitialActivity.this, true);
            }
            return;
        }
        onDismissScreen();
        if (VastInterstitialActivity.access$8(VastInterstitialActivity.this) && !VastInterstitialActivity.access$9() && !VastInterstitialActivity.access$13(VastInterstitialActivity.this))
        {
            VastInterstitialActivity.access$10(VastInterstitialActivity.this).onRewardedVideoComplete(true, VastInterstitialActivity.access$11(VastInterstitialActivity.this));
        }
        finish();
    }

    ner()
    {
        this$0 = VastInterstitialActivity.this;
        super();
    }
}
