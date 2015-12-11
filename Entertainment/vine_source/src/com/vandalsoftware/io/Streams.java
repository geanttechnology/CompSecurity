// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vandalsoftware.io;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.vandalsoftware.io:
//            IoUtils

public final class Streams
{

    private static AtomicReference skipBuffer = new AtomicReference();

    private Streams()
    {
    }

    private static void checkOffsetAndCount(int i, int j, int k)
        throws EOFException
    {
        if (j + k > i)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public static int copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        int i = 0;
        byte abyte0[] = new byte[8192];
        do
        {
            int j = inputstream.read(abyte0);
            if (j != -1)
            {
                i += j;
                outputstream.write(abyte0, 0, j);
            } else
            {
                return i;
            }
        } while (true);
    }

    public static String readAsciiLine(InputStream inputstream)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder(80);
        do
        {
            int i = inputstream.read();
            if (i == -1)
            {
                throw new EOFException();
            }
            if (i == 10)
            {
                i = stringbuilder.length();
                if (i > 0 && stringbuilder.charAt(i - 1) == '\r')
                {
                    stringbuilder.setLength(i - 1);
                }
                return stringbuilder.toString();
            }
            stringbuilder.append((char)i);
        } while (true);
    }

    public static String readFully(Reader reader)
        throws IOException
    {
        Object obj;
        char ac[];
        obj = new StringWriter();
        ac = new char[1024];
_L1:
        int i = reader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        ((StringWriter) (obj)).write(ac, 0, i);
          goto _L1
        obj;
        reader.close();
        throw obj;
        obj = ((StringWriter) (obj)).toString();
        reader.close();
        return ((String) (obj));
    }

    public static void readFully(InputStream inputstream, byte abyte0[])
        throws IOException
    {
        readFully(inputstream, abyte0, 0, abyte0.length);
    }

    public static void readFully(InputStream inputstream, byte abyte0[], int i, int j)
        throws IOException
    {
        if (j != 0)
        {
            if (inputstream == null)
            {
                throw new NullPointerException("in == null");
            }
            if (abyte0 == null)
            {
                throw new NullPointerException("dst == null");
            }
            checkOffsetAndCount(abyte0.length, i, j);
            while (j > 0) 
            {
                int k = inputstream.read(abyte0, i, j);
                if (k < 0)
                {
                    throw new EOFException();
                }
                i += k;
                j -= k;
            }
        }
    }

    public static byte[] readFully(InputStream inputstream)
        throws IOException
    {
        byte abyte0[] = readFullyNoClose(inputstream);
        inputstream.close();
        return abyte0;
        Exception exception;
        exception;
        inputstream.close();
        throw exception;
    }

    public static byte[] readFullyNoClose(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    public static int readSingleByte(InputStream inputstream)
        throws IOException
    {
        int i = -1;
        byte abyte0[] = new byte[1];
        if (inputstream.read(abyte0, 0, 1) != -1)
        {
            i = abyte0[0] & 0xff;
        }
        return i;
    }

    public static String readStringFrom(InputStream inputstream)
        throws IOException
    {
        return readFully(new InputStreamReader(inputstream, "UTF-8"));
    }

    public static int skipAll(InputStream inputstream)
        throws IOException
    {
        int i = 0;
        int j;
        do
        {
            j = (int)((long)i + inputstream.skip(0x7fffffffffffffffL));
            i = j;
        } while (inputstream.read() != -1);
        return j;
    }

    public static long skipByReading(InputStream inputstream, long l)
        throws IOException
    {
        byte abyte0[];
        long l1;
        byte abyte1[] = (byte[])skipBuffer.getAndSet(null);
        abyte0 = abyte1;
        if (abyte1 == null)
        {
            abyte0 = new byte[4096];
        }
        l1 = 0L;
_L5:
        long l2 = l1;
        if (l1 >= l) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = (int)Math.min(l - l1, abyte0.length);
        j = inputstream.read(abyte0, 0, i);
        if (j != -1) goto _L4; else goto _L3
_L3:
        l2 = l1;
_L2:
        skipBuffer.set(abyte0);
        return l2;
_L4:
        l2 = l1 + (long)j;
        l1 = l2;
        if (j >= i) goto _L5; else goto _L2
    }

    public static void writeSingleByte(OutputStream outputstream, int i)
        throws IOException
    {
        outputstream.write(new byte[] {
            (byte)(i & 0xff)
        });
    }

    public static void writeStringTo(OutputStream outputstream, String s)
        throws IOException
    {
        Object obj = null;
        outputstream = new OutputStreamWriter(outputstream, "UTF-8");
        outputstream.write(s);
        IoUtils.closeQuietly(outputstream);
        return;
        s;
        outputstream = obj;
_L2:
        IoUtils.closeQuietly(outputstream);
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
