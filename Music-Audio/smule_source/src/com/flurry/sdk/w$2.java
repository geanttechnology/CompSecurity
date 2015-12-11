// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.flurry.sdk:
//            w

class nit>
    implements android.view..OnTouchListener
{

    final w a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        w.d(a).onTouchEvent(motionevent);
        return true;
    }

    Event(w w1)
    {
        a = w1;
        super();
    }
}
