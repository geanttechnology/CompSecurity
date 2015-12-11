// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.EditText;

// Referenced classes of package com.target.ui.view.common:
//            NameView

class pter extends AnimatorListenerAdapter
{

    final NameView this$0;

    public void onAnimationEnd(Animator animator)
    {
        NameView.c(NameView.this).lastName.setEnabled(false);
    }

    ews()
    {
        this$0 = NameView.this;
        super();
    }
}
