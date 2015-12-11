// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.facebook.internal:
//            q

class a
    implements android.view..OnTouchListener
{

    final q a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!view.hasFocus())
        {
            view.requestFocus();
        }
        return false;
    }

    istener(q q1)
    {
        a = q1;
        super();
    }
}
