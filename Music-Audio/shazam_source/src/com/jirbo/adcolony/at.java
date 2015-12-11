// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

// Referenced classes of package com.jirbo.adcolony:
//            ag, e, ad, c, 
//            v, q, AdColonyBrowser, o

final class at extends ag
{

    static boolean a;
    static at b;
    boolean H;
    boolean I;
    e J;

    public at(e e1, o o)
    {
        J = e1;
        G = o;
        e1.B.pause();
        b = this;
        b();
    }

    final void a()
    {
        int i = J.s;
        int j = J.t;
        y = (i - c.f) / 2;
        z = (j - c.g) / 2;
        A = y + c.f / 2;
        B = z + c.g / 2;
        E = z + (int)((double)c.g - ((double)e.g + r * 16D));
        C = y + (int)(r * 16D);
        D = y + (int)((double)c.f - ((double)e.f + r * 16D));
    }

    public final void onDraw(Canvas canvas)
    {
        int i = 128;
        if (J.B == null)
        {
            return;
        }
        a = true;
        a();
        int j = ((int)(System.currentTimeMillis() - x) * 255) / 1000;
        if (j <= 128)
        {
            i = j;
        }
        canvas.drawARGB(i, 0, 0, 0);
        c.a(canvas, y, z);
        i = ((int)ag.v.getTextSize() * 3) / 2;
        a("Completion is required to receive", A, (int)((double)B - (double)i * 2.75D), canvas);
        a("your reward.", A, B - i * 2, canvas);
        a("Are you sure you want to skip?", A, (int)((double)B - (double)i * 1.25D), canvas);
        d.a(canvas, A - d.f / 2, B - d.g / 2);
        if (!H)
        {
            e.a(canvas, C, E);
        } else
        {
            f.a(canvas, C, E);
        }
        if (!I)
        {
            g.a(canvas, D, E);
        } else
        {
            h.a(canvas, D, E);
        }
        b("Yes", C, E, canvas);
        b("No", D, E, canvas);
    }

    public final boolean onKeyDown(int i, KeyEvent keyevent)
    {
        while (J.B == null || i != 4) 
        {
            return false;
        }
        return super.onKeyDown(i, keyevent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            b = null;
            J.B.start();
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = true;
        boolean flag;
        if (e.d)
        {
            b = null;
            flag = J.C.onTouchEvent(motionevent);
        } else
        {
            int i = (int)motionevent.getX();
            int j = (int)motionevent.getY();
            if (motionevent.getAction() == 1)
            {
                if (a(i, j, C, E) && H)
                {
                    b = null;
                    a = false;
                    q.l = false;
                    q.R = true;
                    q.D.b(G);
                    AdColonyBrowser.B = true;
                    J.finish();
                } else
                if (a(i, j, D, E) && I)
                {
                    b = null;
                    a = false;
                    J.B.start();
                }
                H = false;
                I = false;
                invalidate();
            }
            flag = flag1;
            if (motionevent.getAction() == 0)
            {
                if (a(i, j, C, E))
                {
                    H = true;
                    invalidate();
                    return true;
                }
                flag = flag1;
                if (a(i, j, D, E))
                {
                    I = true;
                    invalidate();
                    return true;
                }
            }
        }
        return flag;
    }
}
