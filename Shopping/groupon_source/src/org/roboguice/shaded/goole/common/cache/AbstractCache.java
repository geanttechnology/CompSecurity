// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;


// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            Cache, LongAddables, LongAddable

public abstract class AbstractCache
    implements Cache
{
    public static final class SimpleStatsCounter
        implements StatsCounter
    {

        private final LongAddable evictionCount = LongAddables.create();
        private final LongAddable hitCount = LongAddables.create();
        private final LongAddable loadExceptionCount = LongAddables.create();
        private final LongAddable loadSuccessCount = LongAddables.create();
        private final LongAddable missCount = LongAddables.create();
        private final LongAddable totalLoadTime = LongAddables.create();

        public void recordEviction()
        {
            evictionCount.increment();
        }

        public void recordHits(int i)
        {
            hitCount.add(i);
        }

        public void recordLoadException(long l)
        {
            loadExceptionCount.increment();
            totalLoadTime.add(l);
        }

        public void recordLoadSuccess(long l)
        {
            loadSuccessCount.increment();
            totalLoadTime.add(l);
        }

        public void recordMisses(int i)
        {
            missCount.add(i);
        }

        public SimpleStatsCounter()
        {
        }
    }

    public static interface StatsCounter
    {

        public abstract void recordEviction();

        public abstract void recordHits(int i);

        public abstract void recordLoadException(long l);

        public abstract void recordLoadSuccess(long l);

        public abstract void recordMisses(int i);
    }

}
