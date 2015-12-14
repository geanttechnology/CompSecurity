// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecorator extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private Paint backgroundPaint;
    private Path innerPath;
    private Path outerPath;
    private Paint pokerPaint;
    private int pokerWidth;
    private int spacingSize;

    public DividerItemDecorator(Context context)
    {
        pokerPaint = new Paint();
        pokerPaint.setColor(context.getResources().getColor(0x7f09007d));
        pokerPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        pokerPaint.setAntiAlias(true);
        backgroundPaint = new Paint();
        backgroundPaint.setColor(context.getResources().getColor(0x7f0900ab));
        backgroundPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        backgroundPaint.setAntiAlias(true);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        if (recyclerview.getItemAnimator() == null || !recyclerview.getItemAnimator().isRunning()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.onDrawOver(canvas, recyclerview, state);
        if ((recyclerview.getItemAnimator() == null || !recyclerview.getItemAnimator().isRunning()) && innerPath != null && outerPath != null)
        {
            int j = recyclerview.getChildCount();
            int i = 0;
            while (i < j) 
            {
                state = recyclerview.getChildAt(i);
                if (state.getTag(0x7f0c000e) == com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.DIVIDER && state.getRight() + pokerWidth < recyclerview.getWidth())
                {
                    canvas.save();
                    canvas.translate(state.getRight() - spacingSize / 2, state.getTop());
                    canvas.drawPath(outerPath, backgroundPaint);
                    canvas.drawPath(innerPath, pokerPaint);
                    canvas.restore();
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setPokerSize(int i, int j, int k)
    {
        pokerWidth = i;
        spacingSize = k;
        int l = k / 2;
        outerPath = new Path();
        outerPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        outerPath.moveTo(l, (float)j * 0.75F);
        outerPath.lineTo(i, (float)j * 0.75F + (float)(j / 2));
        outerPath.lineTo(l, (float)j * 1.75F);
        outerPath.close();
        innerPath = new Path();
        innerPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        innerPath.moveTo(l, (float)j * 0.75F + (float)k);
        innerPath.lineTo(i - k, (float)j * 0.75F + (float)(j / 2));
        innerPath.lineTo(l, (float)j * 1.75F - (float)k);
        innerPath.close();
    }
}
