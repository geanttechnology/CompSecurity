// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.roboguice.shaded.goole.common.base.Ascii;
import org.roboguice.shaded.goole.common.base.Equivalence;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.base.Supplier;
import org.roboguice.shaded.goole.common.base.Suppliers;
import org.roboguice.shaded.goole.common.base.Ticker;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            CacheStats, RemovalListener, Weigher, Cache, 
//            CacheLoader, LoadingCache, RemovalNotification

public final class CacheBuilder
{
    static final class NullListener extends Enum
        implements RemovalListener
    {

        private static final NullListener $VALUES[];
        public static final NullListener INSTANCE;

        public static NullListener valueOf(String s)
        {
            return (NullListener)Enum.valueOf(org/roboguice/shaded/goole/common/cache/CacheBuilder$NullListener, s);
        }

        public static NullListener[] values()
        {
            return (NullListener[])$VALUES.clone();
        }

        public void onRemoval(RemovalNotification removalnotification)
        {
        }

        static 
        {
            INSTANCE = new NullListener("INSTANCE", 0);
            $VALUES = (new NullListener[] {
                INSTANCE
            });
        }

        private NullListener(String s, int i)
        {
            super(s, i);
        }
    }

    static final class OneWeigher extends Enum
        implements Weigher
    {

        private static final OneWeigher $VALUES[];
        public static final OneWeigher INSTANCE;

        public static OneWeigher valueOf(String s)
        {
            return (OneWeigher)Enum.valueOf(org/roboguice/shaded/goole/common/cache/CacheBuilder$OneWeigher, s);
        }

        public static OneWeigher[] values()
        {
            return (OneWeigher[])$VALUES.clone();
        }

        public int weigh(Object obj, Object obj1)
        {
            return 1;
        }

        static 
        {
            INSTANCE = new OneWeigher("INSTANCE", 0);
            $VALUES = (new OneWeigher[] {
                INSTANCE
            });
        }

        private OneWeigher(String s, int i)
        {
            super(s, i);
        }
    }


