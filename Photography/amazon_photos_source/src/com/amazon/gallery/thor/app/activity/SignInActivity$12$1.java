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

class EmailListener
    implements Runnable
{

    final val.listener this$1;
    final com.amazon.gallery.thor.app.authentication.rvice.CustomerEmailListener val$listener;

    public void run()
    {
        Object obj = SignInActivity.access$1600(_fld0).getEmail();
        emailText.setText(((CharSequence) (obj)));
        obj = new AlphaAnimation(0.0F, 1.0F);
        ((Animation) (obj)).setDuration(1000L);
        ((Animation) (obj)).setFillAfter(true);
        emailText.startAnimation(((Animation) (obj)));
        FetchCustomerEmailService.removeListener(val$listener);
    }

    EmailListener()
    {
        this$1 = final_emaillistener;
        val$listener = com.amazon.gallery.thor.app.authentication.rvice.CustomerEmailListener.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/app/activity/SignInActivity$12

/* anonymous class */
    class SignInActivity._cls12
        implements com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService.CustomerEmailListener
    {

        final SignInActivity this$0;
        final TextView val$emailText;

        public void onCustomerEmailFetched()
        {
            SignInActivity.access$1200(SignInActivity.this).post(new SignInActivity._cls12._cls1());
        }

            
            {
                this$0 = final_signinactivity;
                emailText = TextView.this;
                super();
            }
    }

}
