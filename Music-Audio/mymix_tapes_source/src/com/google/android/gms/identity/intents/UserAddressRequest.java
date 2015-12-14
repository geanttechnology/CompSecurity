// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.identity.intents:
//            zza

public final class UserAddressRequest
    implements SafeParcelable
{
    public final class Builder
    {

        final UserAddressRequest zzaAA;

        public Builder addAllowedCountrySpecification(CountrySpecification countryspecification)
        {
            if (zzaAA.zzaAz == null)
            {
                zzaAA.zzaAz = new ArrayList();
            }
            zzaAA.zzaAz.add(countryspecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection collection)
        {
            if (zzaAA.zzaAz == null)
            {
                zzaAA.zzaAz = new ArrayList();
            }
            zzaAA.zzaAz.addAll(collection);
            return this;
        }

        public UserAddressRequest build()
        {
            if (zzaAA.zzaAz != null)
            {
                zzaAA.zzaAz = Collections.unmodifiableList(zzaAA.zzaAz);
            }
            return zzaAA;
        }

        private Builder()
        {
            zzaAA = UserAddressRequest.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    List zzaAz;

    UserAddressRequest()
    {
        mVersionCode = 1;
    }

    UserAddressRequest(int i, List list)
    {
        mVersionCode = i;
        zzaAz = list;
    }

    public static Builder newBuilder()
    {
        UserAddressRequest useraddressrequest = new UserAddressRequest();
        useraddressrequest.getClass();
        return useraddressrequest. new Builder();
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
        zza.zza(this, parcel, i);
    }

}
