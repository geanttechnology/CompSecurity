// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;

// Referenced classes of package com.wishabi.flipp.app:
//            fr

final class ft
    implements android.view.View.OnTouchListener
{

    final fr a;

    ft(fr fr1)
    {
        a = fr1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (fr.c(a) != null)
        {
            fr.c(a).show();
        }
        return false;
    }
}
