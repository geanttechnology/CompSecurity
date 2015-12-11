// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.util.ByteArrayBuffer;

// Referenced classes of package org.apache.james.mime4j.codec:
//            Base64OutputStream, DecodeMonitor

public class Base64InputStream extends InputStream
{

    static final boolean $assertionsDisabled;
    private static final int BASE64_DECODE[];
    private static final byte BASE64_PAD = 61;
    private static final int ENCODED_BUFFER_SIZE = 1536;
    private static final int EOF = -1;
    private boolean closed;
    private final ByteArrayBuffer decodedBuf;
    private final byte encoded[];
    private boolean eof;
    private final InputStream in;
    private final DecodeMonitor monitor;
    private int position;
    private final byte singleByte[];
    private int size;

    protected Base64InputStream(int i, InputStream inputstream, DecodeMonitor decodemonitor)
    {
        singleByte = new byte[1];
        position = 0;
        size = 0;
        closed = false;
        if (inputstream == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            encoded = new byte[i];
            decodedBuf = new ByteArrayBuffer(512);
            in = inputstream;
            monitor = decodemonitor;
            return;
        }
    }

    public Base64InputStream(InputStream inputstream)
    {
        this(inputstream, false);
    }

    public Base64InputStream(InputStream inputstream, DecodeMonitor decodemonitor)
    {
        this(1536, inputstream, decodemonitor);
    }

    public Base64InputStream(InputStream inputstream, boolean flag)
    {
        DecodeMonitor decodemonitor;
        if (flag)
        {
            decodemonitor = DecodeMonitor.STRICT;
        } else
        {
            decodemonitor = DecodeMonitor.SILENT;
        }
        this(1536, inputstream, decodemonitor);
    }

    private int decodePad(int i, int j, byte abyte0[], int k, int l)
        throws IOException
    {
        eof = true;
        if (j == 2)
        {
            byte byte0 = (byte)(i >>> 4);
            if (k < l)
            {
                abyte0[k] = byte0;
                return k + 1;
            } else
            {
                decodedBuf.append(byte0);
                return k;
            }
        }
        if (j == 3)
        {
            byte byte1 = (byte)(i >>> 10);
            byte byte2 = (byte)(i >>> 2 & 0xff);
            if (k < l - 1)
            {
                i = k + 1;
                abyte0[k] = byte1;
                abyte0[i] = byte2;
                return i + 1;
            }
            if (k < l)
            {
                abyte0[k] = byte1;
                decodedBuf.append(byte2);
                return k + 1;
            } else
            {
                decodedBuf.append(byte1);
                decodedBuf.append(byte2);
                return k;
            }
        } else
        {
            handleUnexpecedPad(j);
            return k;
        }
    }

    private void handleUnexpecedPad(int i)
        throws IOException
    {
        if (monitor.warn("Unexpected padding character", (new StringBuilder()).append("dropping ").append(i).append(" sextet(s)").toString()))
        {
            throw new IOException("Unexpected padding character");
        } else
        {
            return;
        }
    }

    private void handleUnexpectedEof(int i)
        throws IOException
    {
        if (monitor.warn("Unexpected end of BASE64 stream", (new StringBuilder()).append("dropping ").append(i).append(" sextet(s)").toString()))
        {
            throw new IOException("Unexpected end of BASE64 stream");
        } else
        {
            return;
        }
    }

