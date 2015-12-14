// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class val.emailText
    implements com.amazon.gallery.thor.app.authentication.Service.CustomerEmailListener
{

    final SignInActivity this$0;
    final TextView val$emailText;

    public void onCustomerEmailFetched()
    {
        SignInActivity.access$1200(SignInActivity.this).post(new Runnable() {

            final SignInActivity._cls12 this$1;
            final com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService.CustomerEmailListener val$listener;

            public void run()
            {
                Object obj = SignInActivity.access$1600(this$0).getEmail();
                emailText.setText(((CharSequence) (obj)));
                obj = new AlphaAnimation(0.0F, 1.0F);
                ((Animation) (obj)).setDuration(1000L);
                ((Animation) (obj)).setFillAfter(true);
                emailText.startAnimation(((Animation) (obj)));
                FetchCustomerEmailService.removeListener(listener);
            }

            
            {
                this$1 = SignInActivity._cls12.this;
                listener = customeremaillistener;
                super();
            }
        });
    }

    _cls1.val.listener()
    {
        this$0 = final_signinactivity;
        val$emailText = TextView.this;
        super();
    }
}
