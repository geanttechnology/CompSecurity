// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

// Referenced classes of package com.localytics.android:
//            DatapointHelper, Localytics

public class PushTrackingActivity extends Activity
{

    public PushTrackingActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        Object obj = DatapointHelper.getLocalyticsAppKeyOrNull(this);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            Localytics.integrate(getApplicationContext(), ((String) (obj)));
        }
        Localytics.openSession();
        Localytics.handlePushNotificationOpened(bundle);
        finish();
        obj = getPackageManager().getLaunchIntentForPackage(getPackageName());
        ((Intent) (obj)).putExtras(bundle);
        ((Intent) (obj)).addFlags(0x24000000);
        startActivity(((Intent) (obj)));
    }
}
