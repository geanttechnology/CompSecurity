// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.io;

import com.pf.common.utility.m;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public final class IO extends Enum
{

    private static final IO a[] = new IO[0];

    public static int a(ReadableByteChannel readablebytechannel, ByteBuffer bytebuffer)
    {
        int i = bytebuffer.position();
        while (bytebuffer.remaining() > 0 && readablebytechannel.read(bytebuffer) > 0) ;
        if (bytebuffer.remaining() > 0)
        {
            throw new EOFException("Could not read all bytes.");
        } else
        {
            return bytebuffer.position() - i;
        }
    }

    public static int a(WritableByteChannel writablebytechannel, ByteBuffer bytebuffer)
    {
        int i = bytebuffer.position();
        while (bytebuffer.remaining() > 0 && writablebytechannel.write(bytebuffer) > 0) ;
        if (bytebuffer.remaining() > 0)
        {
            throw new IOException("Could not write all bytes.");
        } else
        {
            return bytebuffer.position() - i;
        }
    }

    public static ReadableByteChannel a(InputStream inputstream)
    {
        if (inputstream instanceof FileInputStream)
        {
            return ((FileInputStream)inputstream).getChannel();
        } else
        {
            return Channels.newChannel(inputstream);
        }
    }

    public static WritableByteChannel a(OutputStream outputstream)
    {
        if (outputstream instanceof FileOutputStream)
        {
            return ((FileOutputStream)outputstream).getChannel();
        } else
        {
            return Channels.newChannel(outputstream);
        }
    }

    public static boolean a(Closeable closeable)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
            }
            // Misplaced declaration of an exception variable
            catch (Closeable closeable)
            {
                m.b("IO", "closeNoThrow", closeable);
                return false;
            }
        }
        return true;
    }

    public static IO valueOf(String s)
    {
        return (IO)Enum.valueOf(com/pf/common/io/IO, s);
    }

    public static IO[] values()
    {
        return (IO[])a.clone();
    }

}
