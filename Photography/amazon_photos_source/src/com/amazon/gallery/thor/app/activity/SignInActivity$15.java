// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

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
        SignInActivity.access$500(SignInActivity.this).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
