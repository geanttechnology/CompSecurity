// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ContextualUndoView extends FrameLayout
{

    private View mContentView;
    private TextView mCountDownTV;
    private long mItemId;
    private View mUndoView;

    public ContextualUndoView(Context context, int i, int j)
    {
        super(context);
        initUndo(i, j);
    }

    private void initUndo(int i, int j)
    {
        mUndoView = View.inflate(getContext(), i, null);
        addView(mUndoView);
        if (j != -1)
        {
            mCountDownTV = (TextView)mUndoView.findViewById(j);
        }
    }

    public void displayContentView()
    {
        mContentView.setVisibility(0);
        mUndoView.setVisibility(4);
    }

    public void displayUndo()
    {
        updateCountDownTimer("");
        mContentView.setVisibility(4);
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

    public void updateCountDownTimer(String s)
    {
        if (mCountDownTV != null)
        {
            mCountDownTV.setText(s);
        }
    }
}
