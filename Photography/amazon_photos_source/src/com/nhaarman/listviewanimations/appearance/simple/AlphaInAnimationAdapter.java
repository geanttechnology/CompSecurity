// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.appearance.simple;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.appearance.AnimationAdapter;
import com.nineoldandroids.animation.Animator;

public class AlphaInAnimationAdapter extends AnimationAdapter
{

    public AlphaInAnimationAdapter(BaseAdapter baseadapter)
    {
        super(baseadapter);
    }

    public Animator[] getAnimators(ViewGroup viewgroup, View view)
    {
        return new Animator[0];
    }
}
