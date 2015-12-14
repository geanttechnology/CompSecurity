// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;

// Referenced classes of package com.mopub.nativeads:
//            NativeFullScreenVideoView

static class mCornerRadiusPx extends Drawable
{

    private final RectF mButtonRect;
    final int mCornerRadiusPx;
    private final Paint mPaint;

    public void draw(Canvas canvas)
    {
        mButtonRect.set(getBounds());
        canvas.drawRoundRect(mButtonRect, mCornerRadiusPx, mCornerRadiusPx, mPaint);
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

    (Context context)
    {
        this(context, new RectF(), new Paint());
    }

    <init>(Context context, RectF rectf, Paint paint)
    {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(rectf);
        Preconditions.checkNotNull(paint);
        mButtonRect = rectf;
        mPaint = paint;
        mPaint.setColor(0xff000000);
        mPaint.setAlpha(128);
        mPaint.setAntiAlias(true);
        mCornerRadiusPx = Dips.asIntPixels(5F, context);
    }
}
