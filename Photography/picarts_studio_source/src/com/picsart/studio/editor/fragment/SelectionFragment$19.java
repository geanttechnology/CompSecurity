// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.view.animation.stener
{

    private SelectionFragment a;

    public final void onAnimationEnd(Animation animation)
    {
        animation = a.getView();
        if (animation != null)
        {
            Object obj = animation.findViewById(0x7f1005fc);
            ((View) (obj)).clearAnimation();
            ((View) (obj)).setVisibility(8);
            obj = SelectionFragment.c(a, animation);
            animation = animation.findViewById(0x7f10059a);
            ((View) (obj)).setVisibility(0);
            animation.setVisibility(0);
            ((View) (obj)).startAnimation(SelectionFragment.O(a));
            animation.startAnimation(SelectionFragment.N(a));
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    (SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
