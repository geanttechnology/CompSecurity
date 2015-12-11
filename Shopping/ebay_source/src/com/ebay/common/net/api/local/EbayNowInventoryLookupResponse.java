// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.local:
//            BaseEbayNowResponse

public final class EbayNowInventoryLookupResponse extends BaseEbayNowResponse
{
    static class Availabilities extends BaseApiResponse
    {

        final android.os.Parcelable.Creator CREATOR = new _cls1();
        public ArrayList availabilities;

        public Availabilities()
        {
            availabilities = new ArrayList();
        }
    }


    public EbayNowInventoryLookupResponse()
    {
        super(com/ebay/common/net/api/local/EbayNowInventoryLookupResponse$Availabilities);
    }

    // Unreferenced inner class com/ebay/common/net/api/local/EbayNowInventoryLookupResponse$Availabilities$1

/* anonymous class */
    class Availabilities._cls1
        implements android.os.Parcelable.Creator
    {

        final Availabilities this$0;

        public Availabilities createFromParcel(Parcel parcel)
        {
            return (Availabilities)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/local/EbayNowInventoryLookupResponse$Availabilities);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Availabilities[] newArray(int i)
        {
            return new Availabilities[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

            
            {
                this$0 = Availabilities.this;
                super();
            }
    }

}
