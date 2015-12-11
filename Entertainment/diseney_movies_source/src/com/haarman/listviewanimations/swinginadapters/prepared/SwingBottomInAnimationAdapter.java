// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.swinginadapters.prepared;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.haarman.listviewanimations.swinginadapters.SingleAnimationAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class SwingBottomInAnimationAdapter extends SingleAnimationAdapter
{

    private final long mAnimationDelayMillis;
    private final long mAnimationDurationMillis;

    public SwingBottomInAnimationAdapter(BaseAdapter baseadapter)
    {
        this(baseadapter, 100L, 300L);
    }

    public SwingBottomInAnimationAdapter(BaseAdapter baseadapter, long l)
    {
        this(baseadapter, l, 300L);
    }

    public SwingBottomInAnimationAdapter(BaseAdapter baseadapter, long l, long l1)
    {
        super(baseadapter);
        mAnimationDelayMillis = l;
        mAnimationDurationMillis = l1;
    }

    protected long getAnimationDelayMillis()
    {
        return mAnimationDelayMillis;
    }

    protected long getAnimationDurationMillis()
    {
        return mAnimationDurationMillis;
    }

    protected Animator getAnimator(ViewGroup viewgroup, View view)
    {
        return ObjectAnimator.ofFloat(view, "translationY", new float[] {
            500F, 0.0F
        });
    }
}
