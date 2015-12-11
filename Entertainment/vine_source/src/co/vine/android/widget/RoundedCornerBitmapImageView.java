// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedCornerBitmapImageView extends ImageView
{

    public Bitmap mCanvasBitmap;
    public int mRadius;

    public RoundedCornerBitmapImageView(Context context)
    {
        super(context);
    }

    public RoundedCornerBitmapImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RoundedCornerBitmapImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRadius = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.RoundedCornerImageView, i, 0).getDimensionPixelSize(0, 0);
    }

    public void draw(Canvas canvas)
    {
        Object obj = getDrawable();
        if (obj instanceof BitmapDrawable)
        {
            obj = ((BitmapDrawable)obj).getBitmap();
            int i = getMeasuredWidth();
            int j = getMeasuredHeight();
            if (mCanvasBitmap == null || i != mCanvasBitmap.getWidth() || j != mCanvasBitmap.getHeight())
            {
                if (mCanvasBitmap != null)
                {
                    mCanvasBitmap.recycle();
                }
                mCanvasBitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            }
            Canvas canvas1 = new Canvas(mCanvasBitmap);
            canvas1.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            super.draw(canvas1);
            if (obj != null)
            {
                BitmapShader bitmapshader = new BitmapShader(mCanvasBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setShader(bitmapshader);
                canvas.drawRoundRect(new RectF(0.0F, 0.0F, i, j), mRadius, mRadius, paint);
                return;
            } else
            {
                super.draw(canvas);
                return;
            }
        } else
        {
            super.draw(canvas);
            return;
        }
    }
}
