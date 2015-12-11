// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import com.groupon.view.UrlImageView;
import com.groupon.view.imagezoom.easing.Cubic;
import com.groupon.view.imagezoom.graphics.FastBitmapDrawable;
import com.groupon.view.imagezoom.utils.IDisposable;

public abstract class ImageViewTouchBase extends UrlImageView
    implements IDisposable
{
    public static final class DisplayType extends Enum
    {

        private static final DisplayType $VALUES[];
        public static final DisplayType FIT_TO_SCREEN;
        public static final DisplayType NONE;

        public static DisplayType valueOf(String s)
        {
            return (DisplayType)Enum.valueOf(com/groupon/view/imagezoom/ImageViewTouchBase$DisplayType, s);
        }

        public static DisplayType[] values()
        {
            return (DisplayType[])$VALUES.clone();
        }

        static 
        {
            NONE = new DisplayType("NONE", 0);
            FIT_TO_SCREEN = new DisplayType("FIT_TO_SCREEN", 1);
            $VALUES = (new DisplayType[] {
                NONE, FIT_TO_SCREEN
            });
        }

        private DisplayType(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface OnDrawableChangeListener
    {

        public abstract void onDrawableChanged(Drawable drawable);
    }

    public static interface OnLayoutChangeListener
    {

        public abstract void onLayoutChanged(boolean flag, int i, int j, int k, int l);
    }


    protected static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "ImageViewTouchBase";
    public static final float ZOOM_INVALID = -1F;
    protected final int DEFAULT_ANIMATION_DURATION;
    private Matrix baseMatrix;
    private boolean bitmapChanged;
    private RectF bitmapRect;
    private PointF center;
    private RectF centerRect;
    private Cubic cubicEasing;
    private final Matrix displayMatrix;
    private OnDrawableChangeListener drawableChangeListener;
    private Handler handler;
    private Runnable layoutRunnable;
    private final float matrixValues[];
    private float maxZoom;
    private boolean maxZoomDefined;
    private float minZoom;
    private boolean minZoomDefined;
    private Matrix nextMatrix;
    private OnLayoutChangeListener onLayoutChangeListener;
    private DisplayType scaleType;
    private boolean scaleTypeChanged;
    protected RectF scrollRect;
    private Matrix suppMatrix;
    private int thisHeight;
    private int thisWidth;

    public ImageViewTouchBase(Context context)
    {
        super(context);
        maxZoom = -1F;
        minZoom = -1F;
        DEFAULT_ANIMATION_DURATION = 200;
        displayMatrix = new Matrix();
        matrixValues = new float[9];
        scrollRect = new RectF();
        cubicEasing = new Cubic();
        baseMatrix = new Matrix();
        suppMatrix = new Matrix();
        handler = new Handler();
        layoutRunnable = null;
        thisWidth = -1;
        thisHeight = -1;
        center = new PointF();
        scaleType = DisplayType.NONE;
        bitmapRect = new RectF();
        centerRect = new RectF();
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        maxZoom = -1F;
        minZoom = -1F;
        DEFAULT_ANIMATION_DURATION = 200;
        displayMatrix = new Matrix();
        matrixValues = new float[9];
        scrollRect = new RectF();
        cubicEasing = new Cubic();
        baseMatrix = new Matrix();
        suppMatrix = new Matrix();
        handler = new Handler();
        layoutRunnable = null;
        thisWidth = -1;
        thisHeight = -1;
        center = new PointF();
        scaleType = DisplayType.NONE;
        bitmapRect = new RectF();
        centerRect = new RectF();
        init();
    }

    protected void _setImageDrawable(Drawable drawable, Matrix matrix, float f, float f1)
    {
        if (drawable != null)
        {
            super.setImageDrawable(drawable);
        } else
        {
            baseMatrix.reset();
            super.setImageDrawable(null);
        }
        if (f != -1F && f1 != -1F)
        {
            f = Math.min(f, f1);
            f1 = Math.max(f, f1);
            minZoom = f;
            maxZoom = f1;
            minZoomDefined = true;
            maxZoomDefined = true;
            if (scaleType == DisplayType.FIT_TO_SCREEN)
            {
                if (minZoom >= 1.0F)
                {
                    minZoomDefined = false;
                    minZoom = -1F;
                }
                if (maxZoom <= 1.0F)
                {
                    maxZoomDefined = true;
                    maxZoom = -1F;
                }
            }
        } else
        {
            minZoom = -1F;
            maxZoom = -1F;
            minZoomDefined = false;
            maxZoomDefined = false;
        }
        if (matrix != null)
        {
            nextMatrix = new Matrix(matrix);
        }
        bitmapChanged = true;
        requestLayout();
    }

    protected void center(boolean flag, boolean flag1)
    {
        RectF rectf;
        if (getDrawable() != null)
        {
            if ((rectf = getCenter(suppMatrix, flag, flag1)).left != 0.0F || rectf.top != 0.0F)
            {
                postTranslate(rectf.left, rectf.top);
                return;
            }
        }
    }

    public void clear()
    {
        setImageBitmap(null);
    }

    protected float computeMaxZoom()
    {
        Drawable drawable = getDrawable();
        if (drawable == null)
        {
            return 1.0F;
        } else
        {
            return Math.max((float)drawable.getIntrinsicWidth() / (float)thisWidth, (float)drawable.getIntrinsicHeight() / (float)thisHeight) * 8F;
        }
    }

    protected float computeMinZoom()
    {
        if (getDrawable() == null)
        {
            return 1.0F;
        } else
        {
            return Math.min(1.0F, 1.0F / getScale(baseMatrix));
        }
    }

    public void dispose()
    {
        clear();
    }

    protected void fireOnDrawableChangeListener(Drawable drawable)
    {
        if (drawableChangeListener != null)
        {
            drawableChangeListener.onDrawableChanged(drawable);
        }
    }

    protected void fireOnLayoutChangeListener(int i, int j, int k, int l)
    {
        if (onLayoutChangeListener != null)
        {
            onLayoutChangeListener.onLayoutChanged(true, i, j, k, l);
        }
    }

    protected RectF getBitmapRect()
    {
        return getBitmapRect(suppMatrix);
    }

    protected RectF getBitmapRect(Matrix matrix)
    {
        Drawable drawable = getDrawable();
        if (drawable == null)
        {
            return null;
        } else
        {
            matrix = getImageViewMatrix(matrix);
            bitmapRect.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(bitmapRect);
            return bitmapRect;
        }
    }

    protected PointF getCenter()
    {
        return center;
    }

    protected RectF getCenter(Matrix matrix, boolean flag, boolean flag1)
    {
        if (getDrawable() == null)
        {
            return new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        }
        centerRect.set(0.0F, 0.0F, 0.0F, 0.0F);
        matrix = getBitmapRect(matrix);
        float f4 = matrix.height();
        float f3 = matrix.width();
        float f2 = 0.0F;
        float f1 = 0.0F;
        float f = f1;
        int i;
        if (flag1)
        {
            i = thisHeight;
            if (f4 < (float)i)
            {
                f = ((float)i - f4) / 2.0F - ((RectF) (matrix)).top;
            } else
            if (((RectF) (matrix)).top > 0.0F)
            {
                f = -((RectF) (matrix)).top;
            } else
            {
                f = f1;
                if (((RectF) (matrix)).bottom < (float)i)
                {
                    f = (float)thisHeight - ((RectF) (matrix)).bottom;
                }
            }
        }
        f1 = f2;
        if (flag)
        {
            i = thisWidth;
            if (f3 < (float)i)
            {
                f1 = ((float)i - f3) / 2.0F - ((RectF) (matrix)).left;
            } else
            if (((RectF) (matrix)).left > 0.0F)
            {
                f1 = -((RectF) (matrix)).left;
            } else
            {
                f1 = f2;
                if (((RectF) (matrix)).right < (float)i)
                {
                    f1 = (float)i - ((RectF) (matrix)).right;
                }
            }
        }
        centerRect.set(f1, f, 0.0F, 0.0F);
        return centerRect;
    }

    protected float getDefaultScale(DisplayType displaytype)
    {
        if (displaytype == DisplayType.FIT_TO_SCREEN)
        {
            return 1.0F;
        } else
        {
            return Math.min(1.0F, 1.0F / getScale(baseMatrix));
        }
    }

    public Matrix getDisplayMatrix()
    {
        return new Matrix(suppMatrix);
    }

    public DisplayType getDisplayType()
    {
        return scaleType;
    }

    public Matrix getImageViewMatrix()
    {
        return getImageViewMatrix(suppMatrix);
    }

    public Matrix getImageViewMatrix(Matrix matrix)
    {
        displayMatrix.set(baseMatrix);
        displayMatrix.postConcat(matrix);
        return displayMatrix;
    }

    public float getMaxScale()
    {
        if (maxZoom == -1F)
        {
            maxZoom = computeMaxZoom();
        }
        return maxZoom;
    }

    public float getMinScale()
    {
        if (minZoom == -1F)
        {
            minZoom = computeMinZoom();
        }
        return minZoom;
    }

    protected void getProperBaseMatrix(Drawable drawable, Matrix matrix)
    {
        float f = thisWidth;
        float f1 = thisHeight;
        float f2 = drawable.getIntrinsicWidth();
        float f3 = drawable.getIntrinsicHeight();
        matrix.reset();
        if (f2 > f || f3 > f1)
        {
            float f4 = Math.min(f / f2, f1 / f3);
            matrix.postScale(f4, f4);
            matrix.postTranslate((f - f2 * f4) / 2.0F, (f1 - f3 * f4) / 2.0F);
            return;
        } else
        {
            float f5 = Math.min(f / f2, f1 / f3);
            matrix.postScale(f5, f5);
            matrix.postTranslate((f - f2 * f5) / 2.0F, (f1 - f3 * f5) / 2.0F);
            return;
        }
    }

    public float getRotation()
    {
        return 0.0F;
    }

    public float getScale()
    {
        return getScale(suppMatrix);
    }

    protected float getScale(Matrix matrix)
    {
        return getValue(matrix, 0);
    }

    protected float getValue(Matrix matrix, int i)
    {
        matrix.getValues(matrixValues);
        return matrixValues[i];
    }

    protected void init()
    {
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    protected void onDrawableChanged(Drawable drawable)
    {
        fireOnDrawableChangeListener(drawable);
    }

    protected void onImageMatrixChanged()
    {
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        Object obj;
        int i1;
        int j1;
        super.onLayout(flag, i, j, k, l);
        i1 = 0;
        j1 = 0;
        if (flag)
        {
            i1 = thisWidth;
            j1 = thisHeight;
            thisWidth = k - i;
            thisHeight = l - j;
            i1 = thisWidth - i1;
            j1 = thisHeight - j1;
            center.x = (float)thisWidth / 2.0F;
            center.y = (float)thisHeight / 2.0F;
        }
        obj = layoutRunnable;
        if (obj != null)
        {
            layoutRunnable = null;
            ((Runnable) (obj)).run();
        }
        obj = getDrawable();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!flag && !scaleTypeChanged && !bitmapChanged) goto _L4; else goto _L3
_L3:
        float f1;
        float f2;
        float f3;
        float f4;
        f1 = 1.0F;
        getDefaultScale(scaleType);
        f2 = getScale(baseMatrix);
        f3 = getScale();
        getProperBaseMatrix(((Drawable) (obj)), baseMatrix);
        f4 = getScale(baseMatrix);
        if (!bitmapChanged && !scaleTypeChanged) goto _L6; else goto _L5
_L5:
        float f;
        if (nextMatrix != null)
        {
            suppMatrix.set(nextMatrix);
            nextMatrix = null;
            f1 = getScale();
        } else
        {
            suppMatrix.reset();
            f1 = getDefaultScale(scaleType);
        }
        setImageMatrix(getImageViewMatrix());
        f = f1;
        if (f1 != getScale())
        {
            zoomTo(f1);
            f = f1;
        }
_L9:
        if (f > getMaxScale() || f < getMinScale())
        {
            zoomTo(f);
        }
        center(true, true);
        if (bitmapChanged)
        {
            onDrawableChanged(((Drawable) (obj)));
        }
        if (flag || bitmapChanged || scaleTypeChanged)
        {
            onLayoutChanged(i, j, k, l);
        }
        if (scaleTypeChanged)
        {
            scaleTypeChanged = false;
        }
        if (bitmapChanged)
        {
            bitmapChanged = false;
        }
_L4:
        return;
_L6:
        f = f1;
        if (flag)
        {
            if (!minZoomDefined)
            {
                minZoom = -1F;
            }
            if (!maxZoomDefined)
            {
                maxZoom = -1F;
            }
            setImageMatrix(getImageViewMatrix());
            postTranslate(-i1, -j1);
            f = f1;
            if (f3 != 1.0F)
            {
                f = (f2 / f4) * f3;
            }
            zoomTo(f);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (bitmapChanged)
        {
            onDrawableChanged(((Drawable) (obj)));
        }
        if (flag || bitmapChanged || scaleTypeChanged)
        {
            onLayoutChanged(i, j, k, l);
        }
        if (bitmapChanged)
        {
            bitmapChanged = false;
        }
        if (!scaleTypeChanged) goto _L4; else goto _L7
_L7:
        scaleTypeChanged = false;
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        fireOnLayoutChangeListener(i, j, k, l);
    }

    protected void onZoom(float f)
    {
    }

    protected void onZoomAnimationCompleted(float f)
    {
    }

    protected void panBy(double d, double d1)
    {
        RectF rectf = getBitmapRect();
        scrollRect.set((float)d, (float)d1, 0.0F, 0.0F);
        updateRect(rectf, scrollRect);
        postTranslate(scrollRect.left, scrollRect.top);
        center(true, true);
    }

    protected void postScale(float f, float f1, float f2)
    {
        suppMatrix.postScale(f, f, f1, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void postTranslate(float f, float f1)
    {
        if (f != 0.0F || f1 != 0.0F)
        {
            suppMatrix.postTranslate(f, f1);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void printMatrix(Matrix matrix)
    {
        float f = getValue(matrix, 0);
        float f1 = getValue(matrix, 4);
        float f2 = getValue(matrix, 2);
        float f3 = getValue(matrix, 5);
        Log.d("ImageViewTouchBase", (new StringBuilder()).append("matrix: { x: ").append(f2).append(", y: ").append(f3).append(", scalex: ").append(f).append(", scaley: ").append(f1).append(" }").toString());
    }

    public void scrollBy(float f, float f1)
    {
        panBy(f, f1);
    }

    protected void scrollBy(float f, float f1, final double durationMs)
    {
        final double dx = f;
        final double dy = f1;
        final long startTime = System.currentTimeMillis();
        handler.post(new Runnable() {

            double old_x;
            double old_y;
            final ImageViewTouchBase this$0;
            final double val$durationMs;
            final double val$dx;
            final double val$dy;
            final long val$startTime;

            public void run()
            {
                long l = System.currentTimeMillis();
                double d = Math.min(durationMs, l - startTime);
                double d1 = cubicEasing.easeOut(d, 0.0D, dx, durationMs);
                double d2 = cubicEasing.easeOut(d, 0.0D, dy, durationMs);
                panBy(d1 - old_x, d2 - old_y);
                old_x = d1;
                old_y = d2;
                if (d < durationMs)
                {
                    handler.post(this);
                } else
                {
                    RectF rectf = getCenter(suppMatrix, true, true);
                    if (rectf.left != 0.0F || rectf.top != 0.0F)
                    {
                        scrollBy(rectf.left, rectf.top);
                        return;
                    }
                }
            }

            
            {
                this$0 = ImageViewTouchBase.this;
                durationMs = d;
                startTime = l;
                dx = d1;
                dy = d2;
                super();
                old_x = 0.0D;
                old_y = 0.0D;
            }
        });
    }

    public void setDisplayType(DisplayType displaytype)
    {
        if (displaytype != scaleType)
        {
            scaleType = displaytype;
            scaleTypeChanged = true;
            requestLayout();
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        setImageBitmap(bitmap, null, -1F, -1F);
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f, float f1)
    {
        if (bitmap != null)
        {
            setImageDrawable(new FastBitmapDrawable(bitmap), matrix, f, f1);
            return;
        } else
        {
            setImageDrawable(null, matrix, f, f1);
            return;
        }
    }

    public void setImageDrawable(Drawable drawable)
    {
        setImageDrawable(drawable, null, -1F, -1F);
    }

    public void setImageDrawable(final Drawable drawable, final Matrix initial_matrix, final float min_zoom, final float max_zoom)
    {
        if (getWidth() <= 0)
        {
            layoutRunnable = new Runnable() {

                final ImageViewTouchBase this$0;
                final Drawable val$drawable;
                final Matrix val$initial_matrix;
                final float val$max_zoom;
                final float val$min_zoom;

                public void run()
                {
                    setImageDrawable(drawable, initial_matrix, min_zoom, max_zoom);
                }

            
            {
                this$0 = ImageViewTouchBase.this;
                drawable = drawable1;
                initial_matrix = matrix;
                min_zoom = f;
                max_zoom = f1;
                super();
            }
            };
            return;
        } else
        {
            _setImageDrawable(drawable, initial_matrix, min_zoom, max_zoom);
            return;
        }
    }

    public void setImageMatrix(Matrix matrix)
    {
        boolean flag;
label0:
        {
            Matrix matrix1 = getImageMatrix();
            boolean flag1 = false;
            if (matrix != null || matrix1.isIdentity())
            {
                flag = flag1;
                if (matrix == null)
                {
                    break label0;
                }
                flag = flag1;
                if (matrix1.equals(matrix))
                {
                    break label0;
                }
            }
            flag = true;
        }
        super.setImageMatrix(matrix);
        if (flag)
        {
            onImageMatrixChanged();
        }
    }

    public void setImageResource(int i)
    {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    protected void setMaxScale(float f)
    {
        maxZoom = f;
    }

    protected void setMinScale(float f)
    {
        minZoom = f;
    }

    public void setOnDrawableChangedListener(OnDrawableChangeListener ondrawablechangelistener)
    {
        drawableChangeListener = ondrawablechangelistener;
    }

    public void setOnLayoutChangeListener(OnLayoutChangeListener onlayoutchangelistener)
    {
        onLayoutChangeListener = onlayoutchangelistener;
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (scaletype == android.widget.ImageView.ScaleType.MATRIX)
        {
            super.setScaleType(scaletype);
            return;
        } else
        {
            Log.w("ImageViewTouchBase", "Unsupported scaletype. Only MATRIX can be used");
            return;
        }
    }

    protected void updateRect(RectF rectf, RectF rectf1)
    {
        if (rectf != null)
        {
            if (rectf.top >= 0.0F && rectf.bottom <= (float)thisHeight)
            {
                rectf1.top = 0.0F;
            }
            if (rectf.left >= 0.0F && rectf.right <= (float)thisWidth)
            {
                rectf1.left = 0.0F;
            }
            if (rectf.top + rectf1.top >= 0.0F && rectf.bottom > (float)thisHeight)
            {
                rectf1.top = (int)(0.0F - rectf.top);
            }
            if (rectf.bottom + rectf1.top <= (float)(thisHeight + 0) && rectf.top < 0.0F)
            {
                rectf1.top = (int)((float)(thisHeight + 0) - rectf.bottom);
            }
            if (rectf.left + rectf1.left >= 0.0F)
            {
                rectf1.left = (int)(0.0F - rectf.left);
            }
            if (rectf.right + rectf1.left <= (float)(thisWidth + 0))
            {
                rectf1.left = (int)((float)(thisWidth + 0) - rectf.right);
                return;
            }
        }
    }

    protected void zoomTo(float f)
    {
        float f1 = f;
        if (f > getMaxScale())
        {
            f1 = getMaxScale();
        }
        f = f1;
        if (f1 < getMinScale())
        {
            f = getMinScale();
        }
        PointF pointf = getCenter();
        zoomTo(f, pointf.x, pointf.y);
    }

    public void zoomTo(float f, float f1)
    {
        PointF pointf = getCenter();
        zoomTo(f, pointf.x, pointf.y, f1);
    }

    protected void zoomTo(float f, float f1, float f2)
    {
        float f3 = f;
        if (f > getMaxScale())
        {
            f3 = getMaxScale();
        }
        postScale(f3 / getScale(), f1, f2);
        onZoom(getScale());
        center(true, true);
    }

    protected void zoomTo(float f, float f1, float f2, final float durationMs)
    {
        float f3 = f;
        if (f > getMaxScale())
        {
            f3 = getMaxScale();
        }
        final long startTime = System.currentTimeMillis();
        f = getScale();
        Object obj = new Matrix(suppMatrix);
        ((Matrix) (obj)).postScale(f3, f3, f1, f2);
        obj = getCenter(((Matrix) (obj)), true, true);
        float f4 = ((RectF) (obj)).left;
        float f5 = ((RectF) (obj)).top;
        handler.post(new Runnable() {

            final ImageViewTouchBase this$0;
            final float val$deltaScale;
            final float val$destX;
            final float val$destY;
            final float val$durationMs;
            final float val$oldScale;
            final long val$startTime;

            public void run()
            {
                long l = System.currentTimeMillis();
                float f6 = Math.min(durationMs, l - startTime);
                float f7 = (float)cubicEasing.easeInOut(f6, 0.0D, deltaScale, durationMs);
                zoomTo(oldScale + f7, destX, destY);
                if (f6 < durationMs)
                {
                    handler.post(this);
                    return;
                } else
                {
                    onZoomAnimationCompleted(getScale());
                    center(true, true);
                    return;
                }
            }

            
            {
                this$0 = ImageViewTouchBase.this;
                durationMs = f;
                startTime = l;
                deltaScale = f1;
                oldScale = f2;
                destX = f3;
                destY = f4;
                super();
            }
        });
    }



}
