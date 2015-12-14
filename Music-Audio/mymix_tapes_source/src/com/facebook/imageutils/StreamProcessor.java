// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

class StreamProcessor
{

    StreamProcessor()
    {
    }

    public static int readPackedInt(InputStream inputstream, int i, boolean flag)
        throws IOException
    {
        int j = 0;
        int k = 0;
        while (k < i) 
        {
            int l = inputstream.read();
            if (l == -1)
            {
                throw new IOException("no more bytes");
            }
            if (flag)
            {
                j |= (l & 0xff) << k * 8;
            } else
            {
                j = j << 8 | l & 0xff;
            }
            k++;
        }
        return j;
    }
}
