// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity, ThorChooserActivity, ThorNativeGalleryActivity

class this._cls0
    implements Runnable
{

    final SignInActivity this$0;

    public void run()
    {
        Object obj;
        if (getIntent().hasExtra("intent_extra_came_from_chooser"))
        {
            obj = new Intent(SignInActivity.this, com/amazon/gallery/thor/app/activity/ThorChooserActivity);
            ((Intent) (obj)).putExtra("intent_extra_came_from_chooser", true);
        } else
        {
            obj = new Intent(SignInActivity.this, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
        }
        ((Intent) (obj)).setAction("android.intent.action.MAIN");
        ((Intent) (obj)).putExtra("intent_extra_came_from_sign_in", true);
        startActivity(((Intent) (obj)));
        SignInActivity.access$1400(SignInActivity.this).trackEvent(ricEvent.SignInSuccess);
        obj = PreferenceManager.getDefaultSharedPreferences(SignInActivity.this);
        if (((SharedPreferences) (obj)).getString("referrer", null) != null && !((SharedPreferences) (obj)).getBoolean("ref_signin_complete_key", false))
        {
            String s = ((SharedPreferences) (obj)).getString("AMZN_REF_KEY", "NO_REF");
            SignInActivity.access$1400(SignInActivity.this).trackEvent(ricEvent.ReferredAppFirstSignIn, CustomerMetricsHelper.getExtraEventTag(s));
            ((SharedPreferences) (obj)).edit().putBoolean("ref_signin_complete_key", true).apply();
        }
        finish();
    }

    ctivity()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
