// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.mobile.sell:
//            EditShippingServiceDialogFragment

static class _cls1 extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.rviceInfo CREATOR = new android.os.Parcelable.Creator() {

        public EditShippingServiceDialogFragment.ShippingServiceInfo createFromParcel(Parcel parcel)
        {
            return (EditShippingServiceDialogFragment.ShippingServiceInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/sell/EditShippingServiceDialogFragment$ShippingServiceInfo);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EditShippingServiceDialogFragment.ShippingServiceInfo[] newArray(int i)
        {
            return new EditShippingServiceDialogFragment.ShippingServiceInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public com.ebay.common.model..newArray serviceDetail;
    public ShippingEstimate serviceEstimate;
    public LdsOption serviceOption;


    public _cls1()
    {
    }
}
