// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import cgn;

// Referenced classes of package wantu.sephiroth.android.library.imagezoom:
//            ImageViewTouch

public class MaskScrollImageViewTouch extends ImageViewTouch
{

    private static final String TAG = "MaskScrollImageViewTouch";
    private Shader mBmpShader;
    private RectF mFrame;
    private Bitmap mMask;
    private Paint mPaint;

    public MaskScrollImageViewTouch(Context context)
    {
        super(context);
        mFrame = new RectF();
    }

    public MaskScrollImageViewTouch(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFrame = new RectF();
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

    public Bitmap getDispalyImage(int i, int j)
    {
        int k = getWidth();
        float f = (float)i / (float)k;
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Matrix matrix = new Matrix(getImageViewMatrix());
        matrix.preScale(f, f);
        canvas.drawARGB(0, 0, 0, 0);
        Matrix matrix1 = new Matrix();
        mBmpShader.getLocalMatrix(matrix1);
        if (mMask != null && !mMask.isRecycled())
        {
            float f1 = (float)i / (float)mMask.getWidth();
            matrix.preScale(1.0F / f1, 1.0F / f1);
            mBmpShader.setLocalMatrix(matrix);
            canvas.scale(f1, f1);
            canvas.drawBitmap(mMask, 0.0F, 0.0F, mPaint);
        } else
        {
            Bitmap bitmap1 = ((cgn)getDrawable()).a();
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap1, matrix, paint);
        }
        mBmpShader.setLocalMatrix(matrix1);
        return bitmap;
    }

    public Bitmap getMask()
    {
        return mMask;
    }

    protected void init()
    {
        super.init();
        setFitToScreen(true);
        mPaint = new Paint();
        mPaint.setFilterBitmap(true);
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
        if (mMask != null && !mMask.isRecycled() && mBmpShader != null)
        {
            canvas.save();
            Matrix matrix = new Matrix(getImageViewMatrix());
            float f = mFrame.width() / (float)mMask.getWidth();
            canvas.scale(f, f);
            matrix.postScale(1.0F / f, 1.0F / f);
            mBmpShader.setLocalMatrix(matrix);
            canvas.drawBitmap(mMask, 0.0F, 0.0F, mPaint);
            canvas.restore();
            return;
        } else
        {
            super.onDraw(canvas);
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mFrame.set(0.0F, 0.0F, k - i, l - j);
    }

    public void renderInCanvas(Canvas canvas)
    {
        if (mMask != null && !mMask.isRecycled() && mBmpShader != null)
        {
            Matrix matrix = new Matrix(getImageViewMatrix());
            float f = mFrame.width() / (float)mMask.getWidth();
            canvas.scale(f, f);
            matrix.postScale(1.0F / f, 1.0F / f);
            mBmpShader.setLocalMatrix(matrix);
            canvas.drawBitmap(mMask, 0.0F, 0.0F, mPaint);
            return;
        } else
        {
            Bitmap bitmap = ((cgn)getDrawable()).a();
            Paint paint = new Paint();
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap, getImageViewMatrix(), paint);
            return;
        }
    }

    public void setMask(Bitmap bitmap)
    {
        if (mMask != null && !mMask.isRecycled())
        {
            mMask.recycle();
            mMask = null;
        }
        mMask = bitmap;
    }
}
