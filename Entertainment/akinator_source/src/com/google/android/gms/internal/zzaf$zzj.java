// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzaf, zzsd, zzse, 
//            zzsc, zzsa, zzrx, zzrw, 
//            zzsh

public static final class zzP extends zzry
{

    public String zziQ[];
    public String zziR;
    public String zziS;

    public static zzP zzd(byte abyte0[])
        throws zzsd
    {
        return (zzP)zzse.zza(new <init>(), abyte0);
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
        if (!(obj instanceof <init>)) goto _L4; else goto _L3
_L3:
        obj = (<init>)obj;
        flag = flag1;
        if (!zzsc.equals(zziQ, ((zziQ) (obj)).zziQ)) goto _L4; else goto _L5
_L5:
        if (zziR != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((zziR) (obj)).zziR != null) goto _L4; else goto _L8
_L8:
        if (zziS != null) goto _L10; else goto _L9
_L9:
        flag = flag1;
        if (((zziS) (obj)).zziS != null) goto _L4; else goto _L11
_L11:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_143;
        }
        if (((pty) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzbik) (obj)).zzbik.isEmpty()) goto _L4; else goto _L12
_L12:
        return true;
_L7:
        if (!zziR.equals(((equals) (obj)).zziR))
        {
            return false;
        }
          goto _L8
_L10:
        if (!zziS.equals(((zziS) (obj)).zziS))
        {
            return false;
        }
          goto _L11
        return zzbik.equals(((ls) (obj)).zzbik);
          goto _L8
    }

    public int hashCode()
    {
        boolean flag = false;
        int l = getClass().getName().hashCode();
        int i1 = zzsc.hashCode(zziQ);
        int i;
        int j;
        int k;
        if (zziR == null)
        {
            i = 0;
        } else
        {
            i = zziR.hashCode();
        }
        if (zziS == null)
        {
            j = 0;
        } else
        {
            j = zziS.hashCode();
        }
        k = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                k = ((flag) ? 1 : 0);
            } else
            {
                k = zzbik.hashCode();
            }
        }
        return (j + (i + ((l + 527) * 31 + i1) * 31) * 31) * 31 + k;
    }

    protected int zzB()
    {
        int i = super.zzB();
        int j = i;
        if (zziQ != null)
        {
            j = i;
            if (zziQ.length > 0)
            {
                int k = 0;
                do
                {
                    j = i;
                    if (k >= zziQ.length)
                    {
                        break;
                    }
                    Code code = zziQ[k];
                    j = i;
                    if (code != null)
                    {
                        j = i + zzrx.zzc(1, code);
                    }
                    k++;
                    i = j;
                } while (true);
            }
        }
        i = j;
        if (zziR != null)
        {
            i = j + zzrx.zzc(2, zziR);
        }
        j = i;
        if (!zziS.equals(""))
        {
            j = i + zzrx.zzn(3, zziS);
        }
        return j;
    }

    public zziS zzP()
    {
        zziQ = zzN();
        zziR = null;
        zziS = "";
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        if (zziQ != null && zziQ.length > 0)
        {
            for (int i = 0; i < zziQ.length; i++)
            {
                zzbiv zzbiv = zziQ[i];
                if (zzbiv != null)
                {
                    zzrx1.zza(1, zzbiv);
                }
            }

        }
        if (zziR != null)
        {
            zzrx1.zza(2, zziR);
        }
        if (!zziS.equals(""))
        {
            zzrx1.zzb(3, zziS);
        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzk(zzrw1);
    }

    public zzk zzk(zzrw zzrw1)
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
                int k = zzsh.zzc(zzrw1, 10);
                zzk azzk[];
                int j;
                if (zziQ == null)
                {
                    j = 0;
                } else
                {
                    j = zziQ.length;
                }
                azzk = new zziQ[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zziQ, 0, azzk, 0, j);
                    k = j;
                }
                for (; k < azzk.length - 1; k++)
                {
                    azzk[k] = new <init>();
                    zzrw1.zza(azzk[k]);
                    zzrw1.zzFo();
                }

                azzk[k] = new <init>();
                zzrw1.zza(azzk[k]);
                zziQ = azzk;
                break;

            case 18: // '\022'
                if (zziR == null)
                {
                    zziR = new <init>();
                }
                zzrw1.zza(zziR);
                break;

            case 26: // '\032'
                zziS = zzrw1.readString();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzP();
    }
}
