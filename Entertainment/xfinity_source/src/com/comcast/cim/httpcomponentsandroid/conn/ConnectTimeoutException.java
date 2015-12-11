// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn;

import java.io.InterruptedIOException;

public class ConnectTimeoutException extends InterruptedIOException
{

    public ConnectTimeoutException()
    {
    }

    public ConnectTimeoutException(String s)
    {
        super(s);
    }
}
