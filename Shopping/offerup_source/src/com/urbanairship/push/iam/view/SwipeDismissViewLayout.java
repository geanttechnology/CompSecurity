// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.content.Context;
import android.support.v4.view.at;
import android.support.v4.view.bi;
import android.support.v4.widget.bo;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.urbanairship.Logger;

public class SwipeDismissViewLayout extends FrameLayout
{

    private static final float FLING_MIN_DRAG_PERCENT = 0.1F;
    private static final float IDLE_MIN_DRAG_PERCENT = 0.75F;
    private bo dragHelper;
    private Listener listener;
    private float minFlingVelocity;

    public SwipeDismissViewLayout(Context context)
    {
        super(context);
        init(context);
    }

    public SwipeDismissViewLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public SwipeDismissViewLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    public SwipeDismissViewLayout(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        init(context);
    }

    private void init(Context context)
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            minFlingVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
            dragHelper = bo.a(this, new ViewDragCallback(null));
            return;
        }
    }

    public void computeScroll()
    {
        super.computeScroll();
        if (dragHelper != null && dragHelper.a(true))
        {
            bi.d(this);
        }
    }

    public float getMinFlingVelocity()
    {
        return minFlingVelocity;
    }

    public float getXFraction()
    {
        int i = getWidth();
        if (i == 0)
        {
            return 0.0F;
        } else
        {
            return getTranslationX() / (float)i;
        }
    }

    public float getYFraction()
    {
        int i = getHeight();
        if (i == 0)
        {
            return 0.0F;
        } else
        {
            return getTranslationY() / (float)i;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (!dragHelper.a(motionevent) && !super.onInterceptTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        Logger.error((new StringBuilder("onInterceptTouchEvent ")).append(motionevent).toString());
_L4:
        return true;
_L2:
        if (dragHelper.a() != 0 || at.a(motionevent) != 2 || !dragHelper.c(1))
        {
            break; /* Loop/switch isn't completed */
        }
        View view = dragHelper.b((int)motionevent.getX(), (int)motionevent.getY());
        if (view == null || bi.a(view, dragHelper.d()))
        {
            break; /* Loop/switch isn't completed */
        }
        dragHelper.a(view, at.b(motionevent, 0));
        if (dragHelper.a() != 1)
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        dragHelper.b(motionevent);
        return dragHelper.c() != null;
    }

    public void setListener(Listener listener1)
    {
        this;
        JVM INSTR monitorenter ;
        listener = listener1;
        this;
        JVM INSTR monitorexit ;
        return;
        listener1;
        this;
        JVM INSTR monitorexit ;
        throw listener1;
    }

    public void setMinFlingVelocity(float f)
    {
        minFlingVelocity = f;
    }

    public void setXFraction(final float xFraction)
    {
        if (getVisibility() == 0 && getHeight() == 0)
        {
            _cls2 _lcls2 = new _cls2();
            getViewTreeObserver().addOnPreDrawListener(_lcls2);
            return;
        } else
        {
            setTranslationX((float)getWidth() * xFraction);
            return;
        }
    }

    public void setYFraction(final float yFraction)
    {
        if (getVisibility() == 0 && getHeight() == 0)
        {
            _cls1 _lcls1 = new _cls1();
            getViewTreeObserver().addOnPreDrawListener(_lcls1);
            return;
        } else
        {
            setTranslationY((float)getHeight() * yFraction);
            return;
        }
    }




    private class ViewDragCallback extends br
    {

        private View capturedView;
        private float dragPercent;
        private boolean isDismissed;
        private int startLeft;
        private int startTop;
        final SwipeDismissViewLayout this$0;

        public int clampViewPositionHorizontal(View view, int i, int j)
        {
            return i;
        }

        public int clampViewPositionVertical(View view, int i, int j)
        {
            return view.getTop();
        }

        public void onViewCaptured(View view, int i)
        {
            capturedView = view;
            startTop = view.getTop();
            startLeft = view.getLeft();
            dragPercent = 0.0F;
            isDismissed = false;
        }

        public void onViewDragStateChanged(int i)
        {
            if (capturedView == null)
            {
                return;
            }
            this;
            JVM INSTR monitorenter ;
            if (listener != null)
            {
                listener.onDragStateChanged(capturedView, i);
            }
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_90;
            }
            if (isDismissed)
            {
                if (listener != null)
                {
                    listener.onDismissed(capturedView);
                }
                removeView(capturedView);
            }
            capturedView = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onViewPositionChanged(View view, int i, int j, int k, int l)
        {
            j = getWidth() / 2;
            i = Math.abs(i - startLeft);
            if (j > 0)
            {
                dragPercent = (float)i / (float)j;
            }
            if (android.os.Build.VERSION.SDK_INT > 11)
            {
                view.setAlpha(1.0F - dragPercent);
                invalidate();
            }
        }

        public void onViewReleased(View view, float f, float f1)
        {
            int i;
label0:
            {
                boolean flag1 = false;
                boolean flag;
                if (Math.abs(f) > minFlingVelocity)
                {
                    if (f > 0.0F)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                } else
                if (startLeft < view.getLeft())
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (dragPercent < 0.75F)
                {
                    flag = flag1;
                    if (Math.abs(f) <= minFlingVelocity)
                    {
                        break label0;
                    }
                    flag = flag1;
                    if (dragPercent <= 0.1F)
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            isDismissed = flag;
            if (isDismissed)
            {
                if (i != 0)
                {
                    i = -view.getWidth();
                } else
                {
                    i = view.getWidth();
                }
                dragHelper.a(startLeft - i, startTop);
            } else
            {
                dragHelper.a(startLeft, startTop);
            }
            invalidate();
        }

        public boolean tryCaptureView(View view, int i)
        {
            return capturedView == null;
        }

        private ViewDragCallback()
        {
            this$0 = SwipeDismissViewLayout.this;
            super();
            dragPercent = 0.0F;
            isDismissed = false;
        }

        ViewDragCallback(_cls1 _pcls1)
        {
            this();
        }

        private class Listener
        {

            public abstract void onDismissed(View view);

            public abstract void onDragStateChanged(View view, int i);
        }

    }


    private class _cls2
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final SwipeDismissViewLayout this$0;
        final float val$xFraction;

        public boolean onPreDraw()
        {
            setXFraction(xFraction);
            getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }

        _cls2()
        {
            this$0 = SwipeDismissViewLayout.this;
            xFraction = f;
            super();
        }
    }


    private class _cls1
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final SwipeDismissViewLayout this$0;
        final float val$yFraction;

        public boolean onPreDraw()
        {
            setYFraction(yFraction);
            getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }

        _cls1()
        {
            this$0 = SwipeDismissViewLayout.this;
            yFraction = f;
            super();
        }
    }

}
