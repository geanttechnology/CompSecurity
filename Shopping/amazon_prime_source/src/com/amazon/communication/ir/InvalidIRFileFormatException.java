// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;


public class InvalidIRFileFormatException extends Exception
{

    public InvalidIRFileFormatException(String s)
    {
        super(s);
    }

    public InvalidIRFileFormatException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public InvalidIRFileFormatException(Throwable throwable)
    {
        super(throwable);
    }
}
