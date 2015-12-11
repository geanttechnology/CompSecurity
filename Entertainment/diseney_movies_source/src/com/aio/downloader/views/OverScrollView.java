// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import java.util.Timer;
import java.util.TimerTask;

public class OverScrollView extends ScrollView
{
    class MyTimer
    {

        private Handler handler;
        private MyTask mTask;
        final OverScrollView this$0;
        private Timer timer;

        public void cancel()
        {
            if (mTask != null)
            {
                mTask.cancel();
                mTask = null;
            }
        }

        public void schedule(long l)
        {
            if (mTask != null)
            {
                mTask.cancel();
                mTask = null;
            }
            mTask = new MyTask(handler);
            timer.schedule(mTask, 0L, l);
        }

        public MyTimer(Handler handler1)
        {
            this$0 = OverScrollView.this;
            super();
            handler = handler1;
            timer = new Timer();
        }
    }

    class MyTimer.MyTask extends TimerTask
    {

        private Handler handler;
        final MyTimer this$1;

        public void run()
        {
            handler.obtainMessage().sendToTarget();
        }

        public MyTimer.MyTask(Handler handler1)
        {
            this$1 = MyTimer.this;
            super();
            handler = handler1;
        }
    }

    public static interface OverScrollListener
    {

        public abstract void footerScroll();

        public abstract void headerScroll();
    }

    public static interface OverScrollTinyListener
    {

        public abstract void scrollDistance(int i, int j);

        public abstract void scrollLoosen();
    }


    public static final String TAG = "PullToRefreshLayout";
    private static final int TRIGGER_HEIGHT = 120;
    public float MOVE_SPEED;
    private boolean canPullDown;
    private boolean canPullUp;
    private float downY;
    private boolean isLayout;
    private float lastY;
    private int mEvents;
    private OverScrollListener mOverScrollListener;
    private OverScrollTinyListener mOverScrollTinyListener;
    private int mOverScrollTrigger;
    private float overScrollDistance;
    public float pullDownY;
    private float pullUpY;
    private View pullableView;
    private float radio;
    private MyTimer timer;
    Handler updateHandler = new Handler() {

        final OverScrollView this$0;

        public void handleMessage(Message message)
        {
            MOVE_SPEED = (float)(5D + 15D * Math.tan((1.5707963267948966D / (double)getMeasuredHeight()) * (double)(pullDownY + Math.abs(pullUpY))));
            if (pullDownY <= 0.0F) goto _L2; else goto _L1
_L1:
            message = OverScrollView.this;
            message.pullDownY = ((OverScrollView) (message)).pullDownY - MOVE_SPEED;
_L4:
            if (pullDownY < 0.0F)
            {
                pullDownY = 0.0F;
                timer.cancel();
            }
            if (pullUpY > 0.0F)
            {
                pullUpY = 0.0F;
                timer.cancel();
            }
            requestLayout();
            return;
_L2:
            if (pullUpY < 0.0F)
            {
                message = OverScrollView.this;
                message.pullUpY = ((OverScrollView) (message)).pullUpY + MOVE_SPEED;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                this$0 = OverScrollView.this;
                super();
            }
    };

    public OverScrollView(Context context)
    {
        super(context);
        mOverScrollTrigger = 120;
        pullDownY = 0.0F;
        pullUpY = 0.0F;
        MOVE_SPEED = 8F;
        isLayout = false;
        radio = 2.0F;
        canPullDown = true;
        canPullUp = true;
        initView(context);
    }

    public OverScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mOverScrollTrigger = 120;
        pullDownY = 0.0F;
        pullUpY = 0.0F;
        MOVE_SPEED = 8F;
        isLayout = false;
        radio = 2.0F;
        canPullDown = true;
        canPullUp = true;
        initView(context);
    }

