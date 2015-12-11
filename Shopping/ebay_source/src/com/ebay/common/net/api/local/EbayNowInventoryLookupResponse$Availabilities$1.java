// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowInventoryLookupResponse

class this._cls0
    implements android.os.e.Availabilities._cls1
{

    final newArray this$0;

    public this._cls0 createFromParcel(Parcel parcel)
    {
        return (this._cls0)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/local/EbayNowInventoryLookupResponse$Availabilities);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
