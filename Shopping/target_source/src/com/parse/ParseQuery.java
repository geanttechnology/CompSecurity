// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseKeyValueCache, ParseQueryController, ParseCorePlugins, 
//            ParseUser, Parse, ParseException, ParseTaskUtils, 
//            ParseRESTQueryCommand, ParseGeoPoint, ParseCallback2, CountCallback, 
//            FindCallback, GetCallback, ParseEncoder, ParseRelation, 
//            ParseTextUtils

public class ParseQuery
{
    public static final class CachePolicy extends Enum
    {

        private static final CachePolicy $VALUES[];
        public static final CachePolicy CACHE_ELSE_NETWORK;
        public static final CachePolicy CACHE_ONLY;
        public static final CachePolicy CACHE_THEN_NETWORK;
        public static final CachePolicy IGNORE_CACHE;
        public static final CachePolicy NETWORK_ELSE_CACHE;
        public static final CachePolicy NETWORK_ONLY;

        public static CachePolicy valueOf(String s)
        {
            return (CachePolicy)Enum.valueOf(com/parse/ParseQuery$CachePolicy, s);
        }

        public static CachePolicy[] values()
        {
            return (CachePolicy[])$VALUES.clone();
        }

        static 
        {
            IGNORE_CACHE = new CachePolicy("IGNORE_CACHE", 0);
            CACHE_ONLY = new CachePolicy("CACHE_ONLY", 1);
            NETWORK_ONLY = new CachePolicy("NETWORK_ONLY", 2);
            CACHE_ELSE_NETWORK = new CachePolicy("CACHE_ELSE_NETWORK", 3);
            NETWORK_ELSE_CACHE = new CachePolicy("NETWORK_ELSE_CACHE", 4);
            CACHE_THEN_NETWORK = new CachePolicy("CACHE_THEN_NETWORK", 5);
            $VALUES = (new CachePolicy[] {
                IGNORE_CACHE, CACHE_ONLY, NETWORK_ONLY, CACHE_ELSE_NETWORK, NETWORK_ELSE_CACHE, CACHE_THEN_NETWORK
            });
        }

        private CachePolicy(String s, int i)
        {
            super(s, i);
        }
    }

    private static interface CacheThenNetworkCallable
    {

        public abstract Object call(State state, ParseUser parseuser, j j1);
    }

    static class KeyConstraints extends HashMap
    {

        KeyConstraints()
        {
        }
    }

    static class QueryConstraints extends HashMap
    {

        public QueryConstraints()
        {
        }

        public QueryConstraints(Map map)
        {
            super(map);
        }
    }

    static class RelationConstraint
    {

        private String key;
        private ParseObject object;

