// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

// Referenced classes of package android.support.v4.widget:
//            h, i

public class g
{
    static class a
        implements c
    {

        public Object a(Context context)
        {
            return null;
        }

        public void a(Object obj, int i, int j)
        {
        }

        public boolean a(Object obj)
        {
            return true;
        }

        public boolean a(Object obj, float f)
        {
            return false;
        }

        public boolean a(Object obj, float f, float f1)
        {
            return false;
        }

        public boolean a(Object obj, int i)
        {
            return false;
        }

        public boolean a(Object obj, Canvas canvas)
        {
            return false;
        }

        public void b(Object obj)
        {
        }

        public boolean c(Object obj)
        {
            return false;
        }

        a()
        {
        }
    }

    static class b
        implements c
    {

        public Object a(Context context)
        {
            return h.a(context);
        }

        public void a(Object obj, int i, int j)
        {
            h.a(obj, i, j);
        }

        public boolean a(Object obj)
        {
            return h.a(obj);
        }

        public boolean a(Object obj, float f)
        {
            return h.a(obj, f);
        }

        public boolean a(Object obj, float f, float f1)
        {
            return h.a(obj, f);
        }

        public boolean a(Object obj, int i)
        {
            return h.a(obj, i);
        }

        public boolean a(Object obj, Canvas canvas)
        {
            return h.a(obj, canvas);
        }

        public void b(Object obj)
        {
            h.b(obj);
        }

        public boolean c(Object obj)
        {
            return h.c(obj);
        }

        b()
        {
        }
    }

    static interface c
    {

        public abstract Object a(Context context);

        public abstract void a(Object obj, int i, int j);

        public abstract boolean a(Object obj);

        public abstract boolean a(Object obj, float f);

        public abstract boolean a(Object obj, float f, float f1);

        public abstract boolean a(Object obj, int i);

        public abstract boolean a(Object obj, Canvas canvas);

        public abstract void b(Object obj);

        public abstract boolean c(Object obj);
    }

    static class d extends b
    {

        public boolean a(Object obj, float f, float f1)
        {
            return i.a(obj, f, f1);
        }

        d()
        {
        }
    }


    private static final c b;
    private Object a;

    public g(Context context)
    {
        a = b.a(context);
    }

    public void a(int i, int j)
    {
        b.a(a, i, j);
    }

    public boolean a()
    {
        return b.a(a);
    }

    public boolean a(float f)
    {
        return b.a(a, f);
    }

    public boolean a(float f, float f1)
    {
        return b.a(a, f, f1);
    }

    public boolean a(int i)
    {
        return b.a(a, i);
    }

    public boolean a(Canvas canvas)
    {
        return b.a(a, canvas);
    }

    public void b()
    {
        b.b(a);
    }

    public boolean c()
    {
        return b.c(a);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            b = new d();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b = new b();
        } else
        {
            b = new a();
        }
    }
}
