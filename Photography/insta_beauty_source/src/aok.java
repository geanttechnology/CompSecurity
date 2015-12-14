// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.fotoable.fullscreenad.FullScreenAdView;

public class aok
    implements android.animation.Animator.AnimatorListener
{

    final View a;
    final ViewGroup b;
    final FullScreenAdView c;

    public aok(FullScreenAdView fullscreenadview, View view, ViewGroup viewgroup)
    {
        c = fullscreenadview;
        a = view;
        b = viewgroup;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        try
        {
            a.setAlpha(1.0F);
        }
        // Misplaced declaration of an exception variable
        catch (Animator animator)
        {
            animator.printStackTrace();
        }
        b.removeView(a);
        if (FullScreenAdView.access$600(c) != null)
        {
            FullScreenAdView.access$600(c).a();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
