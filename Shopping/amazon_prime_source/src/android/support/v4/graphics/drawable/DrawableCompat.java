// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.graphics.drawable:
//            DrawableCompatJellybeanMr1, DrawableCompatKitKat, DrawableCompatApi23

public class DrawableCompat
{
    static class BaseDrawableImpl
        implements DrawableImpl
    {

        public boolean isAutoMirrored(Drawable drawable)
        {
            return false;
        }

        public void setLayoutDirection(Drawable drawable, int i)
        {
        }

        BaseDrawableImpl()
        {
        }
    }

    static interface DrawableImpl
    {

        public abstract boolean isAutoMirrored(Drawable drawable);

        public abstract void setLayoutDirection(Drawable drawable, int i);
    }

    static class HoneycombDrawableImpl extends BaseDrawableImpl
    {

        HoneycombDrawableImpl()
        {
        }
    }

    static class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl
    {

        public void setLayoutDirection(Drawable drawable, int i)
        {
            DrawableCompatJellybeanMr1.setLayoutDirection(drawable, i);
        }

        JellybeanMr1DrawableImpl()
        {
        }
    }

    static class KitKatDrawableImpl extends JellybeanMr1DrawableImpl
    {

        public boolean isAutoMirrored(Drawable drawable)
        {
            return DrawableCompatKitKat.isAutoMirrored(drawable);
        }

        KitKatDrawableImpl()
        {
        }
    }

    static class LollipopDrawableImpl extends KitKatDrawableImpl
    {

        LollipopDrawableImpl()
        {
        }
    }

    static class LollipopMr1DrawableImpl extends LollipopDrawableImpl
    {

        LollipopMr1DrawableImpl()
        {
        }
    }

    static class MDrawableImpl extends LollipopMr1DrawableImpl
    {

        public void setLayoutDirection(Drawable drawable, int i)
        {
            DrawableCompatApi23.setLayoutDirection(drawable, i);
        }

        MDrawableImpl()
        {
        }
    }


    static final DrawableImpl IMPL;

    public DrawableCompat()
    {
    }

    public static boolean isAutoMirrored(Drawable drawable)
    {
        return IMPL.isAutoMirrored(drawable);
    }

    public static void setLayoutDirection(Drawable drawable, int i)
    {
        IMPL.setLayoutDirection(drawable, i);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
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
