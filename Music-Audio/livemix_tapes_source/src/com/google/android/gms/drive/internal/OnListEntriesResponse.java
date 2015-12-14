// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbc

public class OnListEntriesResponse extends WriteAwareParcelable
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbc();
    final int mVersionCode;
    final boolean zzaio;
    final DataHolder zzajT;

    OnListEntriesResponse(int i, DataHolder dataholder, boolean flag)
    {
        mVersionCode = i;
        zzajT = dataholder;
        zzaio = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    protected void zzI(Parcel parcel, int i)
    {
        zzbc.zza(this, parcel, i);
    }

    public DataHolder zzqT()
    {
        return zzajT;
    }

    public boolean zzqU()
    {
        return zzaio;
    }

}
