// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.hlistviewanimations.swinginadapters.prepared;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;
import it.sephiroth.android.library.hlistviewanimations.swinginadapters.AnimationAdapter;

public class AlphaInAnimationAdapter extends AnimationAdapter
{

    public AlphaInAnimationAdapter(BaseAdapter baseadapter)
    {
        super(baseadapter);
    }

    protected long getAnimationDelayMillis()
    {
        return 100L;
    }

    protected long getAnimationDurationMillis()
    {
        return 300L;
    }

    public Animator[] getAnimators(ViewGroup viewgroup, View view)
    {
        return new Animator[0];
    }
}
