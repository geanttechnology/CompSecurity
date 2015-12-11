// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ao;

import com.shazam.b.a.e;
import com.shazam.b.e.a;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.streaming.StreamingConnectionState;
import com.shazam.model.streaming.SubscriptionType;

public final class d
    implements e
{

    private final StreamingConnectionState a;
    private final PlaybackProvider b;

    public d(StreamingConnectionState streamingconnectionstate, PlaybackProvider playbackprovider)
    {
        a = streamingconnectionstate;
        b = playbackprovider;
    }

    public final boolean apply(Object obj)
    {
        obj = (PlaylistItem)obj;
        return obj != null && com.shazam.b.e.a.c(((PlaylistItem) (obj)).a().a(b)) && a.a() && a.g().allowsPlayback();
    }
}
