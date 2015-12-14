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

    private Boolean zzalI;

    private zzg()
    {
        zzalI = Boolean.valueOf(false);
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
        return zzalI;
    }

    public Boolean zzc(Operator operator, MetadataField metadatafield, Object obj)
    {
        return zzalI;
    }

    public Boolean zzc(Operator operator, List list)
    {
        return zzalI;
    }

    public Object zzcM(String s)
    {
        return zzcN(s);
    }

    public Boolean zzcN(String s)
    {
        if (!s.isEmpty())
        {
            zzalI = Boolean.valueOf(true);
        }
        return zzalI;
    }

    public Boolean zzd(Boolean boolean1)
    {
        return zzalI;
    }

    public Object zzd(MetadataField metadatafield, Object obj)
    {
        return zze(metadatafield, obj);
    }

    public Boolean zze(MetadataField metadatafield, Object obj)
    {
        return zzalI;
    }

    public Object zze(MetadataField metadatafield)
    {
        return zzf(metadatafield);
    }

    public Boolean zzf(MetadataField metadatafield)
    {
        return zzalI;
    }

    public Object zzri()
    {
        return zzrl();
    }

    public Object zzrj()
    {
        return zzrk();
    }

    public Boolean zzrk()
    {
        return zzalI;
    }

    public Boolean zzrl()
    {
        return zzalI;
    }

    public Object zzw(Object obj)
    {
        return zzd((Boolean)obj);
    }
}
