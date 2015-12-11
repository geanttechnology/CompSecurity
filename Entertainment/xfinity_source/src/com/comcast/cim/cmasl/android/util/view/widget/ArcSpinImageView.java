// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

public class ArcSpinImageView extends ImageView
{

    private static final ColorStateList DEFAULT_BACKING_RING_COLOR = ColorStateList.valueOf(0x64000000);
    private static final ColorStateList DEFAULT_RING_COLOR = ColorStateList.valueOf(0xff000000);
    private static final int STATE_ANIMATING[];
    private boolean animating;
    Paint paint;
    private RectF rectF;
    private float ringAlpha;
    private ColorStateList ringBackingColor;
    private ColorStateList ringColor;
    private float ringStrokeWidth;
    private int sweep;

    private void setPaintForBacking()
    {
        paint.setColor(ringBackingColor.getColorForState(getDrawableState(), com.comcast.cim.cmasl.android.util.R.color.translucent_black));
        paint.setStrokeWidth(3F);
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
    }

    private void setPaintForRing()
    {
        updateRingColor();
        paint.setStrokeWidth(ringStrokeWidth);
        paint.setAlpha((int)(ringAlpha * 255F));
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    private void updateRingColor()
    {
        int i = ringColor.getColorForState(getDrawableState(), 0);
        paint.setColor(i);
        invalidate();
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        updateRingColor();
    }

    public float getRingAlpha()
    {
        return ringAlpha;
    }

    public int getSweep()
    {
        return sweep;
    }

    public int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 1);
        if (animating)
        {
            mergeDrawableStates(ai, STATE_ANIMATING);
        }
        return ai;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        rectF.top = ringStrokeWidth / 2.0F;
        rectF.bottom = (float)canvas.getHeight() - ringStrokeWidth / 2.0F;
        rectF.left = ringStrokeWidth / 2.0F;
        rectF.right = (float)canvas.getWidth() - ringStrokeWidth / 2.0F;
        setPaintForBacking();
        canvas.drawArc(rectF, 0.0F, 360F, false, paint);
        setPaintForRing();
        canvas.drawArc(rectF, -90F, sweep, false, paint);
    }

    public void setRingAlpha(float f)
    {
        ringAlpha = f;
        paint.setAlpha((int)(255F * f));
        invalidate();
        requestLayout();
    }

    public void setRingColor(ColorStateList colorstatelist)
    {
        ringColor = colorstatelist;
    }

    public void setSweep(int i)
    {
        sweep = i;
        invalidate();
        requestLayout();
    }

    static 
    {
        STATE_ANIMATING = (new int[] {
            com.comcast.cim.cmasl.android.util.R.attr.state_animating
        });
    }
}
