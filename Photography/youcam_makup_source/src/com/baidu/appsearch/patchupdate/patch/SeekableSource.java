// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate.patch;

import java.io.Closeable;
import java.nio.ByteBuffer;

public interface SeekableSource
    extends Closeable
{

    public abstract int read(ByteBuffer bytebuffer);

    public abstract void seek(long l);
}
