// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

// Referenced classes of package com.google.android.gms.fitness.internal.service:
//            zzb

public class FitnessUnregistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final DataSource zzapM;

    FitnessUnregistrationRequest(int i, DataSource datasource)
    {
        mVersionCode = i;
        zzapM = datasource;
    }

    public int describeContents()
    {
        return 0;
    }

    public DataSource getDataSource()
    {
        return zzapM;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[] {
            zzapM
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
