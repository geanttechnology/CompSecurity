// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ExtendedSearchHistoryFooterView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        View clearRecentHistoryButton;

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

    public ExtendedSearchHistoryFooterView(Context context)
    {
        super(context);
        a();
    }

    public ExtendedSearchHistoryFooterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ExtendedSearchHistoryFooterView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(ExtendedSearchHistoryFooterView extendedsearchhistoryfooterview)
    {
        return extendedsearchhistoryfooterview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f03015d, this);
        mViews = new Views(this);
        mViews.clearRecentHistoryButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ExtendedSearchHistoryFooterView this$0;

            public void onClick(View view)
            {
                if (ExtendedSearchHistoryFooterView.a(ExtendedSearchHistoryFooterView.this) == null)
                {
                    return;
                } else
                {
                    ExtendedSearchHistoryFooterView.a(ExtendedSearchHistoryFooterView.this).a();
                    return;
                }
            }

            
            {
                this$0 = ExtendedSearchHistoryFooterView.this;
                super();
            }
        });
    }

    public void setExtendedSearchHistoryFooterViewClickListener(a a1)
    {
        mListener = a1;
    }
}
