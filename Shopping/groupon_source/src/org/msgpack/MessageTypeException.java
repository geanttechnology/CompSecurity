// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;


public class MessageTypeException extends RuntimeException
{

    public MessageTypeException()
    {
    }

    public MessageTypeException(String s)
    {
        super(s);
    }

    public MessageTypeException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public MessageTypeException(Throwable throwable)
    {
        super(throwable);
    }
}
