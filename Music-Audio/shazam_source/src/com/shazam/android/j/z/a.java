// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.z;

import com.shazam.android.aq.c;
import com.shazam.f.b;
import com.shazam.model.configuration.SearchConfiguration;
import com.shazam.server.response.config.AmpApis;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSearch;
import com.shazam.server.response.config.AmpSetting;
import com.shazam.server.response.config.AmpSettings;
import java.net.URL;
import java.net.URLEncoder;

public final class a
    implements SearchConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final URL a(String s)
    {
        String s1 = a.a().getAmpApis().getAmpSearch().getHref();
        if (com.shazam.b.e.a.c(s1))
        {
            return com.shazam.b.c.a.a(s1.replace("{searchTerm}", URLEncoder.encode(s, "UTF-8")));
        } else
        {
            throw new b("Tag search endpoint is null");
        }
    }

    public final boolean a()
    {
        return a.a().getSettings().getSearchEducationOverlay().isEnabled();
    }
}
