// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.a.a;
import com.edmodo.cropper.cropwindow.edge.Edge;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class e extends c
{

    private Edge a;

    e(Edge edge)
    {
        super(null, edge);
        a = edge;
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        a.a(f, f1, rect, f3, f2);
        float f4 = Edge.a.a();
        f = Edge.b.a();
        float f5 = Edge.c.a();
        f1 = Edge.d.a();
        f4 = (com.edmodo.cropper.a.a.b(f4, f5, f2) - (f1 - f)) / 2.0F;
        Edge.b.a(f - f4);
        Edge.d.a(f4 + f1);
        if (Edge.b.a(rect, f3) && !a.a(Edge.b, rect, f2))
        {
            f = Edge.b.a(rect);
            Edge.d.b(-f);
            a.c(f2);
        }
        if (Edge.d.a(rect, f3) && !a.a(Edge.d, rect, f2))
        {
            f = Edge.d.a(rect);
            Edge.b.b(-f);
            a.c(f2);
        }
    }
}