    static final Supplier CACHE_STATS_COUNTER = new Supplier() {

        public volatile Object get()
        {
            return get();
        }

        public AbstractCache.StatsCounter get()
        {
            return new AbstractCache.SimpleStatsCounter();
        }

    };
    static final CacheStats EMPTY_STATS = new CacheStats(0L, 0L, 0L, 0L, 0L, 0L);
    static final Supplier NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() {

        public void recordEviction()
        {
        }

        public void recordHits(int i)
        {
        }

        public void recordLoadException(long l)
        {
        }

        public void recordLoadSuccess(long l)
        {
        }

        public void recordMisses(int i)
        {
        }

    });
    static final Ticker NULL_TICKER = new Ticker() {

        public long read()
        {
            return 0L;
        }

    };
    private static final Logger logger = Logger.getLogger(org/roboguice/shaded/goole/common/cache/CacheBuilder.getName());
    int concurrencyLevel;
    long expireAfterAccessNanos;
    long expireAfterWriteNanos;
    int initialCapacity;
    Equivalence keyEquivalence;
    LocalCache.Strength keyStrength;
    long maximumSize;
    long maximumWeight;
    long refreshNanos;
    RemovalListener removalListener;
    Supplier statsCounterSupplier;
    boolean strictParsing;
    Ticker ticker;
    Equivalence valueEquivalence;
    LocalCache.Strength valueStrength;
    Weigher weigher;

    CacheBuilder()
    {
        strictParsing = true;
        initialCapacity = -1;
        concurrencyLevel = -1;
        maximumSize = -1L;
        maximumWeight = -1L;
        expireAfterWriteNanos = -1L;
        expireAfterAccessNanos = -1L;
        refreshNanos = -1L;
        statsCounterSupplier = NULL_STATS_COUNTER;
    }

    private void checkNonLoadingCache()
    {
        boolean flag;
        if (refreshNanos == -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher()
    {
        boolean flag2 = true;
        boolean flag = true;
        if (weigher == null)
        {
            if (maximumWeight != -1L)
            {
                flag = false;
            }
            Preconditions.checkState(flag, "maximumWeight requires weigher");
        } else
        {
            if (strictParsing)
            {
                boolean flag1;
                if (maximumWeight != -1L)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                Preconditions.checkState(flag1, "weigher requires maximumWeight");
                return;
            }
            if (maximumWeight == -1L)
            {
                logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
                return;
            }
        }
    }

    public static CacheBuilder newBuilder()
    {
        return new CacheBuilder();
    }

    public Cache build()
    {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }

    public LoadingCache build(CacheLoader cacheloader)
    {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheloader);
    }

    int getConcurrencyLevel()
    {
        if (concurrencyLevel == -1)
        {
            return 4;
        } else
        {
            return concurrencyLevel;
        }
    }

    long getExpireAfterAccessNanos()
    {
        if (expireAfterAccessNanos == -1L)
        {
            return 0L;
        } else
        {
            return expireAfterAccessNanos;
        }
    }

    long getExpireAfterWriteNanos()
    {
        if (expireAfterWriteNanos == -1L)
        {
            return 0L;
        } else
        {
            return expireAfterWriteNanos;
        }
    }

    int getInitialCapacity()
    {
        if (initialCapacity == -1)
        {
            return 16;
        } else
        {
            return initialCapacity;
        }
    }

    Equivalence getKeyEquivalence()
    {
        return (Equivalence)Objects.firstNonNull(keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    LocalCache.Strength getKeyStrength()
    {
        return (LocalCache.Strength)Objects.firstNonNull(keyStrength, LocalCache.Strength.STRONG);
    }

    long getMaximumWeight()
    {
        if (expireAfterWriteNanos == 0L || expireAfterAccessNanos == 0L)
        {
            return 0L;
        }
        if (weigher == null)
        {
            return maximumSize;
        } else
        {
            return maximumWeight;
        }
    }

    long getRefreshNanos()
    {
        if (refreshNanos == -1L)
        {
            return 0L;
        } else
        {
            return refreshNanos;
        }
    }

    RemovalListener getRemovalListener()
    {
        return (RemovalListener)Objects.firstNonNull(removalListener, NullListener.INSTANCE);
    }

    Supplier getStatsCounterSupplier()
    {
        return statsCounterSupplier;
    }

    Ticker getTicker(boolean flag)
    {
        if (ticker != null)
        {
            return ticker;
        }
        if (flag)
        {
            return Ticker.systemTicker();
        } else
        {
            return NULL_TICKER;
        }
    }

    Equivalence getValueEquivalence()
    {
        return (Equivalence)Objects.firstNonNull(valueEquivalence, getValueStrength().defaultEquivalence());
    }

    LocalCache.Strength getValueStrength()
    {
        return (LocalCache.Strength)Objects.firstNonNull(valueStrength, LocalCache.Strength.STRONG);
    }

    Weigher getWeigher()
    {
        return (Weigher)Objects.firstNonNull(weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder maximumSize(long l)
    {
        boolean flag1 = true;
        boolean flag;
        if (maximumSize == -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "maximum size was already set to %s", new Object[] {
            Long.valueOf(maximumSize)
        });
        if (maximumWeight == -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "maximum weight was already set to %s", new Object[] {
            Long.valueOf(maximumWeight)
        });
        if (weigher == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "maximum size can not be combined with weigher");
        if (l >= 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "maximum size must not be negative");
        maximumSize = l;
        return this;
    }

    public CacheBuilder removalListener(RemovalListener removallistener)
    {
        boolean flag;
        if (removalListener == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        removalListener = (RemovalListener)Preconditions.checkNotNull(removallistener);
        return this;
    }

    CacheBuilder setKeyStrength(LocalCache.Strength strength)
    {
        boolean flag;
        if (keyStrength == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Key strength was already set to %s", new Object[] {
            keyStrength
        });
        keyStrength = (LocalCache.Strength)Preconditions.checkNotNull(strength);
        return this;
    }

    CacheBuilder setValueStrength(LocalCache.Strength strength)
    {
        boolean flag;
        if (valueStrength == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Value strength was already set to %s", new Object[] {
            valueStrength
        });
        valueStrength = (LocalCache.Strength)Preconditions.checkNotNull(strength);
        return this;
    }

    public String toString()
    {
        org.roboguice.shaded.goole.common.base.Objects.ToStringHelper tostringhelper = Objects.toStringHelper(this);
        if (initialCapacity != -1)
        {
            tostringhelper.add("initialCapacity", initialCapacity);
        }
        if (concurrencyLevel != -1)
        {
            tostringhelper.add("concurrencyLevel", concurrencyLevel);
        }
        if (maximumSize != -1L)
        {
            tostringhelper.add("maximumSize", maximumSize);
        }
        if (maximumWeight != -1L)
        {
            tostringhelper.add("maximumWeight", maximumWeight);
        }
        if (expireAfterWriteNanos != -1L)
        {
            tostringhelper.add("expireAfterWrite", (new StringBuilder()).append(expireAfterWriteNanos).append("ns").toString());
        }
        if (expireAfterAccessNanos != -1L)
        {
            tostringhelper.add("expireAfterAccess", (new StringBuilder()).append(expireAfterAccessNanos).append("ns").toString());
        }
        if (keyStrength != null)
        {
            tostringhelper.add("keyStrength", Ascii.toLowerCase(keyStrength.toString()));
        }
        if (valueStrength != null)
        {
            tostringhelper.add("valueStrength", Ascii.toLowerCase(valueStrength.toString()));
        }
        if (keyEquivalence != null)
        {
            tostringhelper.addValue("keyEquivalence");
        }
        if (valueEquivalence != null)
        {
            tostringhelper.addValue("valueEquivalence");
        }
        if (removalListener != null)
        {
            tostringhelper.addValue("removalListener");
        }
        return tostringhelper.toString();
    }

    public CacheBuilder weakKeys()
    {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    public CacheBuilder weakValues()
    {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

}
