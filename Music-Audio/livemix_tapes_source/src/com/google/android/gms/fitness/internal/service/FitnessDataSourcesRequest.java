// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.internal.service:
//            zza

public class FitnessDataSourcesRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    private final List zzanw;

    FitnessDataSourcesRequest(int i, List list)
    {
        mVersionCode = i;
        zzanw = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getDataTypes()
    {
        return Collections.unmodifiableList(zzanw);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("dataTypes", zzanw).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
