// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public class ContextualUndoView extends FrameLayout
{

    private View mContentView;
    private long mItemId;
    private View mUndoView;

    public ContextualUndoView(Context context, int i)
    {
        super(context);
        initUndo(i);
    }

    private void initUndo(int i)
    {
        mUndoView = View.inflate(getContext(), i, null);
        addView(mUndoView);
    }

    public void displayContentView()
    {
        mContentView.setVisibility(0);
        mUndoView.setVisibility(8);
    }

    public void displayUndo()
    {
        mContentView.setVisibility(8);
        mUndoView.setVisibility(0);
    }

    public View getContentView()
    {
        return mContentView;
    }

    public long getItemId()
    {
        return mItemId;
    }

    public boolean isContentDisplayed()
    {
        return mContentView.getVisibility() == 0;
    }

    public void setItemId(long l)
    {
        mItemId = l;
    }

    public void updateContentView(View view)
    {
        if (mContentView == null)
        {
            addView(view);
        }
        mContentView = view;
    }
}
