// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            PooledByteBuffer, PooledByteBufferOutputStream

public interface PooledByteBufferFactory
{

    public abstract PooledByteBuffer newByteBuffer(int i);

    public abstract PooledByteBuffer newByteBuffer(InputStream inputstream)
        throws IOException;

    public abstract PooledByteBuffer newByteBuffer(InputStream inputstream, int i)
        throws IOException;

    public abstract PooledByteBuffer newByteBuffer(byte abyte0[]);

    public abstract PooledByteBufferOutputStream newOutputStream();

    public abstract PooledByteBufferOutputStream newOutputStream(int i);
}
