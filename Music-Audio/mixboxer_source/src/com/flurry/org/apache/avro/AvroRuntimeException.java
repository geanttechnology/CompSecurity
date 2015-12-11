// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;


public class AvroRuntimeException extends RuntimeException
{

    public AvroRuntimeException(String s)
    {
        super(s);
    }

    public AvroRuntimeException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public AvroRuntimeException(Throwable throwable)
    {
        super(throwable);
    }
}
