// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;

// Referenced classes of package com.edmodo.cropper.cropwindow.handle:
//            b, e, d, a, 
//            c

public final class Handle extends Enum
{

    public static final Handle a;
    public static final Handle b;
    public static final Handle c;
    public static final Handle d;
    public static final Handle e;
    public static final Handle f;
    public static final Handle g;
    public static final Handle h;
    public static final Handle i;
    private static final Handle j[];
    private c mHelper;

    private Handle(String s, int k, c c1)
    {
        super(s, k);
        mHelper = c1;
    }

    public static Handle valueOf(String s)
    {
        return (Handle)Enum.valueOf(com/edmodo/cropper/cropwindow/handle/Handle, s);
    }

    public static Handle[] values()
    {
        return (Handle[])j.clone();
    }

    public void a(float f1, float f2, float f3, Rect rect, float f4)
    {
        mHelper.a(f1, f2, f3, rect, f4);
    }

    public void a(float f1, float f2, Rect rect, float f3)
    {
        mHelper.a(f1, f2, rect, f3);
    }

    static 
    {
        a = new Handle("TOP_LEFT", 0, new b(Edge.b, Edge.a));
        b = new Handle("TOP_RIGHT", 1, new b(Edge.b, Edge.c));
        c = new Handle("BOTTOM_LEFT", 2, new b(Edge.d, Edge.a));
        d = new Handle("BOTTOM_RIGHT", 3, new b(Edge.d, Edge.c));
        e = new Handle("LEFT", 4, new e(Edge.a));
        f = new Handle("TOP", 5, new d(Edge.b));
        g = new Handle("RIGHT", 6, new e(Edge.c));
        h = new Handle("BOTTOM", 7, new d(Edge.d));
        i = new Handle("CENTER", 8, new a());
        j = (new Handle[] {
            a, b, c, d, e, f, g, h, i
        });
    }
}
