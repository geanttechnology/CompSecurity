// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package com.target.ui.view.common:
//            CheckableFormItemCompat

class val.flipTo extends AnimatorListenerAdapter
{

    final CheckableFormItemCompat this$0;
    final Drawable val$flipTo;

    public void onAnimationStart(Animator animator)
    {
        if (CheckableFormItemCompat.a(CheckableFormItemCompat.this) != null)
        {
            CheckableFormItemCompat.a(CheckableFormItemCompat.this).checkMark.setImageDrawable(val$flipTo);
        }
    }

    _cls9()
    {
        this$0 = final_checkableformitemcompat;
        val$flipTo = Drawable.this;
        super();
    }
}
