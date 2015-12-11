// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

// Referenced classes of package com.jirbo.adcolony:
//            AdColonyBrowser, c

final class a extends View
{

    Rect a;
    final AdColonyBrowser b;

    public final void onDraw(Canvas canvas)
    {
        if (!AdColonyBrowser.z)
        {
            canvas.drawARGB(255, 0, 0, 0);
            getDrawingRect(a);
            b.j.a(canvas, (a.width() - b.j.f) / 2, (a.height() - b.j.g) / 2);
            invalidate();
        }
    }

    public (AdColonyBrowser adcolonybrowser, Activity activity)
    {
        b = adcolonybrowser;
        super(activity);
        a = new Rect();
    }
}
