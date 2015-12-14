// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.a.a;
import com.edmodo.cropper.cropwindow.edge.Edge;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class d extends c
{

    private Edge a;

    d(Edge edge)
    {
        super(edge, null);
        a = edge;
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        a.a(f, f1, rect, f3, f2);
        f = Edge.a.a();
        float f4 = Edge.b.a();
        f1 = Edge.c.a();
        f4 = (com.edmodo.cropper.a.a.a(f4, Edge.d.a(), f2) - (f1 - f)) / 2.0F;
        Edge.a.a(f - f4);
        Edge.c.a(f4 + f1);
        if (Edge.a.a(rect, f3) && !a.a(Edge.a, rect, f2))
        {
            f = Edge.a.a(rect);
            Edge.c.b(-f);
            a.c(f2);
        }
        if (Edge.c.a(rect, f3) && !a.a(Edge.c, rect, f2))
        {
            f = Edge.c.a(rect);
            Edge.a.b(-f);
            a.c(f2);
        }
    }
}
