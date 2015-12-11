// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public interface bi
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tapjoy/internal/bi$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("GET", 0);
            b = new a("POST", 1);
            c = new a("PUT", 2);
            d = new a("DELETE", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

}
