// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.ViewFlipper;

public class AviaryNavBarViewFlipper extends ViewFlipper
    implements android.widget.ViewSwitcher.ViewFactory
{
    public static interface OnToolbarClickListener
    {

        public abstract void onApplyClick();

        public abstract void onDoneClick();
    }

    private static class ViewState
    {

        Status current;
        Status previous;

        void setCurrent(Status status)
        {
            previous = current;
            current = status;
        }

        private ViewState()
        {
        }

    }

    static final class ViewState.Status extends Enum
    {

        private static final ViewState.Status $VALUES[];
        public static final ViewState.Status Close;
        public static final ViewState.Status Open;

        public static ViewState.Status valueOf(String s)
        {
            return (ViewState.Status)Enum.valueOf(com/aviary/android/feather/sdk/widget/AviaryNavBarViewFlipper$ViewState$Status, s);
        }

        public static ViewState.Status[] values()
        {
            return (ViewState.Status[])$VALUES.clone();
        }

        static 
        {
            Open = new ViewState.Status("Open", 0);
            Close = new ViewState.Status("Close", 1);
            $VALUES = (new ViewState.Status[] {
                Open, Close
            });
        }

        private ViewState.Status(String s, int i)
        {
            super(s, i);
        }
    }


    Button mButton1;
    Button mButton2;
    private boolean mButtonSizeChanged;
    boolean mClickable;
    OnToolbarClickListener mListener;
    ProgressBar mProgress1;
    ProgressBar mProgress2;
    ViewState mStatus;
    TextSwitcher mTextSwitcher;

    public AviaryNavBarViewFlipper(Context context)
    {
        super(context);
    }

    public AviaryNavBarViewFlipper(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void close()
    {
        if (!closed())
        {
            mStatus.setCurrent(ViewState.Status.Close);
            setDisplayedChild(0);
        }
    }

    public boolean closed()
    {
        return mStatus.current == ViewState.Status.Close;
    }

    public boolean getApplyProgressVisible()
    {
        return mProgress2.getVisibility() == 0;
    }

    public boolean getDoneProgressVisible()
    {
        return mProgress1.getVisibility() == 0;
    }

    public boolean isClickable()
    {
        return mClickable;
    }

    public View makeView()
    {
        return LayoutInflater.from(getContext()).inflate(com.aviary.android.feather.sdk.R.layout.aviary_navbar_text, null);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mStatus = new ViewState();
        mStatus.current = ViewState.Status.Close;
        mStatus.previous = ViewState.Status.Close;
        mTextSwitcher = (TextSwitcher)findViewById(com.aviary.android.feather.sdk.R.id.navbar_text2);
        mButton1 = (Button)findViewById(com.aviary.android.feather.sdk.R.id.navbar_button1);
        mProgress1 = (ProgressBar)findViewById(com.aviary.android.feather.sdk.R.id.navbar_progress1);
        mButton2 = (Button)findViewById(com.aviary.android.feather.sdk.R.id.navbar_button2);
        mProgress2 = (ProgressBar)findViewById(com.aviary.android.feather.sdk.R.id.navbar_progress2);
        mTextSwitcher.setFactory(this);
        mButton2.setOnClickListener(new android.view.View.OnClickListener() {

            final AviaryNavBarViewFlipper this$0;

            public void onClick(View view)
            {
                if (mListener != null && isClickable() && opened())
                {
                    mListener.onApplyClick();
                }
            }

            
            {
                this$0 = AviaryNavBarViewFlipper.this;
                super();
            }
        });
        mButton1.setOnClickListener(new android.view.View.OnClickListener() {

            final AviaryNavBarViewFlipper this$0;

            public void onClick(View view)
            {
                if (mListener != null && isClickable() && !opened())
                {
                    mListener.onDoneClick();
                }
            }

            
            {
                this$0 = AviaryNavBarViewFlipper.this;
                super();
            }
        });
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (!mButtonSizeChanged)
        {
            i = mButton1.getMeasuredWidth();
            j = mButton2.getMeasuredWidth();
            k = Math.max(i, j);
            if (i != k)
            {
                mButton1.setWidth(k);
            }
            if (j != k)
            {
                mButton2.setWidth(k);
            }
            mButtonSizeChanged = true;
        }
    }

    public void open()
    {
        if (!opened())
        {
            mStatus.setCurrent(ViewState.Status.Open);
            setDisplayedChild(1);
        }
    }

    public boolean opened()
    {
        return mStatus.current == ViewState.Status.Open;
    }

    public void setApplyEnabled(boolean flag)
    {
        mButton2.setEnabled(flag);
    }

    public void setApplyProgressVisible(boolean flag)
    {
        ProgressBar progressbar = mProgress2;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        progressbar.setVisibility(i);
    }

    public void setApplyVisible(boolean flag)
    {
        Button button = mButton2;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        button.setVisibility(i);
    }

    public void setClickable(boolean flag)
    {
        mClickable = flag;
    }

    public void setDoneEnabled(boolean flag)
    {
        mButton1.setEnabled(flag);
    }

    public void setDoneProgressVisible(boolean flag)
    {
        ProgressBar progressbar = mProgress1;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        progressbar.setVisibility(i);
    }

    public void setOnToolbarClickListener(OnToolbarClickListener ontoolbarclicklistener)
    {
        mListener = ontoolbarclicklistener;
    }

    public void setTitle(int i)
    {
        setTitle(i, true);
    }

    public void setTitle(int i, boolean flag)
    {
        setTitle(((CharSequence) (getContext().getResources().getString(i))), flag);
    }

    public void setTitle(CharSequence charsequence)
    {
        setTitle(charsequence, true);
    }

    public void setTitle(CharSequence charsequence, boolean flag)
    {
        if (!flag)
        {
            android.view.animation.Animation animation = mTextSwitcher.getInAnimation();
            android.view.animation.Animation animation1 = mTextSwitcher.getOutAnimation();
            mTextSwitcher.setInAnimation(null);
            mTextSwitcher.setOutAnimation(null);
            mTextSwitcher.setText(charsequence);
            mTextSwitcher.setInAnimation(animation);
            mTextSwitcher.setOutAnimation(animation1);
            return;
        } else
        {
            mTextSwitcher.setText(charsequence);
            return;
        }
    }
}
