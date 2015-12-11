// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils.do;

import io.presage.utils.do.do.b;
import io.presage.utils.do.do.c;
import java.util.List;

public interface io.presage.utils.do.a
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(io/presage/utils/do/a$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("INTERSTITIAL", 0);
            b = new a("POSTITIAL", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void a(int i);

    public abstract void a(long l);

    public abstract void a(c c1);

    public abstract void a(String s, Object obj);

    public abstract void a(String s, Object obj, b b1);

    public abstract void a(String s, Object obj, b b1, a a1);

    public abstract void a(List list);

    public abstract boolean a();

    public abstract String b();

    public abstract void b(int i);

    public abstract void c(int i);
}
