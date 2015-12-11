// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod;

import android.app.Activity;
import java.util.List;

public interface MShopAmazonInstantVideo
{

    public abstract void forceRefreshAccount();

    public abstract List getGroverRecommendations();

    public abstract long getGroverRecommendationsTTLMillis();

    public abstract boolean isAIVBeta();

    public abstract boolean isPlaybackSustainable();

    public abstract boolean isSupported();

    public abstract void refreshUserData();

    public abstract void startPlayback(Activity activity, String s, long l);

    public abstract void startTrailer(Activity activity, String s);

    public abstract void verifyAndroidRuntime(Activity activity, Runnable runnable);

    public abstract void whisperCache(List list);
}
