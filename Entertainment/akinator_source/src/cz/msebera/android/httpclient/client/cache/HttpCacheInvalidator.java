// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.cache;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;

public interface HttpCacheInvalidator
{

    public abstract void flushInvalidatedCacheEntries(HttpHost httphost, HttpRequest httprequest);

    public abstract void flushInvalidatedCacheEntries(HttpHost httphost, HttpRequest httprequest, HttpResponse httpresponse);
}
