// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            WeakValueHashMap, OfflineSQLiteOpenHelper, ParseSQLiteDatabase, ParseObject, 
//            OfflineQueryLogic, ParseQuery, ParseTraverser, ParseUser, 
//            ParsePin, ParseDecoder, ParseObjectEncodingStrategy, ParseException

class OfflineStore
{
    private class OfflineDecoder extends ParseDecoder
    {

        private Map offlineObjects;
        final OfflineStore this$0;

        public Object decode(Object obj)
        {
            if ((obj instanceof JSONObject) && ((JSONObject)obj).optString("__type").equals("OfflineObject"))
            {
                obj = ((JSONObject)obj).optString("uuid");
                return ((Task)offlineObjects.get(obj)).getResult();
            } else
            {
                return super.decode(obj);
            }
        }

        private OfflineDecoder(Map map)
        {
            this$0 = OfflineStore.this;
            super();
            offlineObjects = map;
        }

    }

    private class OfflineEncodingStrategy
        implements ParseObjectEncodingStrategy
    {

        private ParseSQLiteDatabase db;
        private ArrayList tasks;
        private final Object tasksLock = new Object();
        final OfflineStore this$0;

        public JSONObject encodeRelatedObject(ParseObject parseobject)
        {
            JSONObject jsonobject;
            if (parseobject.getObjectId() == null)
            {
                break MISSING_BLOCK_LABEL_48;
            }
            jsonobject = new JSONObject();
            jsonobject.put("__type", "Pointer");
            jsonobject.put("objectId", parseobject.getObjectId());
            jsonobject.put("className", parseobject.getClassName());
            return jsonobject;
            JSONObject jsonobject1;
            jsonobject1 = new JSONObject();
            jsonobject1.put("__type", "OfflineObject");
            synchronized (tasksLock)
            {
                tasks.add(getOrCreateUUIDAsync(parseobject, db).onSuccess(jsonobject1. new Continuation() {

                    final OfflineEncodingStrategy this$1;
                    final JSONObject val$result;

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

                    public Void then(Task task)
                        throws Exception
                    {
                        result.put("uuid", task.getResult());
                        return null;
                    }

            
            {
                this$1 = final_offlineencodingstrategy;
                result = JSONObject.this;
                super();
            }
                }));
            }
            return jsonobject1;
            parseobject;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw parseobject;
            }
            // Misplaced declaration of an exception variable
            catch (ParseObject parseobject)
            {
                throw new RuntimeException(parseobject);
            }
        }

