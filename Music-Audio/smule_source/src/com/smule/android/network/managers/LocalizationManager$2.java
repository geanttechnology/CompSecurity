// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.managers.a.c;

// Referenced classes of package com.smule.android.network.managers:
//            LocalizationManager, m, n

class c
    implements tLocalizationPackageListener
{

    final c a;
    final String b;
    final Runnable c;
    final LocalizationManager d;

    public void handleResponse(m m1)
    {
        m1 = m1.b();
        if (m1 != null)
        {
            a.a(m1);
            m1 = m1.a();
            android.content.or or = LocalizationManager.a(d).getSharedPreferences((new StringBuilder()).append("localized_").append(b).toString(), 0).edit();
            or.putString("config", m1);
            p.a(or);
            aa.a(LocalizationManager.b(), (new StringBuilder()).append("Saved ").append(m1).toString());
        }
        if (c != null)
        {
            c.run();
        }
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((m)obj);
    }

    tLocalizationPackageListener(LocalizationManager localizationmanager, c c1, String s, Runnable runnable)
    {
        d = localizationmanager;
        a = c1;
        b = s;
        c = runnable;
        super();
    }
}
