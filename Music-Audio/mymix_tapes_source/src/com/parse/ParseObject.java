// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.util.Pair;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import java.util.SimpleTimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseMulticastDelegate, TaskQueue, ParseOperationSet, OfflineStore, 
//            ParseException, ParseFieldOperation, ParseTraverser, Parse, 
//            ParseJSONCacheItem, ParseSetOperation, ParseCommand, ParseFile, 
//            ParseUser, LockSet, ParseQuery, ParseDecoder, 
//            ParseACL, ParseClassName, ParsePin, ParseRole, 
//            ParseInstallation, EventuallyPin, LocalIdManager, ParseAddOperation, 
//            ParseAddUniqueOperation, ParseRelation, PointerOrLocalIdEncodingStrategy, ParseGeoPoint, 
//            ParseIncrementOperation, ParseDeleteOperation, ParseRemoveOperation, PointerEncodingStrategy, 
//            ParseEventuallyQueue, DeleteCallback, FindCallback, SaveCallback, 
//            ParseObjectEncodingStrategy, GetCallback, RefreshCallback, KnownParseObjectDecoder

public class ParseObject
{

    static final String API_VERSION = "2";
    private static final String AUTO_CLASS_NAME = "_Automatic";
    public static final String DEFAULT_PIN = "_default";
    private static final String NEW_OFFLINE_OBJECT_ID_PLACEHOLDER = "*** Offline Object ***";
    private static final String REST_KEY_COMPLETE = "__complete";
    private static final String REST_KEY_OPERATIONS = "__operations";
    private static final String TAG = "com.parse.ParseObject";
    static final String VERSION_NAME = "1.8.0";
    private static final Map classNames = new ConcurrentHashMap();
    private static final DateFormat impreciseDateFormat;
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
    private String className;
    private Date createdAt;
    private final Map dataAvailability;
    private final Map estimatedData;
    boolean hasBeenFetched;
    private final Map hashedObjects;
    boolean isDeleted;
    int isDeletingEventually;
    private String localId;
    final Object mutex;
    private String objectId;
    final LinkedList operationSetQueue;
    private final ParseMulticastDelegate saveEvent;
    private final Map serverData;
    final TaskQueue taskQueue;
    private Date updatedAt;

    protected ParseObject()
    {
        this("_Automatic");
    }

    public ParseObject(String s)
    {
        saveEvent = new ParseMulticastDelegate();
        mutex = new Object();
        taskQueue = new TaskQueue();
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
        localId = null;
        serverData = new HashMap();
        operationSetQueue = new LinkedList();
        operationSetQueue.add(new ParseOperationSet());
        estimatedData = new HashMap();
        hashedObjects = new IdentityHashMap();
        dataAvailability = new HashMap();
        className = s1;
        if (s2 == null)
        {
            setDefaultValues();
            hasBeenFetched = true;
        } else
        {
            if (!s2.equals("*** Offline Object ***"))
            {
                objectId = s2;
            }
            hasBeenFetched = false;
        }
        s = OfflineStore.getCurrent();
        if (s != null)
        {
            s.registerNewObject(this);
        }
    }

