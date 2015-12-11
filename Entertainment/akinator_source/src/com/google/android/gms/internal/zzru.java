// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsd, zzse, zzsc, 
//            zzsa, zzrx, zzrw, zzsh

public final class zzru extends zzry
{

    public String zzbhU[];
    public int zzbhV[];
    public byte zzbhW[][];

    public zzru()
    {
        zzFn();
    }

    public static zzru zzz(byte abyte0[])
        throws zzsd
    {
        return (zzru)zzse.zza(new zzru(), abyte0);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof zzru)) goto _L4; else goto _L3
_L3:
        obj = (zzru)obj;
        flag = flag1;
        if (!zzsc.equals(zzbhU, ((zzru) (obj)).zzbhU)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!zzsc.equals(zzbhV, ((zzru) (obj)).zzbhV)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!zzsc.zza(zzbhW, ((zzru) (obj)).zzbhW)) goto _L4; else goto _L7
_L7:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (((zzru) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzru) (obj)).zzbik.isEmpty()) goto _L4; else goto _L8
_L8:
        return true;
        return zzbik.equals(((zzru) (obj)).zzbik);
    }

    public int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = zzsc.hashCode(zzbhU);
        int l = zzsc.hashCode(zzbhV);
        int i1 = zzsc.zza(zzbhW);
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31;
    }

    protected int zzB()
    {
        boolean flag = false;
        int l2 = super.zzB();
        int j;
        int k;
        if (zzbhU != null && zzbhU.length > 0)
        {
            int i = 0;
            k = 0;
            int l;
            int k1;
            for (l = 0; i < zzbhU.length; l = k1)
            {
                String s = zzbhU[i];
                int i2 = k;
                k1 = l;
                if (s != null)
                {
                    k1 = l + 1;
                    i2 = k + zzrx.zzfA(s);
                }
                i++;
                k = i2;
            }

            k = l2 + k + l * 1;
        } else
        {
            k = l2;
        }
        j = k;
        if (zzbhV != null)
        {
            j = k;
            if (zzbhV.length > 0)
            {
                j = 0;
                int i1 = 0;
                for (; j < zzbhV.length; j++)
                {
                    i1 += zzrx.zzlJ(zzbhV[j]);
                }

                j = k + i1 + zzbhV.length * 1;
            }
        }
        k = j;
        if (zzbhW != null)
        {
            k = j;
            if (zzbhW.length > 0)
            {
                int j1 = 0;
                int l1 = 0;
                for (k = ((flag) ? 1 : 0); k < zzbhW.length;)
                {
                    byte abyte0[] = zzbhW[k];
                    int k2 = j1;
                    int j2 = l1;
                    if (abyte0 != null)
                    {
                        j2 = l1 + 1;
                        k2 = j1 + zzrx.zzE(abyte0);
                    }
                    k++;
                    j1 = k2;
                    l1 = j2;
                }

                k = j + j1 + l1 * 1;
            }
        }
        return k;
    }

    public zzru zzE(zzrw zzrw1)
        throws IOException
    {
        do
        {
            int i = zzrw1.zzFo();
            switch (i)
            {
            default:
                if (zza(zzrw1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int j1 = zzsh.zzc(zzrw1, 10);
                String as[];
                int j;
                if (zzbhU == null)
                {
                    j = 0;
                } else
                {
                    j = zzbhU.length;
                }
                as = new String[j1 + j];
                j1 = j;
                if (j != 0)
                {
                    System.arraycopy(zzbhU, 0, as, 0, j);
                    j1 = j;
                }
                for (; j1 < as.length - 1; j1++)
                {
                    as[j1] = zzrw1.readString();
                    zzrw1.zzFo();
                }

                as[j1] = zzrw1.readString();
                zzbhU = as;
                break;

            case 16: // '\020'
                int k1 = zzsh.zzc(zzrw1, 16);
                int ai[];
                int k;
                if (zzbhV == null)
                {
                    k = 0;
                } else
                {
                    k = zzbhV.length;
                }
                ai = new int[k1 + k];
                k1 = k;
                if (k != 0)
                {
                    System.arraycopy(zzbhV, 0, ai, 0, k);
                    k1 = k;
                }
                for (; k1 < ai.length - 1; k1++)
                {
                    ai[k1] = zzrw1.zzFr();
                    zzrw1.zzFo();
                }

                ai[k1] = zzrw1.zzFr();
                zzbhV = ai;
                break;

            case 18: // '\022'
                int j2 = zzrw1.zzlC(zzrw1.zzFv());
                int l = zzrw1.getPosition();
                int l1;
                for (l1 = 0; zzrw1.zzFA() > 0; l1++)
                {
                    zzrw1.zzFr();
                }

                zzrw1.zzlE(l);
                int ai1[];
                if (zzbhV == null)
                {
                    l = 0;
                } else
                {
                    l = zzbhV.length;
                }
                ai1 = new int[l1 + l];
                l1 = l;
                if (l != 0)
                {
                    System.arraycopy(zzbhV, 0, ai1, 0, l);
                    l1 = l;
                }
                for (; l1 < ai1.length; l1++)
                {
                    ai1[l1] = zzrw1.zzFr();
                }

                zzbhV = ai1;
                zzrw1.zzlD(j2);
                break;

            case 26: // '\032'
                int i2 = zzsh.zzc(zzrw1, 26);
                byte abyte0[][];
                int i1;
                if (zzbhW == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zzbhW.length;
                }
                abyte0 = new byte[i2 + i1][];
                i2 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zzbhW, 0, abyte0, 0, i1);
                    i2 = i1;
                }
                for (; i2 < abyte0.length - 1; i2++)
                {
                    abyte0[i2] = zzrw1.readBytes();
                    zzrw1.zzFo();
                }

                abyte0[i2] = zzrw1.readBytes();
                zzbhW = abyte0;
                break;
            }
        } while (true);
    }

    public zzru zzFn()
    {
        zzbhU = zzsh.zzbiC;
        zzbhV = zzsh.zzbix;
        zzbhW = zzsh.zzbiD;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        boolean flag = false;
        if (zzbhU != null && zzbhU.length > 0)
        {
            for (int i = 0; i < zzbhU.length; i++)
            {
                String s = zzbhU[i];
                if (s != null)
                {
                    zzrx1.zzb(1, s);
                }
            }

        }
        if (zzbhV != null && zzbhV.length > 0)
        {
            for (int j = 0; j < zzbhV.length; j++)
            {
                zzrx1.zzy(2, zzbhV[j]);
            }

        }
        if (zzbhW != null && zzbhW.length > 0)
        {
            for (int k = ((flag) ? 1 : 0); k < zzbhW.length; k++)
            {
                byte abyte0[] = zzbhW[k];
                if (abyte0 != null)
                {
                    zzrx1.zza(3, abyte0);
                }
            }

        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzE(zzrw1);
    }
}
