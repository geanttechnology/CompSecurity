// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

class entManager extends EventIncrementManager
{

    final GamesClientImpl zzavq;

    public EventIncrementCache zzuU()
    {
        return new meClientEventIncrementCache(zzavq);
    }

    entCache(GamesClientImpl gamesclientimpl)
    {
        zzavq = gamesclientimpl;
        super();
    }
}
