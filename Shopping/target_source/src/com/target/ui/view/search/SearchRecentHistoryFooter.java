// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class SearchRecentHistoryFooter extends LinearLayout
    implements android.view.View.OnClickListener
{
    static class Views extends com.target.ui.view.a
    {

        View container;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();
    }


    private a mListener;
    private Views mViews;

    public SearchRecentHistoryFooter(Context context)
    {
        super(context);
        a();
    }

    public SearchRecentHistoryFooter(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301ef, this);
        mViews = new Views(this);
        mViews.container.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.a();
            return;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
