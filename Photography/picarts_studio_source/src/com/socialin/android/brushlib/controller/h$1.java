// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.socialin.android.brushlib.input.gesture.h;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.controller:
//            h

final class a
    implements h
{

    private com.socialin.android.brushlib.controller.h a;

    public final void a(float f, float f1)
    {
        a.j = a.a.c.b.a;
        a.h = new PointF(f, f1);
    }

    public final void b(float f, float f1)
    {
    }

    public final void c(float f, float f1)
    {
        float f2 = f - a.h.x;
        float f3 = f1 - a.h.y;
        float f4 = a.b.x;
        float f5 = a.b.y;
        a.j.postTranslate(f2, f3);
        PointF pointf = a.h;
        pointf.x = f2 + pointf.x;
        pointf = a.h;
        pointf.y = f3 + pointf.y;
        pointf = a.b;
        pointf.x = pointf.x + (f - f4);
        pointf = a.b;
        pointf.y = pointf.y + (f1 - f5);
    }

    w(com.socialin.android.brushlib.controller.h h1)
    {
        a = h1;
        super();
    }
}
