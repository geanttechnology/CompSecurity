// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import com.google.b.a.e;
import com.google.b.b;
import com.google.b.c.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
    implements y, Cloneable
{

    public static final d a = new d();
    public double b;
    public int c;
    public boolean d;
    public boolean e;
    public List f;
    public List g;

    public d()
    {
        b = -1D;
        c = 136;
        d = true;
        f = Collections.emptyList();
        g = Collections.emptyList();
    }

    public static boolean a(Class class1)
    {
        return !java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass());
    }

    public static boolean b(Class class1)
    {
        if (class1.isMemberClass())
        {
            boolean flag;
            if ((class1.getModifiers() & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }

    public final d a()
    {
        d d1;
        try
        {
            d1 = (d)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return d1;
    }

    public final x a(f f1, a a1)
    {
        Class class1 = a1.a;
        boolean flag = a(class1, true);
        boolean flag1 = a(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new x(flag1, flag, f1, a1) {

                final boolean a;
                final boolean b;
                final f c;
                final a d;
                final d e;
                private x f;

                private x a()
                {
                    x x1 = f;
                    if (x1 != null)
                    {
                        return x1;
                    } else
                    {
                        x x2 = c.a(e, d);
                        f = x2;
                        return x2;
                    }
                }

                public final Object a(com.google.b.d.a a2)
                {
                    if (a)
                    {
                        a2.o();
                        return null;
                    } else
                    {
                        return a().a(a2);
                    }
                }

                public final void a(c c1, Object obj)
                {
                    if (b)
                    {
                        c1.f();
                        return;
                    } else
                    {
                        a().a(c1, obj);
                        return;
                    }
                }

            
            {
                e = d.this;
                a = flag;
                b = flag1;
                c = f1;
                d = a1;
                super();
            }
            };
        }
    }

    public final boolean a(com.google.b.a.d d1, e e1)
    {
        boolean flag;
        if (d1 != null && d1.a() > b)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            if (e1 != null && e1.a() <= b)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean a(Class class1, boolean flag)
    {
        if (b != -1D && !a((com.google.b.a.d)class1.getAnnotation(com/google/b/a/d), (e)class1.getAnnotation(com/google/b/a/e)))
        {
            return true;
        }
        if (!d && b(class1))
        {
            return true;
        }
        if (a(class1))
        {
            return true;
        }
        Object obj;
        if (flag)
        {
            obj = f;
        } else
        {
            obj = g;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            if (((b)((Iterator) (obj)).next()).shouldSkipClass(class1))
            {
                return true;
            }
        }

        return false;
    }

    protected final Object clone()
    {
        return a();
    }

}
