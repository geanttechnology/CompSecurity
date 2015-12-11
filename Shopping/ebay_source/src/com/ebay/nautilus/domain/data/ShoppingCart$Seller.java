// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static class vacationEndsOn extends BaseDataMapped
    implements Parcelable, Comparable
{

    public static final android.os.hoppingCart.Seller CREATOR = new android.os.Parcelable.Creator() {

        public ShoppingCart.Seller createFromParcel(Parcel parcel)
        {
            return (ShoppingCart.Seller)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Seller);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShoppingCart.Seller[] newArray(int i)
        {
            return new ShoppingCart.Seller[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final _cls1.newArray UNKNOWN = new <init>();
    public final int feedbackScore;
    public final boolean isOnVacation;
    public final String username;
    public final Date vacationEndsOn;

    public int compareTo(d d)
    {
        if (this == d)
        {
            return 0;
        }
        if (d == null)
        {
            return 1;
        } else
        {
            return username.compareTo(d.username);
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }


    protected _cls1()
    {
        this(null, 0, false, null);
    }

    public <init>(String s, int i, boolean flag, Date date)
    {
        if (s == null)
        {
            s = "";
        }
        username = s;
        feedbackScore = i;
        isOnVacation = flag;
        if (!flag || date == null)
        {
            date = new Date(0L);
        }
        vacationEndsOn = date;
    }
}
