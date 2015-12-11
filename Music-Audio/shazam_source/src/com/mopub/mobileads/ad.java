// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

final class ad
    implements Serializable
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/mopub/mobileads/ad$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("NONE", 0);
            b = new a("IMAGE", 1);
            c = new a("JAVASCRIPT", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/mopub/mobileads/ad$b, s);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("STATIC_RESOURCE", 0);
            b = new b("HTML_RESOURCE", 1);
            c = new b("IFRAME_RESOURCE", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private static final List f = Arrays.asList(new String[] {
        "image/jpeg", "image/png", "image/bmp", "image/gif"
    });
    private static final List g = Arrays.asList(new String[] {
        "application/x-javascript"
    });
    String a;
    b b;
    a c;
    int d;
    int e;

    public final String a(String s, String s1)
    {
        String s2 = s1;
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[b.values().length];
                try
                {
                    a[b.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[b.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[b.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[b.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 44
    //                   2 42
    //                   3 42;
           goto _L1 _L2 _L3 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        s2 = null;
_L5:
        return s2;
_L2:
        if (a.b == c)
        {
            return s;
        }
        s2 = s1;
        if (a.c != c)
        {
            return null;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

}
