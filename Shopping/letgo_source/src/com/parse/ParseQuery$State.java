// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

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
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseQuery, ParseEncoder, ParseTextUtils, ParseObject

static class Builder
{
    static class Builder
    {

        private ParseQuery.CachePolicy cachePolicy;
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
        private final ParseQuery.QueryConstraints where;

        private Builder addConditionInternal(String s, String s1, Object obj)
        {
            if (!where.containsKey(s)) goto _L2; else goto _L1
_L1:
            Object obj1 = where.get(s);
            if (!(obj1 instanceof ParseQuery.KeyConstraints)) goto _L2; else goto _L3
_L3:
            obj1 = (ParseQuery.KeyConstraints)obj1;
_L5:
            ParseQuery.KeyConstraints keyconstraints = ((ParseQuery.KeyConstraints) (obj1));
            if (obj1 == null)
            {
                keyconstraints = new ParseQuery.KeyConstraints();
            }
            keyconstraints.put(s1, obj);
            where.put(s, keyconstraints);
            return this;
_L2:
            obj1 = null;
            if (true) goto _L5; else goto _L4
_L4:
        }

        private Builder addOrder(String s)
        {
            order.add(s);
            return this;
        }

        public static Builder or(List list)
        {
            if (list.isEmpty())
            {
                throw new IllegalArgumentException("Can't take an or of an empty list of queries");
            }
            ArrayList arraylist = new ArrayList();
            Iterator iterator = list.iterator();
            list = null;
            Builder builder;
            for (; iterator.hasNext(); arraylist.add(builder.where))
            {
                builder = (Builder)iterator.next();
                if (list != null && !builder.className.equals(list))
                {
                    throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
                }
                if (builder.limit >= 0)
                {
                    throw new IllegalArgumentException("Cannot have limits in sub queries of an 'OR' query");
                }
                if (builder.skip > 0)
                {
                    throw new IllegalArgumentException("Cannot have skips in sub queries of an 'OR' query");
                }
                if (!builder.order.isEmpty())
                {
                    throw new IllegalArgumentException("Cannot have an order in sub queries of an 'OR' query");
                }
                if (!builder.includes.isEmpty())
                {
                    throw new IllegalArgumentException("Cannot have an include in sub queries of an 'OR' query");
                }
                if (builder.selectedKeys != null)
                {
                    throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an 'OR' query");
                }
                list = builder.className;
            }

            return (new Builder(list)).whereSatifiesAnyOf(arraylist);
        }

        private Builder setOrder(String s)
        {
            order.clear();
            order.add(s);
            return this;
        }

        private Builder whereSatifiesAnyOf(List list)
        {
            where.put("$or", list);
            return this;
        }

        public Builder addAscendingOrder(String s)
        {
            return addOrder(s);
        }

        public Builder addCondition(String s, String s1, Object obj)
        {
            return addConditionInternal(s, s1, obj);
        }

        public Builder addCondition(String s, String s1, Collection collection)
        {
            return addConditionInternal(s, s1, Collections.unmodifiableCollection(collection));
        }

        public Builder addDescendingOrder(String s)
        {
            return addOrder(String.format("-%s", new Object[] {
                s
            }));
        }

        public ParseQuery.State build()
        {
            if (!isFromLocalDatastore && ignoreACLs)
            {
                throw new IllegalStateException("`ignoreACLs` cannot be combined with network queries");
            } else
            {
                return new ParseQuery.State(this, null);
            }
        }

        public Builder fromLocalDatastore()
        {
            return fromPin(null);
        }

        public Builder fromNetwork()
        {
            ParseQuery.access$100();
            isFromLocalDatastore = false;
            pinName = null;
            return this;
        }

        public Builder fromPin()
        {
            return fromPin("_default");
        }

        public Builder fromPin(String s)
        {
            ParseQuery.access$100();
            isFromLocalDatastore = true;
            pinName = s;
            return this;
        }

        public ParseQuery.CachePolicy getCachePolicy()
        {
            ParseQuery.access$000();
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
            ParseQuery.access$000();
            return maxCacheAge;
        }

        public int getSkip()
        {
            return skip;
        }

        public Builder ignoreACLs()
        {
            ParseQuery.access$100();
            ignoreACLs = true;
            return this;
        }

        public Builder include(String s)
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
            ParseQuery.access$100();
            return !isFromLocalDatastore;
        }

        public Builder orderByAscending(String s)
        {
            return setOrder(s);
        }

        public Builder orderByDescending(String s)
        {
            return setOrder(String.format("-%s", new Object[] {
                s
            }));
        }

        Builder redirectClassNameForKey(String s)
        {
            extraOptions.put("redirectClassNameForKey", s);
            return this;
        }

        public Builder selectKeys(Collection collection)
        {
            if (selectedKeys == null)
            {
                selectedKeys = new HashSet();
            }
            selectedKeys.addAll(collection);
            return this;
        }

