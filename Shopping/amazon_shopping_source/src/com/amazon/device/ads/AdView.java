// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


interface AdView
{

    public abstract int getHeight();

    public abstract AdWebViewClient.UrlExecutor getSpecialUrlExecutor();

    public abstract boolean isAdViewRenderable();

    public abstract boolean launchExternalBrowserForLink(String s);

    public abstract void onPageFinished();

    public abstract boolean shouldDisableWebViewHardwareAcceleration();
}
