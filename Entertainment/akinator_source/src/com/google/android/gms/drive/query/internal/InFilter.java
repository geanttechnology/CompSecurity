// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            AbstractFilter, zzj, zze, zzf

public class InFilter extends AbstractFilter
{

    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final MetadataBundle zzanW;
    private final zzb zzaoj;

    InFilter(int i, MetadataBundle metadatabundle)
    {
        mVersionCode = i;
        zzanW = metadatabundle;
        zzaoj = (zzb)com.google.android.gms.drive.query.internal.zze.zzb(metadatabundle);
    }

    public InFilter(SearchableCollectionMetadataField searchablecollectionmetadatafield, Object obj)
    {
        this(1, MetadataBundle.zza(searchablecollectionmetadatafield, Collections.singleton(obj)));
    }

    public int describeContents()
    {
        return 0;
    }

    public Object getValue()
    {
        return ((Collection)zzanW.zza(zzaoj)).iterator().next();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

    public Object zza(zzf zzf1)
    {
        return zzf1.zzb(zzaoj, getValue());
    }

}
