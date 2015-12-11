// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7:
//            aa, w, x, y, 
//            z, v

public class u
{
    static class a
        implements b
    {

        public void a(Drawable drawable)
        {
        }

        public void a(Drawable drawable, float f1, float f2)
        {
        }

        public void a(Drawable drawable, int i)
        {
            w.a(drawable, i);
        }

        public void a(Drawable drawable, int i, int j, int k, int l)
        {
        }

        public void a(Drawable drawable, ColorStateList colorstatelist)
        {
            w.a(drawable, colorstatelist);
        }

        public void a(Drawable drawable, android.graphics.PorterDuff.Mode mode)
        {
            w.a(drawable, mode);
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
            return w.a(drawable);
        }

        a()
        {
        }
    }

    static interface b
    {

        public abstract void a(Drawable drawable);

        public abstract void a(Drawable drawable, float f1, float f2);

        public abstract void a(Drawable drawable, int i);

        public abstract void a(Drawable drawable, int i, int j, int k, int l);

        public abstract void a(Drawable drawable, ColorStateList colorstatelist);

        public abstract void a(Drawable drawable, android.graphics.PorterDuff.Mode mode);

        public abstract void a(Drawable drawable, boolean flag);

        public abstract boolean b(Drawable drawable);

        public abstract Drawable c(Drawable drawable);
    }

    static class c extends a
    {

        public void a(Drawable drawable)
        {
            x.a(drawable);
        }

        public Drawable c(Drawable drawable)
        {
            return x.b(drawable);
        }

        c()
        {
        }
    }

    static class d extends c
    {

        public void a(Drawable drawable, boolean flag)
        {
            y.a(drawable, flag);
        }

        public boolean b(Drawable drawable)
        {
            return y.a(drawable);
        }

        public Drawable c(Drawable drawable)
        {
            return y.b(drawable);
        }

        d()
        {
        }
    }

    static class e extends d
    {

        public void a(Drawable drawable, float f1, float f2)
        {
            z.a(drawable, f1, f2);
        }

        public void a(Drawable drawable, int i)
        {
            z.a(drawable, i);
        }

        public void a(Drawable drawable, int i, int j, int k, int l)
        {
            z.a(drawable, i, j, k, l);
        }

        public void a(Drawable drawable, ColorStateList colorstatelist)
        {
            z.a(drawable, colorstatelist);
        }

        public void a(Drawable drawable, android.graphics.PorterDuff.Mode mode)
        {
            z.a(drawable, mode);
        }

        public Drawable c(Drawable drawable)
        {
            return z.a(drawable);
        }

        e()
        {
        }
    }

    static class f extends e
    {

        public Drawable c(Drawable drawable)
        {
            return v.a(drawable);
        }

        f()
        {
        }
    }


    static final b a;

    public static void a(Drawable drawable)
    {
        a.a(drawable);
    }

    public static void a(Drawable drawable, float f1, float f2)
    {
        a.a(drawable, f1, f2);
    }

    public static void a(Drawable drawable, int i)
    {
        a.a(drawable, i);
    }

    public static void a(Drawable drawable, int i, int j, int k, int l)
    {
        a.a(drawable, i, j, k, l);
    }

    public static void a(Drawable drawable, ColorStateList colorstatelist)
    {
        a.a(drawable, colorstatelist);
    }

    public static void a(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        a.a(drawable, mode);
    }

    public static void a(Drawable drawable, boolean flag)
    {
        a.a(drawable, flag);
    }

    public static boolean b(Drawable drawable)
    {
        return a.b(drawable);
    }

    public static Drawable c(Drawable drawable)
    {
        return a.c(drawable);
    }

    public static Drawable d(Drawable drawable)
    {
        Drawable drawable1 = drawable;
        if (drawable instanceof aa)
        {
            drawable1 = ((aa)drawable).a();
        }
        return drawable1;
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 22)
        {
            a = new f();
        } else
        if (i >= 21)
        {
            a = new e();
        } else
        if (i >= 19)
        {
            a = new d();
        } else
        if (i >= 11)
        {
            a = new c();
        } else
        {
            a = new a();
        }
    }
}
