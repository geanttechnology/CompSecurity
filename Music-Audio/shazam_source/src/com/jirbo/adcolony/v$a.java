// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

// Referenced classes of package com.jirbo.adcolony:
//            v, c

final class init> extends View
{

    Rect a;
    final v b;

    public final void onDraw(Canvas canvas)
    {
        canvas.drawARGB(255, 0, 0, 0);
        getDrawingRect(a);
        b.ar.a(canvas, (a.width() - b.ar.f) / 2, (a.height() - b.ar.g) / 2);
        invalidate();
    }

    public (v v1, Activity activity)
    {
        b = v1;
        super(activity);
        a = new Rect();
    }
}
