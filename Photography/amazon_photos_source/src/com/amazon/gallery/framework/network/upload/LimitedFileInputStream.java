// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LimitedFileInputStream extends FileInputStream
{

    private final long limit;
    private long offset;

    public LimitedFileInputStream(File file, long l, long l1)
        throws IOException
    {
        super(file);
        super.skip(l);
        offset = l;
        limit = l + l1;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = j;
        if (offset >= limit)
        {
            return -1;
        }
        int l = k;
        if (offset + (long)j > limit)
        {
            l = (int)((long)k - ((offset + (long)j) - limit));
        }
        i = super.read(abyte0, i, l);
        offset = offset + (long)i;
        return i;
    }
}
