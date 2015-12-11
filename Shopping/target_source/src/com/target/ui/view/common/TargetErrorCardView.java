// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.target.ui.view.common:
//            b, TargetErrorView, c

public class TargetErrorCardView extends FrameLayout
    implements b
{
    private class a
    {

        final TargetErrorView errorView;
        final TargetErrorCardView this$0;

        public a(View view)
        {
            this$0 = TargetErrorCardView.this;
            super();
            errorView = (TargetErrorView)view.findViewById(0x7f1005d1);
        }
    }


    private c mListener;
    private a mViews;

    public TargetErrorCardView(Context context)
    {
        super(context);
        a();
    }

    public TargetErrorCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public TargetErrorCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static c a(TargetErrorCardView targeterrorcardview)
    {
        return targeterrorcardview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f030200, this);
        mViews = new a(this);
        mViews.errorView.setClickListener(new c() {

            final TargetErrorCardView this$0;

            public void A_()
            {
                if (TargetErrorCardView.a(TargetErrorCardView.this) == null)
                {
                    return;
                } else
                {
                    TargetErrorCardView.a(TargetErrorCardView.this).A_();
                    return;
                }
            }

            
            {
                this$0 = TargetErrorCardView.this;
                super();
            }
        });
    }

    public void a(b.a a1, boolean flag)
    {
        mViews.errorView.a(a1, flag);
    }

    public void a(String s, String s1, boolean flag)
    {
        mViews.errorView.a(s, s1, flag);
    }

    public void setClickListener(c c)
    {
        mListener = c;
    }
}
