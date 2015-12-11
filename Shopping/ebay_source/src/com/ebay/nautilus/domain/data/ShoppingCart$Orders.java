// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class itemsByOffer extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.pping.BaseDataMapped CREATOR = new android.os.Parcelable.Creator() {

        public ShoppingCart.Orders createFromParcel(Parcel parcel)
        {
            return (ShoppingCart.Orders)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Orders);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShoppingCart.Orders[] newArray(int i)
        {
            return new ShoppingCart.Orders[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final _cls1.newArray UNKNOWN = new <init>();
    public final Map itemsByOffer;


    protected _cls1()
    {
        this(null);
    }

    public <init>(SortedMap sortedmap)
    {
        if (sortedmap != null)
        {
            sortedmap = Collections.unmodifiableSortedMap(sortedmap);
        } else
        {
            sortedmap = Collections.emptyMap();
        }
        itemsByOffer = sortedmap;
    }
}
