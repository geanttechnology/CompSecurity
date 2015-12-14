// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls0
    implements android.view.animation.nListener
{

    final SignInActivity this$0;

    public void onAnimationEnd(Animation animation)
    {
        SignInActivity.access$1200(SignInActivity.this).post(new Runnable() {

            final SignInActivity._cls14 this$1;

            public void run()
            {
                if (SignInActivity.access$500(this$0).getVisibility() != 0)
                {
                    SignInActivity.access$2000(this$0);
                }
            }

            
            {
                this$1 = SignInActivity._cls14.this;
                super();
            }
        });
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
