// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.graphics.drawable:
//            DrawableWrapper

public class DrawableCompat
{

    static final DrawableImpl IMPL;

    public DrawableCompat()
    {
    }

    public static int getLayoutDirection(Drawable drawable)
    {
    /* block-local class not found */
    class DrawableImpl {}

        return IMPL.getLayoutDirection(drawable);
    }

    public static boolean isAutoMirrored(Drawable drawable)
    {
        return IMPL.isAutoMirrored(drawable);
    }

    public static void jumpToCurrentState(Drawable drawable)
    {
        IMPL.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean flag)
    {
        IMPL.setAutoMirrored(drawable, flag);
    }

    public static void setHotspot(Drawable drawable, float f, float f1)
    {
        IMPL.setHotspot(drawable, f, f1);
    }

    public static void setHotspotBounds(Drawable drawable, int i, int j, int k, int l)
    {
        IMPL.setHotspotBounds(drawable, i, j, k, l);
    }

    public static void setLayoutDirection(Drawable drawable, int i)
    {
        IMPL.setLayoutDirection(drawable, i);
    }

    public static void setTint(Drawable drawable, int i)
    {
        IMPL.setTint(drawable, i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorstatelist)
    {
        IMPL.setTintList(drawable, colorstatelist);
    }

    public static void setTintMode(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        IMPL.setTintMode(drawable, mode);
    }

    public static Drawable unwrap(Drawable drawable)
    {
        Drawable drawable1 = drawable;
        if (drawable instanceof DrawableWrapper)
        {
            drawable1 = ((DrawableWrapper)drawable).getWrappedDrawable();
        }
        return drawable1;
    }

    public static Drawable wrap(Drawable drawable)
    {
        return IMPL.wrap(drawable);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
    /* block-local class not found */
    class BaseDrawableImpl {}

    /* block-local class not found */
    class HoneycombDrawableImpl {}

    /* block-local class not found */
    class JellybeanMr1DrawableImpl {}

    /* block-local class not found */
    class KitKatDrawableImpl {}

    /* block-local class not found */
    class LollipopDrawableImpl {}

    /* block-local class not found */
    class LollipopMr1DrawableImpl {}

    /* block-local class not found */
    class MDrawableImpl {}

        if (i >= 23)
        {
            IMPL = new MDrawableImpl();
        } else
        if (i >= 22)
        {
            IMPL = new LollipopMr1DrawableImpl();
        } else
        if (i >= 21)
        {
            IMPL = new LollipopDrawableImpl();
        } else
        if (i >= 19)
        {
            IMPL = new KitKatDrawableImpl();
        } else
        if (i >= 17)
        {
            IMPL = new JellybeanMr1DrawableImpl();
        } else
        if (i >= 11)
        {
            IMPL = new HoneycombDrawableImpl();
        } else
        {
            IMPL = new BaseDrawableImpl();
        }
    }
}
