// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            AviaryOverlay

public class BlemishOverlay extends AviaryOverlay
{
    static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State ALL;
        public static final State FIRST;
        public static final State NONE;
        public static final State SECOND;
        public static final State THIRD;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/aviary/android/feather/sdk/overlays/BlemishOverlay$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            NONE = new State("NONE", 0);
            FIRST = new State("FIRST", 1);
            SECOND = new State("SECOND", 2);
            THIRD = new State("THIRD", 3);
            ALL = new State("ALL", 4);
            $VALUES = (new State[] {
                NONE, FIRST, SECOND, THIRD, ALL
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private int alpha1;
    private int alpha2;
    private Drawable arrow;
    private CharSequence mDetailText1;
    private CharSequence mDetailText2;
    private State mState;
    private android.text.Layout.Alignment mTextAlign1;
    private Drawable mTextDrawable1;
    private Drawable mTextDrawable2;
    private CharSequence mTextRelativePosition1;
    private CharSequence mTextRelativePosition2;
    private float mTextWidthFraction1;
    private float mTextWidthFraction2;
    private Drawable mTitleDrawable1;
    private Drawable mTitleDrawable2;
    private CharSequence mTitleText1;
    private CharSequence mTitleText2;
    private View mView1;
    private View mView2;
    private Drawable ripple;
    private final Rect viewRect1 = new Rect();
    private final Rect viewRect2 = new Rect();

    public BlemishOverlay(Context context, int i, View view, View view1)
    {
        super(context, ToolLoaderFactory.getToolName(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.BLEMISH), i, 2);
        mState = State.NONE;
        alpha2 = 0;
        alpha1 = 0;
        mView1 = view;
        mView2 = view1;
        ripple = generateRipple();
        arrow = generateArrow();
        context = context.getResources();
        mTitleText1 = context.getString(com.aviary.android.feather.sdk.R.string.feather_overlay_tap_title);
        mDetailText1 = context.getString(com.aviary.android.feather.sdk.R.string.feather_overlay_blemish_tap_text);
        mTextWidthFraction1 = context.getFraction(com.aviary.android.feather.sdk.R.fraction.aviary_overlay_blemish_text1_width, 100, 100);
        mTextRelativePosition1 = context.getString(com.aviary.android.feather.sdk.R.string.aviary_overlay_blemish_text1_position);
        mTitleText2 = context.getString(com.aviary.android.feather.sdk.R.string.feather_overlay_zoom_title);
        mDetailText2 = context.getString(com.aviary.android.feather.sdk.R.string.feather_overlay_zoom_text);
        mTextWidthFraction2 = context.getFraction(com.aviary.android.feather.sdk.R.fraction.aviary_overlay_blemish_text2_width, 100, 100);
        mTextRelativePosition2 = context.getString(com.aviary.android.feather.sdk.R.string.aviary_overlay_blemish_text2_position);
        context = context.getString(com.aviary.android.feather.sdk.R.string.aviary_overlay_default_text_align);
        if (android.text.Layout.Alignment.ALIGN_CENTER.name().equals(context))
        {
            mTextAlign1 = android.text.Layout.Alignment.ALIGN_CENTER;
        } else
        if (android.text.Layout.Alignment.ALIGN_OPPOSITE.equals(context))
        {
            mTextAlign1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        } else
        {
            mTextAlign1 = android.text.Layout.Alignment.ALIGN_NORMAL;
        }
        addCloseButton(new int[] {
            9, 12
        });
    }

    private void calculateTextLayouts()
    {
        if (isAttachedToParent())
        {
            char c = '\0';
            if (mState == State.ALL)
            {
                c = '\377';
            }
            Object obj = getDisplayMetrics();
            if (mState != State.FIRST);
            if ((mState == State.SECOND || mState == State.ALL) && (mState == State.ALL || mTextDrawable1 == null || mTitleDrawable1 == null))
            {
                mView1.getGlobalVisibleRect(viewRect1);
                ripple.setBounds(viewRect1.left + viewRect1.width() / 3, viewRect1.top + viewRect1.height() / 3, viewRect1.left + viewRect1.width() / 3 + ripple.getIntrinsicWidth(), viewRect1.top + viewRect1.height() / 3 + ripple.getIntrinsicHeight());
                ripple.setAlpha(c);
                int i = (int)((float)((DisplayMetrics) (obj)).widthPixels * (mTextWidthFraction1 / 100F));
                mTextDrawable1 = generateTextDrawable(getContext(), mDetailText1, i, mTextAlign1);
                Rect rect = generateBounds(mTextDrawable1, ripple.getBounds(), getTextMargins(), mTextRelativePosition1);
                mTextDrawable1.setBounds(rect);
                mTextDrawable1.setAlpha(c);
                mTitleDrawable1 = generateTitleDrawable(getContext(), mTitleText1, i, mTextAlign1);
                Rect rect2 = new Rect(0, 0, mTitleDrawable1.getIntrinsicWidth(), mTitleDrawable1.getIntrinsicHeight());
                rect2.offsetTo(rect.left, rect.top - rect2.height() - getTitleMargins());
                mTitleDrawable1.setAlpha(c);
                mTitleDrawable1.setBounds(rect2);
            }
            if ((mState == State.THIRD || mState == State.ALL) && (mState == State.ALL || mTextDrawable2 == null || mTitleDrawable2 == null))
            {
                mView2.getGlobalVisibleRect(viewRect2);
                arrow.setBounds(viewRect2.centerX(), viewRect2.top - arrow.getIntrinsicHeight(), viewRect2.centerX() + arrow.getIntrinsicWidth(), viewRect2.top);
                arrow.setAlpha(c);
                int j = (int)((float)((DisplayMetrics) (obj)).widthPixels * (mTextWidthFraction2 / 100F));
                mTextDrawable2 = generateTextDrawable(getContext(), mDetailText2, j, mTextAlign1);
                obj = generateBounds(mTextDrawable2, arrow.getBounds(), getTextMargins(), mTextRelativePosition2);
                mTextDrawable2.setBounds(((Rect) (obj)));
                mTextDrawable2.setAlpha(c);
                mTitleDrawable2 = generateTitleDrawable(getContext(), mTitleText2, j, mTextAlign1);
                Rect rect1 = new Rect(0, 0, mTitleDrawable2.getIntrinsicWidth(), mTitleDrawable2.getIntrinsicHeight());
                rect1.offsetTo(((Rect) (obj)).left, ((Rect) (obj)).top - rect1.height() - getTitleMargins());
                mTitleDrawable2.setBounds(rect1);
                mTitleDrawable2.setAlpha(c);
                return;
            }
        }
    }

    private Rect generateBounds(Drawable drawable, Rect rect, int i, CharSequence charsequence)
    {
        DisplayMetrics displaymetrics = getDisplayMetrics();
        int j = drawable.getIntrinsicWidth();
        drawable = new Rect(0, 0, j, drawable.getIntrinsicHeight());
        int k = rect.top;
        int l = drawable.height();
        if (POSITION_LEFT.equals(charsequence))
        {
            j = rect.left - j;
        } else
        if (POSITION_CENTER.equals(charsequence))
        {
            j = rect.centerX() - j / 2;
        } else
        {
            j = rect.right;
        }
        drawable.offsetTo(j, k - l - i);
        if (((Rect) (drawable)).right > displaymetrics.widthPixels)
        {
            drawable.offsetTo(displaymetrics.widthPixels - drawable.width() - i, ((Rect) (drawable)).top);
        } else
        if (((Rect) (drawable)).left < 0)
        {
            drawable.offsetTo(i, ((Rect) (drawable)).top);
            return drawable;
        }
        return drawable;
    }

    private void onAnimationComplete()
    {
        logger.info("onAnimationComplete. state: %s", new Object[] {
            mState
        });
        static class _cls4
        {

            static final int $SwitchMap$com$aviary$android$feather$sdk$overlays$BlemishOverlay$State[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$sdk$overlays$BlemishOverlay$State = new int[State.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$overlays$BlemishOverlay$State[State.NONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$overlays$BlemishOverlay$State[State.FIRST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$overlays$BlemishOverlay$State[State.SECOND.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$overlays$BlemishOverlay$State[State.THIRD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4..SwitchMap.com.aviary.android.feather.sdk.overlays.BlemishOverlay.State[mState.ordinal()])
        {
        case 1: // '\001'
        default:
            return;

        case 2: // '\002'
            setState(State.SECOND);
            return;

        case 3: // '\003'
            setState(State.THIRD);
            break;
        }
    }

    private void setState(State state)
    {
        logger.info("setState: %s", new Object[] {
            state
        });
        mState = state;
        calculatePositions();
    }

    public void calculatePositions()
    {
        calculateTextLayouts();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (getVisibility() != 0 || !isAttachedToParent() || mView1 == null)
        {
            return;
        }
        calculateTextLayouts();
        canvas.drawColor(getBackgroundColor());
        if (mState == State.SECOND || mState == State.THIRD || mState == State.ALL)
        {
            ripple.draw(canvas);
            mTextDrawable1.draw(canvas);
            mTitleDrawable1.draw(canvas);
        }
        if (mState == State.THIRD || mState == State.ALL)
        {
            arrow.draw(canvas);
            mTextDrawable2.draw(canvas);
            mTitleDrawable2.draw(canvas);
            canvas.save();
            canvas.translate(viewRect2.left, viewRect2.top);
            if (alpha2 < 255)
            {
                int i = canvas.saveLayerAlpha(0.0F, 0.0F, viewRect2.width(), viewRect2.height(), alpha2, 4);
                mView2.draw(canvas);
                canvas.restoreToCount(i);
            } else
            {
                mView2.draw(canvas);
            }
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    protected void doShow()
    {
        logger.info("doShow");
        if (!isAttachedToParent())
        {
            return;
        } else
        {
            fadeIn();
            return;
        }
    }

    protected Animator generateInAnimation()
    {
        AnimatorSet animatorset = new AnimatorSet();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            0.0F, 1.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofInt(this, "alpha1", new int[] {
            0, 255
        });
        ObjectAnimator objectanimator2 = ObjectAnimator.ofInt(this, "alpha2", new int[] {
            0, 255
        });
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            0, 255
        });
        objectanimator1.setStartDelay(200L);
        objectanimator2.setStartDelay(400L);
        valueanimator.setStartDelay(400L);
        objectanimator.setDuration(getAnimationDuration());
        objectanimator1.setDuration(getAnimationDuration());
        objectanimator2.setDuration(getAnimationDuration());
        valueanimator.setDuration(getAnimationDuration());
        objectanimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final BlemishOverlay this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                onAnimationComplete();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = BlemishOverlay.this;
                super();
            }
        });
        objectanimator1.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final BlemishOverlay this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                onAnimationComplete();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = BlemishOverlay.this;
                super();
            }
        });
        objectanimator2.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final BlemishOverlay this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                onAnimationComplete();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = BlemishOverlay.this;
                super();
            }
        });
        animatorset.playSequentially(new Animator[] {
            objectanimator, objectanimator1, objectanimator2, valueanimator
        });
        return animatorset;
    }

    public int getAlpha1()
    {
        return alpha1;
    }

    public int getAlpha2()
    {
        return alpha2;
    }

    protected void inAnimationCompleted()
    {
        logger.info("inAnimationCompleted");
        if (getCloseButton() != null)
        {
            getCloseButton().setVisibility(0);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        mState = State.ALL;
        super.onConfigurationChanged(configuration);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            hide("background");
        }
        return true;
    }

    public void setAlpha1(int i)
    {
        alpha1 = i;
        ripple.setAlpha(i);
        mTitleDrawable1.setAlpha(i);
        mTextDrawable1.setAlpha(i);
        postInvalidate();
    }

    public void setAlpha2(int i)
    {
        alpha2 = i;
        arrow.setAlpha(i);
        mTitleDrawable2.setAlpha(i);
        mTextDrawable2.setAlpha(i);
        postInvalidate();
    }

    public boolean showDelayed(long l)
    {
        setState(State.FIRST);
        return super.showDelayed(l);
    }

}
