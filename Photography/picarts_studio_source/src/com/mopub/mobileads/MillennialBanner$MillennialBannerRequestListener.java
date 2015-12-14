// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;

// Referenced classes of package com.mopub.mobileads:
//            MillennialBanner, MoPubErrorCode

class this._cls0
    implements RequestListener
{

    final MillennialBanner this$0;

    public void MMAdOverlayClosed(MMAd mmad)
    {
        MillennialBanner.access$000(MillennialBanner.this).nerCollapsed();
    }

    public void MMAdOverlayLaunched(MMAd mmad)
    {
        MillennialBanner.access$000(MillennialBanner.this).nerExpanded();
    }

    public void MMAdRequestIsCaching(MMAd mmad)
    {
    }

    public void onSingleTap(MMAd mmad)
    {
        MillennialBanner.access$000(MillennialBanner.this).nerClicked();
    }

    public void requestCompleted(MMAd mmad)
    {
        MillennialBanner.access$000(MillennialBanner.this).nerLoaded(MillennialBanner.access$100(MillennialBanner.this));
    }

    public void requestFailed(MMAd mmad, MMException mmexception)
    {
        MillennialBanner.access$000(MillennialBanner.this).nerFailed(MoPubErrorCode.NETWORK_NO_FILL);
    }

    ()
    {
        this$0 = MillennialBanner.this;
        super();
    }
}
