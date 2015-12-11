// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

final class cf
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/cf$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("RELATIVE_LAYOUT", 0);
            b = new a("LINEAR_LAYOUT", 1);
            c = new a("FRAME_LAYOUT", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    cf()
    {
    }

    public static ViewGroup a(Context context, a a1, String s)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[a.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[a1.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 48
    //                   2 60;
           goto _L1 _L2 _L3
_L1:
        context = new LinearLayout(context);
_L5:
        context.setContentDescription(s);
        return context;
_L2:
        context = new RelativeLayout(context);
        continue; /* Loop/switch isn't completed */
_L3:
        context = new FrameLayout(context);
        if (true) goto _L5; else goto _L4
_L4:
    }
}
