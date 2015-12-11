// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.view.animation.Animation;

public class ak
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
            return (a)Enum.valueOf(com/tapjoy/internal/ak$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("LEFT", 0);
            b = new a("RIGHT", 1);
            c = new a("UP", 2);
            d = new a("DOWN", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    protected final Animation a;

    public ak(Animation animation)
    {
        a = animation;
        animation.setDuration(400L);
    }

    public Animation a()
    {
        return a;
    }

    public final ak b()
    {
        a.setDuration(600L);
        return this;
    }

    // Unreferenced inner class com/tapjoy/internal/ak$1

/* anonymous class */
    public static final class _cls1
    {

        public static final int a[];

        static 
        {
            a = new int[a.values().length];
            try
            {
                a[a.a.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[a.b.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[a.c.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[a.d.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
