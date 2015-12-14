// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.pipcamera.application.PIPCameraApplication;
import ew;

public class TTieZhiInfoView extends ImageView
{

    public static float KRotateAdjustValue = 1.0F;
    public static int kDefaultEditBtnWidth = 40;
    public static float kMinScale = 0.5F;
    private float HWScale;
    PointF centerF;
    Drawable deleteDrawable;
    int flip;
    Drawable flipDrawable;
    float lastAngle;
    PointF lastPointF;
    float lastScale;
    Bitmap mBitmap;
    private float mImg2ViewScale;
    private boolean mIsSelected;
    private Paint mPaint;
    private float mViewSizeScale;
    float newAngle;
    PointF newPointF;
    float newScale;
    TTieZhiInfo resInfo;
    Drawable rotateDrawable;

    public TTieZhiInfoView(Context context)
    {
        super(context);
        HWScale = 1.0F;
        mViewSizeScale = 1.0F;
        centerF = new PointF();
        mIsSelected = false;
        newPointF = new PointF(0.0F, 0.0F);
        lastPointF = new PointF(0.0F, 0.0F);
        newScale = 1.0F;
        lastScale = 1.0F;
        newAngle = 0.0F;
        lastAngle = 0.0F;
        flip = 1;
        deleteDrawable = null;
        rotateDrawable = null;
        flipDrawable = null;
        mImg2ViewScale = 1.0F;
        init();
    }

