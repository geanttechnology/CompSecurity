// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.analytics;

import android.content.Context;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;

public interface PlayerAnalytics
{

    public abstract void adProgress(int i, AbstractXuaAsset abstractxuaasset);

    public abstract void bitrateChanged(long l, AbstractXuaAsset abstractxuaasset);

    public abstract void fragmentWarning(int i, int j, int k, String s, AbstractXuaAsset abstractxuaasset);

    public abstract void heartBeat(Long long1, Long long2, Integer integer, String s, String s1, Long long3, AbstractXuaAsset abstractxuaasset, 
            FragmentInfo fragmentinfo);

    public abstract void mediaEnded(AbstractXuaAsset abstractxuaasset);

    public abstract void mediaFailed(String s, long l, String s1, String s2, AbstractXuaAsset abstractxuaasset);

    public abstract void mediaInfo(int i, String s, AbstractXuaAsset abstractxuaasset);

    public abstract void mediaOpened(String s, long l, Long long1, AbstractXuaAsset abstractxuaasset);

    public abstract void openingMedia(String s, AbstractXuaAsset abstractxuaasset);

    public abstract void playStateChanged(PlayerStatus playerstatus, AbstractXuaAsset abstractxuaasset);

    public abstract void playStateChanged(String s, AbstractXuaAsset abstractxuaasset);

    public abstract void pluginInitialized(Context context);

    public abstract void retryAttempt(String s, String s1, String s2, int i, AbstractXuaAsset abstractxuaasset);

    public abstract void scrubEnded(int i, AbstractXuaAsset abstractxuaasset);

    public abstract void scrubStarted(int i, AbstractXuaAsset abstractxuaasset);

    public abstract void trickPlay(int i, String s, AbstractXuaAsset abstractxuaasset);
}
