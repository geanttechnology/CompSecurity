// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import sz;

public class PaintView extends View
{

    private static int BACKGROUND_COLOR = 0;
    private static final int FADE_ALPHA = 6;
    private static final int MAX_CONNECT_DISTANCE = 40;
    private static final int MAX_FADE_STEPS = 46;
    private static final int POINT_DISTANCE = 2;
    private static final int SPLAT_VECTORS = 40;
    private static final int STOKE_WIDTH = 4;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mCurPath;
    private sz mDelegate;
    private Paint mFadePaint;
    private int mFadeSteps;
    private PointF mLastPt;
    private int mOldButtonState;
    private Paint mPaint;
    private PointF mPoint0;
    private PointF mPoint1;
    private PointF mPoint2;
    private PointF mPoint3;
    private List mPtArray;
    private final Random mRandom;

    public PaintView(Context context)
    {
        super(context);
        mRandom = new Random();
        mFadeSteps = 46;
        mPtArray = new ArrayList();
        init();
    }

    public PaintView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRandom = new Random();
        mFadeSteps = 46;
        mPtArray = new ArrayList();
        init();
    }

    private void init()
    {
        setFocusable(true);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        DashPathEffect dashpatheffect = new DashPathEffect(new float[] {
            5F, 8F
        }, 1.0F);
        mPaint.setPathEffect(dashpatheffect);
        mPaint.setStrokeWidth(4F);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setColor(0xff00ffff);
        mFadePaint = new Paint();
        mFadePaint.setAntiAlias(true);
        mFadePaint.setStyle(android.graphics.Paint.Style.FILL);
        mFadePaint.setColor(-1);
        mCurPath = new Path();
        mLastPt = new PointF();
    }

    private boolean isNewOneDrawing(float f, float f1)
    {
        if (!mCurPath.isEmpty())
        {
            float f2 = mLastPt.x;
            float f3 = mLastPt.y;
            if ((float)Math.sqrt((f2 - f) * (f2 - f) + (f3 - f1) * (f3 - f1)) <= 40F)
            {
                return false;
            }
        }
        return true;
    }

    private boolean onTouchOrHoverEvent(MotionEvent motionevent, boolean flag)
    {
        if (motionevent.getPointerCount() <= 1)
        {
            int i = motionevent.getActionMasked();
            Log.v("PaintView", (new StringBuilder()).append("action: ").append(i).toString());
            if (i == 0)
            {
                paint(motionevent.getX(0), motionevent.getY(0), i);
                return true;
            }
            if (i == 2)
            {
                paint(motionevent.getX(0), motionevent.getY(0), i);
                return true;
            }
        }
        return true;
    }

    private void paint(float f, float f1, int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        mPoint0 = new PointF(-1F, -1F);
        mPoint1 = new PointF(-1F, -1F);
        mPoint2 = new PointF(-1F, -1F);
        mPoint3 = new PointF(f, f1);
        if (!isNewOneDrawing(f, f1)) goto _L4; else goto _L3
_L3:
        if (!mCurPath.isEmpty())
        {
            mCurPath.close();
            clearRender();
            mCanvas.drawPath(mCurPath, mPaint);
            invalidate();
        }
        mCurPath.moveTo(f, f1);
_L10:
        mLastPt.set(f, f1);
_L6:
        return;
_L4:
        if (hasDrawing())
        {
            mCurPath.lineTo(f, f1);
            mCanvas.drawPath(mCurPath, mPaint);
            invalidate();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        PointF pointf = new PointF(f, f1);
        pointf.x = Math.min(Math.max(0.0F, pointf.x), getWidth());
        pointf.y = Math.min(Math.max(0.0F, pointf.y), getHeight());
        mPoint0 = mPoint1;
        mPoint1 = mPoint2;
        mPoint2 = mPoint3;
        mPoint3 = pointf;
        if (Math.sqrt((mPoint2.x - mPoint1.x) * (mPoint2.x - mPoint1.x) + (mPoint2.y - mPoint1.y) * (mPoint2.y - mPoint1.y)) < 2D)
        {
            mCurPath.lineTo(mPoint2.x, mPoint2.y);
            Log.v("PaintView", (new StringBuilder()).append("PaintView Point1: ").append(mPoint1.x).append("PaintView Point2: ").append(mPoint2.y).toString());
            return;
        }
        if (mPoint1.x <= -1F) goto _L6; else goto _L5
_L5:
        double d;
        double d1;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        if (mPoint0.x > -1F)
        {
            f2 = mPoint0.x;
        } else
        {
            f2 = mPoint1.x;
        }
        if (mPoint0.y > -1F)
        {
            f3 = mPoint0.y;
        } else
        {
            f3 = mPoint1.y;
        }
        f4 = mPoint1.x;
        f5 = mPoint1.y;
        f6 = mPoint2.x;
        f7 = mPoint2.y;
        f8 = mPoint3.x;
        f9 = mPoint3.y;
        f10 = (f2 + f4) / 2.0F;
        f11 = (f3 + f5) / 2.0F;
        f12 = (f4 + f6) / 2.0F;
        f13 = (f5 + f7) / 2.0F;
        f14 = (f6 + f8) / 2.0F;
        f15 = (f7 + f9) / 2.0F;
        d = Math.sqrt((f4 - f2) * (f4 - f2) + (f5 - f3) * (f5 - f3));
        d1 = Math.sqrt((f6 - f4) * (f6 - f4) + (f7 - f5) * (f7 - f5));
        d2 = Math.sqrt((f8 - f6) * (f8 - f6) + (f9 - f7) * (f9 - f7));
        if (d + d1 == 0.0D || d1 + d2 == 0.0D) goto _L6; else goto _L7
_L7:
        d /= d + d1;
        d1 /= d2 + d1;
        d3 = (double)f10 + (double)(f12 - f10) * d;
        d2 = f11;
        d5 = (double)(f13 - f11) * d + d2;
        d4 = (double)f12 + (double)(f14 - f12) * d1;
        d2 = f13;
        d2 = (double)(f15 - f13) * d1 + d2;
        Log.v("PaintView", (new StringBuilder()).append("drawPath before xm1: ").append(d3).append("drawPath before xc2: ").append(f12).append("drawPath before xm1: ").append(d3).append("drawPath before x1: ").append(f4).append("k1: ").append(d).append("k2: ").append(d1).toString());
        d3 = (((double)f12 - d3) * 0.5D + d3 + (double)f4) - d3;
        d6 = f13;
        d5 = ((double)f5 + ((d6 - d5) * 0.5D + d5)) - d5;
        d4 = (((double)f12 - d4) * 0.5D + d4 + (double)f6) - d4;
        d6 = f13;
        d2 = ((double)f7 + ((d6 - d2) * 0.5D + d2)) - d2;
        if (d3 <= -1D || d3 > 1000000D) goto _L6; else goto _L8
_L8:
        clearRender();
        Log.v("PaintView", (new StringBuilder()).append("drawPath before ctrl1_x: ").append(d3).append("drawPath before ctrl1_y: ").append(d5).append("drawPath before ctrl2_x: ").append(d4).append("drawPath before ctrl2_y: ").append(d2).append("k1: ").append(d).append("k2: ").append(d1).toString());
        mCurPath.cubicTo((float)d3, (float)d5, (float)d4, (float)d2, mPoint2.x, mPoint2.y);
        mCanvas.drawPath(mCurPath, mPaint);
        invalidate();
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void clear()
    {
        if (mCanvas != null)
        {
            mCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            invalidate();
        }
        mCurPath.reset();
        mLastPt.set(0.0F, 0.0F);
    }

    public void clearRender()
    {
        if (mCanvas != null)
        {
            mCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        }
    }

    public RectF getDrawingBoundingBox()
    {
        if (mCurPath == null)
        {
            return null;
        } else
        {
            RectF rectf = new RectF();
            mCurPath.computeBounds(rectf, false);
            return rectf;
        }
    }

    public Bitmap getMaskBitmap()
    {
        if (!hasDrawing())
        {
            return null;
        }
        if (mCanvas != null)
        {
            mCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            mCanvas.drawPath(mCurPath, mFadePaint);
            invalidate();
        }
        return mBitmap;
    }

    public sz getPaintDelegate()
    {
        return mDelegate;
    }

    public boolean hasDrawing()
    {
        return !mCurPath.isEmpty();
    }

    protected void onDraw(Canvas canvas)
    {
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            canvas.drawBitmap(mBitmap, 0.0F, 0.0F, null);
        }
    }

    public boolean onHoverEvent(MotionEvent motionevent)
    {
        if (mDelegate != null)
        {
            mDelegate.a(motionevent);
        }
        return onTouchOrHoverEvent(motionevent, false);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmap);
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            canvas.drawBitmap(mBitmap, 0.0F, 0.0F, null);
        }
        mBitmap = bitmap;
        mCanvas = canvas;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mDelegate != null)
        {
            mDelegate.a(motionevent);
        }
        return onTouchOrHoverEvent(motionevent, true);
    }

    public void setPaintDelegate(sz sz1)
    {
        mDelegate = sz1;
    }

    static 
    {
        BACKGROUND_COLOR = Color.argb(100, 255, 255, 255);
    }
}
