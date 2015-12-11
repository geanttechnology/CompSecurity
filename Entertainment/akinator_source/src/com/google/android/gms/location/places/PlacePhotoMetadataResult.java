// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location.places:
//            zzh, PlacePhotoMetadataBuffer

public class PlacePhotoMetadataResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    private final Status zzSC;
    final DataHolder zzaGq;
    private final PlacePhotoMetadataBuffer zzaGr;

    PlacePhotoMetadataResult(int i, Status status, DataHolder dataholder)
    {
        mVersionCode = i;
        zzSC = status;
        zzaGq = dataholder;
        if (dataholder == null)
        {
            zzaGr = null;
            return;
        } else
        {
            zzaGr = new PlacePhotoMetadataBuffer(zzaGq);
            return;
        }
    }

    public PlacePhotoMetadataResult(Status status, DataHolder dataholder)
    {
        this(0, status, dataholder);
    }

    public int describeContents()
    {
        return 0;
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata()
    {
        return zzaGr;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

}
