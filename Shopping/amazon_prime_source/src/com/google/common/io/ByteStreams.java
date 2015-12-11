// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ByteStreams
{

    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {

        public String toString()
        {
            return "ByteStreams.nullOutputStream()";
        }

        public void write(int i)
        {
        }

        public void write(byte abyte0[])
        {
            Preconditions.checkNotNull(abyte0);
        }

        public void write(byte abyte0[], int i, int j)
        {
            Preconditions.checkNotNull(abyte0);
        }

    };

    private ByteStreams()
    {
    }

    public static long copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        Preconditions.checkNotNull(inputstream);
        Preconditions.checkNotNull(outputstream);
        byte abyte0[] = new byte[4096];
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                return l;
            }
            outputstream.write(abyte0, 0, i);
            l += i;
        } while (true);
    }

    public static byte[] toByteArray(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        copy(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

}
