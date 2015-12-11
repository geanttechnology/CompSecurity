// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ag, q, c, o

final class t extends ag
{

    boolean a;
    boolean b;

    public t(String s, o o1)
    {
        F = s;
        G = o1;
        b();
        q.b().addContentView(this, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        if (p)
        {
            E = E + 20;
        }
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
        if (G.g() == 1)
        {
            a(F, "");
            if (!u)
            {
                a("Watch a video to earn", A, (int)((double)B - (double)j * this.k), canvas);
                a(s, A, (int)((double)B - (double)j * l), canvas);
                a((new StringBuilder()).append(t).append(".").toString(), A, (int)((double)B - (double)j * m), canvas);
            } else
            {
                a("Watch a video to earn", A, (int)((double)B - (double)j * n), canvas);
                a((new StringBuilder()).append(s).append(".").toString(), A, (int)((double)B - (double)j * o), canvas);
            }
        } else
        {
            String s;
            if (k == 1)
            {
                s = "video";
            } else
            {
                s = "videos";
            }
            a(F, (new StringBuilder()).append(k).append(" more ").append(s).append(" to earn )?").toString());
            if (!u)
            {
                a("Watch a sponsored video now (Only", A, (int)((double)B - (double)j * this.k), canvas);
                a((new StringBuilder()).append(k).append(" more ").append(s).append(" to earn ").append(s).toString(), A, (int)((double)B - (double)j * l), canvas);
                a((new StringBuilder()).append(t).append(")?").toString(), A, (int)((double)B - (double)j * m), canvas);
            } else
            {
                a("Watch a sponsored video now (Only", A, (int)((double)B - (double)j * n), canvas);
                a((new StringBuilder()).append(k).append(" more ").append(s).append(" to earn ").append(s).append(")?").toString(), A, (int)((double)B - (double)j * o), canvas);
            }
        }
        d.a(canvas, A - d.f / 2, B - d.g / 2);
        if (!b)
        {
            e.a(canvas, C, E);
        } else
        {
            f.a(canvas, C, E);
        }
        if (!a)
        {
            g.a(canvas, D, E);
        } else
        {
            h.a(canvas, D, E);
        }
        b("Yes", C, E, canvas);
        b("No", D, E, canvas);
        if (i != 128)
        {
            invalidate();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        int j;
        int k;
        j = (int)motionevent.getX();
        k = (int)motionevent.getY();
        if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        if (!a(j, k, C, E) || !b) goto _L4; else goto _L3
_L3:
        q.z = null;
        ((ViewGroup)getParent()).removeView(this);
        G.b(true);
_L11:
        a = false;
        b = false;
        invalidate();
_L2:
        if (motionevent.getAction() != 0) goto _L6; else goto _L5
_L5:
        if (!a(j, k, C, E)) goto _L8; else goto _L7
_L7:
        b = true;
        invalidate();
_L6:
        return true;
_L4:
        if (a(j, k, D, E) && a)
        {
            q.z = null;
            ((ViewGroup)getParent()).removeView(this);
            G.b(false);
            q.m = true;
            for (int i = 0; i < q.U.size(); i++)
            {
                ((Bitmap)q.U.get(i)).recycle();
            }

            q.U.clear();
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (!a(j, k, D, E)) goto _L6; else goto _L9
_L9:
        a = true;
        invalidate();
        return true;
        if (true) goto _L11; else goto _L10
_L10:
    }
}