        public Task whenFinished()
        {
            return Task.whenAll(tasks).continueWithTask(new Continuation() {

                final OfflineEncodingStrategy this$1;

                public Task then(Task task)
                    throws Exception
                {
label0:
                    {
                        Task task2;
                        synchronized (tasksLock)
                        {
                            Iterator iterator = tasks.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break label0;
                                }
                                task2 = (Task)iterator.next();
                            } while (!task2.isFaulted() && !task2.isCancelled());
                        }
                        return task2;
                    }
                    Task task1;
                    tasks.clear();
                    task1 = Task.forResult((Void)null);
                    task;
                    JVM INSTR monitorexit ;
                    return task1;
                    exception;
                    task;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$1 = OfflineEncodingStrategy.this;
                super();
            }
            });
        }



        public OfflineEncodingStrategy(ParseSQLiteDatabase parsesqlitedatabase)
        {
            this$0 = OfflineStore.this;
            super();
            tasks = new ArrayList();
            db = parsesqlitedatabase;
        }
    }


    private static final int MAX_SQL_VARIABLES = 999;
    private static OfflineStore defaultInstance = null;
    private static final Object defaultInstanceLock = new Object();
    private final WeakValueHashMap classNameAndObjectIdToObjectMap = new WeakValueHashMap();
    private final WeakHashMap fetchedObjects = new WeakHashMap();
    private final OfflineSQLiteOpenHelper helper;
    private final Object lock = new Object();
    private final WeakHashMap objectToUuidMap = new WeakHashMap();
    private final WeakValueHashMap uuidToObjectMap = new WeakValueHashMap();

    private OfflineStore(Context context)
    {
        helper = new OfflineSQLiteOpenHelper(context);
    }

    private Task deleteDataForObjectAsync(final ParseObject object, final ParseSQLiteDatabase db)
    {
        final Capture uuid = new Capture();
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Task task = (Task)objectToUuidMap.get(object);
        if (task != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        object = Task.forResult(null);
        obj;
        JVM INSTR monitorexit ;
        return object;
        obj;
        JVM INSTR monitorexit ;
        return task.onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final Capture val$uuid;

            public Task then(Task task1)
                throws Exception
            {
                uuid.set(task1.getResult());
                return task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final Capture val$uuid;

            public Task then(Task task1)
                throws Exception
            {
                task1 = (String)uuid.get();
                return db.queryAsync("Dependencies", new String[] {
                    "key"
                }, "uuid=?", new String[] {
                    task1
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseObject val$object;

            public Task then(Task task1)
                throws Exception
            {
                task1 = (Cursor)task1.getResult();
                ArrayList arraylist = new ArrayList();
                task1.moveToFirst();
                for (; !task1.isAfterLast(); task1.moveToNext())
                {
                    String s = task1.getString(0);
                    arraylist.add(getPointerAsync(s, db).onSuccessTask(new Continuation() {

                        final _cls39 this$1;

                        public Task then(Task task)
                            throws Exception
                        {
                            task = (ParsePin)task.getResult();
                            return fetchLocallyAsync(task, db);
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = _cls39.this;
                super();
            }
                    }).continueWithTask(s. new Continuation() {

                        final _cls39 this$1;
                        final String val$uuid;

                        public Task then(Task task)
                            throws Exception
                        {
                            ParsePin parsepin = (ParsePin)task.getResult();
                            List list = parsepin.getObjects();
                            if (list == null || !list.contains(object))
                            {
                                return task.makeVoid();
                            }
                            list.remove(object);
                            if (list.size() == 0)
                            {
                                return unpinAsync(uuid, db);
                            } else
                            {
                                parsepin.setObjects(list);
                                return saveLocallyAsync(parsepin, true, db);
                            }
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls39;
                uuid = String.this;
                super();
            }
                    }));
                }

                return Task.whenAll(arraylist);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                object = parseobject;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final Capture val$uuid;

            public Task then(Task task1)
                throws Exception
            {
                task1 = (String)uuid.get();
                return db.deleteAsync("Dependencies", "uuid=?", new String[] {
                    task1
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final Capture val$uuid;

            public Task then(Task task1)
                throws Exception
            {
                task1 = (String)uuid.get();
                return db.deleteAsync("ParseObjects", "uuid=?", new String[] {
                    task1
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public Task then(Task task1)
                throws Exception
            {
                Object obj1 = lock;
                obj1;
                JVM INSTR monitorenter ;
                String s = object.getObjectId();
                if (s == null)
                {
                    break MISSING_BLOCK_LABEL_43;
                }
                classNameAndObjectIdToObjectMap.remove(Pair.create(object.getClassName(), s));
                fetchedObjects.remove(object);
                obj1;
                JVM INSTR monitorexit ;
                return task1;
                task1;
                obj1;
                JVM INSTR monitorexit ;
                throw task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        });
        object;
        obj;
        JVM INSTR monitorexit ;
        throw object;
    }

    private Task deleteObjects(final List uuids, final ParseSQLiteDatabase db)
    {
        if (uuids.size() <= 0)
        {
            return Task.forResult(null);
        }
        if (uuids.size() > 999)
        {
            return deleteObjects(uuids.subList(0, 999), db).onSuccessTask(new Continuation() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final List val$uuids;

                public Task then(Task task)
                    throws Exception
                {
                    return deleteObjects(uuids.subList(999, uuids.size()), db);
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = OfflineStore.this;
                uuids = list;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
        String as[] = new String[uuids.size()];
        for (int i = 0; i < as.length; i++)
        {
            as[i] = "?";
        }

        return db.deleteAsync("ParseObjects", (new StringBuilder()).append("uuid IN (").append(TextUtils.join(",", as)).append(")").toString(), (String[])uuids.toArray(new String[uuids.size()]));
    }

    static void disableOfflineStore()
    {
        synchronized (defaultInstanceLock)
        {
            defaultInstance = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void enableOfflineStore(Context context)
    {
label0:
        {
            synchronized (defaultInstanceLock)
            {
                if (defaultInstance != null)
                {
                    break label0;
                }
                defaultInstance = new OfflineStore(context);
            }
            return;
        }
        throw new RuntimeException("enableOfflineStore() called multiple times.");
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static OfflineStore getCurrent()
    {
        OfflineStore offlinestore;
        synchronized (defaultInstanceLock)
        {
            offlinestore = defaultInstance;
        }
        return offlinestore;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Task getOrCreateUUIDAsync(final ParseObject object, ParseSQLiteDatabase parsesqlitedatabase)
    {
        final String newUUID;
        final bolts.Task.TaskCompletionSource tcs;
        newUUID = UUID.randomUUID().toString();
        tcs = Task.create();
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Task task = (Task)objectToUuidMap.get(object);
        if (task == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj;
        JVM INSTR monitorexit ;
        return task;
        objectToUuidMap.put(object, tcs.getTask());
        uuidToObjectMap.put(newUUID, object);
        fetchedObjects.put(object, tcs.getTask().onSuccess(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public ParseObject then(Task task1)
                throws Exception
            {
                return object;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        }));
        obj;
        JVM INSTR monitorexit ;
        obj = new ContentValues();
        ((ContentValues) (obj)).put("uuid", newUUID);
        ((ContentValues) (obj)).put("className", object.getClassName());
        parsesqlitedatabase.insertOrThrowAsync("ParseObjects", ((ContentValues) (obj))).continueWith(new Continuation() {

            final OfflineStore this$0;
            final String val$newUUID;
            final bolts.Task.TaskCompletionSource val$tcs;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Void then(Task task1)
                throws Exception
            {
                tcs.setResult(newUUID);
                return null;
            }

            
            {
                this$0 = OfflineStore.this;
                tcs = taskcompletionsource;
                newUUID = s;
                super();
            }
        });
        return tcs.getTask();
        object;
        obj;
        JVM INSTR monitorexit ;
        throw object;
    }

    private Task getPointerAsync(final String uuid, ParseSQLiteDatabase parsesqlitedatabase)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ParseObject parseobject = (ParseObject)uuidToObjectMap.get(uuid);
        if (parseobject == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        uuid = Task.forResult(parseobject);
        obj;
        JVM INSTR monitorexit ;
        return uuid;
        obj;
        JVM INSTR monitorexit ;
        return parsesqlitedatabase.queryAsync("ParseObjects", new String[] {
            "className", "objectId"
        }, "uuid = ?", new String[] {
            uuid
        }).onSuccess(new Continuation() {

            final OfflineStore this$0;
            final String val$uuid;

            public ParseObject then(Task task)
                throws Exception
            {
                Object obj1;
                obj1 = (Cursor)task.getResult();
                ((Cursor) (obj1)).moveToFirst();
                if (((Cursor) (obj1)).isAfterLast())
                {
                    throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append(uuid).toString());
                }
                task = ((Task) (lock));
                task;
                JVM INSTR monitorenter ;
                Object obj2 = (ParseObject)uuidToObjectMap.get(uuid);
                if (obj2 == null)
                {
                    break MISSING_BLOCK_LABEL_90;
                }
                task;
                JVM INSTR monitorexit ;
                return ((ParseObject) (obj2));
                obj2 = ((Cursor) (obj1)).getString(0);
                obj1 = ((Cursor) (obj1)).getString(1);
                obj2 = ParseObject.createWithoutData(((String) (obj2)), ((String) (obj1)));
                if (obj1 != null)
                {
                    break MISSING_BLOCK_LABEL_150;
                }
                uuidToObjectMap.put(uuid, obj2);
                objectToUuidMap.put(obj2, Task.forResult(uuid));
                task;
                JVM INSTR monitorexit ;
                return ((ParseObject) (obj2));
                Exception exception;
                exception;
                task;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = s;
                super();
            }
        });
        uuid;
        obj;
        JVM INSTR monitorexit ;
        throw uuid;
    }

    public static boolean isEnabled()
    {
        Object obj = defaultInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (defaultInstance != null)
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

    private Task saveLocallyAsync(final String key, final ParseObject object, final ParseSQLiteDatabase db)
    {
        if (object.getObjectId() != null && !object.isDataAvailable() && !object.hasChanges() && !object.hasOutstandingOperations())
        {
            return Task.forResult(null);
        } else
        {
            final Capture uuid = new Capture();
            final Capture encoded = new Capture();
            return fetchLocallyAsync(object, db).continueWithTask(new Continuation() {

                final OfflineStore this$0;

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
                            if (((ParseException)task.getError()).getCode() == 120)
                            {
                                task1 = Task.forResult(null);
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
                this$0 = OfflineStore.this;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final ParseObject val$object;

                public Task then(Task task)
                    throws Exception
                {
                    return getOrCreateUUIDAsync(object, db);
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                db = parsesqlitedatabase;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final Capture val$encoded;
                final ParseObject val$object;
                final Capture val$uuid;

                public Task then(Task task)
                    throws Exception
                {
                    uuid.set(task.getResult());
                    task = new OfflineEncodingStrategy(db);
                    encoded.set(object.toRest(task));
                    return task.whenFinished();
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                db = parsesqlitedatabase;
                encoded = capture1;
                object = parseobject;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final Capture val$encoded;
                final ParseObject val$object;
                final Capture val$uuid;

                public Task then(Task task)
                    throws Exception
                {
                    String s = object.getClassName();
                    String s1 = object.getObjectId();
                    String s2 = encoded.get().toString();
                    task = new ContentValues();
                    task.put("className", s);
                    task.put("json", s2);
                    if (s1 != null)
                    {
                        task.put("objectId", s1);
                    }
                    s = (String)uuid.get();
                    return db.updateAsync("ParseObjects", task, "uuid = ?", new String[] {
                        s
                    }).makeVoid();
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                encoded = capture;
                uuid = capture1;
                db = parsesqlitedatabase;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final String val$key;
                final Capture val$uuid;

                public Task then(Task task)
                    throws Exception
                {
                    task = new ContentValues();
                    task.put("key", key);
                    task.put("uuid", (String)uuid.get());
                    return db.insertWithOnConflict("Dependencies", task, 4);
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = OfflineStore.this;
                key = s;
                uuid = capture;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
    }

    private Task unpinAsync(final String key)
    {
        return helper.getWritableDatabaseAsync().onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final String val$key;

            public Task then(Task task)
                throws Exception
            {
                task = (ParseSQLiteDatabase)task.getResult();
                return task.beginTransactionAsync().onSuccessTask(task. new Continuation() {

                    final _cls28 this$1;
                    final ParseSQLiteDatabase val$db;

                    public Task then(Task task)
                        throws Exception
                    {
                        return unpinAsync(key, db).onSuccessTask(new Continuation() {

                            final _cls1 this$2;

                            public Task then(Task task)
                                throws Exception
                            {
                                return db.setTransactionSuccessfulAsync();
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        }).continueWithTask(new Continuation() {

                            final _cls1 this$2;

                            public Task then(Task task)
                                throws Exception
                            {
                                db.endTransactionAsync();
                                db.close();
                                return task;
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$2 = _cls1.this;
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
                this$1 = final__pcls28;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                key = s;
                super();
            }
        });
    }

    private Task unpinAsync(final String key, final ParseSQLiteDatabase db)
    {
        final LinkedList uuidsToDelete = new LinkedList();
        return Task.forResult((Void)null).continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final String val$key;

            public Task then(Task task)
                throws Exception
            {
                task = key;
                return db.rawQueryAsync("SELECT uuid FROM Dependencies WHERE key=? AND uuid IN ( SELECT uuid FROM Dependencies GROUP BY uuid HAVING COUNT(uuid)=1)", new String[] {
                    task
                });
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                key = s;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final List val$uuidsToDelete;

            public Task then(Task task)
                throws Exception
            {
                for (task = (Cursor)task.getResult(); task.moveToNext(); uuidsToDelete.add(task.getString(0))) { }
                return deleteObjects(uuidsToDelete, db);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                uuidsToDelete = list;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final String val$key;

            public Task then(Task task)
                throws Exception
            {
                task = key;
                return db.deleteAsync("Dependencies", "key=?", new String[] {
                    task
                });
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                key = s;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccess(new Continuation() {

            final OfflineStore this$0;
            final List val$uuidsToDelete;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                task = ((Task) (lock));
                task;
                JVM INSTR monitorenter ;
                Iterator iterator = uuidsToDelete.iterator();
_L2:
                String s;
                ParseObject parseobject;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_92;
                    }
                    s = (String)iterator.next();
                    parseobject = (ParseObject)uuidToObjectMap.get(s);
                } while (parseobject == null);
                objectToUuidMap.remove(parseobject);
                uuidToObjectMap.remove(s);
                if (true) goto _L2; else goto _L1
_L1:
                Exception exception;
                exception;
                task;
                JVM INSTR monitorexit ;
                throw exception;
                task;
                JVM INSTR monitorexit ;
                return null;
            }

            
            {
                this$0 = OfflineStore.this;
                uuidsToDelete = list;
                super();
            }
        });
    }

    private Task updateDataForObjectAsync(final ParseObject object, final ParseSQLiteDatabase db)
    {
        final Capture uuid;
        final Capture jsonObject;
        uuid = new Capture();
        jsonObject = new Capture();
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Task task = (Task)objectToUuidMap.get(object);
        if (task != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        object = Task.forResult(null);
        obj;
        JVM INSTR monitorexit ;
        return object;
        obj;
        JVM INSTR monitorexit ;
        return task.onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final Capture val$jsonObject;
            final ParseObject val$object;
            final Capture val$uuid;

            public Task then(Task task1)
                throws Exception
            {
                uuid.set(task1.getResult());
                task1 = new OfflineEncodingStrategy(db);
                jsonObject.set(object.toRest(task1));
                return task1.whenFinished();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                db = parsesqlitedatabase;
                jsonObject = capture1;
                object = parseobject;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final Capture val$jsonObject;
            final ParseObject val$object;
            final Capture val$uuid;

            public Task then(Task task1)
                throws Exception
            {
                String s = object.getClassName();
                String s1 = object.getObjectId();
                String s2 = ((JSONObject)jsonObject.get()).toString();
                int i = ((JSONObject)jsonObject.get()).getInt("isDeletingEventually");
                task1 = new ContentValues();
                task1.put("className", s);
                task1.put("json", s2);
                if (s1 != null)
                {
                    task1.put("objectId", s1);
                }
                task1.put("isDeletingEventually", Integer.valueOf(i));
                s = (String)uuid.get();
                return db.updateAsync("ParseObjects", task1, "uuid = ?", new String[] {
                    s
                }).makeVoid();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                jsonObject = capture;
                uuid = capture1;
                db = parsesqlitedatabase;
                super();
            }
        });
        object;
        obj;
        JVM INSTR monitorexit ;
        throw object;
    }

    void clearDatabase(Context context)
    {
        helper.clearDatabase(context);
    }

    Task countAsync(ParseQuery parsequery, ParseUser parseuser, ParsePin parsepin, boolean flag, boolean flag1)
    {
        return findAsync(parsequery, parseuser, parsepin, true, flag, flag1).onSuccess(new Continuation() {

            final OfflineStore this$0;

            public Integer then(Task task)
                throws Exception
            {
                return Integer.valueOf(((List)task.getResult()).size());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                super();
            }
        });
    }

    Task deleteDataForObjectAsync(final ParseObject object)
    {
        return helper.getWritableDatabaseAsync().continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public Task then(Task task)
                throws Exception
            {
                task = (ParseSQLiteDatabase)task.getResult();
                return task.beginTransactionAsync().onSuccessTask(task. new Continuation() {

                    final _cls37 this$1;
                    final ParseSQLiteDatabase val$db;

                    public Task then(Task task)
                        throws Exception
                    {
                        return deleteDataForObjectAsync(object, db).onSuccessTask(new Continuation() {

                            final _cls1 this$2;

                            public Task then(Task task)
                                throws Exception
                            {
                                return db.setTransactionSuccessfulAsync();
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        }).continueWithTask(new Continuation() {

                            final _cls1 this$2;

                            public Task then(Task task)
                                throws Exception
                            {
                                db.endTransactionAsync();
                                db.close();
                                return task;
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$2 = _cls1.this;
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
                this$1 = final__pcls37;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        });
    }

    Task fetchLocallyAsync(final ParseObject object)
    {
        return helper.getWritableDatabaseAsync().continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public Task then(Task task)
                throws Exception
            {
                task = (ParseSQLiteDatabase)task.getResult();
                return fetchLocallyAsync(object, task).continueWithTask(task. new Continuation() {

                    final _cls14 this$1;
                    final ParseSQLiteDatabase val$db;

                    public Task then(Task task)
                        throws Exception
                    {
                        db.close();
                        return task;
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = final__pcls14;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        });
    }

    Task fetchLocallyAsync(final ParseObject object, final ParseSQLiteDatabase db)
    {
        final bolts.Task.TaskCompletionSource tcs;
label0:
        {
            tcs = Task.create();
            synchronized (lock)
            {
                if (!fetchedObjects.containsKey(object))
                {
                    break label0;
                }
                object = (Task)fetchedObjects.get(object);
            }
            return object;
        }
        Task task;
        fetchedObjects.put(object, tcs.getTask());
        task = (Task)objectToUuidMap.get(object);
        uuid;
        JVM INSTR monitorexit ;
        String s;
        String s1;
        s = object.getClassName();
        s1 = object.getObjectId();
        uuid = Task.forResult(null);
        if (s1 != null) goto _L2; else goto _L1
_L1:
        if (task != null)
        {
            uuid = new Capture();
            uuid = task.onSuccessTask(new Continuation() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final String val$select[];
                final Capture val$uuid;

                public Task then(Task task1)
                    throws Exception
                {
                    uuid.set(task1.getResult());
                    task1 = (String)uuid.get();
                    return db.queryAsync("ParseObjects", select, "uuid = ?", new String[] {
                        task1
                    });
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                db = parsesqlitedatabase;
                select = as;
                super();
            }
            }).onSuccess(new Continuation() {

                final OfflineStore this$0;
                final Capture val$uuid;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public String then(Task task1)
                    throws Exception
                {
                    task1 = (Cursor)task1.getResult();
                    task1.moveToFirst();
                    if (task1.isAfterLast())
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append((String)uuid.get()).toString());
                    } else
                    {
                        return task1.getString(0);
                    }
                }

            
            {
                this$0 = OfflineStore.this;
                uuid = capture;
                super();
            }
            });
        }
_L4:
        return ((Task) (uuid)).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseObject val$object;

            public Task then(final Task json)
                throws Exception
            {
                json = (String)json.getResult();
                if (json == null)
                {
                    return Task.forError(new ParseException(120, "Attempted to fetch an object offline which was never saved to the offline cache."));
                }
                HashMap hashmap;
                try
                {
                    json = new JSONObject(json);
                }
                // Misplaced declaration of an exception variable
                catch (final Task json)
                {
                    return Task.forError(json);
                }
                hashmap = new HashMap();
                (hashmap. new ParseTraverser() {

                    final _cls13 this$1;
                    final Map val$offlineObjects;

                    protected boolean visit(Object obj)
                    {
                        if ((obj instanceof JSONObject) && ((JSONObject)obj).optString("__type").equals("OfflineObject"))
                        {
                            obj = ((JSONObject)obj).optString("uuid");
                            offlineObjects.put(obj, getPointerAsync(((String) (obj)), db));
                        }
                        return true;
                    }

            
            {
                this$1 = final__pcls13;
                offlineObjects = Map.this;
                super();
            }
                }).setTraverseParseObjects(false).setYieldRoot(false).traverse(json);
                return Task.whenAll(hashmap.values()).onSuccess(hashmap. new Continuation() {

                    final _cls13 this$1;
                    final JSONObject val$json;
                    final Map val$offlineObjects;

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

                    public Void then(Task task)
                        throws Exception
                    {
                        object.mergeREST(json, new OfflineDecoder(offlineObjects));
                        return null;
                    }

            
            {
                this$1 = final__pcls13;
                json = jsonobject;
                offlineObjects = Map.this;
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
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                object = parseobject;
                super();
            }
        }).continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;
            final bolts.Task.TaskCompletionSource val$tcs;

            public Task then(Task task1)
                throws Exception
            {
                if (task1.isCancelled())
                {
                    tcs.setCancelled();
                } else
                if (task1.isFaulted())
                {
                    tcs.setError(task1.getError());
                } else
                {
                    tcs.setResult(object);
                }
                return tcs.getTask();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                tcs = taskcompletionsource;
                object = parseobject;
                super();
            }
        });
        object;
        uuid;
        JVM INSTR monitorexit ;
        throw object;
_L2:
        if (task != null)
        {
            tcs.setError(new IllegalStateException("This object must have already been fetched from the local datastore, but isn't marked as fetched."));
            synchronized (lock)
            {
                fetchedObjects.remove(object);
            }
            return tcs.getTask();
        }
        break MISSING_BLOCK_LABEL_227;
        object;
        db;
        JVM INSTR monitorexit ;
        throw object;
        uuid = String.format("%s = ? AND %s = ?", new Object[] {
            "className", "objectId"
        });
        uuid = db.queryAsync("ParseObjects", new String[] {
            "json", "uuid"
        }, ((String) (uuid)), new String[] {
            s, s1
        }).onSuccess(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public String then(Task task1)
                throws Exception
            {
                Cursor cursor = (Cursor)task1.getResult();
                cursor.moveToFirst();
                if (cursor.isAfterLast())
                {
                    throw new ParseException(120, "This object is not available in the offline cache.");
                }
                task1 = cursor.getString(0);
                String s2 = cursor.getString(1);
                synchronized (lock)
                {
                    objectToUuidMap.put(object, Task.forResult(s2));
                    uuidToObjectMap.put(s2, object);
                }
                return task1;
                task1;
                obj;
                JVM INSTR monitorexit ;
                throw task1;
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        });
        if (true) goto _L4; else goto _L3
_L3:
    }

    Task findAsync(ParseQuery parsequery, ParseUser parseuser, ParsePin parsepin, boolean flag, boolean flag1)
    {
        return findAsync(parsequery, parseuser, parsepin, false, flag, flag1);
    }

    Task findAsync(final ParseQuery query, final ParseUser user, final ParsePin pin, final boolean isCount, final boolean includeIsDeletingEventually, final boolean ignoreACLs)
    {
        return helper.getWritableDatabaseAsync().continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final boolean val$ignoreACLs;
            final boolean val$includeIsDeletingEventually;
            final boolean val$isCount;
            final ParsePin val$pin;
            final ParseQuery val$query;
            final ParseUser val$user;

            public Task then(Task task)
                throws Exception
            {
                task = (ParseSQLiteDatabase)task.getResult();
                return findAsync(query, user, pin, isCount, includeIsDeletingEventually, ignoreACLs, task).continueWithTask(task. new Continuation() {

                    final _cls5 this$1;
                    final ParseSQLiteDatabase val$db;

                    public Task then(Task task)
                        throws Exception
                    {
                        db.close();
                        return task;
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = final__pcls5;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                query = parsequery;
                user = parseuser;
                pin = parsepin;
                isCount = flag;
                includeIsDeletingEventually = flag1;
                ignoreACLs = flag2;
                super();
            }
        });
    }

    Task findAsync(final ParseQuery query, final ParseUser user, ParsePin parsepin, final boolean isCount, final boolean includeIsDeletingEventually, final boolean ignoreACLs, final ParseSQLiteDatabase db)
    {
        final OfflineQueryLogic queryLogic = new OfflineQueryLogic(this);
        final ArrayList results = new ArrayList();
        if (parsepin == null)
        {
            parsepin = "className=?";
            if (!includeIsDeletingEventually)
            {
                parsepin = (new StringBuilder()).append("className=?").append(" AND isDeletingEventually=0").toString();
            }
            String s = query.getClassName();
            parsepin = db.queryAsync("ParseObjects", new String[] {
                "uuid"
            }, parsepin, new String[] {
                s
            });
        } else
        {
            parsepin = (Task)objectToUuidMap.get(parsepin);
            if (parsepin == null)
            {
                return Task.forResult(results);
            }
            parsepin = parsepin.onSuccessTask(new Continuation() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final boolean val$includeIsDeletingEventually;
                final ParseQuery val$query;

                public Task then(Task task)
                    throws Exception
                {
                    String s1 = (String)task.getResult();
                    task = "className=? AND key=?";
                    if (!includeIsDeletingEventually)
                    {
                        task = (new StringBuilder()).append("className=? AND key=?").append(" AND isDeletingEventually=0").toString();
                    }
                    String s2 = query.getClassName();
                    return db.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", new String[] {
                        "A.uuid"
                    }, task, new String[] {
                        s2, s1
                    });
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = OfflineStore.this;
                includeIsDeletingEventually = flag;
                query = parsequery;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
        return parsepin.onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final boolean val$ignoreACLs;
            final ParseQuery val$query;
            final OfflineQueryLogic val$queryLogic;
            final List val$results;
            final ParseUser val$user;

            public Task then(Task task)
                throws Exception
            {
                Cursor cursor = (Cursor)task.getResult();
                OfflineQueryLogic.ConstraintMatcher constraintmatcher = queryLogic.createMatcher(query, user, ignoreACLs);
                task = Task.forResult(null);
                cursor.moveToFirst();
                for (; !cursor.isAfterLast(); cursor.moveToNext())
                {
                    String s1 = cursor.getString(0);
                    final Capture object = new Capture();
                    task = task.onSuccessTask(s1. new Continuation() {

                        final _cls8 this$1;
                        final String val$uuid;

                        public Task then(Task task)
                            throws Exception
                        {
                            return getPointerAsync(uuid, db);
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls8;
                uuid = String.this;
                super();
            }
                    }).onSuccessTask(object. new Continuation() {

                        final _cls8 this$1;
                        final Capture val$object;

                        public Task then(Task task)
                            throws Exception
                        {
                            object.set(task.getResult());
                            return fetchLocallyAsync((ParseObject)object.get(), db);
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls8;
                object = Capture.this;
                super();
            }
                    }).onSuccessTask(constraintmatcher. new Continuation() {

                        final _cls8 this$1;
                        final OfflineQueryLogic.ConstraintMatcher val$matcher;
                        final Capture val$object;

                        public Task then(Task task)
                            throws Exception
                        {
                            if (!((ParseObject)object.get()).isDataAvailable())
                            {
                                return Task.forResult(Boolean.valueOf(false));
                            } else
                            {
                                return matcher.matchesAsync((ParseObject)object.get(), db);
                            }
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls8;
                object = capture;
                matcher = OfflineQueryLogic.ConstraintMatcher.this;
                super();
            }
                    }).onSuccess(object. new Continuation() {

                        final _cls8 this$1;
                        final Capture val$object;

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

                        public Void then(Task task)
                        {
                            if (((Boolean)task.getResult()).booleanValue())
                            {
                                results.add(object.get());
                            }
                            return null;
                        }

            
            {
                this$1 = final__pcls8;
                object = Capture.this;
                super();
            }
                    });
                }

                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                queryLogic = offlinequerylogic;
                query = parsequery;
                user = parseuser;
                ignoreACLs = flag;
                db = parsesqlitedatabase;
                results = list;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final boolean val$isCount;
            final ParseQuery val$query;
            final OfflineQueryLogic val$queryLogic;
            final List val$results;

            public Task then(Task task)
                throws Exception
            {
                queryLogic.sort(results, query);
                Object obj = results;
                int i = query.getSkip();
                task = ((Task) (obj));
                if (!isCount)
                {
                    task = ((Task) (obj));
                    if (i >= 0)
                    {
                        task = ((List) (obj)).subList(Math.min(query.getSkip(), ((List) (obj)).size()), ((List) (obj)).size());
                    }
                }
                i = query.getLimit();
                obj = task;
                if (!isCount)
                {
                    obj = task;
                    if (i >= 0)
                    {
                        obj = task;
                        if (task.size() > i)
                        {
                            obj = task.subList(0, i);
                        }
                    }
                }
                task = Task.forResult(null);
                for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext();)
                {
                    task = task.onSuccessTask(((ParseObject)iterator.next()). new Continuation() {

                        final _cls7 this$1;
                        final ParseObject val$object;

                        public Task then(Task task)
                            throws Exception
                        {
                            return queryLogic.fetchIncludes(object, query, db);
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls7;
                object = ParseObject.this;
                super();
            }
                    });
                }

                return task.onSuccess(((_cls2) (obj)). new Continuation() {

                    final _cls7 this$1;
                    final List val$finalTrimmedResults;

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

                    public List then(Task task)
                        throws Exception
                    {
                        return finalTrimmedResults;
                    }

            
            {
                this$1 = final__pcls7;
                finalTrimmedResults = List.this;
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
                this$0 = OfflineStore.this;
                queryLogic = offlinequerylogic;
                results = list;
                query = parsequery;
                isCount = flag;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    Pair getOrCreateObjectWithoutData(String s, String s1)
    {
        Object obj;
        if (s1 == null)
        {
            throw new IllegalStateException("objectId cannot be null.");
        }
        obj = Pair.create(s, s1);
        s1 = ((String) (lock));
        s1;
        JVM INSTR monitorenter ;
        obj = (ParseObject)classNameAndObjectIdToObjectMap.get(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        s = Pair.create(obj, Boolean.valueOf(false));
        s1;
        JVM INSTR monitorexit ;
        return s;
        s = Pair.create(ParseObject.create(s), Boolean.valueOf(true));
        s1;
        JVM INSTR monitorexit ;
        return s;
        s;
        s1;
        JVM INSTR monitorexit ;
        throw s;
    }

    void registerNewObject(ParseObject parseobject)
    {
        Object obj = parseobject.getObjectId();
        if (obj != null)
        {
            obj = Pair.create(parseobject.getClassName(), obj);
            classNameAndObjectIdToObjectMap.put(obj, parseobject);
        }
    }

    Task saveLocallyAsync(final ParseObject object, final boolean includeAllChildren)
    {
        return helper.getWritableDatabaseAsync().continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final boolean val$includeAllChildren;
            final ParseObject val$object;

            public Task then(Task task)
                throws Exception
            {
                task = (ParseSQLiteDatabase)task.getResult();
                return task.beginTransactionAsync().onSuccessTask(task. new Continuation() {

                    final _cls20 this$1;
                    final ParseSQLiteDatabase val$db;

                    public Task then(Task task)
                        throws Exception
                    {
                        return saveLocallyAsync(object, includeAllChildren, db);
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = final__pcls20;
                db = ParseSQLiteDatabase.this;
                super();
            }
                }).onSuccessTask(task. new Continuation() {

                    final _cls20 this$1;
                    final ParseSQLiteDatabase val$db;

                    public Task then(Task task)
                        throws Exception
                    {
                        return db.setTransactionSuccessfulAsync();
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = final__pcls20;
                db = ParseSQLiteDatabase.this;
                super();
            }
                }).continueWithTask(task. new Continuation() {

                    final _cls20 this$1;
                    final ParseSQLiteDatabase val$db;

                    public Task then(Task task)
                        throws Exception
                    {
                        db.endTransactionAsync();
                        db.close();
                        return task;
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = final__pcls20;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                object = parseobject;
                includeAllChildren = flag;
                super();
            }
        });
    }

    Task saveLocallyAsync(final ParseObject object, boolean flag, final ParseSQLiteDatabase db)
    {
        final ArrayList objectsInTree = new ArrayList();
        if (!flag)
        {
            objectsInTree.add(object);
            return fetchLocallyAsync(object, db).makeVoid();
        }
        (new ParseTraverser() {

            final OfflineStore this$0;
            final ArrayList val$objectsInTree;

            protected boolean visit(Object obj)
            {
                if (obj instanceof ParseObject)
                {
                    objectsInTree.add((ParseObject)obj);
                }
                return true;
            }

            
            {
                this$0 = OfflineStore.this;
                objectsInTree = arraylist;
                super();
            }
        }).setYieldRoot(true).setTraverseParseObjects(true).traverse(object);
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = objectsInTree.iterator(); iterator.hasNext(); arraylist.add(fetchLocallyAsync((ParseObject)iterator.next(), db).makeVoid())) { }
        return Task.whenAll(arraylist).continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public Task then(Task task)
                throws Exception
            {
                return (Task)objectToUuidMap.get(object);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;

            public Task then(Task task)
                throws Exception
            {
                task = (String)task.getResult();
                if (task == null)
                {
                    return null;
                } else
                {
                    return unpinAsync(task, db);
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseObject val$object;

            public Task then(Task task)
                throws Exception
            {
                return getOrCreateUUIDAsync(object, db);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                db = parsesqlitedatabase;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ArrayList val$objectsInTree;

            public Task then(Task task)
                throws Exception
            {
                task = (String)task.getResult();
                ArrayList arraylist1 = new ArrayList();
                ParseObject parseobject;
                for (Iterator iterator1 = objectsInTree.iterator(); iterator1.hasNext(); arraylist1.add(saveLocallyAsync(task, parseobject, db)))
                {
                    parseobject = (ParseObject)iterator1.next();
                }

                return Task.whenAll(arraylist1);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                objectsInTree = arraylist;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    void simulateReboot()
    {
        synchronized (lock)
        {
            uuidToObjectMap.clear();
            objectToUuidMap.clear();
            classNameAndObjectIdToObjectMap.clear();
            fetchedObjects.clear();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Task unpinAsync(final ParseObject object)
    {
        return Task.forResult(null).continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public Task then(Task task)
                throws Exception
            {
                return (Task)objectToUuidMap.get(object);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        }).continueWithTask(new Continuation() {

            final OfflineStore this$0;

            public Task then(Task task)
                throws Exception
            {
                task = (String)task.getResult();
                if (task == null)
                {
                    return Task.forResult(null);
                } else
                {
                    return unpinAsync(task);
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = OfflineStore.this;
                super();
            }
        });
    }

    Task updateDataForObjectAsync(final ParseObject object)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Task task = (Task)fetchedObjects.get(object);
        if (task != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        object = Task.forError(new IllegalStateException("An object cannot be updated if it wasn't fetched."));
        obj;
        JVM INSTR monitorexit ;
        return object;
        obj;
        JVM INSTR monitorexit ;
        return task.continueWithTask(new Continuation() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public Task then(Task task1)
                throws Exception
            {
                if (task1.isFaulted())
                {
                    if ((task1.getError() instanceof ParseException) && ((ParseException)task1.getError()).getCode() == 120)
                    {
                        return Task.forResult(null);
                    } else
                    {
                        return task1.makeVoid();
                    }
                } else
                {
                    return helper.getWritableDatabaseAsync().continueWithTask(new Continuation() {

                        final _cls34 this$1;

                        public Task then(Task task)
                            throws Exception
                        {
                            task = (ParseSQLiteDatabase)task.getResult();
                            return task.beginTransactionAsync().onSuccessTask(task. new Continuation() {

                                final _cls1 this$2;
                                final ParseSQLiteDatabase val$db;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    return updateDataForObjectAsync(object, db).onSuccessTask(new Continuation() {

                                        final _cls1 this$3;

                                        public Task then(Task task)
                                            throws Exception
                                        {
                                            return db.setTransactionSuccessfulAsync();
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
                                    }).continueWithTask(new Continuation() {

                                        final _cls1 this$3;

                                        public Task then(Task task)
                                            throws Exception
                                        {
                                            db.endTransactionAsync();
                                            db.close();
                                            return task;
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
                this$2 = final__pcls1;
                db = ParseSQLiteDatabase.this;
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
                this$1 = _cls34.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        });
        object;
        obj;
        JVM INSTR monitorexit ;
        throw object;
    }

    void updateObjectId(ParseObject parseobject, String s, String s1)
    {
        if (s != null)
        {
            if (s.equals(s1))
            {
                return;
            } else
            {
                throw new RuntimeException("objectIds cannot be changed in offline mode.");
            }
        }
        s1 = Pair.create(parseobject.getClassName(), s1);
        s = ((String) (lock));
        s;
        JVM INSTR monitorenter ;
        ParseObject parseobject1 = (ParseObject)classNameAndObjectIdToObjectMap.get(s1);
        if (parseobject1 == null || parseobject1 == parseobject)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        throw new RuntimeException("Attempted to change an objectId to one that's already known to the Offline Store.");
        parseobject;
        s;
        JVM INSTR monitorexit ;
        throw parseobject;
        classNameAndObjectIdToObjectMap.put(s1, parseobject);
        s;
        JVM INSTR monitorexit ;
    }















}
