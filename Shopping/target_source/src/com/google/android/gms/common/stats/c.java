// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import com.google.android.gms.b.ct;

// Referenced classes of package com.google.android.gms.common.stats:
//            d

public final class c
{
    public static final class a
    {

        public static ct a;
        public static ct b = ct.a("gms:common:stats:connections:ignored_calling_processes", "");
        public static ct c = ct.a("gms:common:stats:connections:ignored_calling_services", "");
        public static ct d = ct.a("gms:common:stats:connections:ignored_target_processes", "");
        public static ct e = ct.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static ct f = ct.a("gms:common:stats:connections:time_out_duration", Long.valueOf(0x927c0L));

        static 
        {
            a = ct.a("gms:common:stats:connections:level", Integer.valueOf(d.a));
        }
    }


    public static ct a = ct.a("gms:common:stats:debug", false);
    public static ct b = ct.a("gms:common:stats:max_num_of_events", Integer.valueOf(100));

}
