// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.DownloadFileFactory;
import com.comcast.cim.utils.JsonDeserializer;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.xfinity.playerlib.model.consumable.EncodedWatchable;
import com.xfinity.playerlib.model.consumable.WatchableCodec;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.downloads:
//            PlayerDownloadMetaData, PersistentEntityCache, PlayerDownloadFile

public class DownloadableFileFactory extends DownloadFileFactory
{

    private final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/downloads/DownloadableFileFactory);
    private final JsonDeserializer downloadMetaDataDeserializer;
    private final PersistentEntityCache entityCache;
    private final WatchableCodec watchableCodec;

    public DownloadableFileFactory(PersistentEntityCache persistententitycache, JsonDeserializer jsondeserializer, WatchableCodec watchablecodec)
    {
        entityCache = persistententitycache;
        downloadMetaDataDeserializer = jsondeserializer;
        watchableCodec = watchablecodec;
    }

    public volatile DownloadFile create(IVirtuosoAsset ivirtuosoasset)
    {
        return create(ivirtuosoasset);
    }

    public PlayerDownloadFile create(IVirtuosoAsset ivirtuosoasset)
    {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        Object obj = (PlayerDownloadMetaData)downloadMetaDataDeserializer.deserialize(ivirtuosoasset.metadata(), com/xfinity/playerlib/model/downloads/PlayerDownloadMetaData);
        Object obj1 = ((PlayerDownloadMetaData) (obj)).getUuid();
        obj1 = entityCache.retrieve(((java.util.UUID) (obj1)));
        obj1 = new EncodedWatchable(((PlayerDownloadMetaData) (obj)).getWatchableKey(), ((com.comcast.cim.cmasl.utils.container.Either) (obj1)));
        obj = new PlayerDownloadFile(ivirtuosoasset, ((PlayerDownloadMetaData) (obj)), watchableCodec.decode(((EncodedWatchable) (obj1))));
        stopwatch.stop();
        LOG.debug("Created new PlayerDownloadFile {} in {}", ivirtuosoasset.uuid(), stopwatch);
        return ((PlayerDownloadFile) (obj));
    }
}
