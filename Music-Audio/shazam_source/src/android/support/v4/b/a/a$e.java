// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

// Referenced classes of package android.support.v4.b.a:
//            a, g, b

static class rawable extends rawable
{

    public final void a(Drawable drawable, float f, float f1)
    {
        drawable.setHotspot(f, f1);
    }

    public final void a(Drawable drawable, int i)
    {
        if (drawable instanceof g)
        {
            b.a(drawable, i);
            return;
        } else
        {
            drawable.setTint(i);
            return;
        }
    }

    public final void a(Drawable drawable, int i, int j, int k, int l)
    {
        drawable.setHotspotBounds(i, j, k, l);
    }

    public final void a(Drawable drawable, ColorStateList colorstatelist)
    {
        if (drawable instanceof g)
        {
            b.a(drawable, colorstatelist);
            return;
        } else
        {
            drawable.setTintList(colorstatelist);
            return;
        }
    }

    public final void a(Drawable drawable, android.graphics.erDuff.Mode mode)
    {
        if (drawable instanceof g)
        {
            b.a(drawable, mode);
            return;
        } else
        {
            drawable.setTintMode(mode);
            return;
        }
    }

    public Drawable c(Drawable drawable)
    {
        Object obj = drawable;
        if (drawable instanceof GradientDrawable)
        {
            obj = new g(drawable);
        }
        return ((Drawable) (obj));
    }

    rawable()
    {
    }
}
