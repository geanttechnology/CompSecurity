// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            AttrsContainer

public class AbstractCoupon extends AttrsContainer
{

    public static final String DISPLAY_TYPE_INSTORE_PROMO_CODE = "instore_promo_code";
    public static final String DISPLAY_TYPE_INSTORE_SALE = "instore_sale";
    public static final String DISPLAY_TYPE_MOBILE_DOWNLOAD_PROMO_CODE = "mobile_download_promo_code";
    public static final String DISPLAY_TYPE_MOBILE_DOWNLOAD_SALE = "mobile_download_sale";
    public static final String DISPLAY_TYPE_ONLINE_INSTORE_PROMO_CODE = "online_instore_promo_code";
    public static final String DISPLAY_TYPE_ONLINE_INSTORE_SALE = "online_instore_sale";
    public static final String DISPLAY_TYPE_ONLINE_PROMO_CODE = "online_promo_code";
    public static final String DISPLAY_TYPE_ONLINE_SALE = "online_sale";
    public String derivedMerchantHiresLogoUrl;
    public String derivedMerchantLogoUrl;
    public String displayType;
    public boolean instoreOffer;
    public boolean isExclusive;
    public String merchantUuid;
    public boolean onlineOffer;
    public String productImageUrl;
    public String title;

    public AbstractCoupon()
    {
        title = "";
        displayType = "";
        isExclusive = false;
        derivedMerchantHiresLogoUrl = "";
        derivedMerchantLogoUrl = "";
        merchantUuid = "";
        productImageUrl = "";
        instoreOffer = false;
        onlineOffer = false;
    }

    public AbstractCoupon(AbstractCoupon abstractcoupon)
    {
        title = "";
        displayType = "";
        isExclusive = false;
        derivedMerchantHiresLogoUrl = "";
        derivedMerchantLogoUrl = "";
        merchantUuid = "";
        productImageUrl = "";
        instoreOffer = false;
        onlineOffer = false;
        title = abstractcoupon.title;
        displayType = abstractcoupon.displayType;
        isExclusive = abstractcoupon.isExclusive;
        derivedMerchantHiresLogoUrl = abstractcoupon.derivedMerchantHiresLogoUrl;
        derivedMerchantLogoUrl = abstractcoupon.derivedMerchantLogoUrl;
        productImageUrl = abstractcoupon.productImageUrl;
        instoreOffer = abstractcoupon.instoreOffer;
        onlineOffer = abstractcoupon.onlineOffer;
    }

    public String getImageUrl()
    {
        if (Strings.notEmpty(derivedMerchantHiresLogoUrl))
        {
            return derivedMerchantHiresLogoUrl;
        } else
        {
            return derivedMerchantLogoUrl;
        }
    }
}
