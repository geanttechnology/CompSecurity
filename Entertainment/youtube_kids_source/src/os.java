// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;

public class os
    implements bmj
{

    public final bqb a = new bqb();
    private Context b;
    private ContentResolver c;
    private String d;
    private String e[];
    private final bmr f = new ot(this);

    public os(Context context, ContentResolver contentresolver, String s1)
    {
        b = context;
        c = contentresolver;
        d = s1;
    }

    private int a(String s1, int i1)
    {
        s1 = a(s1);
        if (s1 == null)
        {
            return i1;
        } else
        {
            return bcf.a(c, s1, i1);
        }
    }

    private String a(String s1)
    {
        if (e == null)
        {
            String s2 = a.a(b, b.getPackageManager());
            String s3 = a.f(b);
            e = (new String[] {
                a(d, s2, s3), a(d, s2, "*"), a(d, "*", s3), a(d, "*", "*"), a("*", "*", s3), a("*", "*", "*")
            });
        }
        String as[] = e;
        int j1 = as.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            String s4 = as[i1];
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(s4).append(":").append(s1);
            s4 = stringbuilder.toString();
            if (bcf.a(c, s4, null) != null)
            {
                return s4;
            }
        }

        return null;
    }

    private String a(String s1, String s2)
    {
        s1 = a(s1);
        if (s1 == null)
        {
            return s2;
        } else
        {
            return bcf.a(c, s1, s2);
        }
    }

    private static String a(String s1, String s2, String s3)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("youtube:").append(s1).append(":").append(s2).append(":").append(s3);
        return stringbuilder.toString();
    }

    public final long a(String s1, long l1)
    {
        s1 = a(s1);
        if (s1 == null)
        {
            return l1;
        } else
        {
            return bcf.a(c, s1, l1);
        }
    }

    public final bzj a()
    {
        return bzj.a(a("gdata_version", "2.1"));
    }

    public void a(SharedPreferences sharedpreferences)
    {
        a.a(sharedpreferences);
    }

    public final boolean a(String s1, boolean flag)
    {
        s1 = a(s1);
        if (s1 == null)
        {
            return flag;
        } else
        {
            return bcf.a(c, s1, flag);
        }
    }

    public final boolean b()
    {
        return a("enable_device_retention", true);
    }

    public final String c()
    {
        return a("adsense_query_domain", "googleads.g.doubleclick.net");
    }

    public final String d()
    {
        return a("adsense_query_domain", "/pagead/ads");
    }

    public final boolean e()
    {
        return a("is_low_end_mobile_network", false);
    }

    public final boolean f()
    {
        return a("device_supports_720p_playback", true);
    }

    public final boolean g()
    {
        return a("device_supports_1080p_playback", true);
    }

    public final boolean h()
    {
        return a("device_supports_1440p_playback", true);
    }

    public final boolean i()
    {
        return a("device_supports_2160p_playback", true);
    }

    public final boolean j()
    {
        return a("can_use_texture_surface", true);
    }

    public final long k()
    {
        return a("task_master_delay_before_startup_millis", 10000L);
    }

    public final int l()
    {
        return a("maximum_consecutive_skipped_unplayable_videos", 10);
    }

    public final long m()
    {
        return ((Long)f.b_()).longValue();
    }

    public final boolean n()
    {
        return a("block_watch_next_on_player", false);
    }

    public boolean o()
    {
        return a("interaction_logging_enabled", false);
    }

    public final int p()
    {
        return a("interaction_logging_queue_flush_time_ms", 60000);
    }

    public final int q()
    {
        return a("interaction_logging_max_queue_size", 30);
    }

    public final boolean r()
    {
        return a("interaction_logging_dev_logging_enabled", false);
    }

    public final boolean s()
    {
        return a("enable_mdx_logs", true);
    }

    public final boolean t()
    {
        return a("enable_mdx_wake_up_screen", false);
    }

    public final bsf u()
    {
        bri bri1 = a.a;
        if (bri1.b == null)
        {
            if (bri1.a() && bri1.a.a.c != null)
            {
                bri1.b = new bsf(bri1.a.a.c);
            } else
            {
                bri1.b = new bsf(new dpz());
            }
        }
        return bri1.b;
    }

    public final btl v()
    {
        boolean flag = false;
        bri bri1 = a.a;
        if (bri1.d == null)
        {
            if (bri1.a() && bri1.a.a.g != null)
            {
                dww dww1 = bri1.a.a.g;
                dpd dpd = dww1.a;
                if (!dww1.b)
                {
                    flag = true;
                }
                bri1.d = new btl(dpd, flag);
            } else
            {
                bri1.d = new btl(null, false);
            }
        }
        return bri1.d;
    }

    public final coi w()
    {
        bri bri1 = a.a;
        if (bri1.c == null)
        {
            if (bri1.a())
            {
                bri1.c = new bsr(bri1.a.a.d);
            } else
            {
                bri1.c = new bsr(null);
            }
        }
        return bri1.c;
    }
}
