// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import aaj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import xm;

public class CropImageView extends View
{

    private final int EDGE_B;
    private final int EDGE_L;
    private final int EDGE_LB;
    private final int EDGE_LT;
    private final int EDGE_MOVE_IN;
    private final int EDGE_MOVE_OUT;
    private final int EDGE_NONE;
    private final int EDGE_R;
    private final int EDGE_RB;
    private final int EDGE_RT;
    private final int EDGE_T;
    private final int STATUS_TOUCH_MULTI_START;
    private final int STATUS_TOUCH_MULTI_TOUCHING;
    private final int STATUS_TOUCH_SINGLE;
    private int cropHeight;
    private int cropWidth;
    public int currentEdge;
    private final int defaultCropHeight;
    private final int defaultCropWidth;
    protected float floatRationWH;
    protected boolean isFrist;
    protected Context mContext;
    protected Drawable mDrawable;
    protected Rect mDrawableDst;
    protected Rect mDrawableFloat;
    protected Rect mDrawableSrc;
    protected xm mFloatDrawable;
    protected final int mFloatPointRadius;
    protected Paint mPaint;
    private int mStatus;
    private final int minFloatHeight;
    private final int minFloatWidth;
    private float oldX;
    private float oldY;
    private float oldx_0;
    private float oldx_1;
    private float oldy_0;
    private float oldy_1;

    public CropImageView(Context context)
    {
        super(context);
        oldX = 0.0F;
        oldY = 0.0F;
        oldx_0 = 0.0F;
        oldy_0 = 0.0F;
        oldx_1 = 0.0F;
        oldy_1 = 0.0F;
        STATUS_TOUCH_SINGLE = 1;
        STATUS_TOUCH_MULTI_START = 2;
        STATUS_TOUCH_MULTI_TOUCHING = 3;
        mStatus = 1;
        defaultCropWidth = 200;
        defaultCropHeight = 200;
        minFloatWidth = 120;
        minFloatHeight = 120;
        cropWidth = 200;
        cropHeight = 200;
        EDGE_LT = 1;
        EDGE_RT = 2;
        EDGE_LB = 3;
        EDGE_RB = 4;
        EDGE_MOVE_IN = 5;
        EDGE_MOVE_OUT = 6;
        EDGE_NONE = 7;
        EDGE_T = 8;
        EDGE_B = 9;
        EDGE_L = 10;
        EDGE_R = 11;
        currentEdge = 7;
        floatRationWH = 0.0F;
        mFloatPointRadius = 5;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        isFrist = true;
        init(context);
    }

