// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.a;

abstract class c
{

    private Edge a;
    private Edge b;
    private a c;

    c(Edge edge, Edge edge1)
    {
        a = edge;
        b = edge1;
        c = new a(a, b);
    }

    private float a(float f, float f1)
    {
        float f2;
        float f3;
        if (b == Edge.a)
        {
            f2 = f;
        } else
        {
            f2 = Edge.a.a();
        }
        if (a == Edge.b)
        {
            f3 = f1;
        } else
        {
            f3 = Edge.b.a();
        }
        if (b != Edge.c)
        {
            f = Edge.c.a();
        }
        if (a != Edge.d)
        {
            f1 = Edge.d.a();
        }
        return com.edmodo.cropper.a.a.a(f2, f3, f, f1);
    }

    a a()
    {
        return c;
    }

    a a(float f, float f1, float f2)
    {
        if (a(f, f1) > f2)
        {
            c.a = b;
            c.b = a;
        } else
        {
            c.a = a;
            c.b = b;
        }
        return c;
    }

    abstract void a(float f, float f1, float f2, Rect rect, float f3);

    void a(float f, float f1, Rect rect, float f2)
    {
        Object obj = a();
        Edge edge = ((a) (obj)).a;
        obj = ((a) (obj)).b;
        if (edge != null)
        {
            edge.a(f, f1, rect, f2, 1.0F);
        }
        if (obj != null)
        {
            ((Edge) (obj)).a(f, f1, rect, f2, 1.0F);
        }
    }
}
