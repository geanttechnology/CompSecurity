// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.b;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

// Referenced classes of package com.j.a.b:
//            b, j, a

public class g
{

    private final a a;

    public g(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener)
    {
        this(context, ongesturelistener, null);
    }

    public g(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener, Handler handler)
    {
        if (android.os.Build.VERSION.SDK_INT > 17)
        {
            a = new b(context, ongesturelistener, handler);
            return;
        } else
        {
            a = new j(context, ongesturelistener, handler);
            return;
        }
    }

    public boolean a(MotionEvent motionevent)
    {
        return a.a(motionevent);
    }
}
