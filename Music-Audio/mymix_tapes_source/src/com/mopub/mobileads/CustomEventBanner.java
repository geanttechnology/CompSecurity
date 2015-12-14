// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            MoPubErrorCode

public abstract class CustomEventBanner
{
    public static interface CustomEventBannerListener
    {

        public abstract void onBannerClicked();

        public abstract void onBannerCollapsed();

        public abstract void onBannerExpanded();

        public abstract void onBannerFailed(MoPubErrorCode mopuberrorcode);

        public abstract void onBannerLoaded(View view);

        public abstract void onLeaveApplication();
    }


    public CustomEventBanner()
    {
    }

    protected abstract void loadBanner(Context context, CustomEventBannerListener customeventbannerlistener, Map map, Map map1);

    protected abstract void onInvalidate();
}
