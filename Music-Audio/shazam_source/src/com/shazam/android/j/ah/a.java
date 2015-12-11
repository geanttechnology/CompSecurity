// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ah;

import com.shazam.android.aq.c;
import com.shazam.f.b;
import com.shazam.model.configuration.TagCountConfiguration;
import com.shazam.server.response.config.AmpApis;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpTagCount;
import java.net.URL;

public final class a
    implements TagCountConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final URL a(String s)
    {
        String s1 = a.a().getAmpApis().getAmpTagCount().getHref();
        if (com.shazam.b.e.a.c(s1))
        {
            return com.shazam.b.c.a.a(s1.replace("{key}", s));
        } else
        {
            throw new b("Tag count endpoint is null");
        }
    }
}
