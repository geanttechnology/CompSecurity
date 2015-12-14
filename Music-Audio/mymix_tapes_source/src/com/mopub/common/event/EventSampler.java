// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.common.Preconditions;
import java.util.LinkedHashMap;
import java.util.Random;

// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public class EventSampler
{

    private static final int CAPACITY = 135;
    private static final float LOAD_FACTOR = 0.75F;
    static final int MAX_SIZE = 100;
    private Random mRandom;
    private LinkedHashMap mSampleDecisionsCache = new LinkedHashMap(135, 0.75F, true) {

        final EventSampler this$0;

        protected boolean removeEldestEntry(java.util.Map.Entry entry)
        {
            return size() > 100;
        }

            
            {
                this$0 = EventSampler.this;
                super(i, f, flag);
            }
    };

    public EventSampler()
    {
        this(new Random());
    }

    public EventSampler(Random random)
    {
        mRandom = random;
    }

    int getCacheSize()
    {
        return mSampleDecisionsCache.size();
    }

    boolean sample(BaseEvent baseevent)
    {
        Preconditions.checkNotNull(baseevent);
        String s = baseevent.getRequestId();
        if (s == null)
        {
            return mRandom.nextDouble() < baseevent.getSamplingRate();
        }
        Boolean boolean1 = (Boolean)mSampleDecisionsCache.get(s);
        if (boolean1 != null)
        {
            return boolean1.booleanValue();
        }
        boolean flag;
        if (mRandom.nextDouble() < baseevent.getSamplingRate())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mSampleDecisionsCache.put(s, Boolean.valueOf(flag));
        return flag;
    }
}
