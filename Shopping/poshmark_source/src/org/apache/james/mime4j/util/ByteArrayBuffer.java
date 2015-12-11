// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;


// Referenced classes of package org.apache.james.mime4j.util:
//            ByteSequence

public final class ByteArrayBuffer
    implements ByteSequence
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

    public ByteArrayBuffer(byte abyte0[], int i, boolean flag)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > abyte0.length)
        {
            throw new IllegalArgumentException();
        }
        if (flag)
        {
            buffer = abyte0;
        } else
        {
            buffer = new byte[i];
            System.arraycopy(abyte0, 0, buffer, 0, i);
        }
        len = i;
    }

    public ByteArrayBuffer(byte abyte0[], boolean flag)
    {
        this(abyte0, abyte0.length, flag);
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

    public void append(byte abyte0[], int i, int j)
    {
        if (abyte0 != null)
        {
            if (i < 0 || i > abyte0.length || j < 0 || i + j < 0 || i + j > abyte0.length)
            {
                throw new IndexOutOfBoundsException();
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

    public byte[] buffer()
    {
        return buffer;
    }

    public byte byteAt(int i)
    {
        if (i < 0 || i >= len)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return buffer[i];
        }
    }

    public int capacity()
    {
        return buffer.length;
    }

    public void clear()
    {
        len = 0;
    }

    public int indexOf(byte byte0)
    {
        return indexOf(byte0, 0, len);
    }

    public int indexOf(byte byte0, int i, int j)
    {
        int k;
        int l;
        k = i;
        if (i < 0)
        {
            k = 0;
        }
        l = j;
        if (j > len)
        {
            l = len;
        }
        if (k <= l) goto _L2; else goto _L1
_L1:
        j = -1;
_L4:
        return j;
_L2:
        i = k;
label0:
        do
        {
label1:
            {
                if (i >= l)
                {
                    break label1;
                }
                j = i;
                if (buffer[i] == byte0)
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
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

    public void remove(int i, int j)
    {
        if (i < 0 || i > len || j < 0 || i + j < 0 || i + j > len)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j == 0)
        {
            return;
        }
        int k = len - i - j;
        if (k > 0)
        {
            System.arraycopy(buffer, i + j, buffer, i, k);
        }
        len = len - j;
    }

    public void setLength(int i)
    {
        if (i < 0 || i > buffer.length)
        {
            throw new IndexOutOfBoundsException();
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

    public String toString()
    {
        return new String(toByteArray());
    }
}
