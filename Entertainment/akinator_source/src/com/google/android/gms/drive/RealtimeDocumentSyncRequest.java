// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive:
//            zzj

public class RealtimeDocumentSyncRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzj();
    final int mVersionCode;
    final List zzajp;
    final List zzajq;

    RealtimeDocumentSyncRequest(int i, List list, List list1)
    {
        mVersionCode = i;
        zzajp = (List)zzx.zzw(list);
        zzajq = (List)zzx.zzw(list1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

}
