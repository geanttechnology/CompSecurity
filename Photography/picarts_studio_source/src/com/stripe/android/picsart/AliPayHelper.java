// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import android.app.Activity;
import android.content.Intent;
import myobfuscated.bp.d;
import org.json.JSONObject;

public class AliPayHelper
{

    private static volatile AliPayHelper instance;
    d mPurchaseListener;
    int mRequestCode;
    String shopItemId;

    public AliPayHelper()
    {
    }

    public static AliPayHelper getInstance()
    {
        if (instance == null)
        {
            instance = new AliPayHelper();
        }
        return instance;
    }

    public boolean handleActivityResult(int i, int j, Intent intent)
    {
        boolean flag = false;
        if (i != mRequestCode)
        {
            return false;
        }
        intent = mPurchaseListener;
        if (j == -1)
        {
            flag = true;
        }
        intent.a(flag, shopItemId, new JSONObject());
        return true;
    }

    public void launchPurchase(Activity activity, d d1, int i, String s, double d2)
    {
        mPurchaseListener = d1;
        shopItemId = s;
        mRequestCode = i;
        d1 = new Intent();
        d1.putExtra("item.price", d2);
        d1.setClassName(activity.getPackageName(), "com.stripe.android.picsart.StripeAuthActivity");
        activity.startActivityForResult(d1, i);
    }
}
