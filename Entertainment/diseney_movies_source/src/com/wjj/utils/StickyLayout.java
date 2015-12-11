// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import java.util.NoSuchElementException;

public class StickyLayout extends LinearLayout
{
    public static interface OnGiveUpTouchEventListener
    {

        public abstract boolean giveUpTouchEvent(MotionEvent motionevent);
    }


    private static final boolean DEBUG = true;
    public static final int STATUS_COLLAPSED = 2;
    public static final int STATUS_EXPANDED = 1;
    private static final String TAG = "StickyLayout";
    private static final int TAN = 2;
    private View mContent;
    private boolean mDisallowInterceptTouchEventOnHeader;
    private OnGiveUpTouchEventListener mGiveUpTouchEventListener;
    private View mHeader;
    private int mHeaderHeight;
    private boolean mInitDataSucceed;
    private boolean mIsSticky;
    private int mLastX;
    private int mLastXIntercept;
    private int mLastY;
    private int mLastYIntercept;
    private int mOriginalHeaderHeight;
    private int mStatus;
    private int mTouchSlop;

    public StickyLayout(Context context)
    {
        super(context);
        mStatus = 1;
        mLastX = 0;
        mLastY = 0;
        mLastXIntercept = 0;
        mLastYIntercept = 0;
        mIsSticky = true;
        mInitDataSucceed = false;
        mDisallowInterceptTouchEventOnHeader = true;
    }

