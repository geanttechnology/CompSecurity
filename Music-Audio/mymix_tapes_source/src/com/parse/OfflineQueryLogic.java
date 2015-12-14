// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseException, Parse, ParseQuery, ParseObject, 
//            OfflineStore, PointerEncodingStrategy, ParseACL, ParseGeoPoint, 
//            ParseSQLiteDatabase, ParseUser, ParseRelation

class OfflineQueryLogic
{
    static interface ConstraintMatcher
    {

        public abstract Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase);
    }

    private static interface Decider
    {

        public abstract boolean decide(Object obj, Object obj1);
    }

    private abstract class SubQueryMatcher
        implements ConstraintMatcher
    {

        private final ParseQuery subQuery;
        private Task subQueryResults;
        final OfflineQueryLogic this$0;

        protected abstract boolean matches(ParseObject parseobject, List list)
            throws ParseException;

        public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            if (subQueryResults == null)
            {
                ParseUser parseuser = ParseUser.getCurrentUser();
                subQueryResults = store.findAsync(subQuery, parseuser, null, false, false, false, parsesqlitedatabase);
            }
            return subQueryResults.onSuccess(parseobject. new Continuation() {

                final SubQueryMatcher this$1;
                final ParseObject val$object;

                public Boolean then(Task task)
                    throws ParseException
                {
                    return Boolean.valueOf(matches(object, (List)task.getResult()));
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$1 = final_subquerymatcher;
                object = ParseObject.this;
                super();
            }
            });
        }

        public SubQueryMatcher(ParseQuery parsequery)
        {
            this$0 = OfflineQueryLogic.this;
            super();
            subQueryResults = null;
            subQuery = parsequery;
        }
    }


    private final OfflineStore store;

    OfflineQueryLogic(OfflineStore offlinestore)
    {
        store = offlinestore;
    }

    private static boolean compare(Object obj, Object obj1, Decider decider)
    {
        if (obj1 instanceof List)
        {
            return compareList(obj, (List)obj1, decider);
        }
        if (obj1 instanceof JSONArray)
        {
            return compareArray(obj, (JSONArray)obj1, decider);
        } else
        {
            return decider.decide(obj, obj1);
        }
    }

    private static boolean compareArray(Object obj, JSONArray jsonarray, Decider decider)
    {
        for (int i = 0; i < jsonarray.length(); i++)
        {
            boolean flag;
            try
            {
                flag = decider.decide(obj, jsonarray.get(i));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
            if (flag)
            {
                return true;
            }
        }

        return false;
    }

    private static boolean compareList(Object obj, List list, Decider decider)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (decider.decide(obj, list.next()))
            {
                return true;
            }
        }

        return false;
    }

    private static int compareTo(Object obj, Object obj1)
    {
        boolean flag;
        boolean flag1;
        if (obj == JSONObject.NULL || obj == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (obj1 == JSONObject.NULL || obj1 == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || flag1)
        {
            if (!flag)
            {
                return 1;
            }
            return flag1 ? 0 : -1;
        }
        if ((obj instanceof Date) && (obj1 instanceof Date))
        {
            return ((Date)obj).compareTo((Date)obj1);
        }
        if ((obj instanceof String) && (obj1 instanceof String))
        {
            return ((String)obj).compareTo((String)obj1);
        }
        if ((obj instanceof Number) && (obj1 instanceof Number))
        {
            return Parse.compareNumbers((Number)obj, (Number)obj1);
        } else
        {
            throw new IllegalArgumentException(String.format("Cannot compare %s against %s", new Object[] {
                obj, obj1
            }));
        }
    }

    private ConstraintMatcher createDontSelectMatcher(Object obj, String s)
    {
        return new ConstraintMatcher() {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$selectMatcher;

            public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                return selectMatcher.matchesAsync(parseobject, parsesqlitedatabase).onSuccess(new Continuation() {

                    final _cls9 this$1;

                    public Boolean then(Task task)
                        throws Exception
                    {
                        boolean flag;
                        if (!((Boolean)task.getResult()).booleanValue())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        return Boolean.valueOf(flag);
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                selectMatcher = constraintmatcher;
                super();
            }
        };
    }

    private ConstraintMatcher createInQueryMatcher(Object obj, String s)
    {
        return new SubQueryMatcher(s) {

            final OfflineQueryLogic this$0;
            final String val$key;

            protected boolean matches(ParseObject parseobject, List list)
                throws ParseException
            {
                return OfflineQueryLogic.matchesInConstraint(list, getValue(parseobject, key));
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                key = s;
                super(final_parsequery);
            }
        };
    }

    private ConstraintMatcher createMatcher(ParseQuery.QueryConstraints queryconstraints)
    {
        final ArrayList matchers = new ArrayList();
        for (Iterator iterator = queryconstraints.keySet().iterator(); iterator.hasNext();)
        {
            final String key = (String)iterator.next();
            final Object queryConstraintValue = queryconstraints.get(key);
            if (key.equals("$or"))
            {
                matchers.add(createOrMatcher((ArrayList)queryConstraintValue));
            } else
            if (queryConstraintValue instanceof ParseQuery.KeyConstraints)
            {
                queryConstraintValue = (ParseQuery.KeyConstraints)queryConstraintValue;
                Iterator iterator1 = ((ParseQuery.KeyConstraints) (queryConstraintValue)).keySet().iterator();
                while (iterator1.hasNext()) 
                {
                    String s = (String)iterator1.next();
                    matchers.add(createMatcher(s, ((ParseQuery.KeyConstraints) (queryConstraintValue)).get(s), key, ((ParseQuery.KeyConstraints) (queryConstraintValue))));
                }
            } else
            if (queryConstraintValue instanceof ParseQuery.RelationConstraint)
            {
                matchers.add(new ConstraintMatcher() {

                    final OfflineQueryLogic this$0;
                    final ParseQuery.RelationConstraint val$relation;

                    public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                    {
                        return Task.forResult(Boolean.valueOf(relation.getRelation().hasKnownObject(parseobject)));
                    }

            
            {
                this$0 = OfflineQueryLogic.this;
                relation = relationconstraint;
                super();
            }
                });
            } else
            {
                matchers.add(new ConstraintMatcher() {

                    final OfflineQueryLogic this$0;
                    final String val$key;
                    final Object val$queryConstraintValue;

                    public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                    {
                        try
                        {
                            parseobject = ((ParseObject) (getValue(parseobject, key)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            return Task.forError(parseobject);
                        }
                        return Task.forResult(Boolean.valueOf(OfflineQueryLogic.matchesEqualConstraint(queryConstraintValue, parseobject)));
                    }

            
            {
                this$0 = OfflineQueryLogic.this;
                key = s;
                queryConstraintValue = obj;
                super();
            }
                });
            }
        }

        return new ConstraintMatcher() {

            final OfflineQueryLogic this$0;
            final ArrayList val$matchers;

            public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                Task task = Task.forResult(Boolean.valueOf(true));
                for (Iterator iterator2 = matchers.iterator(); iterator2.hasNext();)
                {
                    task = task.onSuccessTask(parsesqlitedatabase. new Continuation() {

                        final _cls14 this$1;
                        final ParseSQLiteDatabase val$db;
                        final ConstraintMatcher val$matcher;
                        final ParseObject val$object;

                        public Task then(Task task)
                            throws Exception
                        {
                            if (!((Boolean)task.getResult()).booleanValue())
                            {
                                return task;
                            } else
                            {
                                return matcher.matchesAsync(object, db);
                            }
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls14;
                matcher = constraintmatcher;
                object = parseobject;
                db = ParseSQLiteDatabase.this;
                super();
            }
                    });
                }

                return task;
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                matchers = arraylist;
                super();
            }
        };
    }

    private ConstraintMatcher createMatcher(final String operator, final Object constraint, final String key, final ParseQuery.KeyConstraints allKeyConstraints)
    {
        if (operator.equals("$inQuery"))
        {
            return createInQueryMatcher(constraint, key);
        }
        if (operator.equals("$notInQuery"))
        {
            return createNotInQueryMatcher(constraint, key);
        }
        if (operator.equals("$select"))
        {
            return createSelectMatcher(constraint, key);
        }
        if (operator.equals("$dontSelect"))
        {
            return createDontSelectMatcher(constraint, key);
        } else
        {
            return new ConstraintMatcher() {

                final OfflineQueryLogic this$0;
                final ParseQuery.KeyConstraints val$allKeyConstraints;
                final Object val$constraint;
                final String val$key;
                final String val$operator;

                public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                {
                    try
                    {
                        parseobject = ((ParseObject) (getValue(parseobject, key)));
                        parseobject = Task.forResult(Boolean.valueOf(OfflineQueryLogic.matchesStatelessConstraint(operator, constraint, parseobject, allKeyConstraints)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (ParseObject parseobject)
                    {
                        return Task.forError(parseobject);
                    }
                    return parseobject;
                }

            
            {
                this$0 = OfflineQueryLogic.this;
                key = s;
                operator = s1;
                constraint = obj;
                allKeyConstraints = keyconstraints;
                super();
            }
            };
        }
    }

    private ConstraintMatcher createNotInQueryMatcher(Object obj, String s)
    {
        return new ConstraintMatcher() {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$inQueryMatcher;

            public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                return inQueryMatcher.matchesAsync(parseobject, parsesqlitedatabase).onSuccess(new Continuation() {

                    final _cls7 this$1;

                    public Boolean then(Task task)
                        throws Exception
                    {
                        boolean flag;
                        if (!((Boolean)task.getResult()).booleanValue())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        return Boolean.valueOf(flag);
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                });
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                inQueryMatcher = constraintmatcher;
                super();
            }
        };
    }

    private ConstraintMatcher createOrMatcher(ArrayList arraylist)
    {
        final ArrayList matchers = new ArrayList();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); matchers.add(createMatcher((ParseQuery.QueryConstraints)arraylist.next()))) { }
        return new ConstraintMatcher() {

            final OfflineQueryLogic this$0;
            final ArrayList val$matchers;

            public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                Task task = Task.forResult(Boolean.valueOf(false));
                for (Iterator iterator = matchers.iterator(); iterator.hasNext();)
                {
                    task = task.onSuccessTask(parsesqlitedatabase. new Continuation() {

                        final _cls11 this$1;
                        final ParseSQLiteDatabase val$db;
                        final ConstraintMatcher val$matcher;
                        final ParseObject val$object;

                        public Task then(Task task)
                            throws Exception
                        {
                            if (((Boolean)task.getResult()).booleanValue())
                            {
                                return task;
                            } else
                            {
                                return matcher.matchesAsync(object, db);
                            }
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls11;
                matcher = constraintmatcher;
                object = parseobject;
                db = ParseSQLiteDatabase.this;
                super();
            }
                    });
                }

                return task;
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                matchers = arraylist;
                super();
            }
        };
    }

    private ConstraintMatcher createSelectMatcher(Object obj, String s)
    {
        obj = (JSONObject)obj;
        return new SubQueryMatcher(((JSONObject) (obj)).optString("key", null)) {

            final OfflineQueryLogic this$0;
            final String val$key;
            final String val$resultKey;

            protected boolean matches(ParseObject parseobject, List list)
                throws ParseException
            {
                parseobject = ((ParseObject) (getValue(parseobject, key)));
                for (list = list.iterator(); list.hasNext();)
                {
                    ParseObject parseobject1 = (ParseObject)list.next();
                    if (OfflineQueryLogic.matchesEqualConstraint(parseobject, getValue(parseobject1, resultKey)))
                    {
                        return true;
                    }
                }

                return false;
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                key = s;
                resultKey = s1;
                super(final_parsequery);
            }
        };
    }

    private Task fetchIncludeAsync(final Object container, final String path, final ParseSQLiteDatabase db)
        throws ParseException
    {
        if (container != null) goto _L2; else goto _L1
_L1:
        container = Task.forResult(null);
_L4:
        return ((Task) (container));
_L2:
        if (container instanceof JSONArray)
        {
            final JSONArray array = (JSONArray)container;
            Task task = Task.forResult(null);
            final int index = 0;
            do
            {
                container = task;
                if (index >= array.length())
                {
                    continue; /* Loop/switch isn't completed */
                }
                task = task.onSuccessTask(new Continuation() {

                    final OfflineQueryLogic this$0;
                    final JSONArray val$array;
                    final ParseSQLiteDatabase val$db;
                    final int val$index;
                    final String val$path;

                    public Task then(Task task2)
                        throws Exception
                    {
                        return fetchIncludeAsync(array.get(index), path, db);
                    }

                    public volatile Object then(Task task2)
                        throws Exception
                    {
                        return then(task2);
                    }

            
            {
                this$0 = OfflineQueryLogic.this;
                array = jsonarray;
                index = i;
                path = s;
                db = parsesqlitedatabase;
                super();
            }
                });
                index++;
            } while (true);
        }
label0:
        {
            if (!(container instanceof List))
            {
                break label0;
            }
            container = (List)container;
            Task task1 = Task.forResult(null);
            Iterator iterator = ((List) (container)).iterator();
            do
            {
                container = task1;
                if (!iterator.hasNext())
                {
                    break;
                }
                task1 = task1.onSuccessTask(new Continuation() {

                    final OfflineQueryLogic this$0;
                    final ParseSQLiteDatabase val$db;
                    final Object val$item;
                    final String val$path;

                    public Task then(Task task2)
                        throws Exception
                    {
                        return fetchIncludeAsync(item, path, db);
                    }

                    public volatile Object then(Task task2)
                        throws Exception
                    {
                        return then(task2);
                    }

            
            {
                this$0 = OfflineQueryLogic.this;
                item = obj;
                path = s;
                db = parsesqlitedatabase;
                super();
            }
                });
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (path == null)
        {
            if (!(container instanceof ParseObject))
            {
                return Task.forError(new ParseException(121, "include is invalid for non-ParseObjects"));
            } else
            {
                container = (ParseObject)container;
                return store.fetchLocallyAsync(((ParseObject) (container)), db).makeVoid();
            }
        }
        path = path.split("\\.", 2);
        final String key = path[0];
        if (path.length > 1)
        {
            path = path[1];
        } else
        {
            path = null;
        }
        return Task.forResult(null).continueWithTask(new Continuation() {

            final OfflineQueryLogic this$0;
            final Object val$container;
            final ParseSQLiteDatabase val$db;
            final String val$key;

            public Task then(Task task2)
                throws Exception
            {
                if (container instanceof ParseObject)
                {
                    return fetchIncludeAsync(container, null, db).onSuccess(new Continuation() {

                        final _cls20 this$1;

                        public Object then(Task task)
                            throws Exception
                        {
                            return ((ParseObject)container).get(key);
                        }

            
            {
                this$1 = _cls20.this;
                super();
            }
                    });
                }
                if (container instanceof Map)
                {
                    return Task.forResult(((Map)container).get(key));
                }
                if (container instanceof JSONObject)
                {
                    return Task.forResult(((JSONObject)container).opt(key));
                } else
                {
                    return Task.forError(new IllegalStateException("include is invalid"));
                }
            }

            public volatile Object then(Task task2)
                throws Exception
            {
                return then(task2);
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                container = obj;
                db = parsesqlitedatabase;
                key = s;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final OfflineQueryLogic this$0;
            final ParseSQLiteDatabase val$db;
            final String val$rest;

            public Task then(Task task2)
                throws Exception
            {
                return fetchIncludeAsync(task2.getResult(), rest, db);
            }

            public volatile Object then(Task task2)
                throws Exception
            {
                return then(task2);
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                rest = s;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    private Object getValue(Object obj, String s)
        throws ParseException
    {
        return getValue(obj, s, 0);
    }

    private Object getValue(Object obj, String s, int i)
        throws ParseException
    {
        String as[] = null;
        if (!s.contains(".")) goto _L2; else goto _L1
_L1:
        Object obj1;
        as = s.split("\\.", 2);
        obj1 = getValue(obj, as[0], i + 1);
        if (obj1 == null || obj1 == JSONObject.NULL || (obj1 instanceof Map) || (obj1 instanceof JSONObject)) goto _L4; else goto _L3
_L3:
        if (i <= 0) goto _L6; else goto _L5
_L5:
        obj = null;
        obj1 = Parse.encode(obj1, PointerEncodingStrategy.get());
        obj = obj1;
_L12:
        if (!(obj instanceof JSONObject)) goto _L6; else goto _L7
_L7:
        obj1 = getValue(obj, as[1], i + 1);
_L9:
        return obj1;
_L6:
        throw new ParseException(102, String.format("Key %s is invalid.", new Object[] {
            s
        }));
_L4:
        return getValue(obj1, as[1], i + 1);
_L2:
        if (obj instanceof ParseObject)
        {
            obj = (ParseObject)obj;
            if (!((ParseObject) (obj)).isDataAvailable())
            {
                throw new ParseException(121, String.format("Bad key: %s", new Object[] {
                    s
                }));
            }
            if (s.equals("objectId"))
            {
                return ((ParseObject) (obj)).getObjectId();
            }
            if (s.equals("createdAt") || s.equals("_created_at"))
            {
                return ((ParseObject) (obj)).getCreatedAt();
            }
            if (s.equals("updatedAt") || s.equals("_updated_at"))
            {
                return ((ParseObject) (obj)).getUpdatedAt();
            } else
            {
                return ((ParseObject) (obj)).get(s);
            }
        }
        if (obj instanceof JSONObject)
        {
            return ((JSONObject)obj).opt(s);
        }
        if (obj instanceof Map)
        {
            return ((Map)obj).get(s);
        }
        obj1 = as;
        if (obj == JSONObject.NULL) goto _L9; else goto _L8
_L8:
        obj1 = as;
        if (obj == null) goto _L9; else goto _L10
_L10:
        throw new ParseException(121, String.format("Bad key: %s", new Object[] {
            s
        }));
        Exception exception;
        exception;
        if (true) goto _L12; else goto _L11
_L11:
    }

    static boolean hasReadAccess(ParseUser parseuser, ParseObject parseobject)
    {
        if (parseuser != parseobject)
        {
            if ((parseobject = parseobject.getACL()) != null && !parseobject.getPublicReadAccess() && (parseuser == null || !parseobject.getReadAccess(parseuser)))
            {
                return false;
            }
        }
        return true;
    }

    static boolean hasWriteAccess(ParseUser parseuser, ParseObject parseobject)
    {
        if (parseuser != parseobject)
        {
            if ((parseobject = parseobject.getACL()) != null && !parseobject.getPublicWriteAccess() && (parseuser == null || !parseobject.getWriteAccess(parseuser)))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean matchesAllConstraint(Object obj, Object obj1)
    {
        if (obj instanceof List)
        {
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext();)
            {
                if (!matchesInConstraint(obj1, ((Iterator) (obj)).next()))
                {
                    return false;
                }
            }

            return true;
        } else
        if (obj instanceof JSONArray)
        {
            for (int i = 0; i < ((JSONArray)obj).length(); i++)
            {
                if (!matchesInConstraint(obj1, ((JSONArray)obj).opt(i)))
                {
                    return false;
                }
            }

            return true;
        } else
        {
            throw new IllegalArgumentException("Value type not supported for $all queries.");
        }
    }

    private static boolean matchesEqualConstraint(Object obj, Object obj1)
    {
        if (obj != null && obj1 != null) goto _L2; else goto _L1
_L1:
        if (obj != obj1) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if ((obj instanceof Number) && (obj1 instanceof Number))
        {
            if (compareTo(obj, obj1) != 0)
            {
                return false;
            }
        } else
        {
            return compare(obj, obj1, new Decider() {

                public boolean decide(Object obj2, Object obj3)
                {
                    return obj2.equals(obj3);
                }

            });
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private static boolean matchesExistsConstraint(Object obj, Object obj1)
    {
        boolean flag = false;
        if (obj != null && ((Boolean)obj).booleanValue())
        {
            return obj1 != null && obj1 != JSONObject.NULL;
        }
        if (obj1 == null || obj1 == JSONObject.NULL)
        {
            flag = true;
        }
        return flag;
    }

    private static boolean matchesGreaterThanConstraint(Object obj, Object obj1)
    {
        return compare(obj, obj1, new Decider() {

            public boolean decide(Object obj2, Object obj3)
            {
                while (obj3 == null || obj3 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj2, obj3) >= 0) 
                {
                    return false;
                }
                return true;
            }

        });
    }

    private static boolean matchesGreaterThanOrEqualToConstraint(Object obj, Object obj1)
    {
        return compare(obj, obj1, new Decider() {

            public boolean decide(Object obj2, Object obj3)
            {
                while (obj3 == null || obj3 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj2, obj3) > 0) 
                {
                    return false;
                }
                return true;
            }

        });
    }

    private static boolean matchesInConstraint(Object obj, Object obj1)
    {
        if (obj instanceof List)
        {
            return ((List)obj).contains(obj1);
        }
        if (obj instanceof JSONArray)
        {
            for (int i = 0; i < ((JSONArray)obj).length(); i++)
            {
                if (((JSONArray)obj).opt(i).equals(obj1))
                {
                    return true;
                }
            }

            return false;
        }
        if (obj == JSONObject.NULL)
        {
            return false;
        }
        if (obj == null)
        {
            return false;
        } else
        {
            throw new IllegalArgumentException("Value type not supported for $in queries.");
        }
    }

    private static boolean matchesLessThanConstraint(Object obj, Object obj1)
    {
        return compare(obj, obj1, new Decider() {

            public boolean decide(Object obj2, Object obj3)
            {
                while (obj3 == null || obj3 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj2, obj3) <= 0) 
                {
                    return false;
                }
                return true;
            }

        });
    }

    private static boolean matchesLessThanOrEqualToConstraint(Object obj, Object obj1)
    {
        return compare(obj, obj1, new Decider() {

            public boolean decide(Object obj2, Object obj3)
            {
                while (obj3 == null || obj3 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj2, obj3) < 0) 
                {
                    return false;
                }
                return true;
            }

        });
    }

    private static boolean matchesNearSphereConstraint(Object obj, Object obj1, Double double1)
    {
        boolean flag1 = true;
        boolean flag;
        if (obj1 == null || obj1 == JSONObject.NULL)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (double1 != null)
            {
                flag = flag1;
                if (((ParseGeoPoint)obj).distanceInRadiansTo((ParseGeoPoint)obj1) > double1.doubleValue())
                {
                    return false;
                }
            }
        }
        return flag;
    }

    private static boolean matchesNotEqualConstraint(Object obj, Object obj1)
    {
        return !matchesEqualConstraint(obj, obj1);
    }

    private static boolean matchesNotInConstraint(Object obj, Object obj1)
    {
        return !matchesInConstraint(obj, obj1);
    }

    private static boolean matchesRegexConstraint(Object obj, Object obj1, String s)
        throws ParseException
    {
        if (obj1 == null || obj1 == JSONObject.NULL)
        {
            return false;
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        if (!s1.matches("^[imxs]*$"))
        {
            throw new ParseException(102, String.format("Invalid regex options: %s", new Object[] {
                s1
            }));
        }
        int j = 0;
        if (s1.contains("i"))
        {
            j = 0 | 2;
        }
        int i = j;
        if (s1.contains("m"))
        {
            i = j | 8;
        }
        j = i;
        if (s1.contains("x"))
        {
            j = i | 4;
        }
        i = j;
        if (s1.contains("s"))
        {
            i = j | 0x20;
        }
        return Pattern.compile((String)obj, i).matcher((String)obj1).find();
    }

    private static boolean matchesStatelessConstraint(String s, Object obj, Object obj1, ParseQuery.KeyConstraints keyconstraints)
        throws ParseException
    {
        boolean flag1 = true;
        boolean flag;
        if (s.equals("$ne"))
        {
            flag = matchesNotEqualConstraint(obj, obj1);
        } else
        {
            if (s.equals("$lt"))
            {
                return matchesLessThanConstraint(obj, obj1);
            }
            if (s.equals("$lte"))
            {
                return matchesLessThanOrEqualToConstraint(obj, obj1);
            }
            if (s.equals("$gt"))
            {
                return matchesGreaterThanConstraint(obj, obj1);
            }
            if (s.equals("$gte"))
            {
                return matchesGreaterThanOrEqualToConstraint(obj, obj1);
            }
            if (s.equals("$in"))
            {
                return matchesInConstraint(obj, obj1);
            }
            if (s.equals("$nin"))
            {
                return matchesNotInConstraint(obj, obj1);
            }
            if (s.equals("$all"))
            {
                return matchesAllConstraint(obj, obj1);
            }
            if (s.equals("$regex"))
            {
                return matchesRegexConstraint(obj, obj1, (String)keyconstraints.get("$options"));
            }
            flag = flag1;
            if (!s.equals("$options"))
            {
                if (s.equals("$exists"))
                {
                    return matchesExistsConstraint(obj, obj1);
                }
                if (s.equals("$nearSphere"))
                {
                    return matchesNearSphereConstraint(obj, obj1, (Double)keyconstraints.get("$maxDistance"));
                }
                flag = flag1;
                if (!s.equals("$maxDistance"))
                {
                    if (s.equals("$within"))
                    {
                        return matchesWithinConstraint(obj, obj1);
                    } else
                    {
                        throw new UnsupportedOperationException(String.format("The offline store does not yet support the %s operator.", new Object[] {
                            s
                        }));
                    }
                }
            }
        }
        return flag;
    }

    private static boolean matchesWithinConstraint(Object obj, Object obj1)
        throws ParseException
    {
        Object obj2 = (ArrayList)((HashMap)obj).get("$box");
        obj = (ParseGeoPoint)((ArrayList) (obj2)).get(0);
        obj2 = (ParseGeoPoint)((ArrayList) (obj2)).get(1);
        obj1 = (ParseGeoPoint)obj1;
        if (((ParseGeoPoint) (obj2)).getLongitude() < ((ParseGeoPoint) (obj)).getLongitude())
        {
            throw new ParseException(102, "whereWithinGeoBox queries cannot cross the International Date Line.");
        }
        if (((ParseGeoPoint) (obj2)).getLatitude() < ((ParseGeoPoint) (obj)).getLatitude())
        {
            throw new ParseException(102, "The southwest corner of a geo box must be south of the northeast corner.");
        }
        if (((ParseGeoPoint) (obj2)).getLongitude() - ((ParseGeoPoint) (obj)).getLongitude() > 180D)
        {
            throw new ParseException(102, "Geo box queries larger than 180 degrees in longitude are not supported. Please check point order.");
        }
        return ((ParseGeoPoint) (obj1)).getLatitude() >= ((ParseGeoPoint) (obj)).getLatitude() && ((ParseGeoPoint) (obj1)).getLatitude() <= ((ParseGeoPoint) (obj2)).getLatitude() && ((ParseGeoPoint) (obj1)).getLongitude() >= ((ParseGeoPoint) (obj)).getLongitude() && ((ParseGeoPoint) (obj1)).getLongitude() <= ((ParseGeoPoint) (obj2)).getLongitude();
    }

    ConstraintMatcher createMatcher(ParseQuery parsequery, final ParseUser user, final boolean ignoreACLs)
    {
        return new ConstraintMatcher() {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$constraintMatcher;
            final boolean val$ignoreACLs;
            final ParseUser val$user;

            public Task matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                if (!ignoreACLs && !OfflineQueryLogic.hasReadAccess(user, parseobject))
                {
                    return Task.forResult(Boolean.valueOf(false));
                } else
                {
                    return constraintMatcher.matchesAsync(parseobject, parsesqlitedatabase);
                }
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                ignoreACLs = flag;
                user = parseuser;
                constraintMatcher = constraintmatcher;
                super();
            }
        };
    }

    Task fetchIncludes(final ParseObject object, ParseQuery parsequery, ParseSQLiteDatabase parsesqlitedatabase)
    {
        Object obj = parsequery.getIncludes();
        parsequery = Task.forResult(null);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            parsequery = parsequery.onSuccessTask(new Continuation() {

                final OfflineQueryLogic this$0;
                final ParseSQLiteDatabase val$db;
                final String val$include;
                final ParseObject val$object;

                public Task then(Task task)
                    throws Exception
                {
                    return fetchIncludeAsync(object, include, db);
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = OfflineQueryLogic.this;
                object = parseobject;
                include = s;
                db = parsesqlitedatabase;
                super();
            }
            });
        }

        return parsequery;
    }

    void sort(List list, ParseQuery parsequery)
        throws ParseException
    {
        final String keys[] = parsequery.sortKeys();
        int j = keys.length;
        for (int i = 0; i < j; i++)
        {
            String s = keys[i];
            if (!s.matches("^-?[A-Za-z][A-Za-z0-9_]*$") && !"_created_at".equals(s) && !"_updated_at".equals(s))
            {
                throw new ParseException(105, String.format("Invalid key name: \"%s\".", new Object[] {
                    s
                }));
            }
        }

        final String nearSphereKey = null;
        final ParseGeoPoint nearSphereValue = null;
        Iterator iterator = parsequery.getConstraints().keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            Object obj = parsequery.getConstraints().get(s1);
            if (obj instanceof ParseQuery.KeyConstraints)
            {
                obj = (ParseQuery.KeyConstraints)obj;
                if (((ParseQuery.KeyConstraints) (obj)).containsKey("$nearSphere"))
                {
                    nearSphereKey = s1;
                    nearSphereValue = (ParseGeoPoint)((ParseQuery.KeyConstraints) (obj)).get("$nearSphere");
                }
            }
        } while (true);
        if (keys.length == 0 && nearSphereKey == null)
        {
            return;
        } else
        {
            Collections.sort(list, new Comparator() {

                final OfflineQueryLogic this$0;
                final String val$keys[];
                final String val$nearSphereKey;
                final ParseGeoPoint val$nearSphereValue;

                public int compare(ParseObject parseobject, ParseObject parseobject1)
                {
                    if (nearSphereKey != null)
                    {
                        double d;
                        double d1;
                        ParseGeoPoint parsegeopoint;
                        ParseGeoPoint parsegeopoint1;
                        try
                        {
                            parsegeopoint = (ParseGeoPoint)getValue(parseobject, nearSphereKey);
                            parsegeopoint1 = (ParseGeoPoint)getValue(parseobject1, nearSphereKey);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            throw new RuntimeException(parseobject);
                        }
                        d = parsegeopoint.distanceInRadiansTo(nearSphereValue);
                        d1 = parsegeopoint1.distanceInRadiansTo(nearSphereValue);
                        if (d != d1)
                        {
                            return d - d1 <= 0.0D ? -1 : 1;
                        }
                    }
                    String as[] = keys;
                    int i1 = as.length;
                    String s2;
                    for (int k = 0; k < i1; k++)
                    {
                        Object obj1 = as[k];
                        boolean flag = false;
                        s2 = ((String) (obj1));
                        if (((String) (obj1)).startsWith("-"))
                        {
                            flag = true;
                            s2 = ((String) (obj1)).substring(1);
                        }
                        Object obj2;
                        int l;
                        try
                        {
                            obj1 = getValue(parseobject, s2);
                            obj2 = getValue(parseobject1, s2);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            throw new RuntimeException(parseobject);
                        }
                        try
                        {
                            l = OfflineQueryLogic.compareTo(obj1, obj2);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            throw new IllegalArgumentException(String.format("Unable to sort by key %s.", new Object[] {
                                s2
                            }), parseobject);
                        }
                        if (l != 0)
                        {
                            k = l;
                            if (flag)
                            {
                                k = -l;
                            }
                            return k;
                        }
                    }

                    return 0;
                }

                public volatile int compare(Object obj1, Object obj2)
                {
                    return compare((ParseObject)obj1, (ParseObject)obj2);
                }

            
            {
                this$0 = OfflineQueryLogic.this;
                nearSphereKey = s;
                nearSphereValue = parsegeopoint;
                keys = as;
                super();
            }
            });
            return;
        }
    }







}
