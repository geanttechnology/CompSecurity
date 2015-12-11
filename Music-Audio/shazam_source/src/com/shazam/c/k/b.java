// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.k;

import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.player.ProviderPlaybackIdsExtractor;
import com.shazam.model.store.OrderedStores;
import com.shazam.model.store.Store;
import com.shazam.server.response.actions.Action;
import com.shazam.server.response.actions.ActionType;
import com.shazam.server.response.play.Stream;
import com.shazam.server.response.play.Streams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
    implements ProviderPlaybackIdsExtractor
{

    public b()
    {
    }

    private static Action a(ActionType actiontype, Stream stream)
    {
        List list1 = Collections.emptyList();
        List list = list1;
        if (stream != null)
        {
            list = list1;
            if (stream.actions != null)
            {
                list = stream.actions;
            }
        }
        for (stream = list.iterator(); stream.hasNext();)
        {
            Action action = (Action)stream.next();
            if (action.type == actiontype)
            {
                return action;
            }
        }

        return null;
    }

    public final ProviderPlaybackIds a(Streams streams, OrderedStores orderedstores)
    {
        String s = null;
        com.shazam.model.player.ProviderPlaybackIds.Builder builder = com.shazam.model.player.ProviderPlaybackIds.Builder.a();
        PlaybackProvider playbackprovider = PlaybackProvider.RDIO;
        Object obj = a(ActionType.RDIO_PLAY, streams.rdioStream);
        PlaybackProvider playbackprovider1;
        PlaybackProvider playbackprovider2;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((Action) (obj)).id;
        }
        playbackprovider1 = PlaybackProvider.SPOTIFY;
        streams = a(ActionType.SPOTIFY_PLAY, streams.spotifyStream);
        if (streams == null)
        {
            streams = null;
        } else
        {
            streams = ((Action) (streams)).uri;
        }
        playbackprovider2 = PlaybackProvider.PREVIEW;
        if (orderedstores.stores.isEmpty())
        {
            orderedstores = null;
        } else
        {
            orderedstores = (Store)orderedstores.stores.get(0);
        }
        if (orderedstores != null)
        {
            s = ((Store) (orderedstores)).previewUrl;
        }
        orderedstores = new HashMap(3);
        orderedstores.put(playbackprovider, obj);
        orderedstores.put(playbackprovider1, streams);
        orderedstores.put(playbackprovider2, s);
        builder.providerTrackIdMap.clear();
        builder.providerTrackIdMap.putAll(orderedstores);
        return builder.b();
    }
}