    public OverScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mOverScrollTrigger = 120;
        pullDownY = 0.0F;
        pullUpY = 0.0F;
        MOVE_SPEED = 8F;
        isLayout = false;
        radio = 2.0F;
        canPullDown = true;
        canPullUp = true;
        initView(context);
    }

    private void hide()
    {
        timer.schedule(5L);
    }

    private void initView(Context context)
    {
        timer = new MyTimer(updateHandler);
        setFadingEdgeLength(0);
    }

    private boolean isCanPullDown()
    {
        return getScrollY() == 0 || pullableView.getHeight() < getHeight() + getScrollY();
    }

    private boolean isCanPullUp()
    {
        return pullableView.getHeight() <= getHeight() + getScrollY();
    }

    private boolean isOnBottom()
    {
        return getScrollY() + getHeight() == pullableView.getHeight();
    }

    private boolean isOnTop()
    {
        return getScrollY() == 0;
    }

    private void overScrollTrigger()
    {
        if (mOverScrollListener != null)
        {
            if (overScrollDistance > (float)mOverScrollTrigger && overScrollDistance >= 0.0F)
            {
                mOverScrollListener.headerScroll();
            }
            if (overScrollDistance < (float)(-mOverScrollTrigger) && overScrollDistance < 0.0F)
            {
                mOverScrollListener.footerScroll();
                return;
            }
        }
    }

    private void releasePull()
    {
        canPullDown = true;
        canPullUp = true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 48
    //                   0 56
    //                   1 450
    //                   2 99
    //                   3 491
    //                   4 48
    //                   5 91
    //                   6 91;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L6
_L1:
        float f;
        try
        {
            super.dispatchTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            motionevent.printStackTrace();
            return true;
        }
        return true;
_L2:
        downY = motionevent.getY();
        lastY = downY;
        timer.cancel();
        mEvents = 0;
        releasePull();
        continue; /* Loop/switch isn't completed */
_L6:
        mEvents = -1;
        continue; /* Loop/switch isn't completed */
_L4:
        f = motionevent.getY() - lastY;
        if (mEvents == 0)
        {
            if (canPullDown && isCanPullDown())
            {
                pullDownY = pullDownY + f / radio;
                if (motionevent.getY() - lastY < 0.0F)
                {
                    pullDownY = pullDownY + f;
                }
                if (pullDownY < 0.0F)
                {
                    pullDownY = 0.0F;
                    canPullDown = false;
                    canPullUp = true;
                }
                if (pullDownY > (float)getMeasuredHeight())
                {
                    pullDownY = getMeasuredHeight();
                }
                overScrollDistance = pullDownY;
            } else
            if (canPullUp && isCanPullUp())
            {
                pullUpY = pullUpY + f / radio;
                if (motionevent.getY() - lastY > 0.0F)
                {
                    pullUpY = pullUpY + f;
                }
                if (pullUpY > 0.0F)
                {
                    pullUpY = 0.0F;
                    canPullDown = true;
                    canPullUp = false;
                }
                if (pullUpY < (float)(-getMeasuredHeight()))
                {
                    pullUpY = -getMeasuredHeight();
                }
                overScrollDistance = pullUpY;
            } else
            {
                releasePull();
            }
        } else
        {
            mEvents = 0;
        }
        lastY = motionevent.getY();
        radio = (float)(2D + 3D * Math.tan((1.5707963267948966D / (double)getMeasuredHeight()) * (double)(pullDownY + Math.abs(pullUpY))));
        requestLayout();
        if (pullDownY + Math.abs(pullUpY) > 8F)
        {
            motionevent.setAction(3);
        }
        if (mOverScrollTinyListener != null)
        {
            mOverScrollTinyListener.scrollDistance((int)f, (int)overScrollDistance);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        hide();
        overScrollTrigger();
        if (mOverScrollTinyListener != null && (isCanPullDown() || isCanPullUp()))
        {
            mOverScrollTinyListener.scrollLoosen();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mOverScrollTinyListener != null && (isCanPullDown() || isCanPullUp()))
        {
            mOverScrollTinyListener.scrollLoosen();
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public OverScrollListener getOverScrollListener()
    {
        return mOverScrollListener;
    }

    public OverScrollTinyListener getOverScrollTinyListener()
    {
        return mOverScrollTinyListener;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (!isLayout)
        {
            pullableView = getChildAt(0);
            isLayout = true;
        }
        pullableView.layout(0, (int)(pullDownY + pullUpY), pullableView.getMeasuredWidth(), (int)(pullDownY + pullUpY) + pullableView.getMeasuredHeight());
    }

    public void setOverScrollListener(OverScrollListener overscrolllistener)
    {
        mOverScrollListener = overscrolllistener;
    }

    public void setOverScrollTinyListener(OverScrollTinyListener overscrolltinylistener)
    {
        mOverScrollTinyListener = overscrolltinylistener;
    }

    public void setOverScrollTrigger(int i)
    {
        if (i >= 30)
        {
            mOverScrollTrigger = i;
        }
    }



}
