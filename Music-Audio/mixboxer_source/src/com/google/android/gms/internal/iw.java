// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            iy, jb

public final class iw
{

    private int Hp;
    private int Hq;
    private int Hr;
    private int Hs;
    private int Ht;
    private int Hu;
    private int Hv;
    private final byte buffer[];

    private iw(byte abyte0[], int i, int j)
    {
        Ht = 0x7fffffff;
        Hu = 64;
        Hv = 0x4000000;
        buffer = abyte0;
        Hp = i;
        Hq = i + j;
        Hr = i;
    }

    public static iw a(byte abyte0[], int i, int j)
    {
        return new iw(abyte0, i, j);
    }

    public static long n(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    public void bI(int i)
        throws iy
    {
        if (Hs != i)
        {
            throw iy.gk();
        } else
        {
            return;
        }
    }

    public boolean bJ(int i)
        throws IOException
    {
        switch (jb.bS(i))
        {
        default:
            throw iy.gl();

        case 0: // '\0'
            fW();
            return true;

        case 1: // '\001'
            gb();
            return true;

        case 2: // '\002'
            bL(fY());
            return true;

        case 3: // '\003'
            fV();
            bI(jb.g(jb.bT(i), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            ga();
            break;
        }
        return true;
    }

    public byte[] bK(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw iy.gh();
        }
        if (Hr + i > Ht)
        {
            bL(Ht - Hr);
            throw iy.gg();
        }
        if (i <= Hq - Hr)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(buffer, Hr, abyte0, 0, i);
            Hr = Hr + i;
            return abyte0;
        } else
        {
            throw iy.gg();
        }
    }

    public void bL(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw iy.gh();
        }
        if (Hr + i > Ht)
        {
            bL(Ht - Hr);
            throw iy.gg();
        }
        if (i <= Hq - Hr)
        {
            Hr = Hr + i;
            return;
        } else
        {
            throw iy.gg();
        }
    }

    public int fU()
        throws IOException
    {
        if (gc())
        {
            Hs = 0;
            return 0;
        }
        Hs = fY();
        if (Hs == 0)
        {
            throw iy.gj();
        } else
        {
            return Hs;
        }
    }

    public void fV()
        throws IOException
    {
        int i;
        do
        {
            i = fU();
        } while (i != 0 && bJ(i));
    }

    public int fW()
        throws IOException
    {
        return fY();
    }

    public long fX()
        throws IOException
    {
        return n(fZ());
    }

    public int fY()
        throws IOException
    {
        int i = gd();
        if (i < 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i &= 0x7f;
        byte byte0 = gd();
        if (byte0 >= 0)
        {
            return i | byte0 << 7;
        }
        i |= (byte0 & 0x7f) << 7;
        byte0 = gd();
        if (byte0 >= 0)
        {
            return i | byte0 << 14;
        }
        i |= (byte0 & 0x7f) << 14;
        int k = gd();
        if (k >= 0)
        {
            return i | k << 21;
        }
        byte0 = gd();
        k = i | (k & 0x7f) << 21 | byte0 << 28;
        i = k;
        if (byte0 < 0)
        {
            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= 5)
                    {
                        break label1;
                    }
                    i = k;
                    if (gd() >= 0)
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw iy.gi();
    }

    public long fZ()
        throws IOException
    {
        int i = 0;
        long l = 0L;
        for (; i < 64; i += 7)
        {
            byte byte0 = gd();
            l |= (long)(byte0 & 0x7f) << i;
            if ((byte0 & 0x80) == 0)
            {
                return l;
            }
        }

        throw iy.gi();
    }

    public int ga()
        throws IOException
    {
        return gd() & 0xff | (gd() & 0xff) << 8 | (gd() & 0xff) << 16 | (gd() & 0xff) << 24;
    }

    public long gb()
        throws IOException
    {
        int i = gd();
        int j = gd();
        int k = gd();
        int l = gd();
        int i1 = gd();
        int j1 = gd();
        int k1 = gd();
        int l1 = gd();
        long l2 = i;
        return ((long)j & 255L) << 8 | l2 & 255L | ((long)k & 255L) << 16 | ((long)l & 255L) << 24 | ((long)i1 & 255L) << 32 | ((long)j1 & 255L) << 40 | ((long)k1 & 255L) << 48 | ((long)l1 & 255L) << 56;
    }

    public boolean gc()
    {
        return Hr == Hq;
    }

    public byte gd()
        throws IOException
    {
        if (Hr == Hq)
        {
            throw iy.gg();
        } else
        {
            byte abyte0[] = buffer;
            int i = Hr;
            Hr = i + 1;
            return abyte0[i];
        }
    }

    public String readString()
        throws IOException
    {
        int i = fY();
        if (i <= Hq - Hr && i > 0)
        {
            String s = new String(buffer, Hr, i, "UTF-8");
            Hr = i + Hr;
            return s;
        } else
        {
            return new String(bK(i), "UTF-8");
        }
    }
}
