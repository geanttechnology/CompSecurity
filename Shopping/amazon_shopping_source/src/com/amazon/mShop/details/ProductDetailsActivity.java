// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.home.EulaDialog;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;

public class ProductDetailsActivity extends AmazonActivity
{

    private static ProductController sGlobalProductController;

    public ProductDetailsActivity()
    {
    }

    public static String getViewIntentUri(String s, Context context)
    {
        context = new Intent();
        context.setAction("android.intent.action.VIEW");
        context.setDataAndType(Uri.parse((new StringBuilder()).append("mshop://featured?ASIN=").append(s).toString()), "vnd.android.cursor.item/vnd.amazon.mShop.featured");
        return context.toUri(1);
    }

    protected void handleForceSignIn()
    {
        if (isLaunchedFromPublicUrl())
        {
            SSOUtil.handleSigninPrompt(this);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(com.amazon.mShop.android.lib.R.string.product_details_activity_name);
        bundle = null;
        Object obj = null;
        Uri uri = getIntent().getData();
        if (uri != null)
        {
            bundle = null;
            if ("amazonmobile".equals(uri.getScheme()))
            {
                bundle = uri.getQueryParameter("asin");
            } else
            if ("mshop".equals(uri.getScheme()))
            {
                bundle = uri.getQueryParameter("ASIN");
            }
            if (bundle != null)
            {
                obj = getClickStreamOrigin();
                if (Util.isEmpty(((String) (obj))))
                {
                    obj = ClickStreamTag.ORIGIN_REMEMBERS;
                } else
                {
                    obj = new ClickStreamTag(((String) (obj)));
                }
                obj = new ProductController(bundle, ((ClickStreamTag) (obj)));
            }
            EulaDialog.showEulaIfNeeded(this);
        } else
        {
            obj = bundle;
            if (sGlobalProductController != null)
            {
                obj = sGlobalProductController;
                sGlobalProductController = null;
            }
        }
        if (obj == null)
        {
            finish();
            return;
        } else
        {
            ActivityUtils.goToUdp(this, ((ProductController) (obj)), null, -1);
            finish();
            return;
        }
    }
}
