// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

public final class FloatLabelLayout extends FrameLayout
{

    private EditText mEditText;
    private TextView mLabel;
    private Spinner mSpinner;

    public FloatLabelLayout(Context context)
    {
        this(context, null);
    }

    public FloatLabelLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FloatLabelLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, com.boldchat.sdk.R.styleable.FloatLabelLayout);
        i = attributeset.getDimensionPixelSize(com.boldchat.sdk.R.styleable.FloatLabelLayout_floatLabelSidePadding, dipsToPix(12F));
        mLabel = new TextView(context);
        mLabel.setPadding(i, 0, i, 0);
        mLabel.setVisibility(4);
        mLabel.setTextAppearance(context, attributeset.getResourceId(com.boldchat.sdk.R.styleable.FloatLabelLayout_floatLabelTextAppearance, 0x1030046));
        addView(mLabel, -2, -2);
        attributeset.recycle();
    }

    private int dipsToPix(float f)
    {
        return (int)TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private void setEditText(EditText edittext)
    {
        mEditText = edittext;
        mEditText.addTextChangedListener(new TextWatcher() {

            final FloatLabelLayout this$0;

            public void afterTextChanged(Editable editable)
            {
                if (TextUtils.isEmpty(editable))
                {
                    hideLabel();
                    return;
                } else
                {
                    showLabel();
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = FloatLabelLayout.this;
                super();
            }
        });
        mEditText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final FloatLabelLayout this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    mLabel.setActivated(flag);
                }
            }

            
            {
                this$0 = FloatLabelLayout.this;
                super();
            }
        });
        mLabel.setText(mEditText.getHint());
    }

    private void setSpinner(Spinner spinner)
    {
        mSpinner = spinner;
        mSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final FloatLabelLayout this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                if (i == 0 || TextUtils.isEmpty(mLabel.getText()))
                {
                    hideLabel();
                    return;
                } else
                {
                    showLabel();
                    return;
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = FloatLabelLayout.this;
                super();
            }
        });
        mSpinner.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final FloatLabelLayout this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    mLabel.setActivated(flag);
                }
            }

            
            {
                this$0 = FloatLabelLayout.this;
                super();
            }
        });
    }

    public final void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        Object obj;
label0:
        {
            if (!(view instanceof EditText))
            {
                obj = layoutparams;
                if (!(view instanceof Spinner))
                {
                    break label0;
                }
            }
            if (view instanceof EditText)
            {
                if (mEditText != null)
                {
                    throw new IllegalArgumentException("We already have an EditText, can only have one");
                }
                setEditText((EditText)view);
            }
            if (view instanceof Spinner)
            {
                if (mSpinner != null)
                {
                    throw new IllegalArgumentException("We already have an EditText, can only have one");
                }
                setSpinner((Spinner)view);
            }
            obj = new android.widget.FrameLayout.LayoutParams(layoutparams);
            obj.gravity = 80;
            obj.topMargin = (int)mLabel.getTextSize();
        }
        super.addView(view, i, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public EditText getEditText()
    {
        return mEditText;
    }

    public TextView getLabel()
    {
        return mLabel;
    }

    public Spinner getSpinner()
    {
        return mSpinner;
    }

    public void hideLabel()
    {
label0:
        {
            if (mLabel.getVisibility() == 0)
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    break label0;
                }
                mLabel.setAlpha(1.0F);
                mLabel.setTranslationY(0.0F);
                mLabel.animate().alpha(0.0F).translationY(mLabel.getHeight()).setDuration(150L).setListener(new AnimatorListenerAdapter() {

                    final FloatLabelLayout this$0;

                    public void onAnimationEnd(Animator animator)
                    {
                        mLabel.setVisibility(8);
                    }

            
            {
                this$0 = FloatLabelLayout.this;
                super();
            }
                }).start();
            }
            return;
        }
        mLabel.setVisibility(8);
    }

    public void showLabel()
    {
        if (mLabel.getVisibility() != 0)
        {
            if (mEditText != null)
            {
                mLabel.setText(mEditText.getHint());
            }
            mLabel.setVisibility(0);
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                mLabel.setAlpha(0.0F);
                mLabel.setTranslationY(mLabel.getHeight());
                mLabel.animate().alpha(1.0F).translationY(0.0F).setDuration(150L).setListener(null).start();
            }
        }
    }

}
