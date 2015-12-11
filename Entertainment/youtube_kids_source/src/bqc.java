// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.util.Base64;

public final class bqc
{

    private final SharedPreferences a;
    private final bmi b;
    private final bon c;

    public bqc(SharedPreferences sharedpreferences, bmi bmi1, bon bon1)
    {
        a = (SharedPreferences)b.a(sharedpreferences);
        b = (bmi)b.a(bmi1);
        c = (bon)b.a(bon1);
    }

    public final void a()
    {
        b.b();
        Object obj = c;
        obj = new bop(((bon) (obj)).b, ((bon) (obj)).c.b());
        ((bop) (obj)).a(bqd.a);
        boo boo = c.e;
        Object obj1 = boo.a(boo.a(((bxi) (obj))));
        boo.a(((bxi) (obj)), obj1);
        obj = Base64.encodeToString(eun.a(((bri)obj1).a), 0);
        a.edit().putString("com.google.android.libraries.youtube.innertube.pref.inner_tube_config", ((String) (obj))).putLong("com.google.android.libraries.youtube.innertube.pref.inner_tube_config_last_sync_timestamp", b.b()).apply();
        bmo.d("New config values downloaded");
    }
}
