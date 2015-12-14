// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkImageView

public class RoundedImageView extends LinkImageView
{

    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    private float mBottomLeft;
    private float mBottomRight;
    private RoundRectShape mRoundRectShape;
    private float mTopLeft;
    private float mTopRight;
    private final Paint paint;

    public RoundedImageView(Context context)
    {
        super(context);
        mTopLeft = 0.0F;
        mTopRight = 0.0F;
        mBottomRight = 0.0F;
        mBottomLeft = 0.0F;
        paint = new Paint();
        setLayerType(2, null);
    }

    public RoundedImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mTopLeft = 0.0F;
        mTopRight = 0.0F;
        mBottomRight = 0.0F;
        mBottomLeft = 0.0F;
        paint = new Paint();
        setLayerType(2, null);
        getAttributes(context, attributeset);
    }

    public RoundedImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mTopLeft = 0.0F;
        mTopRight = 0.0F;
        mBottomRight = 0.0F;
        mBottomLeft = 0.0F;
        paint = new Paint();
        setLayerType(2, null);
        getAttributes(context, attributeset);
    }

    private void getAttributes(Context context, AttributeSet attributeset)
    {
        context = getContext().obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.RoundedImageView);
        mTopLeft = context.getDimensionPixelSize(0, 0);
        mTopRight = context.getDimensionPixelSize(1, 0);
        mBottomLeft = context.getDimensionPixelSize(2, 0);
        mBottomRight = context.getDimensionPixelSize(3, 0);
        mRoundRectShape = new RoundRectShape(new float[] {
            mTopLeft, mTopLeft, mTopRight, mTopRight, mBottomRight, mBottomRight, mBottomLeft, mBottomLeft
        }, null, null);
    }

    public float getBottomLeftRadius()
    {
        return mBottomLeft;
    }

    public float getBottomRightRadius()
    {
        return mBottomRight;
    }

    public float getTopLeftRadius()
    {
        return mTopLeft;
    }

    public float getTopRightRadius()
    {
        return mTopRight;
    }

    protected void onDraw(Canvas canvas)
    {
        if ((BitmapDrawable)getDrawable() != null)
        {
            mBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
            mBitmapShader = new BitmapShader(mBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        }
        paint.setAntiAlias(true);
        paint.setShader(mBitmapShader);
        mRoundRectShape.resize(getWidth(), getHeight());
        mRoundRectShape.draw(canvas, paint);
    }

    public void setBottomLeftRadius(float f)
    {
        mBottomLeft = f;
    }

    public void setBottomRightRadius(float f)
    {
        mBottomRight = f;
    }

    public void setTopLeftRadius(float f)
    {
        mTopLeft = f;
    }

    public void setTopRightRadius(float f)
    {
        mTopRight = f;
    }
}
