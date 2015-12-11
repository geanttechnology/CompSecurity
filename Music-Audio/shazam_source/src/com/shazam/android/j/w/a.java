// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.w;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.ProModeConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpProMode;
import com.shazam.server.response.follow.FollowData;

public final class a
    implements ProModeConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final boolean a()
    {
        return a.a().getAmpProMode().isEnabled();
    }

    public final FollowData b()
    {
        return a.a().getAmpProMode().getFollowKey();
    }
}
