// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;

// Referenced classes of package com.facebook.drawee.drawable:
//            ForwardingDrawable, Rounded

public class RoundedCornersDrawable extends ForwardingDrawable
    implements Rounded
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type CLIPPING;
        public static final Type OVERLAY_COLOR;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/facebook/drawee/drawable/RoundedCornersDrawable$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            OVERLAY_COLOR = new Type("OVERLAY_COLOR", 0);
            CLIPPING = new Type("CLIPPING", 1);
            $VALUES = (new Type[] {
                OVERLAY_COLOR, CLIPPING
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    int mBorderColor;
    float mBorderWidth;
    boolean mIsCircle;
    int mOverlayColor;
    final Paint mPaint = new Paint(1);
    private final Path mPath = new Path();
    final float mRadii[] = new float[8];
    private final RectF mTempRectangle = new RectF();
    Type mType;

    public RoundedCornersDrawable(Drawable drawable)
    {
        super((Drawable)Preconditions.checkNotNull(drawable));
        mType = Type.OVERLAY_COLOR;
        mIsCircle = false;
        mBorderWidth = 0.0F;
        mBorderColor = 0;
        mOverlayColor = 0;
    }

    private void updatePath()
    {
        mPath.reset();
        mTempRectangle.set(getBounds());
        mTempRectangle.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
        if (mIsCircle)
        {
            mPath.addCircle(mTempRectangle.centerX(), mTempRectangle.centerY(), Math.min(mTempRectangle.width(), mTempRectangle.height()) / 2.0F, android.graphics.Path.Direction.CW);
        } else
        {
            mPath.addRoundRect(mTempRectangle, mRadii, android.graphics.Path.Direction.CW);
        }
        mTempRectangle.inset(-mBorderWidth / 2.0F, -mBorderWidth / 2.0F);
    }

    public void draw(Canvas canvas)
    {
        Rect rect = getBounds();
        static class _cls1
        {

            static final int $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[];

            static 
            {
                $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = new int[Type.values().length];
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[Type.CLIPPING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[Type.OVERLAY_COLOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.facebook.drawee.drawable.RoundedCornersDrawable.Type[mType.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 102
    //                   2 141;
           goto _L1 _L2 _L3
_L1:
        if (mBorderColor != 0)
        {
            mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            mPaint.setColor(mBorderColor);
            mPaint.setStrokeWidth(mBorderWidth);
            mPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            canvas.drawPath(mPath, mPaint);
        }
        return;
_L2:
        int i = canvas.save();
        mPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        canvas.clipPath(mPath);
        super.draw(canvas);
        canvas.restoreToCount(i);
        continue; /* Loop/switch isn't completed */
_L3:
        super.draw(canvas);
        mPaint.setColor(mOverlayColor);
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
        mPath.setFillType(android.graphics.Path.FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(mPath, mPaint);
        if (mIsCircle)
        {
            float f = ((float)(rect.width() - rect.height()) + mBorderWidth) / 2.0F;
            float f1 = ((float)(rect.height() - rect.width()) + mBorderWidth) / 2.0F;
            if (f > 0.0F)
            {
                canvas.drawRect(rect.left, rect.top, (float)rect.left + f, rect.bottom, mPaint);
                canvas.drawRect((float)rect.right - f, rect.top, rect.right, rect.bottom, mPaint);
            }
            if (f1 > 0.0F)
            {
                canvas.drawRect(rect.left, rect.top, rect.right, (float)rect.top + f1, mPaint);
                canvas.drawRect(rect.left, (float)rect.bottom - f1, rect.right, rect.bottom, mPaint);
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        updatePath();
    }

    public void setBorder(int i, float f)
    {
        mBorderColor = i;
        mBorderWidth = f;
        updatePath();
        invalidateSelf();
    }

    public void setCircle(boolean flag)
    {
        mIsCircle = flag;
        updatePath();
        invalidateSelf();
    }

    public void setOverlayColor(int i)
    {
        mOverlayColor = i;
        invalidateSelf();
    }

    public void setRadii(float af[])
    {
        if (af == null)
        {
            Arrays.fill(mRadii, 0.0F);
        } else
        {
            boolean flag;
            if (af.length == 8)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "radii should have exactly 8 values");
            System.arraycopy(af, 0, mRadii, 0, 8);
        }
        updatePath();
        invalidateSelf();
    }

    public void setRadius(float f)
    {
        Arrays.fill(mRadii, f);
        updatePath();
        invalidateSelf();
    }

    public void setType(Type type)
    {
        mType = type;
        invalidateSelf();
    }
}
