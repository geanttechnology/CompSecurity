// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.google.android.apps.youtube.kids.ui.HeaderTileGridLayout;
import java.util.List;

final class afk
    implements android.view.animation.Animation.AnimationListener
{

    private TranslateAnimation a;
    private afj b;

    afk(afj afj1, TranslateAnimation translateanimation)
    {
        b = afj1;
        a = translateanimation;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (a == HeaderTileGridLayout.f(b.b))
        {
            int i = 0;
            while (i < HeaderTileGridLayout.d(b.b).size()) 
            {
                if (i == b.a)
                {
                    HeaderTileGridLayout.a(b.b, i, true);
                } else
                {
                    HeaderTileGridLayout.a(b.b, i, false);
                }
                i++;
            }
            b.b.a(b.a);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
