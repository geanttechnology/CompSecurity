// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            SetUserDonationDetailsResponse

public static class _cls1 extends BaseApiResponse
{

    public static final android.os.ationDetailsResponseData CREATOR = new android.os.Parcelable.Creator() {

        public SetUserDonationDetailsResponse.SetUserDonationDetailsResponseData createFromParcel(Parcel parcel)
        {
            return (SetUserDonationDetailsResponse.SetUserDonationDetailsResponseData)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/givingworks/SetUserDonationDetailsResponse$SetUserDonationDetailsResponseData);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SetUserDonationDetailsResponse.SetUserDonationDetailsResponseData[] newArray(int i)
        {
            return new SetUserDonationDetailsResponse.SetUserDonationDetailsResponseData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String output;


    public _cls1()
    {
    }
}
