// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.ArrayList;

public class FontSldeLineView extends ImageView
{

    private Paint mPaint;
    private Path mPath;

    public FontSldeLineView(Context context)
    {
        super(context);
        init();
    }

    public FontSldeLineView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(-1);
        mPaint.setStrokeWidth(2.0F);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPath = new Path();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    public void setPtArray(ArrayList arraylist)
    {
        mPath.reset();
        Point point = (Point)arraylist.get(0);
        mPath.moveTo(point.x, point.y);
        for (int i = 1; i < arraylist.size(); i++)
        {
            Point point1 = (Point)arraylist.get(i);
            mPath.lineTo(point1.x, point1.y);
        }

        mPath.close();
        invalidate();
    }
}
