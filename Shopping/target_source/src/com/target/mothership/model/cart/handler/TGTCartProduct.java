// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.a.b;
import com.target.mothership.common.a.d;
import com.target.mothership.common.a.f;
import com.target.mothership.common.product.i;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.CartProductCharges;
import com.target.mothership.model.cart.interfaces.CartRegistryDetails;
import com.target.mothership.model.cart.interfaces.GiftCardDeliveryProfile;
import com.target.mothership.model.cart.interfaces.LimitedQuantityDetails;
import com.target.mothership.model.cart.interfaces.a;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.common.StorePickUpDetails;
import com.target.mothership.model.product.handler.TGTProduct;
import com.target.mothership.util.c;
import com.target.mothership.util.k;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TGTCartProduct extends TGTProduct
    implements CartProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartProduct a(Parcel parcel)
        {
            return new TGTCartProduct(parcel);
        }

        public TGTCartProduct[] a(int i1)
        {
            return new TGTCartProduct[i1];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i1)
        {
            return a(i1);
        }

    };
    private String mCartProductDescription;
    private String mCartProductId;
    private i mCartProductInventoryStatus;
    private int mCartProductQuantity;
    private String mDefaultAddressId;
    private b mDefaultDeliveryMethod;
    private f mDefaultFulfillmentType;
    private Date mExpectedDeliveryEndDate;
    private Date mExpectedDeliveryStartDate;
    private d mEyebrow;
    private List mFreeItems;
    private GiftCardDeliveryProfile mGiftCardDeliveryProfile;
    private boolean mHasShippingRestriction;
    private OrderProductImage mImage;
    private boolean mIsBackOrder;
    private boolean mIsBulky;
    private boolean mIsDigitalDownload;
    private boolean mIsFreeGift;
    private boolean mIsGiftCard;
    private boolean mIsOnlineAvailable;
    private boolean mIsPickupAvailable;
    private boolean mIsPreOrder;
    private boolean mIsShipToStoreAvailable;
    private boolean mIsSignatureRequired;
    private a mItemType;
    private LimitedQuantityDetails mLimitedQuantityDetails;
    private Integer mMaxPurchaseLimit;
    private List mOffers;
    private String mPartNumber;
    private Date mPreOrderReleaseDate;
    private CartProductCharges mProductCharges;
    private CartRegistryDetails mRegistryDetails;
    private List mRewardOptions;
    private String mShipModeId;
    private String mSize;
    private StorePickUpDetails mStorePickUpDetails;
    private BigDecimal mTotalProductPrice;
    private BigDecimal mUnitPrice;
    private BigDecimal mUnitPriceBeforeDiscount;
    private String mValue;

    TGTCartProduct()
    {
    }

    private TGTCartProduct(Parcel parcel)
    {
        Object obj1 = null;
        boolean flag1 = true;
        super(parcel);
        mCartProductId = parcel.readString();
        mImage = (OrderProductImage)parcel.readParcelable(com/target/mothership/model/common/OrderProductImage.getClassLoader());
        mDefaultAddressId = parcel.readString();
        int i1 = parcel.readInt();
        Object obj;
        long l1;
        boolean flag;
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.a.b.values()[i1];
        }
        mDefaultDeliveryMethod = ((b) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.a.f.values()[i1];
        }
        mDefaultFulfillmentType = ((f) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.product.i.values()[i1];
        }
        mCartProductInventoryStatus = ((i) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.model.cart.interfaces.a.values()[i1];
        }
        mItemType = ((a) (obj));
        mCartProductDescription = parcel.readString();
        mTotalProductPrice = (BigDecimal)parcel.readSerializable();
        mUnitPrice = (BigDecimal)parcel.readSerializable();
        mUnitPriceBeforeDiscount = (BigDecimal)parcel.readSerializable();
        mPartNumber = parcel.readString();
        mCartProductQuantity = parcel.readInt();
        mMaxPurchaseLimit = (Integer)parcel.readSerializable();
        mLimitedQuantityDetails = (LimitedQuantityDetails)parcel.readParcelable(com/target/mothership/model/cart/interfaces/LimitedQuantityDetails.getClassLoader());
        mStorePickUpDetails = (StorePickUpDetails)parcel.readParcelable(com/target/mothership/model/common/StorePickUpDetails.getClassLoader());
        mGiftCardDeliveryProfile = (GiftCardDeliveryProfile)parcel.readParcelable(com/target/mothership/model/cart/interfaces/GiftCardDeliveryProfile.getClassLoader());
        mRegistryDetails = (CartRegistryDetails)parcel.readParcelable(com/target/mothership/model/cart/interfaces/CartRegistryDetails.getClassLoader());
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
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsGiftCard = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsPreOrder = flag;
        l1 = parcel.readLong();
        if (l1 == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l1);
        }
        mPreOrderReleaseDate = ((Date) (obj));
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsBackOrder = flag;
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.a.d.values()[i1];
        }
        mEyebrow = ((d) (obj));
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasShippingRestriction = flag;
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
            flag = true;
        } else
        {
            flag = false;
        }
        mIsPickupAvailable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsShipToStoreAvailable = flag;
        mSize = parcel.readString();
        mValue = parcel.readString();
        mOffers = new ArrayList();
        parcel.readList(mOffers, com/target/mothership/model/cart/handler/TGTCartProduct.getClassLoader());
        mProductCharges = (CartProductCharges)parcel.readParcelable(com/target/mothership/model/cart/interfaces/CartProductCharges.getClassLoader());
        l1 = parcel.readLong();
        if (l1 == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l1);
        }
        mExpectedDeliveryEndDate = ((Date) (obj));
        l1 = parcel.readLong();
        if (l1 == -1L)
        {
            obj = obj1;
        } else
        {
            obj = new Date(l1);
        }
        mExpectedDeliveryStartDate = ((Date) (obj));
        mRewardOptions = new ArrayList();
        parcel.readList(mRewardOptions, com/target/mothership/model/cart/handler/TGTCartProduct.getClassLoader());
        mFreeItems = new ArrayList();
        parcel.readList(mFreeItems, com/target/mothership/model/cart/handler/TGTCartProduct.getClassLoader());
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsSignatureRequired = flag;
        mShipModeId = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsFreeGift = flag;
    }


    public boolean A()
    {
        return mIsFreeGift;
    }

    public String a()
    {
        return mCartProductId;
    }

    public void a(b b1)
    {
        mDefaultDeliveryMethod = b1;
    }

    public void a(d d1)
    {
        mEyebrow = d1;
    }

    public void a(f f1)
    {
        mDefaultFulfillmentType = f1;
    }

    public void a(i i1)
    {
        mCartProductInventoryStatus = i1;
    }

    public void a(CartProductCharges cartproductcharges)
    {
        mProductCharges = cartproductcharges;
    }

    public void a(CartRegistryDetails cartregistrydetails)
    {
        mRegistryDetails = cartregistrydetails;
    }

    public void a(GiftCardDeliveryProfile giftcarddeliveryprofile)
    {
        mGiftCardDeliveryProfile = giftcarddeliveryprofile;
    }

    public void a(LimitedQuantityDetails limitedquantitydetails)
    {
        mLimitedQuantityDetails = limitedquantitydetails;
    }

    public void a(a a1)
    {
        mItemType = a1;
    }

    public void a(OrderProductImage orderproductimage)
    {
        mImage = orderproductimage;
    }

    public void a(StorePickUpDetails storepickupdetails)
    {
        mStorePickUpDetails = storepickupdetails;
    }

    public void a(Integer integer)
    {
        mMaxPurchaseLimit = integer;
    }

    public void a(String s1)
    {
        mCartProductId = s1;
    }

    public void a(Date date)
    {
        mExpectedDeliveryEndDate = date;
    }

    public void a(List list)
    {
        mOffers = list;
    }

    public void a(boolean flag)
    {
        mIsBulky = flag;
    }

    public OrderProductImage b()
    {
        return mImage;
    }

    public void b(String s1)
    {
        mDefaultAddressId = s1;
    }

    public void b(Date date)
    {
        mExpectedDeliveryStartDate = date;
    }

    public void b(List list)
    {
        mRewardOptions = list;
    }

    public void b(boolean flag)
    {
        mIsDigitalDownload = flag;
    }

    public b c()
    {
        return mDefaultDeliveryMethod;
    }

    public void c(String s1)
    {
        mCartProductDescription = s1;
    }

    public void c(Date date)
    {
        mPreOrderReleaseDate = date;
    }

    public void c(List list)
    {
        mFreeItems = list;
    }

    public void c(boolean flag)
    {
        mIsGiftCard = flag;
    }

    public f d()
    {
        return mDefaultFulfillmentType;
    }

    public void d(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mTotalProductPrice = s1;
    }

    public void d(boolean flag)
    {
        mHasShippingRestriction = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mUnitPrice = s1;
    }

    public void e(boolean flag)
    {
        mIsOnlineAvailable = flag;
    }

    public void f(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mUnitPriceBeforeDiscount = s1;
    }

    public void f(boolean flag)
    {
        mIsPickupAvailable = flag;
    }

    public void g(String s1)
    {
        mPartNumber = s1;
    }

    public void g(boolean flag)
    {
        mIsShipToStoreAvailable = flag;
    }

    public i g_()
    {
        return mCartProductInventoryStatus;
    }

    public void h(String s1)
    {
        if (s1 == null)
        {
            mCartProductQuantity = 0;
            return;
        } else
        {
            mCartProductQuantity = Double.valueOf(s1).intValue();
            return;
        }
    }

    public void h(boolean flag)
    {
        mIsPreOrder = flag;
    }

    public BigDecimal h_()
    {
        return mUnitPrice;
    }

    public e i()
    {
        if (mMaxPurchaseLimit == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mMaxPurchaseLimit);
        }
    }

    public void i(String s1)
    {
        mSize = s1;
    }

    public void i(boolean flag)
    {
        mIsBackOrder = flag;
    }

    public BigDecimal i_()
    {
        return mUnitPriceBeforeDiscount;
    }

    public e j()
    {
        return com.target.mothership.util.k.a(mLimitedQuantityDetails);
    }

    public void j(String s1)
    {
        mValue = s1;
    }

    public void j(boolean flag)
    {
        mIsSignatureRequired = flag;
    }

    public int j_()
    {
        return mCartProductQuantity;
    }

    public e k()
    {
        if (mStorePickUpDetails == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mStorePickUpDetails);
        }
    }

    public void k(String s1)
    {
        mShipModeId = s1;
    }

    public void k(boolean flag)
    {
        mIsFreeGift = flag;
    }

    public e l()
    {
        if (mRegistryDetails == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mRegistryDetails);
        }
    }

    public boolean m()
    {
        return mIsDigitalDownload;
    }

    public boolean n()
    {
        return mIsGiftCard;
    }

    public boolean o()
    {
        return mIsPreOrder;
    }

    public Date p()
    {
        return mPreOrderReleaseDate;
    }

    public boolean q()
    {
        return mIsBackOrder;
    }

    public boolean r()
    {
        return mIsOnlineAvailable;
    }

    public boolean s()
    {
        return mIsPickupAvailable;
    }

    public boolean t()
    {
        return mIsShipToStoreAvailable;
    }

    public e u()
    {
        return com.target.mothership.util.k.a(mExpectedDeliveryEndDate);
    }

    public e v()
    {
        return com.target.mothership.util.k.a(mExpectedDeliveryStartDate);
    }

    public boolean w()
    {
        return mIsSignatureRequired;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        long l2 = -1L;
        byte byte1 = -1;
        boolean flag = true;
        super.writeToParcel(parcel, i1);
        parcel.writeString(mCartProductId);
        parcel.writeParcelable(mImage, i1);
        parcel.writeString(mDefaultAddressId);
        byte byte0;
        long l1;
        if (mDefaultDeliveryMethod == null)
        {
            i1 = -1;
        } else
        {
            i1 = mDefaultDeliveryMethod.ordinal();
        }
        parcel.writeInt(i1);
        if (mDefaultFulfillmentType == null)
        {
            i1 = -1;
        } else
        {
            i1 = mDefaultFulfillmentType.ordinal();
        }
        parcel.writeInt(i1);
        if (mCartProductInventoryStatus == null)
        {
            i1 = -1;
        } else
        {
            i1 = mCartProductInventoryStatus.ordinal();
        }
        parcel.writeInt(i1);
        if (mItemType == null)
        {
            i1 = -1;
        } else
        {
            i1 = mItemType.ordinal();
        }
        parcel.writeInt(i1);
        parcel.writeString(mCartProductDescription);
        parcel.writeSerializable(mTotalProductPrice);
        parcel.writeSerializable(mUnitPrice);
        parcel.writeSerializable(mUnitPriceBeforeDiscount);
        parcel.writeString(mPartNumber);
        parcel.writeInt(mCartProductQuantity);
        parcel.writeSerializable(mMaxPurchaseLimit);
        parcel.writeParcelable(mLimitedQuantityDetails, 0);
        parcel.writeParcelable(mStorePickUpDetails, 0);
        parcel.writeParcelable(mGiftCardDeliveryProfile, 0);
        parcel.writeParcelable(mRegistryDetails, 0);
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
        if (mIsGiftCard)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsPreOrder)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mPreOrderReleaseDate != null)
        {
            l1 = mPreOrderReleaseDate.getTime();
        } else
        {
            l1 = -1L;
        }
        parcel.writeLong(l1);
        if (mIsBackOrder)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mEyebrow == null)
        {
            i1 = byte1;
        } else
        {
            i1 = mEyebrow.ordinal();
        }
        parcel.writeInt(i1);
        if (mHasShippingRestriction)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
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
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsShipToStoreAvailable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mSize);
        parcel.writeString(mValue);
        parcel.writeList(mOffers);
        parcel.writeParcelable(mProductCharges, 0);
        if (mExpectedDeliveryEndDate != null)
        {
            l1 = mExpectedDeliveryEndDate.getTime();
        } else
        {
            l1 = -1L;
        }
        parcel.writeLong(l1);
        l1 = l2;
        if (mExpectedDeliveryStartDate != null)
        {
            l1 = mExpectedDeliveryStartDate.getTime();
        }
        parcel.writeLong(l1);
        parcel.writeList(mRewardOptions);
        parcel.writeList(mFreeItems);
        if (mIsSignatureRequired)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mShipModeId);
        if (mIsFreeGift)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

    public List x()
    {
        return mRewardOptions;
    }

    public List y()
    {
        return mFreeItems;
    }

    public String z()
    {
        return mShipModeId;
    }

}
