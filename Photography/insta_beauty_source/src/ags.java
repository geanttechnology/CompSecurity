// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.Animation;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;

public class ags
    implements android.view.animation.Animation.AnimationListener
{

    final View a;
    final boolean b;
    final ProEditFontActivity c;

    public ags(ProEditFontActivity proeditfontactivity, View view, boolean flag)
    {
        c = proeditfontactivity;
        a = view;
        b = flag;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        a.clearAnimation();
        if (b)
        {
            a.setVisibility(0);
            return;
        } else
        {
            a.setVisibility(4);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
