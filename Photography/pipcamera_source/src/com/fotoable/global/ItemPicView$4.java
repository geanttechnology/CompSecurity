// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.global;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.fotoable.global:
//            ItemPicView

class b
    implements android.view.animation.ationListener
{

    final boolean a;
    final View b;
    final ItemPicView c;

    public void onAnimationEnd(Animation animation)
    {
        if (a)
        {
            b.setVisibility(0);
            return;
        } else
        {
            b.setVisibility(4);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    nimationListener(ItemPicView itempicview, boolean flag, View view)
    {
        c = itempicview;
        a = flag;
        b = view;
        super();
    }
}
