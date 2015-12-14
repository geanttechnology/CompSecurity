// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public interface bp
{
    public static interface a
    {

        public abstract void a();
    }

    public static final class b
    {

        public static final b a = new b();


        private b()
        {
        }
    }

    public static final class c
    {

        public static final c a = new c();
        public static final c b = new c();
        public static final c c = new c();


        private c()
        {
        }
    }

    public static interface d
    {

        public abstract void a(c c1, Object obj);
    }

    public static interface e
    {

        public abstract void a(c c1, Object obj, byte abyte0[], int i, int j, Object obj1);
    }

    public static interface f
    {

        public abstract void a(c c1, Object obj, int i, int j, Object obj1);
    }


    public abstract c a(Object obj, b b1, byte abyte0[], int i, e e1, Object obj1);

    public abstract c a(Object obj, byte abyte0[], int i, f f1, Object obj1);

    public abstract void a(Object obj);

    public abstract void a(String s, int i, d d1, a a1);

    public abstract void a(String s, int i, Vector vector, d d1, a a1);

    public abstract void b(Object obj);
}
