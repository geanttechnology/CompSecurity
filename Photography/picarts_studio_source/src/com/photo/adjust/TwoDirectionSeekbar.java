// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.adjust;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.picsart.studio.view.FloatSeekBar;

public class TwoDirectionSeekbar extends FloatSeekBar
{

    private Rect c;
    private Paint d;
    private Bitmap e;
    private int f;
    private Context g;

    public TwoDirectionSeekbar(Context context)
    {
        super(context);
        g = context;
    }

    public TwoDirectionSeekbar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        g = context;
        c = new Rect();
        d = new Paint();
        f = 6;
        e = BitmapFactory.decodeResource(context.getResources(), 0x7f020614);
    }

    public TwoDirectionSeekbar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        c.set(getThumbOffset(), getHeight() / 2 - f / 4, getWidth() - getThumbOffset(), getHeight() / 2 + f / 4);
        d.setColor(0xff888888);
        canvas.drawRect(c, d);
        int i = getWidth();
        int j = getHeight();
        canvas.drawBitmap(e, i / 2 - e.getWidth() / 2, j / 2 - e.getHeight() / 2, null);
        if (getProgress() > 500)
        {
            c.set(getWidth() / 2, getHeight() / 2 - f / 2, (getWidth() / 2 + (getWidth() * (getProgress() - 500)) / 1000) - ((getProgress() - 500) * getThumbOffset()) / 500, getHeight() / 2 + f / 2);
            d.setColor(g.getResources().getColor(0x7f0f0007));
            canvas.drawRect(c, d);
        }
        if (getProgress() < 500)
        {
            c.set((getWidth() / 2 - (getWidth() * (500 - getProgress())) / 1000) + ((500 - getProgress()) * getThumbOffset()) / 500, getHeight() / 2 - f / 2, getWidth() / 2, getHeight() / 2 + f / 2);
            d.setColor(g.getResources().getColor(0x7f0f0007));
            canvas.drawRect(c, d);
        }
        super.onDraw(canvas);
        this;
        JVM INSTR monitorexit ;
        return;
        canvas;
        throw canvas;
    }
}
