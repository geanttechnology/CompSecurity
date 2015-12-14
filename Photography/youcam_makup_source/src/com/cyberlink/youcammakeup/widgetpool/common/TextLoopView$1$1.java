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

class a extends android.view.impleOnGestureListener
{

    final a a;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (f > 0.0F)
        {
            TextLoopView.a(a.a, -1, false);
            return true;
        } else
        {
            TextLoopView.a(a.a, 1, false);
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
        if (0.0F > f1 || f1 > (float)a.a.getHeight())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        j = (a.a.getWidth() - TextLoopView.a(a.a) * TextLoopView.b(a.a)) / 2;
        i = 0;
_L3:
        if (i >= TextLoopView.a(a.a))
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if ((float)j > f || f > (float)(TextLoopView.b(a.a) + j)) goto _L2; else goto _L1
_L1:
        if (i != -1)
        {
            j = TextLoopView.c(a.a);
            TextLoopView.a(a.a, i - j, true);
        }
        return true;
_L2:
        j += TextLoopView.b(a.a);
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    <init>(<init> <init>1)
    {
        a = <init>1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/common/TextLoopView$1

/* anonymous class */
    class TextLoopView._cls1
        implements android.view.View.OnTouchListener
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

            
            {
                b = textloopview;
                a = context;
                super();
                c = new GestureDetector(a, new TextLoopView._cls1._cls1(this));
            }
    }

}
