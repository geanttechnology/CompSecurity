// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import java.util.Locale;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            EncodedWatchable, WatchableKey, MovieFacade, EpisodeFacade, 
//            Watchable, VideoFacade

public class WatchableCodec
{

    public WatchableCodec()
    {
    }

    public Watchable decode(EncodedWatchable encodedwatchable)
    {
        Object obj = encodedwatchable.getWatchableKey();
        MerlinId merlinid = ((WatchableKey) (obj)).getParentMerlinId();
        long l = ((WatchableKey) (obj)).getVideoId();
        obj = encodedwatchable.getBackingEntity();
        encodedwatchable = (HalMovieConsumable)((Either) (obj)).e1;
        obj = (HalTvSeriesConsumable)((Either) (obj)).e2;
        com.xfinity.playerlib.model.MerlinId.Namespace namespace = merlinid.getNamespace();
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
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.xfinity.playerlib.model.MerlinId.Namespace[namespace.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unexpected parent Merlin ID namespace: ").append(namespace).toString());

        case 1: // '\001'
            return new MovieFacade(encodedwatchable);

        case 2: // '\002'
            encodedwatchable = ((HalTvSeriesConsumable) (obj)).findEpisodeByVideoId(l);
            break;
        }
        if (encodedwatchable != null)
        {
            return new EpisodeFacade(encodedwatchable, ((HalTvSeriesConsumable) (obj)));
        } else
        {
            throw new CimException(String.format(Locale.US, "Couldn't find video id %s in series with id %s", new Object[] {
                Long.valueOf(l), merlinid
            }));
        }
    }

    public EncodedWatchable encode(Watchable watchable, VideoFacade videofacade)
    {
        return new EncodedWatchable(new WatchableKey(watchable, videofacade), watchable.getBackingEntity());
    }
}
