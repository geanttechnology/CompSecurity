// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.common.Preconditions;
import java.util.Random;

// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public class EventSampler
{

    private Random mRandom;

    public EventSampler()
    {
        this(new Random());
    }

    public EventSampler(Random random)
    {
        mRandom = random;
    }

    boolean sample(BaseEvent baseevent)
    {
        Preconditions.checkNotNull(baseevent);
        return mRandom.nextDouble() < baseevent.getSamplingRate();
    }
}
