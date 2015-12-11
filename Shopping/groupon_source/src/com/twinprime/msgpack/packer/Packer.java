// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.packer;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.math.BigInteger;

public interface Packer
    extends Closeable, Flushable
{

    public abstract Packer write(double d)
        throws IOException;

    public abstract Packer write(long l)
        throws IOException;

    public abstract Packer write(Object obj)
        throws IOException;

    public abstract Packer write(String s)
        throws IOException;

    public abstract Packer write(BigInteger biginteger)
        throws IOException;

    public abstract Packer write(byte abyte0[])
        throws IOException;

    public abstract Packer writeArrayBegin(int i)
        throws IOException;

    public abstract Packer writeArrayEnd()
        throws IOException;

    public abstract Packer writeArrayEnd(boolean flag)
        throws IOException;

    public abstract Packer writeMapBegin(int i)
        throws IOException;

    public abstract Packer writeMapEnd()
        throws IOException;

    public abstract Packer writeMapEnd(boolean flag)
        throws IOException;

    public abstract Packer writeNil()
        throws IOException;
}
