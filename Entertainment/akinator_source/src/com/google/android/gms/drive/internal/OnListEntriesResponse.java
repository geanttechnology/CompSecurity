// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbd

public class OnListEntriesResponse extends WriteAwareParcelable
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbd();
    final int mVersionCode;
    final boolean zzakB;
    final DataHolder zzamk;

    OnListEntriesResponse(int i, DataHolder dataholder, boolean flag)
    {
        mVersionCode = i;
        zzamk = dataholder;
        zzakB = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    protected void zzJ(Parcel parcel, int i)
    {
        zzbd.zza(this, parcel, i);
    }

    public DataHolder zzrB()
    {
        return zzamk;
    }

    public boolean zzrC()
    {
        return zzakB;
    }

}
