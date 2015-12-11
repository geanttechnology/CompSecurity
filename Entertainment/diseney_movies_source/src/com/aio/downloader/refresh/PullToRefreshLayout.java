// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.refresh;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.refresh:
//            Pullable

public class PullToRefreshLayout extends RelativeLayout
{
    class MyTimer
    {

        private Handler handler;
        private MyTask mTask;
        final PullToRefreshLayout this$0;
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
            this$0 = PullToRefreshLayout.this;
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

    public static interface OnRefreshListener
    {

        public abstract void onRefresh(PullToRefreshLayout pulltorefreshlayout);
    }


    public static final int DONE = 3;
    public static final int FAIL = 1;
    public static final int INIT = 0;
    public static final int REFRESHING = 2;
    public static final int RELEASE_TO_REFRESH = 1;
    public static final int SUCCEED = 0;
    public static final String TAG = "PullToRefreshLayout";
    public float MOVE_SPEED;
    private float downY;
    private boolean isLayout;
    private boolean isTouch;
    private float lastY;
    private int mEvents;
    private OnRefreshListener mListener;
    public float pullDownY;
    private View pullView;
    private View pullableView;
    private float radio;
    private float refreshDist;
    private View refreshStateImageView;
    private TextView refreshStateTextView;
    private View refreshView;
    private RotateAnimation refreshingAnimation;
    private View refreshingView;
    private RotateAnimation rotateAnimation;
    private int state;
    private MyTimer timer;
    Handler updateHandler = new Handler() {

        final PullToRefreshLayout this$0;

        public void handleMessage(Message message)
        {
            MOVE_SPEED = (float)(8D + 20D * Math.tan((1.5707963267948966D / (double)getMeasuredHeight()) * (double)pullDownY));
            if (!isTouch && state == 2 && pullDownY <= refreshDist)
            {
                pullDownY = refreshDist;
                timer.cancel();
            }
            if (pullDownY > 0.0F)
            {
                message = PullToRefreshLayout.this;
                message.pullDownY = ((PullToRefreshLayout) (message)).pullDownY - MOVE_SPEED;
            }
            if (pullDownY <= 0.0F)
            {
                pullDownY = 0.0F;
                pullView.clearAnimation();
                if (state != 2)
                {
                    changeState(0);
                }
                timer.cancel();
            }
            requestLayout();
        }

            
            {
                this$0 = PullToRefreshLayout.this;
                super();
            }
    };

    public PullToRefreshLayout(Context context)
    {
        super(context);
        state = 0;
        pullDownY = 0.0F;
        refreshDist = 200F;
        MOVE_SPEED = 8F;
        isLayout = false;
        isTouch = false;
        radio = 2.0F;
        initView(context);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        state = 0;
        pullDownY = 0.0F;
        refreshDist = 200F;
        MOVE_SPEED = 8F;
        isLayout = false;
        isTouch = false;
        radio = 2.0F;
        initView(context);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        state = 0;
        pullDownY = 0.0F;
        refreshDist = 200F;
        MOVE_SPEED = 8F;
        isLayout = false;
        isTouch = false;
        radio = 2.0F;
        initView(context);
    }

    private void changeState(int i)
    {
        state = i;
        switch (state)
        {
        default:
            return;

        case 0: // '\0'
            refreshStateImageView.setVisibility(8);
            refreshStateTextView.setText(0x7f0b005b);
            pullView.startAnimation((RotateAnimation)AnimationUtils.loadAnimation(getContext(), 0x7f04001c));
            pullView.setVisibility(0);
            return;

        case 1: // '\001'
            refreshStateTextView.setText(0x7f0b005c);
            pullView.startAnimation(rotateAnimation);
            return;

        case 2: // '\002'
            pullView.clearAnimation();
            break;
        }
        refreshingView.setVisibility(0);
        pullView.setVisibility(4);
        refreshingView.startAnimation(refreshingAnimation);
        refreshStateTextView.setText(0x7f0b005d);
    }

    private void hide()
    {
        timer.schedule(5L);
    }

