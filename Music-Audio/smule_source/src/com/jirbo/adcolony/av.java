// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

// Referenced classes of package com.jirbo.adcolony:
//            au, m

class av extends View
{

    Rect a;
    final au b;

    public av(au au1, Activity activity)
    {
        b = au1;
        super(activity);
        a = new Rect();
    }

    public void onDraw(Canvas canvas)
    {
        canvas.drawARGB(255, 0, 0, 0);
        getDrawingRect(a);
        b.ar.a(canvas, (a.width() - b.ar.f) / 2, (a.height() - b.ar.g) / 2);
        invalidate();
    }
}
