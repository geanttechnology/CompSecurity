// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import android.widget.RelativeLayout;

// Referenced classes of package com.mdotm.android.vast:
//            VastInterstitialActivity

class this._cls0
    implements Runnable
{

    final VastInterstitialActivity this$0;

    public void run()
    {
        if (VastInterstitialActivity.access$3(VastInterstitialActivity.this) != null)
        {
            VastInterstitialActivity.access$3(VastInterstitialActivity.this).setVisibility(0);
        }
        VastInterstitialActivity.access$3(VastInterstitialActivity.this).bringToFront();
    }

    ()
    {
        this$0 = VastInterstitialActivity.this;
        super();
    }
}
