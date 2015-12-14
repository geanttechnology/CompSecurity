// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;


public class SmackException extends Exception
{

    private static final long serialVersionUID = 0x1999998fd20aa3b9L;

    protected SmackException()
    {
    }

    public SmackException(String s)
    {
        super(s);
    }

    public SmackException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public SmackException(Throwable throwable)
    {
        super(throwable);
    }
}
