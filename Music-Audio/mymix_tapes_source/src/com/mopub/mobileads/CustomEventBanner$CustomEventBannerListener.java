// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventBanner, MoPubErrorCode

public static interface 
{

    public abstract void onBannerClicked();

    public abstract void onBannerCollapsed();

    public abstract void onBannerExpanded();

    public abstract void onBannerFailed(MoPubErrorCode mopuberrorcode);

    public abstract void onBannerLoaded(View view);

    public abstract void onLeaveApplication();
}
