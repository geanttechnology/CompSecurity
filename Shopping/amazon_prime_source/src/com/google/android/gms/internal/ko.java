// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            kw

public final class ko
{
    public static class a extends IOException
    {

        a(int i, int j)
        {
            super((new StringBuilder()).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i).append(" limit ").append(j).append(").").toString());
        }
    }


    private final int adT;
    private final byte buffer[];
    private int position;

    private ko(byte abyte0[], int i, int j)
    {
        buffer = abyte0;
        position = i;
        adT = i + j;
    }

    public static ko b(byte abyte0[], int i, int j)
    {
        return new ko(abyte0, i, j);
    }

    public static ko o(byte abyte0[])
    {
        return b(abyte0, 0, abyte0.length);
    }

    public void C(long l)
        throws IOException
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                cY((int)l);
                return;
            }
            cY((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }

    public void b(byte byte0)
        throws IOException
    {
        if (position == adT)
        {
            throw new a(position, adT);
        } else
        {
            byte abyte0[] = buffer;
            int i = position;
            position = i + 1;
            abyte0[i] = byte0;
            return;
        }
    }

    public void b(int i, long l)
        throws IOException
    {
        k(i, 0);
        y(l);
    }

    public void b(int i, String s)
        throws IOException
    {
        k(i, 2);
        ce(s);
    }

    public void c(byte abyte0[], int i, int j)
        throws IOException
    {
        if (adT - position >= j)
        {
            System.arraycopy(abyte0, i, buffer, position, j);
            position = position + j;
            return;
        } else
        {
            throw new a(position, adT);
        }
    }

    public void cY(int i)
        throws IOException
    {
        b((byte)i);
    }

    public void ce(String s)
        throws IOException
    {
        s = s.getBytes("UTF-8");
        da(s.length);
        p(s);
    }

    public void da(int i)
        throws IOException
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                cY(i);
                return;
            }
            cY(i & 0x7f | 0x80);
            i >>>= 7;
        } while (true);
    }

    public void k(int i, int j)
        throws IOException
    {
        da(kw.l(i, j));
    }

    public int mv()
    {
        return adT - position;
    }

    public void p(byte abyte0[])
        throws IOException
    {
        c(abyte0, 0, abyte0.length);
    }

    public void y(long l)
        throws IOException
    {
        C(l);
    }
}
