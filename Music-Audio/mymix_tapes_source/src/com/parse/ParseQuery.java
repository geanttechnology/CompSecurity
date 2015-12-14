// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore, Parse, ParseRelation, 
//            ParsePin, ParseUser, ParseCommand, ParseException, 
//            PointerEncodingStrategy, ParseGeoPoint, ParseCallback, CountCallback, 
//            FindCallback, GetCallback, ParseObjectEncodingStrategy

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

    private static interface CallableWithCachePolicy
    {

        public abstract Object call(CachePolicy cachepolicy);
    }

    private static interface CommandDelegate
    {

        public abstract Task runFromCacheAsync();

        public abstract Task runOnNetworkAsync(boolean flag);
    }

    static class KeyConstraints extends HashMap
    {

        KeyConstraints()
        {
        }
    }

    static class QueryConstraints extends HashMap
    {

        QueryConstraints()
        {
        }
    }

    static class RelationConstraint
    {

        private String key;
        private ParseObject object;

        public JSONObject encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("key", key);
                jsonobject.put("object", parseobjectencodingstrategy.encodeRelatedObject(object));
            }
            // Misplaced declaration of an exception variable
            catch (ParseObjectEncodingStrategy parseobjectencodingstrategy)
            {
                throw new RuntimeException(parseobjectencodingstrategy);
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


    private static final String TAG = "com.parse.ParseQuery";
    private CachePolicy cachePolicy;
    private String className;
    private ParseCommand currentCommand;
    private HashMap extraOptions;
    private boolean ignoreACLs;
    private ArrayList include;
    private boolean isRunning;
    private final Object isRunningLock;
    private int limit;
    private long maxCacheAge;
    private long objectsParsed;
    private String order;
    private String pinName;
    private long queryReceived;
    private long querySent;
    private long queryStart;
    private ArrayList selectedKeys;
    private int skip;
    private boolean trace;
    private QueryConstraints where;

    public ParseQuery(Class class1)
    {
        this(ParseObject.getClassName(class1));
    }

    public ParseQuery(String s)
    {
        isRunningLock = new Object();
        currentCommand = null;
        isRunning = false;
        extraOptions = null;
        className = s;
        limit = -1;
        skip = 0;
        where = new QueryConstraints();
        include = new ArrayList();
        cachePolicy = CachePolicy.IGNORE_CACHE;
        maxCacheAge = 0x7fffffffffffffffL;
        trace = false;
        extraOptions = new HashMap();
    }

    private void addCondition(String s, String s1, Object obj)
    {
        checkIfRunning();
        KeyConstraints keyconstraints1 = null;
        KeyConstraints keyconstraints = keyconstraints1;
        if (where.containsKey(s))
        {
            Object obj1 = where.get(s);
            keyconstraints = keyconstraints1;
            if (obj1 instanceof KeyConstraints)
            {
                keyconstraints = (KeyConstraints)obj1;
            }
        }
        keyconstraints1 = keyconstraints;
        if (keyconstraints == null)
        {
            keyconstraints1 = new KeyConstraints();
        }
        keyconstraints1.put(s1, obj);
        where.put(s, keyconstraints1);
    }

    private void checkIfRunning()
    {
        checkIfRunning(false);
    }

    private void checkIfRunning(boolean flag)
    {
        Object obj = isRunningLock;
        obj;
        JVM INSTR monitorenter ;
        if (isRunning)
        {
            throw new RuntimeException("This query has an outstanding network connection. You have to wait until it's done.");
        }
        break MISSING_BLOCK_LABEL_30;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        isRunning = true;
        obj;
        JVM INSTR monitorexit ;
    }

    private static void checkPinningEnabled(boolean flag)
    {
        if (flag && !OfflineStore.isEnabled())
        {
            throw new IllegalStateException("Method requires Pinning to be enabled.");
        }
        if (!flag && OfflineStore.isEnabled())
        {
            throw new IllegalStateException("Method not allowed when Pinning is enabled.");
        } else
        {
            return;
        }
    }

    public static void clearAllCachedResults()
    {
        checkPinningEnabled(false);
        Parse.clearCacheDir();
    }

    private List convertFindResponse(JSONObject jsonobject)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        JSONArray jsonarray = jsonobject.getJSONArray("results");
        if (jsonarray == null)
        {
            Parse.logD("com.parse.ParseQuery", "null results in find response");
        } else
        {
            String s1 = jsonobject.optString("className");
            String s = s1;
            if (s1.equals(""))
            {
                s = className;
            }
            int i = 0;
            while (i < jsonarray.length()) 
            {
                Object obj = jsonarray.getJSONObject(i);
                RelationConstraint relationconstraint;
                boolean flag;
                if (selectedKeys == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj = ParseObject.fromJSON(((JSONObject) (obj)), s, flag);
                arraylist.add(obj);
                relationconstraint = (RelationConstraint)where.get("$relatedTo");
                if (relationconstraint != null)
                {
                    relationconstraint.getRelation().addKnownObject(((ParseObject) (obj)));
                }
                i++;
            }
        }
        objectsParsed = System.nanoTime();
        if (jsonobject.has("trace"))
        {
            jsonobject = ((JSONObject) (jsonobject.get("trace")));
            Parse.logD("ParseQuery", String.format("Query pre-processing took %f seconds\n%s\nClient side parsing took %f seconds\n", new Object[] {
                Float.valueOf((float)(querySent - queryStart) / 1000000F), jsonobject, Float.valueOf((float)(objectsParsed - queryReceived) / 1000000F)
            }));
        }
        return arraylist;
    }

    private Task countFromCacheAsync(final ParseUser user, final boolean includeIsDeletingEventually, final boolean ignoreACLs)
    {
        final OfflineStore store = OfflineStore.getCurrent();
        if (store != null)
        {
            Task task;
            if (pinName != null)
            {
                task = ParsePin.getParsePin(pinName);
            } else
            {
                task = Task.forResult(null);
            }
            return task.onSuccessTask(new Continuation() {

                final ParseQuery this$0;
                final boolean val$ignoreACLs;
                final boolean val$includeIsDeletingEventually;
                final OfflineStore val$store;
                final ParseUser val$user;

                public Task then(Task task1)
                    throws Exception
                {
                    task1 = (ParsePin)task1.getResult();
                    return store.countAsync(ParseQuery.this, user, task1, includeIsDeletingEventually, ignoreACLs);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseQuery.this;
                store = offlinestore;
                user = parseuser;
                includeIsDeletingEventually = flag;
                ignoreACLs = flag1;
                super();
            }
            });
        } else
        {
            return Task.call(new Callable() {

                final ParseQuery this$0;

                public Integer call()
                    throws Exception
                {
                    Object obj = Parse.jsonFromKeyValueCache(makeCountCommand(ParseUser.getCurrentSessionToken()).getCacheKey(), maxCacheAge);
                    if (obj == null)
                    {
                        throw new ParseException(120, "results not cached");
                    }
                    if (!(obj instanceof JSONObject))
                    {
                        throw new ParseException(120, "the cache contains the wrong datatype");
                    }
                    obj = (JSONObject)obj;
                    int i;
                    try
                    {
                        i = ((JSONObject) (obj)).getInt("count");
                    }
                    catch (JSONException jsonexception)
                    {
                        throw new ParseException(120, "the cache contains corrupted json");
                    }
                    return Integer.valueOf(i);
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
    }

    private Task countFromNetworkAsync()
    {
        final boolean caching;
        if (cachePolicy != CachePolicy.IGNORE_CACHE)
        {
            caching = true;
        } else
        {
            caching = false;
        }
        currentCommand = makeCountCommand(ParseUser.getCurrentSessionToken());
        return currentCommand.executeAsync().onSuccessTask(new Continuation() {

            final ParseQuery this$0;
            final boolean val$caching;

            public Task then(Task task)
                throws Exception
            {
                if (caching)
                {
                    Object obj = task.getResult();
                    Parse.saveToKeyValueCache(currentCommand.getCacheKey(), obj.toString());
                }
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseQuery.this;
                caching = flag;
                super();
            }
        }).continueWith(new Continuation() {

            final ParseQuery this$0;

            public Integer then(Task task)
                throws Exception
            {
                return Integer.valueOf(((JSONObject)task.getResult()).optInt("count"));
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
        });
    }

    private Task countWithCachePolicyAsync(CachePolicy cachepolicy, final ParseUser user)
    {
        return runCommandWithPolicyAsync(new CommandDelegate() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task runFromCacheAsync()
            {
                return countFromCacheAsync(user, false, ignoreACLs);
            }

            public Task runOnNetworkAsync(boolean flag)
            {
                return countFromNetworkAsync();
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        }, cachepolicy);
    }

    private void doInBackground(final CallableWithCachePolicy callable, final ParseCallback callback)
    {
        Parse.callbackOnMainThreadAsync(doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final CallableWithCachePolicy val$callable;
            final ParseCallback val$callback;

            public Task call()
                throws Exception
            {
                if (cachePolicy == CachePolicy.CACHE_THEN_NETWORK)
                {
                    return Parse.callbackOnMainThreadAsync((Task)callable.call(CachePolicy.CACHE_ONLY), callback).continueWithTask(new Continuation() {

                        final _cls13 this$1;

                        public Task then(Task task)
                            throws Exception
                        {
                            if (task.isCancelled())
                            {
                                return task;
                            } else
                            {
                                return (Task)callable.call(CachePolicy.NETWORK_ONLY);
                            }
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = _cls13.this;
                super();
            }
                    });
                } else
                {
                    return (Task)callable.call(cachePolicy);
                }
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                callable = callablewithcachepolicy;
                callback = parsecallback;
                super();
            }
        }), callback);
    }

    private Task doWithRunningCheck(Callable callable)
    {
        checkIfRunning(true);
        try
        {
            callable = (Task)callable.call();
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            callable = Task.forError(callable);
        }
        return callable.continueWithTask(new Continuation() {

            final ParseQuery this$0;

            public Task then(Task task)
                throws Exception
            {
                synchronized (isRunningLock)
                {
                    isRunning = false;
                    currentCommand = null;
                }
                return task;
                task;
                obj;
                JVM INSTR monitorexit ;
                throw task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
        });
    }

    private Task findFromNetworkAsync(final boolean shouldRetry)
    {
        currentCommand = makeFindCommand(ParseUser.getCurrentSessionToken());
        return Task.call(new Callable() {

            final ParseQuery this$0;
            final boolean val$shouldRetry;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                if (shouldRetry)
                {
                    currentCommand.enableRetrying();
                }
                return null;
            }

            
            {
                this$0 = ParseQuery.this;
                shouldRetry = flag;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParseQuery this$0;

            public Task then(Task task)
                throws Exception
            {
                task = new ArrayList();
                if (currentCommand == null)
                {
                    return Task.forResult(task);
                }
                boolean flag;
                if (cachePolicy != CachePolicy.IGNORE_CACHE)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                querySent = System.nanoTime();
                return currentCommand.executeAsync().onSuccess(flag. new Continuation() {

                    final _cls6 this$1;
                    final boolean val$caching;

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

                    public List then(Task task)
                        throws Exception
                    {
                        if (caching)
                        {
                            Object obj = task.getResult();
                            Parse.saveToKeyValueCache(currentCommand.getCacheKey(), obj.toString());
                        }
                        queryReceived = System.nanoTime();
                        return convertFindResponse((JSONObject)task.getResult());
                    }

            
            {
                this$1 = final__pcls6;
                caching = Z.this;
                super();
            }
                });
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
        });
    }

    private ParseQuery fromLocalDatastore(String s, boolean flag)
    {
        checkPinningEnabled(true);
        checkIfRunning();
        cachePolicy = CachePolicy.CACHE_ONLY;
        pinName = s;
        ignoreACLs = flag;
        return this;
    }

    private Task getFirstWithCachePolicyAsync(CachePolicy cachepolicy, ParseUser parseuser)
    {
        limit = 1;
        return findWithCachePolicyAsync(cachepolicy, parseuser).continueWith(new Continuation() {

            final ParseQuery this$0;

            public ParseObject then(Task task)
                throws Exception
            {
                if (task.isFaulted())
                {
                    throw task.getError();
                }
                if (task.getResult() != null && ((List)task.getResult()).size() > 0)
                {
                    return (ParseObject)((List)task.getResult()).get(0);
                } else
                {
                    throw new ParseException(101, "no results found for query");
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
        });
    }

    public static ParseQuery getQuery(Class class1)
    {
        return new ParseQuery(class1);
    }

    public static ParseQuery getQuery(String s)
    {
        return new ParseQuery(s);
    }

    public static ParseQuery getUserQuery()
    {
        return ParseUser.getQuery();
    }

    private Task getWithCachePolicyAsync(String s, CachePolicy cachepolicy, ParseUser parseuser)
    {
        skip = -1;
        where = new QueryConstraints();
        where.put("objectId", s);
        return getFirstWithCachePolicyAsync(cachepolicy, parseuser);
    }

    private ParseCommand makeCountCommand(String s)
    {
        s = makeFindCommand(s);
        s.put("limit", 0);
        s.put("count", 1);
        return s;
    }

    private ParseCommand makeFindCommand(String s)
    {
        s = new ParseCommand("find", s);
        JSONObject jsonobject = toJSON();
        Iterator iterator = jsonobject.keys();
        try
        {
            while (iterator.hasNext()) 
            {
                String s1 = (String)iterator.next();
                s.put(s1, jsonobject.get(s1).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public static ParseQuery or(List list)
    {
        ArrayList arraylist = new ArrayList();
        String s = null;
        for (int i = 0; i < list.size(); i++)
        {
            if (s != null && !((ParseQuery)list.get(i)).className.equals(s))
            {
                throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
            }
            s = ((ParseQuery)list.get(i)).className;
            arraylist.add(list.get(i));
        }

        if (arraylist.size() == 0)
        {
            throw new IllegalArgumentException("Can't take an or of an empty list of queries");
        } else
        {
            return (new ParseQuery(s)).whereSatifiesAnyOf(arraylist);
        }
    }

    private Task runCommandWithPolicyAsync(final CommandDelegate c, CachePolicy cachepolicy)
    {
        static class _cls24
        {

            static final int $SwitchMap$com$parse$ParseQuery$CachePolicy[];

            static 
            {
                $SwitchMap$com$parse$ParseQuery$CachePolicy = new int[CachePolicy.values().length];
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[CachePolicy.IGNORE_CACHE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[CachePolicy.NETWORK_ONLY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[CachePolicy.CACHE_ONLY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[CachePolicy.CACHE_ELSE_NETWORK.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[CachePolicy.NETWORK_ELSE_CACHE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$parse$ParseQuery$CachePolicy[CachePolicy.CACHE_THEN_NETWORK.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls24..SwitchMap.com.parse.ParseQuery.CachePolicy[cachepolicy.ordinal()])
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unknown cache policy: ").append(cachePolicy).toString());

        case 1: // '\001'
        case 2: // '\002'
            return c.runOnNetworkAsync(true);

        case 3: // '\003'
            return c.runFromCacheAsync();

        case 4: // '\004'
            return c.runFromCacheAsync().continueWithTask(new Continuation() {

                final ParseQuery this$0;
                final CommandDelegate val$c;

                public Task then(Task task)
                    throws Exception
                {
                    Task task1 = task;
                    if (task.isFaulted())
                    {
                        task1 = task;
                        if (task.getError() instanceof ParseException)
                        {
                            task1 = c.runOnNetworkAsync(true);
                        }
                    }
                    return task1;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseQuery.this;
                c = commanddelegate;
                super();
            }
            });

        case 5: // '\005'
            return c.runOnNetworkAsync(false).continueWithTask(new Continuation() {

                final ParseQuery this$0;
                final CommandDelegate val$c;

                public Task then(Task task)
                    throws Exception
                {
                    Task task1 = task;
                    if (task.isFaulted())
                    {
                        task1 = task;
                        if (task.getError() instanceof ParseException)
                        {
                            task1 = task;
                            if (((ParseException)task.getError()).getCode() == 100)
                            {
                                task1 = c.runFromCacheAsync();
                            }
                        }
                    }
                    return task1;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseQuery.this;
                c = commanddelegate;
                super();
            }
            });

        case 6: // '\006'
            throw new RuntimeException("You cannot use the cache policy CACHE_THEN_NETWORK with find()");
        }
    }

    private JSONObject toJSON()
    {
        JSONObject jsonobject = toREST();
        try
        {
            if (!jsonobject.isNull("where"))
            {
                jsonobject.put("data", jsonobject.remove("where"));
            }
            jsonobject.put("classname", jsonobject.remove("className"));
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception);
        }
        return jsonobject;
    }

    private ParseQuery whereSatifiesAnyOf(List list)
    {
        ArrayList arraylist = new ArrayList();
        ParseQuery parsequery;
        for (list = list.iterator(); list.hasNext(); arraylist.add(parsequery.getConstraints()))
        {
            parsequery = (ParseQuery)list.next();
            if (parsequery.limit >= 0)
            {
                throw new IllegalArgumentException("Cannot have limits in sub queries of an 'OR' query");
            }
            if (parsequery.skip > 0)
            {
                throw new IllegalArgumentException("Cannot have skips in sub queries of an 'OR' query");
            }
            if (parsequery.order != null)
            {
                throw new IllegalArgumentException("Cannot have an order in sub queries of an 'OR' query");
            }
            if (!parsequery.include.isEmpty())
            {
                throw new IllegalArgumentException("Cannot have an include in sub queries of an 'OR' query");
            }
            if (parsequery.selectedKeys != null)
            {
                throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an 'OR' query");
            }
        }

        where.put("$or", arraylist);
        return this;
    }

    public ParseQuery addAscendingOrder(String s)
    {
        checkIfRunning();
        if (order == null)
        {
            order = s;
            return this;
        } else
        {
            order = (new StringBuilder()).append(order).append(",").append(s).toString();
            return this;
        }
    }

    public ParseQuery addDescendingOrder(String s)
    {
        checkIfRunning();
        if (order == null)
        {
            order = (new StringBuilder()).append("-").append(s).toString();
            return this;
        } else
        {
            order = (new StringBuilder()).append(order).append(",-").append(s).toString();
            return this;
        }
    }

    public void cancel()
    {
        synchronized (isRunningLock)
        {
            if (currentCommand != null)
            {
                currentCommand.cancel();
                currentCommand = null;
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
        checkPinningEnabled(false);
        Parse.clearFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey());
    }

    public int count()
        throws ParseException
    {
        return ((Integer)Parse.waitForTask(countInBackground())).intValue();
    }

    public Task countInBackground()
    {
        final ParseUser user = ParseUser.getCurrentUser();
        queryStart = System.nanoTime();
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task call()
                throws Exception
            {
                return countWithCachePolicyAsync(cachePolicy, user);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        });
    }

    public void countInBackground(CountCallback countcallback)
    {
        final ParseUser user = ParseUser.getCurrentUser();
        queryStart = System.nanoTime();
        doInBackground(new CallableWithCachePolicy() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task call(CachePolicy cachepolicy)
            {
                return countWithCachePolicyAsync(cachepolicy, user);
            }

            public volatile Object call(CachePolicy cachepolicy)
            {
                return call(cachepolicy);
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        }, countcallback);
    }

    public List find()
        throws ParseException
    {
        return (List)Parse.waitForTask(findInBackground());
    }

    Task findFromCacheAsync(final ParseUser user, final boolean includeIsDeletingEventually, final boolean ignoreACLs)
    {
        final OfflineStore store = OfflineStore.getCurrent();
        if (store != null)
        {
            Task task;
            if (pinName != null)
            {
                task = ParsePin.getParsePin(pinName);
            } else
            {
                task = Task.forResult(null);
            }
            return task.onSuccessTask(new Continuation() {

                final ParseQuery this$0;
                final boolean val$ignoreACLs;
                final boolean val$includeIsDeletingEventually;
                final OfflineStore val$store;
                final ParseUser val$user;

                public Task then(Task task1)
                    throws Exception
                {
                    task1 = (ParsePin)task1.getResult();
                    return store.findAsync(ParseQuery.this, user, task1, includeIsDeletingEventually, ignoreACLs);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseQuery.this;
                store = offlinestore;
                user = parseuser;
                includeIsDeletingEventually = flag;
                ignoreACLs = flag1;
                super();
            }
            });
        } else
        {
            return Task.call(new Callable() {

                final ParseQuery this$0;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public List call()
                    throws Exception
                {
                    Object obj = Parse.jsonFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey(), maxCacheAge);
                    if (obj == null)
                    {
                        throw new ParseException(120, "results not cached");
                    }
                    if (!(obj instanceof JSONObject))
                    {
                        throw new ParseException(120, "the cache contains the wrong datatype");
                    }
                    obj = (JSONObject)obj;
                    try
                    {
                        obj = convertFindResponse(((JSONObject) (obj)));
                    }
                    catch (JSONException jsonexception)
                    {
                        throw new ParseException(120, "the cache contains corrupted json");
                    }
                    return ((List) (obj));
                }

            
            {
                this$0 = ParseQuery.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
    }

    public Task findInBackground()
    {
        return findInBackground(ParseUser.getCurrentUser());
    }

    Task findInBackground(final ParseUser user)
    {
        queryStart = System.nanoTime();
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task call()
                throws Exception
            {
                return findWithCachePolicyAsync(cachePolicy, user);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        });
    }

    public void findInBackground(FindCallback findcallback)
    {
        final ParseUser user = ParseUser.getCurrentUser();
        queryStart = System.nanoTime();
        doInBackground(new CallableWithCachePolicy() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task call(CachePolicy cachepolicy)
            {
                return findWithCachePolicyAsync(cachepolicy, user);
            }

            public volatile Object call(CachePolicy cachepolicy)
            {
                return call(cachepolicy);
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        }, findcallback);
    }

    Task findWithCachePolicyAsync(CachePolicy cachepolicy, final ParseUser user)
    {
        return runCommandWithPolicyAsync(new CommandDelegate() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task runFromCacheAsync()
            {
                return findFromCacheAsync(user, false, ignoreACLs);
            }

            public Task runOnNetworkAsync(boolean flag)
            {
                return findFromNetworkAsync(flag);
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        }, cachepolicy);
    }

    public ParseQuery fromLocalDatastore()
    {
        return fromLocalDatastore(null, false);
    }

    ParseQuery fromLocalDatastore(boolean flag)
    {
        return fromLocalDatastore(null, flag);
    }

    ParseQuery fromNetwork()
    {
        checkPinningEnabled(true);
        checkIfRunning();
        cachePolicy = CachePolicy.NETWORK_ONLY;
        pinName = null;
        ignoreACLs = false;
        return this;
    }

    public ParseQuery fromPin()
    {
        return fromLocalDatastore("_default", false);
    }

    public ParseQuery fromPin(String s)
    {
        return fromLocalDatastore(s, false);
    }

    ParseQuery fromPin(String s, boolean flag)
    {
        return fromLocalDatastore(s, flag);
    }

    ParseQuery fromPin(boolean flag)
    {
        return fromLocalDatastore("_default", flag);
    }

    public ParseObject get(String s)
        throws ParseException
    {
        return (ParseObject)Parse.waitForTask(getInBackground(s));
    }

    public CachePolicy getCachePolicy()
    {
        checkPinningEnabled(false);
        return cachePolicy;
    }

    public String getClassName()
    {
        return className;
    }

    QueryConstraints getConstraints()
    {
        return where;
    }

    public ParseObject getFirst()
        throws ParseException
    {
        return (ParseObject)Parse.waitForTask(getFirstInBackground());
    }

    public Task getFirstInBackground()
    {
        final ParseUser user = ParseUser.getCurrentUser();
        queryStart = System.nanoTime();
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task call()
                throws Exception
            {
                return getFirstWithCachePolicyAsync(cachePolicy, user);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        });
    }

    public void getFirstInBackground(GetCallback getcallback)
    {
        doInBackground(new CallableWithCachePolicy() {

            final ParseQuery this$0;
            final ParseUser val$user;

            public Task call(CachePolicy cachepolicy)
            {
                return getFirstWithCachePolicyAsync(cachepolicy, user);
            }

            public volatile Object call(CachePolicy cachepolicy)
            {
                return call(cachepolicy);
            }

            
            {
                this$0 = ParseQuery.this;
                user = parseuser;
                super();
            }
        }, getcallback);
    }

    public Task getInBackground(final String objectId)
    {
        final ParseUser user = ParseUser.getCurrentUser();
        queryStart = System.nanoTime();
        return doWithRunningCheck(new Callable() {

            final ParseQuery this$0;
            final String val$objectId;
            final ParseUser val$user;

            public Task call()
                throws Exception
            {
                return getWithCachePolicyAsync(objectId, cachePolicy, user);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseQuery.this;
                objectId = s;
                user = parseuser;
                super();
            }
        });
    }

    public void getInBackground(final String objectId, GetCallback getcallback)
    {
        doInBackground(new CallableWithCachePolicy() {

            final ParseQuery this$0;
            final String val$objectId;
            final ParseUser val$user;

            public Task call(CachePolicy cachepolicy)
            {
                return getWithCachePolicyAsync(objectId, cachepolicy, user);
            }

            public volatile Object call(CachePolicy cachepolicy)
            {
                return call(cachepolicy);
            }

            
            {
                this$0 = ParseQuery.this;
                objectId = s;
                user = parseuser;
                super();
            }
        }, getcallback);
    }

    List getIncludes()
    {
        return Collections.unmodifiableList(include);
    }

    public int getLimit()
    {
        return limit;
    }

    public long getMaxCacheAge()
    {
        checkPinningEnabled(false);
        return maxCacheAge;
    }

    public int getSkip()
    {
        return skip;
    }

    public boolean hasCachedResult()
    {
        boolean flag = false;
        checkPinningEnabled(false);
        if (Parse.loadFromKeyValueCache(makeFindCommand(ParseUser.getCurrentSessionToken()).getCacheKey(), maxCacheAge) != null)
        {
            flag = true;
        }
        return flag;
    }

    public void include(String s)
    {
        checkIfRunning();
        include.add(s);
    }

    boolean isFromLocalDatastore()
    {
        checkPinningEnabled(true);
        return cachePolicy == CachePolicy.CACHE_ONLY;
    }

    boolean isFromNetwork()
    {
        checkPinningEnabled(true);
        return cachePolicy == CachePolicy.NETWORK_ONLY;
    }

    public ParseQuery orderByAscending(String s)
    {
        checkIfRunning();
        order = s;
        return this;
    }

    public ParseQuery orderByDescending(String s)
    {
        checkIfRunning();
        order = (new StringBuilder()).append("-").append(s).toString();
        return this;
    }

    ParseQuery redirectClassNameForKey(String s)
    {
        extraOptions.put("redirectClassNameForKey", s);
        return this;
    }

    public void selectKeys(Collection collection)
    {
        checkIfRunning();
        if (selectedKeys == null)
        {
            selectedKeys = new ArrayList();
        }
        selectedKeys.addAll(collection);
    }

    public void setCachePolicy(CachePolicy cachepolicy)
    {
        checkPinningEnabled(false);
        checkIfRunning();
        cachePolicy = cachepolicy;
    }

    public ParseQuery setLimit(int i)
    {
        checkIfRunning();
        limit = i;
        return this;
    }

    public void setMaxCacheAge(long l)
    {
        checkPinningEnabled(false);
        maxCacheAge = l;
    }

    public ParseQuery setSkip(int i)
    {
        checkIfRunning();
        skip = i;
        return this;
    }

    public void setTrace(boolean flag)
    {
        trace = flag;
    }

    String[] sortKeys()
    {
        if (order == null)
        {
            return new String[0];
        } else
        {
            return order.split(",");
        }
    }

    JSONObject toREST()
    {
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("className", className);
            ((JSONObject) (obj)).put("where", Parse.encode(where, PointerEncodingStrategy.get()));
            if (limit >= 0)
            {
                ((JSONObject) (obj)).put("limit", limit);
            }
            if (skip > 0)
            {
                ((JSONObject) (obj)).put("skip", skip);
            }
            if (order != null)
            {
                ((JSONObject) (obj)).put("order", order);
            }
            if (!include.isEmpty())
            {
                ((JSONObject) (obj)).put("include", Parse.join(",", include));
            }
            if (selectedKeys != null)
            {
                ((JSONObject) (obj)).put("fields", Parse.join(",", selectedKeys));
            }
            if (trace)
            {
                ((JSONObject) (obj)).put("trace", "1");
            }
            String s;
            for (Iterator iterator = extraOptions.keySet().iterator(); iterator.hasNext(); ((JSONObject) (obj)).put(s, Parse.encode(extraOptions.get(s), PointerEncodingStrategy.get())))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return ((JSONObject) (obj));
    }

    public ParseQuery whereContainedIn(String s, Collection collection)
    {
        addCondition(s, "$in", new ArrayList(collection));
        return this;
    }

    public ParseQuery whereContains(String s, String s1)
    {
        whereMatches(s, Pattern.quote(s1));
        return this;
    }

    public ParseQuery whereContainsAll(String s, Collection collection)
    {
        addCondition(s, "$all", new ArrayList(collection));
        return this;
    }

    public ParseQuery whereDoesNotExist(String s)
    {
        addCondition(s, "$exists", Boolean.valueOf(false));
        return this;
    }

    public ParseQuery whereDoesNotMatchKeyInQuery(String s, String s1, ParseQuery parsequery)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("key", s1);
            jsonobject.put("query", parsequery);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        addCondition(s, "$dontSelect", jsonobject);
        return this;
    }

    public ParseQuery whereDoesNotMatchQuery(String s, ParseQuery parsequery)
    {
        addCondition(s, "$notInQuery", parsequery);
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
        where.put(s, obj);
        return this;
    }

    public ParseQuery whereExists(String s)
    {
        addCondition(s, "$exists", Boolean.valueOf(true));
        return this;
    }

    public ParseQuery whereGreaterThan(String s, Object obj)
    {
        addCondition(s, "$gt", obj);
        return this;
    }

    public ParseQuery whereGreaterThanOrEqualTo(String s, Object obj)
    {
        addCondition(s, "$gte", obj);
        return this;
    }

    public ParseQuery whereLessThan(String s, Object obj)
    {
        addCondition(s, "$lt", obj);
        return this;
    }

    public ParseQuery whereLessThanOrEqualTo(String s, Object obj)
    {
        addCondition(s, "$lte", obj);
        return this;
    }

    public ParseQuery whereMatches(String s, String s1)
    {
        addCondition(s, "$regex", s1);
        return this;
    }

    public ParseQuery whereMatches(String s, String s1, String s2)
    {
        addCondition(s, "$regex", s1);
        if (s2.length() != 0)
        {
            addCondition(s, "$options", s2);
        }
        return this;
    }

    public ParseQuery whereMatchesKeyInQuery(String s, String s1, ParseQuery parsequery)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("key", s1);
            jsonobject.put("query", parsequery);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        addCondition(s, "$select", jsonobject);
        return this;
    }

    public ParseQuery whereMatchesQuery(String s, ParseQuery parsequery)
    {
        addCondition(s, "$inQuery", parsequery);
        return this;
    }

    public ParseQuery whereNear(String s, ParseGeoPoint parsegeopoint)
    {
        addCondition(s, "$nearSphere", parsegeopoint);
        return this;
    }

    public ParseQuery whereNotContainedIn(String s, Collection collection)
    {
        addCondition(s, "$nin", new ArrayList(collection));
        return this;
    }

    public ParseQuery whereNotEqualTo(String s, Object obj)
    {
        addCondition(s, "$ne", obj);
        return this;
    }

    ParseQuery whereRelatedTo(ParseObject parseobject, String s)
    {
        where.put("$relatedTo", new RelationConstraint(s, parseobject));
        return this;
    }

    public ParseQuery whereStartsWith(String s, String s1)
    {
        whereMatches(s, (new StringBuilder()).append("^").append(Pattern.quote(s1)).toString());
        return this;
    }

    public ParseQuery whereWithinGeoBox(String s, ParseGeoPoint parsegeopoint, ParseGeoPoint parsegeopoint1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(parsegeopoint);
        arraylist.add(parsegeopoint1);
        parsegeopoint = new HashMap();
        parsegeopoint.put("$box", arraylist);
        addCondition(s, "$within", parsegeopoint);
        return this;
    }

    public ParseQuery whereWithinKilometers(String s, ParseGeoPoint parsegeopoint, double d)
    {
        whereWithinRadians(s, parsegeopoint, d / ParseGeoPoint.EARTH_MEAN_RADIUS_KM);
        return this;
    }

    public ParseQuery whereWithinMiles(String s, ParseGeoPoint parsegeopoint, double d)
    {
        whereWithinRadians(s, parsegeopoint, d / ParseGeoPoint.EARTH_MEAN_RADIUS_MILE);
        return this;
    }

    public ParseQuery whereWithinRadians(String s, ParseGeoPoint parsegeopoint, double d)
    {
        addCondition(s, "$nearSphere", parsegeopoint);
        addCondition(s, "$maxDistance", Double.valueOf(d));
        return this;
    }







/*
    static boolean access$1302(ParseQuery parsequery, boolean flag)
    {
        parsequery.isRunning = flag;
        return flag;
    }

*/








/*
    static ParseCommand access$402(ParseQuery parsequery, ParseCommand parsecommand)
    {
        parsequery.currentCommand = parsecommand;
        return parsecommand;
    }

*/



/*
    static long access$602(ParseQuery parsequery, long l)
    {
        parsequery.querySent = l;
        return l;
    }

*/


/*
    static long access$702(ParseQuery parsequery, long l)
    {
        parsequery.queryReceived = l;
        return l;
    }

*/


}
