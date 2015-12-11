// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.MotionEvent;

// Referenced classes of package com.wishabi.flipp.widget:
//            db, dk, dj

final class de extends android.view.GestureDetector.SimpleOnGestureListener
{

    final db a;

    de(db db1)
    {
        a = db1;
        super();
    }

    public final void onLongPress(MotionEvent motionevent)
    {
        if (db.a(a) == null || db.b(a) == dk.d)
        {
            return;
        } else
        {
            db.a(a).b(a);
            return;
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (db.a(a) == null || db.b(a) == dk.d)
        {
            return false;
        } else
        {
            db.a(a).a(a);
            return true;
        }
    }
}
