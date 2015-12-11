// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzaf, zzsc, zzsa, 
//            zzrx, zzrw, zzse

public static final class zzI extends zzry
{

    private static volatile  zzic[];
    public int key;
    public int value;

    public static zzI[] zzH()
    {
        if (zzic == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzic == null)
                {
                    zzic = new zzic[0];
                }
            }
        }
        return zzic;
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
        if (!(obj instanceof zzic)) goto _L4; else goto _L3
_L3:
        obj = (zzic)obj;
        flag = flag1;
        if (key != ((key) (obj)).key) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (value != ((value) (obj)).value) goto _L4; else goto _L6
_L6:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (((pty) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzbik) (obj)).zzbik.isEmpty()) goto _L4; else goto _L7
_L7:
        return true;
        return zzbik.equals(((ls) (obj)).zzbik);
    }

    public int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = key;
        int l = value;
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + (((j + 527) * 31 + k) * 31 + l) * 31;
    }

    protected int zzB()
    {
        return super.zzB() + zzrx.zzA(1, key) + zzrx.zzA(2, value);
    }

    public value zzI()
    {
        key = 0;
        value = 0;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        zzrx1.zzy(1, key);
        zzrx1.zzy(2, value);
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzf(zzrw1);
    }

    public zzf zzf(zzrw zzrw1)
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

            case 8: // '\b'
                key = zzrw1.zzFr();
                break;

            case 16: // '\020'
                value = zzrw1.zzFr();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzI();
    }
}
