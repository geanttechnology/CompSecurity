// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.util.ByteArrayBuffer;

// Referenced classes of package org.apache.james.mime4j.io:
//            LineReaderInputStream, MaxLineLimitException

public class BufferedLineReaderInputStream extends LineReaderInputStream
{

    private byte buffer[];
    private int buflen;
    private int bufpos;
    private final int maxLineLen;
    private byte origBuffer[];
    private int origBuflen;
    private int origBufpos;
    boolean tempBuffer;
    private boolean truncated;

    public BufferedLineReaderInputStream(InputStream inputstream, int i)
    {
        this(inputstream, i, -1);
    }

    public BufferedLineReaderInputStream(InputStream inputstream, int i, int j)
    {
        super(inputstream);
        tempBuffer = false;
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        } else
        {
            buffer = new byte[i];
            bufpos = 0;
            buflen = 0;
            maxLineLen = j;
            truncated = false;
            return;
        }
    }

    private int bufferLen()
    {
        return buflen - bufpos;
    }

    private void clear()
    {
        bufpos = 0;
        buflen = 0;
    }

    private void expand(int i)
    {
        byte abyte0[] = new byte[i];
        i = bufferLen();
        if (i > 0)
        {
            System.arraycopy(buffer, bufpos, abyte0, bufpos, i);
        }
        buffer = abyte0;
    }

    protected byte[] buf()
    {
        return buffer;
    }

    public int byteAt(int i)
    {
        if (i < bufpos || i > buflen)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("looking for ").append(i).append(" in ").append(bufpos).append("/").append(buflen).toString());
        } else
        {
            return buffer[i] & 0xff;
        }
    }

    public int capacity()
    {
        return buffer.length;
    }

    public void ensureCapacity(int i)
    {
        if (i > buffer.length)
        {
            expand(i);
        }
    }

    public int fillBuffer()
        throws IOException
    {
        if (tempBuffer)
        {
            if (bufpos != buflen)
            {
                throw new IllegalStateException("unread only works when a buffer is fully read before the next refill is asked!");
            } else
            {
                buffer = origBuffer;
                buflen = origBuflen;
                bufpos = origBufpos;
                tempBuffer = false;
                return bufferLen();
            }
        }
        if (bufpos > 0)
        {
            int i = bufferLen();
            if (i > 0)
            {
                System.arraycopy(buffer, bufpos, buffer, 0, i);
            }
            bufpos = 0;
            buflen = i;
        }
        int j = buflen;
        int k = buffer.length;
        k = in.read(buffer, j, k - j);
        if (k == -1)
        {
            return -1;
        } else
        {
            buflen = j + k;
            return k;
        }
    }

    public boolean hasBufferedData()
    {
        return bufferLen() > 0;
    }

    public int indexOf(byte byte0)
    {
        return indexOf(byte0, bufpos, bufferLen());
    }

    public int indexOf(byte byte0, int i, int j)
    {
        if (i < bufpos || j < 0 || i + j > buflen)
        {
            throw new IndexOutOfBoundsException();
        }
        for (int k = i; k < i + j; k++)
        {
            if (buffer[k] == byte0)
            {
                return k;
            }
        }

        return -1;
    }

    public int indexOf(byte abyte0[])
    {
        return indexOf(abyte0, bufpos, buflen - bufpos);
    }

    public int indexOf(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Pattern may not be null");
        }
        if (i < bufpos || j < 0 || i + j > buflen)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("looking for ").append(i).append("(").append(j).append(")").append(" in ").append(bufpos).append("/").append(buflen).toString());
        }
        if (j >= abyte0.length) goto _L2; else goto _L1
_L1:
        int k1 = -1;
_L6:
        return k1;
_L2:
        int ai[];
        int i1;
        ai = new int[256];
        for (int k = 0; k < ai.length; k++)
        {
            ai[k] = abyte0.length + 1;
        }

        for (int l = 0; l < abyte0.length; l++)
        {
            ai[abyte0[l] & 0xff] = abyte0.length - l;
        }

        i1 = 0;
_L8:
        if (i1 > j - abyte0.length) goto _L4; else goto _L3
_L3:
        int l1;
        boolean flag1;
        l1 = i + i1;
        flag1 = true;
        k1 = 0;
_L7:
        boolean flag;
        flag = flag1;
        if (k1 < abyte0.length)
        {
            if (buffer[l1 + k1] == abyte0[k1])
            {
                break MISSING_BLOCK_LABEL_267;
            }
            flag = false;
        }
        k1 = l1;
        if (flag) goto _L6; else goto _L5
