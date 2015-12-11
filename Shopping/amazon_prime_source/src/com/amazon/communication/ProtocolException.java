// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.CommunicationBaseException;

public class ProtocolException extends CommunicationBaseException
{

    public ProtocolException(Exception exception)
    {
        super(exception);
    }

    public ProtocolException(String s)
    {
        super(s);
    }

    public ProtocolException(String s, Exception exception)
    {
        super(s, exception);
    }
}