    public CropImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        oldX = 0.0F;
        oldY = 0.0F;
        oldx_0 = 0.0F;
        oldy_0 = 0.0F;
        oldx_1 = 0.0F;
        oldy_1 = 0.0F;
        STATUS_TOUCH_SINGLE = 1;
        STATUS_TOUCH_MULTI_START = 2;
        STATUS_TOUCH_MULTI_TOUCHING = 3;
        mStatus = 1;
        defaultCropWidth = 200;
        defaultCropHeight = 200;
        minFloatWidth = 120;
        minFloatHeight = 120;
        cropWidth = 200;
        cropHeight = 200;
        EDGE_LT = 1;
        EDGE_RT = 2;
        EDGE_LB = 3;
        EDGE_RB = 4;
        EDGE_MOVE_IN = 5;
        EDGE_MOVE_OUT = 6;
        EDGE_NONE = 7;
        EDGE_T = 8;
        EDGE_B = 9;
        EDGE_L = 10;
        EDGE_R = 11;
        currentEdge = 7;
        floatRationWH = 0.0F;
        mFloatPointRadius = 5;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        isFrist = true;
        init(context);
    }

    public CropImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        oldX = 0.0F;
        oldY = 0.0F;
        oldx_0 = 0.0F;
        oldy_0 = 0.0F;
        oldx_1 = 0.0F;
        oldy_1 = 0.0F;
        STATUS_TOUCH_SINGLE = 1;
        STATUS_TOUCH_MULTI_START = 2;
        STATUS_TOUCH_MULTI_TOUCHING = 3;
        mStatus = 1;
        defaultCropWidth = 200;
        defaultCropHeight = 200;
        minFloatWidth = 120;
        minFloatHeight = 120;
        cropWidth = 200;
        cropHeight = 200;
        EDGE_LT = 1;
        EDGE_RT = 2;
        EDGE_LB = 3;
        EDGE_RB = 4;
        EDGE_MOVE_IN = 5;
        EDGE_MOVE_OUT = 6;
        EDGE_NONE = 7;
        EDGE_T = 8;
        EDGE_B = 9;
        EDGE_L = 10;
        EDGE_R = 11;
        currentEdge = 7;
        floatRationWH = 0.0F;
        mFloatPointRadius = 5;
        mDrawableSrc = new Rect();
        mDrawableDst = new Rect();
        mDrawableFloat = new Rect();
        isFrist = true;
        init(context);
    }

    private void init(Context context)
    {
        mContext = context;
        if (aaj.c())
        {
            setLayerType(1, null);
        }
        mFloatDrawable = new xm(context);
        mFloatDrawable.a(true);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#a0000000"));
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
    }

    protected void checkBounds()
    {
        boolean flag1 = true;
        int j = mDrawableFloat.left;
        int k = mDrawableFloat.top;
        int i = 0;
        if (mDrawableFloat.left < mDrawableSrc.left)
        {
            j = mDrawableSrc.left;
            i = 1;
        }
        boolean flag = i;
        i = k;
        if (mDrawableFloat.top < mDrawableSrc.top)
        {
            i = mDrawableSrc.top;
            flag = true;
        }
        if (mDrawableFloat.right > mDrawableSrc.right)
        {
            j = mDrawableSrc.right - mDrawableFloat.width();
            flag = true;
        }
        if (mDrawableFloat.bottom > mDrawableSrc.bottom)
        {
            i = mDrawableSrc.bottom - mDrawableFloat.height();
            flag = flag1;
        }
        mDrawableFloat.offsetTo(j, i);
        if (flag)
        {
            invalidate();
        }
    }

    protected void configureBounds()
    {
        if (isFrist)
        {
            float f = (float)mDrawable.getIntrinsicWidth() / (float)mDrawable.getIntrinsicHeight();
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            if (f > (float)getWidth() / (float)getHeight())
            {
                j = getWidth() - mFloatDrawable.c();
                i = (int)((float)j / f);
            } else
            {
                i = getHeight() - mFloatDrawable.d();
                j = (int)((float)i * f);
            }
            k = (getWidth() - j) / 2;
            l = (getHeight() - i) / 2;
            i1 = k + j;
            j1 = l + i;
            mDrawableSrc.set(k, l, i1, j1);
            k1 = dipTopx(getContext(), 5F);
            mDrawableSrc.inset(k1, k1);
            mDrawableDst.set(mDrawableSrc);
            if (j > 240 && i > 240)
            {
                cropWidth = j / 2;
                cropHeight = i / 2;
            }
            mDrawableFloat.set(k + k1, l + k1, i1 - k1, j1 - k1);
            isFrist = false;
        }
        mDrawable.setBounds(mDrawableDst);
        mFloatDrawable.setBounds(mDrawableFloat);
    }

    public int dipTopx(Context context, float f)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f + 0.5F);
    }

    public Bitmap getCropImage()
    {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Object obj = new Canvas(bitmap);
        mDrawable.draw(((Canvas) (obj)));
        obj = new Matrix();
        float f = (float)mDrawableSrc.width() / (float)mDrawableDst.width();
        ((Matrix) (obj)).postScale(f, f);
        obj = Bitmap.createBitmap(bitmap, mDrawableFloat.left, mDrawableFloat.top, mDrawableFloat.width(), mDrawableFloat.height(), ((Matrix) (obj)), true);
        bitmap.recycle();
        return ((Bitmap) (obj));
    }

    public int getTouchEdge(int i, int j)
    {
        int i1 = mFloatDrawable.c();
        int j1 = mFloatDrawable.d();
        int k1 = mFloatDrawable.getBounds().left - i1;
        int i2 = mFloatDrawable.getBounds().top - j1;
        int k2 = mFloatDrawable.getBounds().right + i1;
        int i3 = mFloatDrawable.getBounds().bottom + j1;
        int k = i1 * 2 + k1;
        int l = j1 * 2 + i2;
        i1 = k2 - i1 * 2;
        j1 = i3 - j1 * 2;
        if (k1 <= i && i < k && i2 <= j && j < l)
        {
            return 1;
        }
        if (i1 <= i && i < k2 && i2 <= j && j < l)
        {
            return 2;
        }
        if (k1 <= i && i < k && j1 <= j && j < i3)
        {
            return 3;
        }
        if (i1 <= i && i < k2 && j1 <= j && j < i3)
        {
            return 4;
        }
        if (mFloatDrawable.e())
        {
            int l1 = (mFloatDrawable.getBounds().left + mFloatDrawable.getBounds().right) / 2;
            int j2 = (mFloatDrawable.getBounds().top + mFloatDrawable.getBounds().bottom) / 2;
            int l2 = mFloatDrawable.a() / 2;
            int j3 = mFloatDrawable.b();
            if (l1 - l2 <= i && j >= l - j3 && l1 + l2 > i && j < l + j3)
            {
                return 8;
            }
            if (l1 - l2 <= i && j >= j1 - j3 && l1 + l2 > i && j < j1 + j3)
            {
                return 9;
            }
            if (k - j3 <= i && j >= j2 - l2 && k + j3 > i && j < j2 + l2)
            {
                return 10;
            }
            if (i1 - j3 <= i && j >= j2 - l2 && i1 + j3 > i && j < j2 + l2)
            {
                return 11;
            }
        }
        return !mFloatDrawable.getBounds().contains(i, j) ? 6 : 5;
    }

    protected void onDraw(Canvas canvas)
    {
        while (mDrawable == null || mDrawable.getIntrinsicWidth() == 0 || mDrawable.getIntrinsicHeight() == 0) 
        {
            return;
        }
        configureBounds();
        mDrawable.draw(canvas);
        canvas.save();
        canvas.clipRect(mDrawableFloat, android.graphics.Region.Op.DIFFERENCE);
        canvas.drawRect(mDrawableSrc, mPaint);
        canvas.restore();
        mFloatDrawable.draw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() > 1)
        {
            if (mStatus == 1)
            {
                mStatus = 2;
                oldx_0 = motionevent.getX(0);
                oldy_0 = motionevent.getY(0);
                oldx_1 = motionevent.getX(1);
                oldy_1 = motionevent.getY(1);
            } else
            if (mStatus == 2)
            {
                mStatus = 3;
            }
        } else
        {
            if (mStatus == 2 || mStatus == 3)
            {
                oldx_0 = 0.0F;
                oldy_0 = 0.0F;
                oldx_1 = 0.0F;
                oldy_1 = 0.0F;
                oldX = motionevent.getX();
                oldY = motionevent.getY();
            }
            mStatus = 1;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 104
    //                   0 182
    //                   1 219
    //                   2 235
    //                   3 104
    //                   4 104
    //                   5 104
    //                   6 226;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
        return true;
_L2:
        oldX = motionevent.getX();
        oldY = motionevent.getY();
        currentEdge = getTouchEdge((int)oldX, (int)oldY);
        continue; /* Loop/switch isn't completed */
_L3:
        checkBounds();
        continue; /* Loop/switch isn't completed */
_L5:
        currentEdge = 7;
        continue; /* Loop/switch isn't completed */
_L4:
label0:
        {
            float f;
            float f1;
            float f2;
            float f3;
            int i;
            int k;
            int j2;
            int l2;
label1:
            {
                if (mStatus != 3)
                {
                    break label0;
                }
                f = motionevent.getX(0);
                f1 = motionevent.getY(0);
                f2 = motionevent.getX(1);
                f3 = motionevent.getY(1);
                float f4 = Math.abs(oldx_1 - oldx_0);
                float f5 = Math.abs(oldy_1 - oldy_0);
                float f6 = Math.abs(f2 - f);
                float f7 = Math.abs(f3 - f1);
                if (f6 + f7 <= 0.0F)
                {
                    continue; /* Loop/switch isn't completed */
                }
                int l1 = mDrawableFloat.centerX();
                int i1 = mDrawableFloat.centerY();
                if (floatRationWH > 0.0F)
                {
                    double d;
                    if (Math.abs(f7 - f5) > Math.abs(f6 - f4))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        d = f7 / f5;
                    } else
                    {
                        d = f6 / f4;
                    }
                    k = (int)(d * (double)mDrawableFloat.width());
                    i = (int)((float)k / floatRationWH);
                } else
                {
                    double d1 = Math.sqrt(f6 * f6 + f7 * f7) / Math.sqrt(f4 * f4 + f5 * f5);
                    k = (int)((double)mDrawableFloat.width() * d1);
                    i = (int)(d1 * (double)mDrawableFloat.height());
                }
                j2 = l1 - k / 2;
                l2 = i1 - i / 2;
                k = k / 2 + l1;
                i = i / 2 + i1;
                if (j2 <= mDrawable.getBounds().left)
                {
                    return true;
                }
                if (k >= mDrawable.getBounds().right)
                {
                    return true;
                }
                if (l2 <= mDrawable.getBounds().top)
                {
                    return true;
                }
                if (i >= mDrawable.getBounds().bottom)
                {
                    return true;
                }
                i1 = Math.abs(k - j2);
                getClass();
                if (i1 >= 120)
                {
                    int j1 = Math.abs(i - l2);
                    getClass();
                    if (j1 >= 120)
                    {
                        break label1;
                    }
                }
                return true;
            }
            mDrawableFloat.set(j2, l2, k, i);
            invalidate();
            oldx_0 = f;
            oldy_0 = f1;
            oldx_1 = f2;
            oldy_1 = f3;
            continue; /* Loop/switch isn't completed */
        }
        if (mStatus != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        int l = (int)(motionevent.getX() - oldX);
        int k1 = (int)(motionevent.getY() - oldY);
        boolean flag = mFloatDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY());
        Rect rect = new Rect(mDrawableFloat);
        oldX = motionevent.getX();
        oldY = motionevent.getY();
        if (l == 0 && k1 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j;
        int i2;
        int k2;
        int i3;
        if (5 != currentEdge && floatRationWH > 0.0F)
        {
            double d2;
            if (Math.abs(k1) > Math.abs(l))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                d2 = (float)k1 / (float)mDrawableFloat.height() + 1.0F;
            } else
            {
                d2 = 1.0F + (float)l / (float)mDrawableFloat.width();
            }
            l = (int)(d2 * (double)l);
            j = (int)((float)l / floatRationWH);
        } else
        {
            j = k1;
        }
        i2 = mDrawableFloat.left + l;
        i3 = mDrawableFloat.top + j;
        k1 = mDrawableFloat.right + l;
        k2 = mDrawableFloat.bottom + j;
        currentEdge;
        JVM INSTR tableswitch 1 11: default 964
    //                   1 1054
    //                   2 1112
    //                   3 1204
    //                   4 1296
    //                   5 1546
    //                   6 964
    //                   7 964
    //                   8 1354
    //                   9 1498
    //                   10 1450
    //                   11 1402;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L6 _L6 _L12 _L13 _L14 _L15
