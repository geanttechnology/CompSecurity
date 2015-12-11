// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;

final class dd
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
        public static final a i;
        private static final a j[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/dd$a, s);
        }

        public static a[] values()
        {
            return (a[])j.clone();
        }

        static 
        {
            a = new a("RENDERED", 0);
            b = new a("VISIBLE", 1);
            c = new a("HIDDEN", 2);
            d = new a("DESTROYED", 3);
            e = new a("CLOSED", 4);
            f = new a("READY", 5);
            g = new a("RESIZED", 6);
            h = new a("BRIDGE_ADDED", 7);
            i = new a("BACK_BUTTON_PRESSED", 8);
            j = (new a[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private a(String s, int k)
        {
            super(s, k);
        }
    }


    final a a;
    final HashMap b = new HashMap();

    public dd(a a1)
    {
        a = a1;
    }
}
