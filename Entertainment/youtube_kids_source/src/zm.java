// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;

final class zm
    implements android.view.View.OnTouchListener
{

    zm(zl zl)
    {
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i == 0)
        {
            view.setBackgroundResource(0x7f020164);
        } else
        if (i == 1)
        {
            view.setBackgroundResource(0);
            return false;
        }
        return false;
    }
}
