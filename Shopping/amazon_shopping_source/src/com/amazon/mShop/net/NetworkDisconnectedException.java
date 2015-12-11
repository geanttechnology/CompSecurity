// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.io.IOException;

public class NetworkDisconnectedException extends IOException
{

    public NetworkDisconnectedException()
    {
        this("Device is not connected to network");
    }

    public NetworkDisconnectedException(String s)
    {
        super(s);
    }
}
