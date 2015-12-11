// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzsh, zzsd, zzse

public final class zzrw
{

    private final byte buffer[];
    private int zzbia;
    private int zzbib;
    private int zzbic;
    private int zzbid;
    private int zzbie;
    private int zzbif;
    private int zzbig;
    private int zzbih;
    private int zzbii;

    private zzrw(byte abyte0[], int i, int j)
    {
        zzbif = 0x7fffffff;
        zzbih = 64;
        zzbii = 0x4000000;
        buffer = abyte0;
        zzbia = i;
        zzbib = i + j;
        zzbid = i;
    }

    public static zzrw zzB(byte abyte0[])
    {
        return zza(abyte0, 0, abyte0.length);
    }

    private void zzFz()
    {
        zzbib = zzbib + zzbic;
        int i = zzbib;
        if (i > zzbif)
        {
            zzbic = i - zzbif;
            zzbib = zzbib - zzbic;
            return;
        } else
        {
            zzbic = 0;
            return;
        }
    }

    public static long zzX(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    public static zzrw zza(byte abyte0[], int i, int j)
    {
        return new zzrw(abyte0, i, j);
    }

    public static int zzlB(int i)
    {
        return i >>> 1 ^ -(i & 1);
    }

    public final int getPosition()
    {
        return zzbid - zzbia;
    }

    public final byte[] readBytes()
    {
        int i = zzFv();
        if (i <= zzbib - zzbid && i > 0)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(buffer, zzbid, abyte0, 0, i);
            zzbid = i + zzbid;
            return abyte0;
        }
        if (i == 0)
        {
            return zzsh.zzbiE;
        } else
        {
            return zzlF(i);
        }
    }

    public final double readDouble()
    {
        return Double.longBitsToDouble(zzFy());
    }

    public final float readFloat()
    {
        return Float.intBitsToFloat(zzFx());
    }

    public final String readString()
    {
        int i = zzFv();
        if (i <= zzbib - zzbid && i > 0)
        {
            String s = new String(buffer, zzbid, i, "UTF-8");
            zzbid = i + zzbid;
            return s;
        } else
        {
            return new String(zzlF(i), "UTF-8");
        }
    }

    public final int zzFA()
    {
        if (zzbif == 0x7fffffff)
        {
            return -1;
        } else
        {
            int i = zzbid;
            return zzbif - i;
        }
    }

    public final boolean zzFB()
    {
        return zzbid == zzbib;
    }

    public final byte zzFC()
    {
        if (zzbid == zzbib)
        {
            throw zzsd.zzFJ();
        } else
        {
            byte abyte0[] = buffer;
            int i = zzbid;
            zzbid = i + 1;
            return abyte0[i];
        }
    }

    public final int zzFo()
    {
        if (zzFB())
        {
            zzbie = 0;
            return 0;
        }
        zzbie = zzFv();
        if (zzbie == 0)
        {
            throw zzsd.zzFM();
        } else
        {
            return zzbie;
        }
    }

    public final void zzFp()
    {
        int i;
        do
        {
            i = zzFo();
        } while (i != 0 && zzlA(i));
    }

    public final long zzFq()
    {
        return zzFw();
    }

    public final int zzFr()
    {
        return zzFv();
    }

    public final boolean zzFs()
    {
        return zzFv() != 0;
    }

    public final int zzFt()
    {
        return zzlB(zzFv());
    }

    public final long zzFu()
    {
        return zzX(zzFw());
    }

