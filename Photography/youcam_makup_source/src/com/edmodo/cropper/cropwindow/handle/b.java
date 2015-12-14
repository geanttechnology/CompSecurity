// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.a;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            c

class b extends c
{

    b(Edge edge, Edge edge1)
    {
        super(edge, edge1);
    }

    void a(float f, float f1, float f2, Rect rect, float f3)
    {
        Object obj = a(f, f1, f2);
        Edge edge = ((a) (obj)).a;
        obj = ((a) (obj)).b;
        edge.a(f, f1, rect, f3, f2);
        ((Edge) (obj)).c(f2);
        if (((Edge) (obj)).a(rect, f3))
        {
            ((Edge) (obj)).a(rect);
            edge.c(f2);
        }
    }
}
