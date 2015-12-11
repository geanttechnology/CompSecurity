// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.Closeable;
import java.io.IOException;

public interface SeekableInput
    extends Closeable
{

    public abstract long length()
        throws IOException;

    public abstract int read(byte abyte0[], int i, int j)
        throws IOException;

    public abstract void seek(long l)
        throws IOException;

    public abstract long tell()
        throws IOException;
}
