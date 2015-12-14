// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class c
    implements android.view.animation.tener
{

    final View a;
    final float b;
    final float c;
    final ProEditFontActivity d;

    public void onAnimationEnd(Animation animation)
    {
        a.clearAnimation();
        animation = (android.widget.ms)a.getLayoutParams();
        animation.bottomMargin = (int)b;
        if (c >= 0.0F)
        {
            animation.height = (int)c;
        }
        a.requestLayout();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (ProEditFontActivity proeditfontactivity, View view, float f, float f1)
    {
        d = proeditfontactivity;
        a = view;
        b = f;
        c = f1;
        super();
    }
}
