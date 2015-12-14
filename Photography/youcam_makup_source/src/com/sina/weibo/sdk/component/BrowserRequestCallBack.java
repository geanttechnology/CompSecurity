// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

interface BrowserRequestCallBack
{

    public abstract void onPageFinishedCallBack(WebView webview, String s);

    public abstract void onPageStartedCallBack(WebView webview, String s, Bitmap bitmap);

    public abstract void onReceivedErrorCallBack(WebView webview, int i, String s, String s1);

    public abstract void onReceivedSslErrorCallBack(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror);

    public abstract boolean shouldOverrideUrlLoadingCallBack(WebView webview, String s);
}
