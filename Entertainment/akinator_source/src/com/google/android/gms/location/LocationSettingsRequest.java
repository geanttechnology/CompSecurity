// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            zzf, LocationRequest

public final class LocationSettingsRequest
    implements SafeParcelable
{
    public static final class Builder
    {

        private boolean zzaEL;
        private boolean zzaEM;
        private boolean zzaEN;
        private final ArrayList zzaEO = new ArrayList();

        public Builder addAllLocationRequests(Collection collection)
        {
            zzaEO.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationrequest)
        {
            zzaEO.add(locationrequest);
            return this;
        }

        public LocationSettingsRequest build()
        {
            return new LocationSettingsRequest(zzaEO, zzaEL, zzaEM, zzaEN);
        }

        public Builder setAlwaysShow(boolean flag)
        {
            zzaEL = flag;
            return this;
        }

        public Builder setNeedBle(boolean flag)
        {
            zzaEM = flag;
            return this;
        }

        public Builder()
        {
            zzaEL = false;
            zzaEM = false;
            zzaEN = false;
        }
    }


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
        zzf.zza(this, parcel, i);
    }

    public List zztd()
    {
        return Collections.unmodifiableList(zzasK);
    }

    public boolean zzwx()
    {
        return zzaEL;
    }

    public boolean zzwy()
    {
        return zzaEM;
    }

    public boolean zzwz()
    {
        return zzaEN;
    }

}
