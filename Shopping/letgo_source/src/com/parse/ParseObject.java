// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            TaskQueue, ParseMulticastDelegate, ParseOperationSet, Parse, 
//            OfflineStore, ParseJSONCacheItem, ParseFieldOperation, ParseTraverser, 
//            ParseSetOperation, ParseException, ParseRESTObjectCommand, ParseUser, 
//            ParseFile, ParseTaskUtils, LockSet, ParseQuery, 
//            ParseDecoder, ParseTextUtils, ParseACL, ParseClassName, 
//            ParseFileUtils, ParseCorePlugins, LocalIdManager, ParseRole, 
//            ParseInstallation, ParseSession, ParsePin, EventuallyPin, 
//            ParseAddOperation, ParseAddUniqueOperation, ParseDateFormat, ParseObjectController, 
//            ParseRESTCommand, ParseEventuallyQueue, ParseRelation, PointerOrLocalIdEncoder, 
//            ParseGeoPoint, KnownParseObjectDecoder, ParseIncrementOperation, ParseImpreciseDateFormat, 
//            ParseJSONUtils, ParseEncoder, ParseDeleteOperation, ParseRemoveOperation, 
//            PointerEncoder, DeleteCallback, FindCallback, SaveCallback, 
//            GetCallback, RefreshCallback

public class ParseObject
{
    static class State
    {

        private final String className;
        private final long createdAt;
        private final boolean isComplete;
        private final String objectId;
        private final Map serverData;
        private final long updatedAt;

        public String className()
        {
            return className;
        }

        public long createdAt()
        {
            return createdAt;
        }

        public Object get(String s)
        {
            return serverData.get(s);
        }

        public boolean isComplete()
        {
            return isComplete;
        }

        public Set keySet()
        {
            return serverData.keySet();
        }

        public Init newBuilder()
        {
            return new Builder(this);
        }

        public String objectId()
        {
            return objectId;
        }

        public String toString()
        {
            return String.format(Locale.US, "%s@%s[className=%s, objectId=%s, createdAt=%d, updatedAt=%d, isComplete=%s, serverData=%s]", new Object[] {
                getClass().getName(), Integer.toHexString(hashCode()), className, objectId, Long.valueOf(createdAt), Long.valueOf(updatedAt), Boolean.valueOf(isComplete), serverData
            });
        }

        public long updatedAt()
        {
            return updatedAt;
        }

        State(Init init)
        {
            className = init.className;
            objectId = init.objectId;
            createdAt = init.createdAt;
            long l;
            if (init.updatedAt > 0L)
            {
                l = init.updatedAt;
            } else
            {
                l = createdAt;
            }
            updatedAt = l;
            serverData = Collections.unmodifiableMap(new HashMap(init.serverData));
            isComplete = init.isComplete;
        }
    }

    static class State.Builder extends State.Init
    {

        public State build()
        {
            return new State(this);
        }

        State.Builder self()
        {
            return this;
        }

        volatile State.Init self()
        {
            return self();
        }

        public State.Builder(State state1)
        {
            super(state1);
        }

        public State.Builder(String s)
        {
            super(s);
        }
    }

    static abstract class State.Init
    {

        private final String className;
        private long createdAt;
        private boolean isComplete;
        private String objectId;
        Map serverData;
        private long updatedAt;

        public State.Init apply(State state1)
        {
            if (state1.objectId() != null)
            {
                objectId(state1.objectId());
            }
            if (state1.createdAt() > 0L)
            {
                createdAt(state1.createdAt());
            }
            if (state1.updatedAt() > 0L)
            {
                updatedAt(state1.updatedAt());
            }
            boolean flag;
            if (isComplete || state1.isComplete())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isComplete(flag);
            String s;
            for (Iterator iterator = state1.keySet().iterator(); iterator.hasNext(); put(s, state1.get(s)))
            {
                s = (String)iterator.next();
            }

            return self();
        }

        public State.Init apply(ParseOperationSet parseoperationset)
        {
            for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Object obj = ((ParseFieldOperation)parseoperationset.get(s)).apply(serverData.get(s), s);
                if (obj != null)
                {
                    put(s, obj);
                } else
                {
                    remove(s);
                }
            }

            return self();
        }

        abstract State build();

        public State.Init clear()
        {
            objectId = null;
            createdAt = -1L;
            updatedAt = -1L;
            isComplete = false;
            serverData.clear();
            return self();
        }

        public State.Init createdAt(long l)
        {
            createdAt = l;
            return self();
        }

        public State.Init createdAt(Date date)
        {
            createdAt = date.getTime();
            return self();
        }

        public State.Init isComplete(boolean flag)
        {
            isComplete = flag;
            return self();
        }

        public State.Init objectId(String s)
        {
            objectId = s;
            return self();
        }

        public State.Init put(String s, Object obj)
        {
            serverData.put(s, obj);
            return self();
        }

        public State.Init remove(String s)
        {
            serverData.remove(s);
            return self();
        }

        abstract State.Init self();

        public State.Init updatedAt(long l)
        {
            updatedAt = l;
            return self();
        }

        public State.Init updatedAt(Date date)
        {
            updatedAt = date.getTime();
            return self();
        }






        State.Init(State state1)
        {
            createdAt = -1L;
            updatedAt = -1L;
            serverData = new HashMap();
            className = state1.className();
            objectId = state1.objectId();
            createdAt = state1.createdAt();
            updatedAt = state1.updatedAt();
            String s;
            for (Iterator iterator = state1.keySet().iterator(); iterator.hasNext(); serverData.put(s, state1.get(s)))
            {
                s = (String)iterator.next();
            }

            isComplete = state1.isComplete();
        }

