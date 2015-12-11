// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;

import android.content.res.Resources;

// Referenced classes of package com.amazon.mShop.platform:
//            Resources

public class AndroidResources
    implements com.amazon.mShop.platform.Resources
{

    private final Resources res;

    public AndroidResources(Resources resources)
    {
        res = resources;
    }

    public String getAddressFormat(String s)
    {
        if ("CN".equals(s))
        {
            return res.getString(com.amazon.mShop.android.lib.R.string.address_format_CN);
        }
        if ("FR".equals(s))
        {
            return res.getString(com.amazon.mShop.android.lib.R.string.address_format_FR);
        }
        if ("JP".equals(s))
        {
            return res.getString(com.amazon.mShop.android.lib.R.string.address_format_JP);
        } else
        {
            return res.getString(com.amazon.mShop.android.lib.R.string.address_format_default);
        }
    }

    public Integer getDimensionPixelSize(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 11: // '\013'
            return Integer.valueOf(res.getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.product_images_height));
        }
    }

    public String getString(int i)
    {
        switch (i)
        {
        case 2: // '\002'
        default:
            return null;

        case 0: // '\0'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_gift_options_gift_wrap_no_gift_wrap);

        case 1: // '\001'
            return res.getString(com.amazon.mShop.android.lib.R.string.payment_format_credit_card_expiration_date_addreviated);

        case 3: // '\003'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_order_status_error_invalid_billing_address);

        case 4: // '\004'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_order_status_error_cannot_ship_to_address);

        case 5: // '\005'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_order_status_error_purchase_error);

        case 6: // '\006'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_order_status_error_quantity_unavailable);

        case 7: // '\007'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_order_status_error_address_needs_correcting);

        case 8: // '\b'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_order_status_error_invalid_payment_plan);

        case 9: // '\t'
            return res.getString(com.amazon.mShop.android.lib.R.string.opl_delivery_time_select_error);
        }
    }
}
