// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTOrderSummaryProduct

public class TGTOrderSummary
    implements OrderSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderSummary a(Parcel parcel)
        {
            return new TGTOrderSummary(parcel);
        }

        public TGTOrderSummary[] a(int i)
        {
            return new TGTOrderSummary[i];
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
    private String mCustomerOrderNumber;
    private boolean mHasStorePickupItem;
    private boolean mIsEligibleToChangeStorePickupInfo;
    private boolean mIsOrderCancellable;
    private boolean mIsReorderable;
    private boolean mIsReturnable;
    private boolean mIsStorePickUpExtendPossible;
    private List mOrderItemList;
    private Date mOrderPlacedDate;
    private String mOrderStatus;

    TGTOrderSummary()
    {
    }

    private TGTOrderSummary(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mCustomerOrderNumber = parcel.readString();
        long l = parcel.readLong();
        Date date;
        boolean flag;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mOrderPlacedDate = date;
        mOrderStatus = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsOrderCancellable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsReorderable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsReturnable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasStorePickupItem = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsEligibleToChangeStorePickupInfo = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsStorePickUpExtendPossible = flag;
        mOrderItemList = new ArrayList();
        parcel.readList(mOrderItemList, com/target/mothership/model/guest/handler/TGTOrderSummaryProduct.getClassLoader());
    }


    public String a()
    {
        return mCustomerOrderNumber;
    }

    public void a(String s)
    {
        mCustomerOrderNumber = s;
    }

    public void a(Date date)
    {
        mOrderPlacedDate = date;
    }

    public void a(List list)
    {
        mOrderItemList = list;
    }

    public void a(boolean flag)
    {
        mIsOrderCancellable = flag;
    }

    public Date b()
    {
        return mOrderPlacedDate;
    }

    public void b(String s)
    {
        mOrderStatus = s;
    }

    public void b(boolean flag)
    {
        mIsReorderable = flag;
    }

    public List c()
    {
        return mOrderItemList;
    }

    public void c(boolean flag)
    {
        mIsReturnable = flag;
    }

    public void d(boolean flag)
    {
        mHasStorePickupItem = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(boolean flag)
    {
        mIsEligibleToChangeStorePickupInfo = flag;
    }

    public void f(boolean flag)
    {
        mIsStorePickUpExtendPossible = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(mCustomerOrderNumber);
        byte byte0;
        long l;
        if (mOrderPlacedDate != null)
        {
            l = mOrderPlacedDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        parcel.writeString(mOrderStatus);
        if (mIsOrderCancellable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsReorderable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsReturnable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mHasStorePickupItem)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsEligibleToChangeStorePickupInfo)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsStorePickUpExtendPossible)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeList(mOrderItemList);
    }

}
