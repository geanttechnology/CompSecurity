// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

// Referenced classes of package co.vine.android.widget:
//            MultiTouchImageView

public class CroppableImageView extends MultiTouchImageView
{

    public static final String CROP_NAME_ORIGINAL_ASPECT_RATION = "original_aspect";
    public static final String CROP_NAME_SQUARE = "square_aspect";
    public static final int CROP_TYPE_EDIT_PROFILE = 0;
    public static final int CROP_TYPE_ORIGINAL_ASPECT_RATIO = 1;
    public static final int CROP_TYPE_SQUARE = 2;
    private int mCropRectPadding;
    private int mCropType;
    private Paint mShadowPaint;
    private RectF mShadowRect;
    private Paint mStrokePaint;

    public CroppableImageView(Context context)
    {
        super(context);
        context = getResources();
        init(context.getColor(0x7f090083), context.getColor(0x7f090091));
    }

    public CroppableImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01001d);
    }

    public CroppableImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.CroppableImageView, i, 0);
        i = context.getDimensionPixelSize(0, 0);
        if (i > 0)
        {
            mCropRectPadding = i;
        }
        attributeset = getResources();
        i = context.getColor(1, attributeset.getColor(0x7f090083));
        int j = context.getColor(2, attributeset.getColor(0x7f090091));
        context.recycle();
        init(i, j);
    }

    private void init(int i, int j)
    {
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        mStrokePaint = paint;
        paint = new Paint();
        paint.setColor(j);
        mShadowPaint = paint;
        mShadowRect = new RectF();
        mCropType = 0;
    }

    public RectF getCropRect()
    {
        RectF rectf = new RectF(mTransformBounds);
        Matrix matrix = new Matrix();
        mMatrix.invert(matrix);
        matrix.mapRect(rectf);
        return rectf;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        RectF rectf = mTransformBounds;
        canvas.drawRect(rectf, mStrokePaint);
        int i = canvas.getWidth();
        int j = canvas.getHeight();
        Paint paint = mShadowPaint;
        RectF rectf1 = mShadowRect;
        rectf1.set(0.0F, rectf.top, rectf.left, rectf.bottom);
        canvas.drawRect(rectf1, paint);
        rectf1.set(0.0F, 0.0F, i, rectf.top);
        canvas.drawRect(rectf1, paint);
        rectf1.set(rectf.right, rectf.top, i, rectf.bottom);
        canvas.drawRect(rectf1, paint);
        rectf1.set(0.0F, rectf.bottom, i, j);
        canvas.drawRect(rectf1, paint);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        setCropPadding(mCropRectPadding, mCropType);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
    }

    public void setCropPadding(int i, int j)
    {
        int k;
        int l;
        int i1;
        mCropType = j;
        mCropRectPadding = i;
        k = getMeasuredWidth();
        l = getMeasuredHeight();
        float f = mBitmapWidth / mBitmapHeight;
        if ((float)k / (float)l > f)
        {
            k = l - (int)((float)i / f);
            f = mBitmapHeight / (float)l;
            i = (int)(mBitmapWidth / f) - i;
        } else
        {
            l = k - i;
            float f1 = mBitmapWidth / (float)k;
            k = (int)(mBitmapHeight / f1) - (int)((float)i / f);
            i = l;
        }
        if (j != 0) goto _L2; else goto _L1
_L1:
        l = i / 2;
        i1 = i;
_L4:
        setTransformDimensions(i1, l, android.widget.ImageView.ScaleType.CENTER_CROP, false);
        return;
_L2:
        l = k;
        i1 = i;
        if (j == 2)
        {
            if (k < i)
            {
                i1 = k;
                l = k;
            } else
            {
                l = i;
                i1 = i;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setCropType(int i)
    {
        if (mCropType != i)
        {
            mCropType = i;
            invalidate();
        }
    }
}
