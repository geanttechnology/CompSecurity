// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.j.a.d.ag;
import com.j.a.g.t;

// Referenced classes of package com.j.a.f:
//            a, f

public class d extends FrameLayout
{

    private Paint a;
    private Paint b;
    private a c;

    public d(Context context)
    {
        super(context);
        b();
    }

    private a a(int i, int j)
    {
        return new a(i, j, 40);
    }

    private void b()
    {
        a = new Paint();
        a.setColor(f.a(ag.c().a()));
        a.setStrokeWidth(20F);
        a.setStyle(android.graphics.Paint.Style.FILL);
        b = new Paint();
        b.setColor(f.a());
        b.setStrokeWidth(2.0F);
        b.setStyle(android.graphics.Paint.Style.FILL);
    }

    public void a()
    {
        c = null;
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        if (c != null)
        {
            canvas.drawCircle(c.b, c.c, c.a, a);
            canvas.drawCircle(c.b, c.c, 3F, b);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 48
    //                   0 98
    //                   1 186
    //                   2 177
    //                   3 204
    //                   4 48
    //                   5 168
    //                   6 195;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L5:
        break MISSING_BLOCK_LABEL_204;
_L1:
        int i = 0;
_L8:
        if (ag.c().a().equals(t.b) || ag.c().a().equals(t.d))
        {
            if (i != 0 || super.onTouchEvent(motionevent))
            {
                flag = true;
            }
            return flag;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
_L2:
        if (ag.c().a().equals(t.b) || ag.c().a().equals(t.d))
        {
            i = (int)motionevent.getX(0);
            int j = (int)motionevent.getY(0);
            if (c == null)
            {
                c = a(i, j);
            }
        }
        invalidate();
        i = 1;
          goto _L8
_L6:
        invalidate();
        i = 1;
          goto _L8
_L4:
        invalidate();
        i = 1;
          goto _L8
_L3:
        invalidate();
        i = 1;
          goto _L8
_L7:
        invalidate();
        i = 1;
          goto _L8
        i = 1;
          goto _L8
    }
}
