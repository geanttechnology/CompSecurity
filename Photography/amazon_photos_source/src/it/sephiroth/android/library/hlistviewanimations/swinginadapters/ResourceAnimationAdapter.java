// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.hlistviewanimations.swinginadapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorInflater;

// Referenced classes of package it.sephiroth.android.library.hlistviewanimations.swinginadapters:
//            AnimationAdapter

public abstract class ResourceAnimationAdapter extends AnimationAdapter
{

    private final Context mContext;

    public ResourceAnimationAdapter(BaseAdapter baseadapter, Context context)
    {
        super(baseadapter);
        mContext = context;
    }

    protected abstract int getAnimationResourceId();

    public Animator[] getAnimators(ViewGroup viewgroup, View view)
    {
        return (new Animator[] {
            AnimatorInflater.loadAnimator(mContext, getAnimationResourceId())
        });
    }
}
