// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.amazon.identity.auth.device.api.MAPBroadcastReceiver;
import com.amazon.mShop.AmazonApplication;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AndroidPlatform;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, IdentityType

public class SSOBackgroundAccountService extends IntentService
{

    public SSOBackgroundAccountService()
    {
        super(com/amazon/mShop/sso/SSOBackgroundAccountService.getSimpleName());
    }

    public void onCreate()
    {
        super.onCreate();
        if (AndroidPlatform.getInstance() == null)
        {
            AmazonApplication.setUp(getApplicationContext());
        }
        CookieBridge.init(getApplicationContext());
    }

    protected void onHandleIntent(Intent intent)
    {
        if (SSOUtil.DEBUG)
        {
            String s = null;
            if (intent != null)
            {
                s = intent.getStringExtra("com.amazon.dcp.sso.extra.account.directed_id");
            }
            Log.v("Amazon.SSOUtil", (new StringBuilder()).append("In SSOBackgroundAccountService onHandleIntent: ").append(intent.getAction()).append(" account is : ").append(s).toString());
        }
        Intent intent2 = MAPBroadcastReceiver.constructBackwardsCompatibleIntent(getApplicationContext(), intent);
        Intent intent1 = intent2;
        if (intent2 == null)
        {
            intent1 = intent;
        }
        SSOUtil.getCurrentIdentityType().handleBackgroundService(this, intent1);
    }
}