    private void applyOperations(ParseOperationSet parseoperationset, Map map)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = parseoperationset.keySet().iterator();
_L1:
        String s;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        s = (String)iterator.next();
        obj1 = ((ParseFieldOperation)parseoperationset.get(s)).apply(map.get(s), this, s);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        map.put(s, obj1);
          goto _L1
        parseoperationset;
        obj;
        JVM INSTR monitorexit ;
        throw parseoperationset;
        map.remove(s);
          goto _L1
        obj;
        JVM INSTR monitorexit ;
    }

    private boolean canBeSerialized()
    {
        boolean flag;
        synchronized (mutex)
        {
            final Capture result = new Capture(Boolean.valueOf(true));
            (new ParseTraverser() {

                final ParseObject this$0;
                final Capture val$result;

                protected boolean visit(Object obj1)
                {
                    if ((obj1 instanceof ParseObject) && ((ParseObject)obj1).getObjectId() == null)
                    {
                        result.set(Boolean.valueOf(false));
                    }
                    return ((Boolean)result.get()).booleanValue();
                }

            
            {
                this$0 = ParseObject.this;
                result = capture;
                super();
            }
            }).setYieldRoot(false).setTraverseParseObjects(true).traverse(this);
            flag = ((Boolean)result.get()).booleanValue();
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
        if (!Parse.isContainerObject(obj))
        {
            break MISSING_BLOCK_LABEL_96;
        }
        parsejsoncacheitem = (ParseJSONCacheItem)hashedObjects.get(obj);
        if (parsejsoncacheitem != null)
        {
            break MISSING_BLOCK_LABEL_50;
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
            throw new IllegalStateException("ParseObject has no data for this key.  Call fetchIfNeeded() to get the data.");
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
        for (Iterator iterator = estimatedData.values().iterator(); iterator.hasNext(); checkpointMutableContainer(iterator.next())) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    private void checkpointMutableContainer(Object obj)
    {
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        boolean flag = Parse.isContainerObject(obj);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        ParseJSONCacheItem parsejsoncacheitem = new ParseJSONCacheItem(obj);
        hashedObjects.put(obj, parsejsoncacheitem);
        obj1;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private static void collectDirtyChildren(Object obj, List list, List list1)
    {
        collectDirtyChildren(obj, list, list1, new IdentityHashMap(), new IdentityHashMap());
    }

    private static void collectDirtyChildren(Object obj, List list, List list1, IdentityHashMap identityhashmap, IdentityHashMap identityhashmap1)
    {
        (new ParseTraverser(list1, identityhashmap, identityhashmap1, list) {

            final IdentityHashMap val$alreadySeen;
            final IdentityHashMap val$alreadySeenNew;
            final List val$dirtyChildren;
            final List val$dirtyFiles;

            protected boolean visit(Object obj1)
            {
                if (obj1 instanceof ParseFile)
                {
                    obj1 = (ParseFile)obj1;
                    if (((ParseFile) (obj1)).getUrl() == null)
                    {
                        dirtyFiles.add(obj1);
                    }
                } else
                if (obj1 instanceof ParseObject)
                {
                    ParseObject parseobject = (ParseObject)obj1;
                    IdentityHashMap identityhashmap2 = alreadySeen;
                    obj1 = alreadySeenNew;
                    if (parseobject.getObjectId() != null)
                    {
                        obj1 = new IdentityHashMap();
                    } else
                    {
                        if (((IdentityHashMap) (obj1)).containsKey(parseobject))
                        {
                            throw new RuntimeException("Found a circular dependency while saving.");
                        }
                        obj1 = new IdentityHashMap(((Map) (obj1)));
                        ((IdentityHashMap) (obj1)).put(parseobject, parseobject);
                    }
                    if (!identityhashmap2.containsKey(parseobject))
                    {
                        identityhashmap2 = new IdentityHashMap(identityhashmap2);
                        identityhashmap2.put(parseobject, parseobject);
                        ParseObject.collectDirtyChildren(parseobject.estimatedData, dirtyChildren, dirtyFiles, identityhashmap2, ((IdentityHashMap) (obj1)));
                        if (parseobject.isDirty(false))
                        {
                            dirtyChildren.add(parseobject);
                            return true;
                        }
                    }
                }
                return true;
            }

            
            {
                dirtyFiles = list;
                alreadySeen = identityhashmap;
                alreadySeenNew = identityhashmap1;
                dirtyChildren = list1;
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
                    if (((ParseObject) (obj)).objectId != null && ((ParseObject) (obj)).isDataAvailable())
                    {
                        fetchedObjects.put(((ParseObject) (obj)).objectId, obj);
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

    private ParseCommand constructDeleteCommand(boolean flag, String s)
        throws com.parse.ParseException
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        s = new ParseCommand("delete", s);
        s.enableRetrying();
        s.put("classname", className);
        jsonobject = new JSONObject();
        jsonobject.put("objectId", objectId);
        s.put("data", jsonobject);
        return s;
        s;
        throw new RuntimeException(s.getMessage());
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
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
        OfflineStore offlinestore = OfflineStore.getCurrent();
        if (s1 != null) goto _L2; else goto _L1
_L1:
        isCreatingPointerForObjectId.set("*** Offline Object ***");
_L8:
        if (offlinestore == null || s1 == null) goto _L4; else goto _L3
_L3:
        boolean flag;
        s1 = offlinestore.getOrCreateObjectWithoutData(s, s1);
        s = (ParseObject)((Pair) (s1)).first;
        flag = ((Boolean)((Pair) (s1)).second).booleanValue();
_L6:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s.hasChanges())
        {
            throw new IllegalStateException("A ParseObject subclass default constructor must not make changes to the object that cause it to be dirty.");
        }
        break; /* Loop/switch isn't completed */
        s;
        throw s;
        s;
        isCreatingPointerForObjectId.set(null);
        throw s;
_L2:
        isCreatingPointerForObjectId.set(s1);
        continue; /* Loop/switch isn't completed */
        s;
        throw new RuntimeException("Failed to create instance of subclass.", s);
_L4:
        s = create(s);
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        isCreatingPointerForObjectId.set(null);
        return s;
        if (true) goto _L8; else goto _L7
_L7:
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

    private static Task deepSaveAsync(Object obj, String s)
    {
        ArrayList arraylist = new ArrayList();
        Object obj1 = new ArrayList();
        collectDirtyChildren(obj, arraylist, ((List) (obj1)));
        obj = new ArrayList();
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(((ParseFile)((Iterator) (obj1)).next()).saveInBackground())) { }
        return Task.whenAll(((Collection) (obj))).onSuccessTask(new Continuation(arraylist, s) {

            final List val$objects;
            final String val$sessionToken;

            public Task then(Task task)
                throws Exception
            {
                task = new IdentityHashMap();
                for (Iterator iterator = objects.iterator(); iterator.hasNext(); task.put((ParseObject)iterator.next(), Boolean.valueOf(true))) { }
                task = new Capture(new ArrayList(task.keySet()));
                return Task.forResult(null).continueWhile(task. new Callable() {

                    final _cls37 this$0;
                    final Capture val$remaining;

                    public Boolean call()
                        throws Exception
                    {
                        boolean flag;
                        if (((List)remaining.get()).size() > 0)
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
                this$0 = final__pcls37;
                remaining = Capture.this;
                super();
            }
                }, task. new Continuation() {

                    final _cls37 this$0;
                    final Capture val$remaining;

                    public Task then(Task task)
                        throws Exception
                    {
                        final ArrayList current = new ArrayList();
                        task = new ArrayList();
                        for (Iterator iterator = ((List)remaining.get()).iterator(); iterator.hasNext();)
                        {
                            ParseObject parseobject = (ParseObject)iterator.next();
                            if (parseobject.canBeSerialized())
                            {
                                current.add(parseobject);
                            } else
                            {
                                task.add(parseobject);
                            }
                        }

                        remaining.set(task);
                        if (current.size() == 0)
                        {
                            throw new RuntimeException("Unable to save a PFObject with a relation to a cycle.");
                        }
                        Task task1 = Task.forResult(null);
                        task = task1;
                        if (ParseUser.getCurrentUser() != null)
                        {
                            task = task1;
                            if (ParseUser.getCurrentUser().isLazy())
                            {
                                task = task1;
                                if (current.contains(ParseUser.getCurrentUser()))
                                {
                                    task = task1.onSuccessTask(new Continuation() {

                                        final _cls2 this$1;

                                        public Task then(Task task)
                                            throws Exception
                                        {
                                            return ParseUser.getCurrentUser().saveInBackground();
                                        }

                                        public volatile Object then(Task task)
                                            throws Exception
                                        {
                                            return then(task);
                                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                                    }).onSuccess(current. new Continuation() {

                                        final _cls2 this$1;
                                        final List val$current;

                                        public volatile Object then(Task task)
                                            throws Exception
                                        {
                                            return then(task);
                                        }

                                        public Void then(Task task)
                                            throws Exception
                                        {
                                            current.remove(ParseUser.getCurrentUser());
                                            return null;
                                        }

            
            {
                this$1 = final__pcls2;
                current = List.this;
                super();
            }
                                    });
                                }
                            }
                        }
                        return task.onSuccessTask((new ArrayList()). new Continuation() {

                            final _cls2 this$1;
                            final List val$current;
                            final List val$operations;

                            public Task then(Task task)
                                throws Exception
                            {
                                if (current.size() == 0)
                                {
                                    return Task.forResult(null);
                                } else
                                {
                                    return ParseObject.enqueueForAll(current, new Continuation() {

                                        final _cls3 this$2;

                                        public Task then(Task task)
                                            throws Exception
                                        {
                                            for (Iterator iterator = current.iterator(); iterator.hasNext();)
                                            {
                                                ParseObject parseobject = (ParseObject)iterator.next();
                                                synchronized (parseobject.mutex)
                                                {
                                                    parseobject.validateSave();
                                                    operations.add(parseobject.startSave());
                                                }
                                            }

                                            break MISSING_BLOCK_LABEL_74;
                                            task;
                                            obj;
                                            JVM INSTR monitorexit ;
                                            throw task;
                                            return task.continueWithTask(new Continuation() {

                                                final _cls1 this$3;

                                                public Task then(Task task)
                                                    throws Exception
                                                {
                                                    task = new JSONArray();
                                                    for (int i = 0; i < current.size(); i++)
                                                    {
                                                        task.put(((ParseObject)current.get(i)).constructSaveCommand((ParseOperationSet)operations.get(i), PointerEncodingStrategy.get(), sessionToken).toJSONObject());
                                                    }

                                                    ParseCommand parsecommand = new ParseCommand("multi", sessionToken);
                                                    parsecommand.put("commands", task);
                                                    return parsecommand.executeAsync().cast().onSuccessTask(new Continuation() {

                                                        final _cls1 this$4;

                                                        public Task then(Task task)
                                                            throws Exception
                                                        {
                                                            ArrayList arraylist = new ArrayList();
                                                            for (int i = 0; i < current.size(); i++)
                                                            {
                                                                JSONObject jsonobject = ((JSONArray)task.getResult()).getJSONObject(i);
                                                                arraylist.add(((ParseObject)current.get(i)).handleSaveResultAsync(jsonobject, (ParseOperationSet)operations.get(i)));
                                                            }

                                                            return Task.whenAll(arraylist).continueWithTask(arraylist. new Continuation() {

                                                                final _cls1 this$5;
                                                                final List val$tasks;

                                                                public Task then(Task task)
                                                                    throws Exception
                                                                {
label0:
                                                                    {
                                                                        if (!task.isFaulted())
                                                                        {
                                                                            break label0;
                                                                        }
                                                                        Iterator iterator = tasks.iterator();
                                                                        Task task1;
                                                                        do
                                                                        {
                                                                            if (!iterator.hasNext())
                                                                            {
                                                                                break label0;
                                                                            }
                                                                            task1 = (Task)iterator.next();
                                                                        } while (!task1.isFaulted());
                                                                        return task1;
                                                                    }
                                                                    return task;
                                                                }

                                                                public volatile Object then(Task task)
                                                                    throws Exception
                                                                {
                                                                    return then(task);
                                                                }

            
            {
                this$5 = final__pcls1;
                tasks = List.this;
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
                this$4 = _cls1.this;
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
                this$3 = _cls1.this;
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
                this$2 = _cls3.this;
                super();
            }
                                    });
                                }
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$1 = final__pcls2;
                current = list;
                operations = List.this;
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
                this$0 = final__pcls37;
                remaining = Capture.this;
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
                objects = list;
                sessionToken = s;
                super();
            }
        });
    }

    public static void deleteAll(List list)
        throws com.parse.ParseException
    {
        Parse.waitForTask(deleteAllAsync(list, ParseUser.getCurrentSessionToken()));
    }

    private static Task deleteAllAsync(List list, String s)
    {
        ArrayList arraylist = new ArrayList();
        HashSet hashset = new HashSet();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ParseObject parseobject = (ParseObject)list.next();
            if (!hashset.contains(parseobject.getObjectId()))
            {
                hashset.add(parseobject.getObjectId());
                arraylist.add(parseobject);
            }
        } while (true);
        return Task.forResult(null).continueWithTask(new Continuation(arraylist, s) {

            final String val$sessionToken;
            final List val$uniqueObjects;

            public Task then(Task task)
                throws Exception
            {
                if (uniqueObjects.size() == 0)
                {
                    return Task.forResult(null);
                } else
                {
                    return ParseObject.enqueueForAll(uniqueObjects, new Continuation() {

                        final _cls34 this$0;

                        public Task then(Task task)
                            throws Exception
                        {
                            return task.continueWithTask(new Continuation() {

                                final _cls1 this$1;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    task = new JSONArray();
                                    for (Iterator iterator = uniqueObjects.iterator(); iterator.hasNext(); task.put(((ParseObject)iterator.next()).constructDeleteCommand(true, sessionToken).toJSONObject())) { }
                                    ParseCommand parsecommand = new ParseCommand("multi", sessionToken);
                                    parsecommand.put("commands", task);
                                    return parsecommand.executeAsync().makeVoid();
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$1 = _cls1.this;
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
                this$0 = _cls34.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                uniqueObjects = list;
                sessionToken = s;
                super();
            }
        });
    }

    public static Task deleteAllInBackground(List list)
    {
        return deleteAllAsync(list, ParseUser.getCurrentSessionToken());
    }

    public static void deleteAllInBackground(List list, DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(deleteAllInBackground(list), deletecallback);
    }

    private Task deleteAsync(Task task)
    {
        final String sessionToken = ParseUser.getCurrentSessionToken();
        return Task.forResult(null).onSuccessTask(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task1)
                throws Exception
            {
                Object obj = mutex;
                obj;
                JVM INSTR monitorenter ;
                validateDelete();
                if (objectId == null)
                {
                    return null;
                }
                obj;
                JVM INSTR monitorexit ;
                return task1;
                task1;
                obj;
                JVM INSTR monitorexit ;
                throw task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        }).onSuccessTask(TaskQueue.waitFor(task)).onSuccessTask(new Continuation() {

            final ParseObject this$0;
            final String val$sessionToken;

            public Task then(Task task1)
                throws Exception
            {
                return deleteAsync(sessionToken);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseObject.this;
                sessionToken = s;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task1)
                throws Exception
            {
                return handleDeleteResultAsync(task1.getResult());
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    static Task enqueueForAll(List list, Continuation continuation)
    {
        Object obj;
        bolts.Task.TaskCompletionSource taskcompletionsource;
        taskcompletionsource = Task.create();
        obj = new ArrayList(list.size());
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).add(((ParseObject)iterator.next()).taskQueue.getLock())) { }
        obj = new LockSet(((Collection) (obj)));
        ((LockSet) (obj)).lock();
        continuation = (Task)continuation.then(taskcompletionsource.getTask());
        ArrayList arraylist;
        arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); ((ParseObject)list.next()).taskQueue.enqueue(new Continuation(arraylist, continuation) {

        final List val$childTasks;
        final Task val$fullTask;

        public Task then(Task task)
            throws Exception
        {
            childTasks.add(task);
            return fullTask;
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                childTasks = list;
                fullTask = task;
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
        Task.whenAll(arraylist).continueWith(new Continuation(taskcompletionsource) {

            final bolts.Task.TaskCompletionSource val$readyToStart;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                readyToStart.setResult(null);
                return null;
            }

            
            {
                readyToStart = taskcompletionsource;
                super();
            }
        });
        ((LockSet) (obj)).unlock();
        return continuation;
    }

    private Task enqueueSaveEventuallyOperationAsync(final ParseOperationSet operationSet)
    {
        if (!operationSet.isSaveEventually())
        {
            throw new IllegalStateException("This should only be used to enqueue saveEventually operation sets");
        } else
        {
            return taskQueue.enqueue(new Continuation() {

                final ParseObject this$0;
                final ParseOperationSet val$operationSet;

                public Task then(Task task)
                    throws Exception
                {
                    return task.continueWithTask(new Continuation() {

                        final _cls14 this$1;

                        public Task then(Task task)
                            throws Exception
                        {
                            return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).makeVoid();
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = _cls14.this;
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
                this$0 = ParseObject.this;
                operationSet = parseoperationset;
                super();
            }
            });
        }
    }

    public static List fetchAll(List list)
        throws com.parse.ParseException
    {
        return (List)Parse.waitForTask(fetchAllInBackground(list));
    }

    private static Task fetchAllAsync(List list, ParseUser parseuser, Task task)
    {
        if (list.size() == 0)
        {
            return Task.forResult(list);
        }
        ArrayList arraylist = new ArrayList();
        Object obj = ((ParseObject)list.get(0)).getClassName();
        ParseObject parseobject;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(parseobject.getObjectId()))
        {
            parseobject = (ParseObject)iterator.next();
            if (!parseobject.getClassName().equals(obj))
            {
                throw new IllegalArgumentException("All objects should have the same class");
            }
            if (parseobject.getObjectId() == null)
            {
                throw new IllegalArgumentException("All objects must exist on the server");
            }
        }

        obj = ParseQuery.getQuery(((String) (obj)));
        ((ParseQuery) (obj)).whereContainedIn("objectId", arraylist);
        return task.continueWithTask(new Continuation(((ParseQuery) (obj)), parseuser) {

            final ParseQuery val$query;
            final ParseUser val$user;

            public Task then(Task task1)
                throws Exception
            {
                return query.findWithCachePolicyAsync(ParseQuery.CachePolicy.IGNORE_CACHE, user);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                query = parsequery;
                user = parseuser;
                super();
            }
        }).onSuccess(new Continuation(list) {

            final List val$objects;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public List then(Task task1)
                throws Exception
            {
                HashMap hashmap = new HashMap();
                ParseObject parseobject1;
                for (task1 = ((List)task1.getResult()).iterator(); task1.hasNext(); hashmap.put(parseobject1.getObjectId(), parseobject1))
                {
                    parseobject1 = (ParseObject)task1.next();
                }

                for (task1 = objects.iterator(); task1.hasNext();)
                {
                    ParseObject parseobject2 = (ParseObject)task1.next();
                    ParseObject parseobject3 = (ParseObject)hashmap.get(parseobject2.getObjectId());
                    if (parseobject3 == null)
                    {
                        throw new RuntimeException((new StringBuilder()).append("Object id ").append(parseobject2.getObjectId()).append(" does not exist").toString());
                    }
                    parseobject2.mergeFromObject(parseobject3);
                    parseobject2.hasBeenFetched = true;
                }

                return objects;
            }

            
            {
                objects = list;
                super();
            }
        });
    }

    public static List fetchAllIfNeeded(List list)
        throws com.parse.ParseException
    {
        return (List)Parse.waitForTask(fetchAllIfNeededInBackground(list));
    }

    private static Task fetchAllIfNeededAsync(List list, ParseUser parseuser, Task task)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = null;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (ParseObject)iterator.next();
            if (!((ParseObject) (obj1)).isDataAvailable())
            {
                if (obj != null && !((String) (obj)).equals(((ParseObject) (obj1)).getClassName()))
                {
                    throw new IllegalArgumentException("All objects should have the same class");
                }
                String s = ((ParseObject) (obj1)).getClassName();
                obj1 = ((ParseObject) (obj1)).getObjectId();
                obj = s;
                if (obj1 != null)
                {
                    arraylist.add(obj1);
                    obj = s;
                }
            }
        } while (true);
        if (arraylist.size() == 0)
        {
            return Task.forResult(list);
        } else
        {
            obj = ParseQuery.getQuery(((String) (obj)));
            ((ParseQuery) (obj)).whereContainedIn("objectId", arraylist);
            return task.continueWithTask(new Continuation(((ParseQuery) (obj)), parseuser) {

                final ParseQuery val$query;
                final ParseUser val$user;

                public Task then(Task task1)
                    throws Exception
                {
                    return query.findWithCachePolicyAsync(ParseQuery.CachePolicy.IGNORE_CACHE, user);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                query = parsequery;
                user = parseuser;
                super();
            }
            }).onSuccess(new Continuation(list) {

                final List val$objects;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public List then(Task task1)
                    throws Exception
                {
                    HashMap hashmap = new HashMap();
                    ParseObject parseobject;
                    for (task1 = ((List)task1.getResult()).iterator(); task1.hasNext(); hashmap.put(parseobject.getObjectId(), parseobject))
                    {
                        parseobject = (ParseObject)task1.next();
                    }

                    task1 = objects.iterator();
                    do
                    {
                        if (!task1.hasNext())
                        {
                            break;
                        }
                        ParseObject parseobject1 = (ParseObject)task1.next();
                        if (!parseobject1.isDataAvailable())
                        {
                            ParseObject parseobject2 = (ParseObject)hashmap.get(parseobject1.getObjectId());
                            if (parseobject2 == null)
                            {
                                throw new RuntimeException((new StringBuilder()).append("Object id ").append(parseobject1.getObjectId()).append(" does not exist").toString());
                            }
                            parseobject1.mergeFromObject(parseobject2);
                            parseobject1.hasBeenFetched = true;
                        }
                    } while (true);
                    return objects;
                }

            
            {
                objects = list;
                super();
            }
            });
        }
    }

    public static Task fetchAllIfNeededInBackground(List list)
    {
        return enqueueForAll(list, new Continuation(list, ParseUser.getCurrentUser()) {

            final List val$objects;
            final ParseUser val$user;

            public Task then(Task task)
                throws Exception
            {
                return ParseObject.fetchAllIfNeededAsync(objects, user, task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                objects = list;
                user = parseuser;
                super();
            }
        });
    }

    public static void fetchAllIfNeededInBackground(List list, FindCallback findcallback)
    {
        Parse.callbackOnMainThreadAsync(fetchAllIfNeededInBackground(list), findcallback);
    }

    public static Task fetchAllInBackground(List list)
    {
        return enqueueForAll(list, new Continuation(list, ParseUser.getCurrentUser()) {

            final List val$objects;
            final ParseUser val$user;

            public Task then(Task task)
                throws Exception
            {
                return ParseObject.fetchAllAsync(objects, user, task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                objects = list;
                user = parseuser;
                super();
            }
        });
    }

    public static void fetchAllInBackground(List list, FindCallback findcallback)
    {
        Parse.callbackOnMainThreadAsync(fetchAllInBackground(list), findcallback);
    }

    private static void findUnsavedChildren(Object obj, List list)
    {
        if (obj instanceof List)
        {
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); findUnsavedChildren(((Iterator) (obj)).next(), list)) { }
        } else
        if (obj instanceof Map)
        {
            for (obj = ((Map)obj).values().iterator(); ((Iterator) (obj)).hasNext(); findUnsavedChildren(((Iterator) (obj)).next(), list)) { }
        } else
        if (obj instanceof ParseObject)
        {
            obj = (ParseObject)obj;
            if (((ParseObject) (obj)).isDirty())
            {
                list.add(obj);
            }
        }
    }

    static ParseObject fromJSON(JSONObject jsonobject, String s, boolean flag)
    {
        return fromJSON(jsonobject, s, flag, new ParseDecoder());
    }

    static ParseObject fromJSON(JSONObject jsonobject, String s, boolean flag, ParseDecoder parsedecoder)
    {
        JSONObject jsonobject1 = jsonobject.optJSONObject("data");
        String s2 = null;
        String s1 = null;
        if (jsonobject1 != null)
        {
            s2 = jsonobject1.optString("objectId", null);
            s1 = jsonobject1.optString("classname", s);
        }
        s = createWithoutData(s1, s2);
        s.mergeAfterFetch(jsonobject, parsedecoder, flag);
        return s;
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
            break MISSING_BLOCK_LABEL_35;
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
        if (!(obj1 instanceof ParseACL))
        {
            throw new RuntimeException("only ACLs can be stored in the ACL key");
        }
        break MISSING_BLOCK_LABEL_58;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (!((ParseACL)obj1).isShared())
        {
            break MISSING_BLOCK_LABEL_103;
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

    static String getApplicationId()
    {
        Parse.checkInit();
        return Parse.applicationId;
    }

    static String getClassName(Class class1)
    {
        String s = (String)classNames.get(class1);
        Object obj = s;
        if (s == null)
        {
            obj = (ParseClassName)class1.getAnnotation(com/parse/ParseClassName);
            if (obj == null)
            {
                return null;
            }
            obj = ((ParseClassName) (obj)).value();
            classNames.put(class1, obj);
        }
        return ((String) (obj));
    }

    static ParseObject getFromDisk(Context context, String s)
    {
        if (OfflineStore.isEnabled())
        {
            throw new IllegalStateException("ParseObject#getFromDisk is not allowed when OfflineStore is enabled");
        }
        context = Parse.getDiskObject(context, s);
        if (context == null)
        {
            return null;
        }
        try
        {
            s = createWithoutData(context.getString("classname"), null);
            s.mergeFromServer(context, new ParseDecoder(), true);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return s;
    }

    private Task handleDeleteResultAsync(Object obj)
    {
        Task task;
        boolean flag;
        flag = true;
        task = Task.forResult(null);
        final Object store = mutex;
        store;
        JVM INSTR monitorenter ;
        if (obj == null)
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        isDeleted = true;
        store;
        JVM INSTR monitorexit ;
        store = OfflineStore.getCurrent();
        obj = task;
        if (store != null)
        {
            obj = task.continueWithTask(new Continuation() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public Task then(Task task1)
                    throws Exception
                {
label0:
                    {
                        Task task2;
                        synchronized (mutex)
                        {
                            if (!isDeleted)
                            {
                                break label0;
                            }
                            task2 = store.deleteDataForObjectAsync(ParseObject.this);
                        }
                        return task2;
                    }
                    Task task3 = store.updateDataForObjectAsync(ParseObject.this);
                    task1;
                    JVM INSTR monitorexit ;
                    return task3;
                    exception;
                    task1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            });
        }
        return ((Task) (obj));
        obj;
        store;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private boolean hasDirtyChildren()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        findUnsavedChildren(estimatedData, arraylist);
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

    private static Date impreciseParseDate(String s)
    {
        com/parse/ParseObject;
        JVM INSTR monitorenter ;
        Date date = impreciseDateFormat.parse(s);
        s = date;
_L2:
        com/parse/ParseObject;
        JVM INSTR monitorexit ;
        return s;
        ParseException parseexception;
        parseexception;
        Parse.logE("com.parse.ParseObject", (new StringBuilder()).append("could not parse date: ").append(s).toString(), parseexception);
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
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

    private void mergeAfterSave(JSONObject jsonobject, ParseDecoder parsedecoder, ParseOperationSet parseoperationset)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        obj1 = operationSetQueue.listIterator(operationSetQueue.indexOf(parseoperationset));
        ((ListIterator) (obj1)).next();
        ((ListIterator) (obj1)).remove();
        obj1 = (ParseOperationSet)((ListIterator) (obj1)).next();
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ((ParseOperationSet) (obj1)).mergeFrom(parseoperationset);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        applyOperations(parseoperationset, serverData);
        mergeFromServer(jsonobject, parsedecoder, false);
        rebuildEstimatedData();
        checkpointAllMutableContainers();
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject;
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    public static void pinAll(String s, List list)
        throws com.parse.ParseException
    {
        Parse.waitForTask(pinAllInBackground(s, list));
    }

    public static void pinAll(List list)
        throws com.parse.ParseException
    {
        Parse.waitForTask(pinAllInBackground("_default", list));
    }

    public static Task pinAllInBackground(String s, List list)
    {
        return ParsePin.pinAllObjectsAsync(s, list);
    }

    public static Task pinAllInBackground(List list)
    {
        return pinAllInBackground("_default", list);
    }

    public static void pinAllInBackground(String s, List list, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(pinAllInBackground(s, list), savecallback);
    }

    public static void pinAllInBackground(List list, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(pinAllInBackground("_default", list), savecallback);
    }

    private void rebuildEstimatedData()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        estimatedData.clear();
        estimatedData.putAll(serverData);
        for (Iterator iterator = operationSetQueue.iterator(); iterator.hasNext(); applyOperations((ParseOperationSet)iterator.next(), estimatedData)) { }
        break MISSING_BLOCK_LABEL_71;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    static void registerParseSubclasses()
    {
        registerSubclass(com/parse/ParseUser);
        registerSubclass(com/parse/ParseRole);
        registerSubclass(com/parse/ParseInstallation);
        registerSubclass(com/parse/ParsePin);
        registerSubclass(com/parse/EventuallyPin);
    }

    public static void registerSubclass(Class class1)
    {
        Object obj = getClassName(class1);
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No ParseClassName annoation provided on ").append(class1).toString());
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
        throws com.parse.ParseException
    {
        Parse.waitForTask(saveAllInBackground(list));
    }

    public static Task saveAllInBackground(List list)
    {
        return deepSaveAsync(list, ParseUser.getCurrentSessionToken());
    }

    public static void saveAllInBackground(List list, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(saveAllInBackground(list), savecallback);
    }

    private void setObjectIdInternal(String s)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s1;
        OfflineStore offlinestore;
        s1 = objectId;
        offlinestore = OfflineStore.getCurrent();
        if (offlinestore == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        offlinestore.updateObjectId(this, s1, s);
        objectId = s;
        if (localId != null)
        {
            LocalIdManager.getDefaultInstance().setObjectId(localId, objectId);
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

    public static void unpinAll()
        throws com.parse.ParseException
    {
        Parse.waitForTask(unpinAllInBackground());
    }

    public static void unpinAll(String s)
        throws com.parse.ParseException
    {
        Parse.waitForTask(unpinAllInBackground(s));
    }

    public static void unpinAll(String s, List list)
        throws com.parse.ParseException
    {
        Parse.waitForTask(unpinAllInBackground(s, list));
    }

    public static void unpinAll(List list)
        throws com.parse.ParseException
    {
        Parse.waitForTask(unpinAllInBackground("_default", list));
    }

    public static Task unpinAllInBackground()
    {
        return unpinAllInBackground("_default");
    }

    public static Task unpinAllInBackground(String s)
    {
        return ParsePin.unpinAllObjectsAsync(s);
    }

    public static Task unpinAllInBackground(String s, List list)
    {
        return ParsePin.unpinAllObjectsAsync(s, list);
    }

    public static Task unpinAllInBackground(List list)
    {
        return unpinAllInBackground("_default", list);
    }

    public static void unpinAllInBackground(DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(unpinAllInBackground(), deletecallback);
    }

    public static void unpinAllInBackground(String s, DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(unpinAllInBackground(s), deletecallback);
    }

    public static void unpinAllInBackground(String s, List list, DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(unpinAllInBackground(s, list), deletecallback);
    }

    public static void unpinAllInBackground(List list, DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(unpinAllInBackground("_default", list), deletecallback);
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

    void addToHashedObjects(Object obj)
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

    public void addUnique(String s, Object obj)
    {
        addAllUnique(s, Arrays.asList(new Object[] {
            obj
        }));
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

    ParseCommand constructSaveCommand(ParseOperationSet parseoperationset, ParseObjectEncodingStrategy parseobjectencodingstrategy, String s)
        throws com.parse.ParseException
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        parseobjectencodingstrategy = toJSONObjectForSaving(parseoperationset, parseobjectencodingstrategy);
        if (objectId == null)
        {
            parseoperationset = "create";
        } else
        {
            parseoperationset = "update";
        }
        parseoperationset = new ParseCommand(parseoperationset, s);
        parseoperationset.enableRetrying();
        parseoperationset.put("classname", className);
        parseoperationset.put("data", parseobjectencodingstrategy.getJSONObject("data"));
        obj;
        JVM INSTR monitorexit ;
        return parseoperationset;
        parseoperationset;
        throw new RuntimeException("could not decode data");
        parseoperationset;
        obj;
        JVM INSTR monitorexit ;
        throw parseoperationset;
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
        throws com.parse.ParseException
    {
        Parse.waitForTask(deleteInBackground());
    }

    Task deleteAsync(String s)
        throws com.parse.ParseException
    {
        return constructDeleteCommand(true, s).executeAsync();
    }

    public final Task deleteEventually()
    {
        Object obj2 = mutex;
        obj2;
        JVM INSTR monitorenter ;
        validateDelete();
        isDeletingEventually = isDeletingEventually + 1;
        Object obj = null;
        Object obj1;
        if (getObjectId() == null)
        {
            obj = getOrCreateLocalId();
        }
        obj1 = OfflineStore.getCurrent();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj1 = ((OfflineStore) (obj1)).updateDataForObjectAsync(this);
_L4:
        final ParseCommand command = constructDeleteCommand(false, ParseUser.getCurrentSessionToken());
        command.setLocalId(((String) (obj)));
        obj = ((Task) (obj1)).continueWithTask(new Continuation() {

            final ParseObject this$0;
            final ParseCommand val$command;

            public Task then(Task task)
                throws Exception
            {
                return Parse.getEventuallyQueue().enqueueEventuallyAsync(command, ParseObject.this);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseObject.this;
                command = parsecommand;
                super();
            }
        });
        obj2;
        JVM INSTR monitorexit ;
        if (OfflineStore.isEnabled())
        {
            return ((Task) (obj)).makeVoid();
        } else
        {
            return ((Task) (obj)).onSuccessTask(new Continuation() {

                final ParseObject this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return handleDeleteEventuallyResultAsync(task.getResult());
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseObject.this;
                super();
            }
            });
        }
_L2:
        obj1 = Task.forResult(null);
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw new IllegalStateException("Cannot deleteEventually this object.", ((Throwable) (obj)));
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public final void deleteEventually(DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(deleteEventually(), deletecallback);
    }

    public final Task deleteInBackground()
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task)
                throws Exception
            {
                return deleteAsync(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public final void deleteInBackground(DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(deleteInBackground(), deletecallback);
    }

    public ParseObject fetch()
        throws com.parse.ParseException
    {
        return (ParseObject)Parse.waitForTask(fetchInBackground());
    }

    Task fetchAsync(Task task)
    {
        return Task.call(new Callable() {

            final ParseObject this$0;
            final String val$sessionToken;

            public ParseCommand call()
                throws Exception
            {
                Object obj = mutex;
                obj;
                JVM INSTR monitorenter ;
                ParseCommand parsecommand;
                JSONObject jsonobject;
                parsecommand = new ParseCommand("get", sessionToken);
                parsecommand.enableRetrying();
                parsecommand.put("classname", className);
                jsonobject = new JSONObject();
                jsonobject.put("objectId", objectId);
                parsecommand.put("data", jsonobject);
                return parsecommand;
                Object obj1;
                obj1;
                throw new RuntimeException(((JSONException) (obj1)).getMessage());
                obj1;
                obj;
                JVM INSTR monitorexit ;
                throw obj1;
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseObject.this;
                sessionToken = s;
                super();
            }
        }).onSuccessTask(TaskQueue.waitFor(task)).onSuccessTask(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task1)
                throws Exception
            {
                return ((ParseCommand)task1.getResult()).executeAsync().cast();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task1)
                throws Exception
            {
                return handleFetchResultAsync((JSONObject)task1.getResult());
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        }).onSuccess(new Continuation() {

            final ParseObject this$0;

            public ParseObject then(Task task1)
                throws Exception
            {
                return ParseObject.this;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public void fetchFromLocalDatastore()
        throws com.parse.ParseException
    {
        Parse.waitForTask(fetchFromLocalDatastoreAsync());
    }

    Task fetchFromLocalDatastoreAsync()
    {
        OfflineStore offlinestore = OfflineStore.getCurrent();
        if (offlinestore == null)
        {
            throw new RuntimeException("You must enable the local datastore before calling fetchFromLocalDatastore().");
        } else
        {
            return offlinestore.fetchLocallyAsync(this);
        }
    }

    public void fetchFromLocalDatastoreInBackground(GetCallback getcallback)
    {
        Parse.callbackOnMainThreadAsync(fetchFromLocalDatastoreAsync(), getcallback);
    }

    public ParseObject fetchIfNeeded()
        throws com.parse.ParseException
    {
        return (ParseObject)Parse.waitForTask(fetchIfNeededInBackground());
    }

    public final Task fetchIfNeededInBackground()
    {
label0:
        {
            Task task;
            synchronized (mutex)
            {
                if (!isDataAvailable())
                {
                    break label0;
                }
                task = Task.forResult(this);
            }
            return task;
        }
        Task task1 = fetchInBackground();
        obj;
        JVM INSTR monitorexit ;
        return task1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void fetchIfNeededInBackground(GetCallback getcallback)
    {
        Parse.callbackOnMainThreadAsync(fetchIfNeededInBackground(), getcallback);
    }

    public final Task fetchInBackground()
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task)
                throws Exception
            {
                return fetchAsync(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public final void fetchInBackground(GetCallback getcallback)
    {
        Parse.callbackOnMainThreadAsync(fetchInBackground(), getcallback);
    }

    public Object get(String s)
    {
        Object obj1;
label0:
        {
            synchronized (mutex)
            {
                checkGetAccess(s);
                obj1 = estimatedData.get(s);
                if (!(obj1 instanceof ParseACL) || !s.equals("ACL"))
                {
                    break label0;
                }
                ParseACL parseacl = (ParseACL)obj1;
                if (!parseacl.isShared())
                {
                    break label0;
                }
                s = parseacl.copy();
                estimatedData.put("ACL", s);
                addToHashedObjects(s);
                s = getACL();
            }
            return s;
        }
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
            s = className;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Date getCreatedAt()
    {
        Date date;
        synchronized (mutex)
        {
            date = createdAt;
        }
        return date;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
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
            obj = Parse.encode(obj1, PointerOrLocalIdEncodingStrategy.get());
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
            obj = Parse.encode(obj1, PointerOrLocalIdEncodingStrategy.get());
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
            obj = (new ParseDecoder()).convertJSONArrayToList((JSONArray)obj1);
            put(s, obj);
        }
        if (obj instanceof List)
        {
            break MISSING_BLOCK_LABEL_62;
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
            obj = (new ParseDecoder()).convertJSONObjectToMap((JSONObject)obj1);
            put(s, obj);
        }
        if (obj instanceof Map)
        {
            break MISSING_BLOCK_LABEL_62;
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
            s = objectId;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    String getOrCreateLocalId()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (localId != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        if (objectId != null)
        {
            throw new IllegalStateException("Attempted to get a localId for an object with an objectId.");
        }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        localId = LocalIdManager.getDefaultInstance().createLocalId();
        String s = localId;
        obj;
        JVM INSTR monitorexit ;
        this;
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
        Date date;
        synchronized (mutex)
        {
            date = updatedAt;
        }
        return date;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Task handleDeleteEventuallyResultAsync(final Object result)
    {
        synchronized (mutex)
        {
            isDeletingEventually = isDeletingEventually - 1;
        }
        return handleDeleteResultAsync(result).onSuccessTask(new Continuation() {

            final ParseObject this$0;
            final Object val$result;

            public Task then(Task task)
                throws Exception
            {
                boolean flag;
                if (result != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    Parse.getEventuallyQueue().notifyTestHelper(6);
                }
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseObject.this;
                result = obj;
                super();
            }
        });
        result;
        obj;
        JVM INSTR monitorexit ;
        throw result;
    }

    Task handleFetchResultAsync(final JSONObject result)
    {
        Task task1 = Task.forResult((Void)null);
        final Map fetchedObjects = collectFetchedObjects();
        final OfflineStore store = OfflineStore.getCurrent();
        Task task = task1;
        if (store != null)
        {
            task = task1.onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public Task then(Task task2)
                    throws Exception
                {
                    return store.fetchLocallyAsync(ParseObject.this).makeVoid();
                }

                public volatile Object then(Task task2)
                    throws Exception
                {
                    return then(task2);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            }).continueWithTask(new Continuation() {

                final ParseObject this$0;

                public Task then(Task task2)
                    throws Exception
                {
                    Task task3 = task2;
                    if (task2.getError() instanceof com.parse.ParseException)
                    {
                        task3 = task2;
                        if (((com.parse.ParseException)task2.getError()).getCode() == 120)
                        {
                            task3 = null;
                        }
                    }
                    return task3;
                }

                public volatile Object then(Task task2)
                    throws Exception
                {
                    return then(task2);
                }

            
            {
                this$0 = ParseObject.this;
                super();
            }
            });
        }
        task = task.onSuccessTask(new Continuation() {

            final ParseObject this$0;
            final Map val$fetchedObjects;
            final JSONObject val$result;

            public Task then(Task task2)
                throws Exception
            {
                synchronized (mutex)
                {
                    serverData.clear();
                    dataAvailability.clear();
                    KnownParseObjectDecoder knownparseobjectdecoder = new KnownParseObjectDecoder(fetchedObjects);
                    mergeAfterFetch(result, knownparseobjectdecoder, true);
                }
                return null;
                exception;
                task2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(Task task2)
                throws Exception
            {
                return then(task2);
            }

            
            {
                this$0 = ParseObject.this;
                fetchedObjects = map;
                result = jsonobject;
                super();
            }
        });
        result = task;
        if (store != null)
        {
            result = task.onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public Task then(Task task2)
                    throws Exception
                {
                    return store.updateDataForObjectAsync(ParseObject.this);
                }

                public volatile Object then(Task task2)
                    throws Exception
                {
                    return then(task2);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            }).continueWithTask(new Continuation() {

                final ParseObject this$0;

                public Task then(Task task2)
                    throws Exception
                {
                    Task task3 = task2;
                    if (task2.getError() instanceof com.parse.ParseException)
                    {
                        task3 = task2;
                        if (((com.parse.ParseException)task2.getError()).getCode() == 120)
                        {
                            task3 = null;
                        }
                    }
                    return task3;
                }

                public volatile Object then(Task task2)
                    throws Exception
                {
                    return then(task2);
                }

            
            {
                this$0 = ParseObject.this;
                super();
            }
            });
        }
        return result;
    }

    Task handleSaveEventuallyResultAsync(JSONObject jsonobject, ParseOperationSet parseoperationset)
    {
        return handleSaveResultAsync(jsonobject, parseoperationset).onSuccessTask(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task)
                throws Exception
            {
                Parse.getEventuallyQueue().notifyTestHelper(5);
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    Task handleSaveResultAsync(final JSONObject result, final ParseOperationSet operationsBeforeSave)
    {
        Task task1 = Task.forResult((Void)null);
        final Map fetchedObjects = collectFetchedObjects();
        final OfflineStore store = OfflineStore.getCurrent();
        Task task = task1;
        if (store != null)
        {
            task = task1.onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public Task then(Task task2)
                    throws Exception
                {
                    return store.fetchLocallyAsync(ParseObject.this).makeVoid();
                }

                public volatile Object then(Task task2)
                    throws Exception
                {
                    return then(task2);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            });
        }
        operationsBeforeSave = task.continueWith(new Continuation() {

            final ParseObject this$0;
            final Map val$fetchedObjects;
            final ParseOperationSet val$operationsBeforeSave;
            final JSONObject val$result;

            public volatile Object then(Task task2)
                throws Exception
            {
                return then(task2);
            }

            public Void then(Task task2)
                throws Exception
            {
                synchronized (mutex)
                {
                    KnownParseObjectDecoder knownparseobjectdecoder = new KnownParseObjectDecoder(fetchedObjects);
                    mergeAfterSave(result, knownparseobjectdecoder, operationsBeforeSave);
                }
                return null;
                exception;
                task2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = ParseObject.this;
                fetchedObjects = map;
                result = jsonobject;
                operationsBeforeSave = parseoperationset;
                super();
            }
        });
        result = operationsBeforeSave;
        if (store != null)
        {
            result = operationsBeforeSave.onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final OfflineStore val$store;

                public Task then(Task task2)
                    throws Exception
                {
                    return store.updateDataForObjectAsync(ParseObject.this);
                }

                public volatile Object then(Task task2)
                    throws Exception
                {
                    return then(task2);
                }

            
            {
                this$0 = ParseObject.this;
                store = offlinestore;
                super();
            }
            });
        }
        return result.onSuccess(new Continuation() {

            final ParseObject this$0;

            public volatile Object then(Task task2)
                throws Exception
            {
                return then(task2);
            }

            public Void then(Task task2)
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

    public boolean isDataAvailable()
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = hasBeenFetched;
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

    void mergeAfterFetch(JSONObject jsonobject, ParseDecoder parsedecoder, boolean flag)
    {
        synchronized (mutex)
        {
            mergeFromServer(jsonobject, parsedecoder, flag);
            rebuildEstimatedData();
            checkpointAllMutableContainers();
        }
        return;
        jsonobject;
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
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
        objectId = parseobject.objectId;
        createdAt = parseobject.createdAt;
        updatedAt = parseobject.updatedAt;
        serverData.clear();
        serverData.putAll(parseobject.serverData);
        if (operationSetQueue.size() != 1)
        {
            throw new IllegalStateException("Attempt to mergeFromObject during a save.");
        }
        break MISSING_BLOCK_LABEL_88;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
        operationSetQueue.clear();
        operationSetQueue.add(new ParseOperationSet());
        rebuildEstimatedData();
        checkpointAllMutableContainers();
        obj;
        JVM INSTR monitorexit ;
    }

    void mergeFromServer(JSONObject jsonobject, ParseDecoder parsedecoder, boolean flag)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        Object obj2;
        if (!hasBeenFetched && !flag)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        hasBeenFetched = flag;
        if (jsonobject.has("id") && objectId == null)
        {
            setObjectIdInternal(jsonobject.getString("id"));
        }
        if (!jsonobject.has("created_at"))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj1 = jsonobject.getString("created_at");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        createdAt = impreciseParseDate(((String) (obj1)));
        if (!jsonobject.has("updated_at"))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj1 = jsonobject.getString("updated_at");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        updatedAt = impreciseParseDate(((String) (obj1)));
        if (jsonobject.has("pointers"))
        {
            obj1 = jsonobject.getJSONObject("pointers");
            String s;
            JSONArray jsonarray;
            for (Iterator iterator = ((JSONObject) (obj1)).keys(); iterator.hasNext(); serverData.put(s, createWithoutData(jsonarray.optString(0), jsonarray.optString(1))))
            {
                s = (String)iterator.next();
                jsonarray = ((JSONObject) (obj1)).getJSONArray(s);
            }

        }
        break MISSING_BLOCK_LABEL_230;
        jsonobject;
        throw new RuntimeException(jsonobject);
        jsonobject;
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
        if (!jsonobject.has("data"))
        {
            break MISSING_BLOCK_LABEL_482;
        }
        jsonobject = jsonobject.getJSONObject("data");
        obj1 = jsonobject.keys();
_L3:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_482;
        }
        obj2 = (String)((Iterator) (obj1)).next();
        dataAvailability.put(obj2, Boolean.valueOf(true));
        if (!((String) (obj2)).equals("objectId")) goto _L2; else goto _L1
_L1:
        setObjectIdInternal(jsonobject.getString(((String) (obj2))));
          goto _L3
_L2:
label0:
        {
            if (!((String) (obj2)).equals("createdAt"))
            {
                break label0;
            }
            createdAt = Parse.stringToDate(jsonobject.getString(((String) (obj2))));
        }
          goto _L3
label1:
        {
            if (!((String) (obj2)).equals("updatedAt"))
            {
                break label1;
            }
            updatedAt = Parse.stringToDate(jsonobject.getString(((String) (obj2))));
        }
          goto _L3
        if (!((String) (obj2)).equals("ACL")) goto _L5; else goto _L4
_L4:
        obj2 = ParseACL.createACLFromJSONObject(jsonobject.getJSONObject(((String) (obj2))), parsedecoder);
        serverData.put("ACL", obj2);
        addToHashedObjects(obj2);
          goto _L3
_L5:
        if (((String) (obj2)).equals("__type") || ((String) (obj2)).equals("className")) goto _L3; else goto _L6
_L6:
        Object obj3 = parsedecoder.decode(jsonobject.get(((String) (obj2))));
        if (Parse.isContainerObject(obj3))
        {
            addToHashedObjects(obj3);
        }
        serverData.put(obj2, obj3);
          goto _L3
        if (updatedAt == null && createdAt != null)
        {
            updatedAt = createdAt;
        }
        rebuildEstimatedData();
        checkpointAllMutableContainers();
        obj;
        JVM INSTR monitorexit ;
    }

    void mergeREST(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        ArrayList arraylist = new ArrayList();
        Object obj3 = mutex;
        obj3;
        JVM INSTR monitorenter ;
        Iterator iterator = jsonobject.keys();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (String)iterator.next();
        dataAvailability.put(obj, Boolean.valueOf(true));
        if (((String) (obj)).equals("__type") || ((String) (obj)).equals("className")) goto _L4; else goto _L3
_L3:
        if (!((String) (obj)).equals("objectId")) goto _L6; else goto _L5
_L5:
        setObjectIdInternal(jsonobject.getString(((String) (obj))));
          goto _L4
_L11:
        throw new RuntimeException(jsonobject);
        obj3;
        JVM INSTR monitorexit ;
        throw jsonobject;
_L6:
label0:
        {
            if (!((String) (obj)).equals("createdAt"))
            {
                break label0;
            }
            createdAt = Parse.stringToDate(jsonobject.getString(((String) (obj))));
        }
          goto _L4
label1:
        {
            if (!((String) (obj)).equals("updatedAt"))
            {
                break label1;
            }
            updatedAt = Parse.stringToDate(jsonobject.getString(((String) (obj))));
        }
          goto _L4
label2:
        {
            if (!((String) (obj)).equals("isDeletingEventually"))
            {
                break label2;
            }
            isDeletingEventually = jsonobject.getInt(((String) (obj)));
        }
          goto _L4
label3:
        {
            if (!((String) (obj)).equals("ACL"))
            {
                break label3;
            }
            obj = ParseACL.createACLFromJSONObject(jsonobject.getJSONObject(((String) (obj))), parsedecoder);
            serverData.put("ACL", obj);
            addToHashedObjects(obj);
        }
          goto _L4
        if (!((String) (obj)).equals("__complete"))
        {
            break MISSING_BLOCK_LABEL_268;
        }
        Object obj1;
        ParseOperationSet parseoperationset;
        ParseOperationSet parseoperationset1;
        JSONArray jsonarray;
        int i;
        boolean flag;
        if (hasBeenFetched || jsonobject.getBoolean(((String) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasBeenFetched = flag;
          goto _L4
        if (!((String) (obj)).equals("__operations")) goto _L8; else goto _L7
_L7:
        parseoperationset1 = currentOperations();
        jsonarray = jsonobject.getJSONArray("__operations");
        if (jsonarray == null) goto _L10; else goto _L9
_L9:
        operationSetQueue.clear();
        obj = null;
        i = 0;
_L13:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_395;
        }
        parseoperationset = ParseOperationSet.fromRest(jsonarray.getJSONObject(i), parsedecoder);
        if (!parseoperationset.isSaveEventually())
        {
            break MISSING_BLOCK_LABEL_382;
        }
        obj1 = obj;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        operationSetQueue.add(obj);
        obj1 = null;
        arraylist.add(parseoperationset);
        operationSetQueue.add(parseoperationset);
        obj = obj1;
        break MISSING_BLOCK_LABEL_539;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_548;
        }
        try
        {
            parseoperationset.mergeFrom(((ParseOperationSet) (obj)));
            break MISSING_BLOCK_LABEL_548;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        finally { }
          goto _L11
        if (obj == null) goto _L10; else goto _L12
_L12:
        operationSetQueue.add(obj);
_L10:
        currentOperations().mergeFrom(parseoperationset1);
          goto _L4
_L8:
        Object obj2 = parsedecoder.decode(jsonobject.get(((String) (obj))));
        if (Parse.isContainerObject(obj2))
        {
            addToHashedObjects(obj2);
        }
        serverData.put(obj, obj2);
          goto _L4
_L2:
        if (updatedAt == null && createdAt != null)
        {
            updatedAt = createdAt;
        }
        rebuildEstimatedData();
        checkpointAllMutableContainers();
        obj3;
        JVM INSTR monitorexit ;
        for (jsonobject = arraylist.iterator(); jsonobject.hasNext(); enqueueSaveEventuallyOperationAsync((ParseOperationSet)jsonobject.next())) { }
        return;
_L14:
        i++;
          goto _L13
        obj = parseoperationset;
          goto _L14
    }

    boolean needsDefaultACL()
    {
        return true;
    }

    void performOperation(String s, ParseFieldOperation parsefieldoperation)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = parsefieldoperation.apply(estimatedData.get(s), this, s);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        estimatedData.put(s, obj1);
_L2:
        parsefieldoperation = parsefieldoperation.mergeWithPrevious((ParseFieldOperation)currentOperations().get(s));
        currentOperations().put(s, parsefieldoperation);
        checkpointMutableContainer(obj1);
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

    public void pin()
        throws com.parse.ParseException
    {
        Parse.waitForTask(pinInBackground());
    }

    public void pin(String s)
        throws com.parse.ParseException
    {
        Parse.waitForTask(pinInBackground(s));
    }

    public Task pinInBackground()
    {
        return pinAllInBackground("_default", Arrays.asList(new ParseObject[] {
            this
        }));
    }

    public Task pinInBackground(String s)
    {
        return pinAllInBackground(s, Arrays.asList(new ParseObject[] {
            this
        }));
    }

    public void pinInBackground(SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(pinInBackground(), savecallback);
    }

    public void pinInBackground(String s, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(pinInBackground(s), savecallback);
    }

    public void put(String s, Object obj)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key may not be null.");
        }
        if (obj == null)
        {
            throw new IllegalArgumentException("value may not be null.");
        }
        if (!Parse.isValidType(obj))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type for value: ").append(obj.getClass().toString()).toString());
        } else
        {
            performOperation(s, new ParseSetOperation(obj));
            return;
        }
    }

    public final void refresh()
        throws com.parse.ParseException
    {
        fetch();
    }

    public final void refreshInBackground(RefreshCallback refreshcallback)
    {
        Parse.callbackOnMainThreadAsync(fetchInBackground(), refreshcallback);
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

    public void removeAll(String s, Collection collection)
    {
        performOperation(s, new ParseRemoveOperation(collection));
    }

    void revert()
    {
        synchronized (mutex)
        {
            currentOperations().clear();
            rebuildEstimatedData();
            checkpointAllMutableContainers();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void save()
        throws com.parse.ParseException
    {
        Parse.waitForTask(saveInBackground());
    }

    Task saveAsync(Task task)
    {
        if (!isDirty())
        {
            return Task.forResult(null);
        } else
        {
            final Capture operations = new Capture();
            final String sessionToken = ParseUser.getCurrentSessionToken();
            return Task.forResult(null).onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final Capture val$operations;

                public Task then(Task task1)
                    throws Exception
                {
                    Object obj = mutex;
                    obj;
                    JVM INSTR monitorenter ;
                    validateSave();
                    operations.set(startSave());
                    if (!isDataAvailable("ACL") || getACL(false) == null || !getACL(false).hasUnresolvedUser())
                    {
                        break MISSING_BLOCK_LABEL_90;
                    }
                    task1 = ParseUser.getCurrentUser().saveInBackground().onSuccess(new Continuation() {

                        final _cls12 this$1;

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

                        public Void then(Task task)
                            throws Exception
                        {
                            if (getACL(false).hasUnresolvedUser())
                            {
                                throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                            } else
                            {
                                return null;
                            }
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                    return task1;
                    obj;
                    JVM INSTR monitorexit ;
                    return task1;
                    task1;
                    obj;
                    JVM INSTR monitorexit ;
                    throw task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseObject.this;
                operations = capture;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final String val$sessionToken;

                public Task then(Task task1)
                    throws Exception
                {
                    Task task2;
                    synchronized (mutex)
                    {
                        task2 = ParseObject.deepSaveAsync(estimatedData, sessionToken);
                    }
                    return task2;
                    exception;
                    task1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseObject.this;
                sessionToken = s;
                super();
            }
            }).onSuccessTask(TaskQueue.waitFor(task)).onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final Capture val$operations;
                final String val$sessionToken;

                public Task then(Task task1)
                    throws Exception
                {
                    return saveAsync((ParseOperationSet)operations.get(), sessionToken).continueWithTask(new Continuation() {

                        final _cls10 this$1;

                        public Task then(Task task)
                            throws Exception
                        {
                            JSONObject jsonobject = (JSONObject)task.getResult();
                            return handleSaveResultAsync(jsonobject, (ParseOperationSet)operations.get()).continueWithTask(task. new Continuation() {

                                final _cls1 this$2;
                                final Task val$saveTask;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    return saveTask.makeVoid();
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$2 = final__pcls1;
                saveTask = Task.this;
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
                this$1 = _cls10.this;
                super();
            }
                    });
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseObject.this;
                operations = capture;
                sessionToken = s;
                super();
            }
            });
        }
    }

    Task saveAsync(ParseOperationSet parseoperationset, String s)
        throws com.parse.ParseException
    {
        return constructSaveCommand(parseoperationset, PointerEncodingStrategy.get(), s).executeAsync();
    }

    public final Task saveEventually()
    {
        if (!isDirty())
        {
            Parse.getEventuallyQueue().fakeObjectUpdate();
            return Task.forResult(null);
        }
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        updateBeforeSave();
        arraylist = new ArrayList();
        findUnsavedChildren(estimatedData, arraylist);
        String s = null;
        final ParseOperationSet operationSet;
        Object obj2;
        if (getObjectId() == null)
        {
            s = getOrCreateLocalId();
        }
        operationSet = startSave();
        operationSet.setIsSaveEventually(true);
        obj2 = ParseUser.getCurrentSessionToken();
        obj2 = constructSaveCommand(operationSet, PointerOrLocalIdEncodingStrategy.get(), ((String) (obj2)));
        ((ParseCommand) (obj2)).setLocalId(s);
        ((ParseCommand) (obj2)).setOperationSetUUID(operationSet.getUUID());
        ((ParseCommand) (obj2)).retainLocalIds();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((ParseObject)iterator.next()).saveEventually()) { }
        break MISSING_BLOCK_LABEL_160;
        Object obj;
        obj;
        throw new IllegalStateException("Unable to saveEventually.", ((Throwable) (obj)));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj1;
        JVM INSTR monitorexit ;
        Task task = Parse.getEventuallyQueue().enqueueEventuallyAsync(((ParseCommand) (obj2)), this);
        enqueueSaveEventuallyOperationAsync(operationSet);
        ((ParseCommand) (obj2)).releaseLocalIds();
        if (OfflineStore.isEnabled())
        {
            return task.makeVoid();
        } else
        {
            return task.onSuccessTask(new Continuation() {

                final ParseObject this$0;
                final ParseOperationSet val$operationSet;

                public Task then(Task task1)
                    throws Exception
                {
                    task1 = (JSONObject)task1.getResult();
                    return handleSaveEventuallyResultAsync(task1, operationSet);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
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
        Parse.callbackOnMainThreadAsync(saveEventually(), savecallback);
    }

    public final Task saveInBackground()
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseObject this$0;

            public Task then(Task task)
                throws Exception
            {
                updateBeforeSave();
                return saveAsync(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseObject.this;
                super();
            }
        });
    }

    public final void saveInBackground(SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(saveInBackground(), savecallback);
    }

    void saveToDisk(Context context, String s)
    {
        if (OfflineStore.isEnabled())
        {
            throw new IllegalStateException("ParseObject#saveToDisk is not allowed when OfflineStore is enabled");
        }
        synchronized (mutex)
        {
            Parse.saveDiskObject(context, s, toJSONObjectForDataFile(false, PointerEncodingStrategy.get()));
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
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
        synchronized (mutex)
        {
            setObjectIdInternal(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
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

    JSONObject toJSONObjectForDataFile(boolean flag, ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        Object obj1;
        checkForChangesToMutableContainers();
        jsonobject = new JSONObject();
        obj1 = new JSONObject();
        Iterator iterator = serverData.keySet().iterator();
_L1:
        String s;
        Object obj2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_164;
            }
            s = (String)iterator.next();
            obj2 = serverData.get(s);
            if (!Parse.isContainerObject(obj2) || !hashedObjects.containsKey(obj2))
            {
                break MISSING_BLOCK_LABEL_147;
            }
            ((JSONObject) (obj1)).put(s, ((ParseJSONCacheItem)hashedObjects.get(obj2)).getJSONObject());
        } while (true);
        parseobjectencodingstrategy;
        throw new RuntimeException("could not serialize object to JSON");
        parseobjectencodingstrategy;
        obj;
        JVM INSTR monitorexit ;
        throw parseobjectencodingstrategy;
        ((JSONObject) (obj1)).put(s, Parse.encode(obj2, parseobjectencodingstrategy));
          goto _L1
        if (createdAt != null)
        {
            ((JSONObject) (obj1)).put("createdAt", Parse.dateToString(createdAt));
        }
        if (updatedAt != null)
        {
            ((JSONObject) (obj1)).put("updatedAt", Parse.dateToString(updatedAt));
        }
        if (objectId != null)
        {
            ((JSONObject) (obj1)).put("objectId", objectId);
        }
        jsonobject.put("data", obj1);
        jsonobject.put("classname", className);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        obj1 = new JSONArray();
        iterator = operationSetQueue.iterator();
_L2:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_379;
        }
        ParseOperationSet parseoperationset = (ParseOperationSet)iterator.next();
        obj2 = new JSONObject();
        String s1;
        for (Iterator iterator1 = parseoperationset.keySet().iterator(); iterator1.hasNext(); ((JSONObject) (obj2)).put(s1, ((ParseFieldOperation)parseoperationset.get(s1)).encode(parseobjectencodingstrategy)))
        {
            s1 = (String)iterator1.next();
        }

        ((JSONArray) (obj1)).put(obj2);
          goto _L2
        jsonobject.put("operations", obj1);
        obj;
        JVM INSTR monitorexit ;
        return jsonobject;
    }

    JSONObject toJSONObjectForSaving(ParseOperationSet parseoperationset, ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        JSONObject jsonobject1;
        jsonobject = new JSONObject();
        jsonobject1 = new JSONObject();
        try
        {
            Iterator iterator = parseoperationset.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                ParseFieldOperation parsefieldoperation = (ParseFieldOperation)parseoperationset.get(s);
                jsonobject1.put(s, Parse.encode(parsefieldoperation, parseobjectencodingstrategy));
                if (parsefieldoperation instanceof ParseSetOperation)
                {
                    Object obj1 = ((ParseSetOperation)parsefieldoperation).getValue();
                    if (Parse.isContainerObject(obj1) && hashedObjects.containsKey(obj1))
                    {
                        hashedObjects.put(obj1, new ParseJSONCacheItem(obj1));
                    }
                }
            } while (true);
            break MISSING_BLOCK_LABEL_164;
        }
        // Misplaced declaration of an exception variable
        catch (ParseOperationSet parseoperationset) { }
        throw new RuntimeException("could not serialize object to JSON");
        parseoperationset;
        obj;
        JVM INSTR monitorexit ;
        throw parseoperationset;
        if (objectId != null)
        {
            jsonobject1.put("objectId", objectId);
        }
        jsonobject.put("data", jsonobject1);
        jsonobject.put("classname", className);
        obj;
        JVM INSTR monitorexit ;
        return jsonobject;
    }

    JSONObject toRest(ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        checkForChangesToMutableContainers();
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("className", className);
            String s;
            for (Iterator iterator = serverData.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, Parse.encode(serverData.get(s), parseobjectencodingstrategy)))
            {
                s = (String)iterator.next();
            }

            break MISSING_BLOCK_LABEL_111;
        }
        // Misplaced declaration of an exception variable
        catch (ParseObjectEncodingStrategy parseobjectencodingstrategy) { }
        throw new RuntimeException("could not serialize object to JSON");
        parseobjectencodingstrategy;
        obj;
        JVM INSTR monitorexit ;
        throw parseobjectencodingstrategy;
        JSONArray jsonarray;
        if (objectId != null)
        {
            jsonobject.put("objectId", objectId);
        }
        if (createdAt != null)
        {
            jsonobject.put("createdAt", Parse.dateToString(createdAt));
        }
        if (updatedAt != null)
        {
            jsonobject.put("updatedAt", Parse.dateToString(updatedAt));
        }
        jsonobject.put("isDeletingEventually", isDeletingEventually);
        jsonarray = new JSONArray();
        for (Iterator iterator1 = operationSetQueue.iterator(); iterator1.hasNext(); jsonarray.put(((ParseOperationSet)iterator1.next()).toRest(parseobjectencodingstrategy))) { }
        jsonobject.put("__operations", jsonarray);
        jsonobject.put("__complete", hasBeenFetched);
        obj;
        JVM INSTR monitorexit ;
        return jsonobject;
    }

    public void unpin()
        throws com.parse.ParseException
    {
        Parse.waitForTask(unpinInBackground());
    }

    public void unpin(String s)
        throws com.parse.ParseException
    {
        Parse.waitForTask(unpinInBackground(s));
    }

    public Task unpinInBackground()
    {
        return unpinAllInBackground("_default", Arrays.asList(new ParseObject[] {
            this
        }));
    }

    public Task unpinInBackground(String s)
    {
        return unpinAllInBackground(s, Arrays.asList(new ParseObject[] {
            this
        }));
    }

    public void unpinInBackground(DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(unpinInBackground(), deletecallback);
    }

    public void unpinInBackground(String s, DeleteCallback deletecallback)
    {
        Parse.callbackOnMainThreadAsync(unpinInBackground(s), deletecallback);
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

    static 
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        impreciseDateFormat = simpledateformat;
    }

















}
