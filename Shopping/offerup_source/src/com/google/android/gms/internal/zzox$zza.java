// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzsh, zzse

public final class zzwc extends zzry
{

    public zza zzaCU[];

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzwc))
            {
                return false;
            }
            obj = (zzwc)obj;
            if (!zzsc.equals(zzaCU, ((zzaCU) (obj)).zzaCU))
            {
                return false;
            }
            if (zzbik == null || zzbik.isEmpty())
            {
                if (((pty) (obj)).zzbik != null && !((zzbik) (obj)).zzbik.isEmpty())
                {
                    return false;
                }
            } else
            {
                return zzbik.equals(((ls) (obj)).zzbik);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = zzsc.hashCode(zzaCU);
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + ((j + 527) * 31 + k) * 31;
    }

    protected final int zzB()
    {
        int i = super.zzB();
        int k = i;
        if (zzaCU != null)
        {
            k = i;
            if (zzaCU.length > 0)
            {
                int j = 0;
                do
                {
                    k = i;
                    if (j >= zzaCU.length)
                    {
                        break;
                    }
                    zza zza1 = zzaCU[j];
                    k = i;
                    if (zza1 != null)
                    {
                        k = i + zzrx.zzc(1, zza1);
                    }
                    j++;
                    i = k;
                } while (true);
            }
        }
        return k;
    }

    public final void zza(zzrx zzrx1)
    {
        if (zzaCU != null && zzaCU.length > 0)
        {
            for (int i = 0; i < zzaCU.length; i++)
            {
                zza zza1 = zzaCU[i];
                if (zza1 != null)
                {
                    zzrx1.zza(1, zza1);
                }
            }

        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzp(zzrw1);
    }

    public final zzp zzp(zzrw zzrw1)
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
                class zza extends zzry
                {

                    private static volatile zza zzaCV[];
                    public int viewId;
                    public String zzaCW;
                    public String zzaCX;

                    public static zza[] zzwd()
                    {
                        if (zzaCV == null)
                        {
                            synchronized (zzsc.zzbiu)
                            {
                                if (zzaCV == null)
                                {
                                    zzaCV = new zza[0];
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
                            if (!(obj instanceof zza))
                            {
                                return false;
                            }
                            obj = (zza)obj;
                            if (zzaCW == null)
                            {
                                if (((zza) (obj)).zzaCW != null)
                                {
                                    return false;
                                }
                            } else
                            if (!zzaCW.equals(((zza) (obj)).zzaCW))
                            {
                                return false;
                            }
                            if (zzaCX == null)
                            {
                                if (((zza) (obj)).zzaCX != null)
                                {
                                    return false;
                                }
                            } else
                            if (!zzaCX.equals(((zza) (obj)).zzaCX))
                            {
                                return false;
                            }
                            if (viewId != ((zza) (obj)).viewId)
                            {
                                return false;
                            }
                            if (zzbik == null || zzbik.isEmpty())
                            {
                                if (((zza) (obj)).zzbik != null && !((zza) (obj)).zzbik.isEmpty())
                                {
                                    return false;
                                }
                            } else
                            {
                                return zzbik.equals(((zza) (obj)).zzbik);
                            }
                        }
                        return true;
                    }

                    public final int hashCode()
                    {
                        boolean flag = false;
                        int k1 = getClass().getName().hashCode();
                        int l;
                        int i1;
                        int j1;
                        int l1;
                        if (zzaCW == null)
                        {
                            l = 0;
                        } else
                        {
                            l = zzaCW.hashCode();
                        }
                        if (zzaCX == null)
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = zzaCX.hashCode();
                        }
                        l1 = viewId;
                        j1 = ((flag) ? 1 : 0);
                        if (zzbik != null)
                        {
                            if (zzbik.isEmpty())
                            {
                                j1 = ((flag) ? 1 : 0);
                            } else
                            {
                                j1 = zzbik.hashCode();
                            }
                        }
                        return ((i1 + (l + (k1 + 527) * 31) * 31) * 31 + l1) * 31 + j1;
                    }

                    protected final int zzB()
                    {
                        int i1 = super.zzB();
                        int l = i1;
                        if (!zzaCW.equals(""))
                        {
                            l = i1 + zzrx.zzn(1, zzaCW);
                        }
                        i1 = l;
                        if (!zzaCX.equals(""))
                        {
                            i1 = l + zzrx.zzn(2, zzaCX);
                        }
                        l = i1;
                        if (viewId != 0)
                        {
                            l = i1 + zzrx.zzA(3, viewId);
                        }
                        return l;
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

                    public final zzse zzb(zzrw zzrw2)
                    {
                        return zzq(zzrw2);
                    }

                    public final zza zzq(zzrw zzrw2)
                    {
                        do
                        {
                            int l = zzrw2.zzFo();
                            switch (l)
                            {
                            default:
                                if (zza(zzrw2, l))
                                {
                                    continue;
                                }
                                // fall through

                            case 0: // '\0'
                                return this;

                            case 10: // '\n'
                                zzaCW = zzrw2.readString();
                                break;

                            case 18: // '\022'
                                zzaCX = zzrw2.readString();
                                break;

                            case 24: // '\030'
                                viewId = zzrw2.zzFr();
                                break;
                            }
                        } while (true);
                    }

                    public final zza zzwe()
                    {
                        zzaCW = "";
                        zzaCX = "";
                        viewId = 0;
                        zzbik = null;
                        zzbiv = -1;
                        return this;
                    }

            public zza()
            {
                zzwe();
            }
                }

                zza azza[];
                int j;
                if (zzaCU == null)
                {
                    j = 0;
                } else
                {
                    j = zzaCU.length;
                }
                azza = new zza[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaCU, 0, azza, 0, j);
                    k = j;
                }
                for (; k < azza.length - 1; k++)
                {
                    azza[k] = new zza();
                    zzrw1.zza(azza[k]);
                    zzrw1.zzFo();
                }

                azza[k] = new zza();
                zzrw1.zza(azza[k]);
                zzaCU = azza;
                break;
            }
        } while (true);
    }

    public final zzaCU zzwc()
    {
        zzaCU = zza.zzwd();
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public zza()
    {
        zzwc();
    }
}
