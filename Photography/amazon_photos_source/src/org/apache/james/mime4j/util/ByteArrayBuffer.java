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

    private void expand(int i)
    {
        byte abyte0[] = new byte[Math.max(buffer.length << 1, i)];
        System.arraycopy(buffer, 0, abyte0, 0, len);
        buffer = abyte0;
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

    public int length()
    {
        return len;
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
