// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

// Referenced classes of package android.support.v4.view:
//            r, p, o

public final class n
{

    private final o a;

    public n(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener)
    {
        this(context, ongesturelistener, null);
    }

    private n(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener, Handler handler)
    {
        if (android.os.Build.VERSION.SDK_INT > 17)
        {
            a = new r(context, ongesturelistener, null);
            return;
        } else
        {
            a = new p(context, ongesturelistener, null);
            return;
        }
    }

    public final void a(android.view.GestureDetector.OnDoubleTapListener ondoubletaplistener)
    {
        a.a(ondoubletaplistener);
    }

    public final boolean a(MotionEvent motionevent)
    {
        return a.a(motionevent);
    }
}
