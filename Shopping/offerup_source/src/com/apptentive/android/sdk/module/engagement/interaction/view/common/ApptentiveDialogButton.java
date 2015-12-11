// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ApptentiveDialogButton extends FrameLayout
{

    android.view.View.OnClickListener onClickListener;

    public ApptentiveDialogButton(Context context)
    {
        super(context);
        init(context);
    }

    public ApptentiveDialogButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ApptentiveDialogButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
        context = context.obtainStyledAttributes(attributeset, com.apptentive.android.sdk.R.styleable.ApptentiveDialogButton, i, 0);
        setText(context.getString(com.apptentive.android.sdk.R.styleable.ApptentiveDialogButton_text));
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void init(Context context)
    {
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        inflate(context, com.apptentive.android.sdk.R.layout.apptentive_dialog_button, this);
        setClickable(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return onClickListener != null;
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        findViewById(com.apptentive.android.sdk.R.id.background).setEnabled(flag);
        findViewById(com.apptentive.android.sdk.R.id.label).setEnabled(flag);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(onclicklistener);
        onClickListener = onclicklistener;
    }

    public void setText(String s)
    {
        if (s != null)
        {
            ((TextView)findViewById(com.apptentive.android.sdk.R.id.label)).setText(s);
        }
    }
}
