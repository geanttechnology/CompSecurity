// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzau

public class OnChangesResponse extends WriteAwareParcelable
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzau();
    final int mVersionCode;
    final DataHolder zzajE;
    final List zzajF;
    final ChangeSequenceNumber zzajG;
    final boolean zzajH;

    OnChangesResponse(int i, DataHolder dataholder, List list, ChangeSequenceNumber changesequencenumber, boolean flag)
    {
        mVersionCode = i;
        zzajE = dataholder;
        zzajF = list;
        zzajG = changesequencenumber;
        zzajH = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    protected void zzI(Parcel parcel, int i)
    {
        zzau.zza(this, parcel, i | 1);
    }

}
