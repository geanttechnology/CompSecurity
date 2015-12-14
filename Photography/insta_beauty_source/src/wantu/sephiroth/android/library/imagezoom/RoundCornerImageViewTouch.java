// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import cgn;

// Referenced classes of package wantu.sephiroth.android.library.imagezoom:
//            ImageViewTouch

public class RoundCornerImageViewTouch extends ImageViewTouch
{

    private Shader mBmpShader;
    private RectF mFrame;
    private Paint mHighlightPaint;
    private boolean mIsHighlight;
    private boolean mIsUsingShadow;
    private Paint mPaint;
    private Paint mShadowPaint;
    private int padding;
    private int radius;

    public RoundCornerImageViewTouch(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        padding = 0;
        mFrame = new RectF();
        mIsUsingShadow = true;
        mIsHighlight = false;
        radius = (int)getContext().getResources().getDimension(0x7f08002f);
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

    public void changeRadius(int i)
    {
        radius = i;
        invalidate();
    }

    public Bitmap getDispalyImage(int i, int j)
    {
        float f;
        Bitmap bitmap;
        Canvas canvas;
        Matrix matrix;
        Bitmap bitmap1;
        int i1;
        int k = getWidth();
        f = (float)i / (float)k;
        bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        matrix = getImageMatrix();
        matrix.postScale(f, f);
        bitmap1 = ((cgn)getDrawable()).a();
        i1 = (int)getContext().getResources().getDimension(0x7f080030);
        int l;
        if (mIsUsingShadow)
        {
            l = i1;
        } else
        {
            l = 0;
        }
        try
        {
            padding = l;
            padding = (int)((float)padding * f + 0.5F);
            RectF rectf = new RectF(padding, padding, i - padding, j - padding);
            i = (int)((float)radius * f);
            if (mIsUsingShadow)
            {
                mShadowPaint.setMaskFilter(new BlurMaskFilter((float)i1 * f, android.graphics.BlurMaskFilter.Blur.OUTER));
                canvas.drawRoundRect(rectf, i, i, mShadowPaint);
            }
            canvas.saveLayer(rectf, null, 31);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff424242);
            Path path = new Path();
            path.addRoundRect(rectf, i, i, android.graphics.Path.Direction.CW);
            canvas.drawPath(path, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap1, matrix, paint);
            canvas.restore();
            matrix.postScale(1.0F / f, 1.0F / f);
        }
        catch (Exception exception)
        {
            return null;
        }
        return bitmap;
    }

    public boolean getIsUsingShadow()
    {
        return mIsUsingShadow;
    }

    public int getRadius()
    {
        return radius;
    }

    protected void init()
    {
        super.init();
        mPaint = new Paint();
        mPaint.setFilterBitmap(true);
        mPaint.setAntiAlias(true);
        mShadowPaint = new Paint(1);
        int i = (int)getContext().getResources().getDimension(0x7f080030);
        mShadowPaint.setMaskFilter(new BlurMaskFilter(i, android.graphics.BlurMaskFilter.Blur.OUTER));
        mShadowPaint.setColor(0xff000000);
        mHighlightPaint = new Paint(1);
        i = (int)getContext().getResources().getDimension(0x7f080032);
        mHighlightPaint.setStrokeWidth(i);
        mHighlightPaint.setColor(Color.parseColor("#0773bc"));
        mHighlightPaint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public boolean isHighlight()
    {
        return mIsHighlight;
    }

    protected void onBitmapChanged(Drawable drawable)
    {
        if (drawable == null)
        {
            mBmpShader = null;
            return;
        } else
        {
            mBmpShader = createShader(((cgn)drawable).a());
            mPaint.setShader(mBmpShader);
            super.onBitmapChanged(drawable);
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        Log.v("Round corner view", (new StringBuilder()).append("width: ").append(getWidth()).append("  height").append(getHeight()).toString());
        int i = (int)getContext().getResources().getDimension(0x7f080030);
        if (!mIsUsingShadow)
        {
            i = 0;
        }
        padding = i;
        mFrame.set(padding, padding, getWidth() - padding, getHeight() - padding);
        if (mIsUsingShadow)
        {
            canvas.drawRoundRect(mFrame, radius, radius, mShadowPaint);
        }
        mBmpShader.setLocalMatrix(getImageViewMatrix());
        canvas.drawRoundRect(mFrame, radius, radius, mPaint);
        if (mIsHighlight)
        {
            i = (int)getContext().getResources().getDimension(0x7f080031);
            mFrame.inset(i, i);
            canvas.drawRoundRect(mFrame, radius - i, radius - i, mHighlightPaint);
        }
    }

    public void setHighlight(boolean flag)
    {
        mIsHighlight = flag;
        invalidate();
    }

    public void setIsUsingShadow(boolean flag)
    {
        mIsUsingShadow = flag;
        invalidate();
    }

    public void setRadius(int i)
    {
        radius = i;
    }
}
