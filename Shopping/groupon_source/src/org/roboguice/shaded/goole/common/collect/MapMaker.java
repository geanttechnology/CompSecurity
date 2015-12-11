// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.roboguice.shaded.goole.common.base.Ascii;
import org.roboguice.shaded.goole.common.base.Equivalence;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.base.Throwables;
import org.roboguice.shaded.goole.common.base.Ticker;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            GenericMapMaker, MapMakerInternalMap, ComputingConcurrentHashMap, ComputationException, 
//            ImmutableEntry

public final class MapMaker extends GenericMapMaker
{
    static final class ComputingMapAdapter extends ComputingConcurrentHashMap
        implements Serializable
    {

        public Object get(Object obj)
        {
            Object obj1;
            try
            {
                obj1 = getOrCompute(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = ((ExecutionException) (obj)).getCause();
                Throwables.propagateIfInstanceOf(((Throwable) (obj)), org/roboguice/shaded/goole/common/collect/ComputationException);
                throw new ComputationException(((Throwable) (obj)));
            }
            if (obj1 == null)
            {
                throw new NullPointerException((new StringBuilder()).append(computingFunction).append(" returned null for key ").append(obj).append(".").toString());
            } else
            {
                return obj1;
            }
        }

        ComputingMapAdapter(MapMaker mapmaker, Function function)
        {
            super(mapmaker, function);
        }
    }

    static final class NullComputingConcurrentMap extends NullConcurrentMap
    {

        final Function computingFunction;

        private Object compute(Object obj)
        {
            Preconditions.checkNotNull(obj);
            try
            {
                obj = computingFunction.apply(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ComputationException(((Throwable) (obj)));
            }
            return obj;
        }

        public Object get(Object obj)
        {
            Object obj1 = compute(obj);
            Preconditions.checkNotNull(obj1, (new StringBuilder()).append(computingFunction).append(" returned null for key ").append(obj).append(".").toString());
            notifyRemoval(obj, obj1);
            return obj1;
        }

        NullComputingConcurrentMap(MapMaker mapmaker, Function function)
        {
            super(mapmaker);
            computingFunction = (Function)Preconditions.checkNotNull(function);
        }
    }

    static class NullConcurrentMap extends AbstractMap
        implements Serializable, ConcurrentMap
    {

        private final RemovalCause removalCause;
        private final RemovalListener removalListener;

        public boolean containsKey(Object obj)
        {
            return false;
        }

        public boolean containsValue(Object obj)
        {
            return false;
        }

        public Set entrySet()
        {
            return Collections.emptySet();
        }

        public Object get(Object obj)
        {
            return null;
        }

        void notifyRemoval(Object obj, Object obj1)
        {
            obj = new RemovalNotification(obj, obj1, removalCause);
            removalListener.onRemoval(((RemovalNotification) (obj)));
        }

        public Object put(Object obj, Object obj1)
        {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(obj1);
            notifyRemoval(obj, obj1);
            return null;
        }

        public Object putIfAbsent(Object obj, Object obj1)
        {
            return put(obj, obj1);
        }

        public Object remove(Object obj)
        {
            return null;
        }

        public boolean remove(Object obj, Object obj1)
        {
            return false;
        }

        public Object replace(Object obj, Object obj1)
        {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(obj1);
            return null;
        }

        public boolean replace(Object obj, Object obj1, Object obj2)
        {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(obj2);
            return false;
        }

        NullConcurrentMap(MapMaker mapmaker)
        {
            removalListener = mapmaker.getRemovalListener();
            removalCause = mapmaker.nullRemovalCause;
        }
    }

    static abstract class RemovalCause extends Enum
    {

        private static final RemovalCause $VALUES[];
        public static final RemovalCause COLLECTED;
        public static final RemovalCause EXPIRED;
        public static final RemovalCause EXPLICIT;
        public static final RemovalCause REPLACED;
        public static final RemovalCause SIZE;

        public static RemovalCause valueOf(String s)
        {
            return (RemovalCause)Enum.valueOf(org/roboguice/shaded/goole/common/collect/MapMaker$RemovalCause, s);
        }

        public static RemovalCause[] values()
        {
            return (RemovalCause[])$VALUES.clone();
        }

        static 
        {
            EXPLICIT = new RemovalCause("EXPLICIT", 0) {

            };
            REPLACED = new RemovalCause("REPLACED", 1) {

            };
            COLLECTED = new RemovalCause("COLLECTED", 2) {

            };
            EXPIRED = new RemovalCause("EXPIRED", 3) {

            };
            SIZE = new RemovalCause("SIZE", 4) {

            };
            $VALUES = (new RemovalCause[] {
                EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE
            });
        }

        private RemovalCause(String s, int i)
        {
            super(s, i);
        }

    }

    static interface RemovalListener
    {

        public abstract void onRemoval(RemovalNotification removalnotification);
    }

    static final class RemovalNotification extends ImmutableEntry
    {

        private final RemovalCause cause;

        RemovalNotification(Object obj, Object obj1, RemovalCause removalcause)
        {
            super(obj, obj1);
            cause = removalcause;
        }
    }


    int concurrencyLevel;
    long expireAfterAccessNanos;
    long expireAfterWriteNanos;
    int initialCapacity;
    Equivalence keyEquivalence;
    MapMakerInternalMap.Strength keyStrength;
    int maximumSize;
    RemovalCause nullRemovalCause;
    Ticker ticker;
    boolean useCustomMap;
    MapMakerInternalMap.Strength valueStrength;

    public MapMaker()
    {
        initialCapacity = -1;
        concurrencyLevel = -1;
        maximumSize = -1;
        expireAfterWriteNanos = -1L;
        expireAfterAccessNanos = -1L;
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

    MapMakerInternalMap.Strength getKeyStrength()
    {
        return (MapMakerInternalMap.Strength)Objects.firstNonNull(keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    Ticker getTicker()
    {
        return (Ticker)Objects.firstNonNull(ticker, Ticker.systemTicker());
    }

    MapMakerInternalMap.Strength getValueStrength()
    {
        return (MapMakerInternalMap.Strength)Objects.firstNonNull(valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    ConcurrentMap makeComputingMap(Function function)
    {
        if (nullRemovalCause == null)
        {
            function = new ComputingMapAdapter(this, function);
        } else
        {
            function = new NullComputingConcurrentMap(this, function);
        }
        return (ConcurrentMap)function;
    }

    public ConcurrentMap makeMap()
    {
        if (!useCustomMap)
        {
            return new ConcurrentHashMap(getInitialCapacity(), 0.75F, getConcurrencyLevel());
        }
        Object obj;
        if (nullRemovalCause == null)
        {
            obj = new MapMakerInternalMap(this);
        } else
        {
            obj = new NullConcurrentMap(this);
        }
        return (ConcurrentMap)obj;
    }

    MapMaker setKeyStrength(MapMakerInternalMap.Strength strength)
    {
        boolean flag1 = false;
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
        keyStrength = (MapMakerInternalMap.Strength)Preconditions.checkNotNull(strength);
        flag = flag1;
        if (keyStrength != MapMakerInternalMap.Strength.SOFT)
        {
            flag = true;
        }
        Preconditions.checkArgument(flag, "Soft keys are not supported");
        if (strength != MapMakerInternalMap.Strength.STRONG)
        {
            useCustomMap = true;
        }
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
        if (maximumSize != -1)
        {
            tostringhelper.add("maximumSize", maximumSize);
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
        if (removalListener != null)
        {
            tostringhelper.addValue("removalListener");
        }
        return tostringhelper.toString();
    }

    public MapMaker weakKeys()
    {
        return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }
}
