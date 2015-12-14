// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import myobfuscated.an.c;
import myobfuscated.ap.a;

public final class b
    implements j, Cloneable
{

    public static final b a = new b();
    public double b;
    public int c;
    public boolean d;
    public List e;
    public List f;

    public b()
    {
        b = -1D;
        c = 136;
        d = true;
        e = Collections.emptyList();
        f = Collections.emptyList();
    }

    private b a()
    {
        b b1;
        try
        {
            b1 = (b)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return b1;
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

    public final i a(com.millennialmedia.google.gson.b b1, a a1)
    {
        Class class1 = a1.a;
        boolean flag = a(class1, true);
        boolean flag1 = a(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new i(flag1, flag, b1, a1) {

                private i a;
                private boolean b;
                private boolean c;
                private com.millennialmedia.google.gson.b d;
                private a e;
                private b f;

                private i a()
                {
                    Object obj = a;
                    if (obj != null)
                    {
                        return ((i) (obj));
                    }
                    obj = d;
                    b b2 = f;
                    a a2 = e;
                    Iterator iterator = ((com.millennialmedia.google.gson.b) (obj)).a.iterator();
                    boolean flag2 = false;
                    while (iterator.hasNext()) 
                    {
                        Object obj1 = (j)iterator.next();
                        if (!flag2)
                        {
                            if (obj1 == b2)
                            {
                                flag2 = true;
                            }
                        } else
                        {
                            obj1 = ((j) (obj1)).a(((com.millennialmedia.google.gson.b) (obj)), a2);
                            if (obj1 != null)
                            {
                                a = ((i) (obj1));
                                return ((i) (obj1));
                            }
                        }
                    }
                    throw new IllegalArgumentException((new StringBuilder("GSON cannot serialize ")).append(a2).toString());
                }

                public final Object a(com.millennialmedia.google.gson.stream.a a2)
                {
                    if (b)
                    {
                        a2.o();
                        return null;
                    } else
                    {
                        return a().a(a2);
                    }
                }

                public final void a(com.millennialmedia.google.gson.stream.b b2, Object obj)
                {
                    if (c)
                    {
                        b2.e();
                        return;
                    } else
                    {
                        a().a(b2, obj);
                        return;
                    }
                }

            
            {
                f = b.this;
                b = flag;
                c = flag1;
                d = b2;
                e = a1;
                super();
            }
            };
        }
    }

    public final boolean a(Class class1, boolean flag)
    {
        if (b != -1D && !a((myobfuscated.an.b)class1.getAnnotation(myobfuscated/an/b), (c)class1.getAnnotation(myobfuscated/an/c)))
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
        if (flag)
        {
            class1 = e;
        } else
        {
            class1 = f;
        }
        for (class1 = class1.iterator(); class1.hasNext();)
        {
            if (((com.melnykov.fab.a)class1.next()).b())
            {
                return true;
            }
        }

        return false;
    }

    public final boolean a(myobfuscated.an.b b1, c c1)
    {
        boolean flag;
        if (b1 != null && b1.a() > b)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            if (c1 != null && c1.a() <= b)
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

    protected final Object clone()
    {
        return a();
    }

}
