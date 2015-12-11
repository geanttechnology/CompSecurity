// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ShippingDetailsDataManager

public static final class site extends com.ebay.nautilus.domain.content.
    implements Parcelable
{

    public static final android.os.ger.KeyParams.site CREATOR = new android.os.Parcelable.Creator() {

        public ShippingDetailsDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return new ShippingDetailsDataManager.KeyParams((EbaySite)parcel.readParcelable(com/ebay/nautilus/domain/EbaySite.getClassLoader()));
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingDetailsDataManager.KeyParams[] newArray(int i)
        {
            return new ShippingDetailsDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final EbaySite site;

    public ShippingDetailsDataManager createManager(EbayContext ebaycontext)
    {
        ebaycontext = new ShippingDetailsDataManager(ebaycontext, this);
        ebaycontext.create();
        return ebaycontext;
    }

    public volatile DataManager createManager(EbayContext ebaycontext)
    {
        return createManager(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            }
            obj = (createManager)obj;
            if (site == null)
            {
                if (((site) (obj)).site != null)
                {
                    return false;
                }
            } else
            {
                return site.equals(((site) (obj)).site);
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = super.Code();
        int i;
        if (site != null)
        {
            i = site.hashCode();
        } else
        {
            i = 0;
        }
        return j * 31 + i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(site, i);
    }


    public _cls1(EbaySite ebaysite)
    {
        if (ShippingDetailsDataManager.logTag.)
        {
            ShippingDetailsDataManager.logTag.((new StringBuilder()).append("KeyParams: site=").append(ebaysite).toString());
        }
        site = ebaysite;
    }
}
