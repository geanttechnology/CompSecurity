// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            AdProperties, AdLayout, AdSize, AdListener

interface IAdController
{

    public abstract void adClosedExpansion();

    public abstract void adExpanded();

    public abstract void adLoaded(AdProperties adproperties);

    public abstract void destroy();

    public abstract AdLayout getAdLayout();

    public abstract AdSize getAdSize();

    public abstract String getMaxSize();

    public abstract AdWebViewClient.UrlExecutor getSpecialUrlExecutor();

    public abstract int getTimeout();

    public abstract int getWindowHeight();

    public abstract int getWindowWidth();

    public abstract boolean isAdExpanded();

    public abstract boolean isAdLoading();

    public abstract void prepareAd(long l);

    public abstract void prepareToGoAway();

    public abstract boolean sendCommand(String s, HashMap hashmap);

    public abstract void setListener(AdListener adlistener);

    public abstract void setTimeout(int i);

    public abstract void setWindowDimensions(int i, int j);

    public abstract boolean shouldDisableWebViewHardwareAcceleration();
}
