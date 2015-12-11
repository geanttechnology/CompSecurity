// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;

public class ProgressRing extends ProgressBar
{

    private final Path backgroundPath;
    private RectF ovalArea;
    private final Paint progressBarBackgroundPaint;
    private final Paint progressBarPaint;
    private final Path progressPath;
    private final float startAngle;
    private final float sweepAngle;
    private RectF totalArea;

    public ProgressRing(Context context)
    {
        this(context, null);
    }

    public ProgressRing(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, Resources.getSystem().getIdentifier("progressBarStyleHorizontal", "attr", "android"));
        backgroundPath = new Path();
        progressPath = new Path();
        context = context.getTheme().obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.ProgressRing, 0, 0);
        float f;
        int i;
        int j;
        attributeset = getResources();
        i = context.getColor(2, attributeset.getColor(0x7f0d00a5));
        j = context.getColor(3, attributeset.getColor(0x7f0d00a6));
        f = context.getFloat(4, attributeset.getInteger(0x7f0c0012));
        startAngle = Math.max(0.0F, Math.min(360F, context.getFloat(0, attributeset.getInteger(0x7f0c0011))));
        sweepAngle = Math.max(0.0F, Math.min(360F, context.getFloat(1, attributeset.getInteger(0x7f0c0013))));
        context.recycle();
        progressBarPaint = new Paint(1);
        progressBarPaint.setStrokeWidth(TypedValue.applyDimension(1, f, getResources().getDisplayMetrics()));
        progressBarPaint.setColor(i);
        progressBarPaint.setStyle(android.graphics.Paint.Style.STROKE);
        progressBarPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        progressBarBackgroundPaint = new Paint(progressBarPaint);
        progressBarBackgroundPaint.setColor(j);
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public ProgressRing(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset);
    }

    private void generatePaths()
    {
        this;
        JVM INSTR monitorenter ;
        if (ovalArea == null) goto _L2; else goto _L1
_L1:
        RectF rectf = totalArea;
        if (rectf != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        float f;
        float f1;
        progressPath.reset();
        backgroundPath.reset();
        f = getProgress();
        f1 = getMax();
        if (f <= 0.0F || f1 <= 0.0F)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        float f2;
        f2 = sweepAngle * (f / f1);
        progressPath.addArc(ovalArea, startAngle, f2);
        if (f == f1) goto _L2; else goto _L4
_L4:
        backgroundPath.addArc(ovalArea, startAngle + f2, sweepAngle - f2);
          goto _L2
        Exception exception;
        exception;
        throw exception;
        backgroundPath.addArc(ovalArea, startAngle, sweepAngle);
          goto _L2
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(backgroundPath, progressBarBackgroundPaint);
        canvas.drawPath(progressPath, progressBarPaint);
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        int k;
        int l;
        k = android.view.View.MeasureSpec.getMode(i);
        l = android.view.View.MeasureSpec.getMode(j);
        boolean flag;
        if (k != 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L1
_L5:
        if (!flag || flag1) goto _L3; else goto _L2
_L2:
        i = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(i, i);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        flag1 = false;
        break; /* Loop/switch isn't completed */
_L3:
        if (!flag1 || flag)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        i = android.view.View.MeasureSpec.getSize(i);
        setMeasuredDimension(i, i);
          goto _L4
        Exception exception;
        exception;
        throw exception;
        super.onMeasure(i, j);
          goto _L4
_L1:
        if (l == 0x40000000) goto _L6; else goto _L5
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        totalArea = new RectF(0.0F, 0.0F, i, j);
        float f2 = Math.min(i, j);
        ovalArea = new RectF(0.0F, 0.0F, f2, f2);
        float f = progressBarPaint.getStrokeWidth() / 2.0F;
        ovalArea.left = f;
        ovalArea.top = f;
        RectF rectf = ovalArea;
        rectf.right = rectf.right - f;
        rectf = ovalArea;
        rectf.bottom = rectf.bottom - f;
        float f1 = 0.0F;
        f = 0.0F;
        if (f2 == (float)i)
        {
            f1 = (totalArea.bottom - ovalArea.bottom) / 2.0F;
        } else
        {
            f = (totalArea.right - ovalArea.right) / 2.0F;
        }
        ovalArea.offset(f, f1);
        generatePaths();
    }

    public void setProgress(int i)
    {
        this;
        JVM INSTR monitorenter ;
        super.setProgress(i);
        generatePaths();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
