// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.merch:
//            MerchandiseDataManager

public static final class _cls1 extends com.ebay.nautilus.domain.content.dm.eyBase
    implements Parcelable
{

    public static final android.os. CREATOR = new android.os.Parcelable.Creator() {

        public MerchandiseDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return MerchandiseDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MerchandiseDataManager.KeyParams[] newArray(int i)
        {
            return new MerchandiseDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public MerchandiseDataManager create(EbayContext ebaycontext)
    {
        return new MerchandiseDataManager(ebaycontext, this);
    }

    public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }


    protected _cls1()
    {
    }
}
