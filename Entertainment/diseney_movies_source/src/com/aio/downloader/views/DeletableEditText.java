// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

public class DeletableEditText extends EditText
{
    private class FocusChangeListenerImpl
        implements android.view.View.OnFocusChangeListener
    {

        final DeletableEditText this$0;

        public void onFocusChange(View view, boolean flag)
        {
            boolean flag1 = true;
            isHasFocus = flag;
            if (isHasFocus)
            {
                if (getText().toString().length() >= 1)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                setClearDrawableVisible(flag);
                return;
            } else
            {
                setClearDrawableVisible(false);
                return;
            }
        }

        private FocusChangeListenerImpl()
        {
            this$0 = DeletableEditText.this;
            super();
        }

        FocusChangeListenerImpl(FocusChangeListenerImpl focuschangelistenerimpl)
        {
            this();
        }
    }

    private class TextWatcherImpl
        implements TextWatcher
    {

        final DeletableEditText this$0;

        public void afterTextChanged(Editable editable)
        {
            boolean flag = true;
            if (getText().toString().length() < 1)
            {
                flag = false;
            }
            setClearDrawableVisible(flag);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private TextWatcherImpl()
        {
            this$0 = DeletableEditText.this;
            super();
        }

        TextWatcherImpl(TextWatcherImpl textwatcherimpl)
        {
            this();
        }
    }


    private boolean isHasFocus;
    private Drawable mRightDrawable;

    public DeletableEditText(Context context)
    {
        super(context);
        init();
    }

    public DeletableEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public DeletableEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        mRightDrawable = getCompoundDrawables()[2];
        setOnFocusChangeListener(new FocusChangeListenerImpl(null));
        addTextChangedListener(new TextWatcherImpl(null));
        setClearDrawableVisible(false);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 1 1: default 24
    //                   1 30;
           goto _L1 _L2
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        boolean flag;
        if (motionevent.getX() > (float)(getWidth() - getTotalPaddingRight()) && motionevent.getX() < (float)(getWidth() - getPaddingRight()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            setText("");
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void setClearDrawableVisible(boolean flag)
    {
        Drawable drawable;
        if (flag)
        {
            drawable = mRightDrawable;
        } else
        {
            drawable = null;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
    }

    public void setShakeAnimation()
    {
        startAnimation(shakeAnimation(5));
    }

    public Animation shakeAnimation(int i)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 10F, 0.0F, 10F);
        translateanimation.setInterpolator(new CycleInterpolator(i));
        translateanimation.setDuration(1000L);
        return translateanimation;
    }


}
