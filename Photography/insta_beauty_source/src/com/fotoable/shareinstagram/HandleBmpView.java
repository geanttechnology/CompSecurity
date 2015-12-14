// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import auc;
import aud;
import aue;
import gl;

public class HandleBmpView extends ImageView
{

    boolean bHasLayout;
    boolean bIsShadow;
    private boolean isNeedRefreshBitmap;
    public float lastAngleDegree;
    public float lastScale;
    Paint mBKPaint;
    Bitmap mBitmap;
    float mBmpHeight;
    Paint mBmpPaint;
    Shader mBmpShader;
    float mBmpWidth;
    float mBorderRadius;
    Context mContext;
    float mCornerRadius;
    float mDefaultBmpScale;
    PointF mDefaultOriginF;
    private Bitmap mDrawBitmap;
    private GestureDetector mGestureDetector;
    private gl mRotateDetector;
    private ScaleGestureDetector mScaleDetector;
    Paint mShadowPaint;
    float mShadowWidth;
    float mViewHeight;
    float mViewWidth;
    public float newAngleDegree;
    public float newScale;
    public float translation_x;
    public float translation_y;

    public HandleBmpView(Context context)
    {
        super(context);
        mCornerRadius = 10F;
        mBorderRadius = 0.0F;
        bIsShadow = true;
        mDefaultBmpScale = 1.0F;
        mDefaultOriginF = new PointF(0.0F, 0.0F);
        bHasLayout = false;
        isNeedRefreshBitmap = true;
        mDrawBitmap = null;
        translation_x = 0.0F;
        translation_y = 0.0F;
        newScale = 1.0F;
        lastScale = 1.0F;
        newAngleDegree = 0.0F;
        lastAngleDegree = 0.0F;
        initView(context);
    }

