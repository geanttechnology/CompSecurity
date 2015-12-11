// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ag, q, c, o

final class u extends ag
{

    boolean a;

    public u(String s, o o1)
    {
        F = s;
        G = o1;
        b();
        q.b().addContentView(this, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
    }

    final void a()
    {
        Display display = q.b().getWindowManager().getDefaultDisplay();
        int i = display.getWidth();
        int j = display.getHeight();
        double d;
        double d1;
        double d2;
        if (p)
        {
            d = 12D;
        } else
        {
            d = 16D;
        }
        y = (i - c.f) / 2;
        z = (j - c.g) / 2 - 80;
        A = y + c.f / 2;
        B = z + c.g / 2;
        i = z;
        d1 = c.g;
        d2 = this.j.g;
        E = (int)(d1 - (d * r + d2)) + i;
        C = A - this.j.f / 2;
    }

    public final void onDraw(Canvas canvas)
    {
        a();
        int j = ((int)(System.currentTimeMillis() - x) * 255) / 1000;
        int i = j;
        if (j > 128)
        {
            i = 128;
        }
        canvas.drawARGB(i, 0, 0, 0);
        c.a(canvas, y, z);
        j = ((int)ag.v.getTextSize() * 3) / 2;
        int k = G.h();
        if (k == G.g() || k == 0)
        {
            a(F, "video. You earned");
            if (u)
            {
                a("Thanks for watching the sponsored", A, (int)((double)B - (double)j * 2.5D), canvas);
                a((new StringBuilder("video. You earned ")).append(s).append(".").toString(), A, (int)((double)B - (double)j * 1.5D), canvas);
            } else
            {
                a("Thanks for watching the sponsored", A, (int)((double)B - (double)j * 2.7999999999999998D), canvas);
                a((new StringBuilder("video. You earned ")).append(s).toString(), A, (int)((double)B - (double)j * 2.0499999999999998D), canvas);
                a((new StringBuilder()).append(t).append(".").toString(), A, (int)((double)B - (double)j * 1.3D), canvas);
            }
        } else
        {
            a(F, "to earn ");
            String s;
            if (k == 1)
            {
                s = "video";
            } else
            {
                s = "videos";
            }
            if (u)
            {
                a((new StringBuilder("Thank you. Watch ")).append(k).append(" more ").append(s).toString(), A, (int)((double)B - (double)j * 2.5D), canvas);
                a((new StringBuilder("to earn ")).append(s).append(".").toString(), A, (int)((double)B - (double)j * 1.5D), canvas);
            } else
            {
                a((new StringBuilder("Thank you. Watch ")).append(k).append(" more ").append(s).toString(), A, (int)((double)B - (double)j * 2.7999999999999998D), canvas);
                a((new StringBuilder("to earn ")).append(s).toString(), A, (int)((double)B - (double)j * 2.0499999999999998D), canvas);
                a((new StringBuilder()).append(t).append(".").toString(), A, (int)((double)B - (double)j * 1.3D), canvas);
            }
        }
        d.a(canvas, A - d.f / 2, B - d.g / 2);
        if (!a)
        {
            this.j.a(canvas, C, E);
        } else
        {
            this.i.a(canvas, C, E);
        }
        b("Ok", C, E, canvas);
        if (i != 128)
        {
            invalidate();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        if (motionevent.getAction() == 1)
        {
            if (a(j, k, C, E) && a)
            {
                q.z = null;
                ((ViewGroup)getParent()).removeView(this);
                for (int i = 0; i < q.U.size(); i++)
                {
                    ((Bitmap)q.U.get(i)).recycle();
                }

                q.U.clear();
                q.m = true;
            }
            a = false;
            invalidate();
        }
        if (motionevent.getAction() == 0 && a(j, k, C, E))
        {
            a = true;
            invalidate();
        }
        return true;
    }
}
