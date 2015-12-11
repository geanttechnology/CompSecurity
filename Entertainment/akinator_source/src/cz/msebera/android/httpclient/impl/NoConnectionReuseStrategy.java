// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class NoConnectionReuseStrategy
    implements ConnectionReuseStrategy
{

    public static final NoConnectionReuseStrategy INSTANCE = new NoConnectionReuseStrategy();

    public NoConnectionReuseStrategy()
    {
    }

    public boolean keepAlive(HttpResponse httpresponse, HttpContext httpcontext)
    {
        return false;
    }

}
