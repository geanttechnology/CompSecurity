// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;
import dt;
import du;
import ew;
import hu;

public class FontTextTouchView extends FrameLayout
{

    String TAG;
    private EditState mEditState;
    private hu mListener;
    private dt mRotateDetector;
    private ScaleGestureDetector mScaleDetector;
    private SingleTouchState mSingleState;
    private PointF movePoint;
    private PointF translatePoint;

    public FontTextTouchView(Context context)
    {
        super(context);
        TAG = "FontTextTouchView";
        mSingleState = SingleTouchState.Single_default;
        mEditState = EditState.Edit_Default;
        translatePoint = new PointF();
        movePoint = new PointF();
        initGesture();
    }

    public FontTextTouchView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "FontTextTouchView";
        mSingleState = SingleTouchState.Single_default;
        mEditState = EditState.Edit_Default;
        translatePoint = new PointF();
        movePoint = new PointF();
        initGesture();
    }

    private void initGesture()
    {
        mScaleDetector = new ScaleGestureDetector(getContext(), new android.view.ScaleGestureDetector.OnScaleGestureListener() {

            final FontTextTouchView a;

            public boolean onScale(ScaleGestureDetector scalegesturedetector)
            {
                float f = scalegesturedetector.getScaleFactor();
                Log.e("SCALE", (new StringBuilder()).append("scale:").append(f).toString());
                if (a.mListener != null)
                {
                    a.mListener.b();
                    a.mListener.a(f);
                }
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
            {
                if (a.mListener != null)
                {
                    a.mListener.b();
                }
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
            {
                if (a.mListener != null)
                {
                    a.mListener.b();
                }
            }

            
            {
                a = FontTextTouchView.this;
                super();
            }
        });
        mRotateDetector = new dt(getContext(), new du() {

            final FontTextTouchView a;

            public boolean a(dt dt1)
            {
                float f = dt1.b();
                if (a.mListener != null)
                {
                    a.mListener.b();
                    a.mListener.b(f);
                }
                return true;
            }

            public boolean b(dt dt1)
            {
                if (a.mListener != null)
                {
                    a.mListener.b();
                }
                return true;
            }

            public void c(dt dt1)
            {
                if (a.mListener != null)
                {
                    a.mListener.b();
                }
            }

            
            {
                a = FontTextTouchView.this;
                super();
            }
        });
    }

    private void onTouchBegin(MotionEvent motionevent)
    {
        if (mListener != null)
        {
            mListener.b();
        }
        if (mListener != null && mListener.b(motionevent))
        {
            mEditState = EditState.Edit_Rotate;
        } else
        {
            mEditState = EditState.Edit_Tap;
        }
        translatePoint.x = motionevent.getX();
        translatePoint.y = motionevent.getY();
        movePoint.x = translatePoint.x;
        movePoint.y = translatePoint.y;
        mSingleState = SingleTouchState.Single_Move;
    }

    private void onTouchEnd(MotionEvent motionevent)
    {
        if (mListener == null)
        {
            mEditState = EditState.Edit_Default;
            mSingleState = SingleTouchState.Single_default;
            return;
        }
        mListener.b();
        if (mEditState == EditState.Edit_Tap)
        {
            mListener.a(motionevent);
        }
        mEditState = EditState.Edit_Default;
        mSingleState = SingleTouchState.Single_default;
    }

    private void onTouchMoved(MotionEvent motionevent)
    {
        PointF pointf1;
        pointf1 = new PointF(motionevent.getX(), motionevent.getY());
        if (mEditState == EditState.Edit_Tap)
        {
            if (Math.sqrt((pointf1.x - translatePoint.x) * (pointf1.x - translatePoint.x) + (pointf1.y - translatePoint.y) * (pointf1.y - translatePoint.y)) < (double)ew.a(getContext(), 3F))
            {
                return;
            }
            mEditState = EditState.Edit_Default;
        }
        if (mSingleState == SingleTouchState.Single_default || mSingleState == SingleTouchState.Single_Start)
        {
            mSingleState = SingleTouchState.Single_Move;
            translatePoint.x = motionevent.getX();
            translatePoint.y = motionevent.getY();
            movePoint.x = translatePoint.x;
            movePoint.y = translatePoint.y;
            return;
        }
        if (mSingleState != SingleTouchState.Single_Move) goto _L2; else goto _L1
_L1:
        if (mEditState == EditState.Edit_Rotate) goto _L4; else goto _L3
_L3:
        float f = pointf1.x;
        float f2 = translatePoint.x;
        float f4 = pointf1.y;
        float f6 = translatePoint.y;
        if (mListener != null)
        {
            mListener.a((int)(f - f2), (int)(f4 - f6));
        }
_L2:
        translatePoint = new PointF(motionevent.getX(), motionevent.getY());
        return;
_L4:
        double d;
        float f3;
        float f5;
        PointF pointf;
        pointf = new PointF();
        if (mListener != null)
        {
            pointf = mListener.a();
        }
        double d1 = spacing(movePoint.x, movePoint.y, pointf.x, pointf.y);
        double d3 = spacing(pointf1.x, pointf1.y, movePoint.x, movePoint.y);
        double d2 = spacing(pointf1.x, pointf1.y, pointf.x, pointf.y);
        d = d1;
        if (d1 == 0.0D)
        {
            d = 1.0D;
        }
        d1 = d2;
        if (d2 == 0.0D)
        {
            d1 = 1.0D;
        }
        d2 = d3;
        if (d3 == 0.0D)
        {
            d2 = 1.0D;
        }
        d2 = ((d * d + d1 * d1) - d2 * d2) / (2D * d * d1);
        float f1 = (float)(d1 / d);
        if (d2 > 1.0D)
        {
            d = 1.0D;
        } else
        {
            d = d2;
            if (d2 < -1D)
            {
                d = -1D;
            }
        }
        d = Math.acos(d);
        f3 = (pointf.y - movePoint.y) / (pointf.x - movePoint.x);
        f5 = movePoint.y - movePoint.x * f3;
        if (pointf1.y - pointf1.x * f3 - f5 <= 0.0F || movePoint.x <= pointf.x)
        {
            break; /* Loop/switch isn't completed */
        }
        d = -d;
_L7:
        d /= 3.1415926535897931D;
        if (mListener != null)
        {
            mListener.a((float)(d * 180D), f1);
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (pointf1.y - pointf1.x * f3 - f5 >= 0.0F || movePoint.x >= pointf.x) goto _L7; else goto _L6
_L6:
        d = -d;
          goto _L7
    }

    private float spacing(float f, float f1, float f2, float f3)
    {
        f -= f2;
        f1 -= f3;
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() == 1)
        {
            mListener.c(motionevent);
            switch (motionevent.getAction())
            {
            default:
                onTouchEnd(motionevent);
                return true;

            case 0: // '\0'
                onTouchBegin(motionevent);
                return true;

            case 2: // '\002'
                onTouchMoved(motionevent);
                return true;

            case 1: // '\001'
                onTouchEnd(motionevent);
                return true;
            }
        } else
        {
            mEditState = EditState.Edit_Default;
            mSingleState = SingleTouchState.Single_default;
            mRotateDetector.a(motionevent);
            mScaleDetector.onTouchEvent(motionevent);
            return true;
        }
    }

    public void setListener(hu hu1)
    {
        mListener = hu1;
    }


    private class SingleTouchState extends Enum
    {

        private static final SingleTouchState $VALUES[];
        public static final SingleTouchState Single_End;
        public static final SingleTouchState Single_Move;
        public static final SingleTouchState Single_Start;
        public static final SingleTouchState Single_default;

        public static SingleTouchState valueOf(String s)
        {
            return (SingleTouchState)Enum.valueOf(com/fotoable/fotoproedit/activity/font/FontTextTouchView$SingleTouchState, s);
        }

        public static SingleTouchState[] values()
        {
            return (SingleTouchState[])$VALUES.clone();
        }

        static 
        {
            Single_default = new SingleTouchState("Single_default", 0);
            Single_Start = new SingleTouchState("Single_Start", 1);
            Single_Move = new SingleTouchState("Single_Move", 2);
            Single_End = new SingleTouchState("Single_End", 3);
            $VALUES = (new SingleTouchState[] {
                Single_default, Single_Start, Single_Move, Single_End
            });
        }

        private SingleTouchState(String s, int i)
        {
            super(s, i);
        }
    }


    private class EditState extends Enum
    {

        private static final EditState $VALUES[];
        public static final EditState Edit_Default;
        public static final EditState Edit_Rotate;
        public static final EditState Edit_Tap;

        public static EditState valueOf(String s)
        {
            return (EditState)Enum.valueOf(com/fotoable/fotoproedit/activity/font/FontTextTouchView$EditState, s);
        }

        public static EditState[] values()
        {
            return (EditState[])$VALUES.clone();
        }

        static 
        {
            Edit_Default = new EditState("Edit_Default", 0);
            Edit_Rotate = new EditState("Edit_Rotate", 1);
            Edit_Tap = new EditState("Edit_Tap", 2);
            $VALUES = (new EditState[] {
                Edit_Default, Edit_Rotate, Edit_Tap
            });
        }

        private EditState(String s, int i)
        {
            super(s, i);
        }
    }

}
