// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.identity.intents:
//            zza

public final class UserAddressRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    List zzaDh;

    UserAddressRequest()
    {
        mVersionCode = 1;
    }

    UserAddressRequest(int i, List list)
    {
        mVersionCode = i;
        zzaDh = list;
    }

    public static Builder newBuilder()
    {
        UserAddressRequest useraddressrequest = new UserAddressRequest();
        useraddressrequest.getClass();
        return useraddressrequest. new Builder(null);
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
        zza.zza(this, parcel, i);
    }


    private class Builder
    {

        final UserAddressRequest zzaDi;

        public final Builder addAllowedCountrySpecification(CountrySpecification countryspecification)
        {
            if (zzaDi.zzaDh == null)
            {
                zzaDi.zzaDh = new ArrayList();
            }
            zzaDi.zzaDh.add(countryspecification);
            return this;
        }

        public final Builder addAllowedCountrySpecifications(Collection collection)
        {
            if (zzaDi.zzaDh == null)
            {
                zzaDi.zzaDh = new ArrayList();
            }
            zzaDi.zzaDh.addAll(collection);
            return this;
        }

        public final UserAddressRequest build()
        {
            if (zzaDi.zzaDh != null)
            {
                zzaDi.zzaDh = Collections.unmodifiableList(zzaDi.zzaDh);
            }
            return zzaDi;
        }

        private Builder()
        {
            zzaDi = UserAddressRequest.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
