// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.interfaces;

import android.webkit.JsResult;

public interface JavascriptBridgeListener
{

    public abstract void onDisplay();

    public abstract void onFinish(int i);

    public abstract void onOpenURLInBrowser(String s, boolean flag);

    public abstract void onPageError(int i, String s, String s1);

    public abstract void onPageLoaded(String s);

    public abstract void onPageStartingLoad(String s);

    public abstract void onPageTimeOut(String s, String s1);

    public abstract void onPlayMovie(String s);

    public abstract void onPrefetchURL(String s, long l);

    public abstract void onSetBackgroundColor(int i);

    public abstract void onShowDialog(String s, JsResult jsresult);

    public abstract void onShowSkip();

    public abstract void onTrack(String s);
}
