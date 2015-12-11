// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.web:
//            WebActivity, NowWebFragment

public class ContactUsActivity extends WebActivity
{

    public ContactUsActivity()
    {
    }

    public static void startActivity(Context context)
    {
        Intent intent = new Intent(context, com/amazon/now/web/ContactUsActivity);
        intent.addFlags(0x20000);
        context.startActivity(intent);
    }

    protected String getLaunchUrl()
    {
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        builder.appendPath("contactUs");
        return builder.build().toString();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mWebFragment.loadUrl(getLaunchUrl());
    }

    public void onResume()
    {
        super.onResume();
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final ContactUsActivity this$0;

            public void run()
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentView().getWindowToken(), 0);
            }

            
            {
                this$0 = ContactUsActivity.this;
                super();
            }
        }, 100L);
    }
}
