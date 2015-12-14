// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.stretch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import ew;
import gb;
import ik;
import il;

public class StretchNewImageView extends View
{

    boolean bIsFirst;
    boolean bIsShowPreImage;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Bitmap bitmap3;
    int bottomSliderValur;
    private int bottomValue;
    private int dy;
    boolean isBitmapChanged;
    private boolean isBottom;
    private boolean isTop;
    private Bitmap lastProcessBitmap;
    private il lisener;
    Context mContext;
    Drawable mDrawable;
    protected Rect mDrawableDst;
    protected Rect mDrawableFloat;
    protected Rect mDrawableSrc;
    ik mLineDrawable;
    private float mOriginalWidth;
    private float mOriginalheight;
    Paint mPaint;
    protected Rect mTempTectRect;
    private int sliderValue;
    private Point startPoint;
    int topSliderValur;
    private int topValue;

    public StretchNewImageView(Context context)
    {
        super(context);
        bIsFirst = true;
        bIsShowPreImage = false;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        mTempTectRect = new Rect();
        isTop = false;
        isBottom = false;
        dy = 0;
        isBitmapChanged = false;
        topSliderValur = 0;
        bottomSliderValur = 0;
        init(context);
    }

    public StretchNewImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bIsFirst = true;
        bIsShowPreImage = false;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        mTempTectRect = new Rect();
        isTop = false;
        isBottom = false;
        dy = 0;
        isBitmapChanged = false;
        topSliderValur = 0;
        bottomSliderValur = 0;
        init(context);
    }

    public StretchNewImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bIsFirst = true;
        bIsShowPreImage = false;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        mTempTectRect = new Rect();
        isTop = false;
        isBottom = false;
        dy = 0;
        isBitmapChanged = false;
        topSliderValur = 0;
        bottomSliderValur = 0;
        init(context);
    }

    private void init(Context context)
    {
        mContext = context;
        if (gb.c())
        {
            setLayerType(1, null);
        }
        mLineDrawable = new ik(context);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#a0000000"));
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
    }

    private Bitmap restoreProcessBitmap()
    {
        Bitmap bitmap;
        if (sliderValue == 0)
        {
            bitmap = lastProcessBitmap;
        } else
        {
            float f = mOriginalWidth / (float)mTempTectRect.width();
            Object obj = null;
            bitmap = obj;
            if (bitmap1 != null)
            {
                bitmap = obj;
                if (bitmap2 != null)
                {
                    bitmap = obj;
                    if (bitmap3 != null)
                    {
                        bitmap = obj;
                        if (lastProcessBitmap != null)
                        {
                            Bitmap bitmap4 = Bitmap.createBitmap((int)mOriginalWidth, (int)((float)mTempTectRect.height() * f), android.graphics.Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(bitmap4);
                            BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
                            BitmapDrawable bitmapdrawable1 = new BitmapDrawable(getResources(), bitmap2);
                            BitmapDrawable bitmapdrawable2 = new BitmapDrawable(getResources(), bitmap3);
                            bitmapdrawable.setBounds(0, 0, bitmap4.getWidth(), (int)((float)topValue * f) + 0);
                            bitmapdrawable1.setBounds(0, (int)((float)topValue * f) + 0, bitmap4.getWidth(), (int)((float)bottomValue * f) + 0 + (int)((float)sliderValue * f));
                            int i = (int)((float)bottomValue * f);
                            bitmapdrawable2.setBounds(0, (int)(f * (float)sliderValue) + (i + 0), bitmap4.getWidth(), bitmap4.getHeight());
                            bitmapdrawable.draw(canvas);
                            bitmapdrawable1.draw(canvas);
                            bitmapdrawable2.draw(canvas);
                            return bitmap4;
                        }
                    }
                }
            }
        }
        return bitmap;
    }

    protected void configureBounds()
    {
        float f = (float)mDrawable.getIntrinsicWidth() / (float)mDrawable.getIntrinsicHeight();
        int i = ew.a(getContext(), 22F);
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
        mDrawable.setBounds(mDrawableDst);
        mLineDrawable.setBounds(mDrawableFloat);
    }

    public Bitmap getSaveBitamp()
    {
        return lastProcessBitmap;
    }

    public void hidePreImage()
    {
        bIsShowPreImage = false;
        invalidate();
    }

    public void logRect(String s, Rect rect)
    {
        Log.e("Rect", String.format("%s rect: %d, %d - %d, %d [%d, %d]", new Object[] {
            s, Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())
        }));
    }

    protected void onDraw(Canvas canvas)
    {
        while (mDrawable == null || mDrawable.getIntrinsicWidth() == 0 || mDrawable.getIntrinsicHeight() == 0) 
        {
            return;
        }
        if (bIsShowPreImage)
        {
            mDrawable.draw(canvas);
            canvas.save();
            canvas.restore();
            return;
        }
        if (bitmap1 != null && bitmap2 != null && bitmap3 != null)
        {
            BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
            BitmapDrawable bitmapdrawable1 = new BitmapDrawable(getResources(), bitmap2);
            BitmapDrawable bitmapdrawable2 = new BitmapDrawable(getResources(), bitmap3);
            bitmapdrawable.setBounds(mTempTectRect.left, mTempTectRect.top, mTempTectRect.right, mTempTectRect.top + topValue);
            bitmapdrawable1.setBounds(mTempTectRect.left, mTempTectRect.top + topValue, mTempTectRect.right, mTempTectRect.top + bottomValue + sliderValue);
            bitmapdrawable2.setBounds(mTempTectRect.left, mTempTectRect.top + bottomValue + sliderValue, mTempTectRect.right, mTempTectRect.bottom);
            bitmapdrawable.draw(canvas);
            bitmapdrawable1.draw(canvas);
            bitmapdrawable2.draw(canvas);
            canvas.save();
            canvas.clipRect(mTempTectRect, android.graphics.Region.Op.DIFFERENCE);
            canvas.drawRect(mTempTectRect, mPaint);
            canvas.restore();
        }
        mLineDrawable.draw(canvas);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (bIsFirst)
        {
            bIsFirst = false;
            configureBounds();
            mLineDrawable.a(true);
            startCropImage();
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

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            startPoint = new Point((int)motionevent.getX(), (int)motionevent.getY());
            isTop = mLineDrawable.c().contains((int)motionevent.getX(), (int)motionevent.getY());
            isBottom = mLineDrawable.d().contains((int)motionevent.getX(), (int)motionevent.getY());
            if (!isTop && !isBottom)
            {
                if (mTempTectRect.contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    showPreImage();
                    return true;
                }
            } else
            {
                mDrawableFloat.set(mTempTectRect);
                if (isBitmapChanged)
                {
                    isBitmapChanged = false;
                    startCropImage();
                    return true;
                }
            }
            break;

        case 2: // '\002'
            if (isTop || isBottom)
            {
                if (lisener != null)
                {
                    sliderValue = 0;
                    lisener.a();
                }
                dy = (int)motionevent.getY() - startPoint.y;
                startPoint.x = (int)motionevent.getX();
                startPoint.y = (int)motionevent.getY();
                if (isTop)
                {
                    mLineDrawable.c(dy);
                    mLineDrawable.b(true);
                    invalidate();
                    return true;
                }
                if (isBottom)
                {
                    mLineDrawable.d(dy);
                    mLineDrawable.b(true);
                    invalidate();
                    return true;
                }
            }
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (isTop || isBottom)
        {
            break; /* Loop/switch isn't completed */
        }
        if (bIsShowPreImage)
        {
            hidePreImage();
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
        dy = (int)motionevent.getY() - startPoint.y;
        startPoint.x = (int)motionevent.getX();
        startPoint.y = (int)motionevent.getY();
        if (isTop)
        {
            mLineDrawable.c(dy);
        } else
        if (isBottom)
        {
            mLineDrawable.d(dy);
        }
        mLineDrawable.b(false);
        startCropImage();
        if (lisener != null)
        {
            lisener.b();
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
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

    public void resstProcessImage()
    {
        lastProcessBitmap = restoreProcessBitmap();
        isBitmapChanged = true;
    }

    public void setDrawable(Drawable drawable, int i, int j)
    {
        mDrawable = drawable;
        mOriginalWidth = drawable.getIntrinsicWidth();
        mOriginalheight = drawable.getIntrinsicHeight();
        bIsFirst = true;
        lastProcessBitmap = ((BitmapDrawable)mDrawable).getBitmap().copy(android.graphics.Bitmap.Config.ARGB_8888, false);
    }

    public void setStretchNewImageViewLisener(il il1)
    {
        lisener = il1;
    }

    public void showPreImage()
    {
        bIsShowPreImage = true;
        invalidate();
    }

    public void startCropImage()
    {
        float f;
        int i1;
        int j1;
        byte byte0;
        boolean flag;
label0:
        {
            byte0 = 2;
            flag = true;
            sliderValue = 0;
            f = (float)lastProcessBitmap.getWidth() / (float)mDrawableDst.width();
            int k = lastProcessBitmap.getWidth();
            int k1 = lastProcessBitmap.getHeight();
            if (k % 2 == 0)
            {
                i1 = k;
                j1 = k1;
                if (k1 % 2 == 0)
                {
                    break label0;
                }
            }
            int i = k;
            if (k % 2 != 0)
            {
                i = k - 1;
            }
            i1 = i;
            j1 = k1;
            if (k1 % 2 != 0)
            {
                j1 = k1 - 1;
                i1 = i;
            }
        }
        topValue = mLineDrawable.a();
        bottomValue = mLineDrawable.b();
        int l1 = (int)((float)topValue * f);
        int l = (int)(f * (float)bottomValue);
        int j = l;
        if (l >= j1)
        {
            j = j1 - 1;
        }
        l = l1;
        if (l1 >= j)
        {
            l = j - 1;
        }
        if (l < 1)
        {
            l = ((flag) ? 1 : 0);
        }
        if (j < 2)
        {
            j = byte0;
        }
        bitmap1 = Bitmap.createBitmap(lastProcessBitmap, 0, 0, i1, l);
        bitmap2 = Bitmap.createBitmap(lastProcessBitmap, 0, l, i1, j - l);
        bitmap3 = Bitmap.createBitmap(lastProcessBitmap, 0, j, i1, j1 - j);
        mTempTectRect.set(mDrawableFloat);
        invalidate();
    }

    public void stretchWithSliderValue(int i)
    {
        int j = bottomValue - topValue;
        if (j <= 50)
        {
            sliderValue = (int)((float)j * ((float)i / 50F));
        } else
        {
            sliderValue = i;
        }
        topSliderValur = sliderValue / 2;
        bottomSliderValur = sliderValue - sliderValue / 2;
        mTempTectRect.set(mDrawableFloat.left, mDrawableFloat.top - topSliderValur, mDrawableFloat.right, mDrawableFloat.bottom + bottomSliderValur);
        Log.e("test", (new StringBuilder()).append("top1 ").append(mLineDrawable.a()).append(", bottom ").append(mLineDrawable.b()).toString());
        logRect("line 1", mLineDrawable.getBounds());
        mLineDrawable.setBounds(mTempTectRect);
        Log.e("test", (new StringBuilder()).append("top2 ").append(mLineDrawable.a()).append(", bottom ").append(mLineDrawable.b()).toString());
        logRect("line 2", mLineDrawable.getBounds());
        mLineDrawable.a(topValue + mTempTectRect.top);
        mLineDrawable.b(bottomValue + mTempTectRect.top + sliderValue);
        Log.e("test", (new StringBuilder()).append("top3 ").append(mLineDrawable.a()).append(", bottom ").append(mLineDrawable.b()).toString());
        Log.e("---", "-----");
        invalidate();
    }
}
