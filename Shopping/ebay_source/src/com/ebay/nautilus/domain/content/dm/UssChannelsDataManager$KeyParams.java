// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssChannelsDataManager, UserContextObservingDataManager

public static final class _cls1 extends eyBase
    implements Parcelable
{

    public static final android.os.elsDataManager.KeyParams CREATOR = new android.os.Parcelable.Creator() {

        public UssChannelsDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return UssChannelsDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UssChannelsDataManager.KeyParams[] newArray(int i)
        {
            return new UssChannelsDataManager.KeyParams[i];
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

    protected UssChannelsDataManager create(EbayContext ebaycontext)
    {
        return new UssChannelsDataManager(ebaycontext, this);
    }

    public boolean equals(Object obj)
    {
        return obj instanceof create;
    }

    public String toString()
    {
        return "UssChannelsDataManager.KEY";
    }


    public _cls1()
    {
    }
}
