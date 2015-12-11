// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.itemview;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.itemview:
//            ProductReviewsDataManager

public static final class site extends com.ebay.nautilus.domain.content.dm.ase
    implements Parcelable
{

    public static final android.os. CREATOR = new android.os.Parcelable.Creator() {

        public ProductReviewsDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return new ProductReviewsDataManager.KeyParams((EbaySite)EbaySite.CREATOR.createFromParcel(parcel));
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ProductReviewsDataManager.KeyParams[] newArray(int i)
        {
            return new ProductReviewsDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final EbaySite site;

    public ProductReviewsDataManager create(EbayContext ebaycontext)
    {
        return new ProductReviewsDataManager(ebaycontext, this);
    }

    public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof create)
        {
            return ((create)obj).site.equals(site);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() * 31 + site.idInt;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Site:").append(site.id).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        site.writeToParcel(parcel, i);
    }


    public _cls1(EbaySite ebaysite)
    {
        site = ebaysite;
    }
}
