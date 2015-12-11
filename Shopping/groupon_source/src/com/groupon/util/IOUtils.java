// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.io.Closeable;
import java.io.IOException;
import roboguice.util.Ln;

public class IOUtils
{

    private IOUtils()
    {
    }

    public static void close(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        Ln.e(closeable);
        return;
    }
}
