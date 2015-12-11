// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.IOException;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.MimeIOException;
import org.apache.james.mime4j.util.ByteArrayBuffer;
import org.apache.james.mime4j.util.CharsetUtil;

// Referenced classes of package org.apache.james.mime4j.io:
//            LineReaderInputStream, BufferedLineReaderInputStream

public class MimeBoundaryInputStream extends LineReaderInputStream
{

    private boolean atBoundary;
    private final byte boundary[];
    private int boundaryLen;
    private BufferedLineReaderInputStream buffer;
    private boolean completed;
    private boolean eof;
    private int initialLength;
    private boolean lastPart;
    private int limit;
    private final boolean strict;

    public MimeBoundaryInputStream(BufferedLineReaderInputStream bufferedlinereaderinputstream, String s)
        throws IOException
    {
        this(bufferedlinereaderinputstream, s, false);
    }

    public MimeBoundaryInputStream(BufferedLineReaderInputStream bufferedlinereaderinputstream, String s, boolean flag)
        throws IOException
    {
        super(bufferedlinereaderinputstream);
        int k = s.length() * 2;
        int i = k;
        if (k < 4096)
        {
            i = 4096;
        }
        bufferedlinereaderinputstream.ensureCapacity(i);
        buffer = bufferedlinereaderinputstream;
        eof = false;
        limit = -1;
        atBoundary = false;
        boundaryLen = 0;
        lastPart = false;
        initialLength = -1;
        completed = false;
        strict = flag;
        boundary = new byte[s.length() + 2];
        boundary[0] = 45;
        boundary[1] = 45;
        for (int j = 0; j < s.length(); j++)
        {
            byte byte0 = (byte)s.charAt(j);
            boundary[j + 2] = byte0;
        }

        fillBuffer();
    }

    private void calculateBoundaryLen()
        throws IOException
    {
        boundaryLen = boundary.length;
        int i = limit - buffer.pos();
        if (i >= 0 && initialLength == -1)
        {
            initialLength = i;
        }
        if (i > 0 && buffer.byteAt(limit - 1) == 10)
        {
            boundaryLen = boundaryLen + 1;
            limit = limit - 1;
        }
        if (i > 1 && buffer.byteAt(limit - 1) == 13)
        {
            boundaryLen = boundaryLen + 1;
            limit = limit - 1;
        }
    }

    private boolean endOfStream()
    {
        return eof || atBoundary;
    }

    private int fillBuffer()
        throws IOException
    {
        int i;
        int k;
        if (eof)
        {
            return -1;
        }
        if (!hasData())
        {
            int j = buffer.fillBuffer();
            i = j;
            if (j == -1)
            {
                eof = true;
                i = j;
            }
        } else
        {
            i = 0;
        }
        k = buffer.pos();
_L6:
        k = buffer.indexOf(boundary, k, buffer.limit() - k);
        if (k != -1) goto _L2; else goto _L1
_L1:
        if (k != -1)
        {
            limit = k;
            atBoundary = true;
            calculateBoundaryLen();
            return i;
        }
        break; /* Loop/switch isn't completed */
_L2:
        int l;
        if (k != buffer.pos() && buffer.byteAt(k - 1) != 10)
        {
            break; /* Loop/switch isn't completed */
        }
        if (buffer.limit() - (l = k + boundary.length) <= 0) goto _L1; else goto _L3
_L3:
        char c = (char)buffer.byteAt(l);
        if (CharsetUtil.isWhitespace(c) || c == '-') goto _L1; else goto _L4
_L4:
        k += boundary.length;
        if (true) goto _L6; else goto _L5
_L5:
        if (eof)
        {
            limit = buffer.limit();
            return i;
        } else
        {
            limit = buffer.limit() - (boundary.length + 2);
            return i;
        }
    }

    private boolean hasData()
    {
        return limit > buffer.pos() && limit <= buffer.limit();
    }

    private void skipBoundary()
        throws IOException
    {
        if (completed) goto _L2; else goto _L1
_L1:
        boolean flag;
        completed = true;
        buffer.skip(boundaryLen);
        flag = true;
_L9:
        if (buffer.length() <= 1) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        i = buffer.byteAt(buffer.pos());
        j = buffer.byteAt(buffer.pos() + 1);
        if (flag && i == 45 && j == 45)
        {
            lastPart = true;
            buffer.skip(2);
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if (i != 13 || j != 10) goto _L6; else goto _L5
_L5:
        buffer.skip(2);
_L2:
        return;
_L6:
        if (i == 10)
        {
            buffer.skip(1);
            return;
        }
        buffer.skip(1);
        continue; /* Loop/switch isn't completed */
_L4:
        if (eof) goto _L2; else goto _L7
_L7:
        fillBuffer();
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void verifyEndOfStream()
        throws IOException
    {
        if (strict && eof && !atBoundary)
        {
            throw new MimeIOException(new MimeException("Unexpected end of stream"));
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
    }

    public boolean eof()
    {
        return eof && !buffer.hasBufferedData();
    }

    public boolean isEmptyStream()
    {
        return initialLength == 0;
    }

    public boolean isFullyConsumed()
    {
        return completed && !buffer.hasBufferedData();
    }

    public boolean isLastPart()
    {
        return lastPart;
    }

    public boolean markSupported()
    {
        return false;
    }

    public int read()
        throws IOException
    {
        do
        {
            if (!readAllowed())
            {
                return -1;
            }
            if (hasData())
            {
                return buffer.read();
            }
            fillBuffer();
        } while (true);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        do
        {
            if (!readAllowed())
            {
                return -1;
            }
            if (hasData())
            {
                j = Math.min(j, limit - buffer.pos());
                return buffer.read(abyte0, i, j);
            }
            fillBuffer();
        } while (true);
    }

    public boolean readAllowed()
        throws IOException
    {
        if (completed)
        {
            return false;
        }
        if (endOfStream() && !hasData())
        {
            skipBoundary();
            verifyEndOfStream();
            return false;
        } else
        {
            return true;
        }
    }

    public int readLine(ByteArrayBuffer bytearraybuffer)
        throws IOException
    {
        if (bytearraybuffer == null)
        {
            throw new IllegalArgumentException("Destination buffer may not be null");
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
            int k;
label0:
            {
                k = j;
                if (!flag)
                {
                    k = j;
                    if (hasData())
                    {
                        break label0;
                    }
                    j = fillBuffer();
                    k = j;
                    if (!endOfStream())
                    {
                        break label0;
                    }
                    k = j;
                    if (hasData())
                    {
                        break label0;
                    }
                    skipBoundary();
                    verifyEndOfStream();
                    k = -1;
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
            }
            if (true)
            {
                continue;
            }
            int l = limit - buffer.pos();
            j = buffer.indexOf((byte)10, buffer.pos(), l);
            boolean flag1;
            if (j != -1)
            {
                flag1 = true;
                l = (j + 1) - buffer.pos();
            } else
            {
                flag1 = flag;
            }
            j = k;
            flag = flag1;
            if (l > 0)
            {
                bytearraybuffer.append(buffer.buf(), buffer.pos(), l);
                buffer.skip(l);
                i += l;
                j = k;
                flag = flag1;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MimeBoundaryInputStream, boundary ");
        byte abyte0[] = boundary;
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((char)abyte0[i]);
        }

        return stringbuilder.toString();
    }

    public boolean unread(ByteArrayBuffer bytearraybuffer)
    {
        return false;
    }
}
