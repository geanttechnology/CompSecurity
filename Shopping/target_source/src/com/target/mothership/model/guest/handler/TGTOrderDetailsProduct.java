// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.common.a.b;
import com.target.mothership.common.a.f;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.mothership.util.p;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTOrderSummaryProduct

public class TGTOrderDetailsProduct extends TGTOrderSummaryProduct
    implements OrderDetailsProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderDetailsProduct a(Parcel parcel)
        {
            return new TGTOrderDetailsProduct(parcel);
        }

        public TGTOrderDetailsProduct[] a(int i)
        {
            return new TGTOrderDetailsProduct[i];
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
    private b mDeliveryMethod;
    private Date mExpectedDeliveryEndDate;
    private Date mExpectedDeliveryStartDate;
    private f mFulfillmentType;
    private boolean mIsCancellable;
    private List mOrderItemStatusList;
    private BigDecimal mPrice;
    private List mProductImagesList;
    private BigDecimal mUnitPrice;
    private BigDecimal mUnitPriceBeforeDiscount;

    TGTOrderDetailsProduct()
    {
    }

    private TGTOrderDetailsProduct(Parcel parcel)
    {
        Object obj1 = null;
        super(parcel);
        Object obj;
        int i;
        long l;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsCancellable = flag;
        mOrderItemStatusList = new ArrayList();
        parcel.readList(mOrderItemStatusList, com/target/mothership/model/guest/handler/TGTOrderDetailsProduct.getClassLoader());
        mProductImagesList = new ArrayList();
        parcel.readList(mProductImagesList, com/target/mothership/model/guest/handler/TGTOrderDetailsProduct.getClassLoader());
        i = parcel.readInt();
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.a.b.values()[i];
        }
        mDeliveryMethod = ((b) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = f.values()[i];
        }
        mFulfillmentType = ((f) (obj));
        mPrice = (BigDecimal)parcel.readSerializable();
        mUnitPrice = (BigDecimal)parcel.readSerializable();
        mUnitPriceBeforeDiscount = (BigDecimal)parcel.readSerializable();
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mExpectedDeliveryEndDate = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            parcel = obj1;
        } else
        {
            parcel = new Date(l);
        }
        mExpectedDeliveryStartDate = parcel;
    }


    public String a(int i)
    {
        if (!mProductImagesList.isEmpty())
        {
            return ((OrderProductImage)mProductImagesList.get(0)).a(i);
        } else
        {
            return p.a(this, i);
        }
    }

    public List a()
    {
        return mProductImagesList;
    }

    public void a(b b1)
    {
        mDeliveryMethod = b1;
    }

    public void a(f f1)
    {
        mFulfillmentType = f1;
    }

    public void a(BigDecimal bigdecimal)
    {
        mPrice = bigdecimal;
    }

    public void a(Date date)
    {
        mExpectedDeliveryEndDate = date;
    }

    public void a(List list)
    {
        mOrderItemStatusList = list;
    }

    public void a(boolean flag)
    {
        mIsCancellable = flag;
    }

    public BigDecimal b()
    {
        return mUnitPrice;
    }

    public void b(BigDecimal bigdecimal)
    {
        mUnitPrice = bigdecimal;
    }

    public void b(Date date)
    {
        mExpectedDeliveryStartDate = date;
    }

    public void b(List list)
    {
        mProductImagesList = list;
    }

    public void c(BigDecimal bigdecimal)
    {
        mUnitPriceBeforeDiscount = bigdecimal;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        byte byte1 = -1;
        super.writeToParcel(parcel, i);
        byte byte0;
        long l;
        if (mIsCancellable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeList(mOrderItemStatusList);
        parcel.writeList(mProductImagesList);
        if (mDeliveryMethod == null)
        {
            i = -1;
        } else
        {
            i = mDeliveryMethod.ordinal();
        }
        parcel.writeInt(i);
        if (mFulfillmentType == null)
        {
            i = byte1;
        } else
        {
            i = mFulfillmentType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeSerializable(mPrice);
        parcel.writeSerializable(mUnitPrice);
        parcel.writeSerializable(mUnitPriceBeforeDiscount);
        if (mExpectedDeliveryEndDate != null)
        {
            l = mExpectedDeliveryEndDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mExpectedDeliveryStartDate != null)
        {
            l = mExpectedDeliveryStartDate.getTime();
        }
        parcel.writeLong(l);
    }

}
