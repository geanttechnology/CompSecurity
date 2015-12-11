// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.i;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.android.persistence.n.b;
import com.shazam.model.availability.AppAvailability;
import com.shazam.model.configuration.FacebookConfiguration;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class a
    implements FacebookConfiguration
{

    private static final List a = Collections.singletonList("email");
    private final h b;
    private final AppAvailability c;
    private final b d;

    public a(h h1, AppAvailability appavailability, b b1)
    {
        b = h1;
        c = appavailability;
        d = b1;
    }

    private String a(String s)
    {
        return b.a().b().getStringConfigEntry(s);
    }

    public final List a()
    {
        int i = 0;
        List list = a;
        String s = a("facebookreadpermissions");
        if (s == null)
        {
            return list;
        }
        String as[];
        if (com.shazam.b.e.a.a(s))
        {
            as = new String[0];
        } else
        {
            String as1[] = s.split(",");
            as = new String[as1.length];
            while (i < as1.length) 
            {
                as[i] = as1[i].trim();
                i++;
            }
        }
        return Arrays.asList(as);
    }

    public final boolean b()
    {
        return com.shazam.b.e.a.c(a("facebookappid"));
    }

    public final boolean c()
    {
        return b() && c.b() && com.facebook.share.b.a.c();
    }

    public final boolean d()
    {
        return d.b("pk_facebook_invite_friends_shown");
    }

    public final void e()
    {
        d.b("pk_facebook_invite_friends_shown", true);
    }

}
