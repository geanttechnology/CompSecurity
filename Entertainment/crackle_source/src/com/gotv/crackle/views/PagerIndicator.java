// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PagerIndicator extends ImageView
{

    private static final int RECT_WIDTH = 36;
    private int mCurrentSelectedDot;
    private Bitmap mLastBitmap;
    private int mNumOfDots;

    public PagerIndicator(Context context)
    {
        super(context);
    }

    public PagerIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PagerIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void update()
    {
        if (mNumOfDots == 0) goto _L2; else goto _L1
_L1:
        if (mLastBitmap != null)
        {
            mLastBitmap.recycle();
            mLastBitmap = null;
        }
        Object obj;
        Paint paint;
        Canvas canvas;
        obj = Bitmap.createBitmap(mNumOfDots * 36, 36, android.graphics.Bitmap.Config.ARGB_8888);
        paint = new Paint();
        canvas = new Canvas(((Bitmap) (obj)));
        int i = 0;
_L3:
        if (i >= mNumOfDots)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        if (i != mCurrentSelectedDot)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        paint.setARGB(255, 255, 170, 0);
_L4:
        canvas.drawRect(i * 36, 0.0F, i * 36 + 36, 5F, paint);
        i++;
          goto _L3
        paint.setARGB(255, 0, 0, 0);
          goto _L4
        obj;
        if (mLastBitmap != null)
        {
            mLastBitmap.recycle();
            mLastBitmap = null;
        }
        System.gc();
_L2:
        return;
        mLastBitmap = ((Bitmap) (obj));
        setImageBitmap(((Bitmap) (obj)));
        return;
          goto _L3
    }

    public int getNumberOfPages()
    {
        return mNumOfDots;
    }

    public void setCurrentPage(int i)
    {
        mCurrentSelectedDot = i;
        update();
    }

    public void setNumberOfPages(int i)
    {
        mNumOfDots = i;
        update();
    }
}
