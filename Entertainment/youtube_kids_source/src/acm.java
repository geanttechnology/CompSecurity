// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;

public final class acm extends os
{

    private bmi b;

    public acm(Context context, ContentResolver contentresolver, bmi bmi1)
    {
        super(context, contentresolver, "kids");
        b = bmi1;
    }

    public final void a(SharedPreferences sharedpreferences)
    {
        super.a(sharedpreferences);
        sharedpreferences.edit().putLong("config_last_refresh_time", b.b()).apply();
    }

    public final void b(SharedPreferences sharedpreferences)
    {
        long l = 0L;
        long l2 = sharedpreferences.getLong("com.google.android.libraries.youtube.innertube.pref.inner_tube_config_last_sync_timestamp", 0L);
        long l1 = sharedpreferences.getLong("config_last_refresh_time", 0L);
        long l3 = b.b();
        if (l3 < l1)
        {
            sharedpreferences.edit().remove("config_last_refresh_time").apply();
        } else
        {
            l = l1;
        }
        if (l < l2)
        {
            super.a.a(sharedpreferences);
            sharedpreferences.edit().putLong("config_last_refresh_time", l3).apply();
        }
    }

    public final boolean o()
    {
        return a("interaction_logging_enabled", true);
    }

    public final Long x()
    {
        return Long.valueOf(a("time_between_upgrade_prompts_millis", 0x48190800L));
    }
}
