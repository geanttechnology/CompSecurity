// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static class requestedQuantity extends BaseDataMapped
    implements Parcelable
{

    public static final android.os..BaseDataMapped CREATOR = new android.os.Parcelable.Creator() {

        public ShoppingCart.Transaction createFromParcel(Parcel parcel)
        {
            return (ShoppingCart.Transaction)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Transaction);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShoppingCart.Transaction[] newArray(int i)
        {
            return new ShoppingCart.Transaction[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final _cls1.newArray UNKNOWN = new <init>();
    public final Long ebayItemId;
    public final WithConversion itemPrice;
    public final int requestedQuantity;
    public final Long transactionId;
    public final String variationId;


    protected WithConversion()
    {
        this(null, null, null, null, 0);
    }

    public WithConversion(Long long1, String s, Long long2, WithConversion withconversion, int i)
    {
        long l;
        if (long1 != null)
        {
            l = long1.longValue();
        } else
        {
            l = 0L;
        }
        ebayItemId = Long.valueOf(l);
        variationId = s;
        if (long2 != null)
        {
            l = long2.longValue();
        } else
        {
            l = -1L;
        }
        transactionId = Long.valueOf(l);
        if (withconversion == null)
        {
            withconversion = WithConversion.ZERO;
        }
        itemPrice = withconversion;
        requestedQuantity = i;
    }
}
