// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

// Referenced classes of package com.google.android.gms.nearby.connection:
//            zzb

public final class AppMetadata
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final List zzaJi;

    AppMetadata(int i, List list)
    {
        mVersionCode = i;
        zzaJi = (List)zzx.zzb(list, "Must specify application identifiers");
        zzx.zza(list.size(), "Application identifiers cannot be empty");
    }

    public AppMetadata(List list)
    {
        this(1, list);
    }

    public int describeContents()
    {
        return 0;
    }

    public List getAppIdentifiers()
    {
        return zzaJi;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
