// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssDealsHistogramDataManager, UserContextObservingDataManager

public static final class _cls1 extends 
    implements Parcelable
{

    public static final android.os.ramDataManager.KeyParams CREATOR = new android.os.Parcelable.Creator() {

        public UssDealsHistogramDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return UssDealsHistogramDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UssDealsHistogramDataManager.KeyParams[] newArray(int i)
        {
            return new UssDealsHistogramDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    protected UssDealsHistogramDataManager create(EbayContext ebaycontext)
    {
        return new UssDealsHistogramDataManager(ebaycontext, this);
    }

    public boolean equals(Object obj)
    {
        return obj instanceof create;
    }

    public String toString()
    {
        return "UssDealsHistogramDataManager.KEY";
    }


    public _cls1()
    {
    }
}
