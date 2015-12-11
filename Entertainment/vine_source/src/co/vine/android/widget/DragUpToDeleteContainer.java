// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import co.vine.android.animation.SmoothAnimator;

public class DragUpToDeleteContainer extends RelativeLayout
{
    public static interface DragUpListener
    {

        public abstract boolean prepareForPickup();

        public abstract void viewDestroyFinished();

        public abstract boolean viewDropped(int i);

        public abstract void viewLanded();

        public abstract boolean viewMoved(int i);

        public abstract void viewPickedUp();
    }

    private class DragViewDestroyAnimator extends SmoothAnimator
    {

        private int mDeltaY;
        private int mStartY;
        final DragUpToDeleteContainer this$0;

        public void onStart()
        {
            mStartY = mDragViewY;
            mDeltaY = mDragViewY + mDragViewHeight;
            mDestroying = true;
        }

        public void onStop()
        {
            mDragViewAlpha = 0.0F;
            mDestroying = false;
            destroyDragView();
            if (mDragUpListener != null)
            {
                mDragUpListener.viewDestroyFinished();
            }
            invalidate();
        }

        public void onUpdate(float f, float f1)
        {
            mDragViewY = (int)((float)mStartY - (float)mDeltaY * f1);
            invalidate();
        }

        public DragViewDestroyAnimator(float f, int i)
        {
            this$0 = DragUpToDeleteContainer.this;
            super(DragUpToDeleteContainer.this, f, i);
        }
    }

    private class DropAnimator extends SmoothAnimator
    {

        private float mDeltaX;
        private float mDeltaY;
        private int mTargetX;
        private int mTargetY;
        final DragUpToDeleteContainer this$0;

        public void onStart()
        {
            mDropping = true;
            if (mDragView != null)
            {
                mTargetY = (int)(mDownY - mYOffsetFromTouch);
            }
            mTargetX = mDragViewX;
            mDeltaX = mDragViewX - mTargetX;
            mDeltaY = mDragViewY - mTargetY;
        }

        public void onStop()
        {
            if (mDragUpListener != null)
            {
                mDragUpListener.viewLanded();
            }
            destroyDragView();
            invalidate();
        }

        public void onUpdate(float f, float f1)
        {
            f = 1.0F - f1;
            mDragViewX = mTargetX + (int)(mDeltaX * f);
            mDragViewY = mTargetY + (int)(mDeltaY * f);
            invalidate();
        }

        public DropAnimator(float f, int i)
        {
            this$0 = DragUpToDeleteContainer.this;
            super(DragUpToDeleteContainer.this, f, i);
        }
    }


    private static final int ALPHA_AT_TOP = 77;
    private static final int DESTROY_TIME = 350;
    private static final int DROP_TIME = 150;
    private static final float SMOOTHNESS = 0.05F;
    private float mCurY;
    private boolean mDestroying;
    private float mDownX;
    private float mDownY;
    private Bitmap mDragBitmap;
    private DragUpListener mDragUpListener;
    private ImageView mDragView;
    private float mDragViewAlpha;
    private final DragViewDestroyAnimator mDragViewDestroyAnimator;
    private final DropAnimator mDragViewDropAnimator;
    private int mDragViewHeight;
    private int mDragViewWidth;
    private int mDragViewX;
    private int mDragViewY;
    private boolean mDropping;
    private boolean mLockAlpha;
    private final int mTouchSlop;
    private View mViewToPickUp;
    private float mYOffsetFromTouch;

    public DragUpToDeleteContainer(Context context)
    {
        this(context, null);
    }

