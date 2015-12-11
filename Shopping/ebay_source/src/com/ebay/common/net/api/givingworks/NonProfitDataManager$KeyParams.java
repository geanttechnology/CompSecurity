// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            NonProfitDataManager

public static final class _cls1 extends com.ebay.nautilus.domain.content.dm..KeyBase
    implements Parcelable
{

    public static final android.os.xt CREATOR = new android.os.Parcelable.Creator() {

        public NonProfitDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return NonProfitDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public NonProfitDataManager.KeyParams[] newArray(int i)
        {
            return new NonProfitDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    protected NonProfitDataManager create(EbayContext ebaycontext)
    {
        return new NonProfitDataManager(ebaycontext, this);
    }

    protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }


    _cls1()
    {
    }
}
