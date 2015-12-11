// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import java.io.InterruptedIOException;

public class RequestAbortedException extends InterruptedIOException
{

    private static final long serialVersionUID = 0x4506aa3106436180L;

    public RequestAbortedException(String s)
    {
        super(s);
    }

    public RequestAbortedException(String s, Throwable throwable)
    {
        super(s);
        if (throwable != null)
        {
            initCause(throwable);
        }
    }
}
