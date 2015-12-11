// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class nit> extends AnimatorListenerAdapter
{

    final BusinessSpecialPage this$0;
    final ImageView val$imageView;

    public void onAnimationEnd(Animator animator)
    {
        val$imageView.setTag(null);
    }

    ()
    {
        this$0 = final_businessspecialpage;
        val$imageView = ImageView.this;
        super();
    }
}
