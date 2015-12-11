// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import io.presage.activities.PresageActivity;
import io.presage.activities.handlers.LegacyActivityHandler;
import io.presage.ads.d;
import io.presage.do.e;

// Referenced classes of package io.presage.formats:
//            a

public final class f extends a
{

    private LegacyActivityHandler e;

    public f(String s, String s1, d d1, e e1)
    {
        super(s, s1, d1, e1);
        a(d1);
    }

    public final void a(LegacyActivityHandler legacyactivityhandler)
    {
        e = legacyactivityhandler;
    }

    public final void b()
    {
        if (e != null)
        {
            e.finishActivity();
        }
        super.b();
    }

    public final void c()
    {
        Object obj = (String)a("launch_type");
        if (((String) (obj)).equals("sdk"))
        {
            obj = new Intent();
            ((Intent) (obj)).setClassName(h(), io/presage/activities/PresageActivity.getName());
            ((Intent) (obj)).setFlags(0x20000000);
            ((Intent) (obj)).putExtra("io.presage.extras.ADVERT_ID", a.c());
        } else
        if (((String) (obj)).equals("app"))
        {
            obj = h().getPackageManager().getLaunchIntentForPackage((String)a("launch_package"));
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((Intent) (obj)).addFlags(0x10000000);
            h().startActivity(((Intent) (obj)));
        }
    }

    public final void d()
    {
    }
}
