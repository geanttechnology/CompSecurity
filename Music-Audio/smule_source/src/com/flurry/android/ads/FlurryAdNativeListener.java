// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;


// Referenced classes of package com.flurry.android.ads:
//            FlurryAdNative, FlurryAdErrorType

public interface FlurryAdNativeListener
{

    public abstract void onAppExit(FlurryAdNative flurryadnative);

    public abstract void onClicked(FlurryAdNative flurryadnative);

    public abstract void onCloseFullscreen(FlurryAdNative flurryadnative);

    public abstract void onError(FlurryAdNative flurryadnative, FlurryAdErrorType flurryaderrortype, int i);

    public abstract void onFetched(FlurryAdNative flurryadnative);

    public abstract void onImpressionLogged(FlurryAdNative flurryadnative);

    public abstract void onShowFullscreen(FlurryAdNative flurryadnative);
}
