// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.WebResponseHeaders;

public interface IAmazonWebServiceCallback
{

    public abstract void onBodyChunkReceived(byte abyte0[], int i);

    public abstract void onHeadersReceived(WebResponseHeaders webresponseheaders);

    public abstract void onNetworkError();

    public abstract void onRequestComplete();
}
