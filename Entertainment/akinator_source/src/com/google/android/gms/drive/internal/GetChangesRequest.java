// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzah

public class GetChangesRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzah();
    final int mVersionCode;
    final List zzajA;
    private final Set zzajB;
    final ChangeSequenceNumber zzalA;
    final int zzalB;
    final boolean zzalC;

    private GetChangesRequest(int i, ChangeSequenceNumber changesequencenumber, int j, List list, Set set, boolean flag)
    {
        mVersionCode = i;
        zzalA = changesequencenumber;
        zzalB = j;
        zzajA = list;
        zzajB = set;
        zzalC = flag;
    }

    GetChangesRequest(int i, ChangeSequenceNumber changesequencenumber, int j, List list, boolean flag)
    {
        Object obj;
        if (list == null)
        {
            obj = null;
        } else
        {
            obj = new HashSet(list);
        }
        this(i, changesequencenumber, j, list, ((Set) (obj)), flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzah.zza(this, parcel, i);
    }

}
