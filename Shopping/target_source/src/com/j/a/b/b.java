// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.b;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

// Referenced classes of package com.j.a.b:
//            a

class b
    implements a
{

    private final GestureDetector a;

    public b(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener, Handler handler)
    {
        a = new GestureDetector(context, ongesturelistener, handler);
    }

    public boolean a(MotionEvent motionevent)
    {
        return a.onTouchEvent(motionevent);
    }
}
