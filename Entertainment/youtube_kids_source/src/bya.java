// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public class bya extends bld
{

    public static final String b = bya.getCanonicalName();
    private final SharedPreferences c;
    private final bmi d;
    private final bqc e;

    public bya(SharedPreferences sharedpreferences, bmi bmi1, bqc bqc1, amv amv1)
    {
        super(amv1);
        c = (SharedPreferences)b.a(sharedpreferences);
        d = (bmi)b.a(bmi1);
        e = (bqc)b.a(bqc1);
    }

    public static long a(long l, long l1, SharedPreferences sharedpreferences)
    {
        return b(l, l1, sharedpreferences);
    }

    private static long b(long l, long l1, SharedPreferences sharedpreferences)
    {
        long l2 = sharedpreferences.getLong("com.google.android.libraries.youtube.innertube.pref.inner_tube_config_last_sync_timestamp", 0L);
        if (l < l2)
        {
            bmo.e("Resetting config resync schedule");
            sharedpreferences.edit().remove("com.google.android.libraries.youtube.innertube.pref.inner_tube_config_last_sync_timestamp").apply();
            return 0L;
        } else
        {
            return l2 + l1;
        }
    }

    protected final void a()
    {
        boolean flag;
        if (d.b() > b(d.b(), super.a.e, c) - 50L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        e.a();
        return;
        bou bou1;
        bou1;
        bmo.b("Scheduled config refresh failed");
        return;
    }

}
