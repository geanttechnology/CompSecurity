// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.view.animation.Animation;
import android.widget.ProgressBar;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class val.delayFadeAnimation
    implements Runnable
{

    final AuthPortalUIActivity this$0;
    final Animation val$delayFadeAnimation;

    public void run()
    {
        ProgressBar progressbar = (ProgressBar)findViewById(AuthPortalUIActivity.access$2400(AuthPortalUIActivity.this));
        progressbar.startAnimation(val$delayFadeAnimation);
        progressbar.setVisibility(4);
    }

    ()
    {
        this$0 = final_authportaluiactivity;
        val$delayFadeAnimation = Animation.this;
        super();
    }
}
