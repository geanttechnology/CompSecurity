// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.target.mothership.util.o;
import com.target.ui.util.al;

public class TargetBottomButton extends LinearLayout
    implements android.view.View.OnClickListener
{
    private class a
    {

        private final String mCentreText;
        private boolean mHighlightCentre;
        private boolean mHighlightLeft;
        private boolean mHighlightRight;
        private final String mLeftText;
        private final String mRightText;
        final TargetBottomButton this$0;

        public String a()
        {
            return mLeftText;
        }

        public void a(boolean flag)
        {
            mHighlightLeft = flag;
        }

        public String b()
        {
            return mCentreText;
        }

        public void b(boolean flag)
        {
            mHighlightCentre = flag;
        }

        public String c()
        {
            return mRightText;
        }

        public void c(boolean flag)
        {
            mHighlightRight = flag;
        }

        public boolean d()
        {
            return mHighlightLeft;
        }

        public boolean e()
        {
            return mHighlightCentre;
        }

        public boolean f()
        {
            return mHighlightRight;
        }

        a(String s, String s1, String s2)
        {
            this$0 = TargetBottomButton.this;
            super();
            mLeftText = s;
            mCentreText = s1;
            mRightText = s2;
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

    private class c
    {

        final Button mCentreButton;
        final View mCentreDiv;
        final Button mLeftButton;
        final View mLeftDiv;
        final Button mRightButton;
        final TargetBottomButton this$0;

        public c(View view)
        {
            this$0 = TargetBottomButton.this;
            super();
            mLeftButton = (Button)view.findViewById(0x7f1002fd);
            mCentreButton = (Button)view.findViewById(0x7f1002ff);
            mRightButton = (Button)view.findViewById(0x7f100301);
            mLeftDiv = view.findViewById(0x7f1002fe);
            mCentreDiv = view.findViewById(0x7f100300);
        }
    }


    private b mListener;
    private c mViews;

    public TargetBottomButton(Context context)
    {
        super(context);
        b(context, null);
    }

    public TargetBottomButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b(context, attributeset);
    }

    public TargetBottomButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b(context, attributeset);
    }

    private void a(a a1)
    {
        if (o.g(a1.a()))
        {
            mViews.mLeftButton.setText(a1.a());
            al.b(mViews.mLeftButton);
            if (o.g(a1.b()) || o.g(a1.c()))
            {
                al.b(mViews.mLeftDiv);
            }
        } else
        {
            al.c(mViews.mLeftButton);
        }
        if (o.g(a1.b()))
        {
            mViews.mCentreButton.setText(a1.b());
            al.b(mViews.mCentreButton);
            if (o.g(a1.c()))
            {
                al.b(mViews.mCentreDiv);
            }
        } else
        {
            al.c(mViews.mCentreButton);
        }
        if (o.g(a1.c()))
        {
            mViews.mRightButton.setText(a1.c());
            al.b(mViews.mRightButton);
        } else
        {
            al.c(mViews.mRightButton);
        }
        if (a1.d())
        {
            mViews.mLeftButton.setTextColor(getResources().getColor(0x7f0f00eb));
        } else
        {
            mViews.mLeftButton.setTextColor(getResources().getColor(0x7f0f00f6));
        }
        if (a1.e())
        {
            mViews.mCentreButton.setTextColor(getResources().getColor(0x7f0f00eb));
        } else
        {
            mViews.mCentreButton.setTextColor(getResources().getColor(0x7f0f00f6));
        }
        if (a1.f())
        {
            mViews.mRightButton.setTextColor(getResources().getColor(0x7f0f00eb));
        } else
        {
            mViews.mRightButton.setTextColor(getResources().getColor(0x7f0f00f6));
        }
        al.c(this);
    }

    private void b(Context context, AttributeSet attributeset)
    {
        if (context == null || attributeset == null)
        {
            return;
        } else
        {
            attributeset = a(context, attributeset);
            inflate(context, 0x7f030102, this);
            mViews = new c(this);
            al.a(this, new View[] {
                mViews.mLeftButton, mViews.mCentreButton, mViews.mRightButton
            });
            a(attributeset);
            return;
        }
    }

    a a(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.target.ui.a.a.TargetBottomButton);
        boolean flag = context.getBoolean(3, false);
        boolean flag1 = context.getBoolean(4, false);
        boolean flag2 = context.getBoolean(5, false);
        int i = context.getResourceId(0, 0);
        int j = context.getResourceId(1, 0);
        int k = context.getResourceId(2, 0);
        context.recycle();
        if (i == 0 && j == 0 && k == 0)
        {
            throw new IllegalStateException("You must specify at least one button text(left, centre, right)");
        }
        context = "";
        attributeset = "";
        String s = "";
        if (i > 1)
        {
            context = getResources().getString(i);
        }
        if (j > 1)
        {
            attributeset = getResources().getString(j);
        }
        if (k > 1)
        {
            s = getResources().getString(k);
        }
        context = new a(context, attributeset, s);
        context.a(flag);
        context.b(flag1);
        context.c(flag2);
        return context;
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        }
        switch (view.getId())
        {
        case 2131755774: 
        case 2131755776: 
        default:
            return;

        case 2131755773: 
            mListener.a();
            return;

        case 2131755775: 
            mListener.b();
            return;

        case 2131755777: 
            mListener.c();
            break;
        }
    }

    public void setCentreBtnEnable(boolean flag)
    {
        if (mViews.mCentreButton == null)
        {
            return;
        } else
        {
            mViews.mCentreButton.setEnabled(flag);
            return;
        }
    }

    public void setClickListener(b b1)
    {
        mListener = b1;
    }

    public void setLeftBtnEnable(boolean flag)
    {
        if (mViews.mLeftButton == null)
        {
            return;
        } else
        {
            mViews.mLeftButton.setEnabled(flag);
            return;
        }
    }

    public void setRightBtnEnable(boolean flag)
    {
        if (mViews.mRightButton == null)
        {
            return;
        } else
        {
            mViews.mRightButton.setEnabled(flag);
            return;
        }
    }
}
