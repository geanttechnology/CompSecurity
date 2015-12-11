// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;

import com.google.ads.mediation.MediationBannerListener;
import com.millennialmedia.android.aa;
import com.millennialmedia.android.ag;
import com.millennialmedia.android.at;

// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapter

private class <init>
    implements at
{

    final MillennialAdapter this$0;

    public void MMAdOverlayClosed(aa aa)
    {
        MillennialAdapter.access$200(MillennialAdapter.this).onDismissScreen(MillennialAdapter.this);
    }

    public void MMAdOverlayLaunched(aa aa)
    {
        MillennialAdapter.access$200(MillennialAdapter.this).onPresentScreen(MillennialAdapter.this);
    }

    public void MMAdRequestIsCaching(aa aa)
    {
    }

    public void onSingleTap(aa aa)
    {
        MillennialAdapter.access$200(MillennialAdapter.this).onClick(MillennialAdapter.this);
    }

    public void requestCompleted(aa aa)
    {
        MillennialAdapter.access$200(MillennialAdapter.this).onReceivedAd(MillennialAdapter.this);
    }

    public void requestFailed(aa aa, ag ag)
    {
        MillennialAdapter.access$200(MillennialAdapter.this).onFailedToReceiveAd(MillennialAdapter.this, com.google.ads.apter);
    }

    private ()
    {
        this$0 = MillennialAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