    public StickyLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mStatus = 1;
        mLastX = 0;
        mLastY = 0;
        mLastXIntercept = 0;
        mLastYIntercept = 0;
        mIsSticky = true;
        mInitDataSucceed = false;
        mDisallowInterceptTouchEventOnHeader = true;
    }

    public StickyLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mStatus = 1;
        mLastX = 0;
        mLastY = 0;
        mLastXIntercept = 0;
        mLastYIntercept = 0;
        mIsSticky = true;
        mInitDataSucceed = false;
        mDisallowInterceptTouchEventOnHeader = true;
    }

    private void initData()
    {
        int i = getResources().getIdentifier("sticky_header", "id", getContext().getPackageName());
        int j = getResources().getIdentifier("sticky_content", "id", getContext().getPackageName());
        if (i != 0 && j != 0)
        {
            mHeader = findViewById(i);
            mContent = findViewById(j);
            mOriginalHeaderHeight = mHeader.getMeasuredHeight();
            mHeaderHeight = mOriginalHeaderHeight;
            mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (mHeaderHeight > 0)
            {
                mInitDataSucceed = true;
            }
            Log.d("StickyLayout", (new StringBuilder("mTouchSlop = ")).append(mTouchSlop).append("mHeaderHeight = ").append(mHeaderHeight).toString());
            return;
        } else
        {
            throw new NoSuchElementException("Did your view with id \"sticky_header\" or \"sticky_content\" exists?");
        }
    }

    public int getHeaderHeight()
    {
        return mHeaderHeight;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        boolean flag;
        int k;
        flag = false;
        i = (int)motionevent.getX();
        k = (int)motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 44
    //                   0 81
    //                   1 227
    //                   2 108;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_227;
_L1:
        i = ((flag) ? 1 : 0);
_L5:
        Log.d("StickyLayout", (new StringBuilder("intercepted=")).append(i).toString());
        int j;
        int l;
        return i != 0 && mIsSticky;
_L2:
        mLastXIntercept = i;
        mLastYIntercept = k;
        mLastX = i;
        mLastY = k;
        i = 0;
          goto _L5
_L4:
        l = mLastXIntercept;
        j = k - mLastYIntercept;
        if (mDisallowInterceptTouchEventOnHeader && k <= getHeaderHeight())
        {
            i = 0;
        } else
        if (Math.abs(j) <= Math.abs(i - l))
        {
            i = 0;
        } else
        if (mStatus == 1 && j <= -mTouchSlop)
        {
            i = 1;
        } else
        {
            i = ((flag) ? 1 : 0);
            if (mGiveUpTouchEventListener != null)
            {
                i = ((flag) ? 1 : 0);
                if (mGiveUpTouchEventListener.giveUpTouchEvent(motionevent))
                {
                    i = ((flag) ? 1 : 0);
                    if (j >= mTouchSlop)
                    {
                        i = 1;
                    }
                }
            }
        }
          goto _L5
        i = 0;
        mLastYIntercept = 0;
        mLastXIntercept = 0;
          goto _L5
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int k;
        int l;
        if (!mIsSticky)
        {
            return true;
        }
        k = (int)motionevent.getX();
        l = (int)motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 52
    //                   0 52
    //                   1 145
    //                   2 65;
           goto _L1 _L1 _L2 _L3
_L1:
        mLastX = k;
        mLastY = l;
        return true;
_L3:
        int i = mLastX;
        i = l - mLastY;
        Log.d("StickyLayout", (new StringBuilder("mHeaderHeight=")).append(mHeaderHeight).append("  deltaY=").append(i).append("  mlastY=").append(mLastY).toString());
        mHeaderHeight = mHeaderHeight + i;
        setHeaderHeight(mHeaderHeight);
        continue; /* Loop/switch isn't completed */
_L2:
        int j;
        if ((double)mHeaderHeight <= (double)mOriginalHeaderHeight * 0.5D)
        {
            j = 0;
            mStatus = 2;
        } else
        {
            j = mOriginalHeaderHeight;
            mStatus = 1;
        }
        smoothSetHeaderHeight(mHeaderHeight, j, 500L);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && (mHeader == null || mContent == null))
        {
            initData();
        }
    }

    public void requestDisallowInterceptTouchEventOnHeader(boolean flag)
    {
        mDisallowInterceptTouchEventOnHeader = flag;
    }

    public void setHeaderHeight(int i)
    {
        if (!mInitDataSucceed)
        {
            initData();
        }
        Log.d("StickyLayout", (new StringBuilder("setHeaderHeight height=")).append(i).toString());
        int j;
        if (i <= 0)
        {
            j = 0;
        } else
        {
            j = i;
            if (i > mOriginalHeaderHeight)
            {
                j = mOriginalHeaderHeight;
            }
        }
        if (j == 0)
        {
            mStatus = 2;
        } else
        {
            mStatus = 1;
        }
        if (mHeader != null && mHeader.getLayoutParams() != null)
        {
            mHeader.getLayoutParams().height = j;
            mHeader.requestLayout();
            mHeaderHeight = j;
            return;
        } else
        {
            Log.e("StickyLayout", "null LayoutParams when setHeaderHeight");
            return;
        }
    }

    public void setHeaderHeight(int i, boolean flag)
    {
        if (flag)
        {
            setOriginalHeaderHeight(i);
        }
        setHeaderHeight(i);
    }

    public void setOnGiveUpTouchEventListener(OnGiveUpTouchEventListener ongiveuptoucheventlistener)
    {
        mGiveUpTouchEventListener = ongiveuptoucheventlistener;
    }

    public void setOriginalHeaderHeight(int i)
    {
        mOriginalHeaderHeight = i;
    }

    public void setSticky(boolean flag)
    {
        mIsSticky = flag;
    }

    public void smoothSetHeaderHeight(int i, int j, long l)
    {
        smoothSetHeaderHeight(i, j, l, false);
    }

    public void smoothSetHeaderHeight(int i, int j, long l, boolean flag)
    {
        int k = (int)(((float)l / 1000F) * 30F) + 1;
        (new Thread(flag) {

            final StickyLayout this$0;
            private final int val$frameCount;
            private final int val$from;
            private final boolean val$modifyOriginalHeaderHeight;
            private final float val$partation;
            private final int val$to;

            public void run()
            {
                int i1 = 0;
                do
                {
                    if (i1 >= frameCount)
                    {
                        if (modifyOriginalHeaderHeight)
                        {
                            setOriginalHeaderHeight(to);
                        }
                        return;
                    }
                    int j1;
                    if (i1 == frameCount - 1)
                    {
                        j1 = to;
                    } else
                    {
                        j1 = (int)((float)from + partation * (float)i1);
                    }
                    post(j1. new Runnable() {

                        final _cls1 this$1;
                        private final int val$height;

                        public void run()
                        {
                            setHeaderHeight(height);
                        }

            
            {
                this$1 = final__pcls1;
                height = I.this;
                super();
            }
                    });
                    try
                    {
                        sleep(10L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                    i1++;
                } while (true);
            }


            
            {
                this$0 = StickyLayout.this;
                frameCount = i;
                to = j;
                from = k;
                partation = f;
                modifyOriginalHeaderHeight = flag;
                super(final_s);
            }
        }).start();
    }
}
