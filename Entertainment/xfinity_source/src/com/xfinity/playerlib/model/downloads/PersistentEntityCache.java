// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.utils.StorageCache;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.LeftEither;
import com.comcast.cim.cmasl.utils.container.RightEither;
import com.comcast.cim.utils.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfinity.playerlib.model.consumable.hal.HalBaseConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.TeeInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistentEntityCache
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/downloads/PersistentEntityCache);
    public static final String NAMESPACE = com/xfinity/playerlib/model/downloads/PersistentEntityCache.getSimpleName();
    private final ObjectMapper objectMapper;
    private final JsonSerializer serializer;
    private final StorageCache storageCache;

    public PersistentEntityCache(StorageCache storagecache, JsonSerializer jsonserializer, ObjectMapper objectmapper)
    {
        storageCache = storagecache;
        serializer = jsonserializer;
        objectMapper = objectmapper;
    }

    private String getCacheKey(UUID uuid)
    {
        return uuid.toString();
    }

    public void clear()
    {
        synchronized (storageCache)
        {
            storageCache.removeAll();
        }
        return;
        exception;
        storagecache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void remove(UUID uuid)
    {
        synchronized (storageCache)
        {
            uuid = getCacheKey(uuid);
            storageCache.remove(uuid);
            LOG.debug("Removed entity for key {}", uuid);
        }
        return;
        uuid;
        storagecache;
        JVM INSTR monitorexit ;
        throw uuid;
    }

    public Either retrieve(UUID uuid)
    {
        String s = getCacheKey(uuid);
        StorageCache storagecache = storageCache;
        storagecache;
        JVM INSTR monitorenter ;
        java.io.InputStream inputstream = storageCache.retrieve(s);
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        LOG.info("Entity for key {} not found", s);
        storagecache;
        JVM INSTR monitorexit ;
        return null;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        uuid = new TeeInputStream(inputstream, bytearrayoutputstream);
        HalBaseConsumable halbaseconsumable;
        try
        {
            halbaseconsumable = (HalBaseConsumable)objectMapper.readValue(uuid, com/xfinity/playerlib/model/consumable/hal/HalBaseConsumable);
            static class _cls1
            {

                static final int $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[];

                static 
                {
                    $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace = new int[com.xfinity.playerlib.model.MerlinId.Namespace.values().length];
                    try
                    {
                        $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.Movie.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.xfinity.playerlib.model.MerlinId.Namespace[halbaseconsumable.getNamespace().ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected namespace for merlin ID: ").append(halbaseconsumable.getMerlinEntityId()).toString());

            case 2: // '\002'
                break MISSING_BLOCK_LABEL_219;

            case 1: // '\001'
                break;
            }
            break MISSING_BLOCK_LABEL_181;
        }
        // Misplaced declaration of an exception variable
        catch (UUID uuid) { }
        finally { }
        LOG.error("Caught exception parsing entity stream. Stream contents: {}", bytearrayoutputstream);
        throw new CimIOException(uuid);
        IOUtils.closeQuietly(inputstream);
        throw uuid;
        uuid;
        storagecache;
        JVM INSTR monitorexit ;
        throw uuid;
        uuid = new LeftEither((HalMovieConsumable)halbaseconsumable);
_L1:
        LOG.debug("Retrieved entity with ID {} for key {}", halbaseconsumable.getMerlinEntityId(), s);
        IOUtils.closeQuietly(inputstream);
        storagecache;
        JVM INSTR monitorexit ;
        return uuid;
        uuid = new RightEither((HalTvSeriesConsumable)halbaseconsumable);
          goto _L1
    }

    public void store(UUID uuid, Either either)
    {
        String s;
        String s1;
        if (either.e1 != null)
        {
            either = (HalBaseConsumable)either.e1;
        } else
        {
            either = (HalBaseConsumable)either.e2;
        }
        s = serializer.serialize(either);
        either = either.getMerlinEntityId();
        s1 = getCacheKey(uuid);
        synchronized (storageCache)
        {
            storageCache.store(IOUtils.toInputStream(s, "UTF-8"), s1);
        }
        try
        {
            LOG.debug("Stored entity with ID {} using key {}", either, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (UUID uuid)
        {
            throw new CimIOException(uuid);
        }
        either;
        uuid;
        JVM INSTR monitorexit ;
        throw either;
    }

}
