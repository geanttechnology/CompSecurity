// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.aa;
import w.panzoomview.d;
import w.panzoomview.g;
import w.panzoomview.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            t

class s extends d
    implements m
{

    float a;
    float b;
    Paint c;
    t d[];
    boolean e;
    t f;

    s(int i, int j)
    {
        c = aa.a();
        d = new t[3];
        e = false;
        f = null;
        d[0] = new t(this);
        d[0].e = BitmapFactory.decodeResource(Globals.d().getResources(), 0x7f020738);
        d[0].a(i / 3, j / 3, i, j);
        d[1] = new t(this);
        d[1].e = BitmapFactory.decodeResource(Globals.d().getResources(), 0x7f020738);
        d[1].a((i * 2) / 3, j / 3, i, j);
        d[2] = new t(this);
        d[2].e = BitmapFactory.decodeResource(Globals.d().getResources(), 0x7f020754);
        d[2].a(i / 2, (j * 2) / 3, i, j);
    }

    public void a(Canvas canvas, g g1)
    {
        int i = 0;
        canvas.clipRect(0, 0, g1.a, g1.b);
        g1 = d;
        for (int j = g1.length; i < j; i++)
        {
            Object obj = g1[i];
            canvas.drawBitmap(((t) (obj)).e, null, ((t) (obj)).c, c);
        }

    }

    public boolean a(View view, MotionEvent motionevent, g g1)
    {
        a = motionevent.getX();
        b = motionevent.getY();
        if (motionevent.getActionMasked() == 0)
        {
            view = d;
            int j = view.length;
            for (int i = 0; i < j; i++)
            {
                motionevent = view[i];
                if (((t) (motionevent)).d.contains(a, b))
                {
                    f = motionevent;
                    motionevent.a(a, b, g1.a, g1.b);
                    e = true;
                    invalidateSelf();
                    return true;
                }
            }

            return false;
        }
        if (motionevent.getActionMasked() == 2 && e)
        {
            f.a(a, b, g1.a, g1.b);
            invalidateSelf();
            return true;
        }
        if (motionevent.getActionMasked() == 1 || motionevent.getActionMasked() == 3)
        {
            f.a(a, b, g1.a, g1.b);
            f = null;
            e = false;
            invalidateSelf();
            return true;
        } else
        {
            return false;
        }
    }

    public int getOpacity()
    {
        return 255;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
