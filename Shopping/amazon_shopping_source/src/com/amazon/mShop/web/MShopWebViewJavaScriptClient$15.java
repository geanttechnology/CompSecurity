// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.opl.PurchaseParams;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.offerId
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$asin;
    final String val$clickStream;
    final String val$dealId;
    final String val$listId;
    final String val$listItemId;
    final String val$offerId;
    final String val$oneClickShippingSpeed;

    public void run()
    {
        Object obj;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$clickStream))
        {
            obj = val$clickStream;
        } else
        if ((MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this) instanceof AmazonActivity) && !Util.isEmpty(((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this)).getClickStreamOrigin()))
        {
            obj = ((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this)).getClickStreamOrigin();
        } else
        {
            obj = ClickStreamTag.ORIGIN_DEFAULT.getTag();
        }
        s1 = val$dealId;
        s = s1;
        if (!MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, s1))
        {
            s = null;
        }
        s2 = val$listId;
        s1 = s2;
        if (!MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, s2))
        {
            s1 = null;
        }
        s3 = val$listItemId;
        s2 = s3;
        if (!MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, s3))
        {
            s2 = null;
        }
        s4 = val$oneClickShippingSpeed;
        s3 = s4;
        if (!MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, s4))
        {
            s3 = null;
        }
        obj = new PurchaseParams(val$asin, val$offerId, s1, s2, s, s3, ((String) (obj)));
        ActivityUtils.startPurchaseActivity(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this), ((PurchaseParams) (obj)));
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$clickStream = s;
        val$dealId = s1;
        val$listId = s2;
        val$listItemId = s3;
        val$oneClickShippingSpeed = s4;
        val$asin = s5;
        val$offerId = String.this;
        super();
    }
}
