// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

final class lh
    implements android.view.View.OnTouchListener
{

    private kx a;

    lh(kx kx1)
    {
        a = kx1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        int j;
        int k;
        i = motionevent.getAction();
        j = (int)motionevent.getX();
        k = (int)motionevent.getY();
        if (i != 0 || kx.b(a) == null || !kx.b(a).isShowing() || j < 0 || j >= kx.b(a).getWidth() || k < 0 || k >= kx.b(a).getHeight()) goto _L2; else goto _L1
_L1:
        kx.d(a).postDelayed(kx.c(a), 250L);
_L4:
        return false;
_L2:
        if (i == 1)
        {
            kx.d(a).removeCallbacks(kx.c(a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
