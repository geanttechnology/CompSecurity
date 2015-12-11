// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzlr;

// Referenced classes of package com.google.android.gms.common.stats:
//            zzd

public final class 
{

    public static zzlr zzahH;
    public static zzlr zzahI = zzlr.zzu("gms:common:stats:connections:ignored_calling_processes", "");
    public static zzlr zzahJ = zzlr.zzu("gms:common:stats:connections:ignored_calling_services", "");
    public static zzlr zzahK = zzlr.zzu("gms:common:stats:connections:ignored_target_processes", "");
    public static zzlr zzahL = zzlr.zzu("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static zzlr zzahM = zzlr.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(0x927c0L));

    static 
    {
        zzahH = zzlr.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
    }
}
