// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            kd, ke, kh

public final class jy
{

    private int ZU;
    private int ZV;
    private int ZW;
    private int ZX;
    private int ZY;
    private int ZZ;
    private int aaa;
    private int aab;
    private int aac;
    private final byte buffer[];

    private jy(byte abyte0[], int i, int j)
    {
        ZZ = 0x7fffffff;
        aab = 64;
        aac = 0x4000000;
        buffer = abyte0;
        ZU = i;
        ZV = i + j;
        ZX = i;
    }

    public static jy a(byte abyte0[], int i, int j)
    {
        return new jy(abyte0, i, j);
    }

    private void kI()
    {
        ZV = ZV + ZW;
        int i = ZV;
        if (i > ZZ)
        {
            ZW = i - ZZ;
            ZV = ZV - ZW;
            return;
        } else
        {
            ZW = 0;
            return;
        }
    }

    public static jy n(byte abyte0[])
    {
        return a(abyte0, 0, abyte0.length);
    }

    public static long w(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    public void a(ke ke1)
        throws IOException
    {
        int i = kE();
        if (aaa >= aab)
        {
            throw kd.kU();
        } else
        {
            i = cw(i);
            aaa = aaa + 1;
            ke1.b(this);
            cu(0);
            aaa = aaa - 1;
            cx(i);
            return;
        }
    }

    public void a(ke ke1, int i)
        throws IOException
    {
        if (aaa >= aab)
        {
            throw kd.kU();
        } else
        {
            aaa = aaa + 1;
            ke1.b(this);
            cu(kh.i(i, 4));
            aaa = aaa - 1;
            return;
        }
    }

    public void cA(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw kd.kP();
        }
        if (ZX + i > ZZ)
        {
            cA(ZZ - ZX);
            throw kd.kO();
        }
        if (i <= ZV - ZX)
        {
            ZX = ZX + i;
            return;
        } else
        {
            throw kd.kO();
        }
    }

    public void cu(int i)
        throws kd
    {
        if (ZY != i)
        {
            throw kd.kS();
        } else
        {
            return;
        }
    }

    public boolean cv(int i)
        throws IOException
    {
        switch (kh.cJ(i))
        {
        default:
            throw kd.kT();

        case 0: // '\0'
            kB();
            return true;

        case 1: // '\001'
            kH();
            return true;

        case 2: // '\002'
            cA(kE());
            return true;

        case 3: // '\003'
            kz();
            cu(kh.i(kh.cK(i), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            kG();
            break;
        }
        return true;
    }

    public int cw(int i)
        throws kd
    {
        if (i < 0)
        {
            throw kd.kP();
        }
        i = ZX + i;
        int j = ZZ;
        if (i > j)
        {
            throw kd.kO();
        } else
        {
            ZZ = i;
            kI();
            return j;
        }
    }

    public void cx(int i)
    {
        ZZ = i;
        kI();
    }

    public void cy(int i)
    {
        if (i > ZX - ZU)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Position ").append(i).append(" is beyond current ").append(ZX - ZU).toString());
        }
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad position ").append(i).toString());
        } else
        {
            ZX = ZU + i;
            return;
        }
    }

    public byte[] cz(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw kd.kP();
        }
        if (ZX + i > ZZ)
        {
            cA(ZZ - ZX);
            throw kd.kO();
        }
        if (i <= ZV - ZX)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(buffer, ZX, abyte0, 0, i);
            ZX = ZX + i;
            return abyte0;
        } else
        {
            throw kd.kO();
        }
    }

    public byte[] e(int i, int j)
    {
        if (j == 0)
        {
            return kh.aaq;
        } else
        {
            byte abyte0[] = new byte[j];
            int k = ZU;
            System.arraycopy(buffer, k + i, abyte0, 0, j);
            return abyte0;
        }
    }

    public int getPosition()
    {
        return ZX - ZU;
    }

    public long kA()
        throws IOException
    {
        return kF();
    }

    public int kB()
        throws IOException
    {
        return kE();
    }

    public boolean kC()
        throws IOException
    {
        return kE() != 0;
    }

    public long kD()
        throws IOException
    {
        return w(kF());
    }

    public int kE()
        throws IOException
    {
        int i = kL();
        if (i < 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i &= 0x7f;
        byte byte0 = kL();
        if (byte0 >= 0)
        {
            return i | byte0 << 7;
        }
        i |= (byte0 & 0x7f) << 7;
        byte0 = kL();
        if (byte0 >= 0)
        {
            return i | byte0 << 14;
        }
        i |= (byte0 & 0x7f) << 14;
        int k = kL();
        if (k >= 0)
        {
            return i | k << 21;
        }
        byte0 = kL();
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
                    if (kL() >= 0)
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw kd.kQ();
    }

    public long kF()
        throws IOException
    {
        int i = 0;
        long l = 0L;
        for (; i < 64; i += 7)
        {
            byte byte0 = kL();
            l |= (long)(byte0 & 0x7f) << i;
            if ((byte0 & 0x80) == 0)
            {
                return l;
            }
        }

        throw kd.kQ();
    }

    public int kG()
        throws IOException
    {
        return kL() & 0xff | (kL() & 0xff) << 8 | (kL() & 0xff) << 16 | (kL() & 0xff) << 24;
    }

    public long kH()
        throws IOException
    {
        int i = kL();
        int j = kL();
        int k = kL();
        int l = kL();
        int i1 = kL();
        int j1 = kL();
        int k1 = kL();
        int l1 = kL();
        long l2 = i;
        return ((long)j & 255L) << 8 | l2 & 255L | ((long)k & 255L) << 16 | ((long)l & 255L) << 24 | ((long)i1 & 255L) << 32 | ((long)j1 & 255L) << 40 | ((long)k1 & 255L) << 48 | ((long)l1 & 255L) << 56;
    }

    public int kJ()
    {
        if (ZZ == 0x7fffffff)
        {
            return -1;
        } else
        {
            int i = ZX;
            return ZZ - i;
        }
    }

    public boolean kK()
    {
        return ZX == ZV;
    }

    public byte kL()
        throws IOException
    {
        if (ZX == ZV)
        {
            throw kd.kO();
        } else
        {
            byte abyte0[] = buffer;
            int i = ZX;
            ZX = i + 1;
            return abyte0[i];
        }
    }

    public int ky()
        throws IOException
    {
        if (kK())
        {
            ZY = 0;
            return 0;
        }
        ZY = kE();
        if (ZY == 0)
        {
            throw kd.kR();
        } else
        {
            return ZY;
        }
    }

    public void kz()
        throws IOException
    {
        int i;
        do
        {
            i = ky();
        } while (i != 0 && cv(i));
    }

    public float readFloat()
        throws IOException
    {
        return Float.intBitsToFloat(kG());
    }

    public String readString()
        throws IOException
    {
        int i = kE();
        if (i <= ZV - ZX && i > 0)
        {
            String s = new String(buffer, ZX, i, "UTF-8");
            ZX = i + ZX;
            return s;
        } else
        {
            return new String(cz(i), "UTF-8");
        }
    }
}
