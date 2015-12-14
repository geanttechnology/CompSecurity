// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import ew;

public class TTieZhiHandleView extends View
{

    public static int kDefaultEditBtnWidth = 40;
    PointF deleteCenterF;
    Drawable deleteDrawable;
    PointF flipCenterF;
    Drawable flipDrawable;
    boolean isNeedDraw;
    PointF lbCenterF;
    private Paint mBKPaint;
    private PointF mForeHeadPoint;
    PointF rotateCenterF;
    Drawable rotateDrawable;

    public TTieZhiHandleView(Context context)
    {
        super(context);
        deleteDrawable = null;
        rotateDrawable = null;
        flipDrawable = null;
        isNeedDraw = false;
        init(context);
    }

    public TTieZhiHandleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        deleteDrawable = null;
        rotateDrawable = null;
        flipDrawable = null;
        isNeedDraw = false;
        init(context);
    }

    public TTieZhiHandleView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        deleteDrawable = null;
        rotateDrawable = null;
        flipDrawable = null;
        isNeedDraw = false;
        init(context);
    }

    private void init(Context context)
    {
        deleteDrawable = context.getResources().getDrawable(0x7f02006d);
        rotateDrawable = context.getResources().getDrawable(0x7f0200a0);
        flipDrawable = context.getResources().getDrawable(0x7f020079);
        mBKPaint = new Paint(1);
        int i = (int)getContext().getResources().getDimension(0x7f08002c);
        mBKPaint.setStrokeWidth(i);
        mBKPaint.setColor(Color.parseColor("#ffffffff"));
        mBKPaint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public Rect getEditRectByCenterF(PointF pointf)
    {
        Rect rect = new Rect();
        float f = (float)kDefaultEditBtnWidth * ew.c(getContext());
        rect.left = (int)(pointf.x - f / 2.0F);
        rect.right = (int)(pointf.x + f / 2.0F);
        rect.top = (int)(pointf.y - f / 2.0F);
        float f1 = pointf.y;
        rect.bottom = (int)(f / 2.0F + f1);
        return rect;
    }

    public boolean isDeleteButtonClicked(int i, int j)
    {
        Rect rect = deleteDrawable.getBounds();
        rect.inset(rect.width() / 4, rect.width() / 4);
        return rect.contains(i, j);
    }

    public boolean isFlipButtonClicked(int i, int j)
    {
        Rect rect = flipDrawable.getBounds();
        rect.inset(rect.width() / 4, rect.width() / 4);
        return rect.contains(i, j);
    }

    public boolean isRotateButtonClicked(int i, int j)
    {
        Rect rect = rotateDrawable.getBounds();
        rect.inset(rect.width() / 4, rect.width() / 4);
        return rect.contains(i, j);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isNeedDraw)
        {
            canvas.drawLine(deleteCenterF.x, deleteCenterF.y, flipCenterF.x, flipCenterF.y, mBKPaint);
            canvas.drawLine(flipCenterF.x, flipCenterF.y, rotateCenterF.x, rotateCenterF.y, mBKPaint);
            canvas.drawLine(rotateCenterF.x, rotateCenterF.y, lbCenterF.x, lbCenterF.y, mBKPaint);
            canvas.drawLine(lbCenterF.x, lbCenterF.y, deleteCenterF.x, deleteCenterF.y, mBKPaint);
            Rect rect = getEditRectByCenterF(deleteCenterF);
            deleteDrawable.setBounds(rect);
            deleteDrawable.draw(canvas);
            rect = getEditRectByCenterF(rotateCenterF);
            rotateDrawable.setBounds(rect);
            rotateDrawable.draw(canvas);
            rect = getEditRectByCenterF(flipCenterF);
            flipDrawable.setBounds(rect);
            flipDrawable.draw(canvas);
        }
    }

    public void redrawView()
    {
        invalidate();
    }

    public void setDeleteCenter(PointF pointf)
    {
        deleteCenterF = pointf;
    }

    public void setFlipCenter(PointF pointf)
    {
        flipCenterF = pointf;
    }

    public void setForeHeadPoint(PointF pointf)
    {
        mForeHeadPoint = pointf;
    }

    public void setLBCenter(PointF pointf)
    {
        lbCenterF = pointf;
    }

    public void setNeedDraw(boolean flag)
    {
        isNeedDraw = flag;
    }

    public void setRotateCenter(PointF pointf)
    {
        rotateCenterF = pointf;
    }

}
