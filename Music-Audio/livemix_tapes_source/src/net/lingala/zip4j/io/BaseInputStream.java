// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.unzip.UnzipEngine;

public abstract class BaseInputStream extends InputStream
{

    public BaseInputStream()
    {
    }

    public int available()
        throws IOException
    {
        return 0;
    }

    public UnzipEngine getUnzipEngine()
    {
        return null;
    }

    public int read()
        throws IOException
    {
        return 0;
    }

    public void seek(long l)
        throws IOException
    {
    }
}
