// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (SignInActivity.access$500(_fld0).getVisibility() != 0)
        {
            SignInActivity.access$2000(_fld0);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/app/activity/SignInActivity$14

/* anonymous class */
    class SignInActivity._cls14
        implements android.view.animation.Animation.AnimationListener
    {

        final SignInActivity this$0;

        public void onAnimationEnd(Animation animation)
        {
            SignInActivity.access$1200(SignInActivity.this).post(new SignInActivity._cls14._cls1());
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
    }

}
