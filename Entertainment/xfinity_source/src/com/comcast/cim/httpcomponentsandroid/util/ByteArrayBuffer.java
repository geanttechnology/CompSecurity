// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.util;

import java.io.Serializable;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.util:
//            CharArrayBuffer

public final class ByteArrayBuffer
    implements Serializable
{

    private byte buffer[];
    private int len;

    public ByteArrayBuffer(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        } else
        {
            buffer = new byte[i];
            return;
        }
    }

    private void expand(int i)
    {
        byte abyte0[] = new byte[Math.max(buffer.length << 1, i)];
        System.arraycopy(buffer, 0, abyte0, 0, len);
        buffer = abyte0;
    }

    public void append(int i)
    {
        int j = len + 1;
        if (j > buffer.length)
        {
            expand(j);
        }
        buffer[len] = (byte)i;
        len = j;
    }

    public void append(CharArrayBuffer chararraybuffer, int i, int j)
    {
        if (chararraybuffer == null)
        {
            return;
        } else
        {
            append(chararraybuffer.buffer(), i, j);
            return;
        }
    }

    public void append(byte abyte0[], int i, int j)
    {
        if (abyte0 != null)
        {
            if (i < 0 || i > abyte0.length || j < 0 || i + j < 0 || i + j > abyte0.length)
            {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + j + " b.length: " + abyte0.length);
            }
            if (j != 0)
            {
                int k = len + j;
                if (k > buffer.length)
                {
                    expand(k);
                }
                System.arraycopy(abyte0, i, buffer, len, j);
                len = k;
                return;
            }
        }
    }

    public void append(char ac[], int i, int j)
    {
        if (ac != null)
        {
            if (i < 0 || i > ac.length || j < 0 || i + j < 0 || i + j > ac.length)
            {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + j + " b.length: " + ac.length);
            }
            if (j != 0)
            {
                int k = len;
                int l = k + j;
                if (l > buffer.length)
                {
                    expand(l);
                }
                for (j = k; j < l; j++)
                {
                    buffer[j] = (byte)ac[i];
                    i++;
                }

                len = l;
                return;
            }
        }
    }

    public byte[] buffer()
    {
        return buffer;
    }

    public int byteAt(int i)
    {
        return buffer[i];
    }

    public int capacity()
    {
        return buffer.length;
    }

    public void clear()
    {
        len = 0;
    }

    public boolean isEmpty()
    {
        return len == 0;
    }

    public boolean isFull()
    {
        return len == buffer.length;
    }

    public int length()
    {
        return len;
    }

    public void setLength(int i)
    {
        if (i < 0 || i > buffer.length)
        {
            throw new IndexOutOfBoundsException("len: " + i + " < 0 or > buffer len: " + buffer.length);
        } else
        {
            len = i;
            return;
        }
    }

    public byte[] toByteArray()
    {
        byte abyte0[] = new byte[len];
        if (len > 0)
        {
            System.arraycopy(buffer, 0, abyte0, 0, len);
        }
        return abyte0;
    }
}
