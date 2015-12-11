// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.i;
import com.target.mothership.common.product.m;
import com.target.mothership.model.product.interfaces.ProductLimitedAvailability;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductPriceInfo, TGTProductEyeBrow

public class TGTProductOnlineInfo extends TGTProductPriceInfo
    implements Parcelable, ProductOnlineInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductOnlineInfo a(Parcel parcel)
        {
            return new TGTProductOnlineInfo(parcel);
        }

        public TGTProductOnlineInfo[] a(int j)
        {
            return new TGTProductOnlineInfo[j];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int j)
        {
            return a(j);
        }

    };
    private String mCategoryName;
    private boolean mHasMinAdvertisedPrice;
    private i mInventoryStatus;
    private boolean mIsFreeShipping;
    private boolean mIsInfoPresent;
    private m mPickUpInStoreStatus;
    private Date mPreOrderDate;
    private List mProductEyeBrow;
    private ProductLimitedAvailability mProductLimitedAvailability;

    TGTProductOnlineInfo()
    {
    }

    TGTProductOnlineInfo(Parcel parcel)
    {
        Object obj1 = null;
        boolean flag1 = true;
        super(parcel);
        Object obj;
        int j;
        long l;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasMinAdvertisedPrice = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsFreeShipping = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsInfoPresent = flag;
        mCategoryName = parcel.readString();
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mPreOrderDate = ((Date) (obj));
        j = parcel.readInt();
        if (j == -1)
        {
            obj = null;
        } else
        {
            obj = i.values()[j];
        }
        mInventoryStatus = ((i) (obj));
        j = parcel.readInt();
        if (j == -1)
        {
            obj = obj1;
        } else
        {
            obj = m.values()[j];
        }
        mPickUpInStoreStatus = ((m) (obj));
        mProductEyeBrow = new ArrayList();
        parcel.readList(mProductEyeBrow, com/target/mothership/model/product/handler/TGTProductEyeBrow.getClassLoader());
        mProductLimitedAvailability = (ProductLimitedAvailability)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductLimitedAvailability.getClassLoader());
    }

    public void a(i j)
    {
        mInventoryStatus = j;
    }

    public void a(m m1)
    {
        mPickUpInStoreStatus = m1;
    }

    public void a(ProductLimitedAvailability productlimitedavailability)
    {
        mProductLimitedAvailability = productlimitedavailability;
    }

    public void a(String s)
    {
        mCategoryName = s;
    }

    public void a(Date date)
    {
        mPreOrderDate = date;
    }

    public void a(List list)
    {
        mProductEyeBrow = list;
    }

    public void a(boolean flag)
    {
        mIsInfoPresent = flag;
    }

    public boolean a()
    {
        return mIsInfoPresent;
    }

    public void b(boolean flag)
    {
        mHasMinAdvertisedPrice = flag;
    }

    public boolean b()
    {
        return mHasMinAdvertisedPrice;
    }

    public i c()
    {
        return mInventoryStatus;
    }

    public void c(boolean flag)
    {
        mIsFreeShipping = flag;
    }

    public e d()
    {
        return k.a(mProductLimitedAvailability);
    }

    public int describeContents()
    {
        return 0;
    }

    public m e()
    {
        return mPickUpInStoreStatus;
    }

    public e f()
    {
        return k.a(mPreOrderDate);
    }

    public List g()
    {
        return mProductEyeBrow;
    }

    public boolean h()
    {
        return mIsFreeShipping;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        byte byte1 = -1;
        boolean flag = true;
        super.writeToParcel(parcel, j);
        byte byte0;
        int l;
        long l1;
        if (mHasMinAdvertisedPrice)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsFreeShipping)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsInfoPresent)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mCategoryName);
        if (mPreOrderDate != null)
        {
            l1 = mPreOrderDate.getTime();
        } else
        {
            l1 = -1L;
        }
        parcel.writeLong(l1);
        if (mInventoryStatus == null)
        {
            l = -1;
        } else
        {
            l = mInventoryStatus.ordinal();
        }
        parcel.writeInt(l);
        if (mPickUpInStoreStatus == null)
        {
            l = byte1;
        } else
        {
            l = mPickUpInStoreStatus.ordinal();
        }
        parcel.writeInt(l);
        parcel.writeList(mProductEyeBrow);
        parcel.writeParcelable(mProductLimitedAvailability, j);
    }

}
