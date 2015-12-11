// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzse

public final class zzwe extends zzry
{

    private static volatile zzbiv zzaCV[];
    public int viewId;
    public String zzaCW;
    public String zzaCX;

    public static zzwe[] zzwd()
    {
        if (zzaCV == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzaCV == null)
                {
                    zzaCV = new zzaCV[0];
                }
            }
        }
        return zzaCV;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzaCV))
            {
                return false;
            }
            obj = (zzaCV)obj;
            if (zzaCW == null)
            {
                if (((zzaCW) (obj)).zzaCW != null)
                {
                    return false;
                }
            } else
            if (!zzaCW.equals(((zzaCW) (obj)).zzaCW))
            {
                return false;
            }
            if (zzaCX == null)
            {
                if (((zzaCX) (obj)).zzaCX != null)
                {
                    return false;
                }
            } else
            if (!zzaCX.equals(((zzaCX) (obj)).zzaCX))
            {
                return false;
            }
            if (viewId != ((viewId) (obj)).viewId)
            {
                return false;
            }
            if (zzbik == null || zzbik.isEmpty())
            {
                if (((zzbik) (obj)).zzbik != null && !((zzbik) (obj)).zzbik.isEmpty())
                {
                    return false;
                }
            } else
            {
                return zzbik.equals(((zzbik) (obj)).zzbik);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        boolean flag = false;
        int l = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int i1;
        if (zzaCW == null)
        {
            i = 0;
        } else
        {
            i = zzaCW.hashCode();
        }
        if (zzaCX == null)
        {
            j = 0;
        } else
        {
            j = zzaCX.hashCode();
        }
        i1 = viewId;
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
        return ((j + (i + (l + 527) * 31) * 31) * 31 + i1) * 31 + k;
    }

    protected final int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!zzaCW.equals(""))
        {
            i = j + zzrx.zzn(1, zzaCW);
        }
        j = i;
        if (!zzaCX.equals(""))
        {
            j = i + zzrx.zzn(2, zzaCX);
        }
        i = j;
        if (viewId != 0)
        {
            i = j + zzrx.zzA(3, viewId);
        }
        return i;
    }

    public final void zza(zzrx zzrx1)
    {
        if (!zzaCW.equals(""))
        {
            zzrx1.zzb(1, zzaCW);
        }
        if (!zzaCX.equals(""))
        {
            zzrx1.zzb(2, zzaCX);
        }
        if (viewId != 0)
        {
            zzrx1.zzy(3, viewId);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzq(zzrw1);
    }

    public final zzq zzq(zzrw zzrw1)
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
                zzaCW = zzrw1.readString();
                break;

            case 18: // '\022'
                zzaCX = zzrw1.readString();
                break;

            case 24: // '\030'
                viewId = zzrw1.zzFr();
                break;
            }
        } while (true);
    }

    public final viewId zzwe()
    {
        zzaCW = "";
        zzaCX = "";
        viewId = 0;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public ()
    {
        zzwe();
    }
}
