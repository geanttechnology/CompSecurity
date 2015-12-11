// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.view.common:
//            h

class enerAdapter extends AnimatorListenerAdapter
{

    final h this$0;

    public void onAnimationStart(Animator animator)
    {
        h.a(h.this, true);
    }

    enerAdapter()
    {
        this$0 = h.this;
        super();
    }
}
