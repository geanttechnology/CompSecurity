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
//            zzag

public class GetChangesRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzag();
    final int mVersionCode;
    final List zzahq;
    private final Set zzahr;
    final ChangeSequenceNumber zzajm;
    final int zzajn;

    GetChangesRequest(int i, ChangeSequenceNumber changesequencenumber, int j, List list)
    {
        Object obj;
        if (list == null)
        {
            obj = null;
        } else
        {
            obj = new HashSet(list);
        }
        this(i, changesequencenumber, j, list, ((Set) (obj)));
    }

    private GetChangesRequest(int i, ChangeSequenceNumber changesequencenumber, int j, List list, Set set)
    {
        mVersionCode = i;
        zzajm = changesequencenumber;
        zzajn = j;
        zzahq = list;
        zzahr = set;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzag.zza(this, parcel, i);
    }

}
