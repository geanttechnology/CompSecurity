// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            zzf, Operator

public class zzg
    implements zzf
{

    private Boolean zzaoi;

    private zzg()
    {
        zzaoi = Boolean.valueOf(false);
    }

    public static boolean zza(Filter filter)
    {
        if (filter == null)
        {
            return false;
        } else
        {
            return ((Boolean)filter.zza(new zzg())).booleanValue();
        }
    }

    public Object zzb(zzb zzb1, Object obj)
    {
        return zzc(zzb1, obj);
    }

    public Object zzb(Operator operator, MetadataField metadatafield, Object obj)
    {
        return zzc(operator, metadatafield, obj);
    }

    public Object zzb(Operator operator, List list)
    {
        return zzc(operator, list);
    }

    public Boolean zzc(zzb zzb1, Object obj)
    {
        return zzaoi;
    }

    public Boolean zzc(Operator operator, MetadataField metadatafield, Object obj)
    {
        return zzaoi;
    }

    public Boolean zzc(Operator operator, List list)
    {
        return zzaoi;
    }

    public Object zzcL(String s)
    {
        return zzcM(s);
    }

    public Boolean zzcM(String s)
    {
        if (!s.isEmpty())
        {
            zzaoi = Boolean.valueOf(true);
        }
        return zzaoi;
    }

    public Boolean zzd(Boolean boolean1)
    {
        return zzaoi;
    }

    public Object zzd(MetadataField metadatafield, Object obj)
    {
        return zze(metadatafield, obj);
    }

    public Boolean zze(MetadataField metadatafield, Object obj)
    {
        return zzaoi;
    }

    public Object zze(MetadataField metadatafield)
    {
        return zzf(metadatafield);
    }

    public Boolean zzf(MetadataField metadatafield)
    {
        return zzaoi;
    }

    public Object zzrU()
    {
        return zzrX();
    }

    public Object zzrV()
    {
        return zzrW();
    }

    public Boolean zzrW()
    {
        return zzaoi;
    }

    public Boolean zzrX()
    {
        return zzaoi;
    }

    public Object zzx(Object obj)
    {
        return zzd((Boolean)obj);
    }
}
