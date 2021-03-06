// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.hlistviewanimations.swinginadapters.prepared;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import it.sephiroth.android.library.hlistviewanimations.swinginadapters.SingleAnimationAdapter;

public class SwingRightInAnimationAdapter extends SingleAnimationAdapter
{

    private static final String TRANSLATION_X = "translationX";
    private final long mAnimationDelayMillis;
    private final long mAnimationDurationMillis;

    public SwingRightInAnimationAdapter(BaseAdapter baseadapter)
    {
        this(baseadapter, 100L, 300L);
    }

    public SwingRightInAnimationAdapter(BaseAdapter baseadapter, long l)
    {
        this(baseadapter, l, 300L);
    }

    public SwingRightInAnimationAdapter(BaseAdapter baseadapter, long l, long l1)
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
        return ObjectAnimator.ofFloat(view, "translationX", new float[] {
            (float)viewgroup.getWidth(), 0.0F
        });
    }
}
