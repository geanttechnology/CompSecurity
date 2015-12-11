// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.IOException;
import java.nio.ByteBuffer;

abstract class Codec
{

    Codec()
    {
    }

    abstract ByteBuffer compress(ByteBuffer bytebuffer)
        throws IOException;

    abstract ByteBuffer decompress(ByteBuffer bytebuffer)
        throws IOException;

    public abstract boolean equals(Object obj);

    abstract String getName();

    public abstract int hashCode();

    public String toString()
    {
        return getName();
    }
}
