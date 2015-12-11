// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbh

public class OnResourceIdSetResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbh();
    private final int mVersionCode;
    private final List zzakb;

    OnResourceIdSetResponse(int i, List list)
    {
        mVersionCode = i;
        zzakb = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzbh.zza(this, parcel, i);
    }

    public List zzrk()
    {
        return zzakb;
    }

}
