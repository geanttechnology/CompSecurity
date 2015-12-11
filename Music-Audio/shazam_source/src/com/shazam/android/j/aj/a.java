// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.aj;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.WearConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.Wear;

public final class a
    implements WearConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final boolean a()
    {
        return a.a().getWear().isShowLyrics();
    }
}
