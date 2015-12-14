// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.cyberlink.beautycircle.model.MeTabItem;
import com.cyberlink.beautycircle.view.widgetpool.common.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements android.view.OnClickListener
{

    final p a;

    public void onClick(View view)
    {
        view = ((j)view).getItem();
        p.a(a, ((MeTabItem) (view)).listMode);
        p.b(a, ((MeTabItem) (view)).listMode);
        view = ObjectAnimator.ofFloat(a.i, "translationY", new float[] {
            0.0F
        });
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(p.b(a), "translationY", new float[] {
            0.0F
        });
        p.a(a, (new AnimatorSet()).setDuration(300L));
        p.c(a).playTogether(new Animator[] {
            view, objectanimator
        });
        p.c(a).start();
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
