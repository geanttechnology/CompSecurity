// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;

public class GrouponCheckMark extends FrameLayout
    implements android.view.View.OnClickListener
{
    public static interface OnCheckedChangeListener
    {

        public abstract void onCheckedChanged(View view, boolean flag);
    }


    private static final int ANIMATION_TIME = 200;
    private View checkMarkIcon;
    private View checkedView;
    private OnCheckedChangeListener onCheckedChangeListener;
    private View uncheckedView;

    public GrouponCheckMark(Context context)
    {
        this(context, null);
    }

    public GrouponCheckMark(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public GrouponCheckMark(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(getContext(), 0x7f030127, this);
        checkedView = findViewById(0x7f100362);
        uncheckedView = findViewById(0x7f100361);
        checkMarkIcon = findViewById(0x7f100363);
        checkedView.setScaleX(0.0F);
        checkedView.setScaleY(0.0F);
        checkedView.setVisibility(8);
        uncheckedView.setVisibility(8);
        checkMarkIcon.setVisibility(8);
        setSelected(false);
    }

    public boolean isChecked()
    {
        return checkedView.getVisibility() == 0;
    }

    public void onClick(View view)
    {
        boolean flag;
        if (!isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChecked(flag, true);
    }

    public void setChecked(boolean flag)
    {
        setChecked(flag, false);
    }

    public void setChecked(boolean flag, boolean flag1)
    {
        setChecked(flag, flag1, null);
    }

    public void setChecked(final boolean checked, boolean flag, final AnimatorListenerAdapter animationEndListenerAdapter)
    {
        if (onCheckedChangeListener != null)
        {
            onCheckedChangeListener.onCheckedChanged(this, checked);
        }
        if (checked)
        {
            checkedView.setVisibility(0);
            checkMarkIcon.setVisibility(0);
        }
        float f;
        if (checked)
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        if (flag)
        {
            ViewPropertyAnimator viewpropertyanimator = checkedView.animate().setDuration(200L).scaleX(f).scaleY(f);
            Object obj;
            if (checked)
            {
                obj = new OvershootInterpolator();
            } else
            {
                obj = new AnticipateInterpolator();
            }
            viewpropertyanimator.setInterpolator(((android.animation.TimeInterpolator) (obj))).setListener(new AnimatorListenerAdapter() {

                final GrouponCheckMark this$0;
                final AnimatorListenerAdapter val$animationEndListenerAdapter;
                final boolean val$checked;

                public void onAnimationEnd(Animator animator)
                {
                    if (!checked)
                    {
                        checkedView.setVisibility(8);
                        checkMarkIcon.setVisibility(8);
                    }
                    if (animationEndListenerAdapter != null)
                    {
                        animationEndListenerAdapter.onAnimationEnd(animator);
                    }
                }

            
            {
                this$0 = GrouponCheckMark.this;
                checked = flag;
                animationEndListenerAdapter = animatorlisteneradapter;
                super();
            }
            });
            return;
        } else
        {
            checkedView.setScaleX(f);
            checkedView.setScaleY(f);
            return;
        }
    }

    public void setClickableState(boolean flag)
    {
        GrouponCheckMark grouponcheckmark;
        if (flag)
        {
            grouponcheckmark = this;
        } else
        {
            grouponcheckmark = null;
        }
        setOnClickListener(grouponcheckmark);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener oncheckedchangelistener)
    {
        onCheckedChangeListener = oncheckedchangelistener;
    }

    public void setUncheckedStateVisibility(boolean flag)
    {
        View view = uncheckedView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean toggle()
    {
        boolean flag;
        if (!isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChecked(flag, true);
        return flag;
    }


}
