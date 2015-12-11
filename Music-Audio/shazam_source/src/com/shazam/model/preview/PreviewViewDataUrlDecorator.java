// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.preview;

import com.shazam.b.e.a;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.store.Store;
import com.shazam.model.store.Stores;
import java.util.Map;

// Referenced classes of package com.shazam.model.preview:
//            PreviewViewData

public class PreviewViewDataUrlDecorator
{

    public PreviewViewDataUrlDecorator()
    {
    }

    public static PreviewViewData a(PreviewViewData previewviewdata, PlaylistItem playlistitem, Stores stores)
    {
        Object obj = previewviewdata;
        if (previewviewdata == null)
        {
            obj = com.shazam.model.preview.PreviewViewData.Builder.a().b();
        }
        previewviewdata = com.shazam.model.preview.PreviewViewData.Builder.a(((PreviewViewData) (obj)));
        obj = com.shazam.model.player.PlaylistItem.Builder.a(playlistitem);
        playlistitem = com.shazam.model.player.ProviderPlaybackIds.Builder.a(playlistitem.a());
        stores = stores.a();
        if (stores != null)
        {
            stores = ((Store) (stores)).previewUrl;
            PlaybackProvider playbackprovider = PlaybackProvider.PREVIEW;
            ((com.shazam.model.player.ProviderPlaybackIds.Builder) (playlistitem)).providerTrackIdMap.put(playbackprovider, stores);
            if (com.shazam.b.e.a.c(stores))
            {
                obj.providerPlaybackIds = playlistitem.b();
                previewviewdata.playlistItem = ((com.shazam.model.player.PlaylistItem.Builder) (obj)).b();
                previewviewdata.b();
            }
        }
        return previewviewdata.b();
    }
}
