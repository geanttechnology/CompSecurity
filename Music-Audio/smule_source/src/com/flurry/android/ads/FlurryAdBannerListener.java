// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;


// Referenced classes of package com.flurry.android.ads:
//            FlurryAdBanner, FlurryAdErrorType

public interface FlurryAdBannerListener
{

    public abstract void onAppExit(FlurryAdBanner flurryadbanner);

    public abstract void onClicked(FlurryAdBanner flurryadbanner);

    public abstract void onCloseFullscreen(FlurryAdBanner flurryadbanner);

    public abstract void onError(FlurryAdBanner flurryadbanner, FlurryAdErrorType flurryaderrortype, int i);

    public abstract void onFetched(FlurryAdBanner flurryadbanner);

    public abstract void onRendered(FlurryAdBanner flurryadbanner);

    public abstract void onShowFullscreen(FlurryAdBanner flurryadbanner);

    public abstract void onVideoCompleted(FlurryAdBanner flurryadbanner);
}
