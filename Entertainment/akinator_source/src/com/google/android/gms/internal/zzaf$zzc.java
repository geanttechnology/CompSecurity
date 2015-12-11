// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzaf, zzsc, zzsa, 
//            zzrx, zzrw, zzse

public static final class zzF extends zzry
{

    private static volatile  zzhU[];
    public String key;
    public long zzhV;
    public long zzhW;
    public boolean zzhX;
    public long zzhY;

    public static zzF[] zzE()
    {
        if (zzhU == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzhU == null)
                {
                    zzhU = new zzhU[0];
                }
            }
        }
        return zzhU;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
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
        if (!(obj instanceof zzhU)) goto _L4; else goto _L3
_L3:
        obj = (zzhU)obj;
        if (key != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        flag = flag1;
        if (((key) (obj)).key != null) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (zzhV != ((zzhV) (obj)).zzhV) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (zzhW != ((zzhW) (obj)).zzhW) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (zzhX != ((zzhX) (obj)).zzhX) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (zzhY != ((zzhY) (obj)).zzhY) goto _L4; else goto _L9
_L9:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (((pty) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzbik) (obj)).zzbik.isEmpty()) goto _L4; else goto _L10
_L10:
        return true;
        if (!key.equals(((key) (obj)).key))
        {
            return false;
        }
          goto _L5
        return zzbik.equals(((ls) (obj)).zzbik);
    }

    public int hashCode()
    {
        boolean flag = false;
        int k = getClass().getName().hashCode();
        int i;
        char c;
        int j;
        int l;
        int i1;
        int j1;
        if (key == null)
        {
            i = 0;
        } else
        {
            i = key.hashCode();
        }
        l = (int)(zzhV ^ zzhV >>> 32);
        i1 = (int)(zzhW ^ zzhW >>> 32);
        if (zzhX)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        j1 = (int)(zzhY ^ zzhY >>> 32);
        j = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = zzbik.hashCode();
            }
        }
        return ((c + (((i + (k + 527) * 31) * 31 + l) * 31 + i1) * 31) * 31 + j1) * 31 + j;
    }

    protected int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!key.equals(""))
        {
            i = j + zzrx.zzn(1, key);
        }
        j = i;
        if (zzhV != 0L)
        {
            j = i + zzrx.zzd(2, zzhV);
        }
        i = j;
        if (zzhW != 0x7fffffffL)
        {
            i = j + zzrx.zzd(3, zzhW);
        }
        j = i;
        if (zzhX)
        {
            j = i + zzrx.zzc(4, zzhX);
        }
        i = j;
        if (zzhY != 0L)
        {
            i = j + zzrx.zzd(5, zzhY);
        }
        return i;
    }

    public zzhY zzF()
    {
        key = "";
        zzhV = 0L;
        zzhW = 0x7fffffffL;
        zzhX = false;
        zzhY = 0L;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        if (!key.equals(""))
        {
            zzrx1.zzb(1, key);
        }
        if (zzhV != 0L)
        {
            zzrx1.zzb(2, zzhV);
        }
        if (zzhW != 0x7fffffffL)
        {
            zzrx1.zzb(3, zzhW);
        }
        if (zzhX)
        {
            zzrx1.zzb(4, zzhX);
        }
        if (zzhY != 0L)
        {
            zzrx1.zzb(5, zzhY);
        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzd(zzrw1);
    }

    public zzd zzd(zzrw zzrw1)
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
                key = zzrw1.readString();
                break;

            case 16: // '\020'
                zzhV = zzrw1.zzFq();
                break;

            case 24: // '\030'
                zzhW = zzrw1.zzFq();
                break;

            case 32: // ' '
                zzhX = zzrw1.zzFs();
                break;

            case 40: // '('
                zzhY = zzrw1.zzFq();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzF();
    }
}