        public JSONObject encode(ParseEncoder parseencoder)
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("key", key);
                jsonobject.put("object", parseencoder.encodeRelatedObject(object));
            }
            // Misplaced declaration of an exception variable
            catch (ParseEncoder parseencoder)
            {
                throw new RuntimeException(parseencoder);
            }
            return jsonobject;
        }

        public String getKey()
        {
            return key;
        }

        public ParseObject getObject()
        {
            return object;
        }

        public ParseRelation getRelation()
        {
            return object.getRelation(key);
        }

        public RelationConstraint(String s, ParseObject parseobject)
        {
            if (s == null || parseobject == null)
            {
                throw new IllegalArgumentException("Arguments must not be null.");
            } else
            {
                key = s;
                object = parseobject;
                return;
            }
        }
    }

    static class State
    {

        private final CachePolicy cachePolicy;
        private final String className;
        private final Map extraOptions;
        private final boolean ignoreACLs;
        private final Set include;
        private final boolean isFromLocalDatastore;
        private final int limit;
        private final long maxCacheAge;
        private final List order;
        private final String pinName;
        private final Set selectedKeys;
        private final int skip;
        private final boolean trace;
        private final QueryConstraints where;

        public CachePolicy cachePolicy()
        {
            return cachePolicy;
        }

        public String className()
        {
            return className;
        }

        public QueryConstraints constraints()
        {
            return where;
        }

        public Map extraOptions()
        {
            return extraOptions;
        }

        public boolean ignoreACLs()
        {
            return ignoreACLs;
        }

        public Set includes()
        {
            return include;
        }

        public boolean isFromLocalDatastore()
        {
            return isFromLocalDatastore;
        }

        public boolean isTracingEnabled()
        {
            return trace;
        }

        public int limit()
        {
            return limit;
        }

        public long maxCacheAge()
        {
            return maxCacheAge;
        }

        public List order()
        {
            return order;
        }

        public String pinName()
        {
            return pinName;
        }

        public Set selectedKeys()
        {
            return selectedKeys;
        }

        public int skip()
        {
            return skip;
        }

        JSONObject toJSON(ParseEncoder parseencoder)
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("className", className);
                jsonobject.put("where", parseencoder.encode(where));
                if (limit >= 0)
                {
                    jsonobject.put("limit", limit);
                }
                if (skip > 0)
                {
                    jsonobject.put("skip", skip);
                }
                if (!order.isEmpty())
                {
                    jsonobject.put("order", ParseTextUtils.join(",", order));
                }
                if (!include.isEmpty())
                {
                    jsonobject.put("include", ParseTextUtils.join(",", include));
                }
                if (selectedKeys != null)
                {
                    jsonobject.put("fields", ParseTextUtils.join(",", selectedKeys));
                }
                if (trace)
                {
                    jsonobject.put("trace", 1);
                }
                String s;
                for (Iterator iterator = extraOptions.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, parseencoder.encode(extraOptions.get(s))))
                {
                    s = (String)iterator.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (ParseEncoder parseencoder)
            {
                throw new RuntimeException(parseencoder);
            }
            return jsonobject;
        }

        public String toString()
        {
            return String.format(Locale.US, "%s[className=%s, where=%s, include=%s, selectedKeys=%s, limit=%s, skip=%s, order=%s, extraOptions=%s, cachePolicy=%s, maxCacheAge=%s, trace=%s]", new Object[] {
                getClass().getName(), className, where, include, selectedKeys, Integer.valueOf(limit), Integer.valueOf(skip), order, extraOptions, cachePolicy, 
                Long.valueOf(maxCacheAge), Boolean.valueOf(trace)
            });
        }

        private State(Builder builder1)
        {
            className = builder1.className;
            where = new QueryConstraints(builder1.where);
            include = Collections.unmodifiableSet(new HashSet(builder1.includes));
            Set set;
            if (builder1.selectedKeys != null)
            {
                set = Collections.unmodifiableSet(new HashSet(builder1.selectedKeys));
            } else
            {
                set = null;
            }
            selectedKeys = set;
            limit = builder1.limit;
            skip = builder1.skip;
            order = Collections.unmodifiableList(new ArrayList(builder1.order));
            extraOptions = Collections.unmodifiableMap(new HashMap(builder1.extraOptions));
            trace = builder1.trace;
            cachePolicy = builder1.cachePolicy;
            maxCacheAge = builder1.maxCacheAge;
            isFromLocalDatastore = builder1.isFromLocalDatastore;
            pinName = builder1.pinName;
            ignoreACLs = builder1.ignoreACLs;
        }

    }

    static class State.Builder
    {

        private CachePolicy cachePolicy;
        private final String className;
        private final Map extraOptions;
        private boolean ignoreACLs;
        private final Set includes;
        private boolean isFromLocalDatastore;
        private int limit;
        private long maxCacheAge;
        private List order;
        private String pinName;
        private Set selectedKeys;
        private int skip;
        private boolean trace;
        private final QueryConstraints where;

        private State.Builder addConditionInternal(String s, String s1, Object obj)
        {
            if (!where.containsKey(s)) goto _L2; else goto _L1
_L1:
            Object obj1 = where.get(s);
            if (!(obj1 instanceof KeyConstraints)) goto _L2; else goto _L3
_L3:
            obj1 = (KeyConstraints)obj1;
_L5:
            KeyConstraints keyconstraints = ((KeyConstraints) (obj1));
            if (obj1 == null)
            {
                keyconstraints = new KeyConstraints();
            }
            keyconstraints.put(s1, obj);
            where.put(s, keyconstraints);
            return this;
_L2:
            obj1 = null;
            if (true) goto _L5; else goto _L4
_L4:
        }

        private State.Builder addOrder(String s)
        {
            order.add(s);
            return this;
        }

        public static State.Builder or(List list)
        {
            if (list.isEmpty())
            {
                throw new IllegalArgumentException("Can't take an or of an empty list of queries");
            }
            ArrayList arraylist = new ArrayList();
            Iterator iterator = list.iterator();
            list = null;
            State.Builder builder1;
            for (; iterator.hasNext(); arraylist.add(builder1.where))
            {
                builder1 = (State.Builder)iterator.next();
                if (list != null && !builder1.className.equals(list))
                {
                    throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
                }
                if (builder1.limit >= 0)
                {
                    throw new IllegalArgumentException("Cannot have limits in sub queries of an 'OR' query");
                }
                if (builder1.skip > 0)
                {
                    throw new IllegalArgumentException("Cannot have skips in sub queries of an 'OR' query");
                }
                if (!builder1.order.isEmpty())
                {
                    throw new IllegalArgumentException("Cannot have an order in sub queries of an 'OR' query");
                }
                if (!builder1.includes.isEmpty())
                {
                    throw new IllegalArgumentException("Cannot have an include in sub queries of an 'OR' query");
                }
                if (builder1.selectedKeys != null)
                {
                    throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an 'OR' query");
                }
                list = builder1.className;
            }

            return (new State.Builder(list)).whereSatifiesAnyOf(arraylist);
        }

        private State.Builder setOrder(String s)
        {
            order.clear();
            order.add(s);
            return this;
        }

        private State.Builder whereSatifiesAnyOf(List list)
        {
            where.put("$or", list);
            return this;
        }

        public State.Builder addAscendingOrder(String s)
        {
            return addOrder(s);
        }

        public State.Builder addCondition(String s, String s1, Object obj)
        {
            return addConditionInternal(s, s1, obj);
        }

        public State.Builder addCondition(String s, String s1, Collection collection)
        {
            return addConditionInternal(s, s1, Collections.unmodifiableCollection(collection));
        }

        public State.Builder addDescendingOrder(String s)
        {
            return addOrder(String.format("-%s", new Object[] {
                s
            }));
        }

        public State build()
        {
            if (!isFromLocalDatastore && ignoreACLs)
            {
                throw new IllegalStateException("`ignoreACLs` cannot be combined with network queries");
            } else
            {
                return new State(this);
            }
        }

        public State.Builder fromLocalDatastore()
        {
            return fromPin(null);
        }

        public State.Builder fromNetwork()
        {
            ParseQuery.throwIfLDSDisabled();
            isFromLocalDatastore = false;
            pinName = null;
            return this;
        }

        public State.Builder fromPin()
        {
            return fromPin("_default");
        }

        public State.Builder fromPin(String s)
        {
            ParseQuery.throwIfLDSDisabled();
            isFromLocalDatastore = true;
            pinName = s;
            return this;
        }

        public CachePolicy getCachePolicy()
        {
            ParseQuery.throwIfLDSEnabled();
            return cachePolicy;
        }

        public String getClassName()
        {
            return className;
        }

        public int getLimit()
        {
            return limit;
        }

        public long getMaxCacheAge()
        {
            ParseQuery.throwIfLDSEnabled();
            return maxCacheAge;
        }

        public int getSkip()
        {
            return skip;
        }

        public State.Builder ignoreACLs()
        {
            ParseQuery.throwIfLDSDisabled();
            ignoreACLs = true;
            return this;
        }

        public State.Builder include(String s)
        {
            includes.add(s);
            return this;
        }

        public boolean isFromLocalDatstore()
        {
            return isFromLocalDatastore;
        }

        public boolean isFromNetwork()
        {
            ParseQuery.throwIfLDSDisabled();
            return !isFromLocalDatastore;
        }

        public State.Builder maxDistance(String s, double d)
        {
            return addCondition(s, "$maxDistance", Double.valueOf(d));
        }

        public State.Builder orderByAscending(String s)
        {
            return setOrder(s);
        }

        public State.Builder orderByDescending(String s)
        {
            return setOrder(String.format("-%s", new Object[] {
                s
            }));
        }

        State.Builder redirectClassNameForKey(String s)
        {
            extraOptions.put("redirectClassNameForKey", s);
            return this;
        }

        public State.Builder selectKeys(Collection collection)
        {
            if (selectedKeys == null)
            {
                selectedKeys = new HashSet();
            }
            selectedKeys.addAll(collection);
            return this;
        }

        public State.Builder setCachePolicy(CachePolicy cachepolicy)
        {
            ParseQuery.throwIfLDSEnabled();
            cachePolicy = cachepolicy;
            return this;
        }

        public State.Builder setLimit(int i)
        {
            limit = i;
            return this;
        }

        public State.Builder setMaxCacheAge(long l)
        {
            ParseQuery.throwIfLDSEnabled();
            maxCacheAge = l;
            return this;
        }

        public State.Builder setSkip(int i)
        {
            skip = i;
            return this;
        }

        public State.Builder setTracingEnabled(boolean flag)
        {
            trace = flag;
            return this;
        }

        public State.Builder whereDoesNotMatchKeyInQuery(String s, String s1, State.Builder builder1)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("key", s1);
            hashmap.put("query", builder1);
            return addConditionInternal(s, "$dontSelect", Collections.unmodifiableMap(hashmap));
        }

        public State.Builder whereDoesNotMatchQuery(String s, State.Builder builder1)
        {
            return addConditionInternal(s, "$notInQuery", builder1);
        }

        public State.Builder whereEqualTo(String s, Object obj)
        {
            where.put(s, obj);
            return this;
        }

        public State.Builder whereMatchesKeyInQuery(String s, String s1, State.Builder builder1)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("key", s1);
            hashmap.put("query", builder1);
            return addConditionInternal(s, "$select", Collections.unmodifiableMap(new HashMap(hashmap)));
        }

        public State.Builder whereMatchesQuery(String s, State.Builder builder1)
        {
            return addConditionInternal(s, "$inQuery", builder1);
        }

        public State.Builder whereNear(String s, ParseGeoPoint parsegeopoint)
        {
            return addCondition(s, "$nearSphere", parsegeopoint);
        }

        State.Builder whereObjectIdEquals(String s)
        {
            where.clear();
            where.put("objectId", s);
            return this;
        }

        State.Builder whereRelatedTo(ParseObject parseobject, String s)
        {
            where.put("$relatedTo", new RelationConstraint(s, parseobject));
            return this;
        }

        public State.Builder whereWithin(String s, ParseGeoPoint parsegeopoint, ParseGeoPoint parsegeopoint1)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(parsegeopoint);
            arraylist.add(parsegeopoint1);
            parsegeopoint = new HashMap();
            parsegeopoint.put("$box", arraylist);
            return addCondition(s, "$within", parsegeopoint);
        }















        public State.Builder(State.Builder builder1)
        {
            where = new QueryConstraints();
            includes = new HashSet();
            limit = -1;
            skip = 0;
            order = new ArrayList();
            extraOptions = new HashMap();
            cachePolicy = CachePolicy.IGNORE_CACHE;
            maxCacheAge = 0x7fffffffffffffffL;
            isFromLocalDatastore = false;
            className = builder1.className;
            where.putAll(builder1.where);
            includes.addAll(builder1.includes);
            HashSet hashset;
            if (builder1.selectedKeys != null)
            {
                hashset = new HashSet(builder1.selectedKeys);
            } else
            {
                hashset = null;
            }
            selectedKeys = hashset;
            limit = builder1.limit;
            skip = builder1.skip;
            order.addAll(builder1.order);
            extraOptions.putAll(builder1.extraOptions);
            trace = builder1.trace;
            cachePolicy = builder1.cachePolicy;
            maxCacheAge = builder1.maxCacheAge;
            isFromLocalDatastore = builder1.isFromLocalDatastore;
            pinName = builder1.pinName;
            ignoreACLs = builder1.ignoreACLs;
        }

        public State.Builder(State state)
        {
            where = new QueryConstraints();
            includes = new HashSet();
            limit = -1;
            skip = 0;
            order = new ArrayList();
            extraOptions = new HashMap();
            cachePolicy = CachePolicy.IGNORE_CACHE;
            maxCacheAge = 0x7fffffffffffffffL;
            isFromLocalDatastore = false;
            className = state.className();
            where.putAll(state.constraints());
            includes.addAll(state.includes());
            HashSet hashset;
            if (state.selectedKeys() != null)
            {
                hashset = new HashSet(state.selectedKeys());
            } else
            {
                hashset = null;
            }
            selectedKeys = hashset;
            limit = state.limit();
            skip = state.skip();
            order.addAll(state.order());
            extraOptions.putAll(state.extraOptions());
            trace = state.isTracingEnabled();
            cachePolicy = state.cachePolicy();
            maxCacheAge = state.maxCacheAge();
            isFromLocalDatastore = state.isFromLocalDatastore();
            pinName = state.pinName();
            ignoreACLs = state.ignoreACLs();
        }

        public State.Builder(Class class1)
        {
            this(ParseObject.getClassName(class1));
        }

        public State.Builder(String s)
        {
            where = new QueryConstraints();
            includes = new HashSet();
            limit = -1;
            skip = 0;
            order = new ArrayList();
            extraOptions = new HashMap();
            cachePolicy = CachePolicy.IGNORE_CACHE;
            maxCacheAge = 0x7fffffffffffffffL;
            isFromLocalDatastore = false;
            className = s;
        }
    }


    private final State.Builder builder;
    private a.j.a cts;
    private boolean isRunning;
    private final Object lock;
    private ParseUser user;

    ParseQuery(State.Builder builder1)
    {
        lock = new Object();
        isRunning = false;
        builder = builder1;
    }

    public ParseQuery(Class class1)
    {
        this(ParseObject.getClassName(class1));
    }

    public ParseQuery(String s)
    {
        this(new State.Builder(s));
    }

    private void checkIfRunning()
    {
        checkIfRunning(false);
    }

    private void checkIfRunning(boolean flag)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (isRunning)
        {
            throw new RuntimeException("This query has an outstanding network connection. You have to wait until it's done.");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        isRunning = true;
        cts = j.a();
        obj;
        JVM INSTR monitorexit ;
    }

    public static void clearAllCachedResults()
    {
        throwIfLDSEnabled();
        ParseKeyValueCache.clearKeyValueCacheDir();
    }

    private j countAsync(final State state)
    {
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final State val$state;

            public j call()
                throws Exception
            {
                return getUserAsync(state).d(new i() {

                    final _cls8 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        j1 = (ParseUser)j1.e();
                        return countAsync(state, j1, cts.a());
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                state = state1;
                super();
            }
        });
    }

    private j countAsync(State state, ParseUser parseuser, j j1)
    {
        return getQueryController().countAsync(state, parseuser, j1);
    }

    private j doCacheThenNetwork(final State state, final ParseCallback2 callback, final CacheThenNetworkCallable delegate)
    {
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final ParseCallback2 val$callback;
            final CacheThenNetworkCallable val$delegate;
            final State val$state;

            public j call()
                throws Exception
            {
                return getUserAsync(state).d(new i() {

                    final _cls10 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        j1 = (ParseUser)j1.e();
                        State state = (new State.Builder(_cls10.this.state)).setCachePolicy(CachePolicy.CACHE_ONLY).build();
                        final State networkState = (new State.Builder(_cls10.this.state)).setCachePolicy(CachePolicy.NETWORK_ONLY).build();
                        return ParseTaskUtils.callbackOnMainThreadAsync((j)_flddelegate.call(state, j1, cts.a()), callback).b(j1. new i() {

                            final _cls1 this$2;
                            final State val$networkState;
                            final ParseUser val$user;

                            public j then(j j1)
                                throws Exception
                            {
                                if (j1.c())
                                {
                                    return j1;
                                } else
                                {
                                    return (j)_flddelegate.call(networkState, user, cts.a());
                                }
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = final__pcls1;
                networkState = state;
                user = ParseUser.this;
                super();
            }
                        });
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                state = state1;
                delegate = cachethennetworkcallable;
                callback = parsecallback2;
                super();
            }
        });
    }

    private j doWithRunningCheck(Callable callable)
    {
        checkIfRunning(true);
        try
        {
            callable = (j)callable.call();
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            callable = j.a(callable);
        }
        return callable.b(new i() {

            final ParseQuery this$0;

            public j then(j j1)
                throws Exception
            {
                synchronized (lock)
                {
                    isRunning = false;
                    if (cts != null)
                    {
                        cts.a(null);
                    }
                    cts = null;
                }
                return j1;
                j1;
                obj;
                JVM INSTR monitorexit ;
                throw j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
        });
    }

    private j findAsync(final State state)
    {
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final State val$state;

            public j call()
                throws Exception
            {
                return getUserAsync(state).d(new i() {

                    final _cls3 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        j1 = (ParseUser)j1.e();
                        return findAsync(state, j1, cts.a());
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                state = state1;
                super();
            }
        });
    }

    private j getFirstAsync(final State state)
    {
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final State val$state;

            public j call()
                throws Exception
            {
                return getUserAsync(state).d(new i() {

                    final _cls5 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        j1 = (ParseUser)j1.e();
                        return getFirstAsync(state, j1, cts.a());
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                state = state1;
                super();
            }
        });
    }

    private j getFirstAsync(State state, ParseUser parseuser, j j1)
    {
        return getQueryController().getFirstAsync(state, parseuser, j1);
    }

    public static ParseQuery getQuery(Class class1)
    {
        return new ParseQuery(class1);
    }

    public static ParseQuery getQuery(String s)
    {
        return new ParseQuery(s);
    }

    private static ParseQueryController getQueryController()
    {
        return ParseCorePlugins.getInstance().getQueryController();
    }

    public static ParseQuery getUserQuery()
    {
        return ParseUser.getQuery();
    }

    public static ParseQuery or(List list)
    {
        if (list.isEmpty())
        {
            throw new IllegalArgumentException("Can't take an or of an empty list of queries");
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((ParseQuery)list.next()).getBuilder())) { }
        return new ParseQuery(State.Builder.or(arraylist));
    }

    private static void throwIfLDSDisabled()
    {
        throwIfLDSEnabled(true);
    }

    private static void throwIfLDSEnabled()
    {
        throwIfLDSEnabled(false);
    }

    private static void throwIfLDSEnabled(boolean flag)
    {
        boolean flag1 = Parse.isLocalDatastoreEnabled();
        if (flag && !flag1)
        {
            throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
        }
        if (!flag && flag1)
        {
            throw new IllegalStateException("Unsupported method when Local Datastore is enabled.");
        } else
        {
            return;
        }
    }

    public ParseQuery addAscendingOrder(String s)
    {
        checkIfRunning();
        builder.addAscendingOrder(s);
        return this;
    }

    public ParseQuery addDescendingOrder(String s)
    {
        checkIfRunning();
        builder.addDescendingOrder(s);
        return this;
    }

    public void cancel()
    {
        synchronized (lock)
        {
            if (cts != null)
            {
                cts.b();
                cts = null;
            }
            isRunning = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearCachedResult()
    {
        throwIfLDSEnabled();
        State state = builder.build();
        Object obj;
        try
        {
            obj = (ParseUser)ParseTaskUtils.wait(getUserAsync(state));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = ((ParseUser) (obj)).getSessionToken();
        } else
        {
            obj = null;
        }
        ParseKeyValueCache.clearFromKeyValueCache(ParseRESTQueryCommand.findCommand(state, ((String) (obj))).getCacheKey());
    }

    public int count()
        throws ParseException
    {
        return ((Integer)ParseTaskUtils.wait(countInBackground())).intValue();
    }

    public j countInBackground()
    {
        return countAsync((new State.Builder(builder)).setLimit(0).build());
    }

    public void countInBackground(final CountCallback callback)
    {
        Object obj = (new State.Builder(builder)).setLimit(0).build();
        if (callback != null)
        {
            callback = new ParseCallback2() {

                final ParseQuery this$0;
                final CountCallback val$callback;

                public void done(Integer integer, ParseException parseexception)
                {
                    CountCallback countcallback = callback;
                    int i;
                    if (parseexception == null)
                    {
                        i = integer.intValue();
                    } else
                    {
                        i = -1;
                    }
                    countcallback.done(i, parseexception);
                }

                public volatile void done(Object obj1, Throwable throwable)
                {
                    done((Integer)obj1, (ParseException)throwable);
                }

            
            {
                this$0 = ParseQuery.this;
                callback = countcallback;
                super();
            }
            };
        } else
        {
            callback = null;
        }
        if (((State) (obj)).cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || ((State) (obj)).isFromLocalDatastore())
        {
            obj = countAsync(((State) (obj)));
        } else
        {
            obj = doCacheThenNetwork(((State) (obj)), callback, new CacheThenNetworkCallable() {

                final ParseQuery this$0;

                public j call(State state, ParseUser parseuser, j j1)
                {
                    return countAsync(state, parseuser, j1);
                }

                public volatile Object call(State state, ParseUser parseuser, j j1)
                {
                    return call(state, parseuser, j1);
                }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
            });
        }
        ParseTaskUtils.callbackOnMainThreadAsync(((j) (obj)), callback);
    }

    public List find()
        throws ParseException
    {
        return (List)ParseTaskUtils.wait(findInBackground());
    }

    j findAsync(State state, ParseUser parseuser, j j1)
    {
        return getQueryController().findAsync(state, parseuser, j1);
    }

    public j findInBackground()
    {
        return findAsync(builder.build());
    }

    public void findInBackground(FindCallback findcallback)
    {
        Object obj = builder.build();
        if (((State) (obj)).cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || ((State) (obj)).isFromLocalDatastore())
        {
            obj = findAsync(((State) (obj)));
        } else
        {
            obj = doCacheThenNetwork(((State) (obj)), findcallback, new CacheThenNetworkCallable() {

                final ParseQuery this$0;

                public j call(State state, ParseUser parseuser, j j1)
                {
                    return findAsync(state, parseuser, j1);
                }

                public volatile Object call(State state, ParseUser parseuser, j j1)
                {
                    return call(state, parseuser, j1);
                }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
            });
        }
        ParseTaskUtils.callbackOnMainThreadAsync(((j) (obj)), findcallback);
    }

    public ParseQuery fromLocalDatastore()
    {
        builder.fromLocalDatastore();
        return this;
    }

    ParseQuery fromNetwork()
    {
        checkIfRunning();
        builder.fromNetwork();
        return this;
    }

    public ParseQuery fromPin()
    {
        checkIfRunning();
        builder.fromPin();
        return this;
    }

    public ParseQuery fromPin(String s)
    {
        checkIfRunning();
        builder.fromPin(s);
        return this;
    }

    public ParseObject get(String s)
        throws ParseException
    {
        return (ParseObject)ParseTaskUtils.wait(getInBackground(s));
    }

    State.Builder getBuilder()
    {
        return builder;
    }

    public CachePolicy getCachePolicy()
    {
        return builder.getCachePolicy();
    }

    public String getClassName()
    {
        return builder.getClassName();
    }

    public ParseObject getFirst()
        throws ParseException
    {
        return (ParseObject)ParseTaskUtils.wait(getFirstInBackground());
    }

    public j getFirstInBackground()
    {
        return getFirstAsync(builder.setLimit(1).build());
    }

    public void getFirstInBackground(GetCallback getcallback)
    {
        Object obj = builder.setLimit(1).build();
        if (((State) (obj)).cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || ((State) (obj)).isFromLocalDatastore())
        {
            obj = getFirstAsync(((State) (obj)));
        } else
        {
            obj = doCacheThenNetwork(((State) (obj)), getcallback, new CacheThenNetworkCallable() {

                final ParseQuery this$0;

                public j call(State state, ParseUser parseuser, j j1)
                {
                    return getFirstAsync(state, parseuser, j1);
                }

                public volatile Object call(State state, ParseUser parseuser, j j1)
                {
                    return call(state, parseuser, j1);
                }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
            });
        }
        ParseTaskUtils.callbackOnMainThreadAsync(((j) (obj)), getcallback);
    }

    public j getInBackground(String s)
    {
        return getFirstAsync(builder.setSkip(-1).whereObjectIdEquals(s).build());
    }

    public void getInBackground(String s, GetCallback getcallback)
    {
        s = builder.setSkip(-1).whereObjectIdEquals(s).build();
        if (s.cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || s.isFromLocalDatastore())
        {
            s = getFirstAsync(s);
        } else
        {
            s = doCacheThenNetwork(s, getcallback, new CacheThenNetworkCallable() {

                final ParseQuery this$0;

                public j call(State state, ParseUser parseuser, j j1)
                {
                    return getFirstAsync(state, parseuser, j1);
                }

                public volatile Object call(State state, ParseUser parseuser, j j1)
                {
                    return call(state, parseuser, j1);
                }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
            });
        }
        ParseTaskUtils.callbackOnMainThreadAsync(s, getcallback);
    }

    public int getLimit()
    {
        return builder.getLimit();
    }

    public long getMaxCacheAge()
    {
        return builder.getMaxCacheAge();
    }

    public int getSkip()
    {
        return builder.getSkip();
    }

    j getUserAsync(State state)
    {
        if (state.ignoreACLs())
        {
            return j.a(null);
        }
        if (user != null)
        {
            return j.a(user);
        } else
        {
            return ParseUser.getCurrentUserAsync();
        }
    }

    public boolean hasCachedResult()
    {
        throwIfLDSEnabled();
        State state = builder.build();
        Object obj;
        try
        {
            obj = (ParseUser)ParseTaskUtils.wait(getUserAsync(state));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = ((ParseUser) (obj)).getSessionToken();
        } else
        {
            obj = null;
        }
        return ParseKeyValueCache.loadFromKeyValueCache(ParseRESTQueryCommand.findCommand(state, ((String) (obj))).getCacheKey(), state.maxCacheAge()) != null;
    }

    public ParseQuery ignoreACLs()
    {
        checkIfRunning();
        builder.ignoreACLs();
        return this;
    }

    public ParseQuery include(String s)
    {
        checkIfRunning();
        builder.include(s);
        return this;
    }

    boolean isFromNetwork()
    {
        return builder.isFromNetwork();
    }

    public ParseQuery orderByAscending(String s)
    {
        checkIfRunning();
        builder.orderByAscending(s);
        return this;
    }

    public ParseQuery orderByDescending(String s)
    {
        checkIfRunning();
        builder.orderByDescending(s);
        return this;
    }

    public ParseQuery selectKeys(Collection collection)
    {
        checkIfRunning();
        builder.selectKeys(collection);
        return this;
    }

    public ParseQuery setCachePolicy(CachePolicy cachepolicy)
    {
        checkIfRunning();
        builder.setCachePolicy(cachepolicy);
        return this;
    }

    public ParseQuery setLimit(int i)
    {
        checkIfRunning();
        builder.setLimit(i);
        return this;
    }

    public ParseQuery setMaxCacheAge(long l)
    {
        checkIfRunning();
        builder.setMaxCacheAge(l);
        return this;
    }

    public ParseQuery setSkip(int i)
    {
        checkIfRunning();
        builder.setSkip(i);
        return this;
    }

    public ParseQuery setTrace(boolean flag)
    {
        checkIfRunning();
        builder.setTracingEnabled(flag);
        return this;
    }

    ParseQuery setUser(ParseUser parseuser)
    {
        user = parseuser;
        return this;
    }

    public ParseQuery whereContainedIn(String s, Collection collection)
    {
        checkIfRunning();
        builder.addCondition(s, "$in", collection);
        return this;
    }

    public ParseQuery whereContains(String s, String s1)
    {
        whereMatches(s, Pattern.quote(s1));
        return this;
    }

    public ParseQuery whereContainsAll(String s, Collection collection)
    {
        checkIfRunning();
        builder.addCondition(s, "$all", collection);
        return this;
    }

    public ParseQuery whereDoesNotExist(String s)
    {
        checkIfRunning();
        builder.addCondition(s, "$exists", Boolean.valueOf(false));
        return this;
    }

    public ParseQuery whereDoesNotMatchKeyInQuery(String s, String s1, ParseQuery parsequery)
    {
        checkIfRunning();
        builder.whereDoesNotMatchKeyInQuery(s, s1, parsequery.getBuilder());
        return this;
    }

    public ParseQuery whereDoesNotMatchQuery(String s, ParseQuery parsequery)
    {
        checkIfRunning();
        builder.whereDoesNotMatchQuery(s, parsequery.getBuilder());
        return this;
    }

    public ParseQuery whereEndsWith(String s, String s1)
    {
        whereMatches(s, (new StringBuilder()).append(Pattern.quote(s1)).append("$").toString());
        return this;
    }

    public ParseQuery whereEqualTo(String s, Object obj)
    {
        checkIfRunning();
        builder.whereEqualTo(s, obj);
        return this;
    }

    public ParseQuery whereExists(String s)
    {
        checkIfRunning();
        builder.addCondition(s, "$exists", Boolean.valueOf(true));
        return this;
    }

    public ParseQuery whereGreaterThan(String s, Object obj)
    {
        checkIfRunning();
        builder.addCondition(s, "$gt", obj);
        return this;
    }

    public ParseQuery whereGreaterThanOrEqualTo(String s, Object obj)
    {
        checkIfRunning();
        builder.addCondition(s, "$gte", obj);
        return this;
    }

    public ParseQuery whereLessThan(String s, Object obj)
    {
        checkIfRunning();
        builder.addCondition(s, "$lt", obj);
        return this;
    }

    public ParseQuery whereLessThanOrEqualTo(String s, Object obj)
    {
        checkIfRunning();
        builder.addCondition(s, "$lte", obj);
        return this;
    }

    public ParseQuery whereMatches(String s, String s1)
    {
        checkIfRunning();
        builder.addCondition(s, "$regex", s1);
        return this;
    }

    public ParseQuery whereMatches(String s, String s1, String s2)
    {
        checkIfRunning();
        builder.addCondition(s, "$regex", s1);
        if (s2.length() != 0)
        {
            builder.addCondition(s, "$options", s2);
        }
        return this;
    }

    public ParseQuery whereMatchesKeyInQuery(String s, String s1, ParseQuery parsequery)
    {
        checkIfRunning();
        builder.whereMatchesKeyInQuery(s, s1, parsequery.getBuilder());
        return this;
    }

    public ParseQuery whereMatchesQuery(String s, ParseQuery parsequery)
    {
        checkIfRunning();
        builder.whereMatchesQuery(s, parsequery.getBuilder());
        return this;
    }

    public ParseQuery whereNear(String s, ParseGeoPoint parsegeopoint)
    {
        checkIfRunning();
        builder.whereNear(s, parsegeopoint);
        return this;
    }

    public ParseQuery whereNotContainedIn(String s, Collection collection)
    {
        checkIfRunning();
        builder.addCondition(s, "$nin", collection);
        return this;
    }

    public ParseQuery whereNotEqualTo(String s, Object obj)
    {
        checkIfRunning();
        builder.addCondition(s, "$ne", obj);
        return this;
    }

    public ParseQuery whereStartsWith(String s, String s1)
    {
        whereMatches(s, (new StringBuilder()).append("^").append(Pattern.quote(s1)).toString());
        return this;
    }

    public ParseQuery whereWithinGeoBox(String s, ParseGeoPoint parsegeopoint, ParseGeoPoint parsegeopoint1)
    {
        checkIfRunning();
        builder.whereWithin(s, parsegeopoint, parsegeopoint1);
        return this;
    }

    public ParseQuery whereWithinKilometers(String s, ParseGeoPoint parsegeopoint, double d)
    {
        checkIfRunning();
        return whereWithinRadians(s, parsegeopoint, d / ParseGeoPoint.EARTH_MEAN_RADIUS_KM);
    }

    public ParseQuery whereWithinMiles(String s, ParseGeoPoint parsegeopoint, double d)
    {
        checkIfRunning();
        return whereWithinRadians(s, parsegeopoint, d / ParseGeoPoint.EARTH_MEAN_RADIUS_MILE);
    }

    public ParseQuery whereWithinRadians(String s, ParseGeoPoint parsegeopoint, double d)
    {
        checkIfRunning();
        builder.whereNear(s, parsegeopoint).maxDistance(s, d);
        return this;
    }





/*
    static boolean access$1802(ParseQuery parsequery, boolean flag)
    {
        parsequery.isRunning = flag;
        return flag;
    }

*/



/*
    static a.j.a access$1902(ParseQuery parsequery, a.j.a a)
    {
        parsequery.cts = a;
        return a;
    }

*/


}
