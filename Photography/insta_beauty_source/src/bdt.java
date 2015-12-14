// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.animation.Animator;
import com.instamag.activity.library.view.MaglibItemView;

public class bdt
    implements android.animation.Animator.AnimatorListener
{

    final MaglibItemView a;

    public bdt(MaglibItemView maglibitemview)
    {
        a = maglibitemview;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        a.refreshUIByData(MaglibItemView.access$100(a));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
