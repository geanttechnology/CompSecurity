// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils
{

    private static final int BUFFER_SIZE = 8192;

    private IoUtils()
    {
    }

    public static void closeSilently(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    public static void copyStream(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[8192];
        do
        {
            int i = inputstream.read(abyte0, 0, 8192);
            if (i == -1)
            {
                return;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
    }
}
