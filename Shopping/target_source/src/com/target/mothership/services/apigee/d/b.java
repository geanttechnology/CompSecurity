// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.d;

import com.target.mothership.common.a.d;
import com.target.mothership.common.a.j;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.i;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.d:
//            a, c

public class b
{
    public static class a
    {

        private String mDescription;
        private String mUsage;
        private String mValue;

        public String a()
        {
            return mDescription;
        }

        public String b()
        {
            return mValue;
        }

        public a()
        {
        }
    }


    private static final String YES = "Y";
    private List mAttachments;
    private String mCatEntryIdString;
    private String mDeliveryDateString;
    private String mDeliveryMethod;
    private String mDpciString;
    private String mEyebrowString;
    private List mFreeItems;
    private boolean mInventoryAvialable;
    private i mInventoryStatus;
    private String mInventoryStatusString;
    private String mIsBulkyString;
    private String mIsDigitalDownloadString;
    private String mIsEligibleForGiftWrapString;
    private String mIsFreeGiftString;
    private boolean mIsLimitedQuantityEligible;
    private boolean mIsOnlineAvailable;
    private boolean mIsPickupAvailable;
    private String mIsShipToStoreAvailableString;
    private String mItemId;
    private String mItemPriceCurrencyString;
    private String mItemPriceString;
    private String mLimitedQuantityString;
    private String mLimitedQuantityThresholdString;
    private String mMaxPurchaseLimitString;
    private String mName;
    private List mOfferList;
    private c mOrderItemCharges;
    private String mPreOrderDateString;
    private List mPriceList;
    private String mQuantityString;
    private String mRegistryId;
    private String mRegistryName;
    private String mRegistryTypeString;
    private List mRewardOptions;
    private List mServicePlans;
    private String mShipModeCodeString;
    private String mShipModeId;
    private String mShipModeString;
    private String mSignatureRequiredString;
    private String mSize;
    private String mStoreIdString;
    private String mStoreName;
    private String mTcinString;
    private String mUnitPrice;
    private String mValue;

    public b()
    {
        mServicePlans = new ArrayList();
        mIsOnlineAvailable = false;
        mIsPickupAvailable = false;
    }

    public String A()
    {
        return mRegistryId;
    }

    public String B()
    {
        return mRegistryName;
    }

    public j C()
    {
        if (com.target.mothership.util.o.g(mRegistryTypeString))
        {
            return com.target.mothership.common.a.j.a(mRegistryTypeString);
        } else
        {
            return j.UNKNOWN;
        }
    }

    public StoreIdentifier D()
    {
        if (com.target.mothership.util.o.g(mStoreIdString))
        {
            return new StoreIdentifier(mStoreIdString);
        } else
        {
            return null;
        }
    }

    public String E()
    {
        return mStoreName;
    }

    public List F()
    {
        return mRewardOptions;
    }

    public List G()
    {
        return mFreeItems;
    }

    public List H()
    {
        return mOfferList;
    }

    public c I()
    {
        return mOrderItemCharges;
    }

    public boolean J()
    {
        return Boolean.parseBoolean(mSignatureRequiredString);
    }

    public String K()
    {
        return mIsFreeGiftString;
    }

    public boolean L()
    {
        return mInventoryAvialable;
    }

    public boolean M()
    {
        return mIsLimitedQuantityEligible;
    }

    public String N()
    {
        return mLimitedQuantityString;
    }

    public String O()
    {
        return mLimitedQuantityThresholdString;
    }

    public List P()
    {
        return mPriceList;
    }

    public String a()
    {
        if (com.target.mothership.util.o.g(mShipModeCodeString))
        {
            return mShipModeCodeString;
        }
        if (com.target.mothership.util.o.g(mShipModeString))
        {
            return mShipModeString;
        }
        if (com.target.mothership.util.o.g(mDeliveryMethod))
        {
            return mDeliveryMethod;
        } else
        {
            return "";
        }
    }

    void a(c c1)
    {
        mOrderItemCharges = c1;
    }

    void a(String s1)
    {
        mSize = s1;
    }

    void a(boolean flag)
    {
        mIsOnlineAvailable = flag;
    }

    public String b()
    {
        return mShipModeId;
    }

    void b(String s1)
    {
        mDeliveryMethod = s1;
    }

    void b(boolean flag)
    {
        mIsPickupAvailable = flag;
    }

    void c(String s1)
    {
        mValue = s1;
    }

    public boolean c()
    {
        return mIsOnlineAvailable;
    }

    public String d()
    {
        return mSize;
    }

    public String e()
    {
        return mValue;
    }

    public boolean f()
    {
        return mIsPickupAvailable;
    }

    public Dpci g()
    {
        return new Dpci(mDpciString);
    }

    public CatEntryId h()
    {
        return new CatEntryId(mCatEntryIdString);
    }

    public String i()
    {
        return mDeliveryDateString;
    }

    public i j()
    {
        if (mInventoryStatus == null)
        {
            mInventoryStatus = (new com.target.mothership.services.apigee.d.a()).a(mInventoryStatusString);
        }
        return mInventoryStatus;
    }

    public String k()
    {
        return mName;
    }

    public String l()
    {
        return mItemId;
    }

    public String m()
    {
        return mItemPriceString;
    }

    public String n()
    {
        return mUnitPrice;
    }

    public Tcin o()
    {
        return new Tcin(mTcinString);
    }

    public String p()
    {
        return mQuantityString;
    }

    public String q()
    {
        return mIsShipToStoreAvailableString;
    }

    public String r()
    {
        return mMaxPurchaseLimitString;
    }

    public List s()
    {
        return mAttachments;
    }

    public boolean t()
    {
        return com.target.mothership.util.o.g(mIsBulkyString) && "Y".equalsIgnoreCase(mIsBulkyString);
    }

    public boolean u()
    {
        if (com.target.mothership.util.o.g(mIsDigitalDownloadString))
        {
            return Boolean.parseBoolean(mIsDigitalDownloadString);
        } else
        {
            return false;
        }
    }

    public boolean v()
    {
        return com.target.mothership.util.o.g(mDeliveryMethod);
    }

    public boolean w()
    {
        return j() == i.PreOrder;
    }

    public boolean x()
    {
        return j() == i.OnBackorder;
    }

    public String y()
    {
        return mPreOrderDateString;
    }

    public d z()
    {
        if (com.target.mothership.util.o.g(mEyebrowString))
        {
            return com.target.mothership.common.a.d.a(mEyebrowString);
        } else
        {
            return d.NONE;
        }
    }
}
