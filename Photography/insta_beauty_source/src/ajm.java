// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.FontStyleColorShadowView;

public class ajm
    implements android.view.animation.Animation.AnimationListener
{

    final int a;
    final FontKeyBoardBottomView b;

    public ajm(FontKeyBoardBottomView fontkeyboardbottomview, int i)
    {
        b = fontkeyboardbottomview;
        a = i;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        b.hiddenAll();
        if (a != 3)
        {
            if (a == 2)
            {
                FontKeyBoardBottomView.access$100(b).setVisibility(0);
            } else
            {
                FontKeyBoardBottomView.access$200(b).setVisibility(0);
            }
        }
        animation = new TranslateAnimation(0.0F, 0.0F, b.getHeight(), 0.0F);
        animation.setDuration(400L);
        animation.setInterpolator(new DecelerateInterpolator());
        FontKeyBoardBottomView.access$300(b).startAnimation(animation);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
