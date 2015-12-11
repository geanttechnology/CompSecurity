// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.type.Value;
import java.io.Closeable;
import java.io.IOException;

public interface Unpacker
    extends Closeable, Iterable
{

    public abstract Value readValue()
        throws IOException;
}
