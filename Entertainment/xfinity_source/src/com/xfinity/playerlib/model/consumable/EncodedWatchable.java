// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.LeftEither;
import com.comcast.cim.cmasl.utils.container.RightEither;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            WatchableKey

public class EncodedWatchable
{

    private final Either backingEntity;
    private final WatchableKey watchableKey;

    public EncodedWatchable(WatchableKey watchablekey, Either either)
    {
        Validate.notNull(watchablekey);
        Validate.notNull(either);
        watchableKey = watchablekey;
        backingEntity = either;
    }

    public EncodedWatchable(WatchableKey watchablekey, HalMovieConsumable halmovieconsumable)
    {
        this(watchablekey, ((Either) (new LeftEither(halmovieconsumable))));
    }

    public EncodedWatchable(WatchableKey watchablekey, HalTvSeriesConsumable haltvseriesconsumable)
    {
        this(watchablekey, ((Either) (new RightEither(haltvseriesconsumable))));
    }

    public Either getBackingEntity()
    {
        return backingEntity;
    }

    public WatchableKey getWatchableKey()
    {
        return watchableKey;
    }
}
