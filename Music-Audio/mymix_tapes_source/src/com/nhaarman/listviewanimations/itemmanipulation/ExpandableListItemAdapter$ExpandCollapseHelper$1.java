// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation:
//            ExpandableListItemAdapter

static final class val.view extends AnimatorListenerAdapter
{

    final View val$view;

    public void onAnimationEnd(Animator animator)
    {
        val$view.setVisibility(8);
    }

    (View view1)
    {
        val$view = view1;
        super();
    }
}
