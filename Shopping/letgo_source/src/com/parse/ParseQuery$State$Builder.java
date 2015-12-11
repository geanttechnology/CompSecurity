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
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.parse:
//            ParseQuery, ParseObject

static class className
{

    private aint cachePolicy;
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
    private final ts where;

    private className addConditionInternal(String s, String s1, Object obj)
    {
        if (!where.containsKey(s)) goto _L2; else goto _L1
_L1:
        Object obj1 = where.get(s);
        if (!(obj1 instanceof )) goto _L2; else goto _L3
_L3:
        obj1 = ()obj1;
_L5:
          = (() (obj1));
        if (obj1 == null)
        {
             = new ();
        }
        .put(s1, obj);
        where.put(s, );
        return this;
_L2:
        obj1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private ts.put addOrder(String s)
    {
        order.add(s);
        return this;
    }

    public static order or(List list)
    {
        if (list.isEmpty())
        {
            throw new IllegalArgumentException("Can't take an or of an empty list of queries");
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        list = null;
        order order1;
        for (; iterator.hasNext(); arraylist.add(order1.where))
        {
            order1 = (where)iterator.next();
            if (list != null && !order1.className.equals(list))
            {
                throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
            }
            if (order1.limit >= 0)
            {
                throw new IllegalArgumentException("Cannot have limits in sub queries of an 'OR' query");
            }
            if (order1.skip > 0)
            {
                throw new IllegalArgumentException("Cannot have skips in sub queries of an 'OR' query");
            }
            if (!order1.order.isEmpty())
            {
                throw new IllegalArgumentException("Cannot have an order in sub queries of an 'OR' query");
            }
            if (!order1.includes.isEmpty())
            {
                throw new IllegalArgumentException("Cannot have an include in sub queries of an 'OR' query");
            }
            if (order1.selectedKeys != null)
            {
                throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an 'OR' query");
            }
            list = order1.className;
        }

        return (new <init>(list)).whereSatifiesAnyOf(arraylist);
    }

    private whereSatifiesAnyOf setOrder(String s)
    {
        order.clear();
        order.add(s);
        return this;
    }

    private order whereSatifiesAnyOf(List list)
    {
        where.put("$or", list);
        return this;
    }

    public ts.put addAscendingOrder(String s)
    {
        return addOrder(s);
    }

    public addOrder addCondition(String s, String s1, Object obj)
    {
        return addConditionInternal(s, s1, obj);
    }

    public addConditionInternal addCondition(String s, String s1, Collection collection)
    {
        return addConditionInternal(s, s1, Collections.unmodifiableCollection(collection));
    }

    public ollection addDescendingOrder(String s)
    {
        return addOrder(String.format("-%s", new Object[] {
            s
        }));
    }

    public addOrder build()
    {
        if (!isFromLocalDatastore && ignoreACLs)
        {
            throw new IllegalStateException("`ignoreACLs` cannot be combined with network queries");
        } else
        {
            return new it>(this, null);
        }
    }

    public it> fromLocalDatastore()
    {
        return fromPin(null);
    }

    public fromPin fromNetwork()
    {
        ParseQuery.access$100();
        isFromLocalDatastore = false;
        pinName = null;
        return this;
    }

    public pinName fromPin()
    {
        return fromPin("_default");
    }

    public fromPin fromPin(String s)
    {
        ParseQuery.access$100();
        isFromLocalDatastore = true;
        pinName = s;
        return this;
    }

    public pinName getCachePolicy()
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

    public skip ignoreACLs()
    {
        ParseQuery.access$100();
        ignoreACLs = true;
        return this;
    }

    public ignoreACLs include(String s)
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

    public isFromLocalDatastore orderByAscending(String s)
    {
        return setOrder(s);
    }

    public setOrder orderByDescending(String s)
    {
        return setOrder(String.format("-%s", new Object[] {
            s
        }));
    }

    setOrder redirectClassNameForKey(String s)
    {
        extraOptions.put("redirectClassNameForKey", s);
        return this;
    }

    public extraOptions selectKeys(Collection collection)
    {
        if (selectedKeys == null)
        {
            selectedKeys = new HashSet();
        }
        selectedKeys.addAll(collection);
        return this;
    }

    public selectedKeys setCachePolicy(selectedKeys selectedkeys)
    {
        ParseQuery.access$000();
        cachePolicy = selectedkeys;
        return this;
    }

    public cachePolicy setLimit(int i)
    {
        limit = i;
        return this;
    }

    public limit setMaxCacheAge(long l)
    {
        ParseQuery.access$000();
        maxCacheAge = l;
        return this;
    }

    public maxCacheAge setSkip(int i)
    {
        skip = i;
        return this;
    }

    public skip setTracingEnabled(boolean flag)
    {
        trace = flag;
        return this;
    }

    public trace whereDoesNotMatchKeyInQuery(String s, String s1, trace trace1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("key", s1);
        hashmap.put("query", trace1);
        return addConditionInternal(s, "$dontSelect", Collections.unmodifiableMap(hashmap));
    }

    public ap whereDoesNotMatchQuery(String s, ap ap)
    {
        return addConditionInternal(s, "$notInQuery", ap);
    }

    public addConditionInternal whereEqualTo(String s, Object obj)
    {
        where.put(s, obj);
        return this;
    }

    public ts.put whereMatchesKeyInQuery(String s, String s1, ts.put put)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("key", s1);
        hashmap.put("query", put);
        return addConditionInternal(s, "$select", Collections.unmodifiableMap(new HashMap(hashmap)));
    }

    public ap whereMatchesQuery(String s, ap ap)
    {
        return addConditionInternal(s, "$inQuery", ap);
    }

    addConditionInternal whereObjectIdEquals(String s)
    {
        where.clear();
        where.put("objectId", s);
        return this;
    }

    ts.put whereRelatedTo(ParseObject parseobject, String s)
    {
        where.put("$relatedTo", new aint(s, parseobject));
        return this;
    }















    public ts(ts ts)
    {
        where = new ts();
        includes = new HashSet();
        limit = -1;
        skip = 0;
        order = new ArrayList();
        extraOptions = new HashMap();
        cachePolicy = NORE_CACHE;
        maxCacheAge = 0x7fffffffffffffffL;
        isFromLocalDatastore = false;
        className = ts.className;
        where.putAll(ts.where);
        includes.addAll(ts.includes);
        HashSet hashset;
        if (ts.selectedKeys != null)
        {
            hashset = new HashSet(ts.selectedKeys);
        } else
        {
            hashset = null;
        }
        selectedKeys = hashset;
        limit = ts.limit;
        skip = ts.skip;
        order.addAll(ts.order);
        extraOptions.putAll(ts.extraOptions);
        trace = ts.trace;
        cachePolicy = ts.cachePolicy;
        maxCacheAge = ts.maxCacheAge;
        isFromLocalDatastore = ts.isFromLocalDatastore;
        pinName = ts.pinName;
        ignoreACLs = ts.ignoreACLs;
    }

    public ignoreACLs(ignoreACLs ignoreacls)
    {
        where = new ts();
        includes = new HashSet();
        limit = -1;
        skip = 0;
        order = new ArrayList();
        extraOptions = new HashMap();
        cachePolicy = NORE_CACHE;
        maxCacheAge = 0x7fffffffffffffffL;
        isFromLocalDatastore = false;
        className = ignoreacls.e();
        where.putAll(ignoreacls.nts());
        includes.addAll(ignoreacls.());
        HashSet hashset;
        if (ignoreacls.Keys() != null)
        {
            hashset = new HashSet(ignoreacls.Keys());
        } else
        {
            hashset = null;
        }
        selectedKeys = hashset;
        limit = ignoreacls.limit();
        skip = ignoreacls.skip();
        order.addAll(ignoreacls.order());
        extraOptions.putAll(ignoreacls.ions());
        trace = ignoreacls.gEnabled();
        cachePolicy = ignoreacls.icy();
        maxCacheAge = ignoreacls.Age();
        isFromLocalDatastore = ignoreacls.calDatastore();
        pinName = ignoreacls.pinName();
        ignoreACLs = ignoreacls.Ls();
    }

    public Ls(Class class1)
    {
        this(ParseObject.getClassName(class1));
    }

    public <init>(String s)
    {
        where = new ts();
        includes = new HashSet();
        limit = -1;
        skip = 0;
        order = new ArrayList();
        extraOptions = new HashMap();
        cachePolicy = NORE_CACHE;
        maxCacheAge = 0x7fffffffffffffffL;
        isFromLocalDatastore = false;
        className = s;
    }
}
