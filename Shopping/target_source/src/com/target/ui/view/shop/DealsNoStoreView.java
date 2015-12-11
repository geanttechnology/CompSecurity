// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class DealsNoStoreView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        View setStoreButton;

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

    public DealsNoStoreView(Context context)
    {
        super(context);
        a();
    }

    public DealsNoStoreView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public DealsNoStoreView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(DealsNoStoreView dealsnostoreview)
    {
        return dealsnostoreview.mListener;
    }

    private void a()
    {
        setGravity(17);
        setOrientation(1);
        inflate(getContext(), 0x7f030154, this);
        mViews = new Views(this);
        mViews.setStoreButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DealsNoStoreView this$0;

            public void onClick(View view)
            {
                if (DealsNoStoreView.a(DealsNoStoreView.this) == null)
                {
                    return;
                } else
                {
                    DealsNoStoreView.a(DealsNoStoreView.this).a();
                    return;
                }
            }

            
            {
                this$0 = DealsNoStoreView.this;
                super();
            }
        });
    }

    public void setOnStoreClickListener(a a1)
    {
        mListener = a1;
    }
}