    private void initView()
    {
        pullView = refreshView.findViewById(0x7f07038a);
        refreshStateTextView = (TextView)refreshView.findViewById(0x7f070388);
        refreshingView = refreshView.findViewById(0x7f070386);
        refreshStateImageView = refreshView.findViewById(0x7f070389);
    }

    private void initView(Context context)
    {
        timer = new MyTimer(updateHandler);
        rotateAnimation = (RotateAnimation)AnimationUtils.loadAnimation(context, 0x7f04001b);
        refreshingAnimation = (RotateAnimation)AnimationUtils.loadAnimation(context, 0x7f04001d);
        context = new LinearInterpolator();
        rotateAnimation.setInterpolator(context);
        refreshingAnimation.setInterpolator(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 48
    //                   0 56
    //                   1 347
    //                   2 95
    //                   3 48
    //                   4 48
    //                   5 87
    //                   6 87;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L5
_L1:
        super.dispatchTouchEvent(motionevent);
        return true;
_L2:
        downY = motionevent.getY();
        lastY = downY;
        timer.cancel();
        mEvents = 0;
        continue; /* Loop/switch isn't completed */
_L5:
        mEvents = -1;
        continue; /* Loop/switch isn't completed */
_L4:
        if (mEvents == 0)
        {
            if (((Pullable)pullableView).canPullDown())
            {
                pullDownY = pullDownY + (motionevent.getY() - lastY) / radio;
                if (motionevent.getY() - lastY < 0.0F)
                {
                    pullDownY = pullDownY + (motionevent.getY() - lastY);
                }
                if (pullDownY < 0.0F)
                {
                    pullDownY = 0.0F;
                }
                if (pullDownY > (float)getMeasuredHeight())
                {
                    pullDownY = getMeasuredHeight();
                }
                if (state == 2)
                {
                    isTouch = true;
                }
            }
        } else
        {
            mEvents = 0;
        }
        lastY = motionevent.getY();
        radio = (float)(2D + 3D * Math.tan((1.5707963267948966D / (double)getMeasuredHeight()) * (double)pullDownY));
        requestLayout();
        if (pullDownY <= refreshDist && (state == 1 || state == 3))
        {
            changeState(0);
        }
        if (pullDownY >= refreshDist && state == 0)
        {
            changeState(1);
        }
        if (pullDownY > 8F)
        {
            motionevent.setAction(3);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (pullDownY > refreshDist)
        {
            isTouch = false;
        }
        if (state == 1)
        {
            changeState(2);
            if (mListener != null)
            {
                mListener.onRefresh(this);
            }
        }
        hide();
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (!isLayout)
        {
            refreshView = getChildAt(0);
            pullableView = getChildAt(1);
            isLayout = true;
            initView();
            refreshDist = ((ViewGroup)refreshView).getChildAt(0).getMeasuredHeight();
        }
        refreshView.layout(0, (int)pullDownY - refreshView.getMeasuredHeight(), refreshView.getMeasuredWidth(), (int)pullDownY);
        pullableView.layout(0, (int)pullDownY, pullableView.getMeasuredWidth(), (int)pullDownY + pullableView.getMeasuredHeight());
    }

    public void refreshFinish(int i)
    {
        refreshingView.clearAnimation();
        refreshingView.setVisibility(8);
        i;
        JVM INSTR tableswitch 0 0: default 36
    //                   0 81;
           goto _L1 _L2
_L1:
        refreshStateImageView.setVisibility(0);
        refreshStateTextView.setText(0x7f0b005f);
        refreshStateImageView.setBackgroundResource(0x7f020168);
_L4:
        (new Handler() {

            final PullToRefreshLayout this$0;

            public void handleMessage(Message message)
            {
                changeState(3);
                if (!isTouch)
                {
                    hide();
                }
            }

            
            {
                this$0 = PullToRefreshLayout.this;
                super();
            }
        }).sendEmptyMessageDelayed(0, 1000L);
        return;
_L2:
        refreshStateImageView.setVisibility(0);
        refreshStateTextView.setText(0x7f0b005e);
        refreshStateImageView.setBackgroundResource(0x7f020169);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setOnRefreshListener(OnRefreshListener onrefreshlistener)
    {
        mListener = onrefreshlistener;
    }







}
