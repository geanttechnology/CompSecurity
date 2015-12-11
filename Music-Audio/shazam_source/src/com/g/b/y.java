// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import c.e;
import java.io.Closeable;
import java.io.InputStream;

public abstract class y
    implements Closeable
{

    public y()
    {
    }

    public abstract long a();

    public abstract e b();

    public final InputStream c()
    {
        return b().f();
    }

    public void close()
    {
        b().close();
    }
}
