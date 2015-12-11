// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.listener;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;

public interface MraidViewListener
{

    public abstract boolean onClose();

    public abstract boolean onConsoleMessage(ConsoleMessage consolemessage);

    public abstract boolean onEventFired();

    public abstract boolean onExpand();

    public abstract boolean onExpandClose();

    public abstract void onPageFinished(WebView webview, String s);

    public abstract void onPageStarted(WebView webview, String s, Bitmap bitmap);

    public abstract boolean onReady();

    public abstract void onReceivedError(WebView webview, int i, String s, String s1);

    public abstract boolean onResize();

    public abstract boolean onResizeClose();

    public abstract boolean shouldOverrideUrlLoading(WebView webview, String s);
}
