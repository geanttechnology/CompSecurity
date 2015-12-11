// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            ar

public class aq
{
    static interface a
    {

        public abstract String a(String s);

        public abstract String b(String s);
    }

    static class b
        implements a
    {

        public String a(String s)
        {
            return null;
        }

        public String b(String s)
        {
            return s;
        }

        b()
        {
        }
    }

    static class c
        implements a
    {

        public String a(String s)
        {
            return ar.a(s);
        }

        public String b(String s)
        {
            return ar.b(s);
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
