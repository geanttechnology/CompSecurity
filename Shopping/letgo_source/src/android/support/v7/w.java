// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7:
//            ab, aa

class w
{

    public static Drawable a(Drawable drawable)
    {
        Object obj = drawable;
        if (!(drawable instanceof ab))
        {
            obj = new ab(drawable);
        }
        return ((Drawable) (obj));
    }

    public static void a(Drawable drawable, int i)
    {
        if (drawable instanceof aa)
        {
            ((aa)drawable).setTint(i);
        }
    }

    public static void a(Drawable drawable, ColorStateList colorstatelist)
    {
        if (drawable instanceof aa)
        {
            ((aa)drawable).setTintList(colorstatelist);
        }
    }

    public static void a(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        if (drawable instanceof aa)
        {
            ((aa)drawable).setTintMode(mode);
        }
    }
}
