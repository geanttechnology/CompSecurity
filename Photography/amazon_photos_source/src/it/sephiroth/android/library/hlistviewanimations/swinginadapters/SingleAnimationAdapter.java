// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.hlistviewanimations.swinginadapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package it.sephiroth.android.library.hlistviewanimations.swinginadapters:
//            AnimationAdapter

public abstract class SingleAnimationAdapter extends AnimationAdapter
{

    public SingleAnimationAdapter(BaseAdapter baseadapter)
    {
        super(baseadapter);
    }

    protected abstract Animator getAnimator(ViewGroup viewgroup, View view);

    public Animator[] getAnimators(ViewGroup viewgroup, View view)
    {
        return (new Animator[] {
            getAnimator(viewgroup, view)
        });
    }
}
