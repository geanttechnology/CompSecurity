// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;

public class NullBackoffStrategy
    implements ConnectionBackoffStrategy
{

    public NullBackoffStrategy()
    {
    }

    public boolean shouldBackoff(HttpResponse httpresponse)
    {
        return false;
    }

    public boolean shouldBackoff(Throwable throwable)
    {
        return false;
    }
}
