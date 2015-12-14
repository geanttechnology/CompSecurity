// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import yp;

public class SlimFaceLineView extends ImageView
{

    private int bmpH;
    private int bmpW;
    private float brushSize;
    private Point firPt;
    private LineType linetype;
    private Bitmap mBmp;
    private Paint mPaint;
    private Path mPath;
    private Point secPt;

    public SlimFaceLineView(Context context)
    {
        super(context);
        linetype = LineType.SLIMFACE;
        mPath = new Path();
        brushSize = 1.0F;
        init();
    }

    public SlimFaceLineView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        linetype = LineType.SLIMFACE;
        mPath = new Path();
        brushSize = 1.0F;
        init();
    }

    private void init()
    {
        mPaint = new Paint();
        mPaint.setColor(-1);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(yp.a(getContext(), 1.0F));
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        firPt = new Point(100, 100);
        secPt = new Point(200, 200);
        mBmp = BitmapFactory.decodeResource(getResources(), 0x7f020306);
        bmpW = yp.a(getContext(), 45F);
        bmpH = yp.a(getContext(), 45F);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (linetype == LineType.SLIMFACE)
        {
            canvas.drawBitmap(mBmp, null, new Rect(firPt.x - bmpW / 2, firPt.y - bmpH / 2, firPt.x + bmpW / 2, firPt.y + bmpH / 2), mPaint);
            canvas.drawLine(firPt.x, firPt.y, secPt.x, secPt.y, mPaint);
            canvas.drawBitmap(mBmp, null, new Rect(secPt.x - bmpW / 2, secPt.y - bmpH / 2, secPt.x + bmpW / 2, secPt.y + bmpH / 2), mPaint);
        } else
        {
            if (linetype == LineType.EYEBAG)
            {
                canvas.drawPath(mPath, mPaint);
                return;
            }
            if (linetype == LineType.QUBAN)
            {
                canvas.drawBitmap(mBmp, null, new Rect(secPt.x - bmpW / 2, secPt.y - bmpH / 2, secPt.x + bmpW / 2, secPt.y + bmpH / 2), mPaint);
                return;
            }
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        android.view.View.MeasureSpec.getSize(i);
    }

    public void setBmpSize(float f)
    {
        if (linetype != LineType.SLIMFACE) goto _L2; else goto _L1
_L1:
        bmpW = (int)((float)yp.a(getContext(), 40F) * f);
        bmpH = (int)((float)yp.a(getContext(), 40F) * f);
        invalidate();
_L4:
        invalidate();
        return;
_L2:
        if (linetype == LineType.EYEBAG)
        {
            brushSize = f;
            mPaint.setStrokeWidth((float)yp.a(getContext(), 30F) * f);
            mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
            mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
            mPaint.setAlpha(100);
        } else
        if (linetype == LineType.QUBAN)
        {
            brushSize = f;
            bmpW = (int)((float)yp.a(getContext(), 20F) * f);
            bmpH = (int)((float)yp.a(getContext(), 20F) * f);
            invalidate();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setFirPt(Point point)
    {
        if (linetype != LineType.SLIMFACE) goto _L2; else goto _L1
_L1:
        firPt.set(point.x, point.y);
        secPt.set(firPt.x, firPt.y);
_L4:
        invalidate();
        return;
_L2:
        if (linetype == LineType.EYEBAG)
        {
            mPath.reset();
            mPath.moveTo(point.x, point.y);
        } else
        if (linetype == LineType.QUBAN)
        {
            firPt.set(point.x, point.y);
            secPt.set(firPt.x, firPt.y);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setLineType(LineType linetype1)
    {
        linetype = linetype1;
        invalidate();
    }

    public void setSecPt(Point point)
    {
        if (linetype != LineType.SLIMFACE) goto _L2; else goto _L1
_L1:
        secPt.set(point.x, point.y);
_L4:
        invalidate();
        return;
_L2:
        if (linetype == LineType.EYEBAG)
        {
            mPath.lineTo(point.x, point.y);
        } else
        if (linetype == LineType.QUBAN)
        {
            secPt.set(point.x, point.y);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private class LineType extends Enum
    {

        private static final LineType $VALUES[];
        public static final LineType EYEBAG;
        public static final LineType QUBAN;
        public static final LineType SLIMFACE;

        public static LineType valueOf(String s)
        {
            return (LineType)Enum.valueOf(com/fotoable/beautyui/SlimFaceLineView$LineType, s);
        }

        public static LineType[] values()
        {
            return (LineType[])$VALUES.clone();
        }

        static 
        {
            SLIMFACE = new LineType("SLIMFACE", 0);
            EYEBAG = new LineType("EYEBAG", 1);
            QUBAN = new LineType("QUBAN", 2);
            $VALUES = (new LineType[] {
                SLIMFACE, EYEBAG, QUBAN
            });
        }

        private LineType(String s, int i)
        {
            super(s, i);
        }
    }

}
