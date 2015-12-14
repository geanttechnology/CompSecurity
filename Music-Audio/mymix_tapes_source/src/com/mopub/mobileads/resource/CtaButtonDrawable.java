// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.util.Dips;

// Referenced classes of package com.mopub.mobileads.resource:
//            BaseWidgetDrawable

public class CtaButtonDrawable extends BaseWidgetDrawable
{

    private final Paint mBackgroundPaint = new Paint();
    private final int mButtonCornerRadius;
    private final RectF mButtonRect = new RectF();
    private String mCtaText;
    private final Paint mOutlinePaint = new Paint();
    private final Paint mTextPaint = new Paint();
    private final Rect mTextRect = new Rect();

    public CtaButtonDrawable(Context context)
    {
        int i = Dips.dipsToIntPixels(2.0F, context);
        float f = Dips.dipsToFloatPixels(20F, context);
        mBackgroundPaint.setColor(0xff000000);
        mBackgroundPaint.setAlpha(51);
        mBackgroundPaint.setStyle(DrawableConstants.CtaButton.BACKGROUND_STYLE);
        mBackgroundPaint.setAntiAlias(true);
        mOutlinePaint.setColor(-1);
        mOutlinePaint.setAlpha(51);
        mOutlinePaint.setStyle(DrawableConstants.CtaButton.OUTLINE_STYLE);
        mOutlinePaint.setStrokeWidth(i);
        mOutlinePaint.setAntiAlias(true);
        mTextPaint.setColor(-1);
        mTextPaint.setTextAlign(DrawableConstants.CtaButton.TEXT_ALIGN);
        mTextPaint.setTypeface(DrawableConstants.CtaButton.TEXT_TYPEFACE);
        mTextPaint.setTextSize(f);
        mTextPaint.setAntiAlias(true);
        mCtaText = "Learn More";
        mButtonCornerRadius = Dips.dipsToIntPixels(6F, context);
    }

    public void draw(Canvas canvas)
    {
        mButtonRect.set(getBounds());
        canvas.drawRoundRect(mButtonRect, mButtonCornerRadius, mButtonCornerRadius, mBackgroundPaint);
        canvas.drawRoundRect(mButtonRect, mButtonCornerRadius, mButtonCornerRadius, mOutlinePaint);
        drawTextWithinBounds(canvas, mTextPaint, mTextRect, mCtaText);
    }

    public String getCtaText()
    {
        return mCtaText;
    }

    public void setCtaText(String s)
    {
        mCtaText = s;
        invalidateSelf();
    }
}
