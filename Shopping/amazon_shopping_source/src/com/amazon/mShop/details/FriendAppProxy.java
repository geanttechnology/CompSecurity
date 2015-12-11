// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.BuildUtils;
import com.amazon.mShop.util.Util;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            AmazonAppStoreProxy, AmazonMp3Proxy, AmazonKindleProxy, AmazonVideoProxy, 
//            ExternalBuyLinkProxy

public abstract class FriendAppProxy
{
    public static class Factory
    {

        public static FriendAppProxy getProxy(Context context, String s)
        {
            AmazonAppStoreProxy amazonappstoreproxy = null;
            if (FriendAppProxy.isAmazonAppstoreDownloadUrl(context, s))
            {
                amazonappstoreproxy = AmazonAppStoreProxy.getInstance();
            } else
            if (FriendAppProxy.isAmazonMp3DownloadUrl(context, s))
            {
                return AmazonMp3Proxy.getInstance();
            }
            return amazonappstoreproxy;
        }

        public static FriendAppProxy getProxy(ProductController productcontroller)
        {
            AmazonAppStoreProxy amazonappstoreproxy = null;
            if (productcontroller.isMobileApp())
            {
                amazonappstoreproxy = AmazonAppStoreProxy.getInstance();
            } else
            {
                if (productcontroller.isMusic())
                {
                    return AmazonMp3Proxy.getInstance();
                }
                if (productcontroller.isKindleBook())
                {
                    return AmazonKindleProxy.getInstance();
                }
                if (productcontroller.isVideo())
                {
                    return AmazonVideoProxy.getInstance();
                }
                if (productcontroller.hasExternalBuyLink())
                {
                    return new ExternalBuyLinkProxy(productcontroller);
                }
                if (productcontroller.isAudiobook())
                {
                    return null;
                }
            }
            return amazonappstoreproxy;
        }

        public Factory()
        {
        }
    }


    public FriendAppProxy()
    {
    }

    protected static boolean isAmazonAppstoreDownloadUrl(Context context, String s)
    {
        if (!Util.isEmpty(s))
        {
            context = Uri.parse(s).getPath();
            if (context != null && (context.startsWith("/gp/mas/get/android") || context.startsWith("/gp/mas/get-appstore/android")))
            {
                return true;
            }
        }
        return false;
    }

    protected static boolean isAmazonMp3DownloadUrl(Context context, String s)
    {
        if (!Util.isEmpty(s))
        {
            context = Uri.parse(s).getPath();
            if (context != null && context.startsWith("/gp/dmusic/device/android/buy.html"))
            {
                return true;
            }
        }
        return false;
    }

    protected void addRefTag(Context context, Intent intent)
    {
        intent.putExtra("ref", (new StringBuilder()).append("mShopAndroidApp").append(BuildUtils.getVersionName(context)).toString());
    }

    public abstract String getButtonLabel(Context context);

    protected Intent getIntentForFriendApp(Context context, ProductController productcontroller)
    {
        if (isAbleToStartFriendApp(context))
        {
            context = getIntentForStart(context, productcontroller);
        } else
        {
            context = getIntentForInstall(context);
        }
        if (context != null)
        {
            context.addFlags(0x10000000);
        }
        return context;
    }

    public Intent getIntentForFriendApp(Context context, String s)
    {
        if (isAbleToStartFriendApp(context))
        {
            context = getIntentForStart(context, s);
        } else
        {
            context = getIntentForInstall(context);
        }
        if (context != null)
        {
            context.addFlags(0x10000000);
        }
        return context;
    }

    protected Intent getIntentForInstall(Context context)
    {
        String s = context.getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_package_name);
        if (isAppInstalled(context, s))
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("amzn://apps/android?p=%s", new Object[] {
                getPackageName(context)
            })));
            intent.setPackage(s);
            addRefTag(context, intent);
            context = intent;
        } else
        {
            Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://search?q=pname:").append(getPackageName(context)).toString()));
            List list = context.getPackageManager().queryIntentActivities(intent1, 0x10000);
            if (list != null && list.size() > 0)
            {
                return intent1;
            }
            context = new Intent("android.intent.action.VIEW", Uri.parse(context.getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_landing_page_url)));
        }
        return context;
    }

    protected abstract Intent getIntentForStart(Context context, ProductController productcontroller);

    protected abstract Intent getIntentForStart(Context context, String s);

    protected abstract String getPackageName(Context context);

    protected abstract String getRefTag();

    public String getRefTagForFriendApp(Context context)
    {
        if (isAbleToStartFriendApp(context))
        {
            return (new StringBuilder()).append("b_").append(getRefTag()).toString();
        } else
        {
            return (new StringBuilder()).append("i_").append(getRefTag()).toString();
        }
    }

    public boolean isAbleToStartFriendApp(Context context)
    {
        while (!isFriendAppInstalled(context) || needFriendAppUpdate(context)) 
        {
            return false;
        }
        return true;
    }

    protected boolean isAppInstalled(Context context, String s)
    {
        return AppUtils.isAppInstalled(context, s);
    }

    protected boolean isFriendAppInstalled(Context context)
    {
        return AppUtils.isAppInstalled(context, getPackageName(context));
    }

    protected abstract boolean needFriendAppUpdate(Context context);
}
