// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.pi_blackfriday_deals;

import android.os.Parcel;
import com.pointinside.maps.Location;
import com.target.mothership.common.product.Dpci;
import java.math.BigDecimal;

// Referenced classes of package com.target.ui.model.pi_blackfriday_deals:
//            PiBaseProduct

public class TGTPiBaseProduct
    implements PiBaseProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPiBaseProduct a(Parcel parcel)
        {
            return new TGTPiBaseProduct(parcel);
        }

        public TGTPiBaseProduct[] a(int i)
        {
            return new TGTPiBaseProduct[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private String mDescription;
    private Dpci mDpci;
    private String mImageUrlPattern;
    private Location mLocation;
    private BigDecimal mPrice;
    private String mTitle;

    TGTPiBaseProduct()
    {
    }

    private TGTPiBaseProduct(Parcel parcel)
    {
        mTitle = parcel.readString();
        mDescription = parcel.readString();
        mDpci = (Dpci)parcel.readParcelable(com/target/mothership/common/product/Dpci.getClassLoader());
        mImageUrlPattern = parcel.readString();
        mPrice = (BigDecimal)parcel.readSerializable();
        mLocation = (Location)parcel.readParcelable(com/pointinside/maps/Location.getClassLoader());
    }


    public String a()
    {
        return mTitle;
    }

    public void a(Location location)
    {
        mLocation = location;
    }

    public void a(Dpci dpci)
    {
        mDpci = dpci;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mPrice = bigdecimal;
    }

    public Dpci b()
    {
        return mDpci;
    }

    public void b(String s)
    {
        mDescription = s;
    }

    public String c()
    {
        return mImageUrlPattern;
    }

    public void c(String s)
    {
        mImageUrlPattern = s;
    }

    public BigDecimal d()
    {
        return mPrice;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeString(mDescription);
        parcel.writeParcelable(mDpci, i);
        parcel.writeString(mImageUrlPattern);
        parcel.writeSerializable(mPrice);
        parcel.writeParcelable(mLocation, i);
    }

}
