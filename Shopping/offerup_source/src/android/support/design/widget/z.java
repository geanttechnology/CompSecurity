// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.design.widget:
//            ao, FloatingActionButton

final class z
    implements ao
{

    private FloatingActionButton a;

    z(FloatingActionButton floatingactionbutton)
    {
        a = floatingactionbutton;
        super();
    }

    public final float a()
    {
        return (float)a.getSizeDimension() / 2.0F;
    }

    public final void a(int i, int j, int k, int l)
    {
        FloatingActionButton.a(a).set(i, j, k, l);
        a.setPadding(FloatingActionButton.b(a) + i, FloatingActionButton.b(a) + j, FloatingActionButton.b(a) + k, FloatingActionButton.b(a) + l);
    }

    public final void a(Drawable drawable)
    {
        FloatingActionButton.a(a, drawable);
    }
}