    private int read0(byte abyte0[], int i, int j)
        throws IOException
    {
        int l1;
        int i2;
        int j2;
        int k2;
        k2 = i + j;
        int j1 = i;
        int k = j1;
        if (decodedBuf.length() > 0)
        {
            j = Math.min(decodedBuf.length(), j);
            System.arraycopy(decodedBuf.buffer(), 0, abyte0, j1, j);
            decodedBuf.remove(0, j);
            k = j1 + j;
        }
        if (eof)
        {
            if (k == i)
            {
                return -1;
            } else
            {
                return k - i;
            }
        }
        j2 = 0;
        i2 = 0;
        l1 = k;
_L6:
        if (l1 >= k2)
        {
            break MISSING_BLOCK_LABEL_604;
        }
_L3:
        int l;
        int k1;
        k1 = j2;
        l = i2;
        j = l1;
        if (position != size) goto _L2; else goto _L1
_L1:
        j = in.read(encoded, 0, encoded.length);
        if (j == -1)
        {
            eof = true;
            if (i2 != 0)
            {
                handleUnexpectedEof(i2);
            }
            if (l1 == i)
            {
                return -1;
            } else
            {
                return l1 - i;
            }
        }
        if (j <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        position = 0;
        size = j;
          goto _L3
        if ($assertionsDisabled || j == 0) goto _L3; else goto _L4
_L4:
        throw new AssertionError();
_L9:
        byte byte0;
        byte byte1;
        byte byte2;
        l1 = k1 << 6 | i2;
        i2 = l + 1;
        k1 = l1;
        l = i2;
        if (i2 == 4)
        {
            l = 0;
            byte0 = (byte)(l1 >>> 16);
            byte1 = (byte)(l1 >>> 8);
            byte2 = (byte)l1;
            if (j >= k2 - 2)
            {
                break MISSING_BLOCK_LABEL_475;
            }
            k1 = j + 1;
            abyte0[j] = byte0;
            j = k1 + 1;
            abyte0[k1] = byte1;
            abyte0[j] = byte2;
            j++;
            k1 = l1;
        }
_L2:
        j2 = k1;
        i2 = l;
        l1 = j;
        if (position >= size) goto _L6; else goto _L5
_L5:
        j2 = k1;
        i2 = l;
        l1 = j;
        if (j >= k2) goto _L6; else goto _L7
_L7:
        byte abyte1[] = encoded;
        l1 = position;
        position = l1 + 1;
        l1 = abyte1[l1] & 0xff;
        if (l1 == 61)
        {
            return decodePad(k1, l, abyte0, j, k2) - i;
        }
        i2 = BASE64_DECODE[l1];
        if (i2 >= 0) goto _L9; else goto _L8
_L8:
        if (l1 == 13 || l1 == 10 || l1 == 32 || !monitor.warn((new StringBuilder()).append("Unexpected base64 byte: ").append((byte)l1).toString(), "ignoring.")) goto _L2; else goto _L10
_L10:
        throw new IOException("Unexpected base64 byte");
        if (j < k2 - 1)
        {
            int i1 = j + 1;
            abyte0[j] = byte0;
            j = i1 + 1;
            abyte0[i1] = byte1;
            decodedBuf.append(byte2);
        } else
        if (j < k2)
        {
            abyte0[j] = byte0;
            decodedBuf.append(byte1);
            decodedBuf.append(byte2);
            j++;
        } else
        {
            decodedBuf.append(byte0);
            decodedBuf.append(byte1);
            decodedBuf.append(byte2);
        }
        if (!$assertionsDisabled && j != k2)
        {
            throw new AssertionError();
        } else
        {
            return k2 - i;
        }
        if (!$assertionsDisabled && i2 != 0)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && l1 != k2)
        {
            throw new AssertionError();
        } else
        {
            return k2 - i;
        }
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
            return;
        }
    }

    public int read()
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Stream has been closed");
        }
        int i;
        do
        {
            i = read0(singleByte, 0, 1);
            if (i == -1)
            {
                return -1;
            }
        } while (i != 1);
        return singleByte[0] & 0xff;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Stream has been closed");
        }
        if (abyte0 == null)
        {
            throw new NullPointerException();
        }
        if (abyte0.length == 0)
        {
            return 0;
        } else
        {
            return read0(abyte0, 0, abyte0.length);
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Stream has been closed");
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
            return 0;
        } else
        {
            return read0(abyte0, i, j);
        }
    }

    static 
    {
        boolean flag;
        if (!org/apache/james/mime4j/codec/Base64InputStream.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        BASE64_DECODE = new int[256];
        for (int i = 0; i < 256; i++)
        {
            BASE64_DECODE[i] = -1;
        }

        for (int j = 0; j < Base64OutputStream.BASE64_TABLE.length; j++)
        {
            BASE64_DECODE[Base64OutputStream.BASE64_TABLE[j] & 0xff] = j;
        }

    }
}
