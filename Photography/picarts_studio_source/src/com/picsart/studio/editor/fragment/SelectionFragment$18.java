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
            Object obj = SelectionFragment.c(a, animation);
            View view = animation.findViewById(0x7f10059a);
            ((View) (obj)).clearAnimation();
            view.clearAnimation();
            ((View) (obj)).setVisibility(8);
            view.setVisibility(8);
            obj = animation.findViewById(0x7f1005fc);
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).startAnimation(SelectionFragment.N(a));
            animation.findViewById(0x7f1005fb).setVisibility(0);
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
