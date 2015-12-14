// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.text:
//            Cue, CaptionStyleCompat

final class CuePainter
{

    private static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08F;
    private static final float INNER_PADDING_RATIO = 0.125F;
    private static final float LINE_HEIGHT_FRACTION = 0.0533F;
    private static final String TAG = "CuePainter";
    private int backgroundColor;
    private final float cornerRadius;
    private android.text.Layout.Alignment cueAlignment;
    private int cuePosition;
    private CharSequence cueText;
    private int edgeColor;
    private int edgeType;
    private int foregroundColor;
    private final RectF lineBounds = new RectF();
    private final float outlineWidth;
    private final Paint paint = new Paint();
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint = new TextPaint();
    private int textTop;
    private int windowColor;

    public CuePainter(Context context)
    {
        TypedArray typedarray = context.obtainStyledAttributes(null, new int[] {
            0x1010217, 0x1010218
        }, 0, 0);
        spacingAdd = typedarray.getDimensionPixelSize(0, 0);
        spacingMult = typedarray.getFloat(1, 1.0F);
        typedarray.recycle();
        int i = Math.round((2.0F * (float)context.getResources().getDisplayMetrics().densityDpi) / 160F);
        cornerRadius = i;
        outlineWidth = i;
        shadowRadius = i;
        shadowOffset = i;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.FILL);
    }

    private void drawLayout(Canvas canvas)
    {
        StaticLayout staticlayout;
        int i1;
        staticlayout = textLayout;
        if (staticlayout == null)
        {
            return;
        }
        i1 = canvas.save();
        canvas.translate(textLeft, textTop);
        if (Color.alpha(windowColor) > 0)
        {
            paint.setColor(windowColor);
            canvas.drawRect(-textPaddingX, 0.0F, staticlayout.getWidth() + textPaddingX, staticlayout.getHeight(), paint);
        }
        if (Color.alpha(backgroundColor) > 0)
        {
            paint.setColor(backgroundColor);
            float f = staticlayout.getLineTop(0);
            int k = staticlayout.getLineCount();
            for (int i = 0; i < k; i++)
            {
                lineBounds.left = staticlayout.getLineLeft(i) - (float)textPaddingX;
                lineBounds.right = staticlayout.getLineRight(i) + (float)textPaddingX;
                lineBounds.top = f;
                lineBounds.bottom = staticlayout.getLineBottom(i);
                f = lineBounds.bottom;
                canvas.drawRoundRect(lineBounds, cornerRadius, cornerRadius, paint);
            }

        }
        if (edgeType != 1) goto _L2; else goto _L1
_L1:
        textPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        textPaint.setStrokeWidth(outlineWidth);
        textPaint.setColor(edgeColor);
        textPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        staticlayout.draw(canvas);
_L4:
        textPaint.setColor(foregroundColor);
        textPaint.setStyle(android.graphics.Paint.Style.FILL);
        staticlayout.draw(canvas);
        textPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        canvas.restoreToCount(i1);
        return;
_L2:
        if (edgeType == 2)
        {
            textPaint.setShadowLayer(shadowRadius, shadowOffset, shadowOffset, edgeColor);
        } else
        if (edgeType == 3 || edgeType == 4)
        {
            float f1;
            int j;
            int l;
            if (edgeType == 3)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            if (l != 0)
            {
                j = -1;
            } else
            {
                j = edgeColor;
            }
            if (l != 0)
            {
                l = edgeColor;
            } else
            {
                l = -1;
            }
            f1 = shadowRadius / 2.0F;
            textPaint.setColor(foregroundColor);
            textPaint.setStyle(android.graphics.Paint.Style.FILL);
            textPaint.setShadowLayer(shadowRadius, -f1, -f1, j);
            staticlayout.draw(canvas);
            textPaint.setShadowLayer(shadowRadius, f1, f1, l);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void draw(Cue cue, CaptionStyleCompat captionstylecompat, float f, Canvas canvas, int i, int j, int k, 
            int l)
    {
        if (TextUtils.isEmpty(cue.text))
        {
            return;
        }
        if (TextUtils.equals(cueText, cue.text) && cuePosition == cue.position && Util.areEqual(cueAlignment, cue.alignment) && foregroundColor == captionstylecompat.foregroundColor && backgroundColor == captionstylecompat.backgroundColor && windowColor == captionstylecompat.windowColor && edgeType == captionstylecompat.edgeType && edgeColor == captionstylecompat.edgeColor && Util.areEqual(textPaint.getTypeface(), captionstylecompat.typeface) && parentLeft == i && parentTop == j && parentRight == k && parentBottom == l)
        {
            drawLayout(canvas);
            return;
        }
        cueText = cue.text;
        cuePosition = cue.position;
        cueAlignment = cue.alignment;
        foregroundColor = captionstylecompat.foregroundColor;
        backgroundColor = captionstylecompat.backgroundColor;
        windowColor = captionstylecompat.windowColor;
        edgeType = captionstylecompat.edgeType;
        edgeColor = captionstylecompat.edgeColor;
        textPaint.setTypeface(captionstylecompat.typeface);
        parentLeft = i;
        parentTop = j;
        parentRight = k;
        parentBottom = l;
        int k1 = parentRight - parentLeft;
        l = parentBottom - parentTop;
        f = 0.0533F * (float)l * f;
        textPaint.setTextSize(f);
        int i1 = (int)(0.125F * f + 0.5F);
        i = k1 - i1 * 2;
        if (i <= 0)
        {
            Log.w("CuePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        int j1;
        if (cueAlignment == null)
        {
            captionstylecompat = android.text.Layout.Alignment.ALIGN_CENTER;
        } else
        {
            captionstylecompat = cueAlignment;
        }
        textLayout = new StaticLayout(cueText, textPaint, i, captionstylecompat, spacingMult, spacingAdd, true);
        j1 = textLayout.getHeight();
        j = 0;
        k = textLayout.getLineCount();
        for (i = 0; i < k; i++)
        {
            j = Math.max((int)Math.ceil(textLayout.getLineWidth(i)), j);
        }

        int l1 = j + i1 * 2;
        i = (k1 - l1) / 2;
        j = i + l1;
        k = parentBottom - j1 - (int)((float)l * 0.08F);
        if (cue.position != -1)
        {
            if (cue.alignment == android.text.Layout.Alignment.ALIGN_OPPOSITE)
            {
                j = (cue.position * k1) / 100 + parentLeft;
                i = Math.max(j - l1, parentLeft);
            } else
            {
                i = (cue.position * k1) / 100 + parentLeft;
                j = Math.min(i + l1, parentRight);
            }
        }
        if (cue.line != -1)
        {
            l = (cue.line * l) / 100 + parentTop;
            k = l;
            if (l + j1 > parentBottom)
            {
                k = parentBottom - j1;
                l = parentBottom;
            }
        }
        textLayout = new StaticLayout(cueText, textPaint, j - i, captionstylecompat, spacingMult, spacingAdd, true);
        textLeft = i;
        textTop = k;
        textPaddingX = i1;
        drawLayout(canvas);
    }
}
