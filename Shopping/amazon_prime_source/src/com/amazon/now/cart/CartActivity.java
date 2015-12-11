// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.web.NowWebFragment;
import com.amazon.now.web.WebActivity;

// Referenced classes of package com.amazon.now.cart:
//            CartController

public class CartActivity extends WebActivity
{

    private boolean mRefreshOnPause;

    public CartActivity()
    {
        mRefreshOnPause = false;
    }

    public static void startActivity(Context context)
    {
        startActivity(context, false);
    }

    public static void startActivity(Context context, boolean flag)
    {
        Intent intent = new Intent(context, com/amazon/now/cart/CartActivity);
        intent.addFlags(0x20000);
        if (flag)
        {
            NavManager.modifyIntentForNewStack(intent);
        }
        context.startActivity(intent);
    }

    protected String getLaunchUrl()
    {
        String s = super.getLaunchUrl();
        Object obj = s;
        if (s == null)
        {
            obj = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendPath("cart");
            obj = ((android.net.Uri.Builder) (obj)).build().toString();
        }
        return ((String) (obj));
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mWebFragment.loadUrl(getLaunchUrl());
    }

    public void onPause()
    {
        super.onPause();
        if (mRefreshOnPause)
        {
            CartController.getInstance().fetchCartCount(null, null);
        }
        mRefreshOnPause = false;
    }

    public void shouldRefreshOnPause(boolean flag)
    {
        mRefreshOnPause = flag;
    }
}
