// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import adi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import aqe;
import com.instabeauty.application.InstaBeautyApplication;
import jx;
import jy;
import jz;
import yp;

public class NewTouchImageView extends ImageView
{

    static final int CLICK;
    static final int DRAG = 1;
    static final int NONE = 0;
    static final int ZOOM = 2;
    private double distanceLas;
    private double distancePre;
    PointF last;
    Paint mPaint;
    ScaleGestureDetector mScaleDetector;
    public Matrix matrix;
    public float maxScale;
    float minScale;
    int mode;
    int oldMeasuredHeight;
    int oldMeasuredWidth;
    public float origHeight;
    public float origWidth;
    public float saveScale;
    PointF start;
    public int viewHeight;
    public int viewWidth;

    public NewTouchImageView(Context context)
    {
        super(context);
        mPaint = new Paint();
        mode = 0;
        last = new PointF();
        start = new PointF();
        minScale = 1.0F;
        maxScale = 6F;
        saveScale = 1.0F;
        distancePre = 0.0D;
        distanceLas = 0.0D;
        sharedConstructing(context);
    }

    public NewTouchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mPaint = new Paint();
        mode = 0;
        last = new PointF();
        start = new PointF();
        minScale = 1.0F;
        maxScale = 6F;
        saveScale = 1.0F;
        distancePre = 0.0D;
        distanceLas = 0.0D;
        sharedConstructing(context);
    }

    private PointF getCurRectSpace()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        RectF rectf = getDisplayRect(matrix);
        float f = rectf.bottom - rectf.top;
        float f1 = rectf.right - rectf.left;
        if (f1 < (float)viewWidth)
        {
            pointf.x = ((float)viewWidth - f1) / 2.0F;
        }
        if (f < (float)viewHeight)
        {
            pointf.y = ((float)viewHeight - f) / 2.0F;
        }
        return pointf;
    }

    private PointF getOutEdgePOint()
    {
        boolean flag3 = true;
        PointF pointf = getCurRectSpace();
        RectF rectf = getDisplayRect(getImageMatrix());
        float f;
        float f1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (rectf.left > pointf.x)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (rectf.top > pointf.y)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (rectf.bottom < (float)viewHeight - pointf.y)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (rectf.right >= (float)viewWidth - pointf.x)
        {
            flag3 = false;
        }
        if (flag)
        {
            f = rectf.left - getCurRectSpace().x;
        } else
        {
            f = 0.0F;
        }
        if (flag3)
        {
            f1 = (rectf.right - (float)viewWidth) + getCurRectSpace().x;
        } else
        {
            f1 = f;
        }
        if (flag2)
        {
            f = (rectf.bottom - (float)viewHeight) + getCurRectSpace().y;
        } else
        {
            f = 0.0F;
        }
        if (flag1)
        {
            f = rectf.top - getCurRectSpace().y;
        }
        return new PointF(f1, f);
    }

    private void setOriginState(float f)
    {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0)
        {
            return;
        } else
        {
            int i = drawable.getIntrinsicWidth();
            int j = drawable.getIntrinsicHeight();
            matrix.reset();
            matrix.postScale(f, f);
            float f3 = viewHeight;
            float f4 = j;
            float f1 = viewWidth;
            float f2 = i;
            f3 = (f3 - f4 * f) / 2.0F;
            f = (f1 - f2 * f) / 2.0F;
            matrix.postTranslate(f, f3);
            origWidth = (float)viewWidth - f * 2.0F;
            origHeight = (float)viewHeight - f3 * 2.0F;
            setImageMatrix(matrix);
            invalidate();
            return;
        }
    }

    private void sharedConstructing(Context context)
    {
        super.setClickable(true);
        mScaleDetector = new ScaleGestureDetector(context, new jy(this, null));
        matrix = new Matrix();
        setImageMatrix(matrix);
        setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        mPaint.setAntiAlias(true);
        mPaint.setColor(-1);
        mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public float getCurImageScale()
    {
        float af[] = new float[9];
        matrix.getValues(af);
        Log.e("NewTouchImageView", (new StringBuilder()).append("curmatrixscale:").append(af[0]).toString());
        return af[0];
    }

    public RectF getDisplayRect(Matrix matrix1)
    {
        RectF rectf = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            rectf.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix1.mapRect(rectf);
            return rectf;
        } else
        {
            return null;
        }
    }

    public aqe getDisplaySize()
    {
        RectF rectf = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            rectf.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectf);
            return new aqe((int)rectf.width(), (int)rectf.height());
        } else
        {
            return new aqe(0, 0);
        }
    }

    public adi getImagePt(Point point)
    {
        if (getDrawable() != null)
        {
            Object obj = ((BitmapDrawable)getDrawable()).getBitmap();
            int i = ((Bitmap) (obj)).getWidth();
            int j = ((Bitmap) (obj)).getHeight();
            obj = new RectF(0.0F, 0.0F, i, j);
            getImageMatrix().mapRect(((RectF) (obj)));
            point = new PointF((float)point.x - ((RectF) (obj)).left, (float)point.y - ((RectF) (obj)).top);
            float f = (float)i / ((RectF) (obj)).width();
            obj = new adi();
            ((adi) (obj)).a(((PointF) (point)).x * f);
            ((adi) (obj)).b(f * ((PointF) (point)).y);
            return ((adi) (obj));
        } else
        {
            return new adi();
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        viewWidth = getWidth();
        viewHeight = getHeight();
        if (oldMeasuredHeight == viewWidth && oldMeasuredHeight == viewHeight || viewWidth == 0 || viewHeight == 0)
        {
            return;
        } else
        {
            oldMeasuredHeight = viewHeight;
            oldMeasuredWidth = viewWidth;
            return;
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
    }

    public void resetSaveScale()
    {
        saveScale = 1.0F;
    }

    public void setBrushSize(float f)
    {
        if (mPaint == null)
        {
            return;
        } else
        {
            mPaint.setStrokeWidth(f);
            return;
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        viewWidth = getWidth();
        viewHeight = getHeight();
        if ((oldMeasuredHeight != viewWidth || oldMeasuredHeight != viewHeight) && viewWidth != 0 && viewHeight != 0)
        {
            oldMeasuredHeight = viewHeight;
            oldMeasuredWidth = viewWidth;
            if (saveScale == 1.0F)
            {
                bitmap = getDrawable();
                if (bitmap != null && bitmap.getIntrinsicWidth() != 0 && bitmap.getIntrinsicHeight() != 0)
                {
                    float f = Math.min((float)viewWidth / (float)getDrawable().getIntrinsicWidth(), (float)viewHeight / (float)getDrawable().getIntrinsicHeight());
                    minScale = f;
                    setOriginState(f);
                    setScaleType(android.widget.ImageView.ScaleType.MATRIX);
                    return;
                }
            }
        }
    }

    public void setMaxZoom(float f)
    {
        maxScale = f;
    }

    public void setMinZoom(float f)
    {
        saveScale = saveScale * f;
        minScale = f;
        setOriginState(f);
    }

    public void setViewTouchEvent(MotionEvent motionevent)
    {
        PointF pointf;
        mScaleDetector.onTouchEvent(motionevent);
        pointf = new PointF(motionevent.getX(), motionevent.getY());
        Matrix matrix1 = new Matrix();
        getImageMatrix().invert(matrix1);
        matrix1.mapPoints(new float[] {
            motionevent.getX(), motionevent.getY()
        });
        motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 112
    //                   0 125
    //                   1 407
    //                   2 163
    //                   3 112
    //                   4 112
    //                   5 112
    //                   6 595;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
        setImageMatrix(matrix);
        invalidate();
        return;
_L2:
        last.set(pointf);
        start.set(last);
        distancePre = 0.0D;
        distanceLas = 0.0D;
        mode = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        float f = pointf.x - last.x;
        float f1 = pointf.y - last.y;
        if (mode == 1)
        {
            Log.e("move test", "event mode drag");
            if (motionevent.getPointerCount() >= 2)
            {
                if (distancePre == 0.0D)
                {
                    distancePre = Math.sqrt((motionevent.getX(0) - motionevent.getX(1)) * (motionevent.getX(0) - motionevent.getX(1)) + (motionevent.getY(0) - motionevent.getY(1)) * (motionevent.getY(0) - motionevent.getY(1)));
                    distanceLas = distancePre;
                } else
                {
                    distancePre = Math.sqrt((motionevent.getX(0) - motionevent.getX(1)) * (motionevent.getX(0) - motionevent.getX(1)) + (motionevent.getY(0) - motionevent.getY(1)) * (motionevent.getY(0) - motionevent.getY(1)));
                }
                matrix.postTranslate(f, f1);
                if (distanceLas != 0.0D)
                {
                    distancePre = distanceLas;
                }
            } else
            {
                matrix.postTranslate(f, f1);
            }
            last.set(pointf.x, pointf.y);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        mode = 0;
        if (getCurImageScale() >= minScale || getCurRectSpace().x == 0.0F && getCurRectSpace().y == 0.0F) goto _L7; else goto _L6
_L6:
        motionevent = getDisplayRect(matrix);
        post(new jx(this, getCurImageScale(), minScale, motionevent.centerX(), motionevent.centerY()));
_L8:
        int i = (int)Math.abs(pointf.x - start.x);
        int j = (int)Math.abs(pointf.y - start.y);
        if (i < CLICK && j < CLICK)
        {
            performClick();
        }
        continue; /* Loop/switch isn't completed */
_L7:
        motionevent = getOutEdgePOint();
        if (((PointF) (motionevent)).x != 0.0F || ((PointF) (motionevent)).y != 0.0F)
        {
            post(new jz(this, ((PointF) (motionevent)).x, ((PointF) (motionevent)).y));
        }
        if (true) goto _L8; else goto _L5
_L5:
        mode = 0;
        if (true) goto _L1; else goto _L9
_L9:
    }

    static 
    {
        CLICK = yp.a(InstaBeautyApplication.a, 2.0F);
    }


}
