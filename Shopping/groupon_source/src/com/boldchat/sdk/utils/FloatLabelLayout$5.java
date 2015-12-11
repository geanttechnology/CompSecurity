// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

// Referenced classes of package com.boldchat.sdk.utils:
//            FloatLabelLayout

class <init> extends AnimatorListenerAdapter
{

    final FloatLabelLayout this$0;

    public void onAnimationEnd(Animator animator)
    {
        FloatLabelLayout.access$000(FloatLabelLayout.this).setVisibility(8);
    }

    ()
    {
        this$0 = FloatLabelLayout.this;
        super();
    }
}
