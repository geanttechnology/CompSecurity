// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            TextLoopView, al

class b
    implements android.view.tener
{

    final Context a;
    final TextLoopView b;
    private GestureDetector c;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!al.a(TextLoopView.d(b)))
        {
            c.onTouchEvent(motionevent);
        }
        return true;
    }

    _cls1.a(TextLoopView textloopview, Context context)
    {
        b = textloopview;
        a = context;
        super();
        c = new GestureDetector(a, new android.view.GestureDetector.SimpleOnGestureListener() {

            final TextLoopView._cls1 a;

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                if (f > 0.0F)
                {
                    TextLoopView.a(a.b, -1, false);
                    return true;
                } else
                {
                    TextLoopView.a(a.b, 1, false);
                    return true;
                }
            }

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                float f;
                int i;
                int j;
                f = motionevent.getX();
                float f1 = motionevent.getY();
                if (0.0F > f1 || f1 > (float)a.b.getHeight())
                {
                    break MISSING_BLOCK_LABEL_173;
                }
                j = (a.b.getWidth() - TextLoopView.a(a.b) * TextLoopView.b(a.b)) / 2;
                i = 0;
_L3:
                if (i >= TextLoopView.a(a.b))
                {
                    break MISSING_BLOCK_LABEL_173;
                }
                if ((float)j > f || f > (float)(TextLoopView.b(a.b) + j)) goto _L2; else goto _L1
_L1:
                if (i != -1)
                {
                    j = TextLoopView.c(a.b);
                    TextLoopView.a(a.b, i - j, true);
                }
                return true;
_L2:
                j += TextLoopView.b(a.b);
                i++;
                  goto _L3
                i = -1;
                  goto _L1
            }

            
            {
                a = TextLoopView._cls1.this;
                super();
            }
        });
    }
}
