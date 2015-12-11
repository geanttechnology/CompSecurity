// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ae;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.model.configuration.StreamingTrackMappingsUrlConfiguration;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.net.URL;

public final class a
    implements StreamingTrackMappingsUrlConfiguration
{

    private final h a;

    public a(h h1)
    {
        a = h1;
    }

    public final URL a()
    {
        return com.shazam.b.c.a.a(a.a().b().getStringConfigEntry("providertrackmappings"));
    }
}
