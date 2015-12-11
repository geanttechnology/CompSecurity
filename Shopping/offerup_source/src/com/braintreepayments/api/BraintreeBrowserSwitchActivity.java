// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;

// Referenced classes of package com.braintreepayments.api:
//            BraintreeBroadcastManager

public class BraintreeBrowserSwitchActivity extends Activity
{

    public static final String EXTRA_REDIRECT_URL = "com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REDIRECT_URL";
    public static final String EXTRA_REQUEST_URL = "com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REQUEST_URL";
    public static final String LOCAL_BROADCAST_BROWSER_SWITCH_COMPLETED = "com.braintreepayments.api.messages.LOCAL_BROADCAST_BROWSER_SWITCH_COMPLETED";
    private boolean mShouldCancelOnResume;

    public BraintreeBrowserSwitchActivity()
    {
        mShouldCancelOnResume = false;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(0x106000d);
        String s = getIntent().getStringExtra("com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REQUEST_URL");
        bundle = s;
        if (s == null)
        {
            bundle = getIntent().getStringExtra("com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REDIRECT_URL");
        }
        if (bundle != null)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bundle)));
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        intent = (new Intent("com.braintreepayments.api.messages.LOCAL_BROADCAST_BROWSER_SWITCH_COMPLETED")).putExtra("com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REDIRECT_URL", intent.getData());
        BraintreeBroadcastManager.getInstance(this).sendBroadcastSync(intent);
        finish();
    }

    protected void onPause()
    {
        super.onPause();
        mShouldCancelOnResume = true;
    }

    protected void onResume()
    {
        super.onResume();
        if (mShouldCancelOnResume)
        {
            finish();
        }
    }
}
