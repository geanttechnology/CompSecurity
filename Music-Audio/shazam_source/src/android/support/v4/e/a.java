// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.e;


// Referenced classes of package android.support.v4.e:
//            b

public final class android.support.v4.e.a
{
    static interface a
    {

        public abstract String a(String s);

        public abstract String b(String s);
    }

    static final class b
        implements a
    {

        public final String a(String s)
        {
            return null;
        }

        public final String b(String s)
        {
            return s;
        }

        b()
        {
        }
    }

    static final class c
        implements a
    {

        public final String a(String s)
        {
            return android.support.v4.e.b.a(s);
        }

        public final String b(String s)
        {
            return android.support.v4.e.b.b(s);
        }

        c()
        {
        }
    }


    private static final a a;

    public static String a(String s)
    {
        return a.a(s);
    }

    public static String b(String s)
    {
        return a.b(s);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
