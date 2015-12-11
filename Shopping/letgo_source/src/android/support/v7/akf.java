// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            aky, alb

abstract class akf
{
    static class a extends WeakReference
    {

        final akf a;

        public a(akf akf1, Object obj, ReferenceQueue referencequeue)
        {
            super(obj, referencequeue);
            a = akf1;
        }
    }


    final aky a;
    final alb b;
    final WeakReference c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    akf(aky aky1, Object obj, alb alb1, int i1, int j1, int k1, Drawable drawable, 
            String s, Object obj1, boolean flag)
    {
        a = aky1;
        b = alb1;
        if (obj == null)
        {
            aky1 = null;
        } else
        {
            aky1 = new a(this, obj, aky1.i);
        }
        c = aky1;
        e = i1;
        f = j1;
        d = flag;
        g = k1;
        h = drawable;
        i = s;
        if (obj1 == null)
        {
            obj1 = this;
        }
        j = obj1;
    }

    abstract void a();

    abstract void a(Bitmap bitmap, aky.d d1);

    void b()
    {
        l = true;
    }

    alb c()
    {
        return b;
    }

    Object d()
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.get();
        }
    }

    String e()
    {
        return i;
    }

    boolean f()
    {
        return l;
    }

    boolean g()
    {
        return k;
    }

    int h()
    {
        return e;
    }

    int i()
    {
        return f;
    }

    aky j()
    {
        return a;
    }

    aky.e k()
    {
        return b.r;
    }

    Object l()
    {
        return j;
    }
}
