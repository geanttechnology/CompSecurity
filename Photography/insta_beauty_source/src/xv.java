// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

class xv extends android.view.GestureDetector.SimpleOnGestureListener
{

    final xu a;

    xv(xu xu1)
    {
        a = xu1;
        super();
    }

    public void onLongPress(MotionEvent motionevent)
    {
        if (xu.a(a) != null)
        {
            xu.a(a).onLongClick((View)xu.b(a).get());
        }
    }
}
