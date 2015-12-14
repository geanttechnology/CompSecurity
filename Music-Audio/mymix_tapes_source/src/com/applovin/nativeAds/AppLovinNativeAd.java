// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.nativeAds;

import android.content.Context;

public interface AppLovinNativeAd
{

    public abstract long getAdId();

    public abstract String getCaptionText();

    public abstract String getClickUrl();

    public abstract String getCtaText();

    public abstract String getDescriptionText();

    public abstract String getIconUrl();

    public abstract String getImageUrl();

    public abstract String getImpressionTrackingUrl();

    public abstract float getStarRating();

    public abstract String getTitle();

    public abstract String getVideoEndTrackingUrl(int i, boolean flag);

    public abstract String getVideoStartTrackingUrl();

    public abstract String getVideoUrl();

    public abstract boolean isImagePrecached();

    public abstract boolean isVideoPrecached();

    public abstract void launchClickTarget(Context context);
}
