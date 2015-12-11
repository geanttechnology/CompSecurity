// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            FlurryAdType

public interface FlurryAdListener
{

    public abstract void onAdClicked(String s);

    public abstract void onAdClosed(String s);

    public abstract void onAdOpened(String s);

    public abstract void onApplicationExit(String s);

    public abstract void onRenderFailed(String s);

    public abstract void onVideoCompleted(String s);

    public abstract boolean shouldDisplayAd(String s, FlurryAdType flurryadtype);

    public abstract void spaceDidFailToReceiveAd(String s);

    public abstract void spaceDidReceiveAd(String s);
}
