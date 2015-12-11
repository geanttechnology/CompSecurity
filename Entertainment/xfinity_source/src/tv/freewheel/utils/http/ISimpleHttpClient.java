// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils.http;

import org.apache.http.client.HttpClient;

public interface ISimpleHttpClient
    extends HttpClient
{

    public abstract void close();

    public abstract void removeRequestInterceptorByClass(Class class1);
}
