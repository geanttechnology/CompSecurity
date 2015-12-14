// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.Animation;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;

public class agr
    implements android.view.animation.Animation.AnimationListener
{

    final View a;
    final float b;
    final float c;
    final ProEditFontActivity d;

    public agr(ProEditFontActivity proeditfontactivity, View view, float f, float f1)
    {
        d = proeditfontactivity;
        a = view;
        b = f;
        c = f1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        a.clearAnimation();
        animation = (android.widget.FrameLayout.LayoutParams)a.getLayoutParams();
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
}
