// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class RoundedAdImageView extends ImageView
{

    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    private float mBottomLeft;
    private float mBottomRight;
    private RoundRectShape mRoundRectShape;
    private float mTopLeft;
    private float mTopRight;
    private final Paint paint;

    public RoundedAdImageView(Context context)
    {
        super(context);
        paint = new Paint();
        setRoundcounterCount();
        mRoundRectShape = new RoundRectShape(new float[] {
            mTopLeft, mTopLeft, mTopRight, mTopRight, mBottomRight, mBottomRight, mBottomLeft, mBottomLeft
        }, null, null);
    }

    public RoundedAdImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        paint = new Paint();
        setRoundcounterCount();
        mRoundRectShape = new RoundRectShape(new float[] {
            mTopLeft, mTopLeft, mTopRight, mTopRight, mBottomRight, mBottomRight, mBottomLeft, mBottomLeft
        }, null, null);
    }

    private float DpToPx(float f)
    {
        return getContext().getResources().getDisplayMetrics().density * f;
    }

    private void setRoundcounterCount()
    {
        float f = DpToPx(11F);
        mBottomRight = f;
        mBottomLeft = f;
        mTopRight = f;
        mTopLeft = f;
    }

    protected void onDraw(Canvas canvas)
    {
        if ((BitmapDrawable)getDrawable() != null)
        {
            mBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
            mBitmapShader = new BitmapShader(mBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
            RectF rectf = new RectF(0.0F, 0.0F, getWidth(), getHeight());
            int i = mBitmap.getWidth();
            int j = mBitmap.getHeight();
            RectF rectf1 = new RectF(0.0F, 0.0F, i, j);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(rectf1, rectf, android.graphics.Matrix.ScaleToFit.FILL);
            mBitmapShader.setLocalMatrix(matrix);
            paint.setAntiAlias(true);
            paint.setShader(mBitmapShader);
            canvas.drawRoundRect(rectf, DpToPx(11F), DpToPx(11F), paint);
        }
    }
}
