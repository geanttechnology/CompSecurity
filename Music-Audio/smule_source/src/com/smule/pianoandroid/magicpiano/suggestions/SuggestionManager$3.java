// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.suggestions;

import android.content.SharedPreferences;
import com.smule.android.f.p;
import com.smule.android.network.managers.x;
import com.smule.pianoandroid.a.z;

// Referenced classes of package com.smule.pianoandroid.magicpiano.suggestions:
//            c

class a
    implements com.smule.android.network.managers.r.RecommedationSelectCallback
{

    final Long a;
    final c b;

    public void handleResponse(x x1)
    {
        p.a(z.a().b().edit().putBoolean("ONBOARDING_REPORTED", x1.a()));
        if (x1.a() || a.longValue() + 0x5265c00L < System.currentTimeMillis())
        {
            c.a().a(true);
        }
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((x)obj);
    }

    tionSelectCallback(c c1, Long long1)
    {
        b = c1;
        a = long1;
        super();
    }
}
