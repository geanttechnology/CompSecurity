// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.tapjoy.internal:
//            r

public final class gm
{

    final r a;
    final r b;
    private final SharedPreferences c;

    public gm(Context context)
    {
        c = context.getApplicationContext().getSharedPreferences("fiverocks", 0);
        a = new r(c, "noMoreToday.date");
        b = new r(c, "noMoreToday.actionIds");
        b();
    }

    static String a()
    {
        return (new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())).format(new Date());
    }

    final void b()
    {
        for (String s = a.a(); s == null || a().equals(s);)
        {
            return;
        }

        a.a(null);
        b.a(null);
    }
}
