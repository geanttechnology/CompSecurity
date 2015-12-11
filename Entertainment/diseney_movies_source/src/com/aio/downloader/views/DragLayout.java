// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.aio.downloader.views:
//            MyRelativeLayout

public class DragLayout extends FrameLayout
{
    public static interface DragListener
    {

        public abstract void onClose();

        public abstract void onDrag(float f);

        public abstract void onOpen();
    }

    public static final class Status extends Enum
    {

        public static final Status Close;
        public static final Status Drag;
        private static final Status ENUM$VALUES[];
        public static final Status Open;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/aio/downloader/views/DragLayout$Status, s);
        }

        public static Status[] values()
        {
            Status astatus[] = ENUM$VALUES;
            int i = astatus.length;
            Status astatus1[] = new Status[i];
            System.arraycopy(astatus, 0, astatus1, 0, i);
            return astatus1;
        }

        static 
        {
            Drag = new Status("Drag", 0);
            Open = new Status("Open", 1);
            Close = new Status("Close", 2);
            ENUM$VALUES = (new Status[] {
                Drag, Open, Close
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }

    class YScrollDetector extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final DragLayout this$0;

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return Math.abs(f1) <= Math.abs(f);
        }

        YScrollDetector()
        {
            this$0 = DragLayout.this;
            super();
        }
    }


    private static final float RANGE = 0.7F;
    private ViewDragHelper dragHelper;
    private android.support.v4.widget.ViewDragHelper.Callback dragHelperCallback = new android.support.v4.widget.ViewDragHelper.Callback() {

        final DragLayout this$0;

        public int clampViewPositionHorizontal(View view, int j, int k)
        {
            if (mainLeft + k < 0)
            {
                j = 0;
            } else
            if (mainLeft + k > range)
            {
                return range;
            }
            return j;
        }

        public int getViewHorizontalDragRange(View view)
        {
            return width;
        }

        public void onViewPositionChanged(View view, int j, int k, int l, int i1)
        {
            if (view == vg_main)
            {
                mainLeft = j;
            } else
            {
                DragLayout draglayout = DragLayout.this;
                draglayout.mainLeft = draglayout.mainLeft + j;
            }
            if (mainLeft >= 0) goto _L2; else goto _L1
_L1:
            mainLeft = 0;
_L4:
            dispatchDragEvent(mainLeft);
            if (view == vg_left)
            {
                vg_left.layout(0, 0, width, height);
                vg_main.layout(mainLeft, 0, mainLeft + width, height);
            }
            return;
_L2:
            if (mainLeft > range)
            {
                mainLeft = range;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onViewReleased(View view, float f, float f1)
        {
            super.onViewReleased(view, f, f1);
            if (f > 0.0F)
            {
                open();
                return;
            }
            if (f < 0.0F)
            {
                close();
                return;
            }
            if (view == vg_main && (double)mainLeft > (double)range * 0.29999999999999999D)
            {
                open();
                return;
            }
            if (view == vg_left && (double)mainLeft > (double)range * 0.69999999999999996D)
            {
                open();
                return;
            } else
            {
                close();
                return;
            }
        }

        public boolean tryCaptureView(View view, int j)
        {
            return true;
        }

            
            {
                this$0 = DragLayout.this;
                super();
            }
    };
    private DragListener dragListener;
    private GestureDetectorCompat gestureDetector;
    private int height;
    private int mainLeft;
    private int range;
    private Status status;
    private RelativeLayout vg_left;
    private MyRelativeLayout vg_main;
    private int width;

    public DragLayout(Context context)
    {
        this(context, null);
    }

    public DragLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DragLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        status = Status.Close;
        gestureDetector = new GestureDetectorCompat(context, new YScrollDetector());
        dragHelper = ViewDragHelper.create(this, dragHelperCallback);
    }

    private void dispatchDragEvent(int i)
    {
        if (dragListener != null)
        {
            float f = (float)i / (float)range;
            dragListener.onDrag(f);
            Status status1 = status;
            if (status1 != getStatus() && status == Status.Close)
            {
                vg_left.setEnabled(false);
                dragListener.onClose();
                return;
            }
            if (status1 != getStatus() && status == Status.Open)
            {
                vg_left.setEnabled(true);
                dragListener.onOpen();
                return;
            }
        }
    }

    public void close()
    {
        close(true);
    }

    public void close(boolean flag)
    {
        if (flag)
        {
            if (dragHelper.smoothSlideViewTo(vg_main, 0, 0))
            {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return;
        } else
        {
            vg_main.layout(0, 0, width, height);
            dispatchDragEvent(0);
            return;
        }
    }

    public void computeScroll()
    {
        if (dragHelper.continueSettling(true))
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public Status getStatus()
    {
        int i = vg_main.getLeft();
        if (i == 0)
        {
            status = Status.Close;
        } else
        if (i == range)
        {
            status = Status.Open;
        } else
        {
            status = Status.Drag;
        }
        return status;
    }

    public ViewGroup getVg_left()
    {
        return vg_left;
    }

    public ViewGroup getVg_main()
    {
        return vg_main;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        vg_left = (RelativeLayout)getChildAt(0);
        vg_main = (MyRelativeLayout)getChildAt(1);
        vg_main.setDragLayout(this);
        vg_left.setClickable(true);
        vg_main.setClickable(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return dragHelper.shouldInterceptTouchEvent(motionevent) && gestureDetector.onTouchEvent(motionevent);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        vg_left.layout(0, 0, width, height);
        vg_main.layout(mainLeft, 0, mainLeft + width, height);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        width = vg_left.getMeasuredWidth();
        height = vg_left.getMeasuredHeight();
        range = (int)((float)width * 0.7F);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        try
        {
            dragHelper.processTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            motionevent.printStackTrace();
        }
        return false;
    }

    public void open()
    {
        open(true);
    }

    public void open(boolean flag)
    {
        if (flag)
        {
            if (dragHelper.smoothSlideViewTo(vg_main, range, 0))
            {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return;
        } else
        {
            vg_main.layout(range, 0, range * 2, height);
            dispatchDragEvent(range);
            return;
        }
    }

    public void setDragListener(DragListener draglistener)
    {
        dragListener = draglistener;
    }








}
