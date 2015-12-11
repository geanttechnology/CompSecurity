// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

// Referenced classes of package com.jirbo.adcolony:
//            o, m

class p extends View
{

    Rect a;
    final o b;

    public p(o o1, Activity activity)
    {
        b = o1;
        super(activity);
        a = new Rect();
    }

    public void onDraw(Canvas canvas)
    {
        canvas.drawARGB(255, 0, 0, 0);
        getDrawingRect(a);
        b.O.a(canvas, (a.width() - b.O.f) / 2, (a.height() - b.O.g) / 2);
        invalidate();
    }
}
