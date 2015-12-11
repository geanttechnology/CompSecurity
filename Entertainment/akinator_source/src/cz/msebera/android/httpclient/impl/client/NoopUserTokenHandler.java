// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class NoopUserTokenHandler
    implements UserTokenHandler
{

    public static final NoopUserTokenHandler INSTANCE = new NoopUserTokenHandler();

    public NoopUserTokenHandler()
    {
    }

    public Object getUserToken(HttpContext httpcontext)
    {
        return null;
    }

}
