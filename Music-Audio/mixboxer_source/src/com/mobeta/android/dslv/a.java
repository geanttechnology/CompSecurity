// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.view.MotionEvent;

// Referenced classes of package com.mobeta.android.dslv:
//            c, DragSortListView

final class a extends android.view.GestureDetector.SimpleOnGestureListener
{

    private c a;

    a(c c1)
    {
        a = c1;
        super();
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (!c.a(a) || !c.b(a)) goto _L2; else goto _L1
_L1:
        int i = c.c(a).getWidth() / 5;
        if (f <= c.d(a)) goto _L4; else goto _L3
_L3:
        if (c.e(a) > -i)
        {
            c.c(a).a(true, f);
        }
_L6:
        c.a(a, false);
_L2:
        return false;
_L4:
        if (f < -c.d(a) && c.e(a) < i)
        {
            c.c(a).a(true, f);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