_L6:
        mDrawableFloat.sort();
        if (currentEdge == 5)
        {
            break; /* Loop/switch isn't completed */
        }
        j = mDrawableFloat.width();
        getClass();
        if (j >= 120)
        {
            j = mDrawableFloat.height();
            getClass();
            if (j >= 120)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        mDrawableFloat = rect;
        return true;
_L7:
        if (i2 >= mDrawable.getBounds().left && i3 >= mDrawable.getBounds().top)
        {
            mDrawableFloat.set(i2, i3, mDrawableFloat.right, mDrawableFloat.bottom);
        }
        continue; /* Loop/switch isn't completed */
_L8:
        i2 = mDrawableFloat.top;
        l = j;
        if (floatRationWH > 0.0F)
        {
            l = -j;
        }
        j = l + i2;
        if (k1 <= mDrawable.getBounds().right && j >= mDrawable.getBounds().top)
        {
            mDrawableFloat.set(mDrawableFloat.left, j, k1, mDrawableFloat.bottom);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        k1 = mDrawableFloat.bottom;
        l = j;
        if (floatRationWH > 0.0F)
        {
            l = -j;
        }
        j = l + k1;
        if (i2 >= mDrawable.getBounds().left && j <= mDrawable.getBounds().bottom)
        {
            mDrawableFloat.set(i2, mDrawableFloat.top, mDrawableFloat.right, j);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (k1 <= mDrawable.getBounds().right && k2 <= mDrawable.getBounds().bottom)
        {
            mDrawableFloat.set(mDrawableFloat.left, mDrawableFloat.top, k1, k2);
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (i3 >= mDrawable.getBounds().top)
        {
            mDrawableFloat.set(mDrawableFloat.left, i3, mDrawableFloat.right, mDrawableFloat.bottom);
        }
        continue; /* Loop/switch isn't completed */
_L15:
        if (k1 <= mDrawable.getBounds().right)
        {
            mDrawableFloat.set(mDrawableFloat.left, mDrawableFloat.top, k1, mDrawableFloat.bottom);
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (i2 >= mDrawable.getBounds().left)
        {
            mDrawableFloat.set(i2, mDrawableFloat.top, mDrawableFloat.right, mDrawableFloat.bottom);
        }
        continue; /* Loop/switch isn't completed */
_L13:
        if (k2 <= mDrawable.getBounds().bottom)
        {
            mDrawableFloat.set(mDrawableFloat.left, mDrawableFloat.top, mDrawableFloat.right, k2);
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (flag)
        {
            if (i2 <= mDrawable.getBounds().left || k1 >= mDrawable.getBounds().right)
            {
                l = 0;
            }
            if (i3 <= mDrawable.getBounds().top || k2 >= mDrawable.getBounds().bottom)
            {
                j = 0;
            }
            mDrawableFloat.offset(l, j);
        }
        if (true) goto _L6; else goto _L16
_L16:
        invalidate();
        if (true) goto _L1; else goto _L17
_L17:
    }

    public void setDrawable(Drawable drawable, int i, int j)
    {
        byte byte0 = 120;
        mDrawable = drawable;
        int k = i;
        if (i < 120)
        {
            k = 120;
        }
        cropWidth = k;
        if (j < 120)
        {
            i = byte0;
        } else
        {
            i = j;
        }
        cropHeight = i;
        isFrist = true;
        invalidate();
    }

    public void setFloatRationWH(float f)
    {
        floatRationWH = f;
        xm xm1 = mFloatDrawable;
        float f1;
        float f2;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        boolean flag;
        if (floatRationWH == 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        xm1.a(flag);
        j = getWidth();
        i = getHeight();
        i1 = j / 2;
        j1 = i / 2;
        f1 = (float)mDrawable.getIntrinsicWidth() / (float)mDrawable.getIntrinsicHeight();
        f2 = mContext.getResources().getDisplayMetrics().density;
        if (f1 > (float)getWidth() / (float)getHeight())
        {
            j = getWidth() - mFloatDrawable.c();
            i = (int)((float)j / f1);
        } else
        {
            i = getHeight() - mFloatDrawable.d();
            j = (int)((float)i * f1);
        }
        f1 = (float)j / (float)i;
        k = i;
        l = j;
        if (f > 0.0F)
        {
            if (f > f1)
            {
                k = (int)((float)j / f);
                l = j;
            } else
            {
                l = (int)((float)i * f);
                k = i;
            }
        }
        i = (l - 0) / 2;
        j = (k - 0) / 2;
        l = (l - 0) / 2;
        k = (k - 0) / 2;
        mDrawableFloat.set(i1 - i, j1 - j, l + i1, k + j1);
        mDrawableFloat.inset(dipTopx(getContext(), 5F), dipTopx(getContext(), 5F));
        invalidate();
    }
}
