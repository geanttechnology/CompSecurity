// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class TimelineBehavior extends android.support.design.widget.CoordinatorLayout.Behavior
{

    private final Context context;

    public TimelineBehavior()
    {
        context = null;
    }

    public TimelineBehavior(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public volatile boolean layoutDependsOn(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        return layoutDependsOn(coordinatorlayout, (ListView)view, view1);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorlayout, ListView listview, View view)
    {
        return view instanceof AppBarLayout;
    }

    public volatile boolean onDependentViewChanged(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        return onDependentViewChanged(coordinatorlayout, (ListView)view, view1);
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorlayout, ListView listview, View view)
    {
        int i = view.getHeight() + view.getTop();
        listview.setPadding(0, 0, 0, i);
        listview.setTranslationY(i);
        return true;
    }
}
