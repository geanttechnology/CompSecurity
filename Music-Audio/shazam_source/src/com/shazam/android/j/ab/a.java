// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ab;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.SignUpConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSetting;
import com.shazam.server.response.config.AmpSettings;
import com.shazam.server.response.config.AmpStyles;

public final class a
    implements SignUpConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final String a()
    {
        return a.a().getAmpStyles().getCaption();
    }

    public final boolean b()
    {
        return a.a().getSettings().getOnboarding().isEnabled();
    }
}
