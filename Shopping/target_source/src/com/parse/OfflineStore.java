// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
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
//            OfflineSQLiteOpenHelper, WeakValueHashMap, ParseSQLiteDatabase, OfflineQueryLogic, 
//            ParseObject, ParsePin, ParseTraverser, ParseUser, 
//            ParseDecoder, ParseEncoder, ParseException

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
                return ((j)offlineObjects.get(obj)).e();
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

    private class OfflineEncoder extends ParseEncoder
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
                tasks.add(getOrCreateUUIDAsync(parseobject, db).c(jsonobject1. new i() {

                    final OfflineEncoder this$1;
                    final JSONObject val$result;

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

                    public Void then(j j1)
                        throws Exception
                    {
                        result.put("uuid", j1.e());
                        return null;
                    }

            
            {
                this$1 = final_offlineencoder;
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

        public j whenFinished()
        {
            return j.a(tasks).b(new i() {

                final OfflineEncoder this$1;

                public j then(j j1)
                    throws Exception
                {
label0:
                    {
                        j j3;
                        synchronized (tasksLock)
                        {
                            Iterator iterator = tasks.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break label0;
                                }
                                j3 = (j)iterator.next();
                            } while (!j3.d() && !j3.c());
                        }
                        return j3;
                    }
                    j j2;
                    tasks.clear();
                    j2 = j.a((Void)null);
                    j1;
                    JVM INSTR monitorexit ;
                    return j2;
                    exception;
                    j1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$1 = OfflineEncoder.this;
                super();
            }
            });
        }



        public OfflineEncoder(ParseSQLiteDatabase parsesqlitedatabase)
        {
            this$0 = OfflineStore.this;
            super();
            tasks = new ArrayList();
            db = parsesqlitedatabase;
        }
    }

    private static interface SQLiteDatabaseCallable
    {

        public abstract Object call(ParseSQLiteDatabase parsesqlitedatabase);
    }


    private static final int MAX_SQL_VARIABLES = 999;
    private final WeakValueHashMap classNameAndObjectIdToObjectMap;
    private final WeakHashMap fetchedObjects;
    private final OfflineSQLiteOpenHelper helper;
    private final Object lock;
    private final WeakHashMap objectToUuidMap;
    private final WeakValueHashMap uuidToObjectMap;

    OfflineStore(Context context)
    {
        this(new OfflineSQLiteOpenHelper(context));
    }

    OfflineStore(OfflineSQLiteOpenHelper offlinesqliteopenhelper)
    {
        lock = new Object();
        uuidToObjectMap = new WeakValueHashMap();
        objectToUuidMap = new WeakHashMap();
        fetchedObjects = new WeakHashMap();
        classNameAndObjectIdToObjectMap = new WeakValueHashMap();
        helper = offlinesqliteopenhelper;
    }

    private j countFromPinAsync(String s, final ParseQuery.State state, final ParseUser user, final ParseSQLiteDatabase db)
    {
        if (s != null)
        {
            s = getParsePin(s, db);
        } else
        {
            s = j.a(null);
        }
        return s.d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseQuery.State val$state;
            final ParseUser val$user;

            public j then(j j1)
                throws Exception
            {
                j1 = (ParsePin)j1.e();
                return findAsync(state, user, j1, true, db).c(new i() {

                    final _cls46 this$1;

                    public Integer then(j j1)
                        throws Exception
                    {
                        return Integer.valueOf(((List)j1.e()).size());
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls46.this;
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
                this$0 = OfflineStore.this;
                state = state1;
                user = parseuser;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    private j deleteDataForObjectAsync(final ParseObject object, final ParseSQLiteDatabase db)
    {
        final h uuid = new h();
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        j j1 = (j)objectToUuidMap.get(object);
        if (j1 != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        object = j.a(null);
        obj;
        JVM INSTR monitorexit ;
        return object;
        obj;
        JVM INSTR monitorexit ;
        return j1.d(new i() {

            final OfflineStore this$0;
            final h val$uuid;

            public j then(j j2)
                throws Exception
            {
                uuid.a(j2.e());
                return j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = h1;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final h val$uuid;

            public j then(j j2)
                throws Exception
            {
                j2 = (String)uuid.a();
                return db.queryAsync("Dependencies", new String[] {
                    "key"
                }, "uuid=?", new String[] {
                    j2
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = h1;
                db = parsesqlitedatabase;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseObject val$object;

            public j then(j j2)
                throws Exception
            {
                j2 = (Cursor)j2.e();
                Object obj1 = new ArrayList();
                j2.moveToFirst();
                for (; !j2.isAfterLast(); j2.moveToNext())
                {
                    ((List) (obj1)).add(j2.getString(0));
                }

                j2.close();
                j2 = new ArrayList();
                String s;
                for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); j2.add(getPointerAsync(s, db).d(new i() {

            final _cls31 this$1;

            public j then(j j1)
                throws Exception
            {
                j1 = (ParsePin)j1.e();
                return fetchLocallyAsync(j1, db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = _cls31.this;
                super();
            }
        }).b(s. new i() {

            final _cls31 this$1;
            final String val$uuid;

            public j then(j j1)
                throws Exception
            {
                ParsePin parsepin = (ParsePin)j1.e();
                List list = parsepin.getObjects();
                if (list == null || !list.contains(object))
                {
                    return j1.j();
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

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = final__pcls31;
                uuid = String.this;
                super();
            }
        })))
                {
                    s = (String)((Iterator) (obj1)).next();
                }

                return j.a(j2);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                object = parseobject;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final h val$uuid;

            public j then(j j2)
                throws Exception
            {
                j2 = (String)uuid.a();
                return db.deleteAsync("Dependencies", "uuid=?", new String[] {
                    j2
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = h1;
                db = parsesqlitedatabase;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final h val$uuid;

            public j then(j j2)
                throws Exception
            {
                j2 = (String)uuid.a();
                return db.deleteAsync("ParseObjects", "uuid=?", new String[] {
                    j2
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                uuid = h1;
                db = parsesqlitedatabase;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public j then(j j2)
                throws Exception
            {
                synchronized (lock)
                {
                    fetchedObjects.remove(object);
                }
                return j2;
                j2;
                obj1;
                JVM INSTR monitorexit ;
                throw j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
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

    private j deleteObjects(final List uuids, final ParseSQLiteDatabase db)
    {
        int i = 0;
        if (uuids.size() <= 0)
        {
            return j.a(null);
        }
        if (uuids.size() > 999)
        {
            return deleteObjects(uuids.subList(0, 999), db).d(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final List val$uuids;

                public j then(j j1)
                    throws Exception
                {
                    return deleteObjects(uuids.subList(999, uuids.size()), db);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = OfflineStore.this;
                uuids = list;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
        String as[];
        for (as = new String[uuids.size()]; i < as.length; i++)
        {
            as[i] = "?";
        }

        return db.deleteAsync("ParseObjects", (new StringBuilder()).append("uuid IN (").append(TextUtils.join(",", as)).append(")").toString(), (String[])uuids.toArray(new String[uuids.size()]));
    }

    private j findAsync(final ParseQuery.State query, final ParseUser user, ParsePin parsepin, final boolean isCount, final ParseSQLiteDatabase db)
    {
        final OfflineQueryLogic queryLogic = new OfflineQueryLogic(this);
        final ArrayList results = new ArrayList();
        if (parsepin == null)
        {
            parsepin = (new StringBuilder()).append("className=?").append(" AND isDeletingEventually=0").toString();
            String s = query.className();
            parsepin = db.queryAsync("ParseObjects", new String[] {
                "uuid"
            }, parsepin, new String[] {
                s
            });
        } else
        {
            parsepin = (j)objectToUuidMap.get(parsepin);
            if (parsepin == null)
            {
                return j.a(results);
            }
            parsepin = parsepin.d(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final ParseQuery.State val$query;

                public j then(j j1)
                    throws Exception
                {
                    j1 = (String)j1.e();
                    String s1 = (new StringBuilder()).append("className=? AND key=?").append(" AND isDeletingEventually=0").toString();
                    String s2 = query.className();
                    return db.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", new String[] {
                        "A.uuid"
                    }, s1, new String[] {
                        s2, j1
                    });
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = OfflineStore.this;
                query = state;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
        return parsepin.d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseQuery.State val$query;
            final OfflineQueryLogic val$queryLogic;
            final List val$results;
            final ParseUser val$user;

            public j then(j j1)
                throws Exception
            {
                j1 = (Cursor)j1.e();
                Object obj = new ArrayList();
                j1.moveToFirst();
                for (; !j1.isAfterLast(); j1.moveToNext())
                {
                    ((List) (obj)).add(j1.getString(0));
                }

                j1.close();
                OfflineQueryLogic.ConstraintMatcher constraintmatcher = queryLogic.createMatcher(query, user);
                j1 = j.a(null);
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    String s1 = (String)((Iterator) (obj)).next();
                    final h object = new h();
                    j1 = j1.d(s1. new i() {

                        final _cls6 this$1;
                        final String val$uuid;

                        public j then(j j1)
                            throws Exception
                        {
                            return getPointerAsync(uuid, db);
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$1 = final__pcls6;
                uuid = String.this;
                super();
            }
                    }).d(object. new i() {

                        final _cls6 this$1;
                        final h val$object;

                        public j then(j j1)
                            throws Exception
                        {
                            object.a(j1.e());
                            return fetchLocallyAsync((ParseObject)object.a(), db);
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$1 = final__pcls6;
                object = h.this;
                super();
            }
                    }).d(constraintmatcher. new i() {

                        final _cls6 this$1;
                        final OfflineQueryLogic.ConstraintMatcher val$matcher;
                        final h val$object;

                        public j then(j j1)
                            throws Exception
                        {
                            if (!((ParseObject)object.a()).isDataAvailable())
                            {
                                return j.a(Boolean.valueOf(false));
                            } else
                            {
                                return matcher.matchesAsync((ParseObject)object.a(), db);
                            }
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$1 = final__pcls6;
                object = h1;
                matcher = OfflineQueryLogic.ConstraintMatcher.this;
                super();
            }
                    }).c(object. new i() {

                        final _cls6 this$1;
                        final h val$object;

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

                        public Void then(j j1)
                        {
                            if (((Boolean)j1.e()).booleanValue())
                            {
                                results.add(object.a());
                            }
                            return null;
                        }

            
            {
                this$1 = final__pcls6;
                object = h.this;
                super();
            }
                    });
                }

                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                queryLogic = offlinequerylogic;
                query = state;
                user = parseuser;
                db = parsesqlitedatabase;
                results = list;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final boolean val$isCount;
            final ParseQuery.State val$query;
            final List val$results;

            public j then(j j1)
                throws Exception
            {
                OfflineQueryLogic.sort(results, query);
                Object obj = results;
                int k = query.skip();
                j1 = ((j) (obj));
                if (!isCount)
                {
                    j1 = ((j) (obj));
                    if (k >= 0)
                    {
                        j1 = ((List) (obj)).subList(Math.min(query.skip(), ((List) (obj)).size()), ((List) (obj)).size());
                    }
                }
                k = query.limit();
                if (!isCount && k >= 0 && j1.size() > k)
                {
                    j1 = j1.subList(0, k);
                }
                obj = j.a(null);
                for (Iterator iterator = j1.iterator(); iterator.hasNext();)
                {
                    obj = ((j) (obj)).d(((ParseObject)iterator.next()). new i() {

                        final _cls5 this$1;
                        final ParseObject val$object;

                        public j then(j j1)
                            throws Exception
                        {
                            return OfflineQueryLogic.fetchIncludesAsync(_fld0, object, query, db);
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$1 = final__pcls5;
                object = ParseObject.this;
                super();
            }
                    });
                }

                return ((j) (obj)).c(j1. new i() {

                    final _cls5 this$1;
                    final List val$finalTrimmedResults;

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

                    public List then(j j1)
                        throws Exception
                    {
                        return finalTrimmedResults;
                    }

            
            {
                this$1 = final__pcls5;
                finalTrimmedResults = List.this;
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
                this$0 = OfflineStore.this;
                results = list;
                query = state;
                isCount = flag;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    private j findFromPinAsync(String s, final ParseQuery.State state, final ParseUser user, final ParseSQLiteDatabase db)
    {
        if (s != null)
        {
            s = getParsePin(s, db);
        } else
        {
            s = j.a(null);
        }
        return s.d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseQuery.State val$state;
            final ParseUser val$user;

            public j then(j j1)
                throws Exception
            {
                j1 = (ParsePin)j1.e();
                return findAsync(state, user, j1, false, db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                state = state1;
                user = parseuser;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    private j getOrCreateUUIDAsync(final ParseObject object, ParseSQLiteDatabase parsesqlitedatabase)
    {
        final String newUUID;
        final a.j.a tcs;
        newUUID = UUID.randomUUID().toString();
        tcs = j.a();
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        j j1 = (j)objectToUuidMap.get(object);
        if (j1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj;
        JVM INSTR monitorexit ;
        return j1;
        objectToUuidMap.put(object, tcs.a());
        uuidToObjectMap.put(newUUID, object);
        fetchedObjects.put(object, tcs.a().c(new i() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public ParseObject then(j j2)
                throws Exception
            {
                return object;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
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
        parsesqlitedatabase.insertOrThrowAsync("ParseObjects", ((ContentValues) (obj))).a(new i() {

            final OfflineStore this$0;
            final String val$newUUID;
            final a.j.a val$tcs;

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            public Void then(j j2)
                throws Exception
            {
                tcs.b(newUUID);
                return null;
            }

            
            {
                this$0 = OfflineStore.this;
                tcs = a;
                newUUID = s;
                super();
            }
        });
        return tcs.a();
        object;
        obj;
        JVM INSTR monitorexit ;
        throw object;
    }

    private j getParsePin(final String name, ParseSQLiteDatabase parsesqlitedatabase)
    {
        return findAsync((new ParseQuery.State.Builder(com/parse/ParsePin)).whereEqualTo("_name", name).build(), null, null, parsesqlitedatabase).c(new i() {

            final OfflineStore this$0;
            final String val$name;

            public ParsePin then(j j1)
                throws Exception
            {
                Object obj;
                if (j1.e() != null && ((List)j1.e()).size() > 0)
                {
                    j1 = (ParsePin)((List)j1.e()).get(0);
                } else
                {
                    j1 = null;
                }
                obj = j1;
                if (j1 == null)
                {
                    obj = (ParsePin)ParseObject.create(com/parse/ParsePin);
                    ((ParsePin) (obj)).setName(name);
                }
                return ((ParsePin) (obj));
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                name = s;
                super();
            }
        });
    }

    private j getPointerAsync(final String uuid, ParseSQLiteDatabase parsesqlitedatabase)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ParseObject parseobject = (ParseObject)uuidToObjectMap.get(uuid);
        if (parseobject == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        uuid = j.a(parseobject);
        obj;
        JVM INSTR monitorexit ;
        return uuid;
        obj;
        JVM INSTR monitorexit ;
        return parsesqlitedatabase.queryAsync("ParseObjects", new String[] {
            "className", "objectId"
        }, "uuid = ?", new String[] {
            uuid
        }).c(new i() {

            final OfflineStore this$0;
            final String val$uuid;

            public ParseObject then(j j1)
                throws Exception
            {
                Object obj1;
                obj1 = (Cursor)j1.e();
                ((Cursor) (obj1)).moveToFirst();
                if (((Cursor) (obj1)).isAfterLast())
                {
                    ((Cursor) (obj1)).close();
                    throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append(uuid).toString());
                }
                j1 = ((j) (lock));
                j1;
                JVM INSTR monitorenter ;
                Object obj2 = (ParseObject)uuidToObjectMap.get(uuid);
                if (obj2 == null)
                {
                    break MISSING_BLOCK_LABEL_96;
                }
                j1;
                JVM INSTR monitorexit ;
                return ((ParseObject) (obj2));
                String s = ((Cursor) (obj1)).getString(0);
                obj2 = ((Cursor) (obj1)).getString(1);
                ((Cursor) (obj1)).close();
                obj1 = ParseObject.createWithoutData(s, ((String) (obj2)));
                if (obj2 != null)
                {
                    break MISSING_BLOCK_LABEL_164;
                }
                uuidToObjectMap.put(uuid, obj1);
                objectToUuidMap.put(obj1, j.a(uuid));
                j1;
                JVM INSTR monitorexit ;
                return ((ParseObject) (obj1));
                Exception exception;
                exception;
                j1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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

    private j pinAllObjectsAsync(String s, final List objects, final boolean includeChildren, final ParseSQLiteDatabase db)
    {
        if (objects == null || objects.size() == 0)
        {
            return j.a(null);
        } else
        {
            return getParsePin(s, db).d(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final boolean val$includeChildren;
                final List val$objects;

                public j then(j j1)
                    throws Exception
                {
                    ParsePin parsepin = (ParsePin)j1.e();
                    j1 = parsepin.getObjects();
                    if (j1 == null)
                    {
                        j1 = new ArrayList(objects);
                    } else
                    {
                        Iterator iterator = objects.iterator();
                        while (iterator.hasNext()) 
                        {
                            ParseObject parseobject = (ParseObject)iterator.next();
                            if (!j1.contains(parseobject))
                            {
                                j1.add(parseobject);
                            }
                        }
                    }
                    parsepin.setObjects(j1);
                    if (includeChildren)
                    {
                        return saveLocallyAsync(parsepin, true, db);
                    } else
                    {
                        return saveLocallyAsync(parsepin, parsepin.getObjects(), db);
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = OfflineStore.this;
                objects = list;
                includeChildren = flag;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
    }

    private j runWithManagedConnection(final SQLiteDatabaseCallable callable)
    {
        return helper.getWritableDatabaseAsync().d(new i() {

            final OfflineStore this$0;
            final SQLiteDatabaseCallable val$callable;

            public j then(j j1)
                throws Exception
            {
                j1 = (ParseSQLiteDatabase)j1.e();
                return ((j)callable.call(j1)).b(j1. new i() {

                    final _cls47 this$1;
                    final ParseSQLiteDatabase val$db;

                    public j then(j j1)
                        throws Exception
                    {
                        db.closeAsync();
                        return j1;
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = final__pcls47;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                callable = sqlitedatabasecallable;
                super();
            }
        });
    }

    private j runWithManagedTransaction(final SQLiteDatabaseCallable callable)
    {
        return helper.getWritableDatabaseAsync().d(new i() {

            final OfflineStore this$0;
            final SQLiteDatabaseCallable val$callable;

            public j then(j j1)
                throws Exception
            {
                j1 = (ParseSQLiteDatabase)j1.e();
                return j1.beginTransactionAsync().d(j1. new i() {

                    final _cls48 this$1;
                    final ParseSQLiteDatabase val$db;

                    public j then(j j1)
                        throws Exception
                    {
                        return ((j)callable.call(db)).d(new i() {

                            final _cls1 this$2;

                            public j then(j j1)
                                throws Exception
                            {
                                return db.setTransactionSuccessfulAsync();
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        }).b(new i() {

                            final _cls1 this$2;

                            public j then(j j1)
                                throws Exception
                            {
                                db.endTransactionAsync();
                                db.closeAsync();
                                return j1;
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = _cls1.this;
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
                this$1 = final__pcls48;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                callable = sqlitedatabasecallable;
                super();
            }
        });
    }

    private j saveLocallyAsync(final ParseObject object, final List objects, final ParseSQLiteDatabase db)
    {
        ArrayList arraylist;
        if (objects != null)
        {
            objects = new ArrayList(objects);
        } else
        {
            objects = new ArrayList();
        }
        if (!objects.contains(object))
        {
            objects.add(object);
        }
        arraylist = new ArrayList();
        for (Iterator iterator = objects.iterator(); iterator.hasNext(); arraylist.add(fetchLocallyAsync((ParseObject)iterator.next(), db).j())) { }
        return j.a(arraylist).b(new i() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public j then(j j1)
                throws Exception
            {
                return (j)objectToUuidMap.get(object);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;

            public j then(j j1)
                throws Exception
            {
                j1 = (String)j1.e();
                if (j1 == null)
                {
                    return null;
                } else
                {
                    return unpinAsync(j1, db);
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseObject val$object;

            public j then(j j1)
                throws Exception
            {
                return getOrCreateUUIDAsync(object, db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                db = parsesqlitedatabase;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final List val$objects;

            public j then(j j1)
                throws Exception
            {
                j1 = (String)j1.e();
                ArrayList arraylist1 = new ArrayList();
                ParseObject parseobject;
                for (Iterator iterator1 = objects.iterator(); iterator1.hasNext(); arraylist1.add(saveLocallyAsync(j1, parseobject, db)))
                {
                    parseobject = (ParseObject)iterator1.next();
                }

                return j.a(arraylist1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                objects = list;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    private j saveLocallyAsync(ParseObject parseobject, boolean flag, ParseSQLiteDatabase parsesqlitedatabase)
    {
        final ArrayList objectsInTree = new ArrayList();
        if (!flag)
        {
            objectsInTree.add(parseobject);
        } else
        {
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
            }).setYieldRoot(true).setTraverseParseObjects(true).traverse(parseobject);
        }
        return saveLocallyAsync(parseobject, ((List) (objectsInTree)), parsesqlitedatabase);
    }

    private j saveLocallyAsync(final String key, final ParseObject object, final ParseSQLiteDatabase db)
    {
        if (object.getObjectId() != null && !object.isDataAvailable() && !object.hasChanges() && !object.hasOutstandingOperations())
        {
            return j.a(null);
        } else
        {
            final h uuidCapture = new h();
            return getOrCreateUUIDAsync(object, db).d(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final ParseObject val$object;
                final h val$uuidCapture;

                public j then(j j1)
                    throws Exception
                {
                    j1 = (String)j1.e();
                    uuidCapture.a(j1);
                    return updateDataForObjectAsync(j1, object, db);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = OfflineStore.this;
                uuidCapture = h1;
                object = parseobject;
                db = parsesqlitedatabase;
                super();
            }
            }).d(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final String val$key;
                final h val$uuidCapture;

                public j then(j j1)
                    throws Exception
                {
                    j1 = new ContentValues();
                    j1.put("key", key);
                    j1.put("uuid", (String)uuidCapture.a());
                    return db.insertWithOnConflict("Dependencies", j1, 4);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = OfflineStore.this;
                key = s;
                uuidCapture = h1;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
    }

    private j unpinAllObjectsAsync(String s, final ParseSQLiteDatabase db)
    {
        return getParsePin(s, db).b(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;

            public j then(j j1)
                throws Exception
            {
                if (j1.d())
                {
                    return j1.j();
                } else
                {
                    j1 = (ParsePin)j1.e();
                    return unpinAsync(j1, db);
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    private j unpinAllObjectsAsync(String s, final List objects, final ParseSQLiteDatabase db)
    {
        if (objects == null || objects.size() == 0)
        {
            return j.a(null);
        } else
        {
            return getParsePin(s, db).d(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final List val$objects;

                public j then(j j1)
                    throws Exception
                {
                    j1 = (ParsePin)j1.e();
                    List list = j1.getObjects();
                    if (list == null)
                    {
                        return j.a(null);
                    }
                    list.removeAll(objects);
                    if (list.size() == 0)
                    {
                        return unpinAsync(j1, db);
                    } else
                    {
                        j1.setObjects(list);
                        return saveLocallyAsync(j1, true, db);
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = OfflineStore.this;
                objects = list;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
    }

    private j unpinAsync(ParseObject parseobject, final ParseSQLiteDatabase db)
    {
        parseobject = (j)objectToUuidMap.get(parseobject);
        if (parseobject == null)
        {
            return j.a(null);
        } else
        {
            return parseobject.b(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;

                public j then(j j1)
                    throws Exception
                {
                    j1 = (String)j1.e();
                    if (j1 == null)
                    {
                        return j.a(null);
                    } else
                    {
                        return unpinAsync(j1, db);
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                super();
            }
            });
        }
    }

    private j unpinAsync(final String key, final ParseSQLiteDatabase db)
    {
        final LinkedList uuidsToDelete = new LinkedList();
        return j.a((Void)null).b(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final String val$key;

            public j then(j j1)
                throws Exception
            {
                j1 = key;
                return db.rawQueryAsync("SELECT uuid FROM Dependencies WHERE key=? AND uuid IN ( SELECT uuid FROM Dependencies GROUP BY uuid HAVING COUNT(uuid)=1)", new String[] {
                    j1
                });
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                key = s;
                db = parsesqlitedatabase;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final List val$uuidsToDelete;

            public j then(j j1)
                throws Exception
            {
                for (j1 = (Cursor)j1.e(); j1.moveToNext(); uuidsToDelete.add(j1.getString(0))) { }
                j1.close();
                return deleteObjects(uuidsToDelete, db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                uuidsToDelete = list;
                db = parsesqlitedatabase;
                super();
            }
        }).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final String val$key;

            public j then(j j1)
                throws Exception
            {
                j1 = key;
                return db.deleteAsync("Dependencies", "key=?", new String[] {
                    j1
                });
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                key = s;
                db = parsesqlitedatabase;
                super();
            }
        }).c(new i() {

            final OfflineStore this$0;
            final List val$uuidsToDelete;

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            public Void then(j j1)
                throws Exception
            {
                j1 = ((j) (lock));
                j1;
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
                j1;
                JVM INSTR monitorexit ;
                throw exception;
                j1;
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

    private j updateDataForObjectAsync(final ParseObject object, final ParseSQLiteDatabase db)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        j j1 = (j)objectToUuidMap.get(object);
        if (j1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        object = j.a(null);
        obj;
        JVM INSTR monitorexit ;
        return object;
        obj;
        JVM INSTR monitorexit ;
        return j1.d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseObject val$object;

            public j then(j j2)
                throws Exception
            {
                j2 = (String)j2.e();
                return updateDataForObjectAsync(j2, object, db);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                db = parsesqlitedatabase;
                super();
            }
        });
        object;
        obj;
        JVM INSTR monitorexit ;
        throw object;
    }

    private j updateDataForObjectAsync(final String uuid, final ParseObject object, final ParseSQLiteDatabase db)
    {
        OfflineEncoder offlineencoder = new OfflineEncoder(db);
        final JSONObject json = object.toRest(offlineencoder);
        return offlineencoder.whenFinished().d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final JSONObject val$json;
            final ParseObject val$object;
            final String val$uuid;

            public j then(j j1)
                throws Exception
            {
                j1 = object.getClassName();
                String s = object.getObjectId();
                int k = json.getInt("__isDeletingEventually");
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("className", j1);
                j1 = json;
                if (!(j1 instanceof JSONObject))
                {
                    j1 = j1.toString();
                } else
                {
                    j1 = JSONObjectInstrumentation.toString((JSONObject)j1);
                }
                contentvalues.put("json", j1);
                if (s != null)
                {
                    contentvalues.put("objectId", s);
                }
                contentvalues.put("isDeletingEventually", Integer.valueOf(k));
                j1 = uuid;
                return db.updateAsync("ParseObjects", contentvalues, "uuid = ?", new String[] {
                    j1
                }).j();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                json = jsonobject;
                uuid = s;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    void clearDatabase(Context context)
    {
        helper.clearDatabase(context);
    }

    j countFromPinAsync(final String name, final ParseQuery.State state, final ParseUser user)
    {
        return runWithManagedConnection(new SQLiteDatabaseCallable() {

            final OfflineStore this$0;
            final String val$name;
            final ParseQuery.State val$state;
            final ParseUser val$user;

            public j call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return countFromPinAsync(name, state, user, parsesqlitedatabase);
            }

            public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return call(parsesqlitedatabase);
            }

            
            {
                this$0 = OfflineStore.this;
                name = s;
                state = state1;
                user = parseuser;
                super();
            }
        });
    }

    j deleteDataForObjectAsync(final ParseObject object)
    {
        return helper.getWritableDatabaseAsync().b(new i() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public j then(j j1)
                throws Exception
            {
                j1 = (ParseSQLiteDatabase)j1.e();
                return j1.beginTransactionAsync().d(j1. new i() {

                    final _cls29 this$1;
                    final ParseSQLiteDatabase val$db;

                    public j then(j j1)
                        throws Exception
                    {
                        return deleteDataForObjectAsync(object, db).d(new i() {

                            final _cls1 this$2;

                            public j then(j j1)
                                throws Exception
                            {
                                return db.setTransactionSuccessfulAsync();
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        }).b(new i() {

                            final _cls1 this$2;

                            public j then(j j1)
                                throws Exception
                            {
                                db.endTransactionAsync();
                                db.closeAsync();
                                return j1;
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = _cls1.this;
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
                this$1 = final__pcls29;
                db = ParseSQLiteDatabase.this;
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
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        });
    }

    j fetchLocallyAsync(final ParseObject object)
    {
        return runWithManagedConnection(new SQLiteDatabaseCallable() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public j call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return fetchLocallyAsync(object, parsesqlitedatabase);
            }

            public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return call(parsesqlitedatabase);
            }

            
            {
                this$0 = OfflineStore.this;
                object = parseobject;
                super();
            }
        });
    }

    j fetchLocallyAsync(final ParseObject object, final ParseSQLiteDatabase db)
    {
        final a.j.a tcs;
label0:
        {
            tcs = j.a();
            synchronized (lock)
            {
                if (!fetchedObjects.containsKey(object))
                {
                    break label0;
                }
                object = (j)fetchedObjects.get(object);
            }
            return object;
        }
        j j1;
        fetchedObjects.put(object, tcs.a());
        j1 = (j)objectToUuidMap.get(object);
        uuid;
        JVM INSTR monitorexit ;
        String s;
        String s1;
        s = object.getClassName();
        s1 = object.getObjectId();
        uuid = j.a(null);
        if (s1 != null) goto _L2; else goto _L1
_L1:
        if (j1 != null)
        {
            uuid = new h();
            uuid = j1.d(new i() {

                final OfflineStore this$0;
                final ParseSQLiteDatabase val$db;
                final String val$select[];
                final h val$uuid;

                public j then(j j2)
                    throws Exception
                {
                    uuid.a(j2.e());
                    j2 = (String)uuid.a();
                    return db.queryAsync("ParseObjects", select, "uuid = ?", new String[] {
                        j2
                    });
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = OfflineStore.this;
                uuid = h1;
                db = parsesqlitedatabase;
                select = as;
                super();
            }
            }).c(new i() {

                final OfflineStore this$0;
                final h val$uuid;

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

                public String then(j j2)
                    throws Exception
                {
                    j2 = (Cursor)j2.e();
                    j2.moveToFirst();
                    if (j2.isAfterLast())
                    {
                        j2.close();
                        throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append((String)uuid.a()).toString());
                    } else
                    {
                        String s2 = j2.getString(0);
                        j2.close();
                        return s2;
                    }
                }

            
            {
                this$0 = OfflineStore.this;
                uuid = h1;
                super();
            }
            });
        }
_L4:
        return ((j) (uuid)).d(new i() {

            final OfflineStore this$0;
            final ParseSQLiteDatabase val$db;
            final ParseObject val$object;

            public j then(final j json)
                throws Exception
            {
                json = (String)json.e();
                if (json == null)
                {
                    return j.a(new ParseException(120, "Attempted to fetch an object offline which was never saved to the offline cache."));
                }
                HashMap hashmap;
                try
                {
                    json = JSONObjectInstrumentation.init(json);
                }
                // Misplaced declaration of an exception variable
                catch (final j json)
                {
                    return j.a(json);
                }
                hashmap = new HashMap();
                (hashmap. new ParseTraverser() {

                    final _cls11 this$1;
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
                this$1 = final__pcls11;
                offlineObjects = Map.this;
                super();
            }
                }).setTraverseParseObjects(false).setYieldRoot(false).traverse(json);
                return j.a(hashmap.values()).c(hashmap. new i() {

                    final _cls11 this$1;
                    final JSONObject val$json;
                    final Map val$offlineObjects;

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

                    public Void then(j j1)
                        throws Exception
                    {
                        object.mergeREST(object.getState(), json, new OfflineDecoder(offlineObjects));
                        return null;
                    }

            
            {
                this$1 = final__pcls11;
                json = jsonobject;
                offlineObjects = Map.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                db = parsesqlitedatabase;
                object = parseobject;
                super();
            }
        }).b(new i() {

            final OfflineStore this$0;
            final ParseObject val$object;
            final a.j.a val$tcs;

            public j then(j j2)
                throws Exception
            {
                if (j2.c())
                {
                    tcs.c();
                } else
                if (j2.d())
                {
                    tcs.b(j2.f());
                } else
                {
                    tcs.b(object);
                }
                return tcs.a();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = OfflineStore.this;
                tcs = a;
                object = parseobject;
                super();
            }
        });
        object;
        uuid;
        JVM INSTR monitorexit ;
        throw object;
_L2:
        if (j1 != null)
        {
            tcs.b(new IllegalStateException("This object must have already been fetched from the local datastore, but isn't marked as fetched."));
            synchronized (lock)
            {
                fetchedObjects.remove(object);
            }
            return tcs.a();
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
        }).c(new i() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            public String then(j j2)
                throws Exception
            {
                Cursor cursor = (Cursor)j2.e();
                cursor.moveToFirst();
                if (cursor.isAfterLast())
                {
                    cursor.close();
                    throw new ParseException(120, "This object is not available in the offline cache.");
                }
                j2 = cursor.getString(0);
                String s2 = cursor.getString(1);
                cursor.close();
                synchronized (lock)
                {
                    objectToUuidMap.put(object, j.a(s2));
                    uuidToObjectMap.put(s2, object);
                }
                return j2;
                j2;
                obj;
                JVM INSTR monitorexit ;
                throw j2;
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

    j findAsync(ParseQuery.State state, ParseUser parseuser, ParsePin parsepin, ParseSQLiteDatabase parsesqlitedatabase)
    {
        return findAsync(state, parseuser, parsepin, false, parsesqlitedatabase);
    }

    j findFromPinAsync(final String name, final ParseQuery.State state, final ParseUser user)
    {
        return runWithManagedConnection(new SQLiteDatabaseCallable() {

            final OfflineStore this$0;
            final String val$name;
            final ParseQuery.State val$state;
            final ParseUser val$user;

            public j call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return findFromPinAsync(name, state, user, parsesqlitedatabase);
            }

            public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return call(parsesqlitedatabase);
            }

            
            {
                this$0 = OfflineStore.this;
                name = s;
                state = state1;
                user = parseuser;
                super();
            }
        });
    }

    ParseObject getObject(String s, String s1)
    {
        if (s1 == null)
        {
            throw new IllegalStateException("objectId cannot be null.");
        }
        s1 = Pair.create(s, s1);
        synchronized (lock)
        {
            s1 = (ParseObject)classNameAndObjectIdToObjectMap.get(s1);
        }
        return s1;
        s1;
        s;
        JVM INSTR monitorexit ;
        throw s1;
    }

    j pinAllObjectsAsync(final String name, final List objects, final boolean includeChildren)
    {
        return runWithManagedTransaction(new SQLiteDatabaseCallable() {

            final OfflineStore this$0;
            final boolean val$includeChildren;
            final String val$name;
            final List val$objects;

            public j call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return pinAllObjectsAsync(name, objects, includeChildren, parsesqlitedatabase);
            }

            public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return call(parsesqlitedatabase);
            }

            
            {
                this$0 = OfflineStore.this;
                name = s;
                objects = list;
                includeChildren = flag;
                super();
            }
        });
    }

    void registerNewObject(ParseObject parseobject)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = parseobject.getObjectId();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        obj1 = Pair.create(parseobject.getClassName(), obj1);
        classNameAndObjectIdToObjectMap.put(obj1, parseobject);
        obj;
        JVM INSTR monitorexit ;
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
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

    j unpinAllObjectsAsync(final String name)
    {
        return runWithManagedTransaction(new SQLiteDatabaseCallable() {

            final OfflineStore this$0;
            final String val$name;

            public j call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return unpinAllObjectsAsync(name, parsesqlitedatabase);
            }

            public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return call(parsesqlitedatabase);
            }

            
            {
                this$0 = OfflineStore.this;
                name = s;
                super();
            }
        });
    }

    j unpinAllObjectsAsync(final String name, final List objects)
    {
        return runWithManagedTransaction(new SQLiteDatabaseCallable() {

            final OfflineStore this$0;
            final String val$name;
            final List val$objects;

            public j call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return unpinAllObjectsAsync(name, objects, parsesqlitedatabase);
            }

            public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
            {
                return call(parsesqlitedatabase);
            }

            
            {
                this$0 = OfflineStore.this;
                name = s;
                objects = list;
                super();
            }
        });
    }

    void unregisterObject(ParseObject parseobject)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        String s = parseobject.getObjectId();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        classNameAndObjectIdToObjectMap.remove(Pair.create(parseobject.getClassName(), s));
        obj;
        JVM INSTR monitorexit ;
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    j updateDataForObjectAsync(final ParseObject object)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        j j1 = (j)fetchedObjects.get(object);
        if (j1 != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        object = j.a(new IllegalStateException("An object cannot be updated if it wasn't fetched."));
        obj;
        JVM INSTR monitorexit ;
        return object;
        obj;
        JVM INSTR monitorexit ;
        return j1.b(new i() {

            final OfflineStore this$0;
            final ParseObject val$object;

            public j then(j j2)
                throws Exception
            {
                if (j2.d())
                {
                    if ((j2.f() instanceof ParseException) && ((ParseException)j2.f()).getCode() == 120)
                    {
                        return j.a(null);
                    } else
                    {
                        return j2.j();
                    }
                } else
                {
                    return helper.getWritableDatabaseAsync().b(new i() {

                        final _cls26 this$1;

                        public j then(j j1)
                            throws Exception
                        {
                            j1 = (ParseSQLiteDatabase)j1.e();
                            return j1.beginTransactionAsync().d(j1. new i() {

                                final _cls1 this$2;
                                final ParseSQLiteDatabase val$db;

                                public j then(j j1)
                                    throws Exception
                                {
                                    return updateDataForObjectAsync(object, db).d(new i() {

                                        final _cls1 this$3;

                                        public j then(j j1)
                                            throws Exception
                                        {
                                            return db.setTransactionSuccessfulAsync();
                                        }

                                        public volatile Object then(j j1)
                                            throws Exception
                                        {
                                            return then(j1);
                                        }

            
            {
                this$3 = _cls1.this;
                super();
            }
                                    }).b(new i() {

                                        final _cls1 this$3;

                                        public j then(j j1)
                                            throws Exception
                                        {
                                            db.endTransactionAsync();
                                            db.closeAsync();
                                            return j1;
                                        }

                                        public volatile Object then(j j1)
                                            throws Exception
                                        {
                                            return then(j1);
                                        }

            
            {
                this$3 = _cls1.this;
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
                this$2 = final__pcls1;
                db = ParseSQLiteDatabase.this;
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
                this$1 = _cls26.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
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
