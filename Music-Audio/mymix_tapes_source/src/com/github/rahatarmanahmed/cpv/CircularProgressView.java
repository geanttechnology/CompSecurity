// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.github.rahatarmanahmed.cpv:
//            CircularProgressViewListener

public class CircularProgressView extends View
{

    private static final float INDETERMINANT_MIN_SWEEP = 15F;
    private float actualProgress;
    private int animDuration;
    private int animSteps;
    private int animSwoopDuration;
    private int animSyncDuration;
    private boolean autostartAnimation;
    private RectF bounds;
    private int color;
    private float currentProgress;
    private AnimatorSet indeterminateAnimator;
    private float indeterminateRotateOffset;
    private float indeterminateSweep;
    private boolean isIndeterminate;
    private List listeners;
    private float maxProgress;
    private Paint paint;
    private ValueAnimator progressAnimator;
    private int size;
    private float startAngle;
    private ValueAnimator startAngleRotate;
    private int thickness;

    public CircularProgressView(Context context)
    {
        super(context);
        size = 0;
        init(null, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        size = 0;
        init(attributeset, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        size = 0;
        init(attributeset, i);
    }

    private AnimatorSet createIndeterminateAnimator(float f)
    {
        final float maxSweep = (360F * (float)(animSteps - 1)) / (float)animSteps + 15F;
        final float start = -90F + (maxSweep - 15F) * f;
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            15F, maxSweep
        });
        valueanimator.setDuration(animDuration / animSteps / 2);
        valueanimator.setInterpolator(new DecelerateInterpolator(1.0F));
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressView this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator4)
            {
                indeterminateSweep = ((Float)valueanimator4.getAnimatedValue()).floatValue();
                invalidate();
            }

            
            {
                this$0 = CircularProgressView.this;
                super();
            }
        });
        ValueAnimator valueanimator1 = ValueAnimator.ofFloat(new float[] {
            (720F * f) / (float)animSteps, ((0.5F + f) * 720F) / (float)animSteps
        });
        valueanimator1.setDuration(animDuration / animSteps / 2);
        valueanimator1.setInterpolator(new LinearInterpolator());
        valueanimator1.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressView this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator4)
            {
                indeterminateRotateOffset = ((Float)valueanimator4.getAnimatedValue()).floatValue();
            }

            
            {
                this$0 = CircularProgressView.this;
                super();
            }
        });
        ValueAnimator valueanimator2 = ValueAnimator.ofFloat(new float[] {
            start, (start + maxSweep) - 15F
        });
        valueanimator2.setDuration(animDuration / animSteps / 2);
        valueanimator2.setInterpolator(new DecelerateInterpolator(1.0F));
        valueanimator2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressView this$0;
            final float val$maxSweep;
            final float val$start;

            public void onAnimationUpdate(ValueAnimator valueanimator4)
            {
                startAngle = ((Float)valueanimator4.getAnimatedValue()).floatValue();
                indeterminateSweep = (maxSweep - startAngle) + start;
                invalidate();
            }

            
            {
                this$0 = CircularProgressView.this;
                maxSweep = f;
                start = f1;
                super();
            }
        });
        ValueAnimator valueanimator3 = ValueAnimator.ofFloat(new float[] {
            ((0.5F + f) * 720F) / (float)animSteps, ((1.0F + f) * 720F) / (float)animSteps
        });
        valueanimator3.setDuration(animDuration / animSteps / 2);
        valueanimator3.setInterpolator(new LinearInterpolator());
        valueanimator3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressView this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator4)
            {
                indeterminateRotateOffset = ((Float)valueanimator4.getAnimatedValue()).floatValue();
            }

            
            {
                this$0 = CircularProgressView.this;
                super();
            }
        });
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(valueanimator).with(valueanimator1);
        animatorset.play(valueanimator2).with(valueanimator3).after(valueanimator1);
        return animatorset;
    }

    private void initAttributes(AttributeSet attributeset, int i)
    {
        attributeset = getContext().obtainStyledAttributes(attributeset, R.styleable.CircularProgressView, i, 0);
        Resources resources = getResources();
        currentProgress = attributeset.getFloat(R.styleable.CircularProgressView_cpv_progress, resources.getInteger(R.integer.cpv_default_progress));
        maxProgress = attributeset.getFloat(R.styleable.CircularProgressView_cpv_maxProgress, resources.getInteger(R.integer.cpv_default_max_progress));
        thickness = attributeset.getDimensionPixelSize(R.styleable.CircularProgressView_cpv_thickness, resources.getDimensionPixelSize(R.dimen.cpv_default_thickness));
        isIndeterminate = attributeset.getBoolean(R.styleable.CircularProgressView_cpv_indeterminate, resources.getBoolean(R.bool.cpv_default_is_indeterminate));
        autostartAnimation = attributeset.getBoolean(R.styleable.CircularProgressView_cpv_animAutostart, resources.getBoolean(R.bool.cpv_default_anim_autostart));
        i = getContext().getResources().getIdentifier("colorAccent", "attr", getContext().getPackageName());
        if (attributeset.hasValue(R.styleable.CircularProgressView_cpv_color))
        {
            color = attributeset.getColor(R.styleable.CircularProgressView_cpv_color, resources.getColor(R.color.cpv_default_color));
        } else
        if (i != 0)
        {
            TypedValue typedvalue = new TypedValue();
            getContext().getTheme().resolveAttribute(i, typedvalue, true);
            color = typedvalue.data;
        } else
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            color = getContext().obtainStyledAttributes(new int[] {
                0x1010435
            }).getColor(0, resources.getColor(R.color.cpv_default_color));
        } else
        {
            color = resources.getColor(R.color.cpv_default_color);
        }
        animDuration = attributeset.getInteger(R.styleable.CircularProgressView_cpv_animDuration, resources.getInteger(R.integer.cpv_default_anim_duration));
        animSwoopDuration = attributeset.getInteger(R.styleable.CircularProgressView_cpv_animSwoopDuration, resources.getInteger(R.integer.cpv_default_anim_swoop_duration));
        animSyncDuration = attributeset.getInteger(R.styleable.CircularProgressView_cpv_animSyncDuration, resources.getInteger(R.integer.cpv_default_anim_sync_duration));
        animSteps = attributeset.getInteger(R.styleable.CircularProgressView_cpv_animSteps, resources.getInteger(R.integer.cpv_default_anim_steps));
        attributeset.recycle();
    }

    private void updateBounds()
    {
        int i = getPaddingLeft();
        int j = getPaddingTop();
        bounds.set(thickness + i, thickness + j, size - i - thickness, size - j - thickness);
    }

    private void updatePaint()
    {
        paint.setColor(color);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(thickness);
        paint.setStrokeCap(android.graphics.Paint.Cap.BUTT);
    }

    public void addListener(CircularProgressViewListener circularprogressviewlistener)
    {
        if (circularprogressviewlistener != null)
        {
            listeners.add(circularprogressviewlistener);
        }
    }

    public int getColor()
    {
        return color;
    }

    public float getMaxProgress()
    {
        return maxProgress;
    }

    public float getProgress()
    {
        return currentProgress;
    }

    public int getThickness()
    {
        return thickness;
    }

    protected void init(AttributeSet attributeset, int i)
    {
        listeners = new ArrayList();
        initAttributes(attributeset, i);
        paint = new Paint(1);
        updatePaint();
        bounds = new RectF();
    }

    public boolean isIndeterminate()
    {
        return isIndeterminate;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (autostartAnimation)
        {
            startAnimation();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (startAngleRotate != null)
        {
            startAngleRotate.cancel();
            startAngleRotate = null;
        }
        if (progressAnimator != null)
        {
            progressAnimator.cancel();
            progressAnimator = null;
        }
        if (indeterminateAnimator != null)
        {
            indeterminateAnimator.cancel();
            indeterminateAnimator = null;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f;
        if (isInEditMode())
        {
            f = (currentProgress / maxProgress) * 360F;
        } else
        {
            f = (actualProgress / maxProgress) * 360F;
        }
        if (!isIndeterminate)
        {
            canvas.drawArc(bounds, startAngle, f, false, paint);
            return;
        } else
        {
            canvas.drawArc(bounds, startAngle + indeterminateRotateOffset, indeterminateSweep, false, paint);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int k = getPaddingLeft() + getPaddingRight();
        int l = getPaddingTop() + getPaddingBottom();
        i = getMeasuredWidth() - k;
        j = getMeasuredHeight() - l;
        if (i >= j)
        {
            i = j;
        }
        size = i;
        setMeasuredDimension(size + k, size + l);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i >= j)
        {
            i = j;
        }
        size = i;
        updateBounds();
    }

    public void removeListener(CircularProgressViewListener circularprogressviewlistener)
    {
        listeners.remove(circularprogressviewlistener);
    }

    public void resetAnimation()
    {
        if (startAngleRotate != null && startAngleRotate.isRunning())
        {
            startAngleRotate.cancel();
        }
        if (progressAnimator != null && progressAnimator.isRunning())
        {
            progressAnimator.cancel();
        }
        if (indeterminateAnimator != null && indeterminateAnimator.isRunning())
        {
            indeterminateAnimator.cancel();
        }
        if (!isIndeterminate)
        {
            startAngle = -90F;
            startAngleRotate = ValueAnimator.ofFloat(new float[] {
                -90F, 270F
            });
            startAngleRotate.setDuration(animSwoopDuration);
            startAngleRotate.setInterpolator(new DecelerateInterpolator(2.0F));
            startAngleRotate.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

                final CircularProgressView this$0;

                public void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    startAngle = ((Float)valueanimator.getAnimatedValue()).floatValue();
                    invalidate();
                }

            
            {
                this$0 = CircularProgressView.this;
                super();
            }
            });
            startAngleRotate.start();
            actualProgress = 0.0F;
            progressAnimator = ValueAnimator.ofFloat(new float[] {
                actualProgress, currentProgress
            });
            progressAnimator.setDuration(animSyncDuration);
            progressAnimator.setInterpolator(new LinearInterpolator());
            progressAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

                final CircularProgressView this$0;

                public void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    actualProgress = ((Float)valueanimator.getAnimatedValue()).floatValue();
                    invalidate();
                }

            
            {
                this$0 = CircularProgressView.this;
                super();
            }
            });
            progressAnimator.start();
        } else
        {
            startAngle = -90F;
            indeterminateSweep = 15F;
            indeterminateAnimator = new AnimatorSet();
            Object obj = null;
            for (int i = 0; i < animSteps; i++)
            {
                AnimatorSet animatorset = createIndeterminateAnimator(i);
                android.animation.AnimatorSet.Builder builder = indeterminateAnimator.play(animatorset);
                if (obj != null)
                {
                    builder.after(((Animator) (obj)));
                }
                obj = animatorset;
            }

            indeterminateAnimator.addListener(new AnimatorListenerAdapter() {

                final CircularProgressView this$0;
                boolean wasCancelled;

                public void onAnimationCancel(Animator animator)
                {
                    wasCancelled = true;
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (!wasCancelled)
                    {
                        resetAnimation();
                    }
                }

            
            {
                this$0 = CircularProgressView.this;
                super();
                wasCancelled = false;
            }
            });
            indeterminateAnimator.start();
            obj = listeners.iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                ((CircularProgressViewListener)((Iterator) (obj)).next()).onAnimationReset();
            }
        }
    }

    public void setColor(int i)
    {
        color = i;
        updatePaint();
        invalidate();
    }

    public void setIndeterminate(boolean flag)
    {
        boolean flag2 = isIndeterminate;
        boolean flag1;
        if (isIndeterminate == flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isIndeterminate = flag;
        if (flag1)
        {
            resetAnimation();
        }
        if (flag2 != flag)
        {
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((CircularProgressViewListener)iterator.next()).onModeChanged(flag)) { }
        }
    }

    public void setMaxProgress(float f)
    {
        maxProgress = f;
        invalidate();
    }

    public void setProgress(final float currentProgress)
    {
        this.currentProgress = currentProgress;
        if (!isIndeterminate)
        {
            if (progressAnimator != null && progressAnimator.isRunning())
            {
                progressAnimator.cancel();
            }
            progressAnimator = ValueAnimator.ofFloat(new float[] {
                actualProgress, currentProgress
            });
            progressAnimator.setDuration(animSyncDuration);
            progressAnimator.setInterpolator(new LinearInterpolator());
            progressAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

                final CircularProgressView this$0;

                public void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    actualProgress = ((Float)valueanimator.getAnimatedValue()).floatValue();
                    invalidate();
                }

            
            {
                this$0 = CircularProgressView.this;
                super();
            }
            });
            progressAnimator.addListener(new AnimatorListenerAdapter() {

                final CircularProgressView this$0;
                final float val$currentProgress;

                public void onAnimationEnd(Animator animator)
                {
                    for (animator = listeners.iterator(); animator.hasNext(); ((CircularProgressViewListener)animator.next()).onProgressUpdateEnd(currentProgress)) { }
                }

            
            {
                this$0 = CircularProgressView.this;
                currentProgress = f;
                super();
            }
            });
            progressAnimator.start();
        }
        invalidate();
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((CircularProgressViewListener)iterator.next()).onProgressUpdate(currentProgress)) { }
    }

    public void setThickness(int i)
    {
        thickness = i;
        updatePaint();
        updateBounds();
        invalidate();
    }

    public void startAnimation()
    {
        resetAnimation();
    }


/*
    static float access$002(CircularProgressView circularprogressview, float f)
    {
        circularprogressview.actualProgress = f;
        return f;
    }

*/




/*
    static float access$202(CircularProgressView circularprogressview, float f)
    {
        circularprogressview.startAngle = f;
        return f;
    }

*/


/*
    static float access$302(CircularProgressView circularprogressview, float f)
    {
        circularprogressview.indeterminateSweep = f;
        return f;
    }

*/


/*
    static float access$402(CircularProgressView circularprogressview, float f)
    {
        circularprogressview.indeterminateRotateOffset = f;
        return f;
    }

*/
}
