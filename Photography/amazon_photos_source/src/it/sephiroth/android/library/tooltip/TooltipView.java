// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package it.sephiroth.android.library.tooltip:
//            Tooltip, TooltipTextDrawable

class TooltipView extends ViewGroup
    implements Tooltip
{
    static interface OnCloseListener
    {

        public abstract void onClose(TooltipView tooltipview);
    }

    static interface OnToolTipListener
    {

        public abstract void onHideCompleted(TooltipView tooltipview);

        public abstract void onShowCompleted(TooltipView tooltipview);

        public abstract void onShowFailed(TooltipView tooltipview);
    }


    private static final String TAG = "ToolTipLayout";
    private final long activateDelay;
    Runnable activateRunnable;
    private final TooltipManager.onTooltipClosingCallback closeCallback;
    private OnCloseListener closeListener;
    private final TooltipManager.ClosePolicy closePolicy;
    private final Rect drawRect = new Rect();
    private final long fadeDuration;
    TooltipManager.Gravity gravity;
    private final boolean hideArrow;
    Runnable hideRunnable;
    private boolean mActivated;
    private boolean mAttached;
    private final TooltipTextDrawable mDrawable;
    private boolean mInitialized;
    Animator mShowAnimation;
    boolean mShowing;
    private TextView mTextView;
    private View mView;
    private final int maxWidth;
    private int padding;
    private final Point point;
    private final boolean restrict;
    private final long showDelay;
    private final long showDuration;
    private final View targetView;
    private final Rect tempRect = new Rect();
    private CharSequence text;
    private final int textResId;
    private final int toolTipId;
    private OnToolTipListener tooltipListener;
    private final int topRule;
    private final Rect viewRect = new Rect();

    public TooltipView(Context context, TooltipManager.Builder builder)
    {
        super(context);
        activateRunnable = new Runnable() {

            final TooltipView this$0;

            public void run()
            {
                mActivated = true;
            }

            
            {
                this$0 = TooltipView.this;
                super();
            }
        };
        hideRunnable = new Runnable() {

            final TooltipView this$0;

            public void run()
            {
                onClose(false);
            }

            
            {
                this$0 = TooltipView.this;
                super();
            }
        };
        TypedArray typedarray = context.getTheme().obtainStyledAttributes(null, R.styleable.TooltipLayout, builder.defStyleAttr, builder.defStyleRes);
        padding = typedarray.getDimensionPixelSize(0, 30);
        typedarray.recycle();
        toolTipId = builder.id;
        text = builder.text;
        gravity = builder.gravity;
        textResId = builder.textResId;
        maxWidth = builder.maxWidth;
        topRule = builder.actionbarSize;
        closePolicy = builder.closePolicy;
        showDuration = builder.showDuration;
        showDelay = builder.showDelay;
        hideArrow = builder.hideArrow;
        activateDelay = builder.activateDelay;
        targetView = builder.view;
        restrict = builder.restrictToScreenEdges;
        fadeDuration = builder.fadeDuration;
        closeCallback = builder.closeCallback;
        if (builder.point != null)
        {
            point = new Point(builder.point);
            Point point1 = point;
            point1.y = point1.y + topRule;
        } else
        {
            point = null;
        }
        if (!builder.isCustomView)
        {
            mDrawable = new TooltipTextDrawable(context, builder);
        } else
        {
            mDrawable = null;
        }
        setVisibility(4);
    }

    private void calculatePositions(List list)
    {
        if (isAttached()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        TooltipManager.Gravity gravity1;
        Point point1;
        Rect rect;
        int i;
        int j;
        if (list.size() < 1)
        {
            if (tooltipListener != null)
            {
                tooltipListener.onShowFailed(this);
            }
            setVisibility(8);
            return;
        }
        gravity1 = (TooltipManager.Gravity)list.get(0);
        list.remove(0);
        rect = new Rect();
        ((Activity)getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        i = rect.top;
        rect.top = rect.top + topRule;
        if (targetView != null)
        {
            targetView.getGlobalVisibleRect(viewRect);
        } else
        {
            viewRect.set(point.x, point.y + i, point.x, point.y + i);
        }
        i = mView.getWidth();
        j = mView.getMeasuredHeight();
        point1 = new Point();
        if (gravity1 != TooltipManager.Gravity.BOTTOM) goto _L4; else goto _L3
_L3:
        drawRect.set(viewRect.centerX() - i / 2, viewRect.bottom, viewRect.centerX() + i / 2, viewRect.bottom + j);
        point1.x = viewRect.centerX();
        point1.y = viewRect.bottom;
        if (!restrict || rect.contains(drawRect))
        {
            break MISSING_BLOCK_LABEL_422;
        }
        if (drawRect.right <= rect.right) goto _L6; else goto _L5
_L5:
        drawRect.offset(rect.right - drawRect.right, 0);
_L8:
        if (drawRect.bottom > rect.bottom)
        {
            calculatePositions(list);
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (drawRect.left < rect.left)
        {
            drawRect.offset(-drawRect.left, 0);
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (drawRect.top < rect.top)
        {
            drawRect.offset(0, rect.top - drawRect.top);
        }
_L10:
        ViewHelper.setTranslationX(mView, drawRect.left);
        ViewHelper.setTranslationY(mView, drawRect.top);
        if (mDrawable != null)
        {
            mView.getGlobalVisibleRect(tempRect);
            point1.x = point1.x - tempRect.left;
            point1.y = point1.y - tempRect.top;
            if (AnimatorProxy.NEEDS_PROXY)
            {
                point1.x = point1.x - drawRect.left;
                point1.y = point1.y - drawRect.top;
            }
            if (!hideArrow)
            {
                if (gravity1 == TooltipManager.Gravity.LEFT || gravity1 == TooltipManager.Gravity.RIGHT)
                {
                    point1.y = point1.y - padding / 2;
                } else
                if (gravity1 == TooltipManager.Gravity.TOP || gravity1 == TooltipManager.Gravity.BOTTOM)
                {
                    point1.x = point1.x - padding / 2;
                }
            }
            list = mDrawable;
            if (hideArrow)
            {
                i = 0;
            } else
            {
                i = padding / 2;
            }
            list.setAnchor(gravity1, i);
            if (!hideArrow)
            {
                mDrawable.setDestinationPoint(point1);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (gravity1 != TooltipManager.Gravity.TOP)
        {
            break MISSING_BLOCK_LABEL_841;
        }
        drawRect.set(viewRect.centerX() - i / 2, viewRect.top - j, viewRect.centerX() + i / 2, viewRect.top);
        point1.x = viewRect.centerX();
        point1.y = viewRect.top;
        if (!restrict || rect.contains(drawRect)) goto _L10; else goto _L9
_L9:
        if (drawRect.right <= rect.right) goto _L12; else goto _L11
_L11:
        drawRect.offset(rect.right - drawRect.right, 0);
_L14:
        if (drawRect.top < rect.top)
        {
            calculatePositions(list);
            return;
        }
        break; /* Loop/switch isn't completed */
_L12:
        if (drawRect.left < rect.left)
        {
            drawRect.offset(-drawRect.left, 0);
        }
        if (true) goto _L14; else goto _L13
_L13:
        if (drawRect.bottom <= rect.bottom) goto _L10; else goto _L15
_L15:
        drawRect.offset(0, rect.bottom - drawRect.bottom);
          goto _L10
        if (gravity1 != TooltipManager.Gravity.RIGHT)
        {
            break MISSING_BLOCK_LABEL_1072;
        }
        drawRect.set(viewRect.right, viewRect.centerY() - j / 2, viewRect.right + i, viewRect.centerY() + j / 2);
        point1.x = viewRect.right;
        point1.y = viewRect.centerY();
        if (!restrict || rect.contains(drawRect)) goto _L10; else goto _L16
_L16:
        if (drawRect.bottom <= rect.bottom) goto _L18; else goto _L17
_L17:
        drawRect.offset(0, rect.bottom - drawRect.bottom);
_L20:
        if (drawRect.right > rect.right)
        {
            calculatePositions(list);
            return;
        }
        break; /* Loop/switch isn't completed */
_L18:
        if (drawRect.top < rect.top)
        {
            drawRect.offset(0, rect.top - drawRect.top);
        }
        if (true) goto _L20; else goto _L19
_L19:
        if (drawRect.left >= rect.left) goto _L10; else goto _L21
_L21:
        drawRect.offset(rect.left - drawRect.left, 0);
          goto _L10
        if (gravity1 != TooltipManager.Gravity.LEFT)
        {
            break MISSING_BLOCK_LABEL_1310;
        }
        drawRect.set(viewRect.left - i, viewRect.centerY() - j / 2, viewRect.left, viewRect.centerY() + j / 2);
        point1.x = viewRect.left;
        point1.y = viewRect.centerY();
        if (!restrict || rect.contains(drawRect)) goto _L10; else goto _L22
_L22:
        if (drawRect.bottom <= rect.bottom) goto _L24; else goto _L23
_L23:
        drawRect.offset(0, rect.bottom - drawRect.bottom);
_L26:
        if (drawRect.left < rect.left)
        {
            gravity = TooltipManager.Gravity.RIGHT;
            calculatePositions(list);
            return;
        }
        break; /* Loop/switch isn't completed */
_L24:
        if (drawRect.top < rect.top)
        {
            drawRect.offset(0, rect.top - drawRect.top);
        }
        if (true) goto _L26; else goto _L25
_L25:
        if (drawRect.right <= rect.right) goto _L10; else goto _L27
_L27:
        drawRect.offset(rect.right - drawRect.right, 0);
          goto _L10
        if (gravity == TooltipManager.Gravity.CENTER)
        {
            drawRect.set(viewRect.centerX() - i / 2, viewRect.centerY() - j / 2, viewRect.centerX() - i / 2, viewRect.centerY() + j / 2);
            point1.x = viewRect.centerX();
            point1.y = viewRect.centerY();
            if (restrict && !rect.contains(drawRect))
            {
                if (drawRect.bottom > rect.bottom)
                {
                    drawRect.offset(0, rect.bottom - drawRect.bottom);
                } else
                if (drawRect.top < rect.top)
                {
                    drawRect.offset(0, rect.top - drawRect.top);
                }
                if (drawRect.right > rect.right)
                {
                    drawRect.offset(rect.right - drawRect.right, 0);
                } else
                if (drawRect.left < rect.left)
                {
                    drawRect.offset(rect.left - drawRect.left, 0);
                }
            }
        }
          goto _L10
    }

    private void fireOnHideCompleted()
    {
        if (tooltipListener != null)
        {
            tooltipListener.onHideCompleted(this);
        }
    }

    private void initializeView()
    {
        if (!isAttached() || mInitialized)
        {
            return;
        }
        mInitialized = true;
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
        mView = LayoutInflater.from(getContext()).inflate(textResId, this, false);
        mView.setLayoutParams(layoutparams);
        if (mDrawable != null)
        {
            mView.setBackgroundDrawable(mDrawable);
            if (hideArrow)
            {
                mView.setPadding(padding / 2, padding / 2, padding / 2, padding / 2);
            } else
            {
                mView.setPadding(padding, padding, padding, padding);
            }
        }
        mTextView = (TextView)mView.findViewById(0x1020014);
        mTextView.setText(Html.fromHtml((String)text));
        if (maxWidth > -1)
        {
            mTextView.setMaxWidth(maxWidth);
        }
        addView(mView);
    }

    private void onClose(boolean flag)
    {
        if (getHandler() != null && isAttached())
        {
            getHandler().removeCallbacks(hideRunnable);
            if (closeListener != null)
            {
                closeListener.onClose(this);
            }
            if (closeCallback != null)
            {
                closeCallback.onClosing(toolTipId, flag);
                return;
            }
        }
    }

    protected void fadeIn()
    {
        if (!mShowing) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mShowAnimation != null)
        {
            mShowAnimation.cancel();
        }
        mShowing = true;
        if (fadeDuration <= 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        mShowAnimation = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            0.0F, 1.0F
        });
        mShowAnimation.setDuration(fadeDuration);
        if (showDelay > 0L)
        {
            mShowAnimation.setStartDelay(showDelay);
        }
        mShowAnimation.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            boolean cancelled;
            final TooltipView this$0;

            public void onAnimationCancel(Animator animator)
            {
                cancelled = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                if (tooltipListener != null && !cancelled)
                {
                    tooltipListener.onShowCompleted(TooltipView.this);
                    postActivate(activateDelay);
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                setVisibility(0);
                cancelled = false;
            }

            
            {
                this$0 = TooltipView.this;
                super();
            }
        });
        mShowAnimation.start();
_L4:
        if (showDuration > 0L)
        {
            getHandler().removeCallbacks(hideRunnable);
            getHandler().postDelayed(hideRunnable, showDuration);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        setVisibility(0);
        tooltipListener.onShowCompleted(this);
        if (!mActivated)
        {
            postActivate(activateDelay);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void fadeOut(final boolean remove)
    {
        if (isAttached() && mShowing)
        {
            if (mShowAnimation != null)
            {
                mShowAnimation.cancel();
            }
            mShowing = false;
            if (fadeDuration > 0L)
            {
                mShowAnimation = ObjectAnimator.ofFloat(this, "alpha", new float[] {
                    ViewHelper.getAlpha(this), 0.0F
                });
                mShowAnimation.setDuration(fadeDuration);
                mShowAnimation.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                    boolean cancelled;
                    final TooltipView this$0;
                    final boolean val$remove;

                    public void onAnimationCancel(Animator animator)
                    {
                        cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        if (cancelled)
                        {
                            return;
                        }
                        if (remove)
                        {
                            fireOnHideCompleted();
                        }
                        mShowAnimation = null;
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                        cancelled = false;
                    }

            
            {
                this$0 = TooltipView.this;
                remove = flag;
                super();
            }
                });
                mShowAnimation.start();
                return;
            }
            setVisibility(4);
            if (remove)
            {
                fireOnHideCompleted();
                return;
            }
        }
    }

    int getTooltipId()
    {
        return toolTipId;
    }

    public void hide(boolean flag)
    {
        if (!isAttached())
        {
            return;
        } else
        {
            fadeOut(flag);
            return;
        }
    }

    public boolean isAttached()
    {
        return mAttached;
    }

    boolean isShowing()
    {
        return mShowing;
    }

    public void offsetTo(int i, int j)
    {
        ViewHelper.setTranslationX(this, i - viewRect.left);
        ViewHelper.setTranslationY(this, j - viewRect.top);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mAttached = true;
        initializeView();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mAttached = false;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        j = getChildCount();
        for (i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 8)
            {
                view.layout(view.getLeft(), view.getTop(), view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }

        if (flag)
        {
            ArrayList arraylist = new ArrayList(Arrays.asList(new TooltipManager.Gravity[] {
                TooltipManager.Gravity.LEFT, TooltipManager.Gravity.RIGHT, TooltipManager.Gravity.TOP, TooltipManager.Gravity.BOTTOM, TooltipManager.Gravity.CENTER
            }));
            arraylist.remove(gravity);
            arraylist.add(0, gravity);
            calculatePositions(arraylist);
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        byte byte1 = -1;
        byte byte0 = -1;
        int k1 = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.getSize(j);
        i = byte1;
        if (k1 != 0)
        {
            i = i1;
        }
        j = byte0;
        if (j1 != 0)
        {
            j = l;
        }
        l = getChildCount();
        for (int k = 0; k < l; k++)
        {
            View view = getChildAt(k);
            if (view.getVisibility() != 8)
            {
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x80000000));
            }
        }

        setMeasuredDimension(i, j);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        if (mAttached && mShowing && isShown()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        int i = motionevent.getAction();
        if (closePolicy != TooltipManager.ClosePolicy.TouchOutside && closePolicy != TooltipManager.ClosePolicy.TouchInside)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!mActivated)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i == 0)
        {
            if (closePolicy == TooltipManager.ClosePolicy.TouchInside)
            {
                if (drawRect.contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    onClose(true);
                    return true;
                } else
                {
                    return false;
                }
            } else
            {
                onClose(true);
                return drawRect.contains((int)motionevent.getX(), (int)motionevent.getY());
            }
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    void postActivate(long l)
    {
        if (l > 0L)
        {
            if (isAttached())
            {
                postDelayed(activateRunnable, l);
            }
            return;
        } else
        {
            mActivated = true;
            return;
        }
    }

    void removeFromParent()
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent != null)
        {
            if (getHandler() != null)
            {
                getHandler().removeCallbacks(hideRunnable);
            }
            ((ViewGroup)viewparent).removeView(this);
            if (mShowAnimation != null && mShowAnimation.isStarted())
            {
                mShowAnimation.cancel();
            }
        }
    }

    public void setOffsetX(int i)
    {
        ViewHelper.setTranslationX(this, i - viewRect.left);
    }

    public void setOffsetY(int i)
    {
        ViewHelper.setTranslationY(this, i - viewRect.top);
    }

    void setOnCloseListener(OnCloseListener oncloselistener)
    {
        closeListener = oncloselistener;
    }

    void setOnToolTipListener(OnToolTipListener ontooltiplistener)
    {
        tooltipListener = ontooltiplistener;
    }

    void setText(CharSequence charsequence)
    {
        text = charsequence;
        if (mTextView != null)
        {
            mTextView.setText(Html.fromHtml((String)charsequence));
        }
    }

    public void show()
    {
        if (!isAttached())
        {
            return;
        } else
        {
            fadeIn();
            return;
        }
    }




/*
    static boolean access$202(TooltipView tooltipview, boolean flag)
    {
        tooltipview.mActivated = flag;
        return flag;
    }

*/


}
