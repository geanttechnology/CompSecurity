// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.Schema;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

public interface FileReader
    extends Iterator, Iterable, Closeable
{

    public abstract Schema getSchema();

    public abstract Object next(Object obj)
        throws IOException;

    public abstract boolean pastSync(long l)
        throws IOException;

    public abstract void sync(long l)
        throws IOException;

    public abstract long tell()
        throws IOException;
}
