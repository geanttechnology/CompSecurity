// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.g;
import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h extends x
{

    public static final y a = new y() {

        public final x a(f f1, com.google.b.c.a a1)
        {
            if (a1.a == java/lang/Object)
            {
                return new h(f1, (byte)0);
            } else
            {
                return null;
            }
        }

    };
    private final f b;

    private h(f f1)
    {
        b = f1;
    }

    h(f f1, byte byte0)
    {
        this(f1);
    }

    public final Object a(a a1)
    {
        b b1 = a1.f();
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.google.b.d.b.values().length];
                try
                {
                    a[b.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[b.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[b.f.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[b.g.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[b.h.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[b.i.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.google.b.b.a._cls2.a[b1.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            a1.a();
            for (; a1.e(); arraylist.add(a(a1))) { }
            a1.b();
            return arraylist;

        case 2: // '\002'
            g g1 = new g();
            a1.c();
            for (; a1.e(); g1.put(a1.h(), a(a1))) { }
            a1.d();
            return g1;

        case 3: // '\003'
            return a1.i();

        case 4: // '\004'
            return Double.valueOf(a1.l());

        case 5: // '\005'
            return Boolean.valueOf(a1.j());

        case 6: // '\006'
            a1.k();
            return null;
        }
    }

    public final void a(c c1, Object obj)
    {
        if (obj == null)
        {
            c1.f();
            return;
        }
        x x1 = b.a(obj.getClass());
        if (x1 instanceof h)
        {
            c1.d();
            c1.e();
            return;
        } else
        {
            x1.a(c1, obj);
            return;
        }
    }

}
