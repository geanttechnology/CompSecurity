// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.notifier;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.recorder.ViewGoneAnimationListener;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;

public class NotifyableRelativeLayout extends RelativeLayout
{
    public static interface NotifierClickListener
    {

        public abstract void onNotifyClick();
    }


    private int mCount;
    private NotifierClickListener mListener;
    private int mNotificationMargin;
    private int mVineGreen;

    public NotifyableRelativeLayout(Context context)
    {
        super(context);
        init(context);
    }

    public NotifyableRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public NotifyableRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void hideNotification()
    {
        View view = findViewById(0x7f0a00f9);
        view.animate().alpha(0.0F).setDuration(1000L).setListener(new ViewGoneAnimationListener(view));
        view.setVisibility(8);
    }

    private void showNotification()
    {
        findViewById(0x7f0a00f9).setVisibility(0);
    }

    public void indicate(int i)
    {
        if (i <= 0)
        {
            hideNotification();
        } else
        {
            ((TextView)findViewById(0x7f0a00f9)).setText(getResources().getQuantityString(0x7f0d0000, i, new Object[] {
                Integer.valueOf(i)
            }));
            showNotification();
        }
        mCount = i;
    }

    public void init(Context context)
    {
        Resources resources = context.getResources();
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030042, null);
        TextView textview = (TextView)context.findViewById(0x7f0a00f9);
        Drawable drawable = resources.getDrawable(0x7f020289);
        mVineGreen = resources.getColor(0x7f090096);
        drawable.setColorFilter(mVineGreen, android.graphics.PorterDuff.Mode.SRC_ATOP);
        ViewUtil.setBackground(textview, drawable);
        addView(context);
        mNotificationMargin = resources.getDimensionPixelOffset(0x7f0b0084) + resources.getDimensionPixelOffset(0x7f0b005f);
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final NotifyableRelativeLayout this$0;

            public void onClick(View view)
            {
                if (mListener != null)
                {
                    mListener.onNotifyClick();
                }
                hideNotification();
            }

            
            {
                this$0 = NotifyableRelativeLayout.this;
                super();
            }
        });
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        for (int i1 = 0; i1 < getChildCount(); i1++)
        {
            View view = getChildAt(i1);
            if (view.getId() == 0x7f0a00f8)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
                layoutparams.addRule(10);
                layoutparams.topMargin = mNotificationMargin;
                bringChildToFront(view);
            }
        }

        super.onLayout(flag, i, j, k, l);
    }

    public void personalizeColor(int i)
    {
        TextView textview = (TextView)findViewById(0x7f0a00f9);
        Drawable drawable = getResources().getDrawable(0x7f020289);
        int j = i;
        if (i != mVineGreen)
        {
            j = Util.getColorWithBlackPercentage(i, 0.24F);
        }
        drawable.setColorFilter(j, android.graphics.PorterDuff.Mode.SRC_ATOP);
        ViewUtil.setBackground(textview, drawable);
    }

    public void setNotifierListener(NotifierClickListener notifierclicklistener)
    {
        mListener = notifierclicklistener;
    }


}
