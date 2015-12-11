// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

// Referenced classes of package android.support.v7:
//            ae, w

class z
{

    public static Drawable a(Drawable drawable)
    {
        Object obj = drawable;
        if (drawable instanceof GradientDrawable)
        {
            obj = new ae(drawable);
        }
        return ((Drawable) (obj));
    }

    public static void a(Drawable drawable, float f, float f1)
    {
        drawable.setHotspot(f, f1);
    }

    public static void a(Drawable drawable, int i)
    {
        if (drawable instanceof ae)
        {
            w.a(drawable, i);
            return;
        } else
        {
            drawable.setTint(i);
            return;
        }
    }

    public static void a(Drawable drawable, int i, int j, int k, int l)
    {
        drawable.setHotspotBounds(i, j, k, l);
    }

    public static void a(Drawable drawable, ColorStateList colorstatelist)
    {
        if (drawable instanceof ae)
        {
            w.a(drawable, colorstatelist);
            return;
        } else
        {
            drawable.setTintList(colorstatelist);
            return;
        }
    }

    public static void a(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        if (drawable instanceof ae)
        {
            w.a(drawable, mode);
            return;
        } else
        {
            drawable.setTintMode(mode);
            return;
        }
    }
}
