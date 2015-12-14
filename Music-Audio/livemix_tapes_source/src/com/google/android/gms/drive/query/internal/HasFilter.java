// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            AbstractFilter, zzi, zze, zzf

public class HasFilter extends AbstractFilter
{

    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    final MetadataBundle zzalw;
    final MetadataField zzalx;

    HasFilter(int i, MetadataBundle metadatabundle)
    {
        mVersionCode = i;
        zzalw = metadatabundle;
        zzalx = zze.zzb(metadatabundle);
    }

    public HasFilter(SearchableMetadataField searchablemetadatafield, Object obj)
    {
        this(1, MetadataBundle.zza(searchablemetadatafield, obj));
    }

    public int describeContents()
    {
        return 0;
    }

    public Object getValue()
    {
        return zzalw.zza(zzalx);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

    public Object zza(zzf zzf1)
    {
        return zzf1.zzd(zzalx, getValue());
    }

}