    public DragUpToDeleteContainer(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DragUpToDeleteContainer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mLockAlpha = false;
        mDragViewDestroyAnimator = new DragViewDestroyAnimator(0.05F, 350);
        mDragViewDropAnimator = new DropAnimator(0.05F, 150);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void createDragView()
    {
        if (mViewToPickUp == null)
        {
            return;
        }
        mViewToPickUp.setDrawingCacheQuality(0x100000);
        mViewToPickUp.setDrawingCacheEnabled(true);
        mDragBitmap = mViewToPickUp.getDrawingCache();
        if (mDragView == null)
        {
            mDragView = new ImageView(getContext());
        }
        mDragViewAlpha = 255F;
        mDragView.setImageBitmap(mDragBitmap);
        mDragView.setLayoutParams(new android.view.ViewGroup.LayoutParams(mViewToPickUp.getWidth(), mViewToPickUp.getHeight()));
        int ai[] = new int[2];
        int ai1[] = new int[2];
        getLocationInWindow(ai);
        mViewToPickUp.getLocationInWindow(ai1);
        mYOffsetFromTouch = (mDownY - (float)ai1[1]) + (float)ai[1];
        mDragViewWidth = mViewToPickUp.getWidth();
        mDragViewHeight = mViewToPickUp.getHeight();
        mDragViewY = (int)(mCurY - mYOffsetFromTouch);
    }

    private void destroyDragView()
    {
        if (mDragView != null)
        {
            mDragView.setImageDrawable(null);
            mDragBitmap = null;
            mDragView = null;
        }
    }

    public void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mDragView != null)
        {
            if (!mDestroying && !mLockAlpha)
            {
                int i = (int)(mDownY - mYOffsetFromTouch);
                mDragViewAlpha = ((1.0F * (float)mDragViewY) / (float)i) * 178F + 77F;
            }
            if (mDragViewAlpha < 0.0F)
            {
                mDragViewAlpha = 0.0F;
            }
            canvas.save();
            canvas.translate(mDragViewX, mDragViewY);
            canvas.clipRect(0, 0, mDragViewWidth, mDragViewHeight);
            canvas.saveLayerAlpha(0.0F, 0.0F, mDragViewWidth, mDragViewHeight, (int)mDragViewAlpha, 31);
            mDragView.layout(0, 0, mDragViewWidth, mDragViewHeight);
            mDragView.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 34
    //                   1 32
    //                   2 52;
           goto _L1 _L2 _L1 _L3
_L1:
        return false;
_L2:
        mDownY = motionevent.getY();
        mDownX = motionevent.getX();
        return false;
_L3:
        if (mDownY - motionevent.getY() >= (float)mTouchSlop && Math.abs(motionevent.getX() - mDownX) < (float)mTouchSlop)
        {
            mCurY = motionevent.getY();
            boolean flag = true;
            if (mDragUpListener != null)
            {
                flag = mDragUpListener.prepareForPickup();
            }
            if (flag)
            {
                createDragView();
                if (mDragUpListener != null)
                {
                    mDragUpListener.viewPickedUp();
                }
                invalidate();
            }
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 2: // '\002'
            mCurY = motionevent.getY();
            mDragViewY = (int)(mCurY - mYOffsetFromTouch);
            int i = (int)(mDownY - mYOffsetFromTouch);
            if (mDragViewY <= i)
            {
                i = mDragViewY;
            }
            mDragViewY = i;
            if (mDragUpListener != null)
            {
                mLockAlpha = mDragUpListener.viewMoved(mDragViewY);
            }
            invalidate();
            return true;

        case 1: // '\001'
            flag = false;
            break;
        }
        if (mDragUpListener != null)
        {
            flag = mDragUpListener.viewDropped(mDragViewY);
        }
        if (flag)
        {
            mDragViewDestroyAnimator.start();
        } else
        {
            mDragViewDropAnimator.start();
        }
        invalidate();
        return true;
    }

    public void setInteractionListner(DragUpListener draguplistener)
    {
        mDragUpListener = draguplistener;
    }

    public void setView(View view, int i)
    {
        mViewToPickUp = view;
        mDragViewX = i;
    }



/*
    static int access$002(DragUpToDeleteContainer draguptodeletecontainer, int i)
    {
        draguptodeletecontainer.mDragViewY = i;
        return i;
    }

*/




/*
    static int access$1002(DragUpToDeleteContainer draguptodeletecontainer, int i)
    {
        draguptodeletecontainer.mDragViewX = i;
        return i;
    }

*/


/*
    static boolean access$202(DragUpToDeleteContainer draguptodeletecontainer, boolean flag)
    {
        draguptodeletecontainer.mDestroying = flag;
        return flag;
    }

*/


/*
    static float access$302(DragUpToDeleteContainer draguptodeletecontainer, float f)
    {
        draguptodeletecontainer.mDragViewAlpha = f;
        return f;
    }

*/




/*
    static boolean access$602(DragUpToDeleteContainer draguptodeletecontainer, boolean flag)
    {
        draguptodeletecontainer.mDropping = flag;
        return flag;
    }

*/



}