        public State.Init(String s)
        {
            createdAt = -1L;
            updatedAt = -1L;
            serverData = new HashMap();
            className = s;
        }
    }


    private static final String AUTO_CLASS_NAME = "_Automatic";
    public static final String DEFAULT_PIN = "_default";
    private static final String KEY_ACL = "ACL";
    private static final String KEY_CLASS_NAME = "className";
    private static final String KEY_COMPLETE = "__complete";
    private static final String KEY_CREATED_AT = "createdAt";
    static final String KEY_IS_DELETING_EVENTUALLY = "__isDeletingEventually";
    private static final String KEY_IS_DELETING_EVENTUALLY_OLD = "isDeletingEventually";
    private static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_OPERATIONS = "__operations";
    private static final String KEY_UPDATED_AT = "updatedAt";
    private static final String NEW_OFFLINE_OBJECT_ID_PLACEHOLDER = "*** Offline Object ***";
    static final String VERSION_NAME = "1.9.4";
    private static final Map classNames = new ConcurrentHashMap();
    private static final ThreadLocal isCreatingPointerForObjectId = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected String initialValue()
        {
            return null;
        }

    };
    private static final Map objectTypes = new ConcurrentHashMap();
    static String server = "https://api.parse.com";
    private final Map dataAvailability;
    private final Map estimatedData;
    private final Map hashedObjects;
    boolean isDeleted;
    int isDeletingEventually;
    private String localId;
    final Object mutex;
    final LinkedList operationSetQueue;
    private final ParseMulticastDelegate saveEvent;
    private State state;
    final TaskQueue taskQueue;

    protected ParseObject()
    {
        this("_Automatic");
    }

    public ParseObject(String s)
    {
        mutex = new Object();
        taskQueue = new TaskQueue();
        saveEvent = new ParseMulticastDelegate();
        String s2 = (String)isCreatingPointerForObjectId.get();
        if (s == null)
        {
            throw new IllegalArgumentException("You must specify a Parse class name when creating a new ParseObject.");
        }
        String s1 = s;
        if ("_Automatic".equals(s))
        {
            s1 = getClassName(getClass());
        }
        if (getClass().equals(com/parse/ParseObject) && objectTypes.containsKey(s1) && !((Class)objectTypes.get(s1)).isInstance(this))
        {
            throw new IllegalArgumentException("You must create this type of ParseObject using ParseObject.create() or the proper subclass.");
        }
        if (!getClass().equals(com/parse/ParseObject) && !getClass().equals(objectTypes.get(s1)))
        {
            throw new IllegalArgumentException("You must register this ParseObject subclass before instantiating it.");
        }
        operationSetQueue = new LinkedList();
        operationSetQueue.add(new ParseOperationSet());
        estimatedData = new HashMap();
        hashedObjects = new IdentityHashMap();
        dataAvailability = new HashMap();
        s = newStateBuilder(s1);
        if (s2 == null)
        {
            setDefaultValues();
            s.isComplete(true);
        } else
        {
            if (!s2.equals("*** Offline Object ***"))
            {
                s.objectId(s2);
            }
            s.isComplete(false);
        }
        state = s.build();
        s = Parse.getLocalDatastore();
        if (s != null)
        {
            s.registerNewObject(this);
        }
    }

    private void addToHashedObjects(Object obj)
    {
        obj1;
        JVM INSTR monitorenter ;
        synchronized (mutex)
        {
            hashedObjects.put(obj, new ParseJSONCacheItem(obj));
        }
        return;
        obj;
        throw new IllegalArgumentException("Couldn't serialize container value to JSON.");
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private void applyOperations(ParseOperationSet parseoperationset, Map map)
    {
        for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj = ((ParseFieldOperation)parseoperationset.get(s)).apply(map.get(s), s);
            if (obj != null)
            {
                map.put(s, obj);
            } else
            {
                map.remove(s);
            }
        }

    }

    private boolean canBeSerialized()
    {
        boolean flag;
        synchronized (mutex)
        {
            final cs result = new cs(Boolean.valueOf(true));
            (new ParseTraverser() {

                final ParseObject this$0;
                final cs val$result;

                protected boolean visit(Object obj1)
                {
                    if ((obj1 instanceof ParseFile) && ((ParseFile)obj1).isDirty())
                    {
                        result.a(Boolean.valueOf(false));
                    }
                    if ((obj1 instanceof ParseObject) && ((ParseObject)obj1).getObjectId() == null)
                    {
                        result.a(Boolean.valueOf(false));
                    }
                    return ((Boolean)result.a()).booleanValue();
                }

            
            {
                this$0 = ParseObject.this;
                result = cs1;
                super();
            }
            }).setYieldRoot(false).setTraverseParseObjects(true).traverse(this);
            flag = ((Boolean)result.a()).booleanValue();
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void checkForChangesToMutableContainer(String s, Object obj)
    {
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        ParseJSONCacheItem parsejsoncacheitem;
        if (!isContainerObject(s, obj))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        parsejsoncacheitem = (ParseJSONCacheItem)hashedObjects.get(obj);
        if (parsejsoncacheitem != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        throw new IllegalArgumentException("ParseObject contains container item that isn't cached.");
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
        ParseJSONCacheItem parsejsoncacheitem1 = new ParseJSONCacheItem(obj);
        if (!parsejsoncacheitem.equals(parsejsoncacheitem1))
        {
            performOperation(s, new ParseSetOperation(obj));
        }
_L1:
        obj1;
        JVM INSTR monitorexit ;
        return;
        s;
        throw new RuntimeException(s);
        hashedObjects.remove(obj);
          goto _L1
    }

    private void checkGetAccess(String s)
    {
        if (!isDataAvailable(s))
        {
            throw new IllegalStateException((new StringBuilder()).append("ParseObject has no data for '").append(s).append("'. Call fetchIfNeeded() to get the data.").toString());
        } else
        {
            return;
        }
    }

    private void checkKeyIsMutable(String s)
    {
        if (!isKeyMutable(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot modify `").append(s).append("` property of an ").append(getClassName()).append(" object.").toString());
        } else
        {
            return;
        }
    }

    private void checkpointAllMutableContainers()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = estimatedData.entrySet().iterator(); iterator.hasNext(); checkpointMutableContainer((String)entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_68;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    private void checkpointMutableContainer(String s, Object obj)
    {
        synchronized (mutex)
        {
            if (isContainerObject(s, obj))
            {
                addToHashedObjects(obj);
            }
        }
        return;
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static void collectDirtyChildren(Object obj, Collection collection, Collection collection1)
    {
        collectDirtyChildren(obj, collection, collection1, ((Set) (new HashSet())), ((Set) (new HashSet())));
    }

    private static void collectDirtyChildren(Object obj, Collection collection, Collection collection1, Set set, Set set1)
    {
        (new ParseTraverser(collection1, collection, set, set1) {

            final Set val$alreadySeen;
            final Set val$alreadySeenNew;
            final Collection val$dirtyChildren;
            final Collection val$dirtyFiles;

            protected boolean visit(Object obj1)
            {
                if (!(obj1 instanceof ParseFile)) goto _L2; else goto _L1
_L1:
                if (dirtyFiles != null) goto _L4; else goto _L3
_L3:
                return true;
_L4:
                if (((ParseFile) (obj1 = (ParseFile)obj1)).getUrl() == null)
                {
                    dirtyFiles.add(obj1);
                    return true;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if ((obj1 instanceof ParseObject) && dirtyChildren != null)
                {
                    ParseObject parseobject = (ParseObject)obj1;
                    Object obj2 = alreadySeen;
                    obj1 = alreadySeenNew;
                    if (parseobject.getObjectId() != null)
                    {
                        obj1 = new HashSet();
                    } else
                    {
                        if (((Set) (obj1)).contains(parseobject))
                        {
                            throw new RuntimeException("Found a circular dependency while saving.");
                        }
                        obj1 = new HashSet(((Collection) (obj1)));
                        ((Set) (obj1)).add(parseobject);
                    }
                    if (!((Set) (obj2)).contains(parseobject))
                    {
                        obj2 = new HashSet(((Collection) (obj2)));
                        ((Set) (obj2)).add(parseobject);
                        ParseObject.collectDirtyChildren(parseobject.estimatedData, dirtyChildren, dirtyFiles, ((Set) (obj2)), ((Set) (obj1)));
                        if (parseobject.isDirty(false))
                        {
                            dirtyChildren.add(parseobject);
                            return true;
                        }
                    }
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                dirtyFiles = collection;
                dirtyChildren = collection1;
                alreadySeen = set;
                alreadySeenNew = set1;
                super();
            }
        }).setYieldRoot(true).traverse(obj);
    }

    private Map collectFetchedObjects()
    {
        final HashMap fetchedObjects = new HashMap();
        (new ParseTraverser() {

            final ParseObject this$0;
            final Map val$fetchedObjects;

            protected boolean visit(Object obj)
            {
                if (obj instanceof ParseObject)
                {
                    obj = (ParseObject)obj;
                    State state1 = ((ParseObject) (obj)).getState();
                    if (state1.objectId() != null && state1.isComplete())
                    {
                        fetchedObjects.put(state1.objectId(), obj);
                    }
                }
                return true;
            }

            
            {
                this$0 = ParseObject.this;
                fetchedObjects = map;
                super();
            }
        }).traverse(estimatedData);
        return fetchedObjects;
    }

    public static ParseObject create(Class class1)
    {
        return create(getClassName(class1));
    }

    public static ParseObject create(String s)
    {
        if (objectTypes.containsKey(s))
        {
            try
            {
                s = (ParseObject)((Class)objectTypes.get(s)).newInstance();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (s instanceof RuntimeException)
                {
                    throw (RuntimeException)s;
                } else
                {
                    throw new RuntimeException("Failed to create instance of subclass.", s);
                }
            }
            return s;
        } else
        {
            return new ParseObject(s);
        }
    }

    public static ParseObject createWithoutData(Class class1, String s)
    {
        return createWithoutData(getClassName(class1), s);
    }

    public static ParseObject createWithoutData(String s, String s1)
    {
        Object obj = Parse.getLocalDatastore();
        if (s1 != null) goto _L2; else goto _L1
_L1:
        isCreatingPointerForObjectId.set("*** Offline Object ***");
_L5:
        if (obj == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        s1 = ((OfflineStore) (obj)).getObject(s, s1);
_L6:
        obj = s1;
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s = create(s);
        obj = s;
        if (s.hasChanges())
        {
            throw new IllegalStateException("A ParseObject subclass default constructor must not make changes to the object that cause it to be dirty.");
        }
          goto _L4
        s;
        throw s;
        s;
        isCreatingPointerForObjectId.set(null);
        throw s;
_L2:
        isCreatingPointerForObjectId.set(s1);
          goto _L5
        s;
        throw new RuntimeException("Failed to create instance of subclass.", s);
_L4:
        isCreatingPointerForObjectId.set(null);
        return ((ParseObject) (obj));
        s1 = null;
          goto _L6
    }

    private ParseOperationSet currentOperations()
    {
        ParseOperationSet parseoperationset;
        synchronized (mutex)
        {
            parseoperationset = (ParseOperationSet)operationSetQueue.getLast();
        }
        return parseoperationset;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ParseRESTObjectCommand currentSaveCommand(ParseOperationSet parseoperationset, ParseEncoder parseencoder, String s)
        throws ParseException
    {
        State state1 = getState();
        parseoperationset = ParseRESTObjectCommand.saveObjectCommand(state1, toJSONObjectForSaving(state1, parseoperationset, parseencoder), s);
        parseoperationset.enableRetrying();
        return parseoperationset;
    }

    private static cu deepSaveAsync(Object obj, String s)
    {
        Object obj1 = new HashSet();
        Object obj3 = new HashSet();
        collectDirtyChildren(obj, ((Collection) (obj1)), ((Collection) (obj3)));
        Object obj2 = new HashSet();
        obj = ((Set) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            ParseObject parseobject = (ParseObject)((Iterator) (obj)).next();
            if ((parseobject instanceof ParseUser) && ((ParseUser)parseobject).isLazy())
            {
                ((Set) (obj2)).add((ParseUser)parseobject);
            }
        } while (true);
        ((Set) (obj1)).removeAll(((Collection) (obj2)));
        obj = new AtomicBoolean(false);
        Object obj4 = new ArrayList();
        for (obj3 = ((Set) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((List) (obj4)).add(((ParseFile)((Iterator) (obj3)).next()).saveAsync(s, null, null))) { }
        obj3 = cu.a(((Collection) (obj4))).a(new ct(((AtomicBoolean) (obj))) {

            final AtomicBoolean val$filesComplete;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                filesComplete.set(true);
                return null;
            }

            
            {
                filesComplete = atomicboolean;
                super();
            }
        });
        obj4 = new AtomicBoolean(false);
        ArrayList arraylist = new ArrayList();
        for (obj2 = ((Set) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(((ParseUser)((Iterator) (obj2)).next()).saveAsync(s))) { }
        obj2 = cu.a(arraylist).a(new ct(((AtomicBoolean) (obj4))) {

            final AtomicBoolean val$usersComplete;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                usersComplete.set(true);
                return null;
            }

            
            {
                usersComplete = atomicboolean;
                super();
            }
        });
        obj1 = new cs(obj1);
        return cu.a(Arrays.asList(new cu[] {
            obj3, obj2, cu.a(null).a(new Callable(((cs) (obj1))) {

                final cs val$remaining;

                public Boolean call()
                    throws Exception
                {
                    boolean flag;
                    if (((Set)remaining.a()).size() > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    return Boolean.valueOf(flag);
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                remaining = cs1;
                super();
            }
            }, new ct(((cs) (obj1)), ((AtomicBoolean) (obj)), ((AtomicBoolean) (obj4)), s) {

                final AtomicBoolean val$filesComplete;
                final cs val$remaining;
                final String val$sessionToken;
                final AtomicBoolean val$usersComplete;

                public cu then(cu cu1)
                    throws Exception
                {
                    cu1 = new ArrayList();
                    HashSet hashset = new HashSet();
                    for (Iterator iterator = ((Set)remaining.a()).iterator(); iterator.hasNext();)
                    {
                        ParseObject parseobject1 = (ParseObject)iterator.next();
                        if (parseobject1.canBeSerialized())
                        {
                            cu1.add(parseobject1);
                        } else
                        {
                            hashset.add(parseobject1);
                        }
                    }

                    remaining.a(hashset);
                    if (cu1.size() == 0 && filesComplete.get() && usersComplete.get())
                    {
                        throw new RuntimeException("Unable to save a ParseObject with a relation to a cycle.");
                    }
                    if (cu1.size() == 0)
                    {
                        return cu.a(null);
                    } else
                    {
                        return ParseObject.enqueueForAll(cu1, cu1. new ct() {

                            final _cls41 this$0;
                            final List val$current;

                            public cu then(cu cu1)
                                throws Exception
                            {
                                return ParseObject.saveAllAsync(current, sessionToken, cu1);
                            }

                            public volatile Object then(cu cu1)
                                throws Exception
                            {
                                return then(cu1);
                            }

            
            {
                this$0 = final__pcls41;
                current = List.this;
                super();
            }
                        });
                    }
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                remaining = cs1;
                filesComplete = atomicboolean;
                usersComplete = atomicboolean1;
                sessionToken = s;
                super();
            }
            })
        }));
    }

    public static void deleteAll(List list)
        throws ParseException
    {
        ParseTaskUtils.wait(deleteAllInBackground(list));
    }

    private static cu deleteAllAsync(List list, String s)
    {
        if (list.size() == 0)
        {
            return cu.a(null);
        }
        int j = list.size();
        ArrayList arraylist = new ArrayList(j);
        HashSet hashset = new HashSet();
        for (int i = 0; i < j; i++)
        {
            ParseObject parseobject = (ParseObject)list.get(i);
            if (!hashset.contains(parseobject.getObjectId()))
            {
                hashset.add(parseobject.getObjectId());
                arraylist.add(parseobject);
            }
        }

        return enqueueForAll(arraylist, new ct(arraylist, s) {

            final String val$sessionToken;
            final List val$uniqueObjects;

            public cu then(cu cu1)
                throws Exception
            {
                return ParseObject.deleteAllAsync(uniqueObjects, sessionToken, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                uniqueObjects = list;
                sessionToken = s;
                super();
            }
        });
    }

    private static cu deleteAllAsync(List list, String s, cu cu1)
    {
        return cu1.b(new ct(list, s) {

            final String val$sessionToken;
            final List val$uniqueObjects;

            public cu then(cu cu2)
                throws Exception
            {
                int k = uniqueObjects.size();
                cu2 = new ArrayList(k);
                for (int i = 0; i < k; i++)
                {
                    ParseObject parseobject = (ParseObject)uniqueObjects.get(i);
                    parseobject.validateDelete();
                    cu2.add(parseobject.getState());
                }

                cu2 = ParseObject.getObjectController().deleteAllAsync(cu2, sessionToken);
                ArrayList arraylist = new ArrayList(k);
                for (int j = 0; j < k; j++)
                {
                    arraylist.add(((cu)cu2.get(j)).d(((ParseObject)uniqueObjects.get(j)). new ct() {

                        final _cls34 this$0;
                        final ParseObject val$object;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            return object.handleDeleteResultAsync().b(cu1. new ct() {

                                final _cls1 this$1;
                                final cu val$batchTask;

                                public cu then(cu cu1)
                                    throws Exception
                                {
                                    return batchTask;
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$1 = final__pcls1;
                batchTask = cu.this;
                super();
            }
                            });
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = final__pcls34;
                object = ParseObject.this;
                super();
            }
                    }));
                }

                return cu.a(arraylist);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                uniqueObjects = list;
                sessionToken = s;
                super();
            }
        });
    }

    public static cu deleteAllInBackground(List list)
    {
        return ParseUser.getCurrentSessionTokenAsync().d(new ct(list) {

            final List val$objects;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return ParseObject.deleteAllAsync(objects, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                objects = list;
                super();
            }
        });
    }

    public static void deleteAllInBackground(List list, DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(deleteAllInBackground(list), deletecallback);
    }

    private cu deleteAsync(final String sessionToken, cu cu1)
    {
        validateDelete();
        return cu1.d(new ct() {

            final ParseObject this$0;
            final String val$sessionToken;

            public cu then(cu cu2)
                throws Exception
            {
                if (state.objectId() == null)
                {
                    return cu2.i();
                } else
                {
                    return deleteAsync(sessionToken);
                }
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseObject.this;
                sessionToken = s;
                super();
            }
        }).d(new ct() {

            final ParseObject this$0;

            public cu then(cu cu2)
                throws Exception
            {
                return handleDeleteResultAsync();
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    static cu enqueueForAll(List list, ct ct1)
    {
        Object obj;
        android.support.v7.cu.a a;
        a = cu.a();
        obj = new ArrayList(list.size());
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).add(((ParseObject)iterator.next()).taskQueue.getLock())) { }
        obj = new LockSet(((Collection) (obj)));
        ((LockSet) (obj)).lock();
        ct1 = (cu)ct1.then(a.a());
        ArrayList arraylist;
        arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); ((ParseObject)list.next()).taskQueue.enqueue(new ct(arraylist, ct1) {

        final List val$childTasks;
        final cu val$fullTask;

        public cu then(cu cu1)
            throws Exception
        {
            childTasks.add(cu1);
            return fullTask;
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                childTasks = list;
                fullTask = cu1;
                super();
            }
    })) { }
        break MISSING_BLOCK_LABEL_163;
        list;
        ((LockSet) (obj)).unlock();
        throw list;
        list;
        throw list;
        list;
        throw new RuntimeException(list);
        cu.a(arraylist).a(new ct(a) {

            final android.support.v7.cu.a val$readyToStart;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                readyToStart.b(null);
                return null;
            }

            
            {
                readyToStart = a;
                super();
            }
        });
        ((LockSet) (obj)).unlock();
        return ct1;
    }

    private cu enqueueSaveEventuallyOperationAsync(final ParseOperationSet operationSet)
    {
        if (!operationSet.isSaveEventually())
        {
            throw new IllegalStateException("This should only be used to enqueue saveEventually operation sets");
        } else
        {
            return taskQueue.enqueue(new ct() {

                final ParseObject this$0;
                final ParseOperationSet val$operationSet;

                public cu then(cu cu1)
                    throws Exception
                {
                    return cu1.b(new ct() {

                        final _cls16 this$1;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).j();
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseObject.this;
                operationSet = parseoperationset;
                super();
            }
            });
        }
    }

    public static List fetchAll(List list)
        throws ParseException
    {
        return (List)ParseTaskUtils.wait(fetchAllInBackground(list));
    }

    private static cu fetchAllAsync(List list, ParseUser parseuser, boolean flag, cu cu1)
    {
        String s;
        ArrayList arraylist;
label0:
        {
            if (list.size() == 0)
            {
                return cu.a(list);
            }
            arraylist = new ArrayList();
            Iterator iterator = list.iterator();
            s = null;
label1:
            do
            {
                while (iterator.hasNext()) 
                {
                    ParseObject parseobject = (ParseObject)iterator.next();
                    if (!flag || !parseobject.isDataAvailable())
                    {
                        if (s != null && !parseobject.getClassName().equals(s))
                        {
                            throw new IllegalArgumentException("All objects should have the same class");
                        }
                        s = parseobject.getClassName();
                        if (parseobject.getObjectId() == null)
                        {
                            continue label1;
                        }
                        arraylist.add(parseobject.getObjectId());
                    }
                }
                break label0;
            } while (flag);
            throw new IllegalArgumentException("All objects must exist on the server");
        }
        if (arraylist.size() == 0)
        {
            return cu.a(list);
        } else
        {
            return cu1.b(new ct(ParseQuery.getQuery(s).whereContainedIn("objectId", arraylist), parseuser) {

                final ParseQuery val$query;
                final ParseUser val$user;

                public cu then(cu cu2)
                    throws Exception
                {
                    return query.findAsync(query.getBuilder().build(), user, null);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                query = parsequery;
                user = parseuser;
                super();
            }
            }).c(new ct(list, flag) {

                final List val$objects;
                final boolean val$onlyIfNeeded;

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

                public List then(cu cu2)
                    throws Exception
                {
                    HashMap hashmap = new HashMap();
                    ParseObject parseobject1;
                    for (cu2 = ((List)cu2.e()).iterator(); cu2.hasNext(); hashmap.put(parseobject1.getObjectId(), parseobject1))
                    {
                        parseobject1 = (ParseObject)cu2.next();
                    }

                    cu2 = objects.iterator();
                    do
                    {
                        if (!cu2.hasNext())
                        {
                            break;
                        }
                        ParseObject parseobject2 = (ParseObject)cu2.next();
                        if (!onlyIfNeeded || !parseobject2.isDataAvailable())
                        {
                            ParseObject parseobject3 = (ParseObject)hashmap.get(parseobject2.getObjectId());
                            if (parseobject3 == null)
                            {
                                throw new RuntimeException((new StringBuilder()).append("Object id ").append(parseobject2.getObjectId()).append(" does not exist").toString());
                            }
                            if (!Parse.isLocalDatastoreEnabled())
                            {
                                parseobject2.mergeFromObject(parseobject3);
                            }
                        }
                    } while (true);
                    return objects;
                }

            
            {
                objects = list;
                onlyIfNeeded = flag;
                super();
            }
            });
        }
    }

    private static cu fetchAllAsync(List list, boolean flag)
    {
        return ParseUser.getCurrentUserAsync().d(new ct(list, flag) {

            final List val$objects;
            final boolean val$onlyIfNeeded;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (ParseUser)cu1.e();
                return ParseObject.enqueueForAll(objects, cu1. new ct() {

                    final _cls45 this$0;
                    final ParseUser val$user;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return ParseObject.fetchAllAsync(objects, user, onlyIfNeeded, cu1);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = final__pcls45;
                user = ParseUser.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                objects = list;
                onlyIfNeeded = flag;
                super();
            }
        });
    }

    public static List fetchAllIfNeeded(List list)
        throws ParseException
    {
        return (List)ParseTaskUtils.wait(fetchAllIfNeededInBackground(list));
    }

    public static cu fetchAllIfNeededInBackground(List list)
    {
        return fetchAllAsync(list, true);
    }

    public static void fetchAllIfNeededInBackground(List list, FindCallback findcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchAllIfNeededInBackground(list), findcallback);
    }

    public static cu fetchAllInBackground(List list)
    {
        return fetchAllAsync(list, false);
    }

    public static void fetchAllInBackground(List list, FindCallback findcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchAllInBackground(list), findcallback);
    }

    static ParseObject fromDiskJSON(JSONObject jsonobject)
    {
        Object obj = jsonobject.optString("classname", null);
        if (obj == null)
        {
            return null;
        } else
        {
            obj = createWithoutData(((String) (obj)), jsonobject.optString("objectId", null));
            ((ParseObject) (obj)).setState(((ParseObject) (obj)).mergeFromDiskJSON(((ParseObject) (obj)).getState(), jsonobject));
            return ((ParseObject) (obj));
        }
    }

    static ParseObject fromJSON(JSONObject jsonobject, String s, boolean flag)
    {
        return fromJSON(jsonobject, s, flag, ParseDecoder.get());
    }

    static ParseObject fromJSON(JSONObject jsonobject, String s, boolean flag, ParseDecoder parsedecoder)
    {
        s = jsonobject.optString("className", s);
        if (s == null)
        {
            return null;
        } else
        {
            s = createWithoutData(s, jsonobject.optString("objectId", null));
            s.setState(s.mergeFromServer(s.getState(), jsonobject, parsedecoder, flag));
            return s;
        }
    }

    static ParseObject fromJSONPayload(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        Object obj = jsonobject.optString("className");
        if (obj == null || ParseTextUtils.isEmpty(((CharSequence) (obj))))
        {
            return null;
        } else
        {
            obj = createWithoutData(((String) (obj)), jsonobject.optString("objectId", null));
            ((ParseObject) (obj)).build(jsonobject, parsedecoder);
            return ((ParseObject) (obj));
        }
    }

    private ParseACL getACL(boolean flag)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        checkGetAccess("ACL");
        obj1 = estimatedData.get("ACL");
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
        if (!(obj1 instanceof ParseACL))
        {
            throw new RuntimeException("only ACLs can be stored in the ACL key");
        }
        break MISSING_BLOCK_LABEL_56;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (!((ParseACL)obj1).isShared())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj1 = ((ParseACL)obj1).copy();
        estimatedData.put("ACL", obj1);
        addToHashedObjects(obj1);
        obj;
        JVM INSTR monitorexit ;
        return ((ParseACL) (obj1));
        obj1 = (ParseACL)obj1;
        obj;
        JVM INSTR monitorexit ;
        return ((ParseACL) (obj1));
    }

    static String getClassName(Class class1)
    {
        Object obj;
label0:
        {
            String s = (String)classNames.get(class1);
            obj = s;
            if (s == null)
            {
                obj = (ParseClassName)class1.getAnnotation(com/parse/ParseClassName);
                if (obj != null)
                {
                    break label0;
                }
                obj = null;
            }
            return ((String) (obj));
        }
        obj = ((ParseClassName) (obj)).value();
        classNames.put(class1, obj);
        return ((String) (obj));
    }

    static ParseObject getFromDisk(String s)
    {
        s = ParseFileUtils.readFileToJSONObject(new File(Parse.getParseDir(), s));
        return fromDiskJSON(s);
        s;
_L2:
        return null;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static ParseObjectController getObjectController()
    {
        return ParseCorePlugins.getInstance().getObjectController();
    }

    private boolean hasDirtyChildren()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        collectDirtyChildren(estimatedData, arraylist, null);
        Exception exception;
        boolean flag;
        if (arraylist.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean isAccessible(Member member)
    {
        return Modifier.isPublic(member.getModifiers()) || member.getDeclaringClass().getPackage().getName().equals("com.parse") && !Modifier.isPrivate(member.getModifiers()) && !Modifier.isProtected(member.getModifiers());
    }

    private boolean isDataAvailable(String s)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (isDataAvailable() || dataAvailability.containsKey(s) && ((Boolean)dataAvailability.get(s)).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static cu migrateFromDiskToLDS(String s, String s1)
    {
        ParseObject parseobject = getFromDisk(s);
        if (parseobject == null)
        {
            return cu.a(null);
        } else
        {
            return parseobject.pinInBackground(s1).a(new ct(s, parseobject) {

                final ParseObject val$disk;
                final String val$filename;

                public ParseObject then(cu cu1)
                    throws Exception
                {
                    if (!cu1.d())
                    {
                        ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), filename));
                    }
                    return disk;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                filename = s;
                disk = parseobject;
                super();
            }
            });
        }
    }

    private void notifyObjectIdChanged(String s, String s1)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        OfflineStore offlinestore = Parse.getLocalDatastore();
        if (offlinestore == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        offlinestore.updateObjectId(this, s, s1);
        if (localId != null)
        {
            LocalIdManager.getDefaultInstance().setObjectId(localId, s1);
            localId = null;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void pinAll(String s, List list)
        throws ParseException
    {
        ParseTaskUtils.wait(pinAllInBackground(s, list));
    }

    public static void pinAll(List list)
        throws ParseException
    {
        ParseTaskUtils.wait(pinAllInBackground("_default", list));
    }

    public static cu pinAllInBackground(String s, List list)
    {
        return pinAllInBackground(s, list, true);
    }

    private static cu pinAllInBackground(String s, List list, boolean flag)
    {
        if (!Parse.isLocalDatastoreEnabled())
        {
            throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
        }
        cu cu1 = cu.a(null);
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            cu1 = cu1.d(new ct((ParseObject)iterator.next()) {

                final ParseObject val$object;

                public cu then(cu cu2)
                    throws Exception
                {
                    if (!object.isDataAvailable("ACL"))
                    {
                        return cu.a(null);
                    }
                    cu2 = object.getACL(false);
                    if (cu2 == null)
                    {
                        return cu.a(null);
                    }
                    cu2 = cu2.getUnresolvedUser();
                    if (cu2 == null || !cu2.isCurrentUser())
                    {
                        return cu.a(null);
                    } else
                    {
                        return ParseUser.pinCurrentUserIfNeededAsync(cu2);
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                object = parseobject;
                super();
            }
            });
        }

        return cu1.d(new ct(s, list, flag) {

            final boolean val$includeAllChildren;
            final String val$name;
            final List val$objects;

            public cu then(cu cu2)
                throws Exception
            {
                OfflineStore offlinestore = Parse.getLocalDatastore();
                if (name != null)
                {
                    cu2 = name;
                } else
                {
                    cu2 = "_default";
                }
                return offlinestore.pinAllObjectsAsync(cu2, objects, includeAllChildren);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                name = s;
                objects = list;
                includeAllChildren = flag;
                super();
            }
        }).d(new ct(s, list) {

            final String val$name;
            final List val$objects;

            public cu then(cu cu2)
                throws Exception
            {
                if (!"_currentUser".equals(name))
                {
                    Iterator iterator1 = objects.iterator();
                    while (iterator1.hasNext()) 
                    {
                        Object obj = (ParseObject)iterator1.next();
                        if (obj instanceof ParseUser)
                        {
                            obj = (ParseUser)obj;
                            if (((ParseUser) (obj)).isCurrentUser())
                            {
                                return ParseUser.pinCurrentUserIfNeededAsync(((ParseUser) (obj)));
                            }
                        }
                    }
                }
                return cu2;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                name = s;
                objects = list;
                super();
            }
        });
    }

    public static cu pinAllInBackground(List list)
    {
        return pinAllInBackground("_default", list);
    }

    public static void pinAllInBackground(String s, List list, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(pinAllInBackground(s, list), savecallback);
    }

    public static void pinAllInBackground(List list, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(pinAllInBackground("_default", list), savecallback);
    }

    private void rebuildDataAvailability()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        dataAvailability.clear();
        String s;
        for (Iterator iterator = state.keySet().iterator(); iterator.hasNext(); dataAvailability.put(s, Boolean.valueOf(true)))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_71;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    private void rebuildEstimatedData()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        estimatedData.clear();
        String s;
        for (Iterator iterator = state.keySet().iterator(); iterator.hasNext(); estimatedData.put(s, state.get(s)))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_75;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        for (Iterator iterator1 = operationSetQueue.iterator(); iterator1.hasNext(); applyOperations((ParseOperationSet)iterator1.next(), estimatedData)) { }
        obj;
        JVM INSTR monitorexit ;
    }

    static void registerParseSubclasses()
    {
        registerSubclass(com/parse/ParseUser);
        registerSubclass(com/parse/ParseRole);
        registerSubclass(com/parse/ParseInstallation);
        registerSubclass(com/parse/ParseSession);
        registerSubclass(com/parse/ParsePin);
        registerSubclass(com/parse/EventuallyPin);
    }

    public static void registerSubclass(Class class1)
    {
        Object obj = getClassName(class1);
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No ParseClassName annotation provided on ").append(class1).toString());
        }
        if (class1.getDeclaredConstructors().length > 0)
        {
            try
            {
                if (!isAccessible(class1.getDeclaredConstructor(new Class[0])))
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Default constructor for ").append(class1).append(" is not accessible.").toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("No default constructor provided for ").append(class1).toString());
            }
        }
        Class class2 = (Class)objectTypes.get(obj);
        if (class2 == null || !class1.isAssignableFrom(class2))
        {
            objectTypes.put(obj, class1);
            if (class2 != null && !class1.equals(class2))
            {
                if (((String) (obj)).equals(getClassName(com/parse/ParseUser)))
                {
                    ParseUser.clearCurrentUserFromMemory();
                    return;
                }
                if (((String) (obj)).equals(getClassName(com/parse/ParseInstallation)))
                {
                    ParseInstallation.clearCurrentInstallationFromMemory();
                    return;
                }
            }
        }
    }

    public static void saveAll(List list)
        throws ParseException
    {
        ParseTaskUtils.wait(saveAllInBackground(list));
    }

    private static cu saveAllAsync(List list, String s, cu cu1)
    {
        return cu1.b(new ct(list, s) {

            final String val$sessionToken;
            final List val$uniqueObjects;

            public cu then(cu cu2)
                throws Exception
            {
                int k = uniqueObjects.size();
                Object obj = new ArrayList(k);
                cu2 = new ArrayList(k);
                ArrayList arraylist = new ArrayList(k);
                for (int i = 0; i < k; i++)
                {
                    ParseObject parseobject = (ParseObject)uniqueObjects.get(i);
                    parseobject.updateBeforeSave();
                    parseobject.validateSave();
                    ((List) (obj)).add(parseobject.getState());
                    cu2.add(parseobject.startSave());
                    arraylist.add(new KnownParseObjectDecoder(parseobject.collectFetchedObjects()));
                }

                obj = ParseObject.getObjectController().saveAllAsync(((List) (obj)), cu2, sessionToken, arraylist);
                arraylist = new ArrayList(k);
                for (int j = 0; j < k; j++)
                {
                    arraylist.add(((cu)((List) (obj)).get(j)).b(((ParseOperationSet)cu2.get(j)). new ct() {

                        final _cls42 this$0;
                        final ParseObject val$object;
                        final ParseOperationSet val$operations;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            State state1 = (State)cu1.e();
                            return object.handleSaveResultAsync(state1, operations).b(cu1. new ct() {

                                final _cls1 this$1;
                                final cu val$batchTask;

                                public cu then(cu cu1)
                                    throws Exception
                                {
                                    if (cu1.d() || cu1.c())
                                    {
                                        return cu1;
                                    } else
                                    {
                                        return batchTask.j();
                                    }
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$1 = final__pcls1;
                batchTask = cu.this;
                super();
            }
                            });
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = final__pcls42;
                object = parseobject;
                operations = ParseOperationSet.this;
                super();
            }
                    }));
                }

                return cu.a(arraylist);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                uniqueObjects = list;
                sessionToken = s;
                super();
            }
        });
    }

    public static cu saveAllInBackground(List list)
    {
        return ParseUser.getCurrentUserAsync().d(new ct(list) {

            final List val$objects;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (ParseUser)cu1.e();
                if (cu1 == null)
                {
                    return cu.a(null);
                }
                if (!cu1.isLazy())
                {
                    return cu.a(cu1.getSessionToken());
                }
                for (cu1 = objects.iterator(); cu1.hasNext();)
                {
                    final ParseACL acl = (ParseObject)cu1.next();
                    if (acl.isDataAvailable("ACL"))
                    {
                        acl = acl.getACL(false);
                        if (acl != null)
                        {
                            ParseUser parseuser = acl.getUnresolvedUser();
                            if (parseuser != null && parseuser.isCurrentUser())
                            {
                                return parseuser.saveAsync(null).c(parseuser. new ct() {

                                    final _cls44 this$0;
                                    final ParseACL val$acl;
                                    final ParseUser val$user;

                                    public volatile Object then(cu cu1)
                                        throws Exception
                                    {
                                        return then(cu1);
                                    }

                                    public String then(cu cu1)
                                        throws Exception
                                    {
                                        if (acl.hasUnresolvedUser())
                                        {
                                            throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                                        } else
                                        {
                                            return user.getSessionToken();
                                        }
                                    }

            
            {
                this$0 = final__pcls44;
                acl = parseacl;
                user = ParseUser.this;
                super();
            }
                                });
                            }
                        }
                    }
                }

                return cu.a(null);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                objects = list;
                super();
            }
        }).d(new ct(list) {

            final List val$objects;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return ParseObject.deepSaveAsync(objects, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                objects = list;
                super();
            }
        });
    }

    public static void saveAllInBackground(List list, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(saveAllInBackground(list), savecallback);
    }

    private void setState(State state1, boolean flag)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        s = state.objectId();
        s1 = state1.objectId();
        state = state1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (!ParseTextUtils.equals(s, s1))
        {
            notifyObjectIdChanged(s, s1);
        }
        rebuildEstimatedData();
        rebuildDataAvailability();
        checkpointAllMutableContainers();
        obj;
        JVM INSTR monitorexit ;
        return;
        state1;
        obj;
        JVM INSTR monitorexit ;
        throw state1;
    }

    public static void unpinAll()
        throws ParseException
    {
        ParseTaskUtils.wait(unpinAllInBackground());
    }

    public static void unpinAll(String s)
        throws ParseException
    {
        ParseTaskUtils.wait(unpinAllInBackground(s));
    }

    public static void unpinAll(String s, List list)
        throws ParseException
    {
        ParseTaskUtils.wait(unpinAllInBackground(s, list));
    }

    public static void unpinAll(List list)
        throws ParseException
    {
        ParseTaskUtils.wait(unpinAllInBackground("_default", list));
    }

    public static cu unpinAllInBackground()
    {
        return unpinAllInBackground("_default");
    }

    public static cu unpinAllInBackground(String s)
    {
        if (!Parse.isLocalDatastoreEnabled())
        {
            throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "_default";
        }
        return Parse.getLocalDatastore().unpinAllObjectsAsync(s1);
    }

    public static cu unpinAllInBackground(String s, List list)
    {
        if (!Parse.isLocalDatastoreEnabled())
        {
            throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "_default";
        }
        return Parse.getLocalDatastore().unpinAllObjectsAsync(s1, list);
    }

    public static cu unpinAllInBackground(List list)
    {
        return unpinAllInBackground("_default", list);
    }

    public static void unpinAllInBackground(DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(), deletecallback);
    }

    public static void unpinAllInBackground(String s, DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(s), deletecallback);
    }

    public static void unpinAllInBackground(String s, List list, DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(s, list), deletecallback);
    }

    public static void unpinAllInBackground(List list, DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground("_default", list), deletecallback);
    }

    static void unregisterParseSubclasses()
    {
        unregisterSubclass(com/parse/ParseUser);
        unregisterSubclass(com/parse/ParseRole);
        unregisterSubclass(com/parse/ParseInstallation);
        unregisterSubclass(com/parse/ParseSession);
        unregisterSubclass(com/parse/ParsePin);
        unregisterSubclass(com/parse/EventuallyPin);
    }

    static void unregisterSubclass(Class class1)
    {
        unregisterSubclass(getClassName(class1));
    }

    static void unregisterSubclass(String s)
    {
        objectTypes.remove(s);
    }

    public void add(String s, Object obj)
    {
        addAll(s, Arrays.asList(new Object[] {
            obj
        }));
    }

    public void addAll(String s, Collection collection)
    {
        performOperation(s, new ParseAddOperation(collection));
    }

    public void addAllUnique(String s, Collection collection)
    {
        performOperation(s, new ParseAddUniqueOperation(collection));
    }

    public void addUnique(String s, Object obj)
    {
        addAllUnique(s, Arrays.asList(new Object[] {
            obj
        }));
    }

    void build(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        State.Builder builder;
        Iterator iterator;
        builder = (State.Builder)(new State.Builder(state)).isComplete(true);
        builder.clear();
        iterator = jsonobject.keys();
_L3:
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_201;
            }
            s = (String)iterator.next();
        } while (s.equals("className"));
        if (!s.equals("objectId")) goto _L2; else goto _L1
_L1:
        builder.objectId(jsonobject.getString(s));
          goto _L3
_L2:
label0:
        {
            if (!s.equals("createdAt"))
            {
                break label0;
            }
            builder.createdAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
label1:
        {
            if (!s.equals("updatedAt"))
            {
                break label1;
            }
            builder.updatedAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
        Object obj;
label2:
        {
            obj = parsedecoder.decode(jsonobject.get(s));
            if (!(obj instanceof ParseFieldOperation))
            {
                break label2;
            }
            performOperation(s, (ParseFieldOperation)obj);
        }
          goto _L3
        try
        {
            put(s, obj);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new RuntimeException(jsonobject);
        }
          goto _L3
        setState(builder.build());
        return;
    }

    void checkForChangesToMutableContainers()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        for (Iterator iterator = estimatedData.keySet().iterator(); iterator.hasNext(); checkForChangesToMutableContainer(s, estimatedData.get(s)))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        hashedObjects.keySet().retainAll(estimatedData.values());
        obj;
        JVM INSTR monitorexit ;
    }

    public boolean containsKey(String s)
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = estimatedData.containsKey(s);
        }
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    void copyChangesFrom(ParseObject parseobject)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        parseobject = (ParseOperationSet)parseobject.operationSetQueue.getFirst();
        String s;
        for (Iterator iterator = parseobject.keySet().iterator(); iterator.hasNext(); performOperation(s, (ParseFieldOperation)parseobject.get(s)))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_71;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void delete()
        throws ParseException
    {
        ParseTaskUtils.wait(deleteInBackground());
    }

    cu deleteAsync(String s)
        throws ParseException
    {
        return getObjectController().deleteAsync(getState(), s);
    }

    public final cu deleteEventually()
    {
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        validateDelete();
        isDeletingEventually = isDeletingEventually + 1;
        Object obj = null;
        if (getObjectId() == null)
        {
            obj = getOrCreateLocalId();
        }
        Object obj2 = ParseUser.getCurrentSessionToken();
        obj2 = ParseRESTObjectCommand.deleteObjectCommand(getState(), ((String) (obj2)));
        ((ParseRESTCommand) (obj2)).enableRetrying();
        ((ParseRESTCommand) (obj2)).setLocalId(((String) (obj)));
        obj = Parse.getEventuallyQueue().enqueueEventuallyAsync(((ParseRESTCommand) (obj2)), this);
        obj1;
        JVM INSTR monitorexit ;
        if (Parse.isLocalDatastoreEnabled())
        {
            return ((cu) (obj)).j();
        } else
        {
            return ((cu) (obj)).d(new ct() {

                final ParseObject this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    return handleDeleteEventuallyResultAsync();
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseObject.this;
                super();
            }
            });
        }
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public final void deleteEventually(DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(deleteEventually(), deletecallback);
    }

    public final cu deleteInBackground()
    {
        return ParseUser.getCurrentSessionTokenAsync().d(new ct() {

            final ParseObject this$0;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return taskQueue.enqueue(cu1. new ct() {

                    final _cls32 this$1;
                    final String val$sessionToken;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return deleteAsync(sessionToken, cu1);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = final__pcls32;
                sessionToken = String.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public final void deleteInBackground(DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(deleteInBackground(), deletecallback);
    }

    public ParseObject fetch()
        throws ParseException
    {
        return (ParseObject)ParseTaskUtils.wait(fetchInBackground());
    }

    cu fetchAsync(final String sessionToken, cu cu1)
    {
        return cu1.d(new ct() {

            final ParseObject this$0;
            final String val$sessionToken;

            public cu then(cu cu2)
                throws Exception
            {
                State state1;
                Map map;
                synchronized (mutex)
                {
                    state1 = getState();
                    map = collectFetchedObjects();
                }
                cu2 = new KnownParseObjectDecoder(map);
                return ParseObject.getObjectController().fetchAsync(state1, sessionToken, cu2);
                exception;
                cu2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseObject.this;
                sessionToken = s;
                super();
            }
        }).d(new ct() {

            final ParseObject this$0;

            public cu then(cu cu2)
                throws Exception
            {
                cu2 = (State)cu2.e();
                return handleFetchResultAsync(cu2);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        }).c(new ct() {

            final ParseObject this$0;

            public ParseObject then(cu cu2)
                throws Exception
            {
                return ParseObject.this;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public void fetchFromLocalDatastore()
        throws ParseException
    {
        ParseTaskUtils.wait(fetchFromLocalDatastoreAsync());
    }

    cu fetchFromLocalDatastoreAsync()
    {
        if (!Parse.isLocalDatastoreEnabled())
        {
            throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
        } else
        {
            return Parse.getLocalDatastore().fetchLocallyAsync(this);
        }
    }

    public void fetchFromLocalDatastoreInBackground(GetCallback getcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchFromLocalDatastoreAsync(), getcallback);
    }

    public ParseObject fetchIfNeeded()
        throws ParseException
    {
        return (ParseObject)ParseTaskUtils.wait(fetchIfNeededInBackground());
    }

    public final cu fetchIfNeededInBackground()
    {
label0:
        {
            cu cu1;
            synchronized (mutex)
            {
                if (!isDataAvailable())
                {
                    break label0;
                }
                cu1 = cu.a(this);
            }
            return cu1;
        }
        cu cu2 = fetchInBackground();
        obj;
        JVM INSTR monitorexit ;
        return cu2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void fetchIfNeededInBackground(GetCallback getcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchIfNeededInBackground(), getcallback);
    }

    public final cu fetchInBackground()
    {
        return ParseUser.getCurrentSessionTokenAsync().d(new ct() {

            final ParseObject this$0;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return taskQueue.enqueue(cu1. new ct() {

                    final _cls28 this$1;
                    final String val$sessionToken;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return fetchAsync(sessionToken, cu1);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = final__pcls28;
                sessionToken = String.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public final void fetchInBackground(GetCallback getcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchInBackground(), getcallback);
    }

    public Object get(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                if (!s.equals("ACL"))
                {
                    break label0;
                }
                s = getACL();
            }
            return s;
        }
        Object obj1;
        checkGetAccess(s);
        obj1 = estimatedData.get(s);
        if (obj1 instanceof ParseRelation)
        {
            ((ParseRelation)obj1).ensureParentAndKey(this, s);
        }
        obj;
        JVM INSTR monitorexit ;
        return obj1;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public ParseACL getACL()
    {
        return getACL(true);
    }

    public boolean getBoolean(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                checkGetAccess(s);
                s = ((String) (estimatedData.get(s)));
                if (s instanceof Boolean)
                {
                    break label0;
                }
            }
            return false;
        }
        boolean flag = ((Boolean)s).booleanValue();
        obj;
        JVM INSTR monitorexit ;
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public byte[] getBytes(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                checkGetAccess(s);
                s = ((String) (estimatedData.get(s)));
                if (s instanceof byte[])
                {
                    break label0;
                }
            }
            return null;
        }
        s = (byte[])(byte[])s;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String getClassName()
    {
        String s;
        synchronized (mutex)
        {
            s = state.className();
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Date getCreatedAt()
    {
        long l = getState().createdAt();
        if (l > 0L)
        {
            return new Date(l);
        } else
        {
            return null;
        }
    }

    public Date getDate(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                checkGetAccess(s);
                s = ((String) (estimatedData.get(s)));
                if (s instanceof Date)
                {
                    break label0;
                }
            }
            return null;
        }
        s = (Date)s;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public double getDouble(String s)
    {
        s = getNumber(s);
        if (s == null)
        {
            return 0.0D;
        } else
        {
            return s.doubleValue();
        }
    }

    public int getInt(String s)
    {
        s = getNumber(s);
        if (s == null)
        {
            return 0;
        } else
        {
            return s.intValue();
        }
    }

    public JSONArray getJSONArray(String s)
    {
        Object obj2 = mutex;
        obj2;
        JVM INSTR monitorenter ;
        Object obj1;
        checkGetAccess(s);
        obj1 = estimatedData.get(s);
        Object obj = obj1;
        if (obj1 instanceof List)
        {
            obj = PointerOrLocalIdEncoder.get().encode(obj1);
            put(s, obj);
        }
        if (obj instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj2;
        JVM INSTR monitorexit ;
        return null;
        s = (JSONArray)obj;
        obj2;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj2;
        JVM INSTR monitorexit ;
        throw s;
    }

    public JSONObject getJSONObject(String s)
    {
        Object obj2 = mutex;
        obj2;
        JVM INSTR monitorenter ;
        Object obj1;
        checkGetAccess(s);
        obj1 = estimatedData.get(s);
        Object obj = obj1;
        if (obj1 instanceof Map)
        {
            obj = PointerOrLocalIdEncoder.get().encode(obj1);
            put(s, obj);
        }
        if (obj instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj2;
        JVM INSTR monitorexit ;
        return null;
        s = (JSONObject)obj;
        obj2;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj2;
        JVM INSTR monitorexit ;
        throw s;
    }

    public List getList(String s)
    {
        Object obj2 = mutex;
        obj2;
        JVM INSTR monitorenter ;
        Object obj1 = estimatedData.get(s);
        Object obj = obj1;
        if (obj1 instanceof JSONArray)
        {
            obj = ParseDecoder.get().convertJSONArrayToList((JSONArray)obj1);
            put(s, obj);
        }
        if (obj instanceof List)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj2;
        JVM INSTR monitorexit ;
        return null;
        s = (List)obj;
        obj2;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj2;
        JVM INSTR monitorexit ;
        throw s;
    }

    public long getLong(String s)
    {
        s = getNumber(s);
        if (s == null)
        {
            return 0L;
        } else
        {
            return s.longValue();
        }
    }

    public Map getMap(String s)
    {
        Object obj2 = mutex;
        obj2;
        JVM INSTR monitorenter ;
        Object obj1 = estimatedData.get(s);
        Object obj = obj1;
        if (obj1 instanceof JSONObject)
        {
            obj = ParseDecoder.get().convertJSONObjectToMap((JSONObject)obj1);
            put(s, obj);
        }
        if (obj instanceof Map)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj2;
        JVM INSTR monitorexit ;
        return null;
        s = (Map)obj;
        obj2;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj2;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Number getNumber(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                checkGetAccess(s);
                s = ((String) (estimatedData.get(s)));
                if (s instanceof Number)
                {
                    break label0;
                }
            }
            return null;
        }
        s = (Number)s;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String getObjectId()
    {
        String s;
        synchronized (mutex)
        {
            s = state.objectId();
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    String getOrCreateLocalId()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (localId != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (state.objectId() != null)
        {
            throw new IllegalStateException("Attempted to get a localId for an object with an objectId.");
        }
        break MISSING_BLOCK_LABEL_40;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        localId = LocalIdManager.getDefaultInstance().createLocalId();
        String s = localId;
        obj;
        JVM INSTR monitorexit ;
        return s;
    }

    public ParseFile getParseFile(String s)
    {
        s = ((String) (get(s)));
        if (!(s instanceof ParseFile))
        {
            return null;
        } else
        {
            return (ParseFile)s;
        }
    }

    public ParseGeoPoint getParseGeoPoint(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                checkGetAccess(s);
                s = ((String) (estimatedData.get(s)));
                if (s instanceof ParseGeoPoint)
                {
                    break label0;
                }
            }
            return null;
        }
        s = (ParseGeoPoint)s;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public ParseObject getParseObject(String s)
    {
        s = ((String) (get(s)));
        if (!(s instanceof ParseObject))
        {
            return null;
        } else
        {
            return (ParseObject)s;
        }
    }

    public ParseUser getParseUser(String s)
    {
        s = ((String) (get(s)));
        if (!(s instanceof ParseUser))
        {
            return null;
        } else
        {
            return (ParseUser)s;
        }
    }

    public ParseRelation getRelation(String s)
    {
label0:
        {
            Object obj1;
            synchronized (mutex)
            {
                obj1 = estimatedData.get(s);
                if (!(obj1 instanceof ParseRelation))
                {
                    break label0;
                }
                obj1 = (ParseRelation)obj1;
                ((ParseRelation) (obj1)).ensureParentAndKey(this, s);
            }
            return ((ParseRelation) (obj1));
        }
        ParseRelation parserelation;
        parserelation = new ParseRelation(this, s);
        estimatedData.put(s, parserelation);
        obj;
        JVM INSTR monitorexit ;
        return parserelation;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    State getState()
    {
        State state1;
        synchronized (mutex)
        {
            state1 = state;
        }
        return state1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getString(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                checkGetAccess(s);
                s = ((String) (estimatedData.get(s)));
                if (s instanceof String)
                {
                    break label0;
                }
            }
            return null;
        }
        s = (String)s;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Date getUpdatedAt()
    {
        long l = getState().updatedAt();
        if (l > 0L)
        {
            return new Date(l);
        } else
        {
            return null;
        }
    }

    cu handleDeleteEventuallyResultAsync()
    {
        synchronized (mutex)
        {
            isDeletingEventually = isDeletingEventually - 1;
        }
        return handleDeleteResultAsync().d(new ct() {

            final ParseObject this$0;

            public cu then(cu cu1)
                throws Exception
            {
                Parse.getEventuallyQueue().notifyTestHelper(6);
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    cu handleDeleteResultAsync()
    {
        cu cu1 = cu.a(null);
        synchronized (mutex)
        {
            isDeleted = true;
        }
        final OfflineStore store = Parse.getLocalDatastore();
        obj = cu1;
        if (store != null)
        {
            obj = cu1.b(new ct() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public cu then(cu cu2)
                    throws Exception
                {
label0:
                    {
                        cu cu3;
                        synchronized (mutex)
                        {
                            if (!isDeleted)
                            {
                                break label0;
                            }
                            store.unregisterObject(ParseObject.this);
                            cu3 = store.deleteDataForObjectAsync(ParseObject.this);
                        }
                        return cu3;
                    }
                    cu cu4 = store.updateDataForObjectAsync(ParseObject.this);
                    cu2;
                    JVM INSTR monitorexit ;
                    return cu4;
                    exception1;
                    cu2;
                    JVM INSTR monitorexit ;
                    throw exception1;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            });
        }
        return ((cu) (obj));
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    cu handleFetchResultAsync(final State result)
    {
        cu cu2 = cu.a((Void)null);
        final OfflineStore store = Parse.getLocalDatastore();
        cu cu1 = cu2;
        if (store != null)
        {
            cu1 = cu2.d(new ct() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public cu then(cu cu3)
                    throws Exception
                {
                    return store.fetchLocallyAsync(ParseObject.this).j();
                }

                public volatile Object then(cu cu3)
                    throws Exception
                {
                    return then(cu3);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            }).b(new ct() {

                final ParseObject this$0;

                public cu then(cu cu3)
                    throws Exception
                {
                    cu cu4 = cu3;
                    if (cu3.f() instanceof ParseException)
                    {
                        cu4 = cu3;
                        if (((ParseException)cu3.f()).getCode() == 120)
                        {
                            cu4 = null;
                        }
                    }
                    return cu4;
                }

                public volatile Object then(cu cu3)
                    throws Exception
                {
                    return then(cu3);
                }

            
            {
                this$0 = ParseObject.this;
                super();
            }
            });
        }
        cu1 = cu1.d(new ct() {

            final ParseObject this$0;
            final State val$result;

            public cu then(cu cu3)
                throws Exception
            {
                Object obj = mutex;
                obj;
                JVM INSTR monitorenter ;
                if (!result.isComplete())
                {
                    break MISSING_BLOCK_LABEL_37;
                }
                cu3 = result;
_L1:
                setState(cu3);
                return null;
                cu3 = getState().newBuilder().apply(result).build();
                  goto _L1
                cu3;
                obj;
                JVM INSTR monitorexit ;
                throw cu3;
            }

            public volatile Object then(cu cu3)
                throws Exception
            {
                return then(cu3);
            }

            
            {
                this$0 = ParseObject.this;
                result = state1;
                super();
            }
        });
        result = cu1;
        if (store != null)
        {
            result = cu1.d(new ct() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public cu then(cu cu3)
                    throws Exception
                {
                    return store.updateDataForObjectAsync(ParseObject.this);
                }

                public volatile Object then(cu cu3)
                    throws Exception
                {
                    return then(cu3);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            }).b(new ct() {

                final ParseObject this$0;

                public cu then(cu cu3)
                    throws Exception
                {
                    cu cu4 = cu3;
                    if (cu3.f() instanceof ParseException)
                    {
                        cu4 = cu3;
                        if (((ParseException)cu3.f()).getCode() == 120)
                        {
                            cu4 = null;
                        }
                    }
                    return cu4;
                }

                public volatile Object then(cu cu3)
                    throws Exception
                {
                    return then(cu3);
                }

            
            {
                this$0 = ParseObject.this;
                super();
            }
            });
        }
        return result;
    }

    cu handleSaveEventuallyResultAsync(JSONObject jsonobject, ParseOperationSet parseoperationset)
    {
        final boolean success;
        if (jsonobject != null)
        {
            success = true;
        } else
        {
            success = false;
        }
        return handleSaveResultAsync(jsonobject, parseoperationset).d(new ct() {

            final ParseObject this$0;
            final boolean val$success;

            public cu then(cu cu1)
                throws Exception
            {
                if (success)
                {
                    Parse.getEventuallyQueue().notifyTestHelper(5);
                }
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject.this;
                success = flag;
                super();
            }
        });
    }

    cu handleSaveResultAsync(final State result, final ParseOperationSet operationsBeforeSave)
    {
        cu cu1 = cu.a((Void)null);
        final Object store;
        Object obj;
        boolean flag;
        if (result != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        store = mutex;
        store;
        JVM INSTR monitorenter ;
        obj = operationSetQueue.listIterator(operationSetQueue.indexOf(operationsBeforeSave));
        ((ListIterator) (obj)).next();
        ((ListIterator) (obj)).remove();
        obj = (ParseOperationSet)((ListIterator) (obj)).next();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        ((ParseOperationSet) (obj)).mergeFrom(operationsBeforeSave);
        store;
        JVM INSTR monitorexit ;
        return cu1;
        store;
        JVM INSTR monitorexit ;
        store = Parse.getLocalDatastore();
        if (store != null)
        {
            cu1 = cu1.d(new ct() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public cu then(cu cu2)
                    throws Exception
                {
                    return store.fetchLocallyAsync(ParseObject.this).j();
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            });
        }
        operationsBeforeSave = cu1.a(new ct() {

            final ParseObject this$0;
            final ParseOperationSet val$operationsBeforeSave;
            final State val$result;

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Void then(cu cu2)
                throws Exception
            {
                Object obj1 = mutex;
                obj1;
                JVM INSTR monitorenter ;
                if (!result.isComplete())
                {
                    break MISSING_BLOCK_LABEL_37;
                }
                cu2 = result;
_L1:
                setState(cu2);
                return null;
                cu2 = getState().newBuilder().apply(operationsBeforeSave).apply(result).build();
                  goto _L1
                cu2;
                obj1;
                JVM INSTR monitorexit ;
                throw cu2;
            }

            
            {
                this$0 = ParseObject.this;
                result = state1;
                operationsBeforeSave = parseoperationset;
                super();
            }
        });
        result = operationsBeforeSave;
        if (store != null)
        {
            result = operationsBeforeSave.d(new ct() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public cu then(cu cu2)
                    throws Exception
                {
                    return store.updateDataForObjectAsync(ParseObject.this);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            });
        }
        return result.c(new ct() {

            final ParseObject this$0;

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Void then(cu cu2)
                throws Exception
            {
                saveEvent.invoke(ParseObject.this, null);
                return null;
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
        result;
        store;
        JVM INSTR monitorexit ;
        throw result;
    }

    cu handleSaveResultAsync(JSONObject jsonobject, ParseOperationSet parseoperationset)
    {
        Object obj = null;
        if (jsonobject != null)
        {
            synchronized (mutex)
            {
                obj = new KnownParseObjectDecoder(collectFetchedObjects());
                obj = getObjectController().stateFromJSON(getState(), jsonobject, ((ParseDecoder) (obj)), false);
            }
        }
        return handleSaveResultAsync(((State) (obj)), parseoperationset);
        jsonobject;
        obj1;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    public boolean has(String s)
    {
        return containsKey(s);
    }

    boolean hasChanges()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (currentOperations().size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean hasOutstandingOperations()
    {
        boolean flag;
        flag = true;
        synchronized (mutex)
        {
            if (operationSetQueue.size() <= 1)
            {
                flag = false;
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean hasSameId(ParseObject parseobject)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (getClassName() != null && getObjectId() != null && getClassName().equals(parseobject.getClassName()) && getObjectId().equals(parseobject.getObjectId()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    public void increment(String s)
    {
        increment(s, ((Number) (Integer.valueOf(1))));
    }

    public void increment(String s, Number number)
    {
        performOperation(s, new ParseIncrementOperation(number));
    }

    boolean isContainerObject(String s, Object obj)
    {
        return (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof Map) || (obj instanceof List) || (obj instanceof ParseACL) || (obj instanceof ParseGeoPoint);
    }

    public boolean isDataAvailable()
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = state.isComplete();
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isDirty()
    {
        return isDirty(true);
    }

    public boolean isDirty(String s)
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = currentOperations().containsKey(s);
        }
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    boolean isDirty(boolean flag)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        checkForChangesToMutableContainers();
        if (isDeleted || getObjectId() == null || hasChanges()) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        if (!hasDirtyChildren()) goto _L4; else goto _L2
_L6:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    boolean isKeyMutable(String s)
    {
        return true;
    }

    public Set keySet()
    {
        Set set;
        synchronized (mutex)
        {
            set = Collections.unmodifiableSet(estimatedData.keySet());
        }
        return set;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    State mergeFromDiskJSON(State state1, JSONObject jsonobject)
    {
        State.Init init;
        init = state1.newBuilder().isComplete(true);
        if (jsonobject.has("id") && state1.objectId() == null)
        {
            init.objectId(jsonobject.getString("id"));
        }
        if (!jsonobject.has("created_at"))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        state1 = jsonobject.getString("created_at");
        if (state1 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        init.createdAt(ParseImpreciseDateFormat.getInstance().parse(state1));
        if (!jsonobject.has("updated_at"))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        state1 = jsonobject.getString("updated_at");
        if (state1 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        init.updatedAt(ParseImpreciseDateFormat.getInstance().parse(state1));
        if (jsonobject.has("pointers"))
        {
            state1 = jsonobject.getJSONObject("pointers");
            String s;
            JSONArray jsonarray;
            for (Iterator iterator = state1.keys(); iterator.hasNext(); init.put(s, createWithoutData(jsonarray.optString(0), jsonarray.optString(1))))
            {
                s = (String)iterator.next();
                jsonarray = state1.getJSONArray(s);
            }

        }
        try
        {
            state1 = jsonobject.optJSONObject("data");
        }
        // Misplaced declaration of an exception variable
        catch (State state1)
        {
            throw new RuntimeException(state1);
        }
        if (state1 == null)
        {
            break MISSING_BLOCK_LABEL_343;
        }
        Iterator iterator1;
        jsonobject = ParseDecoder.get();
        iterator1 = state1.keys();
_L3:
        String s1;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_343;
        }
        s1 = (String)iterator1.next();
        if (!s1.equals("objectId")) goto _L2; else goto _L1
_L1:
        init.objectId(state1.getString(s1));
          goto _L3
_L2:
label0:
        {
            if (!s1.equals("createdAt"))
            {
                break label0;
            }
            init.createdAt(ParseDateFormat.getInstance().parse(state1.getString(s1)));
        }
          goto _L3
label1:
        {
            if (!s1.equals("updatedAt"))
            {
                break label1;
            }
            init.updatedAt(ParseDateFormat.getInstance().parse(state1.getString(s1)));
        }
          goto _L3
        init.put(s1, jsonobject.decode(state1.get(s1)));
          goto _L3
        state1 = init.build();
        return state1;
    }

    void mergeFromObject(ParseObject parseobject)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (this != parseobject)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        setState(parseobject.getState().newBuilder().build(), false);
        obj;
        JVM INSTR monitorexit ;
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    State mergeFromServer(State state1, JSONObject jsonobject, ParseDecoder parsedecoder, boolean flag)
    {
        State.Init init;
        String s;
        try
        {
            init = state1.newBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (State state1)
        {
            throw new RuntimeException(state1);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        init.clear();
        if (!state1.isComplete() && !flag)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        init.isComplete(flag);
        state1 = jsonobject.keys();
_L3:
        do
        {
            if (!state1.hasNext())
            {
                break MISSING_BLOCK_LABEL_241;
            }
            s = (String)state1.next();
        } while (s.equals("__type") || s.equals("className"));
        if (!s.equals("objectId")) goto _L2; else goto _L1
_L1:
        init.objectId(jsonobject.getString(s));
          goto _L3
_L2:
label0:
        {
            if (!s.equals("createdAt"))
            {
                break label0;
            }
            init.createdAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
label1:
        {
            if (!s.equals("updatedAt"))
            {
                break label1;
            }
            init.updatedAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
label2:
        {
            if (!s.equals("ACL"))
            {
                break label2;
            }
            init.put("ACL", ParseACL.createACLFromJSONObject(jsonobject.getJSONObject(s), parsedecoder));
        }
          goto _L3
        init.put(s, parsedecoder.decode(jsonobject.get(s)));
          goto _L3
        state1 = init.build();
        return state1;
    }

    void mergeREST(State state1, JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        ArrayList arraylist = new ArrayList();
        Object obj2 = mutex;
        obj2;
        JVM INSTR monitorenter ;
        JSONArray jsonarray;
        ParseOperationSet parseoperationset1;
        boolean flag;
        flag = jsonobject.getBoolean("__complete");
        isDeletingEventually = ParseJSONUtils.getInt(jsonobject, Arrays.asList(new String[] {
            "__isDeletingEventually", "isDeletingEventually"
        }));
        jsonarray = jsonobject.getJSONArray("__operations");
        parseoperationset1 = currentOperations();
        operationSetQueue.clear();
        Object obj;
        int i;
        i = 0;
        obj = null;
_L14:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        ParseOperationSet parseoperationset = ParseOperationSet.fromRest(jsonarray.getJSONObject(i), parsedecoder);
        if (!parseoperationset.isSaveEventually()) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1 = obj;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        operationSetQueue.add(obj);
        obj1 = null;
        arraylist.add(parseoperationset);
        operationSetQueue.add(parseoperationset);
        obj = obj1;
          goto _L5
_L4:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            parseoperationset.mergeFrom(((ParseOperationSet) (obj)));
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (State state1) { }
        finally { }
          goto _L6
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        operationSetQueue.add(obj);
        currentOperations().mergeFrom(parseoperationset1);
        if (state1.updatedAt() >= 0L) goto _L8; else goto _L7
_L7:
        i = 1;
_L12:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        setState(mergeFromServer(state1, ParseJSONUtils.create(jsonobject, Arrays.asList(new String[] {
            "__complete", "__isDeletingEventually", "isDeletingEventually", "__operations"
        })), parsedecoder, flag));
        obj2;
        JVM INSTR monitorexit ;
          goto _L9
_L8:
        if (!jsonobject.has("updatedAt")) goto _L11; else goto _L10
_L10:
        obj = ParseDateFormat.getInstance().parse(jsonobject.getString("updatedAt"));
        i = (new Date(state1.updatedAt())).compareTo(((Date) (obj)));
        if (i < 0)
        {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L11
_L6:
        throw new RuntimeException(state1);
        obj2;
        JVM INSTR monitorexit ;
        throw state1;
_L9:
        for (state1 = arraylist.iterator(); state1.hasNext(); enqueueSaveEventuallyOperationAsync((ParseOperationSet)state1.next())) { }
        return;
_L11:
        i = 0;
        if (true) goto _L12; else goto _L5
_L5:
        i++;
        if (true) goto _L14; else goto _L13
_L13:
        obj = parseoperationset;
        if (true) goto _L5; else goto _L15
_L15:
        if (true) goto _L14; else goto _L16
_L16:
    }

    boolean needsDefaultACL()
    {
        return true;
    }

    State.Init newStateBuilder(String s)
    {
        return new State.Builder(s);
    }

    void performOperation(String s, ParseFieldOperation parsefieldoperation)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = parsefieldoperation.apply(estimatedData.get(s), s);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        estimatedData.put(s, obj1);
_L2:
        parsefieldoperation = parsefieldoperation.mergeWithPrevious((ParseFieldOperation)currentOperations().get(s));
        currentOperations().put(s, parsefieldoperation);
        checkpointMutableContainer(s, obj1);
        dataAvailability.put(s, Boolean.TRUE);
        obj;
        JVM INSTR monitorexit ;
        return;
        estimatedData.remove(s);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    void performPut(String s, Object obj)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key may not be null.");
        }
        if (obj == null)
        {
            throw new IllegalArgumentException("value may not be null.");
        }
        if (!ParseEncoder.isValidType(obj))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type for value: ").append(obj.getClass().toString()).toString());
        } else
        {
            performOperation(s, new ParseSetOperation(obj));
            return;
        }
    }

    void performRemove(String s)
    {
        synchronized (mutex)
        {
            if (get(s) != null)
            {
                performOperation(s, ParseDeleteOperation.getInstance());
            }
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void pin()
        throws ParseException
    {
        ParseTaskUtils.wait(pinInBackground());
    }

    public void pin(String s)
        throws ParseException
    {
        ParseTaskUtils.wait(pinInBackground(s));
    }

    public cu pinInBackground()
    {
        return pinAllInBackground("_default", Arrays.asList(new ParseObject[] {
            this
        }));
    }

    public cu pinInBackground(String s)
    {
        return pinAllInBackground(s, Arrays.asList(new ParseObject[] {
            this
        }));
    }

    cu pinInBackground(String s, boolean flag)
    {
        return pinAllInBackground(s, Arrays.asList(new ParseObject[] {
            this
        }), flag);
    }

    public void pinInBackground(SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(pinInBackground(), savecallback);
    }

    public void pinInBackground(String s, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(pinInBackground(s), savecallback);
    }

    public void put(String s, Object obj)
    {
        checkKeyIsMutable(s);
        performPut(s, obj);
    }

    public final void refresh()
        throws ParseException
    {
        fetch();
    }

    public final void refreshInBackground(RefreshCallback refreshcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchInBackground(), refreshcallback);
    }

    void registerSaveListener(GetCallback getcallback)
    {
        synchronized (mutex)
        {
            saveEvent.subscribe(getcallback);
        }
        return;
        getcallback;
        obj;
        JVM INSTR monitorexit ;
        throw getcallback;
    }

    public void remove(String s)
    {
        checkKeyIsMutable(s);
        performRemove(s);
    }

    public void removeAll(String s, Collection collection)
    {
        checkKeyIsMutable(s);
        performOperation(s, new ParseRemoveOperation(collection));
    }

    void revert()
    {
        synchronized (mutex)
        {
            currentOperations().clear();
            rebuildEstimatedData();
            rebuildDataAvailability();
            checkpointAllMutableContainers();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void revert(String s)
    {
        synchronized (mutex)
        {
            currentOperations().remove(s);
            rebuildEstimatedData();
            rebuildDataAvailability();
            checkpointAllMutableContainers();
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void save()
        throws ParseException
    {
        ParseTaskUtils.wait(saveInBackground());
    }

    cu saveAsync(ParseOperationSet parseoperationset, String s)
        throws ParseException
    {
        return currentSaveCommand(parseoperationset, PointerEncoder.get(), s).executeAsync();
    }

    cu saveAsync(final String sessionToken)
    {
        return taskQueue.enqueue(new ct() {

            final ParseObject this$0;
            final String val$sessionToken;

            public cu then(cu cu1)
                throws Exception
            {
                return saveAsync(sessionToken, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject.this;
                sessionToken = s;
                super();
            }
        });
    }

    cu saveAsync(final String sessionToken, cu cu1)
    {
        if (!isDirty())
        {
            return cu.a(null);
        }
        final ParseOperationSet operations;
        synchronized (mutex)
        {
            updateBeforeSave();
            validateSave();
            operations = startSave();
        }
        cu cu2;
        synchronized (mutex)
        {
            cu2 = deepSaveAsync(estimatedData, sessionToken);
        }
        return cu2.d(TaskQueue.waitFor(cu1)).d(new ct() {

            final ParseObject this$0;
            final ParseOperationSet val$operations;
            final String val$sessionToken;

            public cu then(cu cu3)
                throws Exception
            {
                cu3 = new KnownParseObjectDecoder(collectFetchedObjects());
                return ParseObject.getObjectController().saveAsync(getState(), operations, sessionToken, cu3);
            }

            public volatile Object then(cu cu3)
                throws Exception
            {
                return then(cu3);
            }

            
            {
                this$0 = ParseObject.this;
                operations = parseoperationset;
                sessionToken = s;
                super();
            }
        }).b(new ct() {

            final ParseObject this$0;
            final ParseOperationSet val$operations;

            public cu then(cu cu3)
                throws Exception
            {
                State state1 = (State)cu3.e();
                return handleSaveResultAsync(state1, operations).b(cu3. new ct() {

                    final _cls13 this$1;
                    final cu val$saveTask;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        if (cu1.d() || cu1.c())
                        {
                            return cu1;
                        } else
                        {
                            return saveTask.j();
                        }
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = final__pcls13;
                saveTask = cu.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu3)
                throws Exception
            {
                return then(cu3);
            }

            
            {
                this$0 = ParseObject.this;
                operations = parseoperationset;
                super();
            }
        });
        sessionToken;
        obj;
        JVM INSTR monitorexit ;
        throw sessionToken;
        sessionToken;
        obj;
        JVM INSTR monitorexit ;
        throw sessionToken;
    }

    public final cu saveEventually()
    {
        String s;
        s = null;
        if (!isDirty())
        {
            Parse.getEventuallyQueue().fakeObjectUpdate();
            return cu.a(null);
        }
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        final ParseOperationSet operationSet;
        Object obj2;
        updateBeforeSave();
        arraylist = new ArrayList();
        collectDirtyChildren(estimatedData, arraylist, null);
        if (getObjectId() == null)
        {
            s = getOrCreateLocalId();
        }
        operationSet = startSave();
        operationSet.setIsSaveEventually(true);
        obj2 = ParseUser.getCurrentSessionToken();
        obj2 = currentSaveCommand(operationSet, PointerOrLocalIdEncoder.get(), ((String) (obj2)));
        ((ParseRESTCommand) (obj2)).setLocalId(s);
        ((ParseRESTCommand) (obj2)).setOperationSetUUID(operationSet.getUUID());
        ((ParseRESTCommand) (obj2)).retainLocalIds();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((ParseObject)iterator.next()).saveEventually()) { }
        break MISSING_BLOCK_LABEL_161;
        Object obj;
        obj;
        throw new IllegalStateException("Unable to saveEventually.", ((Throwable) (obj)));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj1;
        JVM INSTR monitorexit ;
        cu cu1 = Parse.getEventuallyQueue().enqueueEventuallyAsync(((ParseRESTCommand) (obj2)), this);
        enqueueSaveEventuallyOperationAsync(operationSet);
        ((ParseRESTCommand) (obj2)).releaseLocalIds();
        if (Parse.isLocalDatastoreEnabled())
        {
            return cu1.j();
        } else
        {
            return cu1.d(new ct() {

                final ParseObject this$0;
                final ParseOperationSet val$operationSet;

                public cu then(cu cu2)
                    throws Exception
                {
                    cu2 = (JSONObject)cu2.e();
                    return handleSaveEventuallyResultAsync(cu2, operationSet);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseObject.this;
                operationSet = parseoperationset;
                super();
            }
            });
        }
    }

    public final void saveEventually(SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(saveEventually(), savecallback);
    }

    public final cu saveInBackground()
    {
        return ParseUser.getCurrentUserAsync().d(new ct() {

            final ParseObject this$0;

            public cu then(final cu acl)
                throws Exception
            {
                acl = (ParseUser)acl.e();
                if (acl == null)
                {
                    return cu.a(null);
                }
                if (!acl.isLazy())
                {
                    return cu.a(acl.getSessionToken());
                }
                if (!isDataAvailable("ACL"))
                {
                    return cu.a(null);
                }
                acl = getACL(false);
                if (acl == null)
                {
                    return cu.a(null);
                }
                ParseUser parseuser = acl.getUnresolvedUser();
                if (parseuser == null || !parseuser.isCurrentUser())
                {
                    return cu.a(null);
                } else
                {
                    return parseuser.saveAsync(null).c(parseuser. new ct() {

                        final _cls11 this$1;
                        final ParseACL val$acl;
                        final ParseUser val$user;

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

                        public String then(cu cu1)
                            throws Exception
                        {
                            if (acl.hasUnresolvedUser())
                            {
                                throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                            } else
                            {
                                return user.getSessionToken();
                            }
                        }

            
            {
                this$1 = final__pcls11;
                acl = parseacl;
                user = ParseUser.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        }).d(new ct() {

            final ParseObject this$0;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return saveAsync(cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public final void saveInBackground(SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(), savecallback);
    }

    void saveToDisk(String s)
    {
        if (Parse.isLocalDatastoreEnabled())
        {
            throw new IllegalStateException("ParseObject#saveToDisk is not allowed when OfflineStore is enabled");
        }
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = toJSONObjectForDataFile(state, PointerEncoder.get());
        try
        {
            ParseFileUtils.writeJSONObjectToFile(new File(Parse.getParseDir(), s), jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setACL(ParseACL parseacl)
    {
        put("ACL", parseacl);
    }

    void setDefaultValues()
    {
        if (needsDefaultACL() && ParseACL.getDefaultACL() != null)
        {
            setACL(ParseACL.getDefaultACL());
        }
    }

    public void setObjectId(String s)
    {
        String s1;
label0:
        {
            synchronized (mutex)
            {
                s1 = state.objectId();
                if (!ParseTextUtils.equals(s1, s))
                {
                    break label0;
                }
            }
            return;
        }
        state = state.newBuilder().objectId(s).build();
        notifyObjectIdChanged(s1, s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    void setState(State state1)
    {
        synchronized (mutex)
        {
            setState(state1, true);
        }
        return;
        state1;
        obj;
        JVM INSTR monitorexit ;
        throw state1;
    }

    ParseOperationSet startSave()
    {
        ParseOperationSet parseoperationset;
        synchronized (mutex)
        {
            parseoperationset = currentOperations();
            operationSetQueue.addLast(new ParseOperationSet());
        }
        return parseoperationset;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    JSONObject toJSONObjectForDataFile(State state1, ParseEncoder parseencoder)
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        jsonobject = new JSONObject();
        jsonobject1 = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = state1.keySet().iterator(); iterator.hasNext(); jsonobject1.put(s, parseencoder.encode(state1.get(s))))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (State state1)
        {
            throw new RuntimeException("could not serialize object to JSON");
        }
        if (state1.createdAt() > 0L)
        {
            jsonobject1.put("createdAt", ParseDateFormat.getInstance().format(new Date(state1.createdAt())));
        }
        if (state1.updatedAt() > 0L)
        {
            jsonobject1.put("updatedAt", ParseDateFormat.getInstance().format(new Date(state1.updatedAt())));
        }
        if (state1.objectId() != null)
        {
            jsonobject1.put("objectId", state1.objectId());
        }
        jsonobject.put("data", jsonobject1);
        jsonobject.put("classname", state1.className());
        return jsonobject;
    }

    JSONObject toJSONObjectForSaving(State state1, ParseOperationSet parseoperationset, ParseEncoder parseencoder)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, parseencoder.encode((ParseFieldOperation)parseoperationset.get(s))))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (State state1)
        {
            throw new RuntimeException("could not serialize object to JSON");
        }
        if (state1.objectId() != null)
        {
            jsonobject.put("objectId", state1.objectId());
        }
        return jsonobject;
    }

    JSONObject toRest(ParseEncoder parseencoder)
    {
        synchronized (mutex)
        {
            parseencoder = toRest(getState(), ((List) (operationSetQueue)), parseencoder);
        }
        return parseencoder;
        parseencoder;
        obj;
        JVM INSTR monitorexit ;
        throw parseencoder;
    }

    JSONObject toRest(State state1, List list, ParseEncoder parseencoder)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        checkForChangesToMutableContainers();
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("className", state1.className());
            if (state1.objectId() != null)
            {
                jsonobject.put("objectId", state1.objectId());
            }
            if (state1.createdAt() > 0L)
            {
                jsonobject.put("createdAt", ParseDateFormat.getInstance().format(new Date(state1.createdAt())));
            }
            if (state1.updatedAt() > 0L)
            {
                jsonobject.put("updatedAt", ParseDateFormat.getInstance().format(new Date(state1.updatedAt())));
            }
            String s;
            for (Iterator iterator = state1.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, parseencoder.encode(state1.get(s))))
            {
                s = (String)iterator.next();
            }

            break MISSING_BLOCK_LABEL_193;
        }
        // Misplaced declaration of an exception variable
        catch (State state1) { }
        throw new RuntimeException("could not serialize object to JSON");
        state1;
        obj;
        JVM INSTR monitorexit ;
        throw state1;
        jsonobject.put("__complete", state1.isComplete());
        jsonobject.put("__isDeletingEventually", isDeletingEventually);
        state1 = new JSONArray();
        for (list = list.iterator(); list.hasNext(); state1.put(((ParseOperationSet)list.next()).toRest(parseencoder))) { }
        jsonobject.put("__operations", state1);
        obj;
        JVM INSTR monitorexit ;
        return jsonobject;
    }

    public void unpin()
        throws ParseException
    {
        ParseTaskUtils.wait(unpinInBackground());
    }

    public void unpin(String s)
        throws ParseException
    {
        ParseTaskUtils.wait(unpinInBackground(s));
    }

    public cu unpinInBackground()
    {
        return unpinAllInBackground("_default", Arrays.asList(new ParseObject[] {
            this
        }));
    }

    public cu unpinInBackground(String s)
    {
        return unpinAllInBackground(s, Arrays.asList(new ParseObject[] {
            this
        }));
    }

    public void unpinInBackground(DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinInBackground(), deletecallback);
    }

    public void unpinInBackground(String s, DeleteCallback deletecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinInBackground(s), deletecallback);
    }

    void unregisterSaveListener(GetCallback getcallback)
    {
        synchronized (mutex)
        {
            saveEvent.unsubscribe(getcallback);
        }
        return;
        getcallback;
        obj;
        JVM INSTR monitorexit ;
        throw getcallback;
    }

    void updateBeforeSave()
    {
    }

    void validateDelete()
    {
    }

    void validateSave()
    {
    }
















}
