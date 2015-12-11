// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.orders;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.now.AmazonActivity;
import com.amazon.now.account.SSO;
import com.amazon.now.map.MapWebActivity;
import com.amazon.now.util.AppUtils;
import java.util.List;

public class OrderStatusActivity extends AmazonActivity
{

    public OrderStatusActivity()
    {
    }

    private void handleRestaurantsUrlPath(List list)
    {
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        builder.appendPath((String)list.get(0));
        builder.appendPath((String)list.get(1));
        if (list.size() == 3)
        {
            builder.appendQueryParameter("orderId", (String)list.get(2));
        }
        launchMapActivity(builder.build().toString());
    }

    private void handleUrlPath(List list)
    {
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        builder.appendPath((String)list.get(0));
        if (list.size() == 2)
        {
            builder.appendQueryParameter("orderId", (String)list.get(1));
        }
        builder.appendQueryParameter("externalRequest", "1");
        launchMapActivity(builder.build().toString());
    }

    private void launchMapActivity(final String url)
    {
        SSO.authenticateUser(this, new com.amazon.now.account.SSO.SignInCallback() {

            final OrderStatusActivity this$0;
            final String val$url;

            public void failure()
            {
                finish();
            }

            public void success(Activity activity)
            {
                MapWebActivity.startActivity(OrderStatusActivity.this, url, false, true);
                finish();
            }

            
            {
                this$0 = OrderStatusActivity.this;
                url = s;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            bundle = getIntent().getData();
            if (bundle != null && bundle.getHost() != null && bundle.getHost().contains("primenow.amazon."))
            {
                bundle = bundle.getPathSegments();
                if (bundle.isEmpty())
                {
                    finish();
                }
                if (!((String)bundle.get(0)).equalsIgnoreCase("orderStatus"))
                {
                    break label0;
                }
                handleUrlPath(bundle);
            }
            return;
        }
        if (((String)bundle.get(0)).equalsIgnoreCase("restaurants"))
        {
            handleRestaurantsUrlPath(bundle);
            return;
        } else
        {
            finish();
            return;
        }
    }
}