    public HandleBmpView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mCornerRadius = 10F;
        mBorderRadius = 0.0F;
        bIsShadow = true;
        mDefaultBmpScale = 1.0F;
        mDefaultOriginF = new PointF(0.0F, 0.0F);
        bHasLayout = false;
        isNeedRefreshBitmap = true;
        mDrawBitmap = null;
        translation_x = 0.0F;
        translation_y = 0.0F;
        newScale = 1.0F;
        lastScale = 1.0F;
        newAngleDegree = 0.0F;
        lastAngleDegree = 0.0F;
        initView(context);
    }

    public HandleBmpView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mCornerRadius = 10F;
        mBorderRadius = 0.0F;
        bIsShadow = true;
        mDefaultBmpScale = 1.0F;
        mDefaultOriginF = new PointF(0.0F, 0.0F);
        bHasLayout = false;
        isNeedRefreshBitmap = true;
        mDrawBitmap = null;
        translation_x = 0.0F;
        translation_y = 0.0F;
        newScale = 1.0F;
        lastScale = 1.0F;
        newAngleDegree = 0.0F;
        lastAngleDegree = 0.0F;
        initView(context);
    }

    private Shader createShader(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        } else
        {
            return new BitmapShader(bitmap, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
        }
    }

    private Bitmap getDrawBitmap(int i)
    {
        float f = (float)i / mViewWidth;
        Bitmap bitmap = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        if (bHasLayout && mBitmap != null && !mBitmap.isRecycled())
        {
            Matrix matrix = new Matrix();
            matrix.postScale(mDefaultBmpScale, mDefaultBmpScale);
            matrix.postTranslate(mDefaultOriginF.x, mDefaultOriginF.y);
            matrix.postScale(f, f);
            RectF rectf = new RectF(0.0F, 0.0F, mBmpWidth, mBmpHeight);
            matrix.mapRect(rectf);
            rectf.inset(mBorderRadius * f, mBorderRadius * f);
            if (bIsShadow)
            {
                rectf.inset(mShadowWidth * f, mShadowWidth * f);
                mShadowPaint.setMaskFilter(new BlurMaskFilter(mShadowWidth * f, android.graphics.BlurMaskFilter.Blur.OUTER));
                canvas.drawRoundRect(new RectF(rectf), mCornerRadius * f, mCornerRadius * f, mShadowPaint);
            }
            mBmpShader.setLocalMatrix(matrix);
            canvas.drawRoundRect(rectf, mCornerRadius * f, f * mCornerRadius, mBmpPaint);
        }
        return bitmap;
    }

    private void initGesture()
    {
        mScaleDetector = new ScaleGestureDetector(getContext(), new auc(this));
        mRotateDetector = new gl(getContext(), new aud(this));
        mGestureDetector = new GestureDetector(getContext(), new aue(this));
    }

    private void initView(Context context)
    {
        mContext = context;
        mBmpPaint = new Paint();
        mBmpPaint.setAntiAlias(true);
        mBmpPaint.setFilterBitmap(true);
        context = mContext.getResources().getDisplayMetrics();
        mShadowPaint = new Paint();
        mShadowWidth = ((DisplayMetrics) (context)).density * 6F;
        context = new BlurMaskFilter(40F, android.graphics.BlurMaskFilter.Blur.SOLID);
        mShadowPaint.setMaskFilter(context);
        mShadowPaint.setColor(0xff000000);
        mBKPaint = new Paint(1);
        mBKPaint.setAntiAlias(true);
        mBKPaint.setStyle(android.graphics.Paint.Style.STROKE);
        initGesture();
    }

    private Path pathWithRectF(RectF rectf)
    {
        Path path = new Path();
        path.moveTo(rectf.left, rectf.top);
        path.lineTo(rectf.right, rectf.top);
        path.moveTo(rectf.right, rectf.top);
        path.lineTo(rectf.right, rectf.bottom);
        path.moveTo(rectf.right, rectf.bottom);
        path.lineTo(rectf.left, rectf.bottom);
        path.moveTo(rectf.left, rectf.bottom);
        path.lineTo(rectf.right, rectf.top);
        path.close();
        return path;
    }

    public void changeShadowMode()
    {
        boolean flag;
        if (!bIsShadow)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bIsShadow = flag;
        isNeedRefreshBitmap = true;
        invalidate();
    }

    public void clearDrawBitmap()
    {
        if (mDrawBitmap != null && !mDrawBitmap.isRecycled())
        {
            mDrawBitmap.recycle();
            mDrawBitmap = null;
        }
    }

    public void drawInSaveCanvas(Canvas canvas, int i)
    {
        float f = (float)i / mViewWidth;
        if (bHasLayout && mBitmap != null && !mBitmap.isRecycled())
        {
            Matrix matrix = new Matrix();
            matrix.postRotate(-(newAngleDegree + lastAngleDegree), i / 2, i / 2);
            matrix.postScale(lastScale * newScale, lastScale * newScale, i / 2, i / 2);
            matrix.postTranslate(-translation_x * f, f * -translation_y);
            if (mDrawBitmap != null && !mDrawBitmap.isRecycled())
            {
                mDrawBitmap.recycle();
                mDrawBitmap = getDrawBitmap(i);
            }
            if (mDrawBitmap != null && !mDrawBitmap.isRecycled())
            {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(mDrawBitmap, matrix, paint);
                mDrawBitmap.recycle();
                mDrawBitmap = null;
            }
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (bHasLayout && mBitmap != null && !mBitmap.isRecycled())
        {
            Matrix matrix = new Matrix();
            matrix.postRotate(-(newAngleDegree + lastAngleDegree), mViewWidth / 2.0F, mViewHeight / 2.0F);
            matrix.postScale(lastScale * newScale, lastScale * newScale, mViewWidth / 2.0F, mViewHeight / 2.0F);
            matrix.postTranslate(-translation_x, -translation_y);
            if (mDrawBitmap == null || mDrawBitmap.isRecycled() || isNeedRefreshBitmap)
            {
                mDrawBitmap = getDrawBitmap((int)mViewWidth);
            }
            if (mDrawBitmap != null && !mDrawBitmap.isRecycled())
            {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(mDrawBitmap, matrix, paint);
            }
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mViewHeight = l - j;
        mViewWidth = k - i;
        if (mViewHeight != 0.0F && mViewHeight != 0.0F)
        {
            bHasLayout = true;
            float f = mViewWidth / mViewHeight;
            if (mBitmap != null)
            {
                if (mBmpWidth / mBmpHeight >= f)
                {
                    mDefaultBmpScale = mViewWidth / mBmpWidth;
                    mDefaultOriginF.x = 0.0F;
                    mDefaultOriginF.y = (mViewHeight - mBmpHeight * mDefaultBmpScale) / 2.0F;
                    return;
                } else
                {
                    mDefaultBmpScale = mViewHeight / mBmpHeight;
                    mDefaultOriginF.y = 0.0F;
                    mDefaultOriginF.x = (mViewWidth - mBmpWidth * mDefaultBmpScale) / 2.0F;
                    return;
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        mGestureDetector.onTouchEvent(motionevent);
        mRotateDetector.a(motionevent);
        mScaleDetector.onTouchEvent(motionevent);
        return true;
    }

    public void setBorderRadius(float f)
    {
        mBorderRadius = f;
        isNeedRefreshBitmap = true;
        invalidate();
    }

    public void setCornerRadius(float f)
    {
        mCornerRadius = f;
        isNeedRefreshBitmap = true;
        invalidate();
    }

    public void setReDraw()
    {
        isNeedRefreshBitmap = true;
        invalidate();
    }

    public void setSrcBitmap(Bitmap bitmap)
    {
        mBitmap = bitmap;
        mBmpHeight = bitmap.getHeight();
        mBmpWidth = bitmap.getWidth();
        mBmpShader = createShader(bitmap);
        mBmpPaint.setShader(mBmpShader);
    }


/*
    public static boolean access$002(HandleBmpView handlebmpview, boolean flag)
    {
        handlebmpview.isNeedRefreshBitmap = flag;
        return flag;
    }

*/
}
