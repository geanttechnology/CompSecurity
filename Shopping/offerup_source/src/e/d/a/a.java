// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;


// Referenced classes of package e.d.a:
//            b, c

public final class a
{

    private static final a a = new a();
    private static final Object b = new b();
    private static final Object c = new c();

    private a()
    {
    }

    public static a a()
    {
        return a;
    }

    public static Object a(Object obj)
    {
        Object obj1 = obj;
        if (obj == null)
        {
            obj1 = c;
        }
        return obj1;
    }

    public static Object b()
    {
        return b;
    }

    public static boolean b(Object obj)
    {
        return obj == b;
    }

    public static Object c(Object obj)
    {
        Object obj1 = obj;
        if (obj == c)
        {
            obj1 = null;
        }
        return obj1;
    }

}
