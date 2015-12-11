// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.d;
import com.target.mothership.common.product.i;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.cart.interfaces.AddToCartProduct;
import com.target.mothership.model.cart.interfaces.CartRegistryDetails;
import com.target.mothership.model.product.handler.TGTProduct;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TGTAddToCartProduct extends TGTProduct
    implements AddToCartProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAddToCartProduct a(Parcel parcel)
        {
            return new TGTAddToCartProduct(parcel);
        }

        public TGTAddToCartProduct[] a(int j)
        {
            return new TGTAddToCartProduct[j];
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
    private List mCartProductAttachments;
    private String mCartProductId;
    private i mCartProductInventoryStatus;
    private BigDecimal mCartProductPrice;
    private int mCartProductQuantity;
    private d mEyebrow;
    private boolean mIsBulky;
    private boolean mIsDigitalDownload;
    private boolean mIsOnlineAvailable;
    private boolean mIsPickupAvailable;
    private Map mItemAttributes;
    private CartRegistryDetails mRegistryDetails;
    private String mSize;
    private StoreIdentifier mStoreId;

    TGTAddToCartProduct()
    {
    }

    private TGTAddToCartProduct(Parcel parcel)
    {
        Object obj1 = null;
        boolean flag1 = true;
        super(parcel);
        mCartProductId = parcel.readString();
        mCartProductAttachments = new ArrayList();
        parcel.readList(mCartProductAttachments, com/target/mothership/model/cart/handler/TGTAddToCartProduct.getClassLoader());
        int j = parcel.readInt();
        Object obj;
        boolean flag;
        if (j == -1)
        {
            obj = null;
        } else
        {
            obj = i.values()[j];
        }
        mCartProductInventoryStatus = ((i) (obj));
        mCartProductPrice = (BigDecimal)parcel.readSerializable();
        mCartProductQuantity = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsBulky = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDigitalDownload = flag;
        j = parcel.readInt();
        if (j == -1)
        {
            obj = obj1;
        } else
        {
            obj = d.values()[j];
        }
        mEyebrow = ((d) (obj));
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsOnlineAvailable = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsPickupAvailable = flag;
        mSize = parcel.readString();
        mStoreId = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
        mItemAttributes = parcel.readHashMap(com/target/mothership/model/cart/handler/TGTAddToCartProduct.getClassLoader());
        mRegistryDetails = (CartRegistryDetails)parcel.readParcelable(com/target/mothership/model/cart/interfaces/CartRegistryDetails.getClassLoader());
    }


    public void a(d d1)
    {
        mEyebrow = d1;
    }

    public void a(i j)
    {
        mCartProductInventoryStatus = j;
    }

    public void a(StoreIdentifier storeidentifier)
    {
        mStoreId = storeidentifier;
    }

    public void a(CartRegistryDetails cartregistrydetails)
    {
        mRegistryDetails = cartregistrydetails;
    }

    public void a(String s)
    {
        mCartProductId = s;
    }

    public void a(List list)
    {
        mCartProductAttachments = list;
    }

    public void a(Map map)
    {
        mItemAttributes = map;
    }

    public void a(boolean flag)
    {
        mIsBulky = flag;
    }

    public void b(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mCartProductPrice = s;
    }

    public void b(boolean flag)
    {
        mIsDigitalDownload = flag;
    }

    public void c(String s)
    {
        if (s == null)
        {
            mCartProductQuantity = 0;
            return;
        } else
        {
            mCartProductQuantity = Double.valueOf(s).intValue();
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        byte byte1 = -1;
        boolean flag = true;
        super.writeToParcel(parcel, j);
        parcel.writeString(mCartProductId);
        parcel.writeList(mCartProductAttachments);
        byte byte0;
        if (mCartProductInventoryStatus == null)
        {
            j = -1;
        } else
        {
            j = mCartProductInventoryStatus.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeSerializable(mCartProductPrice);
        parcel.writeInt(mCartProductQuantity);
        if (mIsBulky)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsDigitalDownload)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mEyebrow == null)
        {
            j = byte1;
        } else
        {
            j = mEyebrow.ordinal();
        }
        parcel.writeInt(j);
        if (mIsOnlineAvailable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsPickupAvailable)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mSize);
        parcel.writeParcelable(mStoreId, 0);
        parcel.writeMap(mItemAttributes);
        parcel.writeParcelable(mRegistryDetails, 0);
    }

}
