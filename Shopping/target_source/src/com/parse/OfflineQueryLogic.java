// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Collection;
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
//            ParseException, Numbers, ParseObject, OfflineStore, 
//            PointerEncoder, ParseACL, ParseGeoPoint, ParseSQLiteDatabase, 
//            ParseUser, ParseRelation

class OfflineQueryLogic
{
    abstract class ConstraintMatcher
    {

        final OfflineQueryLogic this$0;
        final ParseUser user;

        abstract j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase);

        public ConstraintMatcher(ParseUser parseuser)
        {
            this$0 = OfflineQueryLogic.this;
            super();
            user = parseuser;
        }
    }

    private static interface Decider
    {

        public abstract boolean decide(Object obj, Object obj1);
    }

    private abstract class SubQueryMatcher extends ConstraintMatcher
    {

        private final ParseQuery.State subQuery;
        private j subQueryResults;
        final OfflineQueryLogic this$0;

        protected abstract boolean matches(ParseObject parseobject, List list)
            throws ParseException;

        public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            if (subQueryResults == null)
            {
                subQueryResults = store.findAsync(subQuery, user, null, parsesqlitedatabase);
            }
            return subQueryResults.c(parseobject. new i() {

                final SubQueryMatcher this$1;
                final ParseObject val$object;

                public Boolean then(j j1)
                    throws ParseException
                {
                    return Boolean.valueOf(matches(object, (List)j1.e()));
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$1 = final_subquerymatcher;
                object = ParseObject.this;
                super();
            }
            });
        }

        public SubQueryMatcher(ParseUser parseuser, ParseQuery.State state)
        {
            this$0 = OfflineQueryLogic.this;
            super(parseuser);
            subQueryResults = null;
            subQuery = state;
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
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < jsonarray.length())
                {
                    try
                    {
                        flag = decider.decide(obj, jsonarray.get(i));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new RuntimeException(((Throwable) (obj)));
                    }
                    if (!flag)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
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
            return Numbers.compare((Number)obj, (Number)obj1);
        } else
        {
            throw new IllegalArgumentException(String.format("Cannot compare %s against %s", new Object[] {
                obj, obj1
            }));
        }
    }

    private ConstraintMatcher createDontSelectMatcher(final ParseUser final_parseuser, Object obj, String s)
    {
        return new ConstraintMatcher(createSelectMatcher(final_parseuser, obj, s)) {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$selectMatcher;

            public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                return selectMatcher.matchesAsync(parseobject, parsesqlitedatabase).c(new i() {

                    final _cls9 this$1;

                    public Boolean then(j j1)
                        throws Exception
                    {
                        boolean flag;
                        if (!((Boolean)j1.e()).booleanValue())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        return Boolean.valueOf(flag);
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
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
                super(final_parseuser);
            }
        };
    }

    private ConstraintMatcher createInQueryMatcher(final ParseUser final_parseuser, Object obj, String s)
    {
        return new SubQueryMatcher(((ParseQuery.State.Builder)obj).build(), s) {

            final OfflineQueryLogic this$0;
            final String val$key;

            protected boolean matches(ParseObject parseobject, List list)
                throws ParseException
            {
                return OfflineQueryLogic.matchesInConstraint(list, OfflineQueryLogic.getValue(parseobject, key));
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                key = s;
                super(final_parseuser, state);
            }
        };
    }

    private ConstraintMatcher createMatcher(final ParseUser final_parseuser, ParseQuery.QueryConstraints queryconstraints)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = queryconstraints.keySet().iterator(); iterator.hasNext();)
        {
            final String key = (String)iterator.next();
            Object obj = queryconstraints.get(key);
            if (key.equals("$or"))
            {
                arraylist.add(createOrMatcher(final_parseuser, (ArrayList)obj));
            } else
            if (obj instanceof ParseQuery.KeyConstraints)
            {
                obj = (ParseQuery.KeyConstraints)obj;
                Iterator iterator1 = ((ParseQuery.KeyConstraints) (obj)).keySet().iterator();
                while (iterator1.hasNext()) 
                {
                    String s = (String)iterator1.next();
                    arraylist.add(createMatcher(final_parseuser, s, ((ParseQuery.KeyConstraints) (obj)).get(s), key, ((ParseQuery.KeyConstraints) (obj))));
                }
            } else
            if (obj instanceof ParseQuery.RelationConstraint)
            {
                arraylist.add(new ConstraintMatcher((ParseQuery.RelationConstraint)obj) {

                    final OfflineQueryLogic this$0;
                    final ParseQuery.RelationConstraint val$relation;

                    public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                    {
                        return j.a(Boolean.valueOf(relation.getRelation().hasKnownObject(parseobject)));
                    }

            
            {
                this$0 = OfflineQueryLogic.this;
                relation = relationconstraint;
                super(final_parseuser);
            }
                });
            } else
            {
                arraylist.add(new ConstraintMatcher(obj) {

                    final OfflineQueryLogic this$0;
                    final String val$key;
                    final Object val$queryConstraintValue;

                    public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                    {
                        try
                        {
                            parseobject = ((ParseObject) (OfflineQueryLogic.getValue(parseobject, key)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            return j.a(parseobject);
                        }
                        return j.a(Boolean.valueOf(OfflineQueryLogic.matchesEqualConstraint(queryConstraintValue, parseobject)));
                    }

            
            {
                this$0 = OfflineQueryLogic.this;
                key = s;
                queryConstraintValue = obj;
                super(final_parseuser);
            }
                });
            }
        }

        return new ConstraintMatcher(arraylist) {

            final OfflineQueryLogic this$0;
            final ArrayList val$matchers;

            public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                j j1 = j.a(Boolean.valueOf(true));
                for (Iterator iterator2 = matchers.iterator(); iterator2.hasNext();)
                {
                    j1 = j1.d(parsesqlitedatabase. new i() {

                        final _cls14 this$1;
                        final ParseSQLiteDatabase val$db;
                        final ConstraintMatcher val$matcher;
                        final ParseObject val$object;

                        public j then(j j1)
                            throws Exception
                        {
                            if (!((Boolean)j1.e()).booleanValue())
                            {
                                return j1;
                            } else
                            {
                                return matcher.matchesAsync(object, db);
                            }
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
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

                return j1;
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                matchers = arraylist;
                super(final_parseuser);
            }
        };
    }

    private ConstraintMatcher createMatcher(final ParseUser final_parseuser, final String operator, final Object constraint, final String key, ParseQuery.KeyConstraints keyconstraints)
    {
        byte byte0 = -1;
        operator.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   -721570031: 144
    //                   242866687: 96
    //                   427054964: 112
    //                   979339808: 128;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_144;
_L6:
        switch (byte0)
        {
        default:
            return new ConstraintMatcher(keyconstraints) {

                final OfflineQueryLogic this$0;
                final ParseQuery.KeyConstraints val$allKeyConstraints;
                final Object val$constraint;
                final String val$key;
                final String val$operator;

                public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                {
                    try
                    {
                        parseobject = ((ParseObject) (OfflineQueryLogic.getValue(parseobject, key)));
                        parseobject = j.a(Boolean.valueOf(OfflineQueryLogic.matchesStatelessConstraint(operator, constraint, parseobject, allKeyConstraints)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (ParseObject parseobject)
                    {
                        return j.a(parseobject);
                    }
                    return parseobject;
                }

            
            {
                this$0 = OfflineQueryLogic.this;
                key = s;
                operator = s1;
                constraint = obj;
                allKeyConstraints = keyconstraints;
                super(final_parseuser);
            }
            };

        case 0: // '\0'
            return createInQueryMatcher(final_parseuser, constraint, key);

        case 1: // '\001'
            return createNotInQueryMatcher(final_parseuser, constraint, key);

        case 2: // '\002'
            return createSelectMatcher(final_parseuser, constraint, key);

        case 3: // '\003'
            return createDontSelectMatcher(final_parseuser, constraint, key);
        }
_L3:
        if (operator.equals("$inQuery"))
        {
            byte0 = 0;
        }
          goto _L6
_L4:
        if (operator.equals("$notInQuery"))
        {
            byte0 = 1;
        }
          goto _L6
_L5:
        if (operator.equals("$select"))
        {
            byte0 = 2;
        }
          goto _L6
        if (operator.equals("$dontSelect"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    private ConstraintMatcher createNotInQueryMatcher(final ParseUser final_parseuser, Object obj, String s)
    {
        return new ConstraintMatcher(createInQueryMatcher(final_parseuser, obj, s)) {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$inQueryMatcher;

            public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                return inQueryMatcher.matchesAsync(parseobject, parsesqlitedatabase).c(new i() {

                    final _cls7 this$1;

                    public Boolean then(j j1)
                        throws Exception
                    {
                        boolean flag;
                        if (!((Boolean)j1.e()).booleanValue())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        return Boolean.valueOf(flag);
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
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
                super(final_parseuser);
            }
        };
    }

    private ConstraintMatcher createOrMatcher(final ParseUser final_parseuser, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); arraylist1.add(createMatcher(final_parseuser, (ParseQuery.QueryConstraints)arraylist.next()))) { }
        return new ConstraintMatcher(arraylist1) {

            final OfflineQueryLogic this$0;
            final ArrayList val$matchers;

            public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                j j1 = j.a(Boolean.valueOf(false));
                for (Iterator iterator = matchers.iterator(); iterator.hasNext();)
                {
                    j1 = j1.d(parsesqlitedatabase. new i() {

                        final _cls11 this$1;
                        final ParseSQLiteDatabase val$db;
                        final ConstraintMatcher val$matcher;
                        final ParseObject val$object;

                        public j then(j j1)
                            throws Exception
                        {
                            if (((Boolean)j1.e()).booleanValue())
                            {
                                return j1;
                            } else
                            {
                                return matcher.matchesAsync(object, db);
                            }
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
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

                return j1;
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                matchers = arraylist;
                super(final_parseuser);
            }
        };
    }

    private ConstraintMatcher createSelectMatcher(final ParseUser final_parseuser, Object obj, String s)
    {
        obj = (Map)obj;
        return new SubQueryMatcher(s, (String)((Map) (obj)).get("key")) {

            final OfflineQueryLogic this$0;
            final String val$key;
            final String val$resultKey;

            protected boolean matches(ParseObject parseobject, List list)
                throws ParseException
            {
                parseobject = ((ParseObject) (OfflineQueryLogic.getValue(parseobject, key)));
                for (list = list.iterator(); list.hasNext();)
                {
                    if (OfflineQueryLogic.matchesEqualConstraint(parseobject, OfflineQueryLogic.getValue((ParseObject)list.next(), resultKey)))
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
                super(final_parseuser, final_state);
            }
        };
    }

    private static j fetchIncludeAsync(OfflineStore offlinestore, Object obj, String s, ParseSQLiteDatabase parsesqlitedatabase)
        throws ParseException
    {
        int i = 0;
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1 = j.a(null);
_L4:
        return ((j) (obj1));
_L2:
label0:
        {
            if (!(obj instanceof Collection))
            {
                break label0;
            }
            obj1 = (Collection)obj;
            obj = j.a(null);
            Iterator iterator = ((Collection) (obj1)).iterator();
            do
            {
                obj1 = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = ((j) (obj)).d(new i(offlinestore, iterator.next(), s, parsesqlitedatabase) {

                    final ParseSQLiteDatabase val$db;
                    final Object val$item;
                    final String val$path;
                    final OfflineStore val$store;

                    public j then(j j1)
                        throws Exception
                    {
                        return OfflineQueryLogic.fetchIncludeAsync(store, item, path, db);
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                store = offlinestore;
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
        if (obj instanceof JSONArray)
        {
            JSONArray jsonarray = (JSONArray)obj;
            obj = j.a(null);
            for (; i < jsonarray.length(); i++)
            {
                obj = ((j) (obj)).d(new i(offlinestore, jsonarray, i, s, parsesqlitedatabase) {

                    final JSONArray val$array;
                    final ParseSQLiteDatabase val$db;
                    final int val$index;
                    final String val$path;
                    final OfflineStore val$store;

                    public j then(j j1)
                        throws Exception
                    {
                        return OfflineQueryLogic.fetchIncludeAsync(store, array.get(index), path, db);
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                store = offlinestore;
                array = jsonarray;
                index = k;
                path = s;
                db = parsesqlitedatabase;
                super();
            }
                });
            }

            return ((j) (obj));
        }
        if (s == null)
        {
            if (JSONObject.NULL.equals(obj))
            {
                return j.a(null);
            }
            if (obj instanceof ParseObject)
            {
                return offlinestore.fetchLocallyAsync((ParseObject)obj, parsesqlitedatabase).j();
            } else
            {
                return j.a(new ParseException(121, "include is invalid for non-ParseObjects"));
            }
        }
        s = s.split("\\.", 2);
        String s1 = s[0];
        if (s.length > 1)
        {
            s = s[1];
        } else
        {
            s = null;
        }
        return j.a(null).b(new i(obj, offlinestore, parsesqlitedatabase, s1) {

            final Object val$container;
            final ParseSQLiteDatabase val$db;
            final String val$key;
            final OfflineStore val$store;

            public j then(j j1)
                throws Exception
            {
                j1 = null;
                if (container instanceof ParseObject)
                {
                    j1 = OfflineQueryLogic.fetchIncludeAsync(store, container, null, db).c(new i() {

                        final _cls20 this$0;

                        public Object then(j j1)
                            throws Exception
                        {
                            return ((ParseObject)container).get(key);
                        }

            
            {
                this$0 = _cls20.this;
                super();
            }
                    });
                } else
                {
                    if (container instanceof Map)
                    {
                        return j.a(((Map)container).get(key));
                    }
                    if (container instanceof JSONObject)
                    {
                        return j.a(((JSONObject)container).opt(key));
                    }
                    if (!JSONObject.NULL.equals(container))
                    {
                        return j.a(new IllegalStateException("include is invalid"));
                    }
                }
                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                container = obj;
                store = offlinestore;
                db = parsesqlitedatabase;
                key = s;
                super();
            }
        }).d(new i(offlinestore, s, parsesqlitedatabase) {

            final ParseSQLiteDatabase val$db;
            final String val$rest;
            final OfflineStore val$store;

            public j then(j j1)
                throws Exception
            {
                return OfflineQueryLogic.fetchIncludeAsync(store, j1.e(), rest, db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                store = offlinestore;
                rest = s;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    static j fetchIncludesAsync(OfflineStore offlinestore, ParseObject parseobject, ParseQuery.State state, ParseSQLiteDatabase parsesqlitedatabase)
    {
        Object obj = state.includes();
        state = j.a(null);
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            state = state.d(new i(offlinestore, parseobject, (String)((Iterator) (obj)).next(), parsesqlitedatabase) {

                final ParseSQLiteDatabase val$db;
                final String val$include;
                final ParseObject val$object;
                final OfflineStore val$store;

                public j then(j j1)
                    throws Exception
                {
                    return OfflineQueryLogic.fetchIncludeAsync(store, object, include, db);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                store = offlinestore;
                object = parseobject;
                include = s;
                db = parsesqlitedatabase;
                super();
            }
            });
        }

        return state;
    }

    private static Object getValue(Object obj, String s)
        throws ParseException
    {
        return getValue(obj, s, 0);
    }

    private static Object getValue(Object obj, String s, int i)
        throws ParseException
    {
        Object obj1;
        String as[];
        as = null;
        obj1 = null;
        if (!s.contains(".")) goto _L2; else goto _L1
_L1:
        as = s.split("\\.", 2);
        obj = getValue(obj, as[0], i + 1);
        if (obj == null || obj == JSONObject.NULL || (obj instanceof Map) || (obj instanceof JSONObject)) goto _L4; else goto _L3
_L3:
        if (i <= 0) goto _L6; else goto _L5
_L5:
        try
        {
            obj = PointerEncoder.get().encode(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj1;
        }
        if (!(obj instanceof JSONObject)) goto _L6; else goto _L7
_L7:
        obj1 = getValue(obj, as[1], i + 1);
_L16:
        return obj1;
_L6:
        throw new ParseException(102, String.format("Key %s is invalid.", new Object[] {
            s
        }));
_L4:
        return getValue(obj, as[1], i + 1);
_L2:
        if (!(obj instanceof ParseObject))
        {
            break MISSING_BLOCK_LABEL_364;
        }
        obj = (ParseObject)obj;
        if (!((ParseObject) (obj)).isDataAvailable())
        {
            throw new ParseException(121, String.format("Bad key: %s", new Object[] {
                s
            }));
        }
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 232
    //                   -1949194674: 319
    //                   -1836974455: 304
    //                   90495162: 274
    //                   598371643: 289
    //                   792848342: 334;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        break; /* Loop/switch isn't completed */
_L13:
        break MISSING_BLOCK_LABEL_334;
_L14:
        switch (i)
        {
        default:
            return ((ParseObject) (obj)).get(s);

        case 0: // '\0'
            return ((ParseObject) (obj)).getObjectId();

        case 1: // '\001'
        case 2: // '\002'
            return ((ParseObject) (obj)).getCreatedAt();

        case 3: // '\003'
        case 4: // '\004'
            return ((ParseObject) (obj)).getUpdatedAt();
        }
_L11:
        if (s.equals("objectId"))
        {
            i = 0;
        }
          goto _L14
_L12:
        if (s.equals("createdAt"))
        {
            i = 1;
        }
          goto _L14
_L10:
        if (s.equals("_created_at"))
        {
            i = 2;
        }
          goto _L14
_L9:
        if (s.equals("updatedAt"))
        {
            i = 3;
        }
          goto _L14
        if (s.equals("_updated_at"))
        {
            i = 4;
        }
          goto _L14
        if (obj instanceof JSONObject)
        {
            return ((JSONObject)obj).opt(s);
        }
        if (obj instanceof Map)
        {
            return ((Map)obj).get(s);
        }
        obj1 = as;
        if (obj != JSONObject.NULL)
        {
            obj1 = as;
            if (obj != null)
            {
                throw new ParseException(121, String.format("Bad key: %s", new Object[] {
                    s
                }));
            }
        }
        if (true) goto _L16; else goto _L15
_L15:
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
        if (obj1 == null || obj1 == JSONObject.NULL)
        {
            return false;
        }
        if (!(obj1 instanceof Collection))
        {
            throw new IllegalArgumentException("Value type not supported for $all queries.");
        }
        if (obj instanceof Collection)
        {
            for (obj = ((Collection)obj).iterator(); ((Iterator) (obj)).hasNext();)
            {
                if (!matchesEqualConstraint(((Iterator) (obj)).next(), obj1))
                {
                    return false;
                }
            }

            return true;
        } else
        {
            throw new IllegalArgumentException("Constraint type not supported for $all queries.");
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
        if (!(obj instanceof Number) || !(obj1 instanceof Number))
        {
            break; /* Loop/switch isn't completed */
        }
        if (compareTo(obj, obj1) != 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
        if ((obj instanceof ParseGeoPoint) && (obj1 instanceof ParseGeoPoint))
        {
            obj = (ParseGeoPoint)obj;
            obj1 = (ParseGeoPoint)obj1;
            if (((ParseGeoPoint) (obj)).getLatitude() != ((ParseGeoPoint) (obj1)).getLatitude() || ((ParseGeoPoint) (obj)).getLongitude() != ((ParseGeoPoint) (obj1)).getLongitude())
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
        if (true) goto _L3; else goto _L6
_L6:
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
        if (obj instanceof Collection)
        {
            for (obj = ((Collection)obj).iterator(); ((Iterator) (obj)).hasNext();)
            {
                if (matchesEqualConstraint(((Iterator) (obj)).next(), obj1))
                {
                    return true;
                }
            }

            return false;
        } else
        {
            throw new IllegalArgumentException("Constraint type not supported for $in queries.");
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
        int k = 0;
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
        if (s1.contains("i"))
        {
            k = 2;
        }
        int i = k;
        if (s1.contains("m"))
        {
            i = k | 8;
        }
        k = i;
        if (s1.contains("x"))
        {
            k = i | 4;
        }
        i = k;
        if (s1.contains("s"))
        {
            i = k | 0x20;
        }
        return Pattern.compile((String)obj, i).matcher((String)obj1).find();
    }

    private static boolean matchesStatelessConstraint(String s, Object obj, Object obj1, ParseQuery.KeyConstraints keyconstraints)
        throws ParseException
    {
        byte byte0;
        boolean flag;
        flag = true;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 14: default 132
    //                   -1622199595: 424
    //                   -443727559: 407
    //                   37905: 274
    //                   37961: 306
    //                   38060: 242
    //                   38107: 226
    //                   1169149: 339
    //                   1175156: 290
    //                   1179961: 258
    //                   1181551: 322
    //                   596003200: 390
    //                   1097791887: 441
    //                   1139041955: 356
    //                   1362155002: 373;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        break; /* Loop/switch isn't completed */
_L13:
        break MISSING_BLOCK_LABEL_441;
_L16:
        switch (byte0)
        {
        default:
            throw new UnsupportedOperationException(String.format("The offline store does not yet support the %s operator.", new Object[] {
                s
            }));

        case 0: // '\0'
            flag = matchesNotEqualConstraint(obj, obj1);
            // fall through

        case 9: // '\t'
        case 12: // '\f'
            return flag;

        case 1: // '\001'
            return matchesLessThanConstraint(obj, obj1);

        case 2: // '\002'
            return matchesLessThanOrEqualToConstraint(obj, obj1);

        case 3: // '\003'
            return matchesGreaterThanConstraint(obj, obj1);

        case 4: // '\004'
            return matchesGreaterThanOrEqualToConstraint(obj, obj1);

        case 5: // '\005'
            return matchesInConstraint(obj, obj1);

        case 6: // '\006'
            return matchesNotInConstraint(obj, obj1);

        case 7: // '\007'
            return matchesAllConstraint(obj, obj1);

        case 8: // '\b'
            return matchesRegexConstraint(obj, obj1, (String)keyconstraints.get("$options"));

        case 10: // '\n'
            return matchesExistsConstraint(obj, obj1);

        case 11: // '\013'
            return matchesNearSphereConstraint(obj, obj1, (Double)keyconstraints.get("$maxDistance"));

        case 13: // '\r'
            return matchesWithinConstraint(obj, obj1);
        }
_L7:
        if (s.equals("$ne"))
        {
            byte0 = 0;
        }
          goto _L16
_L6:
        if (s.equals("$lt"))
        {
            byte0 = 1;
        }
          goto _L16
_L10:
        if (s.equals("$lte"))
        {
            byte0 = 2;
        }
          goto _L16
_L4:
        if (s.equals("$gt"))
        {
            byte0 = 3;
        }
          goto _L16
_L9:
        if (s.equals("$gte"))
        {
            byte0 = 4;
        }
          goto _L16
_L5:
        if (s.equals("$in"))
        {
            byte0 = 5;
        }
          goto _L16
_L11:
        if (s.equals("$nin"))
        {
            byte0 = 6;
        }
          goto _L16
_L8:
        if (s.equals("$all"))
        {
            byte0 = 7;
        }
          goto _L16
_L14:
        if (s.equals("$regex"))
        {
            byte0 = 8;
        }
          goto _L16
_L15:
        if (s.equals("$options"))
        {
            byte0 = 9;
        }
          goto _L16
_L12:
        if (s.equals("$exists"))
        {
            byte0 = 10;
        }
          goto _L16
_L3:
        if (s.equals("$nearSphere"))
        {
            byte0 = 11;
        }
          goto _L16
_L2:
        if (s.equals("$maxDistance"))
        {
            byte0 = 12;
        }
          goto _L16
        if (s.equals("$within"))
        {
            byte0 = 13;
        }
          goto _L16
    }

    private static boolean matchesWithinConstraint(Object obj, Object obj1)
        throws ParseException
    {
        if (obj1 == null || obj1 == JSONObject.NULL)
        {
            return false;
        }
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

    static void sort(List list, ParseQuery.State state)
        throws ParseException
    {
        ParseGeoPoint parsegeopoint = null;
        List list1 = state.order();
        for (Iterator iterator = state.order().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if (!s1.matches("^-?[A-Za-z][A-Za-z0-9_]*$") && !"_created_at".equals(s1) && !"_updated_at".equals(s1))
            {
                throw new ParseException(105, String.format("Invalid key name: \"%s\".", new Object[] {
                    s1
                }));
            }
        }

        Iterator iterator1 = state.constraints().keySet().iterator();
        String s = null;
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s2 = (String)iterator1.next();
            Object obj = state.constraints().get(s2);
            if (obj instanceof ParseQuery.KeyConstraints)
            {
                obj = (ParseQuery.KeyConstraints)obj;
                if (((ParseQuery.KeyConstraints) (obj)).containsKey("$nearSphere"))
                {
                    parsegeopoint = (ParseGeoPoint)((ParseQuery.KeyConstraints) (obj)).get("$nearSphere");
                    s = s2;
                }
            }
        } while (true);
        if (list1.size() == 0 && s == null)
        {
            return;
        } else
        {
            Collections.sort(list, new Comparator(s, parsegeopoint, list1) {

                final List val$keys;
                final String val$nearSphereKey;
                final ParseGeoPoint val$nearSphereValue;

                public int compare(ParseObject parseobject, ParseObject parseobject1)
                {
                    if (nearSphereKey == null) goto _L2; else goto _L1
_L1:
                    int i;
                    double d;
                    double d1;
                    ParseGeoPoint parsegeopoint1;
                    ParseGeoPoint parsegeopoint2;
                    try
                    {
                        parsegeopoint1 = (ParseGeoPoint)OfflineQueryLogic.getValue(parseobject, nearSphereKey);
                        parsegeopoint2 = (ParseGeoPoint)OfflineQueryLogic.getValue(parseobject1, nearSphereKey);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ParseObject parseobject)
                    {
                        throw new RuntimeException(parseobject);
                    }
                    d = parsegeopoint1.distanceInRadiansTo(nearSphereValue);
                    d1 = parsegeopoint2.distanceInRadiansTo(nearSphereValue);
                    if (d == d1) goto _L2; else goto _L3
_L3:
                    if (d - d1 <= 0.0D) goto _L5; else goto _L4
_L4:
                    i = 1;
_L7:
                    return i;
_L5:
                    return -1;
_L2:
                    Iterator iterator2 = keys.iterator();
                    do
                    {
                        if (!iterator2.hasNext())
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        String s3 = (String)iterator2.next();
                        Object obj1;
                        Object obj2;
                        boolean flag;
                        int k;
                        if (s3.startsWith("-"))
                        {
                            s3 = s3.substring(1);
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        try
                        {
                            obj1 = OfflineQueryLogic.getValue(parseobject, s3);
                            obj2 = OfflineQueryLogic.getValue(parseobject1, s3);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            throw new RuntimeException(parseobject);
                        }
                        try
                        {
                            k = OfflineQueryLogic.compareTo(obj1, obj2);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            throw new IllegalArgumentException(String.format("Unable to sort by key %s.", new Object[] {
                                s3
                            }), parseobject);
                        }
                    } while (k == 0);
                    i = k;
                    if (flag)
                    {
                        return -k;
                    }
                    if (true) goto _L7; else goto _L6
_L6:
                    return 0;
                }

                public volatile int compare(Object obj1, Object obj2)
                {
                    return compare((ParseObject)obj1, (ParseObject)obj2);
                }

            
            {
                nearSphereKey = s;
                nearSphereValue = parsegeopoint;
                keys = list;
                super();
            }
            });
            return;
        }
    }

    ConstraintMatcher createMatcher(ParseQuery.State state, final ParseUser final_parseuser)
    {
        return new ConstraintMatcher(createMatcher(final_parseuser, state.constraints())) {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$constraintMatcher;
            final boolean val$ignoreACLs;

            public j matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                if (!ignoreACLs && !OfflineQueryLogic.hasReadAccess(user, parseobject))
                {
                    return j.a(Boolean.valueOf(false));
                } else
                {
                    return constraintMatcher.matchesAsync(parseobject, parsesqlitedatabase);
                }
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                ignoreACLs = flag;
                constraintMatcher = constraintmatcher;
                super(final_parseuser);
            }
        };
    }







}
