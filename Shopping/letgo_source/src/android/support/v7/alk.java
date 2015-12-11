// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public class alk
{
    public static class a
    {

        private int a;
        private int b;
        private int c;

        static int a(a a1)
        {
            return a1.a;
        }

        static int b(a a1)
        {
            return a1.b;
        }

        static int c(a a1)
        {
            return a1.c;
        }

        public a a(int i)
        {
            a = i;
            return this;
        }

        public alk a()
        {
            return new alk(this);
        }

        public a b(int i)
        {
            b = i;
            return this;
        }

        public a c(int i)
        {
            c = i;
            return this;
        }

        public a()
        {
            a = 3000;
            b = 0;
            c = 0;
        }
    }


    public static final alk a = (new a()).a(3000).a();
    final int b;
    final int c;
    final int d;

    private alk(a a1)
    {
        b = a.a(a1);
        c = a.b(a1);
        d = a.c(a1);
    }


    public String toString()
    {
        return (new StringBuilder()).append("Configuration{durationInMilliseconds=").append(b).append(", inAnimationResId=").append(c).append(", outAnimationResId=").append(d).append('}').toString();
    }

}
