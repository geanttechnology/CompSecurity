// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.platform.AppLocale;
import java.util.Locale;

// Referenced classes of package com.amazon.mShop.details:
//            FriendAppProxy

public class AmazonKindleProxy extends FriendAppProxy
{

    private static final AmazonKindleProxy instance = new AmazonKindleProxy();

    private AmazonKindleProxy()
    {
    }

    public static AmazonKindleProxy getInstance()
    {
        return instance;
    }

    public String getButtonLabel(Context context)
    {
        if (isFriendAppInstalled(context))
        {
            if (needFriendAppUpdate(context))
            {
                return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_update_amazon_kindle_to_buy);
            } else
            {
                return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_buy_now_from_amazon_kindle);
            }
        } else
        {
            return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_install_amazon_kindle_to_buy);
        }
    }

    protected Intent getIntentForInstall(Context context)
    {
        if (!AppLocale.getInstance().getCurrentLocale().toString().equals("zh_CN"))
        {
            return super.getIntentForInstall(context);
        } else
        {
            return new Intent("android.intent.action.VIEW", Uri.parse("https://www.amazon.cn/gp/aw/feature/id=cn_app_download"));
        }
    }

    protected Intent getIntentForStart(Context context, ProductController productcontroller)
    {
        return getIntentForStart(context, productcontroller.getGroupId(), productcontroller.getAsin());
    }

    protected Intent getIntentForStart(Context context, String s)
    {
        return null;
    }

    public Intent getIntentForStart(Context context, String s, String s1)
    {
        if ("ebooks_display_on_website".equals(s))
        {
            s = "kindle://store/openstore/asin/?asin=%s";
        } else
        {
            s = "kindle://store/openstore/?asin=%s&storefront-context=periodicals";
        }
        s = new Intent("android.intent.action.VIEW", Uri.parse(String.format(s, new Object[] {
            s1
        })));
        addRefTag(context, s);
        return s;
    }

    protected String getPackageName(Context context)
    {
        return "com.amazon.kindle";
    }

    protected String getRefTag()
    {
        return "kindle";
    }

    protected boolean needFriendAppUpdate(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int i;
        try
        {
            i = packagemanager.getPackageInfo(getPackageName(context), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        return i < 1;
    }

}
