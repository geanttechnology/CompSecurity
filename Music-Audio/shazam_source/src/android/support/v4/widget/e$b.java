// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

// Referenced classes of package android.support.v4.widget:
//            e, f

static class 
    implements 
{

    public final Object a(Context context)
    {
        return new EdgeEffect(context);
    }

    public final void a(Object obj, int i, int j)
    {
        ((EdgeEffect)obj).setSize(i, j);
    }

    public final boolean a(Object obj)
    {
        return ((EdgeEffect)obj).isFinished();
    }

    public final boolean a(Object obj, float f1)
    {
        return f.a(obj, f1);
    }

    public boolean a(Object obj, float f1, float f2)
    {
        return f.a(obj, f1);
    }

    public final boolean a(Object obj, int i)
    {
        ((EdgeEffect)obj).onAbsorb(i);
        return true;
    }

    public final boolean a(Object obj, Canvas canvas)
    {
        return ((EdgeEffect)obj).draw(canvas);
    }

    public final void b(Object obj)
    {
        ((EdgeEffect)obj).finish();
    }

    public final boolean c(Object obj)
    {
        obj = (EdgeEffect)obj;
        ((EdgeEffect) (obj)).onRelease();
        return ((EdgeEffect) (obj)).isFinished();
    }

    ()
    {
    }
}
