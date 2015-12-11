// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            db

final class df
    implements android.view.View.OnTouchListener
{

    final db a;

    df(db db1)
    {
        a = db1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        return db.c(a).onTouchEvent(motionevent);
    }
}
