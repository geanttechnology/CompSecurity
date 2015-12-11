// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package android.support.v7.widget:
//            s

private final class <init>
    implements android.view..OnTouchListener
{

    final s a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        int j;
        int k;
        i = motionevent.getAction();
        j = (int)motionevent.getX();
        k = (int)motionevent.getY();
        if (i != 0 || s.b(a) == null || !s.b(a).isShowing() || j < 0 || j >= s.b(a).getWidth() || k < 0 || k >= s.b(a).getHeight()) goto _L2; else goto _L1
_L1:
        s.d(a).postDelayed(s.c(a), 250L);
_L4:
        return false;
_L2:
        if (i == 1)
        {
            s.d(a).removeCallbacks(s.c(a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ner(s s1)
    {
        a = s1;
        super();
    }

    a(s s1, byte byte0)
    {
        this(s1);
    }
}
