// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.animation.Animator;
import android.widget.ImageView;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView

class this._cls0
    implements android.animation.rListener
{

    final LightboxView this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        LightboxView.access$600(LightboxView.this).setVisibility(8);
        LightboxView.access$500(LightboxView.this, 2500L, 500L);
        LightboxView.access$1002(LightboxView.this, false);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = LightboxView.this;
        super();
    }
}
