// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SiteSpeedDataManager

public static final class _cls1 extends com.ebay.nautilus.domain.content.s
    implements Parcelable
{

    public static final android.os.eedDataManager.KeyParams CREATOR = new android.os.Parcelable.Creator() {

        public SiteSpeedDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return SiteSpeedDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SiteSpeedDataManager.KeyParams[] newArray(int i)
        {
            return new SiteSpeedDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public volatile DataManager createManager(EbayContext ebaycontext)
    {
        return createManager(ebaycontext);
    }

    public SiteSpeedDataManager createManager(EbayContext ebaycontext)
    {
        return new SiteSpeedDataManager(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof createManager);
    }


    public _cls1()
    {
    }
}
