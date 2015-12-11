// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;

final class vz
    implements android.view.View.OnTouchListener
{

    private vy a;

    vz(vy vy1)
    {
        a = vy1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i == 0)
        {
            view.setBackgroundColor(a.getResources().getColor(0x7f09007a));
        } else
        if (i == 1)
        {
            view.setBackgroundResource(0);
            return false;
        }
        return false;
    }
}
