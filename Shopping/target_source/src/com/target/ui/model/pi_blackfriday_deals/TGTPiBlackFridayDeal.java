// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.pi_blackfriday_deals;

import android.os.Parcel;
import com.pointinside.maps.Location;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.ui.model.pi_blackfriday_deals:
//            PiBlackFridayDeal, PiBaseProduct

public class TGTPiBlackFridayDeal
    implements PiBlackFridayDeal
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPiBlackFridayDeal a(Parcel parcel)
        {
            return new TGTPiBlackFridayDeal(parcel);
        }

        public TGTPiBlackFridayDeal[] a(int i)
        {
            return new TGTPiBlackFridayDeal[i];
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
    private Date mEndDate;
    private String mId;
    private String mImageUrlPattern;
    private Location mLocation;
    private List mProducts;
    private Date mStartDate;
    private String mTitle;

    TGTPiBlackFridayDeal()
    {
    }

    private TGTPiBlackFridayDeal(Parcel parcel)
    {
        Object obj = null;
        super();
        mId = parcel.readString();
        mTitle = parcel.readString();
        mDescription = parcel.readString();
        mImageUrlPattern = parcel.readString();
        long l = parcel.readLong();
        Date date;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mStartDate = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            date = obj;
        } else
        {
            date = new Date(l);
        }
        mEndDate = date;
        mLocation = (Location)parcel.readParcelable(com/pointinside/maps/Location.getClassLoader());
        mProducts = new ArrayList();
        parcel.readList(mProducts, com/target/ui/model/pi_blackfriday_deals/PiBaseProduct.getClassLoader());
    }


    public int a(PiBlackFridayDeal piblackfridaydeal)
    {
        if (mId != null && piblackfridaydeal.a() != null)
        {
            return mId.compareTo(piblackfridaydeal.a());
        } else
        {
            return 0;
        }
    }

    public String a()
    {
        return mId;
    }

    public void a(Location location)
    {
        mLocation = location;
    }

    public void a(String s)
    {
        mId = s;
    }

    public void a(Date date)
    {
        mStartDate = date;
    }

    public void a(List list)
    {
        mProducts = list;
    }

    public String b()
    {
        return mTitle;
    }

    public void b(String s)
    {
        mTitle = s;
    }

    public void b(Date date)
    {
        mEndDate = date;
    }

    public String c()
    {
        return mDescription;
    }

    public void c(String s)
    {
        mDescription = s;
    }

    public int compareTo(Object obj)
    {
        return a((PiBlackFridayDeal)obj);
    }

    public String d()
    {
        return mImageUrlPattern;
    }

    public void d(String s)
    {
        mImageUrlPattern = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public Location e()
    {
        return mLocation;
    }

    public List f()
    {
        return mProducts;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        parcel.writeString(mId);
        parcel.writeString(mTitle);
        parcel.writeString(mDescription);
        parcel.writeString(mImageUrlPattern);
        long l;
        if (mStartDate != null)
        {
            l = mStartDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mEndDate != null)
        {
            l = mEndDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeParcelable(mLocation, i);
        parcel.writeList(mProducts);
    }

}