        public Builder setCachePolicy(ParseQuery.CachePolicy cachepolicy)
        {
            ParseQuery.access$000();
            cachePolicy = cachepolicy;
            return this;
        }

        public Builder setLimit(int i)
        {
            limit = i;
            return this;
        }

        public Builder setMaxCacheAge(long l)
        {
            ParseQuery.access$000();
            maxCacheAge = l;
            return this;
        }

        public Builder setSkip(int i)
        {
            skip = i;
            return this;
        }

        public Builder setTracingEnabled(boolean flag)
        {
            trace = flag;
            return this;
        }

        public Builder whereDoesNotMatchKeyInQuery(String s, String s1, Builder builder)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("key", s1);
            hashmap.put("query", builder);
            return addConditionInternal(s, "$dontSelect", Collections.unmodifiableMap(hashmap));
        }

        public Builder whereDoesNotMatchQuery(String s, Builder builder)
        {
            return addConditionInternal(s, "$notInQuery", builder);
        }

        public Builder whereEqualTo(String s, Object obj)
        {
            where.put(s, obj);
            return this;
        }

        public Builder whereMatchesKeyInQuery(String s, String s1, Builder builder)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("key", s1);
            hashmap.put("query", builder);
            return addConditionInternal(s, "$select", Collections.unmodifiableMap(new HashMap(hashmap)));
        }

        public Builder whereMatchesQuery(String s, Builder builder)
        {
            return addConditionInternal(s, "$inQuery", builder);
        }

        Builder whereObjectIdEquals(String s)
        {
            where.clear();
            where.put("objectId", s);
            return this;
        }

        Builder whereRelatedTo(ParseObject parseobject, String s)
        {
            where.put("$relatedTo", new ParseQuery.RelationConstraint(s, parseobject));
            return this;
        }















        public Builder(Builder builder)
        {
            where = new ParseQuery.QueryConstraints();
            includes = new HashSet();
            limit = -1;
            skip = 0;
            order = new ArrayList();
            extraOptions = new HashMap();
            cachePolicy = ParseQuery.CachePolicy.IGNORE_CACHE;
            maxCacheAge = 0x7fffffffffffffffL;
            isFromLocalDatastore = false;
            className = builder.className;
            where.putAll(builder.where);
            includes.addAll(builder.includes);
            HashSet hashset;
            if (builder.selectedKeys != null)
            {
                hashset = new HashSet(builder.selectedKeys);
            } else
            {
                hashset = null;
            }
            selectedKeys = hashset;
            limit = builder.limit;
            skip = builder.skip;
            order.addAll(builder.order);
            extraOptions.putAll(builder.extraOptions);
            trace = builder.trace;
            cachePolicy = builder.cachePolicy;
            maxCacheAge = builder.maxCacheAge;
            isFromLocalDatastore = builder.isFromLocalDatastore;
            pinName = builder.pinName;
            ignoreACLs = builder.ignoreACLs;
        }

        public Builder(ParseQuery.State state)
        {
            where = new ParseQuery.QueryConstraints();
            includes = new HashSet();
            limit = -1;
            skip = 0;
            order = new ArrayList();
            extraOptions = new HashMap();
            cachePolicy = ParseQuery.CachePolicy.IGNORE_CACHE;
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

        public Builder(Class class1)
        {
            this(ParseObject.getClassName(class1));
        }

        public Builder(String s)
        {
            where = new ParseQuery.QueryConstraints();
            includes = new HashSet();
            limit = -1;
            skip = 0;
            order = new ArrayList();
            extraOptions = new HashMap();
            cachePolicy = ParseQuery.CachePolicy.IGNORE_CACHE;
            maxCacheAge = 0x7fffffffffffffffL;
            isFromLocalDatastore = false;
            className = s;
        }
    }


    private final olicy cachePolicy;
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
    private final onstraints where;

    public olicy cachePolicy()
    {
        return cachePolicy;
    }

    public String className()
    {
        return className;
    }

    public onstraints constraints()
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

    private Builder(Builder builder)
    {
        className = builder.className;
        where = new onstraints(builder.where);
        include = Collections.unmodifiableSet(new HashSet(builder.includes));
        Set set;
        if (builder.selectedKeys != null)
        {
            set = Collections.unmodifiableSet(new HashSet(builder.selectedKeys));
        } else
        {
            set = null;
        }
        selectedKeys = set;
        limit = builder.limit;
        skip = builder.skip;
        order = Collections.unmodifiableList(new ArrayList(builder.order));
        extraOptions = Collections.unmodifiableMap(new HashMap(builder.extraOptions));
        trace = builder.trace;
        cachePolicy = builder.cachePolicy;
        maxCacheAge = builder.maxCacheAge;
        isFromLocalDatastore = builder.isFromLocalDatastore;
        pinName = builder.pinName;
        ignoreACLs = builder.ignoreACLs;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }
}
