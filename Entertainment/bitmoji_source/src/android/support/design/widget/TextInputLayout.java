// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.internal.widget.TintManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package android.support.design.widget:
//            CollapsingTextHelper, AnimationUtils, ViewUtils, ValueAnimatorCompat

public class TextInputLayout extends LinearLayout
{
    private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat
    {

        final TextInputLayout this$0;

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
        {
            super.onInitializeAccessibilityEvent(view, accessibilityevent);
            accessibilityevent.setClassName(android/support/design/widget/TextInputLayout.getSimpleName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
        {
            super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
            accessibilitynodeinfocompat.setClassName(android/support/design/widget/TextInputLayout.getSimpleName());
            view = mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(view))
            {
                accessibilitynodeinfocompat.setText(view);
            }
            if (mEditText != null)
            {
                accessibilitynodeinfocompat.setLabelFor(mEditText);
            }
            if (mErrorView != null)
            {
                view = mErrorView.getText();
            } else
            {
                view = null;
            }
            if (!TextUtils.isEmpty(view))
            {
                accessibilitynodeinfocompat.setContentInvalid(true);
                accessibilitynodeinfocompat.setError(view);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
        {
            super.onPopulateAccessibilityEvent(view, accessibilityevent);
            view = mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(view))
            {
                accessibilityevent.getText().add(view);
            }
        }

        private TextInputAccessibilityDelegate()
        {
            this$0 = TextInputLayout.this;
            super();
        }

    }


    private static final int ANIMATION_DURATION = 200;
    private ValueAnimatorCompat mAnimator;
    private final CollapsingTextHelper mCollapsingTextHelper;
    private ColorStateList mDefaultTextColor;
    private EditText mEditText;
    private boolean mErrorEnabled;
    private int mErrorTextAppearance;
    private TextView mErrorView;
    private ColorStateList mFocusedTextColor;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private Paint mTmpPaint;

    public TextInputLayout(Context context)
    {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        mCollapsingTextHelper = new CollapsingTextHelper(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
        mCollapsingTextHelper.setCollapsedTextGravity(0x800033);
        context = context.obtainStyledAttributes(attributeset, android.support.design.R.styleable.TextInputLayout, i, android.support.design.R.style.Widget_Design_TextInputLayout);
        mHint = context.getText(android.support.design.R.styleable.TextInputLayout_android_hint);
        mHintAnimationEnabled = context.getBoolean(android.support.design.R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (context.hasValue(android.support.design.R.styleable.TextInputLayout_android_textColorHint))
        {
            attributeset = context.getColorStateList(android.support.design.R.styleable.TextInputLayout_android_textColorHint);
            mFocusedTextColor = attributeset;
            mDefaultTextColor = attributeset;
        }
        if (context.getResourceId(android.support.design.R.styleable.TextInputLayout_hintTextAppearance, -1) != -1)
        {
            setHintTextAppearance(context.getResourceId(android.support.design.R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        mErrorTextAppearance = context.getResourceId(android.support.design.R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean flag = context.getBoolean(android.support.design.R.styleable.TextInputLayout_errorEnabled, false);
        context.recycle();
        setErrorEnabled(flag);
        if (ViewCompat.getImportantForAccessibility(this) == 0)
        {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new TextInputAccessibilityDelegate());
    }

    private void animateToExpansionFraction(float f)
    {
        if (mCollapsingTextHelper.getExpansionFraction() == f)
        {
            return;
        }
        if (mAnimator == null)
        {
            mAnimator = ViewUtils.createAnimator();
            mAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            mAnimator.setDuration(200);
            mAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {

                final TextInputLayout this$0;

                public void onAnimationUpdate(ValueAnimatorCompat valueanimatorcompat)
                {
                    mCollapsingTextHelper.setExpansionFraction(valueanimatorcompat.getAnimatedFloatValue());
                }

            
            {
                this$0 = TextInputLayout.this;
                super();
            }
            });
        }
        mAnimator.setFloatValues(mCollapsingTextHelper.getExpansionFraction(), f);
        mAnimator.start();
    }

    private static boolean arrayContains(int ai[], int i)
    {
        int k = ai.length;
        for (int j = 0; j < k; j++)
        {
            if (ai[j] == i)
            {
                return true;
            }
        }

        return false;
    }

    private void collapseHint(boolean flag)
    {
        if (mAnimator != null && mAnimator.isRunning())
        {
            mAnimator.cancel();
        }
        if (flag && mHintAnimationEnabled)
        {
            animateToExpansionFraction(1.0F);
            return;
        } else
        {
            mCollapsingTextHelper.setExpansionFraction(1.0F);
            return;
        }
    }

    private void expandHint(boolean flag)
    {
        if (mAnimator != null && mAnimator.isRunning())
        {
            mAnimator.cancel();
        }
        if (flag && mHintAnimationEnabled)
        {
            animateToExpansionFraction(0.0F);
            return;
        } else
        {
            mCollapsingTextHelper.setExpansionFraction(0.0F);
            return;
        }
    }

    private int getThemeAttrColor(int i)
    {
        TypedValue typedvalue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedvalue, true))
        {
            return typedvalue.data;
        } else
        {
            return -65281;
        }
    }

    private void setEditText(EditText edittext)
    {
        if (mEditText != null)
        {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        mEditText = edittext;
        mCollapsingTextHelper.setTypeface(mEditText.getTypeface());
        mCollapsingTextHelper.setExpandedTextSize(mEditText.getTextSize());
        mCollapsingTextHelper.setExpandedTextGravity(mEditText.getGravity());
        mEditText.addTextChangedListener(new TextWatcher() {

            final TextInputLayout this$0;

            public void afterTextChanged(Editable editable)
            {
                updateLabelVisibility(true);
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = TextInputLayout.this;
                super();
            }
        });
        if (mDefaultTextColor == null)
        {
            mDefaultTextColor = mEditText.getHintTextColors();
        }
        if (TextUtils.isEmpty(mHint))
        {
            setHint(mEditText.getHint());
            mEditText.setHint(null);
        }
        if (mErrorView != null)
        {
            ViewCompat.setPaddingRelative(mErrorView, ViewCompat.getPaddingStart(mEditText), 0, ViewCompat.getPaddingEnd(mEditText), mEditText.getPaddingBottom());
        }
        updateLabelVisibility(false);
    }

    private android.widget.LinearLayout.LayoutParams updateEditTextMargin(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
        {
            layoutparams = (android.widget.LinearLayout.LayoutParams)layoutparams;
        } else
        {
            layoutparams = new android.widget.LinearLayout.LayoutParams(layoutparams);
        }
        if (mTmpPaint == null)
        {
            mTmpPaint = new Paint();
        }
        mTmpPaint.setTypeface(mCollapsingTextHelper.getTypeface());
        mTmpPaint.setTextSize(mCollapsingTextHelper.getCollapsedTextSize());
        layoutparams.topMargin = (int)(-mTmpPaint.ascent());
        return layoutparams;
    }

    private void updateLabelVisibility(boolean flag)
    {
        boolean flag1;
        boolean flag2;
        if (mEditText != null && !TextUtils.isEmpty(mEditText.getText()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = arrayContains(getDrawableState(), 0x101009c);
        if (mDefaultTextColor != null && mFocusedTextColor != null)
        {
            mCollapsingTextHelper.setExpandedTextColor(mDefaultTextColor.getDefaultColor());
            CollapsingTextHelper collapsingtexthelper = mCollapsingTextHelper;
            int i;
            if (flag2)
            {
                i = mFocusedTextColor.getDefaultColor();
            } else
            {
                i = mDefaultTextColor.getDefaultColor();
            }
            collapsingtexthelper.setCollapsedTextColor(i);
        }
        if (flag1 || flag2)
        {
            collapseHint(flag);
            return;
        } else
        {
            expandHint(flag);
            return;
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (view instanceof EditText)
        {
            setEditText((EditText)view);
            super.addView(view, 0, updateEditTextMargin(layoutparams));
            return;
        } else
        {
            super.addView(view, i, layoutparams);
            return;
        }
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        mCollapsingTextHelper.draw(canvas);
    }

    public EditText getEditText()
    {
        return mEditText;
    }

    public CharSequence getError()
    {
        if (mErrorEnabled && mErrorView != null && mErrorView.getVisibility() == 0)
        {
            return mErrorView.getText();
        } else
        {
            return null;
        }
    }

    public CharSequence getHint()
    {
        return mHint;
    }

    public boolean isErrorEnabled()
    {
        return mErrorEnabled;
    }

    public boolean isHintAnimationEnabled()
    {
        return mHintAnimationEnabled;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (mEditText != null)
        {
            i = mEditText.getLeft() + mEditText.getCompoundPaddingLeft();
            k = mEditText.getRight() - mEditText.getCompoundPaddingRight();
            mCollapsingTextHelper.setExpandedBounds(i, mEditText.getTop() + mEditText.getCompoundPaddingTop(), k, mEditText.getBottom() - mEditText.getCompoundPaddingBottom());
            mCollapsingTextHelper.setCollapsedBounds(i, getPaddingTop(), k, l - j - getPaddingBottom());
            mCollapsingTextHelper.recalculate();
        }
    }

    public void refreshDrawableState()
    {
        super.refreshDrawableState();
        updateLabelVisibility(ViewCompat.isLaidOut(this));
    }

    public void setError(CharSequence charsequence)
    {
        if (!mErrorEnabled)
        {
            if (TextUtils.isEmpty(charsequence))
            {
                return;
            }
            setErrorEnabled(true);
        }
        if (TextUtils.isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        ViewCompat.setAlpha(mErrorView, 0.0F);
        mErrorView.setText(charsequence);
        ViewCompat.animate(mErrorView).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter() {

            final TextInputLayout this$0;

            public void onAnimationStart(View view)
            {
                view.setVisibility(0);
            }

            
            {
                this$0 = TextInputLayout.this;
                super();
            }
        }).start();
        ViewCompat.setBackgroundTintList(mEditText, ColorStateList.valueOf(mErrorView.getCurrentTextColor()));
_L4:
        sendAccessibilityEvent(2048);
        return;
_L2:
        if (mErrorView.getVisibility() == 0)
        {
            ViewCompat.animate(mErrorView).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter() {

                final TextInputLayout this$0;

                public void onAnimationEnd(View view)
                {
                    view.setVisibility(4);
                }

            
            {
                this$0 = TextInputLayout.this;
                super();
            }
            }).start();
            charsequence = TintManager.get(getContext());
            ViewCompat.setBackgroundTintList(mEditText, charsequence.getTintList(android.support.design.R.drawable.abc_edit_text_material));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setErrorEnabled(boolean flag)
    {
        if (mErrorEnabled != flag)
        {
            if (mErrorView != null)
            {
                ViewCompat.animate(mErrorView).cancel();
            }
            if (flag)
            {
                mErrorView = new TextView(getContext());
                mErrorView.setTextAppearance(getContext(), mErrorTextAppearance);
                mErrorView.setVisibility(4);
                addView(mErrorView);
                if (mEditText != null)
                {
                    ViewCompat.setPaddingRelative(mErrorView, ViewCompat.getPaddingStart(mEditText), 0, ViewCompat.getPaddingEnd(mEditText), mEditText.getPaddingBottom());
                }
            } else
            {
                removeView(mErrorView);
                mErrorView = null;
            }
            mErrorEnabled = flag;
        }
    }

    public void setHint(CharSequence charsequence)
    {
        mHint = charsequence;
        mCollapsingTextHelper.setText(charsequence);
        sendAccessibilityEvent(2048);
    }

    public void setHintAnimationEnabled(boolean flag)
    {
        mHintAnimationEnabled = flag;
    }

    public void setHintTextAppearance(int i)
    {
        mCollapsingTextHelper.setCollapsedTextAppearance(i);
        mFocusedTextColor = ColorStateList.valueOf(mCollapsingTextHelper.getCollapsedTextColor());
        if (mEditText != null)
        {
            updateLabelVisibility(false);
            android.widget.LinearLayout.LayoutParams layoutparams = updateEditTextMargin(mEditText.getLayoutParams());
            mEditText.setLayoutParams(layoutparams);
            mEditText.requestLayout();
        }
    }

    public void setTypeface(Typeface typeface)
    {
        mCollapsingTextHelper.setTypeface(typeface);
    }




}
