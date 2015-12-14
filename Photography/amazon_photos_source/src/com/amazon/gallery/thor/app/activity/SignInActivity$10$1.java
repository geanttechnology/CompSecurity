// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class val.bundle
    implements Runnable
{

    final ring this$1;
    final Bundle val$bundle;

    public void run()
    {
        String s = val$bundle.getString("value_key");
        if (s != null && !s.equals(""))
        {
            String as[] = s.split("\\s");
            if (as.length > 0)
            {
                as = as[0];
            } else
            {
                as = "";
            }
            titleText.setText(getString(0x7f0e01f2, new Object[] {
                as
            }));
            return;
        } else
        {
            titleText.setText(getString(0x7f0e01f1));
            return;
        }
    }

    l.titleText()
    {
        this$1 = final_titletext;
        val$bundle = Bundle.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/app/activity/SignInActivity$10

/* anonymous class */
    class SignInActivity._cls10
        implements Callback
    {

        final SignInActivity this$0;
        final TextView val$titleText;

        public void onError(Bundle bundle1)
        {
            GLogger.d(SignInActivity.access$1100(), "Error occurred trying to fetch customer name for SSO", new Object[0]);
        }

        public void onSuccess(Bundle bundle1)
        {
            SignInActivity.access$1200(SignInActivity.this).post(bundle1. new SignInActivity._cls10._cls1());
        }

            
            {
                this$0 = final_signinactivity;
                titleText = TextView.this;
                super();
            }
    }

}
