// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            zzf

public final class LocationSettingsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    private final boolean zzaEL;
    private final boolean zzaEM;
    private final boolean zzaEN;
    private final List zzasK;

    LocationSettingsRequest(int i, List list, boolean flag, boolean flag1, boolean flag2)
    {
        mVersionCode = i;
        zzasK = list;
        zzaEL = flag;
        zzaEM = flag1;
        zzaEN = flag2;
    }

    private LocationSettingsRequest(List list, boolean flag, boolean flag1, boolean flag2)
    {
        this(2, list, flag, flag1, flag2);
    }

    LocationSettingsRequest(List list, boolean flag, boolean flag1, boolean flag2, _cls1 _pcls1)
    {
        this(list, flag, flag1, flag2);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    public final List zztd()
    {
        return Collections.unmodifiableList(zzasK);
    }

    public final boolean zzwx()
    {
        return zzaEL;
    }

    public final boolean zzwy()
    {
        return zzaEM;
    }

    public final boolean zzwz()
    {
        return zzaEN;
    }

}
