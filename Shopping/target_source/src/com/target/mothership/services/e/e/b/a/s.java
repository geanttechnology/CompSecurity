// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b.a;

import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.CategoryId;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.target.mothership.services.e.e.b.a:
//            h, i, j, o, 
//            n, v, y

public class s
{

    private String mAgeRestriction;
    private String mBulkShippingMessage;
    private List mCallout;
    private List mCartWheelOffer;
    private String mCartWheelStatusCode;
    private int mCatalogEntryId;
    private String mCategoryId;
    private String mChannelAvailabilityCode;
    private List mChockingHazards;
    private String mCouponPromotionId;
    private String mDescription;
    private String mDpci;
    private boolean mDrugFactsExist;
    private URL mDvmImpressionUrl;
    private URL mEnergyGuideUri;
    private List mFeatures;
    private List mGiftCardShippingMode;
    private h mGuestReviews;
    private i mImages;
    private j mIndustryRating;
    private boolean mIsBuyItNowEligible;
    private boolean mIsBuyable;
    private boolean mIsHazmat;
    private boolean mIsPickUPFromStoreEligible;
    private String mItemType;
    private String mManufacturingBrand;
    private String mMediaFormat;
    private boolean mNutritionalInfoExists;
    private o mOnlinePriceInfo;
    private String mParentTcin;
    private List mPromotion;
    private boolean mRecallExists;
    private String mReturnPolicy;
    private n mRootOnlineCategory;
    private v mStoreInfo;
    private String mStoreInfoStatusCode;
    private URL mTargetWebUri;
    private String mTcin;
    private URL mTermsAndConditionUri;
    private String mTitle;
    private String mUpc;
    private y mVariationValue;

    public s()
    {
    }

    public String A()
    {
        return mManufacturingBrand;
    }

    public URL B()
    {
        return mTermsAndConditionUri;
    }

    public URL C()
    {
        return mTargetWebUri;
    }

    public i D()
    {
        return mImages;
    }

    public j E()
    {
        return mIndustryRating;
    }

    public String F()
    {
        return mAgeRestriction;
    }

    public URL G()
    {
        return mEnergyGuideUri;
    }

    public String H()
    {
        return mBulkShippingMessage;
    }

    public String I()
    {
        return mParentTcin;
    }

    public String J()
    {
        return mStoreInfoStatusCode;
    }

    public v K()
    {
        return mStoreInfo;
    }

    public y L()
    {
        return mVariationValue;
    }

    public List M()
    {
        return mFeatures;
    }

    public String N()
    {
        return mReturnPolicy;
    }

    public String O()
    {
        return mItemType;
    }

    public List P()
    {
        return mCallout;
    }

    public List Q()
    {
        return mPromotion;
    }

    public String R()
    {
        return mCouponPromotionId;
    }

    public List S()
    {
        return mGiftCardShippingMode;
    }

    public String T()
    {
        return mMediaFormat;
    }

    public URL U()
    {
        return mDvmImpressionUrl;
    }

    public String f()
    {
        return mDpci;
    }

    public String g()
    {
        return mTcin;
    }

    public String h()
    {
        return mUpc;
    }

    public String i()
    {
        return mTitle;
    }

    public String j()
    {
        return mDescription;
    }

    public o k()
    {
        return mOnlinePriceInfo;
    }

    public CatEntryId l()
    {
        return new CatEntryId(Integer.toString(mCatalogEntryId));
    }

    public CategoryId m()
    {
        if (mCategoryId == null)
        {
            return null;
        } else
        {
            return new CategoryId(mCategoryId);
        }
    }

    public String n()
    {
        return mChannelAvailabilityCode;
    }

    public h o()
    {
        return mGuestReviews;
    }

    public boolean p()
    {
        return mNutritionalInfoExists;
    }

    public boolean q()
    {
        return mDrugFactsExist;
    }

    public boolean r()
    {
        return mRecallExists;
    }

    public boolean s()
    {
        return mIsHazmat;
    }

    public boolean t()
    {
        return mIsBuyable;
    }

    public boolean u()
    {
        return mIsBuyItNowEligible;
    }

    public boolean v()
    {
        return mIsPickUPFromStoreEligible;
    }

    public List w()
    {
        return mChockingHazards;
    }

    public List x()
    {
        return mCartWheelOffer;
    }

    public String y()
    {
        return mCartWheelStatusCode;
    }

    public n z()
    {
        return mRootOnlineCategory;
    }
}
