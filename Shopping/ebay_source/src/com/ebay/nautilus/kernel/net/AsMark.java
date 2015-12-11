// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.os.SystemClock;

public final class AsMark
{
    public static final class AsMarkName extends Enum
    {

        private static final AsMarkName $VALUES[];
        public static final AsMarkName activity_app_backgrounded;
        public static final AsMarkName activity_app_foregrounded;
        public static final AsMarkName activity_atf_render;
        public static final AsMarkName activity_closed;
        public static final AsMarkName activity_first_render;
        public static final AsMarkName activity_reloaded;
        public static final AsMarkName activity_start;
        public final int value = 1 << ordinal();

        public static AsMarkName valueOf(String s)
        {
            return (AsMarkName)Enum.valueOf(com/ebay/nautilus/kernel/net/AsMark$AsMarkName, s);
        }

        public static AsMarkName[] values()
        {
            return (AsMarkName[])$VALUES.clone();
        }

        static 
        {
            activity_start = new AsMarkName("activity_start", 0);
            activity_first_render = new AsMarkName("activity_first_render", 1);
            activity_atf_render = new AsMarkName("activity_atf_render", 2);
            activity_reloaded = new AsMarkName("activity_reloaded", 3);
            activity_closed = new AsMarkName("activity_closed", 4);
            activity_app_foregrounded = new AsMarkName("activity_app_foregrounded", 5);
            activity_app_backgrounded = new AsMarkName("activity_app_backgrounded", 6);
            $VALUES = (new AsMarkName[] {
                activity_start, activity_first_render, activity_atf_render, activity_reloaded, activity_closed, activity_app_foregrounded, activity_app_backgrounded
            });
        }

        private AsMarkName(String s, int i)
        {
            super(s, i);
        }
    }


    public final AsMarkName name;
    public final long timestamp = SystemClock.elapsedRealtime();

    public AsMark(AsMarkName asmarkname)
    {
        name = asmarkname;
    }

    public String toString()
    {
        return (new StringBuilder()).append("{name=").append(name).append(",timestamp=").append(timestamp).append('}').toString();
    }
}
