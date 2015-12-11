// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class isEligibleForGuestCheckout extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.eDataMapped CREATOR = new android.os.Parcelable.Creator() {

        public ShoppingCart.CheckoutSession createFromParcel(Parcel parcel)
        {
            return (ShoppingCart.CheckoutSession)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$CheckoutSession);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShoppingCart.CheckoutSession[] newArray(int i)
        {
            return new ShoppingCart.CheckoutSession[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final _cls1.newArray UNKNOWN = new <init>();
    public final boolean isEligibleForGuestCheckout;
    public final String token;
    public final String type;
    public final Uri url;


    protected _cls1()
    {
        this(null, null, null, false);
    }

    public <init>(String s, String s1, Uri uri, boolean flag)
    {
        if (s == null)
        {
            s = "";
        }
        token = s;
        if (s1 == null)
        {
            s1 = "";
        }
        type = s1;
        if (uri == null)
        {
            uri = Uri.EMPTY;
        }
        url = uri;
        isEligibleForGuestCheckout = flag;
    }
}
