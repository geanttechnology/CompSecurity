// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.amazon.mShop.control.item.ProductController;

// Referenced classes of package com.amazon.mShop.details:
//            FriendAppProxy

public class AmazonVideoProxy extends FriendAppProxy
{

    private static final AmazonVideoProxy instance = new AmazonVideoProxy();

    private AmazonVideoProxy()
    {
    }

    public static AmazonVideoProxy getInstance()
    {
        return instance;
    }

    public String getButtonLabel(Context context)
    {
        if (isFriendAppInstalled(context))
        {
            if (needFriendAppUpdate(context))
            {
                return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_update_amazon_video_to_buy);
            } else
            {
                return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_buy_now_from_amazon_video);
            }
        } else
        {
            return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_install_amazon_video_to_buy);
        }
    }

    protected Intent getIntentForStart(Context context, ProductController productcontroller)
    {
        return getIntentForStart(context, null, productcontroller.getAsin());
    }

    protected Intent getIntentForStart(Context context, String s)
    {
        return null;
    }

    public Intent getIntentForStart(Context context, String s, String s1)
    {
        s = new Intent("android.intent.action.VIEW", Uri.parse("content://com.amazon.avod.detail"));
        s.putExtra("asin", s1);
        addRefTag(context, s);
        return s;
    }

    protected String getPackageName(Context context)
    {
        return "com.amazon.avod";
    }

    protected String getRefTag()
    {
        return "aiv";
    }

    protected boolean needFriendAppUpdate(Context context)
    {
        return false;
    }

}
