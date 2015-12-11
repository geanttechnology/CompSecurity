// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import com.shazam.b.b;
import com.shazam.model.store.OrderedStores;
import com.shazam.server.response.play.Streams;

// Referenced classes of package com.shazam.model.player:
//            ProviderPlaybackIds

public interface ProviderPlaybackIdsExtractor
{

    public static final ProviderPlaybackIdsExtractor NO_OP = (ProviderPlaybackIdsExtractor)b.a(com/shazam/model/player/ProviderPlaybackIdsExtractor);

    public abstract ProviderPlaybackIds a(Streams streams, OrderedStores orderedstores);

}
