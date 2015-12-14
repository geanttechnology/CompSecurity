// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzcg, zzce

public class zzcc
{

    public static zzce zza(zzcg zzcg1, long l)
    {
        if (zzcg1 == null)
        {
            return null;
        } else
        {
            return zzcg1.zzb(l);
        }
    }

    public static transient boolean zza(zzcg zzcg1, zzce zzce, long l, String as[])
    {
        if (zzcg1 == null || zzce == null)
        {
            return false;
        } else
        {
            return zzcg1.zza(zzce, l, as);
        }
    }

    public static transient boolean zza(zzcg zzcg1, zzce zzce, String as[])
    {
        if (zzcg1 == null || zzce == null)
        {
            return false;
        } else
        {
            return zzcg1.zza(zzce, as);
        }
    }

    public static zzce zzb(zzcg zzcg1)
    {
        if (zzcg1 == null)
        {
            return null;
        } else
        {
            return zzcg1.zzdn();
        }
    }
}
