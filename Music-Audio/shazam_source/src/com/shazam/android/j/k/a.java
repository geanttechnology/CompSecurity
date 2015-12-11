// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.k;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.GimbalConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSettings;
import com.shazam.server.response.config.GimbalAmpSetting;

public final class a
    implements GimbalConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final boolean a()
    {
        return a.a().getSettings().getGimbal().isEnabled();
    }

    public final String b()
    {
        return a.a().getSettings().getGimbal().getApiKey();
    }
}
