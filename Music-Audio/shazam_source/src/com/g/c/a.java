// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package com.g.c:
//            u, x

abstract class com.g.c.a
{
    static final class a extends WeakReference
    {

        final com.g.c.a a;

        public a(com.g.c.a a1, Object obj, ReferenceQueue referencequeue)
        {
            super(obj, referencequeue);
            a = a1;
        }
    }


    final u a;
    final x b;
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

    com.g.c.a(u u1, Object obj, x x, int i1, int j1, int k1, Drawable drawable, 
            String s, Object obj1, boolean flag)
    {
        a = u1;
        b = x;
        if (obj == null)
        {
            u1 = null;
        } else
        {
            u1 = new a(this, obj, u1.k);
        }
        c = u1;
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

    abstract void a(Bitmap bitmap, u.d d1);

    void b()
    {
        l = true;
    }

    Object c()
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.get();
        }
    }
}
