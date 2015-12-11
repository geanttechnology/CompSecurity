// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.f;
import com.google.b.k;
import com.google.b.l;
import com.google.b.p;
import com.target.mothership.common.a.j;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.i;
import com.target.mothership.services.apigee.d.a;
import com.target.mothership.util.o;
import java.lang.reflect.Type;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            b

public class ak
{
    public static class a
        implements k
    {

        public ak a(l l1, Type type, com.google.b.j j1)
            throws p
        {
            j1 = new f();
            type = (ak)j1.a(l1, type);
            com.target.mothership.services.apigee.c.b.ak.a(type, (b)j1.a(l1, com/target/mothership/services/apigee/c/b/b));
            return type;
        }

        public Object deserialize(l l1, Type type, com.google.b.j j1)
            throws p
        {
            return a(l1, type, j1);
        }

        public a()
        {
        }
    }


    private static final String YES = "Y";
    private b mAddress;
    private List mAttachments;
    private String mCatalogEntryId;
    private String mDefaultAddressId;
    private String mDefaultFulfillmentType;
    private String mDefaultShipModeCode;
    private String mDpci;
    private String mGiftCardAddressId;
    private String mGiftCardFromName;
    private String mGiftCardToEmail;
    private String mGiftCardToName;
    private String mGiftCardToPhone;
    private i mInventoryStatus;
    private String mInventoryStatusString;
    private String mIsBulkyString;
    private String mIsDigitalDownloadString;
    private String mItemType;
    private String mMessage;
    private String mOrderItemDescription;
    private String mOrderItemId;
    private String mOrderItemPrice;
    private String mPartNumber;
    private String mPickUpEmailId;
    private String mPickUpPersonName;
    private String mPickUpPhoneNumber;
    private String mPickUpStoreId;
    private String mQuantity;
    private String mRegistryId;
    private String mRegistryName;
    private String mRegistryTypeString;
    private List mRewardOptions;
    private List mUsableShippingMode;

    public ak()
    {
    }

    static b a(ak ak1, b b1)
    {
        ak1.mAddress = b1;
        return b1;
    }

    public boolean A()
    {
        return com.target.mothership.util.o.g(mIsBulkyString) && "Y".equalsIgnoreCase(mIsBulkyString);
    }

    public boolean B()
    {
        if (com.target.mothership.util.o.g(mIsDigitalDownloadString))
        {
            return Boolean.parseBoolean(mIsDigitalDownloadString);
        } else
        {
            return false;
        }
    }

    public String C()
    {
        return mMessage;
    }

    public List D()
    {
        return mRewardOptions;
    }

    public Dpci a()
    {
        return new Dpci(mDpci);
    }

    public CatEntryId b()
    {
        return new CatEntryId(mCatalogEntryId);
    }

    public List c()
    {
        return mAttachments;
    }

    public String d()
    {
        return mDefaultAddressId;
    }

    public String e()
    {
        return mDefaultShipModeCode;
    }

    public String f()
    {
        return mDefaultFulfillmentType;
    }

    public i g()
    {
        if (mInventoryStatus == null)
        {
            mInventoryStatus = (new com.target.mothership.services.apigee.d.a()).a(mInventoryStatusString);
        }
        return mInventoryStatus;
    }

    public String h()
    {
        return mItemType;
    }

    public String i()
    {
        return mOrderItemDescription;
    }

    public String j()
    {
        return mOrderItemId;
    }

    public String k()
    {
        return mOrderItemPrice;
    }

    public String l()
    {
        return mPartNumber;
    }

    public String m()
    {
        return mQuantity;
    }

    public b n()
    {
        return mAddress;
    }

    public String o()
    {
        return mPickUpPersonName;
    }

    public String p()
    {
        return mPickUpStoreId;
    }

    public String q()
    {
        return mPickUpPhoneNumber;
    }

    public String r()
    {
        return mPickUpEmailId;
    }

    public String s()
    {
        return mGiftCardAddressId;
    }

    public String t()
    {
        return mGiftCardFromName;
    }

    public String u()
    {
        return mGiftCardToName;
    }

    public String v()
    {
        return mGiftCardToEmail;
    }

    public String w()
    {
        return mGiftCardToPhone;
    }

    public String x()
    {
        return mRegistryId;
    }

    public String y()
    {
        return mRegistryName;
    }

    public j z()
    {
        if (com.target.mothership.util.o.g(mRegistryTypeString))
        {
            return com.target.mothership.common.a.j.valueOf(mRegistryTypeString);
        } else
        {
            return j.UNKNOWN;
        }
    }
}
