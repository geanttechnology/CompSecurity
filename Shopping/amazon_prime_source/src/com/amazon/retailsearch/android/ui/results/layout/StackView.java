// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.view.View;
import android.view.ViewParent;
import android.widget.ListAdapter;

public interface StackView
{

    public abstract void disableTouchEvents();

    public abstract void enableTouchEvents();

    public abstract ListAdapter getAdapter();

    public abstract View getChildAt(int i);

    public abstract int getChildCount();

    public abstract int getFirstVisiblePosition();

    public abstract int getHeight();

    public abstract int getLastVisiblePosition();

    public abstract void getLocationOnScreen(int ai[]);

    public abstract ViewParent getParent();

    public abstract View getView();

    public abstract void setAdapter(ListAdapter listadapter);

    public abstract void setSelection(int i);

    public abstract void smoothScrollToPositionFromTop(int i, int j, int k);
}
