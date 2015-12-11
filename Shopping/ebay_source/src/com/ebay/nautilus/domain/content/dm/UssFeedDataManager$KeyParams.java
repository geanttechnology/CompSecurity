// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssFeedDataManager, UserContextObservingDataManager

public static final class _cls1 extends er.KeyBase
    implements Parcelable
{

    public static final android.os.eedDataManager.KeyParams CREATOR = new android.os.Parcelable.Creator() {

        public UssFeedDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return UssFeedDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UssFeedDataManager.KeyParams[] newArray(int i)
        {
            return new UssFeedDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    public UssFeedDataManager create(EbayContext ebaycontext)
    {
        return new UssFeedDataManager(ebaycontext, this);
    }

    public boolean equals(Object obj)
    {
        return obj instanceof create;
    }

    public String toString()
    {
        return "UssFeedDataManager.KEY";
    }


    public _cls1()
    {
    }
}
