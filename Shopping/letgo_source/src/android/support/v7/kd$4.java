// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package android.support.v7:
//            kd

class a
    implements android.view.OnTouchListener
{

    final kd a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!view.hasFocus())
        {
            view.requestFocus();
        }
        return false;
    }

    (kd kd1)
    {
        a = kd1;
        super();
    }
}
