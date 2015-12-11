// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Fragment;

public abstract class za extends Fragment
{

    public android.animation.Animator.AnimatorListener b;

    public za()
    {
    }

    public Animator onCreateAnimator(int i, boolean flag, int j)
    {
        Animator animator = AnimatorInflater.loadAnimator(getActivity(), j);
        if (animator != null && !flag)
        {
            animator.addListener(b);
        }
        return animator;
    }
}
