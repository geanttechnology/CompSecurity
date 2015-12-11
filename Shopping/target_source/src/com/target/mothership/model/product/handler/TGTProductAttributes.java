// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import com.target.mothership.common.product.b;
import com.target.mothership.common.product.c;
import com.target.mothership.common.product.h;
import com.target.mothership.common.product.j;
import com.target.mothership.common.product.k;
import com.target.mothership.model.common.TGTDvmRemoteData;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.product.interfaces.ProductAgeRestriction;
import com.target.mothership.model.product.interfaces.ProductAttributes;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.product.interfaces.ProductIndustryRating;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductRootLevelCategory;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.model.product.interfaces.ProductVariationValues;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProduct, TGTProductImage, TGTProductStoreInfo, TGTProductGuestReview, 
//            TGTProductOnlineInfo, TGTProductIndustryRating, TGTProductAgeRestriction, TGTProductFeature, 
//            TGTProductCartWheel, TGTProductVariationValues, TGTProductChokingHazard, TGTProductCallout, 
//            TGTProductPromotion

public class TGTProductAttributes extends TGTProduct
    implements ProductAttributes
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductAttributes a(Parcel parcel)
        {
            return new TGTProductAttributes(parcel);
        }

        public TGTProductAttributes[] a(int i1)
        {
            return new TGTProductAttributes[i1];
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
    private ProductAgeRestriction mAgeRestriction;
    private String mBulkShippingMessage;
    private List mCalloutTypes;
    private List mCartWheelOffer;
    private b mCartWheelStatusCode;
    private CategoryId mCategoryId;
    private c mChannelAvailabilityCode;
    private List mChockingHazard;
    private CouponPromotionId mCouponPromotionId;
    private String mDescription;
    private DvmRemoteData mDvmRemoteData;
    private URL mEnergyGuideUrl;
    private List mFeatures;
    private List mGiftCardShippingMode;
    private ProductGuestReview mGuestReview;
    private boolean mHasDrugFacts;
    private boolean mHasNutritionalFlag;
    private ProductIndustryRating mIndustryRating;
    private boolean mIsBuyNowEligible;
    private boolean mIsBuyable;
    private boolean mIsGiftCard;
    private boolean mIsHazmat;
    private boolean mIsPickFromStoreEligible;
    private boolean mIsRecall;
    private j mManufacturingBrand;
    private k mMediaFormat;
    private ProductOnlineInfo mOnlinePriceInfo;
    private Tcin mParentTcin;
    private ProductImage mProductImage;
    private ProductRootLevelCategory mProductRootLevelCategory;
    private List mPromotion;
    private String mReturnPolicy;
    private ProductStoreInfo mStorePriceInfo;
    private URL mTargetWebUrl;
    private URL mTermsAndConditionUrl;
    private Upc mUpc;
    private ProductVariationValues mVariationValues;

    TGTProductAttributes()
    {
    }

    TGTProductAttributes(Parcel parcel)
    {
        Object obj1 = null;
        boolean flag1 = true;
        super(parcel);
        mUpc = (Upc)parcel.readParcelable(com/target/mothership/common/product/Upc.getClassLoader());
        mCategoryId = (CategoryId)parcel.readParcelable(com/target/mothership/common/product/CategoryId.getClassLoader());
        mDescription = parcel.readString();
        mReturnPolicy = parcel.readString();
        Object obj;
        int i1;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsHazmat = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsRecall = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsBuyable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasDrugFacts = flag;
        mEnergyGuideUrl = (URL)parcel.readSerializable();
        mBulkShippingMessage = parcel.readString();
        mParentTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsBuyNowEligible = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasNutritionalFlag = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsPickFromStoreEligible = flag;
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.product.c.values()[i1];
        }
        mChannelAvailabilityCode = ((c) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.product.j.values()[i1];
        }
        mManufacturingBrand = ((j) (obj));
        mTermsAndConditionUrl = (URL)parcel.readSerializable();
        mTargetWebUrl = (URL)parcel.readSerializable();
        mProductImage = (ProductImage)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductImage.getClassLoader());
        mStorePriceInfo = (ProductStoreInfo)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductStoreInfo.getClassLoader());
        mGuestReview = (ProductGuestReview)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductGuestReview.getClassLoader());
        mOnlinePriceInfo = (ProductOnlineInfo)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductOnlineInfo.getClassLoader());
        mIndustryRating = (ProductIndustryRating)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductIndustryRating.getClassLoader());
        mAgeRestriction = (ProductAgeRestriction)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductAgeRestriction.getClassLoader());
        mFeatures = new ArrayList();
        parcel.readList(mFeatures, com/target/mothership/model/product/handler/TGTProductFeature.getClassLoader());
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.product.b.values()[i1];
        }
        mCartWheelStatusCode = ((b) (obj));
        mCartWheelOffer = new ArrayList();
        parcel.readList(mCartWheelOffer, com/target/mothership/model/product/handler/TGTProductCartWheel.getClassLoader());
        mVariationValues = (ProductVariationValues)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductVariationValues.getClassLoader());
        mChockingHazard = new ArrayList();
        parcel.readList(mChockingHazard, com/target/mothership/model/product/handler/TGTProductChokingHazard.getClassLoader());
        mCalloutTypes = new ArrayList();
        parcel.readList(mCalloutTypes, com/target/mothership/model/product/handler/TGTProductCallout.getClassLoader());
        mPromotion = new ArrayList();
        parcel.readList(mPromotion, com/target/mothership/model/product/handler/TGTProductPromotion.getClassLoader());
        mCouponPromotionId = (CouponPromotionId)parcel.readParcelable(com/target/mothership/common/coupon_wallets/CouponPromotionId.getClassLoader());
        mGiftCardShippingMode = new ArrayList();
        parcel.readList(mGiftCardShippingMode, com/target/mothership/common/product/h.getClassLoader());
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsGiftCard = flag;
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.product.k.values()[i1];
        }
        mMediaFormat = ((k) (obj));
        mDvmRemoteData = (DvmRemoteData)parcel.readParcelable(com/target/mothership/model/common/TGTDvmRemoteData.getClassLoader());
    }

    public List A()
    {
        return com.target.mothership.util.k.a(mGiftCardShippingMode);
    }

    public boolean B()
    {
        return mIsGiftCard;
    }

    public e C()
    {
        return com.target.mothership.util.k.a(mDvmRemoteData);
    }

    public e a()
    {
        return com.target.mothership.util.k.a(mUpc);
    }

    public void a(CouponPromotionId couponpromotionid)
    {
        mCouponPromotionId = couponpromotionid;
    }

    public void a(CategoryId categoryid)
    {
        mCategoryId = categoryid;
    }

    public void a(Upc upc)
    {
        mUpc = upc;
    }

    public void a(b b1)
    {
        mCartWheelStatusCode = b1;
    }

    public void a(c c1)
    {
        mChannelAvailabilityCode = c1;
    }

    public void a(j j1)
    {
        mManufacturingBrand = j1;
    }

    public void a(k k1)
    {
        mMediaFormat = k1;
    }

    public void a(DvmRemoteData dvmremotedata)
    {
        mDvmRemoteData = dvmremotedata;
    }

    public void a(ProductAgeRestriction productagerestriction)
    {
        mAgeRestriction = productagerestriction;
    }

    public void a(ProductGuestReview productguestreview)
    {
        mGuestReview = productguestreview;
    }

    public void a(ProductImage productimage)
    {
        mProductImage = productimage;
    }

    public void a(ProductIndustryRating productindustryrating)
    {
        mIndustryRating = productindustryrating;
    }

    public void a(ProductOnlineInfo productonlineinfo)
    {
        mOnlinePriceInfo = productonlineinfo;
    }

    public void a(ProductRootLevelCategory productrootlevelcategory)
    {
        mProductRootLevelCategory = productrootlevelcategory;
    }

    public void a(ProductStoreInfo productstoreinfo)
    {
        mStorePriceInfo = productstoreinfo;
    }

    public void a(ProductVariationValues productvariationvalues)
    {
        mVariationValues = productvariationvalues;
    }

    public void a(String s1)
    {
        mDescription = s1;
    }

    public void a(URL url)
    {
        mEnergyGuideUrl = url;
    }

    public void a(List list)
    {
        mCartWheelOffer = list;
    }

    public void a(boolean flag)
    {
        mIsHazmat = flag;
    }

    public String b()
    {
        return mDescription;
    }

    public void b(Tcin tcin)
    {
        mParentTcin = tcin;
    }

    public void b(String s1)
    {
        mBulkShippingMessage = s1;
    }

    public void b(URL url)
    {
        mTermsAndConditionUrl = url;
    }

    public void b(List list)
    {
        mChockingHazard = list;
    }

    public void b(boolean flag)
    {
        mIsRecall = flag;
    }

    public ProductOnlineInfo c()
    {
        return mOnlinePriceInfo;
    }

    public void c(String s1)
    {
        mReturnPolicy = s1;
    }

    public void c(URL url)
    {
        mTargetWebUrl = url;
    }

    public void c(List list)
    {
        mFeatures = list;
    }

    public void c(boolean flag)
    {
        mIsBuyable = flag;
    }

    public void d(List list)
    {
        mCalloutTypes = list;
    }

    public void d(boolean flag)
    {
        mHasDrugFacts = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(List list)
    {
        mPromotion = list;
    }

    public void e(boolean flag)
    {
        mIsBuyNowEligible = flag;
    }

    public void f(List list)
    {
        mGiftCardShippingMode = list;
    }

    public void f(boolean flag)
    {
        mHasNutritionalFlag = flag;
    }

    public void g(boolean flag)
    {
        mIsPickFromStoreEligible = flag;
    }

    public e h()
    {
        return com.target.mothership.util.k.a(mParentTcin);
    }

    public void h(boolean flag)
    {
        mIsGiftCard = flag;
    }

    public c i()
    {
        return mChannelAvailabilityCode;
    }

    public e j()
    {
        return com.target.mothership.util.k.a(mGuestReview);
    }

    public boolean k()
    {
        return mHasNutritionalFlag;
    }

    public boolean l()
    {
        return mIsPickFromStoreEligible;
    }

    public List m()
    {
        return com.target.mothership.util.k.a(mChockingHazard);
    }

    public List n()
    {
        return com.target.mothership.util.k.a(mCartWheelOffer);
    }

    public j o()
    {
        return com.target.mothership.common.product.j.a(mManufacturingBrand.toString());
    }

    public e p()
    {
        return com.target.mothership.util.k.a(mTermsAndConditionUrl);
    }

    public e q()
    {
        return com.target.mothership.util.k.a(mTargetWebUrl);
    }

    public e r()
    {
        return com.target.mothership.util.k.a(mProductImage);
    }

    public e s()
    {
        return com.target.mothership.util.k.a(mProductRootLevelCategory);
    }

    public ProductAgeRestriction t()
    {
        return mAgeRestriction;
    }

    public ProductStoreInfo u()
    {
        return mStorePriceInfo;
    }

    public e v()
    {
        return com.target.mothership.util.k.a(mVariationValues);
    }

    public List w()
    {
        return com.target.mothership.util.k.a(mFeatures);
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        byte byte1 = -1;
        boolean flag = true;
        super.writeToParcel(parcel, i1);
        parcel.writeParcelable(mUpc, i1);
        parcel.writeParcelable(mCategoryId, 0);
        parcel.writeString(mDescription);
        parcel.writeString(mReturnPolicy);
        byte byte0;
        int j1;
        if (mIsHazmat)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsRecall)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsBuyable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mHasDrugFacts)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeSerializable(mEnergyGuideUrl);
        parcel.writeString(mBulkShippingMessage);
        parcel.writeParcelable(mParentTcin, i1);
        if (mIsBuyNowEligible)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mHasNutritionalFlag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsPickFromStoreEligible)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mChannelAvailabilityCode == null)
        {
            j1 = -1;
        } else
        {
            j1 = mChannelAvailabilityCode.ordinal();
        }
        parcel.writeInt(j1);
        if (mManufacturingBrand == null)
        {
            j1 = -1;
        } else
        {
            j1 = mManufacturingBrand.ordinal();
        }
        parcel.writeInt(j1);
        parcel.writeSerializable(mTermsAndConditionUrl);
        parcel.writeSerializable(mTargetWebUrl);
        parcel.writeParcelable(mProductImage, 0);
        parcel.writeParcelable(mStorePriceInfo, i1);
        parcel.writeParcelable(mGuestReview, 0);
        parcel.writeParcelable(mOnlinePriceInfo, i1);
        parcel.writeParcelable(mIndustryRating, 0);
        parcel.writeParcelable(mAgeRestriction, 0);
        parcel.writeList(mFeatures);
        if (mCartWheelStatusCode == null)
        {
            j1 = -1;
        } else
        {
            j1 = mCartWheelStatusCode.ordinal();
        }
        parcel.writeInt(j1);
        parcel.writeList(mCartWheelOffer);
        parcel.writeParcelable(mVariationValues, 0);
        parcel.writeList(mChockingHazard);
        parcel.writeList(mCalloutTypes);
        parcel.writeList(mPromotion);
        parcel.writeParcelable(mCouponPromotionId, i1);
        parcel.writeList(mGiftCardShippingMode);
        if (mIsGiftCard)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mMediaFormat == null)
        {
            i1 = byte1;
        } else
        {
            i1 = mMediaFormat.ordinal();
        }
        parcel.writeInt(i1);
        parcel.writeParcelable(mDvmRemoteData, 0);
    }

    public List x()
    {
        return com.target.mothership.util.k.a(mCalloutTypes);
    }

    public List y()
    {
        return com.target.mothership.util.k.a(mPromotion);
    }

    public e z()
    {
        return com.google.a.a.e.c(mCouponPromotionId);
    }

}
