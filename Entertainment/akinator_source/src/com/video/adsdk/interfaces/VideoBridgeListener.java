// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.interfaces;


public interface VideoBridgeListener
{

    public abstract void onSkipButtonClicked();

    public abstract void onVideoIsComplete();

    public abstract void onVideoIsReadyToPlay(VideoBridge.MovieState moviestate, int i);

    public abstract void onVideoPlaybackError(int i, int j);

    public abstract void onVideoReportsCurrentState(VideoBridge.MovieState moviestate, long l);
}
