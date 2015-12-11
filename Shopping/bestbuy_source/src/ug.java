// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;

public final class ug
{

    public static aco a = a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static aco b = a("gads:sdk_core_experiment_id", (String)null);
    public static aco c = a("gads:sdk_crash_report_enabled", false);
    public static aco d = a("gads:sdk_crash_report_full_stacktrace", false);
    public static aco e = a("gads:block_autoclicks", false);
    public static aco f = a("gads:block_autoclicks_experiment_id", (String)null);
    public static aco g = a("gads:spam_app_context:enabled", false);
    public static aco h = a("gads:spam_app_context:experiment_id", (String)null);
    public static aco i = a("gads:enable_content_fetching", false);
    public static aco j = a("gads:content_length_weight", 1);
    public static aco k = a("gads:content_age_weight", 1);
    public static aco l = a("gads:min_content_len", 11);
    public static aco m = a("gads:fingerprint_number", 10);
    public static aco n = a("gads:sleep_sec", 10);
    private static final Bundle o = new Bundle();
    private static boolean p = false;

    private static aco a(String s, int i1)
    {
        o.putInt(s, i1);
        return aco.a(s, Integer.valueOf(i1));
    }

    private static aco a(String s, String s1)
    {
        o.putString(s, s1);
        return aco.a(s, s1);
    }

    private static aco a(String s, boolean flag)
    {
        o.putBoolean(s, flag);
        return aco.a(s, flag);
    }

    public static Bundle a()
    {
        return o;
    }

    static 
    {
        p = true;
    }
}
