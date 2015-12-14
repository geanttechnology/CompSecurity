// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

public class Base64OutputStream extends FilterOutputStream
{

    static final boolean $assertionsDisabled;
    private static final Set BASE64_CHARS;
    static final byte BASE64_TABLE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte CRLF_SEPARATOR[] = {
        13, 10
    };
    private boolean closed;
    private int data;
    private final byte encoded[];
    private final int lineLength;
    private int linePosition;
    private final byte lineSeparator[];
    private int modulus;
    private int position;
    private final byte singleByte[];

    public Base64OutputStream(OutputStream outputstream)
    {
        this(outputstream, 76, CRLF_SEPARATOR);
    }

    public Base64OutputStream(OutputStream outputstream, int i, byte abyte0[])
    {
        super(outputstream);
        singleByte = new byte[1];
        closed = false;
        position = 0;
        data = 0;
        modulus = 0;
        linePosition = 0;
        if (outputstream == null)
        {
            throw new IllegalArgumentException();
        }
        if (i < 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            checkLineSeparator(abyte0);
            lineLength = i;
            lineSeparator = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, lineSeparator, 0, abyte0.length);
            encoded = new byte[2048];
            return;
        }
    }

    private void checkLineSeparator(byte abyte0[])
    {
        if (abyte0.length > 2048)
        {
            throw new IllegalArgumentException("line separator length exceeds 2048");
        }
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            if (BASE64_CHARS.contains(Byte.valueOf(byte0)))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("line separator must not contain base64 character '").append((char)(byte0 & 0xff)).append("'").toString());
            }
        }

    }

    private void close0()
        throws IOException
    {
        if (modulus != 0)
        {
            writePad();
        }
        if (lineLength > 0 && linePosition > 0)
        {
            writeLineSeparator();
        }
        flush0();
    }

    private void flush0()
        throws IOException
    {
        if (position > 0)
        {
            out.write(encoded, 0, position);
            position = 0;
        }
    }

    private void write0(byte abyte0[], int i, int j)
        throws IOException
    {
        for (; i < j; i++)
        {
            data = data << 8 | abyte0[i] & 0xff;
            int k = modulus + 1;
            modulus = k;
            if (k != 3)
            {
                continue;
            }
            modulus = 0;
            if (lineLength > 0 && linePosition >= lineLength)
            {
                linePosition = 0;
                if (encoded.length - position < lineSeparator.length)
                {
                    flush0();
                }
                byte abyte1[] = lineSeparator;
                int l = abyte1.length;
                for (k = 0; k < l; k++)
                {
                    byte byte0 = abyte1[k];
                    byte abyte3[] = encoded;
                    int i1 = position;
                    position = i1 + 1;
                    abyte3[i1] = byte0;
                }

            }
            if (encoded.length - position < 4)
            {
                flush0();
            }
            byte abyte2[] = encoded;
            k = position;
            position = k + 1;
            abyte2[k] = BASE64_TABLE[data >> 18 & 0x3f];
            abyte2 = encoded;
            k = position;
            position = k + 1;
            abyte2[k] = BASE64_TABLE[data >> 12 & 0x3f];
            abyte2 = encoded;
            k = position;
            position = k + 1;
            abyte2[k] = BASE64_TABLE[data >> 6 & 0x3f];
            abyte2 = encoded;
            k = position;
            position = k + 1;
            abyte2[k] = BASE64_TABLE[data & 0x3f];
            linePosition = linePosition + 4;
        }

    }

    private void writeLineSeparator()
        throws IOException
    {
        linePosition = 0;
        if (encoded.length - position < lineSeparator.length)
        {
            flush0();
        }
        byte abyte0[] = lineSeparator;
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            byte abyte1[] = encoded;
            int k = position;
            position = k + 1;
            abyte1[k] = byte0;
        }

    }

    private void writePad()
        throws IOException
    {
        if (lineLength > 0 && linePosition >= lineLength)
        {
            writeLineSeparator();
        }
        if (encoded.length - position < 4)
        {
            flush0();
        }
        if (modulus == 1)
        {
            byte abyte0[] = encoded;
            int i = position;
            position = i + 1;
            abyte0[i] = BASE64_TABLE[data >> 2 & 0x3f];
            abyte0 = encoded;
            i = position;
            position = i + 1;
            abyte0[i] = BASE64_TABLE[data << 4 & 0x3f];
            abyte0 = encoded;
            i = position;
            position = i + 1;
            abyte0[i] = 61;
            abyte0 = encoded;
            i = position;
            position = i + 1;
            abyte0[i] = 61;
        } else
        {
            if (!$assertionsDisabled && modulus != 2)
            {
                throw new AssertionError();
            }
            byte abyte1[] = encoded;
            int j = position;
            position = j + 1;
            abyte1[j] = BASE64_TABLE[data >> 10 & 0x3f];
            abyte1 = encoded;
            j = position;
            position = j + 1;
            abyte1[j] = BASE64_TABLE[data >> 4 & 0x3f];
            abyte1 = encoded;
            j = position;
            position = j + 1;
            abyte1[j] = BASE64_TABLE[data << 2 & 0x3f];
            abyte1 = encoded;
            j = position;
            position = j + 1;
            abyte1[j] = 61;
        }
        linePosition = linePosition + 4;
    }

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        } else
        {
            closed = true;
            close0();
            return;
        }
    }

    public void flush()
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Base64OutputStream has been closed");
        } else
        {
            flush0();
            return;
        }
    }

    public final void write(int i)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Base64OutputStream has been closed");
        } else
        {
            singleByte[0] = (byte)i;
            write0(singleByte, 0, 1);
            return;
        }
    }

    public final void write(byte abyte0[])
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Base64OutputStream has been closed");
        }
        if (abyte0 == null)
        {
            throw new NullPointerException();
        }
        if (abyte0.length == 0)
        {
            return;
        } else
        {
            write0(abyte0, 0, abyte0.length);
            return;
        }
    }

    public final void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Base64OutputStream has been closed");
        }
        if (abyte0 == null)
        {
            throw new NullPointerException();
        }
        if (i < 0 || j < 0 || i + j > abyte0.length)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j == 0)
        {
            return;
        } else
        {
            write0(abyte0, i, i + j);
            return;
        }
    }

    static 
    {
        byte abyte0[];
        int j;
        boolean flag;
        if (!org/apache/james/mime4j/codec/Base64OutputStream.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        BASE64_CHARS = new HashSet();
        abyte0 = BASE64_TABLE;
        j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            BASE64_CHARS.add(Byte.valueOf(byte0));
        }

        BASE64_CHARS.add(Byte.valueOf((byte)61));
    }
}
