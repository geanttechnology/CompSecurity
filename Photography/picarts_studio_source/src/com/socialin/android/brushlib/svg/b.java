// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;


// Referenced classes of package com.socialin.android.brushlib.svg:
//            ShapeParams

public final class b
{

    public boolean a;
    public float b;
    public int c;

    public b()
    {
        a = false;
        b = 1.0F;
        c = 0;
    }

    public final ShapeParams a()
    {
        return new ShapeParams(a, b, c, null);
    }

    public final b a(int i)
    {
        c = 0xffffff & i | c;
        return this;
    }

    public final b b(int i)
    {
        c = c & 0xffffff;
        c = c | i << 24;
        return this;
    }
}
