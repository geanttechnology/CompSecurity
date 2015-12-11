// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.util.ByteArrayBuffer;

// Referenced classes of package org.apache.james.mime4j.io:
//            LineReaderInputStream, MaxLineLimitException

public class LineReaderInputStreamAdaptor extends LineReaderInputStream
{

    private final LineReaderInputStream bis;
    private boolean eof;
    private final int maxLineLen;
    private boolean used;

    public LineReaderInputStreamAdaptor(InputStream inputstream)
    {
        this(inputstream, -1);
    }

    public LineReaderInputStreamAdaptor(InputStream inputstream, int i)
    {
        super(inputstream);
        used = false;
        eof = false;
        if (inputstream instanceof LineReaderInputStream)
        {
            bis = (LineReaderInputStream)inputstream;
        } else
        {
            bis = null;
        }
        maxLineLen = i;
    }

    private int doReadLine(ByteArrayBuffer bytearraybuffer)
        throws MaxLineLimitException, IOException
    {
        int i = 0;
        int j;
        int k;
        do
        {
            k = in.read();
            j = i;
            if (k == -1)
            {
                break;
            }
            bytearraybuffer.append(k);
            j = i + 1;
            if (maxLineLen > 0 && bytearraybuffer.length() >= maxLineLen)
            {
                throw new MaxLineLimitException("Maximum line length limit exceeded");
            }
            i = j;
        } while (k != 10);
        i = j;
        if (j == 0)
        {
            i = j;
            if (k == -1)
            {
                i = -1;
            }
        }
        return i;
    }

    public boolean eof()
    {
        return eof;
    }

    public boolean isUsed()
    {
        return used;
    }

    public int read()
        throws IOException
    {
        int i = in.read();
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eof = flag;
        used = true;
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        i = in.read(abyte0, i, j);
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eof = flag;
        used = true;
        return i;
    }

    public int readLine(ByteArrayBuffer bytearraybuffer)
        throws MaxLineLimitException, IOException
    {
        int i;
        boolean flag;
        if (bis != null)
        {
            i = bis.readLine(bytearraybuffer);
        } else
        {
            i = doReadLine(bytearraybuffer);
        }
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eof = flag;
        used = true;
        return i;
    }

    public long skip(long l)
        throws IOException
    {
        if (l > 0L) goto _L2; else goto _L1
_L1:
        long l2 = 0L;
_L4:
        return l2;
_L2:
        byte abyte0[];
        int i;
        long l1;
        if (l > 8192L)
        {
            i = 8192;
        } else
        {
            i = (int)l;
        }
        abyte0 = new byte[i];
        l2 = 0L;
        l1 = l;
        l = l2;
        l2 = l;
        if (l1 > 0L)
        {
            i = read(abyte0);
            l2 = l;
            if (i != -1)
            {
                l += i;
                l1 -= i;
                break MISSING_BLOCK_LABEL_39;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String toString()
    {
        return (new StringBuilder()).append("[LineReaderInputStreamAdaptor: ").append(bis).append("]").toString();
    }

    public boolean unread(ByteArrayBuffer bytearraybuffer)
    {
        if (bis != null)
        {
            return bis.unread(bytearraybuffer);
        } else
        {
            return false;
        }
    }
}
