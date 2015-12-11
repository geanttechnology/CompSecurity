// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j;

import com.shazam.model.configuration.RdioConfiguration;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.configuration.StoresConfiguration;
import java.util.List;

public final class n
{

    private final SpotifyConfiguration a;
    private final RdioConfiguration b;
    private final StoresConfiguration c;

    public n(SpotifyConfiguration spotifyconfiguration, RdioConfiguration rdioconfiguration, StoresConfiguration storesconfiguration)
    {
        a = spotifyconfiguration;
        b = rdioconfiguration;
        c = storesconfiguration;
    }

    public final boolean a()
    {
        return a.a() || b.a() || !c.c().isEmpty();
    }
}
