// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v4.view.a:
//            b

public final class android.support.v4.view.a.c
{
    static interface a
    {

        public abstract Object a(android.support.v4.view.a.c c1);
    }

    static final class b extends d
    {

        public final Object a(android.support.v4.view.a.c c1)
        {
            return new d._cls1(new d.a(this, c1) {

                final android.support.v4.view.a.c a;
                final b b;

                public final boolean a()
                {
                    return android.support.v4.view.a.c.b();
                }

                public final List b()
                {
                    android.support.v4.view.a.c.c();
                    new ArrayList();
                    throw new NullPointerException();
                }

                public final Object c()
                {
                    android.support.v4.view.a.c.a();
                    return null;
                }

            
            {
                b = b1;
                a = c1;
                super();
            }
            });
        }

        b()
        {
        }
    }

    static final class c extends d
    {

        public final Object a(android.support.v4.view.a.c c1)
        {
            return new e._cls1(new e.a(this, c1) {

                final android.support.v4.view.a.c a;
                final c b;

                public final boolean a()
                {
                    return android.support.v4.view.a.c.b();
                }

                public final List b()
                {
                    android.support.v4.view.a.c.c();
                    new ArrayList();
                    throw new NullPointerException();
                }

                public final Object c()
                {
                    android.support.v4.view.a.c.a();
                    return null;
                }

                public final Object d()
                {
                    android.support.v4.view.a.c.d();
                    return null;
                }

            
            {
                b = c1;
                a = c2;
                super();
            }
            });
        }

        c()
        {
        }
    }

    static class d
        implements a
    {

        public Object a(android.support.v4.view.a.c c1)
        {
            return null;
        }

        d()
        {
        }
    }


    private static final a b;
    public final Object a;

    public android.support.v4.view.a.c()
    {
        a = b.a(this);
    }

    public android.support.v4.view.a.c(Object obj)
    {
        a = obj;
    }

    public static android.support.v4.view.a.b a()
    {
        return null;
    }

    public static boolean b()
    {
        return false;
    }

    public static List c()
    {
        return null;
    }

    public static android.support.v4.view.a.b d()
    {
        return null;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            b = new c();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            b = new b();
        } else
        {
            b = new d();
        }
    }
}
