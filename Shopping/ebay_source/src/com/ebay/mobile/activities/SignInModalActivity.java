// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, SignInActivity, SignInModalFragment

public class SignInModalActivity extends BaseActivity
{

    public static final String EXTRA_CLIENT_INT = "client_int";
    public static final String EXTRA_FROM_HOME = "fromHome";
    public static final String EXTRA_IAF_TOKEN = "iaf_token";
    public static final String EXTRA_PREV_USERNAME = "prevUser";
    public static final String EXTRA_REDIRECT_INTENTS = "redirect_intents";
    public static final String EXTRA_USER = "user";

    public SignInModalActivity()
    {
    }

    public static Intent getIntentForSignIn(String s, Context context)
    {
        if (DeviceConfiguration.getAsync().get(DcsBoolean.connectSignInModalDialog))
        {
            context = new Intent(context, com/ebay/mobile/activities/SignInModalActivity);
        } else
        {
            context = new Intent(context, com/ebay/mobile/activities/SignInActivity);
        }
        if (!TextUtils.isEmpty(s))
        {
            context.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(s));
        }
        return context;
    }

    public String getTrackingEventName()
    {
        return "SignInEntry";
    }

    public void onBackPressed()
    {
        TrackingData trackingdata = new TrackingData("SignInExit", TrackingType.EVENT);
        trackingdata.addKeyValuePair("isBack", "1");
        trackingdata.send(this);
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03024c);
        ((SignInModalFragment)getFragmentManager().findFragmentById(0x7f1007e9)).processArguments(getIntent().getExtras());
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        SignInModalFragment signinmodalfragment = (SignInModalFragment)getFragmentManager().findFragmentById(0x7f1007e9);
        if (signinmodalfragment != null)
        {
            signinmodalfragment.onNewIntent(intent);
        }
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }
}
