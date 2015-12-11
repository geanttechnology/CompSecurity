// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.interfaces;

import android.webkit.WebView;

// Referenced classes of package com.video.adsdk.interfaces:
//            JavascriptBridgeListener

public interface JavascriptBridge
{

    public abstract void addListener(JavascriptBridgeListener javascriptbridgelistener);

    public abstract void cancel();

    public abstract void clearView();

    public abstract void finalReturn(int i);

    public abstract WebView getWebView();

    public abstract void loadUrl(String s);

    public abstract void movieClick();

    public abstract void movieDidFinish(long l);

    public abstract void moviePulse(VideoBridge.MovieState moviestate, long l);

    public abstract void movieStateDidChange(VideoBridge.MovieState moviestate, long l);

    public abstract void prefetchingComplete();

    public abstract void removeListener(JavascriptBridgeListener javascriptbridgelistener);

    public abstract void setParam(String s, String s1);

    public abstract void troubleshoot(String s, int i);
}
