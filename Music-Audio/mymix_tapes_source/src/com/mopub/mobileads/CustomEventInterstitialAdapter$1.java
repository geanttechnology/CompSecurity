// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitialAdapter, MoPubErrorCode

class this._cls0
    implements Runnable
{

    final CustomEventInterstitialAdapter this$0;

    public void run()
    {
        MoPubLog.d("Third-party network timed out.");
        onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        invalidate();
    }

    ()
    {
        this$0 = CustomEventInterstitialAdapter.this;
        super();
    }
}
