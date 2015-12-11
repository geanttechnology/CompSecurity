// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ao;

import com.shazam.b.a.e;
import com.shazam.model.chart.TrackV2;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.social.ConnectionState;

public final class a
    implements e
{

    private final ConnectionState a;
    private final ConnectionState b;

    public a(ConnectionState connectionstate, ConnectionState connectionstate1)
    {
        a = connectionstate;
        b = connectionstate1;
    }

    public final boolean apply(Object obj)
    {
        obj = (TrackV2)obj;
        if (obj != null)
        {
            boolean flag2 = com.shazam.b.e.a.c(((TrackV2) (obj)).a().a(PlaybackProvider.PREVIEW));
            boolean flag;
            boolean flag1;
            if (a.a() && com.shazam.b.e.a.c(((TrackV2) (obj)).a().a(PlaybackProvider.RDIO)))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (b.a() && com.shazam.b.e.a.c(((TrackV2) (obj)).a().a(PlaybackProvider.SPOTIFY)))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag2 || flag || flag1)
            {
                return true;
            }
        }
        return false;
    }
}
