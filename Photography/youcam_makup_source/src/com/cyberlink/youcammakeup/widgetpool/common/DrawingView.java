// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.ah;

public class DrawingView extends View
{

    Bitmap a;
    Canvas b;
    Paint c;
    private Paint d;
    private drawMode e;

    public DrawingView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        e = drawMode.a;
        a();
    }

    public void a()
    {
        c = new Paint();
        c.setColor(0xffff0000);
        c.setAlpha(80);
        d = new Paint();
        d.setStyle(android.graphics.Paint.Style.FILL);
        d.setColor(0xffff0000);
        d.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OUT));
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        canvas.drawBitmap(a, 0.0F, 0.0F, c);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        a = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        b = new Canvas(a);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        ah.a().a(motionevent, Boolean.valueOf(false));
        return true;
    }

    public void setDrawMode(drawMode drawmode)
    {
        e = drawmode;
    }

    private class drawMode extends Enum
    {

        public static final drawMode a;
        public static final drawMode b;
        private static final drawMode c[];

        public static drawMode valueOf(String s)
        {
            return (drawMode)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/DrawingView$drawMode, s);
        }

        public static drawMode[] values()
        {
            return (drawMode[])c.clone();
        }

        static 
        {
            a = new drawMode("FOREGROUND", 0);
            b = new drawMode("BACKGROUND", 1);
            c = (new drawMode[] {
                a, b
            });
        }

        private drawMode(String s, int i)
        {
            super(s, i);
        }
    }

}