    public final int zzFv()
    {
        int i = zzFC();
        if (i < 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i &= 0x7f;
        byte byte0 = zzFC();
        if (byte0 >= 0)
        {
            return i | byte0 << 7;
        }
        i |= (byte0 & 0x7f) << 7;
        byte0 = zzFC();
        if (byte0 >= 0)
        {
            return i | byte0 << 14;
        }
        i |= (byte0 & 0x7f) << 14;
        int k = zzFC();
        if (k >= 0)
        {
            return i | k << 21;
        }
        byte0 = zzFC();
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
                    if (zzFC() >= 0)
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw zzsd.zzFL();
    }

    public final long zzFw()
    {
        int i = 0;
        long l = 0L;
        for (; i < 64; i += 7)
        {
            byte byte0 = zzFC();
            l |= (long)(byte0 & 0x7f) << i;
            if ((byte0 & 0x80) == 0)
            {
                return l;
            }
        }

        throw zzsd.zzFL();
    }

    public final int zzFx()
    {
        return zzFC() & 0xff | (zzFC() & 0xff) << 8 | (zzFC() & 0xff) << 16 | (zzFC() & 0xff) << 24;
    }

    public final long zzFy()
    {
        int i = zzFC();
        int j = zzFC();
        int k = zzFC();
        int l = zzFC();
        int i1 = zzFC();
        int j1 = zzFC();
        int k1 = zzFC();
        int l1 = zzFC();
        long l2 = i;
        return ((long)j & 255L) << 8 | l2 & 255L | ((long)k & 255L) << 16 | ((long)l & 255L) << 24 | ((long)i1 & 255L) << 32 | ((long)j1 & 255L) << 40 | ((long)k1 & 255L) << 48 | ((long)l1 & 255L) << 56;
    }

    public final void zza(zzse zzse1)
    {
        int i = zzFv();
        if (zzbig >= zzbih)
        {
            throw zzsd.zzFP();
        } else
        {
            i = zzlC(i);
            zzbig = zzbig + 1;
            zzse1.zzb(this);
            zzlz(0);
            zzbig = zzbig - 1;
            zzlD(i);
            return;
        }
    }

    public final void zza(zzse zzse1, int i)
    {
        if (zzbig >= zzbih)
        {
            throw zzsd.zzFP();
        } else
        {
            zzbig = zzbig + 1;
            zzse1.zzb(this);
            zzlz(zzsh.zzD(i, 4));
            zzbig = zzbig - 1;
            return;
        }
    }

    public final boolean zzlA(int i)
    {
        switch (zzsh.zzlU(i))
        {
        default:
            throw zzsd.zzFO();

        case 0: // '\0'
            zzFr();
            return true;

        case 1: // '\001'
            zzFy();
            return true;

        case 2: // '\002'
            zzlG(zzFv());
            return true;

        case 3: // '\003'
            zzFp();
            zzlz(zzsh.zzD(zzsh.zzlV(i), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            zzFx();
            break;
        }
        return true;
    }

    public final int zzlC(int i)
    {
        if (i < 0)
        {
            throw zzsd.zzFK();
        }
        i = zzbid + i;
        int j = zzbif;
        if (i > j)
        {
            throw zzsd.zzFJ();
        } else
        {
            zzbif = i;
            zzFz();
            return j;
        }
    }

    public final void zzlD(int i)
    {
        zzbif = i;
        zzFz();
    }

    public final void zzlE(int i)
    {
        if (i > zzbid - zzbia)
        {
            throw new IllegalArgumentException((new StringBuilder("Position ")).append(i).append(" is beyond current ").append(zzbid - zzbia).toString());
        }
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad position ")).append(i).toString());
        } else
        {
            zzbid = zzbia + i;
            return;
        }
    }

    public final byte[] zzlF(int i)
    {
        if (i < 0)
        {
            throw zzsd.zzFK();
        }
        if (zzbid + i > zzbif)
        {
            zzlG(zzbif - zzbid);
            throw zzsd.zzFJ();
        }
        if (i <= zzbib - zzbid)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(buffer, zzbid, abyte0, 0, i);
            zzbid = zzbid + i;
            return abyte0;
        } else
        {
            throw zzsd.zzFJ();
        }
    }

    public final void zzlG(int i)
    {
        if (i < 0)
        {
            throw zzsd.zzFK();
        }
        if (zzbid + i > zzbif)
        {
            zzlG(zzbif - zzbid);
            throw zzsd.zzFJ();
        }
        if (i <= zzbib - zzbid)
        {
            zzbid = zzbid + i;
            return;
        } else
        {
            throw zzsd.zzFJ();
        }
    }

    public final void zzlz(int i)
    {
        if (zzbie != i)
        {
            throw zzsd.zzFN();
        } else
        {
            return;
        }
    }

    public final byte[] zzx(int i, int j)
    {
        if (j == 0)
        {
            return zzsh.zzbiE;
        } else
        {
            byte abyte0[] = new byte[j];
            int k = zzbia;
            System.arraycopy(buffer, k + i, abyte0, 0, j);
            return abyte0;
        }
    }
}
