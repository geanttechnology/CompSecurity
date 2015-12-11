// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            PrintCouponFragment

final class du
    implements android.view.View.OnTouchListener
{

    final PrintCouponFragment a;

    du(PrintCouponFragment printcouponfragment)
    {
        a = printcouponfragment;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        view.requestFocusFromTouch();
        return false;
    }
}
