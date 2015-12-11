// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.util.ByteArrayBuffer;

// Referenced classes of package org.apache.james.mime4j.codec:
//            DecodeMonitor

public class QuotedPrintableInputStream extends InputStream
{

    private static final byte CR = 13;
    private static final int DEFAULT_BUFFER_SIZE = 2048;
    private static final byte EQ = 61;
    private static final byte LF = 10;
    private final ByteArrayBuffer blanks;
    private boolean closed;
    private final ByteArrayBuffer decodedBuf;
    private final byte encoded[];
    private final InputStream in;
    private int limit;
    private final DecodeMonitor monitor;
    private int pos;
    private final byte singleByte[];

    protected QuotedPrintableInputStream(int i, InputStream inputstream, DecodeMonitor decodemonitor)
    {
        singleByte = new byte[1];
        pos = 0;
        limit = 0;
        in = inputstream;
        encoded = new byte[i];
        decodedBuf = new ByteArrayBuffer(512);
        blanks = new ByteArrayBuffer(512);
        closed = false;
        monitor = decodemonitor;
    }

    protected QuotedPrintableInputStream(int i, InputStream inputstream, boolean flag)
    {
        DecodeMonitor decodemonitor;
        if (flag)
        {
            decodemonitor = DecodeMonitor.STRICT;
        } else
        {
            decodemonitor = DecodeMonitor.SILENT;
        }
        this(i, inputstream, decodemonitor);
    }

    public QuotedPrintableInputStream(InputStream inputstream)
    {
        this(inputstream, false);
    }

    public QuotedPrintableInputStream(InputStream inputstream, DecodeMonitor decodemonitor)
    {
        this(2048, inputstream, decodemonitor);
    }

    public QuotedPrintableInputStream(InputStream inputstream, boolean flag)
    {
        this(2048, inputstream, flag);
    }

    private int convert(int i)
    {
        if (i >= 48 && i <= 57)
        {
            return i - 48;
        }
        if (i >= 65 && i <= 70)
        {
            return (i - 65) + 10;
        }
        if (i >= 97 && i <= 102)
        {
            return (i - 97) + 10;
        } else
        {
            return -1;
        }
    }

    private int fillBuffer()
        throws IOException
    {
        int i = 0;
        int j;
        if (pos < limit)
        {
            System.arraycopy(encoded, pos, encoded, 0, limit - pos);
            limit = limit - pos;
            pos = 0;
        } else
        {
            limit = 0;
            pos = 0;
        }
        j = encoded.length - limit;
        if (j > 0)
        {
            j = in.read(encoded, limit, j);
            i = j;
            if (j > 0)
            {
                limit = limit + j;
                i = j;
            }
        }
        return i;
    }

    private int getnext()
    {
        if (pos < limit)
        {
            byte byte0 = encoded[pos];
            pos = pos + 1;
            return byte0 & 0xff;
        } else
        {
            return -1;
        }
    }

    private int peek(int i)
    {
        if (pos + i < limit)
        {
            return encoded[pos + i] & 0xff;
        } else
        {
            return -1;
        }
    }

