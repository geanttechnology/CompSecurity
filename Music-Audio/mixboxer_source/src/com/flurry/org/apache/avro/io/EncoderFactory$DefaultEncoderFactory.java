// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroRuntimeException;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            EncoderFactory

private static class <init> extends EncoderFactory
{

    public EncoderFactory configureBlockSize(int i)
    {
        throw new AvroRuntimeException("Default EncoderFactory cannot be configured");
    }

    public EncoderFactory configureBufferSize(int i)
    {
        throw new AvroRuntimeException("Default EncoderFactory cannot be configured");
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
