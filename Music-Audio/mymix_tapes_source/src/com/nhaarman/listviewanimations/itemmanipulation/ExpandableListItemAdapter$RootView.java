// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation:
//            ExpandableListItemAdapter

private static class init extends LinearLayout
{

    private ViewGroup mContentViewGroup;
    private ViewGroup mTitleViewGroup;

    private void init()
    {
        setOrientation(1);
        mTitleViewGroup = new FrameLayout(getContext());
        mTitleViewGroup.setId(10000);
        addView(mTitleViewGroup);
        mContentViewGroup = new FrameLayout(getContext());
        mContentViewGroup.setId(10001);
        addView(mContentViewGroup);
    }

    public Y(Context context)
    {
        super(context);
        init();
    }
}
