// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsd, zzse, zzsa, 
//            zzrx, zzrw

public interface zzqz
{
    public static final class zza extends zzry
    {

        public long zzbai;
        public zzaf.zzj zzbaj;
        public zzaf.zzf zziR;

        public static zza zzw(byte abyte0[])
            throws zzsd
        {
            return (zza)zzse.zza(new zza(), abyte0);
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
            if (!(obj instanceof zza)) goto _L4; else goto _L3
_L3:
            obj = (zza)obj;
            flag = flag1;
            if (zzbai != ((zza) (obj)).zzbai) goto _L4; else goto _L5
_L5:
            if (zziR != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((zza) (obj)).zziR != null) goto _L4; else goto _L8
_L8:
            if (zzbaj != null) goto _L10; else goto _L9
_L9:
            flag = flag1;
            if (((zza) (obj)).zzbaj != null) goto _L4; else goto _L11
_L11:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_141;
            }
            if (((zza) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zza) (obj)).zzbik.isEmpty()) goto _L4; else goto _L12
_L12:
            return true;
_L7:
            if (!zziR.equals(((zza) (obj)).zziR))
            {
                return false;
            }
              goto _L8
_L10:
            if (!zzbaj.equals(((zza) (obj)).zzbaj))
            {
                return false;
            }
              goto _L11
            return zzbik.equals(((zza) (obj)).zzbik);
              goto _L8
        }

        public int hashCode()
        {
            boolean flag = false;
            int l = getClass().getName().hashCode();
            int i1 = (int)(zzbai ^ zzbai >>> 32);
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
            if (zzbaj == null)
            {
                j = 0;
            } else
            {
                j = zzbaj.hashCode();
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
            int j = super.zzB() + zzrx.zzd(1, zzbai);
            int i = j;
            if (zziR != null)
            {
                i = j + zzrx.zzc(2, zziR);
            }
            j = i;
            if (zzbaj != null)
            {
                j = i + zzrx.zzc(3, zzbaj);
            }
            return j;
        }

        public zza zzDY()
        {
            zzbai = 0L;
            zziR = null;
            zzbaj = null;
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            zzrx1.zzb(1, zzbai);
            if (zziR != null)
            {
                zzrx1.zza(2, zziR);
            }
            if (zzbaj != null)
            {
                zzrx1.zza(3, zzbaj);
            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzz(zzrw1);
        }

        public zza zzz(zzrw zzrw1)
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
                    zzbai = zzrw1.zzFq();
                    break;

                case 18: // '\022'
                    if (zziR == null)
                    {
                        zziR = new zzaf.zzf();
                    }
                    zzrw1.zza(zziR);
                    break;

                case 26: // '\032'
                    if (zzbaj == null)
                    {
                        zzbaj = new zzaf.zzj();
                    }
                    zzrw1.zza(zzbaj);
                    break;
                }
            } while (true);
        }

        public zza()
        {
            zzDY();
        }
    }

}
