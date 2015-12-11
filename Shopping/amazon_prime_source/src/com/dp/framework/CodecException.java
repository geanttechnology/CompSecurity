// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.framework;


public class CodecException extends Exception
{

    public CodecException(Exception exception)
    {
        super(exception);
    }

    public CodecException(String s)
    {
        super(s);
    }
}
