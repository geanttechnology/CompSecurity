// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;

public interface ServiceUnavailableRetryStrategy
{

    public abstract long getRetryInterval();

    public abstract boolean retryRequest(HttpResponse httpresponse, int i, HttpContext httpcontext);
}
