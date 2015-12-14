// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.engine.ab;
import com.bumptech.glide.load.engine.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import myobfuscated.af.c;
import myobfuscated.af.d;
import myobfuscated.af.e;
import myobfuscated.af.g;
import myobfuscated.aj.i;
import myobfuscated.ak.a;
import myobfuscated.q.f;
import myobfuscated.v.ag;
import myobfuscated.v.ah;

public final class Registry
{

    public final myobfuscated.af.a a = new myobfuscated.af.a();
    public final g b = new g();
    public final f c = new f();
    private final ah d;
    private final e e = new e();
    private final myobfuscated.ac.e f = new myobfuscated.ac.e();
    private final d g = new d();
    private final c h = new c();
    private final android.support.v4.util.Pools.Pool i = myobfuscated.ak.a.a();

    public Registry(Context context)
    {
        d = new ah(context.getApplicationContext(), i);
    }

    public final Registry a(Class class1, com.bumptech.glide.load.a a1)
    {
        a.a(class1, a1);
        return this;
    }

    public final Registry a(Class class1, com.bumptech.glide.load.g g1)
    {
        b.a(class1, g1);
        return this;
    }

    public final Registry a(Class class1, Class class2, com.bumptech.glide.load.f f1)
    {
        e.a(f1, class1, class2);
        return this;
    }

    public final Registry a(Class class1, Class class2, myobfuscated.ac.d d1)
    {
        f.a(class1, class2, d1);
        return this;
    }

    public final Registry a(Class class1, Class class2, ag ag)
    {
        d.a(class1, class2, ag);
        return this;
    }

    public final Registry a(myobfuscated.q.e e1)
    {
        c.a(e1);
        return this;
    }

    public final ab a(Class class1, Class class2, Class class3)
    {
        ab ab1 = h.b(class1, class2, class3);
        Object obj = ab1;
        if (ab1 == null)
        {
            obj = ab1;
            if (!h.a(class1, class2, class3))
            {
                obj = new ArrayList();
                for (Iterator iterator = e.b(class1, class2).iterator(); iterator.hasNext();)
                {
                    Class class4 = (Class)iterator.next();
                    Iterator iterator1 = f.b(class4, class3).iterator();
                    while (iterator1.hasNext()) 
                    {
                        Class class5 = (Class)iterator1.next();
                        ((List) (obj)).add(new j(class1, class4, class5, e.a(class1, class4), f.a(class4, class5), i));
                    }
                }

                c c1;
                if (((List) (obj)).isEmpty())
                {
                    obj = null;
                } else
                {
                    obj = new ab(class1, class2, class3, ((List) (obj)), i);
                }
                c1 = h;
                synchronized (c1.a)
                {
                    c1.a.put(new i(class1, class2, class3), obj);
                }
            }
        }
        return ((ab) (obj));
        class1;
        arraymap;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public final List a(Object obj)
    {
        List list = d.a(obj);
        if (list.isEmpty())
        {
            throw new NoModelLoaderAvailableException(obj);
        } else
        {
            return list;
        }
    }

    public final Registry b(Class class1, Class class2, com.bumptech.glide.load.f f1)
    {
        e.b(f1, class1, class2);
        return this;
    }

    public final List b(Class class1, Class class2, Class class3)
    {
        Object obj = g.a(class1, class2);
        if (obj == null)
        {
            obj = new ArrayList();
            for (Iterator iterator = d.a(class1).iterator(); iterator.hasNext();)
            {
                Object obj1 = (Class)iterator.next();
                obj1 = e.b(((Class) (obj1)), class2).iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    Class class4 = (Class)((Iterator) (obj1)).next();
                    if (!f.b(class4, class3).isEmpty() && !((List) (obj)).contains(class4))
                    {
                        ((List) (obj)).add(class4);
                    }
                }
            }

            d d1 = g;
            List list = Collections.unmodifiableList(((List) (obj)));
            synchronized (d1.a)
            {
                d1.a.put(new i(class1, class2), list);
            }
            return ((List) (obj));
        } else
        {
            return ((List) (obj));
        }
        class1;
        class3;
        JVM INSTR monitorexit ;
        throw class1;
    }

    private class NoModelLoaderAvailableException extends MissingComponentException
    {
        private class MissingComponentException extends RuntimeException
        {

            public MissingComponentException(String s)
            {
                super(s);
            }
        }


        public NoModelLoaderAvailableException(Class class1, Class class2)
        {
            super((new StringBuilder("Failed to find any ModelLoaders for model: ")).append(class1).append(" and data: ").append(class2).toString());
        }

        public NoModelLoaderAvailableException(Object obj)
        {
            super((new StringBuilder("Failed to find any ModelLoaders for model: ")).append(obj).toString());
        }
    }

}