    private int read0(byte abyte0[], int i, int j)
        throws IOException
    {
        int k;
        boolean flag2;
        int i1;
        boolean flag = false;
        i1 = i + j;
        j = i;
        k = j;
        flag2 = flag;
        if (decodedBuf.length() > 0)
        {
            k = Math.min(decodedBuf.length(), i1 - j);
            System.arraycopy(decodedBuf.buffer(), 0, abyte0, j, k);
            decodedBuf.remove(0, k);
            k = j + k;
            flag2 = flag;
        }
_L10:
        if (k >= i1) goto _L2; else goto _L1
_L1:
        boolean flag1;
        int l;
        flag1 = flag2;
        if (limit - pos < 3)
        {
            if (fillBuffer() == -1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (limit - pos == 0 && flag1)
        {
            if (k == i)
            {
                return -1;
            } else
            {
                return k - i;
            }
        }
        l = 0;
        j = k;
_L8:
        int k1;
        k = j;
        flag2 = flag1;
        if (pos >= limit)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = j;
        flag2 = flag1;
        if (j >= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        byte abyte1[] = encoded;
        k = pos;
        pos = k + 1;
        k1 = abyte1[k] & 0xff;
        if (l != 0 && k1 != 10)
        {
            if (monitor.warn("Found CR without LF", "Leaving it as is"))
            {
                throw new IOException("Found CR without LF");
            }
            k = transfer(13, abyte0, j, i1, false);
        } else
        {
            k = j;
            if (l == 0)
            {
                k = j;
                if (k1 == 10)
                {
                    k = j;
                    if (monitor.warn("Found LF without CR", "Translating to CRLF"))
                    {
                        throw new IOException("Found LF without CR");
                    }
                }
            }
        }
        if (k1 == 13)
        {
            l = 1;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        flag2 = false;
        if (k1 != 10) goto _L4; else goto _L3
_L3:
        if (blanks.length() != 0) goto _L6; else goto _L5
_L5:
        j = transfer(10, abyte0, transfer(13, abyte0, k, i1, false), i1, false);
_L7:
        blanks.clear();
        l = ((flag2) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L6:
        j = k;
        if (blanks.byteAt(0) != 61)
        {
            j = transfer(10, abyte0, transfer(13, abyte0, k, i1, false), i1, false);
        }
        if (true) goto _L7; else goto _L4
_L4:
        if (k1 == 61)
        {
            if (limit - pos < 2 && !flag1)
            {
                pos = pos - 1;
                flag2 = flag1;
                continue; /* Loop/switch isn't completed */
            }
            int j1 = getnext();
            if (j1 == 61)
            {
                j = transfer(j1, abyte0, k, i1, true);
                k = peek(0);
                l = peek(1);
                if (k == 10 || k == 13 && l == 10)
                {
                    monitor.warn("Unexpected ==EOL encountered", (new StringBuilder()).append("== 0x").append(k).append(" 0x").append(l).toString());
                    blanks.append(j1);
                    l = ((flag2) ? 1 : 0);
                } else
                {
                    monitor.warn("Unexpected == encountered", "==");
                    l = ((flag2) ? 1 : 0);
                }
            } else
            if (Character.isWhitespace((char)j1))
            {
                k = transfer(-1, abyte0, k, i1, true);
                j = k;
                l = ((flag2) ? 1 : 0);
                if (j1 != 10)
                {
                    blanks.append(k1);
                    blanks.append(j1);
                    j = k;
                    l = ((flag2) ? 1 : 0);
                }
            } else
            {
                j = getnext();
                l = convert(j1);
                k1 = convert(j);
                if (l < 0 || k1 < 0)
                {
                    monitor.warn("Malformed encoded value encountered", (new StringBuilder()).append("leaving =").append((char)j1).append((char)j).append(" as is").toString());
                    j = transfer(j, abyte0, transfer(j1, abyte0, transfer(61, abyte0, k, i1, true), i1, false), i1, false);
                    l = ((flag2) ? 1 : 0);
                } else
                {
                    j = transfer(l << 4 | k1, abyte0, k, i1, true);
                    l = ((flag2) ? 1 : 0);
                }
            }
        } else
        if (Character.isWhitespace(k1))
        {
            blanks.append(k1);
            j = k;
            l = ((flag2) ? 1 : 0);
        } else
        {
            j = transfer(k1 & 0xff, abyte0, k, i1, true);
            l = ((flag2) ? 1 : 0);
        }
        if (true) goto _L8; else goto _L2
_L2:
        return i1 - i;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private int transfer(int i, byte abyte0[], int j, int k, boolean flag)
        throws IOException
    {
        if (flag && blanks.length() > 0)
        {
            int l = Math.min(blanks.length(), k - j);
            System.arraycopy(blanks.buffer(), 0, abyte0, j, l);
            int j1 = blanks.length() - l;
            if (j1 > 0)
            {
                decodedBuf.append(blanks.buffer(), l, j1);
            }
            blanks.clear();
            j += l;
        } else
        if (blanks.length() > 0 && !flag)
        {
            StringBuilder stringbuilder = new StringBuilder(blanks.length() * 3);
            for (int i1 = 0; i1 < blanks.length(); i1++)
            {
                stringbuilder.append((new StringBuilder()).append(" ").append(blanks.byteAt(i1)).toString());
            }

            if (monitor.warn("ignored blanks", stringbuilder.toString()))
            {
                throw new IOException("ignored blanks");
            }
        }
        if (i != -1)
        {
            if (j < k)
            {
                abyte0[j] = (byte)i;
                return j + 1;
            }
            decodedBuf.append(i);
        }
        return j;
    }

    public void close()
        throws IOException
    {
        closed = true;
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
            i = read(singleByte, 0, 1);
            if (i == -1)
            {
                return -1;
            }
        } while (i != 1);
        return singleByte[0] & 0xff;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Stream has been closed");
        } else
        {
            return read0(abyte0, i, j);
        }
    }
}
