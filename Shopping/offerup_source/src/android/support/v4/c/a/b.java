// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.c.a:
//            i, k

class b
{

    b()
    {
    }

    public void a(Drawable drawable)
    {
    }

    public void a(Drawable drawable, float f, float f1)
    {
    }

    public void a(Drawable drawable, int j)
    {
        i.a(drawable, j);
    }

    public void a(Drawable drawable, int j, int l, int i1, int j1)
    {
    }

    public void a(Drawable drawable, ColorStateList colorstatelist)
    {
        i.a(drawable, colorstatelist);
    }

    public void a(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        i.a(drawable, mode);
    }

    public void a(Drawable drawable, boolean flag)
    {
    }

    public boolean b(Drawable drawable)
    {
        return false;
    }

    public Drawable c(Drawable drawable)
    {
        Object obj = drawable;
        if (!(drawable instanceof k))
        {
            obj = new k(drawable);
        }
        return ((Drawable) (obj));
    }
}