    public TTieZhiInfoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        HWScale = 1.0F;
        mViewSizeScale = 1.0F;
        centerF = new PointF();
        mIsSelected = false;
        newPointF = new PointF(0.0F, 0.0F);
        lastPointF = new PointF(0.0F, 0.0F);
        newScale = 1.0F;
        lastScale = 1.0F;
        newAngle = 0.0F;
        lastAngle = 0.0F;
        flip = 1;
        deleteDrawable = null;
        rotateDrawable = null;
        flipDrawable = null;
        mImg2ViewScale = 1.0F;
        init();
    }

    public TTieZhiInfoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        HWScale = 1.0F;
        mViewSizeScale = 1.0F;
        centerF = new PointF();
        mIsSelected = false;
        newPointF = new PointF(0.0F, 0.0F);
        lastPointF = new PointF(0.0F, 0.0F);
        newScale = 1.0F;
        lastScale = 1.0F;
        newAngle = 0.0F;
        lastAngle = 0.0F;
        flip = 1;
        deleteDrawable = null;
        rotateDrawable = null;
        flipDrawable = null;
        mImg2ViewScale = 1.0F;
        init();
    }

    private float getDefaultR()
    {
        if (HWScale > 1.0F)
        {
            return (float)((double)(((float)TTieZhiInfo.kDefaultTZWidth * ew.c(getContext())) / 2.0F) * Math.sqrt(1.0F / (HWScale * HWScale) + 1.0F));
        } else
        {
            return (float)((double)(((float)TTieZhiInfo.kDefaultTZWidth * ew.c(getContext())) / 2.0F) * Math.sqrt(HWScale * HWScale + 1.0F));
        }
    }

    private float getMinScale()
    {
        float f = getCurScale();
        if (getCurScale() * HWScale < kMinScale)
        {
            f = kMinScale / HWScale;
        }
        return f;
    }

    private float getViewDefaultHeight()
    {
        float f = (float)TTieZhiInfo.kDefaultTZWidth * HWScale;
        if (HWScale > 1.0F)
        {
            f = TTieZhiInfo.kDefaultTZWidth;
        }
        return f * ew.c(getContext());
    }

    private float getViewDefaultWidth()
    {
        float f = TTieZhiInfo.kDefaultTZWidth;
        if (HWScale > 1.0F)
        {
            f = (float)TTieZhiInfo.kDefaultTZWidth / HWScale;
        }
        return f * ew.c(getContext());
    }

    private void init()
    {
        Context context = PIPCameraApplication.b().c();
        deleteDrawable = context.getResources().getDrawable(0x7f02006d);
        rotateDrawable = context.getResources().getDrawable(0x7f0200a0);
        flipDrawable = context.getResources().getDrawable(0x7f020079);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.argb(255, 255, 255, 255));
        mPaint.setStrokeWidth(4F);
        mPaint.setFilterBitmap(true);
    }

    public void drawInCanvas(Canvas canvas, float f, Paint paint)
    {
        float f1 = mBitmap.getWidth();
        float f2 = mBitmap.getHeight();
        mImg2ViewScale = getViewDefaultWidth() / f1;
        Matrix matrix = new Matrix();
        matrix.postScale((float)flip * mImg2ViewScale * getCurScale() * f, mImg2ViewScale * getCurScale() * f, f1 / 2.0F, f2 / 2.0F);
        matrix.postRotate((float)((double)((lastAngle - newAngle) * 180F) / 3.1415926535897931D), f1 / 2.0F, f2 / 2.0F);
        matrix.postTranslate((lastPointF.x + newPointF.x + centerF.x) * f - f1 / 2.0F, (lastPointF.y + newPointF.y + centerF.y) * f - f2 / 2.0F);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(mBitmap, matrix, paint);
    }

    public void flipBitmap()
    {
        flip = flip * -1;
        invalidate();
    }

    public RectF frameRect()
    {
        RectF rectf = new RectF();
        float f1 = TTieZhiInfo.kDefaultTZWidth;
        float f = (float)TTieZhiInfo.kDefaultTZWidth * HWScale;
        if (HWScale > 1.0F)
        {
            f1 = (float)TTieZhiInfo.kDefaultTZWidth / HWScale;
            f = TTieZhiInfo.kDefaultTZWidth;
        }
        rectf.left = centerF.x - (ew.c(getContext()) * f1) / 2.0F;
        float f2 = centerF.x;
        rectf.right = (f1 * ew.c(getContext())) / 2.0F + f2;
        rectf.top = centerF.y - (ew.c(getContext()) * f) / 2.0F;
        f1 = centerF.y;
        rectf.bottom = (f * ew.c(getContext())) / 2.0F + f1;
        return rectf;
    }

    public PointF getCenterPointF()
    {
        return new PointF(centerF.x + lastPointF.x + newPointF.x, centerF.y + lastPointF.y + newPointF.y);
    }

    public float getContaintSize()
    {
        float f = (float)TTieZhiInfo.kDefaultTZWidth * ew.c(getContext());
        if (HWScale > 1.0F)
        {
            return (f * f * getMinScale()) / HWScale;
        } else
        {
            return f * f * getMinScale() * HWScale;
        }
    }

    public float getCurScale()
    {
        return mViewSizeScale * lastScale * newScale;
    }

    public float getDefaultLBAngle()
    {
        return (float)(Math.atan(HWScale) - 3.1415926535897931D);
    }

    public float getDefaultLTAngle()
    {
        return (float)(3.1415926535897931D - Math.atan(HWScale));
    }

    public float getDefaultRBAngle()
    {
        return (float)(-Math.atan(HWScale));
    }

    public float getDefaultRTAngle()
    {
        return (float)Math.atan(HWScale);
    }

    public Rect getEditRectByCenterF(PointF pointf)
    {
        Rect rect = new Rect();
        float f = (float)kDefaultEditBtnWidth * ew.c(getContext());
        rect.left = (int)(pointf.x - f / 2.0F);
        rect.right = (int)(pointf.x + f / 2.0F);
        rect.top = (int)(pointf.y - f / 2.0F);
        float f1 = pointf.y;
        rect.bottom = (int)(f / 2.0F + f1);
        return rect;
    }

    public TTieZhiInfo getInfo()
    {
        return resInfo;
    }

    public PointF getLBPointF()
    {
        float f = getDefaultR();
        float f1 = centerF.x;
        float f2 = centerF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)f1 + (double)f * Math.cos(getDefaultLBAngle()));
        pointf.y = (float)((double)f2 - (double)f * Math.sin(getDefaultLBAngle()));
        return pointf;
    }

    public PointF getLBRealPointF()
    {
        float f = getDefaultR() * getMinScale();
        float f1 = centerF.x;
        float f2 = lastPointF.x;
        float f3 = newPointF.x;
        float f4 = centerF.y;
        float f5 = lastPointF.y;
        float f6 = newPointF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)(f1 + f2 + f3) + (double)f * Math.cos(getDefaultLBAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        pointf.y = (float)((double)(f4 + f5 + f6) - (double)f * Math.sin(getDefaultLBAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        return pointf;
    }

    public PointF getLTPointF()
    {
        float f = getDefaultR();
        float f1 = centerF.x;
        float f2 = centerF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)f1 + (double)f * Math.cos(getDefaultLTAngle()));
        pointf.y = (float)((double)f2 - (double)f * Math.sin(getDefaultLTAngle()));
        return pointf;
    }

    public PointF getLTRealPointF()
    {
        float f = getDefaultR() * getMinScale();
        float f1 = centerF.x;
        float f2 = lastPointF.x;
        float f3 = newPointF.x;
        float f4 = centerF.y;
        float f5 = lastPointF.y;
        float f6 = newPointF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)(f1 + f2 + f3) + (double)f * Math.cos(getDefaultLTAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        pointf.y = (float)((double)(f4 + f5 + f6) - (double)f * Math.sin(getDefaultLTAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        return pointf;
    }

    public PointF getRBPointF()
    {
        float f = getDefaultR();
        float f1 = centerF.x;
        float f2 = centerF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)f1 + (double)f * Math.cos(getDefaultRBAngle()));
        pointf.y = (float)((double)f2 - (double)f * Math.sin(getDefaultRBAngle()));
        return pointf;
    }

    public PointF getRBRealPointF()
    {
        float f = getDefaultR() * getMinScale();
        float f1 = centerF.x;
        float f2 = lastPointF.x;
        float f3 = newPointF.x;
        float f4 = centerF.y;
        float f5 = lastPointF.y;
        float f6 = newPointF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)(f1 + f2 + f3) + (double)f * Math.cos(getDefaultRBAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        pointf.y = (float)((double)(f4 + f5 + f6) - (double)f * Math.sin(getDefaultRBAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        return pointf;
    }

    public PointF getRTPointF()
    {
        float f = getDefaultR();
        float f1 = centerF.x;
        float f2 = centerF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)f1 + (double)f * Math.cos(getDefaultRTAngle()));
        pointf.y = (float)((double)f2 - (double)f * Math.sin(getDefaultRTAngle()));
        return pointf;
    }

    public PointF getRTRealPointF()
    {
        float f = getDefaultR() * getMinScale();
        float f1 = centerF.x;
        float f2 = lastPointF.x;
        float f3 = newPointF.x;
        float f4 = centerF.y;
        float f5 = lastPointF.y;
        float f6 = newPointF.y;
        PointF pointf = new PointF();
        pointf.x = (float)((double)(f1 + f2 + f3) + (double)f * Math.cos(getDefaultRTAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        pointf.y = (float)((double)(f4 + f5 + f6) - (double)f * Math.sin(getDefaultRTAngle() - (lastAngle - newAngle) / KRotateAdjustValue));
        return pointf;
    }

    public float getViewHeight()
    {
        return getViewDefaultHeight() * getCurScale();
    }

    public float getViewWidth()
    {
        return getViewDefaultWidth() * getCurScale();
    }

    public boolean isDeleteButtonClicked(int i, int j)
    {
        Rect rect = deleteDrawable.getBounds();
        rect.inset(rect.width() / 4, rect.width() / 4);
        return rect.contains(i, j);
    }

    public boolean isFlipButtonClicked(int i, int j)
    {
        Rect rect = flipDrawable.getBounds();
        rect.inset(rect.width() / 4, rect.width() / 4);
        return rect.contains(i, j);
    }

    public boolean isRotateButtonClicked(int i, int j)
    {
        Rect rect = rotateDrawable.getBounds();
        rect.inset(rect.width() / 4, rect.width() / 4);
        return rect.contains(i, j);
    }

    public boolean isViewContains(int i, int j)
    {
        Path path = new Path();
        path.moveTo(getLTRealPointF().x, getLTRealPointF().y);
        path.lineTo(getRTRealPointF().x, getRTRealPointF().y);
        path.lineTo(getRBRealPointF().x, getRBRealPointF().y);
        path.lineTo(getLBRealPointF().x, getLBRealPointF().y);
        path.close();
        RectF rectf = new RectF();
        path.computeBounds(rectf, true);
        Region region = new Region();
        region.setPath(path, new Region((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom));
        return region.contains(i, j);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f = mBitmap.getWidth();
        float f1 = mBitmap.getHeight();
        mImg2ViewScale = getViewDefaultWidth() / f;
        Matrix matrix = new Matrix();
        matrix.postScale((float)flip * mImg2ViewScale * getCurScale(), mImg2ViewScale * getCurScale(), f / 2.0F, f1 / 2.0F);
        matrix.postRotate((float)((double)((lastAngle - newAngle) * 180F) / 3.1415926535897931D), f / 2.0F, f1 / 2.0F);
        matrix.postTranslate((lastPointF.x + newPointF.x + centerF.x) - f / 2.0F, (lastPointF.y + newPointF.y + centerF.y) - f1 / 2.0F);
        canvas.drawBitmap(mBitmap, matrix, mPaint);
    }

    public void setCenterPoint(PointF pointf)
    {
        centerF.x = pointf.x;
        centerF.y = pointf.y;
        Log.e("center text", (new StringBuilder()).append("center:").append(centerF.x).append(",").append(centerF.y).toString());
    }

    public void setInfo(TTieZhiInfo ttiezhiinfo, boolean flag)
    {
        resInfo = ttiezhiinfo;
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            mBitmap.recycle();
        }
        mBitmap = ttiezhiinfo.getSrcImage();
        HWScale = (float)mBitmap.getHeight() / (float)mBitmap.getWidth();
        if (HWScale > 1.0F)
        {
            mViewSizeScale = (float)mBitmap.getHeight() / TTieZhiInfo.kDefaultSrcImageWidth;
        } else
        {
            mViewSizeScale = (float)mBitmap.getWidth() / TTieZhiInfo.kDefaultSrcImageWidth;
        }
        if (flag)
        {
            invalidate();
        }
    }

    public void setNewRotate(float f)
    {
        newAngle = f;
        Log.e("new angle", (new StringBuilder()).append("new angle ").append(f).toString());
        invalidate();
    }

    public void setNewScale(float f)
    {
        newScale = f;
        invalidate();
    }

    public void setNewScaleAndRotate(float f, float f1)
    {
        newScale = f;
        newAngle = f1;
        invalidate();
    }

    public void setNewTranslate(PointF pointf)
    {
        newPointF.x = pointf.x;
        newPointF.y = pointf.y;
        invalidate();
    }

    public void setSelected(boolean flag)
    {
        mIsSelected = flag;
    }

    public void storeTransform()
    {
        PointF pointf = lastPointF;
        pointf.x = pointf.x + newPointF.x;
        pointf = lastPointF;
        pointf.y = pointf.y + newPointF.y;
        newPointF.x = 0.0F;
        newPointF.y = 0.0F;
        lastScale = lastScale * newScale;
        newScale = 1.0F;
        lastAngle = lastAngle - newAngle;
        newAngle = 0.0F;
    }

}
