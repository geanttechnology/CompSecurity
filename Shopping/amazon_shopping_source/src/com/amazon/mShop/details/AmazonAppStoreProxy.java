// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.details:
//            FriendAppProxy

public class AmazonAppStoreProxy extends FriendAppProxy
{

    private static final AmazonAppStoreProxy instance = new AmazonAppStoreProxy();

    public AmazonAppStoreProxy()
    {
    }

    public static AmazonAppStoreProxy getInstance()
    {
        return instance;
    }

    public String getButtonLabel(Context context)
    {
        if (isFriendAppInstalled(context))
        {
            return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_buy_now_from_amazon_appstore);
        } else
        {
            return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_install_amazon_appstore_to_buy);
        }
    }

    public Intent getIntentForInstall(Context context)
    {
        context = context.getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_landing_page_url);
        if (Util.isEmpty(context))
        {
            Log.e("Amazon.AmazonAppStoreProxy", "landing page is empty.");
            return null;
        } else
        {
            return new Intent("android.intent.action.VIEW", Uri.parse(context));
        }
    }

    protected Intent getIntentForStart(Context context, ProductController productcontroller)
    {
        return getIntentForStart(context, null, productcontroller.getAsin());
    }

    protected Intent getIntentForStart(Context context, String s)
    {
        s = Uri.parse(s.toLowerCase()).getQueryParameter("asin");
        if (Util.isEmpty(s))
        {
            UIUtils.info(context, com.amazon.mShop.android.lib.R.string.error_can_not_find_product);
            return null;
        } else
        {
            return getIntentForStart(context, null, s);
        }
    }

    public Intent getIntentForStart(Context context, String s, String s1)
    {
        s = new Intent("android.intent.action.VIEW", Uri.parse(String.format("amzn://apps/android?asin=%s", new Object[] {
            s1
        })));
        addRefTag(context, s);
        return s;
    }

    protected String getPackageName(Context context)
    {
        return context.getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_package_name);
    }

    protected String getRefTag()
    {
        return "app";
    }

    protected boolean needFriendAppUpdate(Context context)
    {
        return false;
    }

}