_L5:
        int j1;
        j1 = l1 + abyte0.length;
        if (j1 < buffer.length)
        {
            break MISSING_BLOCK_LABEL_276;
        }
_L4:
        return -1;
        k1++;
          goto _L7
        i1 += ai[buffer[j1] & 0xff];
          goto _L8
    }

    protected int length()
    {
        return bufferLen();
    }

    protected int limit()
    {
        return buflen;
    }

    public boolean markSupported()
    {
        return false;
    }

    protected int pos()
    {
        return bufpos;
    }

    public int read()
        throws IOException
    {
        if (!readAllowed())
        {
            return -1;
        }
        while (!hasBufferedData()) 
        {
            if (fillBuffer() == -1)
            {
                return -1;
            }
        }
        byte abyte0[] = buffer;
        int i = bufpos;
        bufpos = i + 1;
        return abyte0[i] & 0xff;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        byte byte0 = 0;
        if (!readAllowed())
        {
            byte0 = -1;
        } else
        if (abyte0 != null)
        {
            return read(abyte0, 0, abyte0.length);
        }
        return byte0;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (!readAllowed())
        {
            return -1;
        }
        if (abyte0 == null)
        {
            return 0;
        }
        while (!hasBufferedData()) 
        {
            if (fillBuffer() == -1)
            {
                return -1;
            }
        }
        int l = bufferLen();
        int k = l;
        if (l > j)
        {
            k = j;
        }
        System.arraycopy(buffer, bufpos, abyte0, i, k);
        bufpos = bufpos + k;
        return k;
    }

    protected boolean readAllowed()
    {
        return !truncated;
    }

    public int readLine(ByteArrayBuffer bytearraybuffer)
        throws MaxLineLimitException, IOException
    {
        if (bytearraybuffer == null)
        {
            throw new IllegalArgumentException("Buffer may not be null");
        }
        if (readAllowed()) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = 0;
        boolean flag = false;
        j = 0;
        do
        {
            do
            {
                int k;
label0:
                {
                    k = j;
                    if (!flag)
                    {
                        k = j;
                        if (hasBufferedData())
                        {
                            break label0;
                        }
                        j = fillBuffer();
                        k = j;
                        if (j != -1)
                        {
                            break label0;
                        }
                        k = j;
                    }
                    j = i;
                    if (i == 0)
                    {
                        j = i;
                        if (k == -1)
                        {
                            return -1;
                        }
                    }
                    continue; /* Loop/switch isn't completed */
                }
                j = indexOf((byte)10);
                boolean flag1;
                int l;
                if (j != -1)
                {
                    flag1 = true;
                    j = (j + 1) - pos();
                } else
                {
                    j = length();
                    flag1 = flag;
                }
                l = i;
                if (j > 0)
                {
                    bytearraybuffer.append(buf(), pos(), j);
                    skip(j);
                    l = i + j;
                }
                j = k;
                flag = flag1;
                i = l;
            } while (maxLineLen <= 0);
            j = k;
            flag = flag1;
            i = l;
        } while (bytearraybuffer.length() < maxLineLen);
        throw new MaxLineLimitException("Maximum line length limit exceeded");
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected int skip(int i)
    {
        i = Math.min(i, bufferLen());
        bufpos = bufpos + i;
        return i;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[pos: ");
        stringbuilder.append(bufpos);
        stringbuilder.append("]");
        stringbuilder.append("[limit: ");
        stringbuilder.append(buflen);
        stringbuilder.append("]");
        stringbuilder.append("[");
        for (int i = bufpos; i < buflen; i++)
        {
            stringbuilder.append((char)buffer[i]);
        }

        stringbuilder.append("]");
        if (tempBuffer)
        {
            stringbuilder.append("-ORIG[pos: ");
            stringbuilder.append(origBufpos);
            stringbuilder.append("]");
            stringbuilder.append("[limit: ");
            stringbuilder.append(origBuflen);
            stringbuilder.append("]");
            stringbuilder.append("[");
            for (int j = origBufpos; j < origBuflen; j++)
            {
                stringbuilder.append((char)origBuffer[j]);
            }

            stringbuilder.append("]");
        }
        return stringbuilder.toString();
    }

    public void truncate()
    {
        clear();
        truncated = true;
    }

    public boolean unread(ByteArrayBuffer bytearraybuffer)
    {
        if (tempBuffer)
        {
            return false;
        } else
        {
            origBuffer = buffer;
            origBuflen = buflen;
            origBufpos = bufpos;
            bufpos = 0;
            buflen = bytearraybuffer.length();
            buffer = bytearraybuffer.buffer();
            tempBuffer = true;
            return true;
        }
    }
}
