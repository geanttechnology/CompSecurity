// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SearchCurrentStoreCardView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        Button changeStoreBtn;
        TextView storeName;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final SearchCurrentStoreCardView this$0;

        public void onClick(View view)
        {
            if (SearchCurrentStoreCardView.a(SearchCurrentStoreCardView.this) == null)
            {
                return;
            } else
            {
                SearchCurrentStoreCardView.a(SearchCurrentStoreCardView.this).a();
                return;
            }
        }

        private a()
        {
            this$0 = SearchCurrentStoreCardView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();
    }


    private b mListener;
    private Views mViews;

    public SearchCurrentStoreCardView(Context context)
    {
        super(context);
        a();
    }

    public SearchCurrentStoreCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    static b a(SearchCurrentStoreCardView searchcurrentstorecardview)
    {
        return searchcurrentstorecardview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301e7, this);
        mViews = new Views(this);
        mViews.changeStoreBtn.setOnClickListener(new a());
    }

    public void setClickListener(b b1)
    {
        mListener = b1;
    }

    public void setStoreName(String s)
    {
        mViews.storeName.setText(s);
    }
}
