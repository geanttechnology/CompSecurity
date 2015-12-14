// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.InterruptedIOException;
import org.apache.commons.httpclient.util.ExceptionUtil;

public class ConnectTimeoutException extends InterruptedIOException
{

    public ConnectTimeoutException()
    {
    }

    public ConnectTimeoutException(String s)
    {
        super(s);
    }

    public ConnectTimeoutException(String s, Throwable throwable)
    {
        super(s);
        ExceptionUtil.initCause(this, throwable);
    }
}
