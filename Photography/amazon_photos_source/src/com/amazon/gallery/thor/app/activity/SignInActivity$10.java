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

class val.titleText
    implements Callback
{

    final SignInActivity this$0;
    final TextView val$titleText;

    public void onError(Bundle bundle)
    {
        GLogger.d(SignInActivity.access$1100(), "Error occurred trying to fetch customer name for SSO", new Object[0]);
    }

    public void onSuccess(final Bundle bundle)
    {
        SignInActivity.access$1200(SignInActivity.this).post(new Runnable() {

            final SignInActivity._cls10 this$1;
            final Bundle val$bundle;

            public void run()
            {
                String s = bundle.getString("value_key");
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

            
            {
                this$1 = SignInActivity._cls10.this;
                bundle = bundle1;
                super();
            }
        });
    }

    _cls1.val.bundle()
    {
        this$0 = final_signinactivity;
        val$titleText = TextView.this;
        super();
    }
}
