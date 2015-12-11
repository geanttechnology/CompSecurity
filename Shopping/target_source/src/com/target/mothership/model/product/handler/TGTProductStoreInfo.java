// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.product.i;
import com.target.mothership.common.product.m;
import com.target.mothership.common.product.r;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductPriceInfo, TGTProductInStoreLocation

class TGTProductStoreInfo extends TGTProductPriceInfo
    implements Parcelable, ProductStoreInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductStoreInfo a(Parcel parcel)
        {
            return new TGTProductStoreInfo(parcel);
        }

        public TGTProductStoreInfo[] a(int j)
        {
            return new TGTProductStoreInfo[j];
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
    private List mGetLocation;
    private boolean mHasPromotion;
    private i mInventoryStatus;
    private boolean mIsInfoPresent;
    private Boolean mIsSoldInStore;
    private m mPickUpInStoreStatus;
    private String mStoreId;
    private r mStoreInfoStatusCode;

    TGTProductStoreInfo()
    {
    }

    private TGTProductStoreInfo(Parcel parcel)
    {
        boolean flag1 = true;
        Object obj1 = null;
        super(parcel);
        mStoreId = parcel.readString();
        Object obj;
        int j;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasPromotion = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsInfoPresent = flag;
        mGetLocation = new ArrayList();
        parcel.readList(mGetLocation, com/target/mothership/model/product/handler/TGTProductInStoreLocation.getClassLoader());
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
            obj = null;
        } else
        {
            obj = m.values()[j];
        }
        mPickUpInStoreStatus = ((m) (obj));
        j = parcel.readInt();
        if (j == -1)
        {
            obj = obj1;
        } else
        {
            obj = r.values()[j];
        }
        mStoreInfoStatusCode = ((r) (obj));
        mIsSoldInStore = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
    }


    public void a(i j)
    {
        mInventoryStatus = j;
    }

    public void a(m m1)
    {
        mPickUpInStoreStatus = m1;
    }

    public void a(r r1)
    {
        mStoreInfoStatusCode = r1;
    }

    public void a(Boolean boolean1)
    {
        mIsSoldInStore = boolean1;
    }

    public void a(String s)
    {
        mStoreId = s;
    }

    public void a(List list)
    {
        mGetLocation = list;
    }

    public void a(boolean flag)
    {
        mIsInfoPresent = flag;
    }

    public boolean a()
    {
        return mIsInfoPresent;
    }

    public List b()
    {
        return k.a(mGetLocation);
    }

    public void b(boolean flag)
    {
        mHasPromotion = flag;
    }

    public i c()
    {
        return mInventoryStatus;
    }

    public m d()
    {
        return mPickUpInStoreStatus;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        boolean flag = true;
        byte byte1 = -1;
        super.writeToParcel(parcel, j);
        parcel.writeString(mStoreId);
        byte byte0;
        if (mHasPromotion)
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
        parcel.writeList(mGetLocation);
        if (mInventoryStatus == null)
        {
            j = -1;
        } else
        {
            j = mInventoryStatus.ordinal();
        }
        parcel.writeInt(j);
        if (mPickUpInStoreStatus == null)
        {
            j = -1;
        } else
        {
            j = mPickUpInStoreStatus.ordinal();
        }
        parcel.writeInt(j);
        if (mStoreInfoStatusCode == null)
        {
            j = byte1;
        } else
        {
            j = mStoreInfoStatusCode.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeValue(mIsSoldInStore);
    }

}
