// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowInventoryLookupResponse

static class availabilities extends BaseApiResponse
{

    final android.os.nse.Availabilities CREATOR = new android.os.Parcelable.Creator() {

        final EbayNowInventoryLookupResponse.Availabilities this$0;

        public EbayNowInventoryLookupResponse.Availabilities createFromParcel(Parcel parcel)
        {
            return (EbayNowInventoryLookupResponse.Availabilities)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/local/EbayNowInventoryLookupResponse$Availabilities);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayNowInventoryLookupResponse.Availabilities[] newArray(int i)
        {
            return new EbayNowInventoryLookupResponse.Availabilities[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

            
            {
                this$0 = EbayNowInventoryLookupResponse.Availabilities.this;
                super();
            }
    };
    public ArrayList availabilities;

    public _cls1.this._cls0()
    {
        availabilities = new ArrayList();
    }
}
