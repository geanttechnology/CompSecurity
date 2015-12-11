// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j;


public class MimeException extends Exception
{

    private static final long serialVersionUID = 0x73eb2eb2a61552feL;

    public MimeException(String s)
    {
        super(s);
    }

    public MimeException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public MimeException(Throwable throwable)
    {
        super(throwable);
    }
}
