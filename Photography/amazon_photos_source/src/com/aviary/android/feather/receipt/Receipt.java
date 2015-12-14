// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import android.content.Context;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.common.utils.SDKUtils;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.receipt:
//            ReceiptUtils

public final class Receipt
{
    public static class Builder
    {

        private final boolean mIsFree;
        private boolean mIsNewPurchase;
        private String mOrderId;
        private String mPrice;
        private String mProductId;
        private long mPurchaseTime;
        private String mToken;

        public Receipt build()
            throws AssertionError
        {
            Receipt receipt = new Receipt(mProductId, mPurchaseTime);
            receipt.isNewPurchase = mIsNewPurchase;
            if (mIsFree)
            {
                receipt.isFree = true;
            } else
            {
                receipt.isFree = false;
                if (mIsNewPurchase)
                {
                    Assert.assertNotNull("orderId cannot be null", mOrderId);
                    Assert.assertNotNull("token cannot be null", mToken);
                    Assert.assertNotNull("price cannot be null", mPrice);
                    receipt.orderId = mOrderId;
                    receipt.purchaseToken = mToken;
                    receipt.price = mPrice;
                    return receipt;
                }
            }
            return receipt;
        }

        public Builder isNewPurchase(boolean flag)
        {
            mIsNewPurchase = flag;
            return this;
        }

        public Builder withOrderId(String s)
        {
            mOrderId = s;
            return this;
        }

        public Builder withPrice(String s)
        {
            mPrice = s;
            return this;
        }

        public Builder withProductId(String s)
        {
            mProductId = s;
            return this;
        }

        public Builder withPurchaseTime(long l)
        {
            mPurchaseTime = l;
            return this;
        }

        public Builder withToken(String s)
        {
            mToken = s;
            return this;
        }

        public Builder(boolean flag)
        {
            mIsFree = flag;
        }
    }


    boolean isFree;
    boolean isNewPurchase;
    String orderId;
    String price;
    final String productId;
    final long purchaseTime;
    String purchaseToken;

    Receipt(String s, long l)
    {
        productId = s;
        purchaseTime = l;
    }

    public JSONObject toJSON(Context context)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("apiKey", SDKUtils.getApiKey(context));
        jsonobject.put("sdkVersion", String.valueOf(380));
        jsonobject.put("binaryVersion", String.valueOf(ReceiptUtils.getBinaryVersion(context)));
        jsonobject.put("aviaryId", ReceiptUtils.getUserUUID(context));
        jsonobject.put("productId", productId);
        jsonobject.put("packageName", context.getPackageName());
        jsonobject.put("country", ReceiptUtils.getCountry());
        jsonobject.put("language", ReceiptUtils.getLanguage());
        jsonobject.put("purchaseTime", purchaseTime);
        boolean flag;
        if (!PackageManagerUtils.isDebugVersion(context))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jsonobject.put("isProduction", flag);
        if (!isFree)
        {
            jsonobject.put("isNewPurchase", isNewPurchase);
            if (orderId != null)
            {
                jsonobject.put("orderId", orderId);
            }
            if (purchaseToken != null)
            {
                jsonobject.put("receipt", purchaseToken);
            }
            if (price != null)
            {
                jsonobject.put("price", price);
            }
        }
        return jsonobject;
    }
}
