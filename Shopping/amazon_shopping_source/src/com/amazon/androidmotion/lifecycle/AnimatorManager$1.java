// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.lifecycle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.amazon.androidmotion.lifecycle:
//            AnimatorManager

class this._cls0 extends AnimatorListenerAdapter
{

    final AnimatorManager this$0;

    public void onAnimationEnd(Animator animator)
    {
        clearAnimator();
    }

    ()
    {
        this$0 = AnimatorManager.this;
        super();
    }
}
