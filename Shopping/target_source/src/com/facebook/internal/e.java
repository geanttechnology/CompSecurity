// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import com.facebook.i;
import java.util.HashMap;
import java.util.Map;

public final class e
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        private static final a j[];
        private final int i;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/internal/e$a, s);
        }

        public static a[] values()
        {
            return (a[])j.clone();
        }

        public int a()
        {
            return com.facebook.i.l() + i;
        }

        static 
        {
            a = new a("Login", 0, 0);
            b = new a("Share", 1, 1);
            c = new a("Message", 2, 2);
            d = new a("Like", 3, 3);
            e = new a("GameRequest", 4, 4);
            f = new a("AppGroupCreate", 5, 5);
            g = new a("AppGroupJoin", 6, 6);
            h = new a("AppInvite", 7, 7);
            j = (new a[] {
                a, b, c, d, e, f, g, h
            });
        }

        private a(String s, int k, int l)
        {
            super(s, k);
            i = l;
        }
    }


    private static Map a = new HashMap();

}
