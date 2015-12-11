// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;


public class ReadyAimFireInitCompletedEvent
{

    private static final String TAG = "~!RAFInitCompletedEvent";
    private static final long serialVersionUID = 1L;
    private Exception exception;
    private boolean readyAimFireReady;

    public ReadyAimFireInitCompletedEvent(boolean flag)
    {
        readyAimFireReady = flag;
    }

    public ReadyAimFireInitCompletedEvent(boolean flag, Exception exception1)
    {
        readyAimFireReady = flag;
        exception = exception1;
    }

    public Exception getException()
    {
        return exception;
    }

    public boolean isReadyAimFireReady()
    {
        return readyAimFireReady;
    }
}
