// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class a extends c
{

    a()
    {
        super(null, null);
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        a(f, f1, rect, f3);
    }

    void a(float f, float f1, Rect rect, float f2)
    {
        float f5 = Edge.a.a();
        float f3 = Edge.b.a();
        float f6 = Edge.c.a();
        float f4 = Edge.d.a();
        f5 = (f5 + f6) / 2.0F;
        f3 = (f3 + f4) / 2.0F;
        f -= f5;
        f1 -= f3;
        Edge.a.b(f);
        Edge.b.b(f1);
        Edge.c.b(f);
        Edge.d.b(f1);
        if (!Edge.a.a(rect, f2)) goto _L2; else goto _L1
_L1:
        f = Edge.a.a(rect);
        Edge.c.b(f);
_L8:
        if (!Edge.b.a(rect, f2)) goto _L4; else goto _L3
_L3:
        f = Edge.b.a(rect);
        Edge.d.b(f);
_L6:
        return;
_L2:
        if (Edge.c.a(rect, f2))
        {
            f = Edge.c.a(rect);
            Edge.a.b(f);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!Edge.d.a(rect, f2)) goto _L6; else goto _L5
_L5:
        f = Edge.d.a(rect);
        Edge.b.b(f);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
