// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.stretch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import gb;
import ij;

public class StretchImageView extends View
{

    boolean bIsCropStarted;
    boolean bIsFirst;
    boolean bIsShowPreImage;
    boolean bIsVerticalStyle;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Bitmap bitmap3;
    private int dy;
    private boolean isBottom;
    private boolean isTop;
    Context mContext;
    Drawable mDrawable;
    protected Rect mDrawableDst;
    protected Rect mDrawableFloat;
    protected Rect mDrawableSrc;
    ij mLineDrawable;
    private float mOriginalWidth;
    private float mOriginalheight;
    Paint mPaint;
    protected Rect mTempTectRect;
    private int sliderValue;
    private Point startPoint;

    public StretchImageView(Context context)
    {
        super(context);
        bIsFirst = true;
        bIsCropStarted = false;
        bIsVerticalStyle = true;
        bIsShowPreImage = false;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        mTempTectRect = new Rect();
        isTop = false;
        isBottom = false;
        dy = 0;
        init(context);
    }

    public StretchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bIsFirst = true;
        bIsCropStarted = false;
        bIsVerticalStyle = true;
        bIsShowPreImage = false;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        mTempTectRect = new Rect();
        isTop = false;
        isBottom = false;
        dy = 0;
        init(context);
    }

    public StretchImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bIsFirst = true;
        bIsCropStarted = false;
        bIsVerticalStyle = true;
        bIsShowPreImage = false;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        mTempTectRect = new Rect();
        isTop = false;
        isBottom = false;
        dy = 0;
        init(context);
    }

    private void init(Context context)
    {
        mContext = context;
        if (gb.c())
        {
            setLayerType(1, null);
        }
        mLineDrawable = new ij(context);
        mLineDrawable.a(bIsVerticalStyle);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#a0000000"));
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
    }

    public void changeStretchStyleVertical(boolean flag)
    {
        bIsVerticalStyle = flag;
        mLineDrawable.a(bIsVerticalStyle);
        invalidate();
    }

    protected void configureBounds()
    {
        if (bIsFirst)
        {
            float f = (float)mDrawable.getIntrinsicWidth() / (float)mDrawable.getIntrinsicHeight();
            int i = dipTopx(getContext(), 22F);
            int j;
            int k;
            int l;
            if (f > (float)getWidth() / (float)getHeight())
            {
                j = getWidth() - i * 2;
                i = (int)((float)j / f);
            } else
            {
                i = getHeight() - i * 2;
                j = (int)((float)i * f);
            }
            k = (getWidth() - j) / 2;
            l = (getHeight() - i) / 2;
            j += k;
            i += l;
            mDrawableSrc.set(k, l, j, i);
            mDrawableDst.set(mDrawableSrc);
            mDrawableFloat.set(k, l, j, i);
            bIsFirst = false;
            mDrawable.setBounds(mDrawableDst);
            mLineDrawable.setBounds(mDrawableFloat);
        }
    }

    public int dipTopx(Context context, float f)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f + 0.5F);
    }

    public Bitmap getSaveBitmap(Bitmap bitmap)
    {
        int k = 2;
        boolean flag1 = true;
        boolean flag = true;
        if (sliderValue == 0)
        {
            return null;
        }
        float f;
        if (bIsVerticalStyle)
        {
            f = mOriginalWidth / (float)mTempTectRect.width();
        } else
        {
            f = mOriginalheight / (float)mTempTectRect.height();
        }
        if (bitmap1 != null && bitmap2 != null && bitmap3 != null)
        {
            bitmap1.recycle();
            bitmap2.recycle();
            bitmap3.recycle();
            int l = (int)((float)mLineDrawable.a() * f);
            int j = (int)((float)mLineDrawable.b() * f);
            if (bIsVerticalStyle)
            {
                Bitmap bitmap4 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight() + (int)((float)sliderValue * f), android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap4);
                int i = j;
                if (j >= bitmap.getHeight())
                {
                    i = bitmap.getHeight() - 1;
                }
                j = l;
                if (l >= i)
                {
                    j = i - 1;
                }
                if (j < 1)
                {
                    j = ((flag) ? 1 : 0);
                }
                BitmapDrawable bitmapdrawable;
                BitmapDrawable bitmapdrawable1;
                if (i >= 2)
                {
                    k = i;
                }
                bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), j);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, j, bitmap.getWidth(), k - j);
                bitmap3 = Bitmap.createBitmap(bitmap, 0, k, bitmap.getWidth(), bitmap.getHeight() - k);
                bitmap = new BitmapDrawable(getResources(), bitmap1);
                bitmapdrawable = new BitmapDrawable(getResources(), bitmap2);
                bitmapdrawable1 = new BitmapDrawable(getResources(), bitmap3);
                bitmap.setBounds(0, 0, bitmap4.getWidth(), j + 0);
                bitmapdrawable.setBounds(0, j + 0, bitmap4.getWidth(), k + 0 + (int)((float)sliderValue * f));
                bitmapdrawable1.setBounds(0, (int)(f * (float)sliderValue) + (k + 0), bitmap4.getWidth(), bitmap4.getHeight());
                bitmap.draw(canvas);
                bitmapdrawable.draw(canvas);
                bitmapdrawable1.draw(canvas);
                bitmap = bitmap4;
            } else
            {
                bitmap4 = Bitmap.createBitmap(bitmap.getWidth() + (int)((float)sliderValue * f), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmap4);
                i = j;
                if (j >= bitmap.getWidth())
                {
                    i = bitmap.getWidth() - 1;
                }
                j = l;
                if (l >= i)
                {
                    j = i - 1;
                }
                if (j < 1)
                {
                    j = ((flag1) ? 1 : 0);
                }
                if (i >= 2)
                {
                    k = i;
                }
                bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, j, bitmap.getHeight());
                bitmap2 = Bitmap.createBitmap(bitmap, j, 0, k - j, bitmap.getHeight());
                bitmap3 = Bitmap.createBitmap(bitmap, k, 0, bitmap.getWidth() - k, bitmap.getHeight());
                bitmap = new BitmapDrawable(getResources(), bitmap1);
                bitmapdrawable = new BitmapDrawable(getResources(), bitmap2);
                bitmapdrawable1 = new BitmapDrawable(getResources(), bitmap3);
                bitmap.setBounds(0, 0, j, bitmap4.getHeight());
                bitmapdrawable.setBounds(j + 0, 0, k + 0 + (int)((float)sliderValue * f), bitmap4.getHeight());
                bitmapdrawable1.setBounds((int)(f * (float)sliderValue) + (k + 0), 0, bitmap4.getWidth(), bitmap4.getHeight());
                bitmap.draw(canvas);
                bitmapdrawable.draw(canvas);
                bitmapdrawable1.draw(canvas);
                bitmap = bitmap4;
            }
        } else
        {
            bitmap = null;
        }
        sliderValue = 0;
        bIsCropStarted = false;
        recycleImage();
        return bitmap;
    }

    public void hidePreImage()
    {
        bIsShowPreImage = false;
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        if (mDrawable != null && mDrawable.getIntrinsicWidth() != 0 && mDrawable.getIntrinsicHeight() != 0)
        {
            if (!bIsCropStarted || bIsShowPreImage)
            {
                configureBounds();
                mDrawable.draw(canvas);
                canvas.save();
                canvas.clipRect(mDrawableFloat, android.graphics.Region.Op.DIFFERENCE);
                canvas.drawRect(mDrawableSrc, mPaint);
            } else
            if (bitmap1 != null && bitmap2 != null && bitmap3 != null)
            {
                BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
                BitmapDrawable bitmapdrawable1 = new BitmapDrawable(getResources(), bitmap2);
                BitmapDrawable bitmapdrawable2 = new BitmapDrawable(getResources(), bitmap3);
                if (bIsVerticalStyle)
                {
                    bitmapdrawable.setBounds(mTempTectRect.left, mTempTectRect.top - sliderValue, mTempTectRect.right, (mTempTectRect.top + mLineDrawable.a()) - sliderValue);
                    bitmapdrawable1.setBounds(mTempTectRect.left, (mTempTectRect.top + mLineDrawable.a()) - sliderValue, mTempTectRect.right, mTempTectRect.top + mLineDrawable.b());
                    bitmapdrawable2.setBounds(mTempTectRect.left, mTempTectRect.top + mLineDrawable.b(), mTempTectRect.right, mTempTectRect.bottom);
                } else
                {
                    bitmapdrawable.setBounds(mTempTectRect.left - sliderValue / 2, mTempTectRect.top, (mTempTectRect.left + mLineDrawable.a()) - sliderValue / 2, mTempTectRect.bottom);
                    bitmapdrawable1.setBounds((mTempTectRect.left + mLineDrawable.a()) - sliderValue / 2, mTempTectRect.top, mTempTectRect.left + mLineDrawable.b() + sliderValue / 2, mTempTectRect.bottom);
                    bitmapdrawable2.setBounds(mTempTectRect.left + mLineDrawable.b() + sliderValue / 2, mTempTectRect.top, mTempTectRect.right + sliderValue / 2, mTempTectRect.bottom);
                }
                bitmapdrawable.draw(canvas);
                bitmapdrawable1.draw(canvas);
                bitmapdrawable2.draw(canvas);
                canvas.save();
                canvas.clipRect(mTempTectRect, android.graphics.Region.Op.DIFFERENCE);
                canvas.drawRect(mTempTectRect, mPaint);
            }
            canvas.restore();
            if (!bIsCropStarted)
            {
                mLineDrawable.draw(canvas);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() == 1) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        switch (motionevent.getAction())
        {
        default:
            return true;

        case 0: // '\0'
            if (bIsCropStarted)
            {
                if (mTempTectRect.contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    showPreImage();
                    return true;
                }
            } else
            {
                startPoint = new Point((int)motionevent.getX(), (int)motionevent.getY());
                isTop = mLineDrawable.c().contains((int)motionevent.getX(), (int)motionevent.getY());
                isBottom = mLineDrawable.d().contains((int)motionevent.getX(), (int)motionevent.getY());
                return true;
            }
            break;

        case 2: // '\002'
            if (!bIsCropStarted && (isTop || isBottom))
            {
                dy = (int)motionevent.getY() - startPoint.y;
                if (!bIsVerticalStyle)
                {
                    dy = (int)motionevent.getX() - startPoint.x;
                }
                startPoint.x = (int)motionevent.getX();
                startPoint.y = (int)motionevent.getY();
                if (isTop)
                {
                    mLineDrawable.a(dy);
                } else
                if (isBottom)
                {
                    mLineDrawable.b(dy);
                }
                invalidate();
                return true;
            }
            break;

        case 1: // '\001'
            if (bIsCropStarted)
            {
                hidePreImage();
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!isTop && !isBottom) goto _L1; else goto _L4
_L4:
        dy = (int)motionevent.getY() - startPoint.y;
        if (!bIsVerticalStyle)
        {
            dy = (int)motionevent.getX() - startPoint.x;
        }
        startPoint.x = (int)motionevent.getX();
        startPoint.y = (int)motionevent.getY();
        if (!isTop) goto _L6; else goto _L5
_L5:
        mLineDrawable.a(dy);
_L8:
        invalidate();
        return true;
_L6:
        if (isBottom)
        {
            mLineDrawable.b(dy);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int pxTodip(Context context, float f)
    {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f1 = f2;
        if (f2 <= 0.0F)
        {
            f1 = 1.0F;
        }
        return (int)(f / f1 + 0.5F);
    }

    public void recycleImage()
    {
        try
        {
            if (bitmap1 != null && !bitmap1.isRecycled())
            {
                bitmap1.recycle();
            }
            if (bitmap2 != null && !bitmap2.isRecycled())
            {
                bitmap2.recycle();
            }
            if (bitmap3 != null && !bitmap3.isRecycled())
            {
                bitmap3.recycle();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void redisplayLineDrawable()
    {
        bIsCropStarted = false;
        sliderValue = 0;
        mLineDrawable.a(bIsVerticalStyle);
        invalidate();
    }

    public void setDrawable(Drawable drawable, int i, int j)
    {
        mDrawable = drawable;
        mOriginalWidth = drawable.getIntrinsicWidth();
        mOriginalheight = drawable.getIntrinsicHeight();
        bIsFirst = true;
        bIsCropStarted = false;
        mLineDrawable.a(bIsVerticalStyle);
        invalidate();
    }

    public void showPreImage()
    {
        bIsShowPreImage = true;
        invalidate();
    }

    public void startCropImage()
    {
        Object obj;
        int j1;
        int k1;
        byte byte0;
        boolean flag;
        boolean flag1;
label0:
        {
            byte0 = 2;
            flag1 = true;
            flag = true;
            bIsCropStarted = true;
            sliderValue = 0;
            Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.RGB_565);
            obj = new Canvas(bitmap);
            mDrawable.draw(((Canvas) (obj)));
            obj = new Matrix();
            float f = (float)mDrawableSrc.width() / (float)mDrawableDst.width();
            ((Matrix) (obj)).postScale(f, f);
            obj = Bitmap.createBitmap(bitmap, mDrawableFloat.left, mDrawableFloat.top, mDrawableFloat.width(), mDrawableFloat.height(), ((Matrix) (obj)), true);
            if (obj != bitmap)
            {
                bitmap.recycle();
            }
            int l = ((Bitmap) (obj)).getWidth();
            int l1 = ((Bitmap) (obj)).getHeight();
            if (l % 2 == 0)
            {
                j1 = l;
                k1 = l1;
                if (l1 % 2 == 0)
                {
                    break label0;
                }
            }
            int i = l;
            if (l % 2 != 0)
            {
                i = l - 1;
            }
            j1 = i;
            k1 = l1;
            if (l1 % 2 != 0)
            {
                k1 = l1 - 1;
                j1 = i;
            }
        }
        int i2 = mLineDrawable.a();
        int i1 = mLineDrawable.b();
        if (bIsVerticalStyle)
        {
            int j = i1;
            if (i1 >= k1)
            {
                j = k1 - 1;
            }
            i1 = i2;
            if (i2 >= j)
            {
                i1 = j - 1;
            }
            if (i1 < 1)
            {
                i1 = ((flag) ? 1 : 0);
            }
            i2 = j;
            if (j < 2)
            {
                i2 = 2;
            }
            bitmap1 = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, j1, i1);
            bitmap2 = Bitmap.createBitmap(((Bitmap) (obj)), 0, i1, j1, i2 - i1);
            bitmap3 = Bitmap.createBitmap(((Bitmap) (obj)), 0, i2, j1, k1 - i2);
            mTempTectRect.set(mDrawableFloat.left, mDrawableFloat.top - sliderValue, mDrawableFloat.right, mDrawableFloat.bottom);
        } else
        {
            int k = i1;
            if (i1 >= j1)
            {
                k = j1 - 1;
            }
            i1 = i2;
            if (i2 >= k)
            {
                i1 = k - 1;
            }
            if (i1 < 1)
            {
                i1 = ((flag1) ? 1 : 0);
            }
            if (k < 2)
            {
                k = byte0;
            }
            bitmap1 = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, i1, k1);
            bitmap2 = Bitmap.createBitmap(((Bitmap) (obj)), i1, 0, k - i1, k1);
            bitmap3 = Bitmap.createBitmap(((Bitmap) (obj)), k, 0, j1 - k, k1);
            mTempTectRect.set(mDrawableFloat.left - sliderValue / 2, mDrawableFloat.top, mDrawableFloat.right + sliderValue / 2, mDrawableFloat.bottom);
        }
        invalidate();
    }

    public void stretchWithSliderValue(int i)
    {
        int j = mLineDrawable.b() - mLineDrawable.a();
        if (j <= 50)
        {
            sliderValue = (int)((float)j * ((float)i / 50F));
        } else
        {
            sliderValue = i;
        }
        if (bIsVerticalStyle)
        {
            mTempTectRect.set(mDrawableFloat.left, mDrawableFloat.top - sliderValue, mDrawableFloat.right, mDrawableFloat.bottom);
        } else
        {
            mTempTectRect.set(mDrawableFloat.left - sliderValue / 2, mDrawableFloat.top, mDrawableFloat.right + sliderValue / 2, mDrawableFloat.bottom);
        }
        i = mTempTectRect.width();
        j = mTempTectRect.height();
        Log.i("tempRect", (new StringBuilder()).append("width ").append(i).append("  height ").append(j).toString());
        invalidate();
    }
}
