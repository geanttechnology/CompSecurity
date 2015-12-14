// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;


// Referenced classes of package com.picsart.studio.editor:
//            g, Camera

final class d extends g
{

    private final g a;
    private final Camera b;

    protected d(g g1, Camera camera)
    {
        a = g1;
        b = camera;
    }

    public final float a()
    {
        return b.b(a.a());
    }

    public final g a(float f)
    {
        a.a(b.d(f));
        return this;
    }

    public final float b()
    {
        return b.c(a.b());
    }

    public final g b(float f)
    {
        a.b(b.e(f));
        return this;
    }

    public final float c()
    {
        return b.e * a.c();
    }

    public final g c(float f)
    {
        a.c(f / b.e);
        return this;
    }

    public final float d()
    {
        return b.e * a.d();
    }

    public final g d(float f)
    {
        a.d(f / b.e);
        return this;
    }

    public final float e()
    {
        return a.e();
    }

    public final g e(float f)
    {
        a.e(f);
        return this;
    }
}
