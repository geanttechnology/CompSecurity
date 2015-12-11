// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.target.ui.util.al;

public abstract class PlpFooterView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        ProgressBar progressBar;
        ImageButton retry;
        final View rootContainer;

        public Views(View view)
        {
            super(view);
            rootContainer = view;
        }
    }

    public static interface a
    {

        public abstract void a();
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final PlpFooterView this$0;

        public void onClick(View view)
        {
            if (PlpFooterView.a(PlpFooterView.this) == null)
            {
                return;
            } else
            {
                PlpFooterView.a(PlpFooterView.this).a();
                return;
            }
        }

        private b()
        {
            this$0 = PlpFooterView.this;
            super();
        }

    }


    private a mListener;
    private Views mViews;

    public PlpFooterView(Context context)
    {
        super(context);
        d();
    }

    public PlpFooterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d();
    }

    public PlpFooterView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d();
    }

    static a a(PlpFooterView plpfooterview)
    {
        return plpfooterview.mListener;
    }

    private void d()
    {
        inflate(getContext(), 0x7f03019d, this);
        mViews = new Views(this);
        mViews.retry.setOnClickListener(new b());
        e();
    }

    private void e()
    {
        mViews.rootContainer.setBackgroundColor(getBackgroundColor());
    }

    public void a()
    {
        if (mViews.rootContainer.getVisibility() == 0)
        {
            return;
        } else
        {
            al.b(mViews.rootContainer);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.retry, new View[] {
                mViews.progressBar
            });
            return;
        } else
        {
            al.a(mViews.progressBar, new View[] {
                mViews.retry
            });
            return;
        }
    }

    public void b()
    {
        al.c(mViews.rootContainer);
    }

    public boolean c()
    {
        while (mViews == null || mViews.retry.getVisibility() != 0) 
        {
            return false;
        }
        return true;
    }

    protected abstract int getBackgroundColor();

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
