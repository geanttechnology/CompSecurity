// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
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
        protected ParseUser user;

        abstract cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase);

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
        private cu subQueryResults;
        final OfflineQueryLogic this$0;

        protected abstract boolean matches(ParseObject parseobject, List list)
            throws ParseException;

        public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
        {
            if (subQueryResults == null)
            {
                subQueryResults = store.findAsync(subQuery, user, null, parsesqlitedatabase);
            }
            return subQueryResults.c(parseobject. new ct() {

                final SubQueryMatcher this$1;
                final ParseObject val$object;

                public Boolean then(cu cu1)
                    throws ParseException
                {
                    return Boolean.valueOf(matches(object, (List)cu1.e()));
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
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

            public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                return selectMatcher.matchesAsync(parseobject, parsesqlitedatabase).c(new ct() {

                    final _cls9 this$1;

                    public Boolean then(cu cu1)
                        throws Exception
                    {
                        boolean flag;
                        if (!((Boolean)cu1.e()).booleanValue())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        return Boolean.valueOf(flag);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
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
                return OfflineQueryLogic.matchesInConstraint(list, getValue(parseobject, key));
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

                    public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                    {
                        return cu.a(Boolean.valueOf(relation.getRelation().hasKnownObject(parseobject)));
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

                    public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                    {
                        try
                        {
                            parseobject = ((ParseObject) (getValue(parseobject, key)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            return cu.a(parseobject);
                        }
                        return cu.a(Boolean.valueOf(OfflineQueryLogic.matchesEqualConstraint(queryConstraintValue, parseobject)));
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

            public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                cu cu1 = cu.a(Boolean.valueOf(true));
                for (Iterator iterator2 = matchers.iterator(); iterator2.hasNext();)
                {
                    cu1 = cu1.d(parsesqlitedatabase. new ct() {

                        final _cls14 this$1;
                        final ParseSQLiteDatabase val$db;
                        final ConstraintMatcher val$matcher;
                        final ParseObject val$object;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            if (!((Boolean)cu1.e()).booleanValue())
                            {
                                return cu1;
                            } else
                            {
                                return matcher.matchesAsync(object, db);
                            }
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
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

                return cu1;
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
        if (operator.equals("$inQuery"))
        {
            return createInQueryMatcher(final_parseuser, constraint, key);
        }
        if (operator.equals("$notInQuery"))
        {
            return createNotInQueryMatcher(final_parseuser, constraint, key);
        }
        if (operator.equals("$select"))
        {
            return createSelectMatcher(final_parseuser, constraint, key);
        }
        if (operator.equals("$dontSelect"))
        {
            return createDontSelectMatcher(final_parseuser, constraint, key);
        } else
        {
            return new ConstraintMatcher(keyconstraints) {

                final OfflineQueryLogic this$0;
                final ParseQuery.KeyConstraints val$allKeyConstraints;
                final Object val$constraint;
                final String val$key;
                final String val$operator;

                public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
                {
                    try
                    {
                        parseobject = ((ParseObject) (getValue(parseobject, key)));
                        parseobject = cu.a(Boolean.valueOf(OfflineQueryLogic.matchesStatelessConstraint(operator, constraint, parseobject, allKeyConstraints)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (ParseObject parseobject)
                    {
                        return cu.a(parseobject);
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
        }
    }

    private ConstraintMatcher createNotInQueryMatcher(final ParseUser final_parseuser, Object obj, String s)
    {
        return new ConstraintMatcher(createInQueryMatcher(final_parseuser, obj, s)) {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$inQueryMatcher;

            public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                return inQueryMatcher.matchesAsync(parseobject, parsesqlitedatabase).c(new ct() {

                    final _cls7 this$1;

                    public Boolean then(cu cu1)
                        throws Exception
                    {
                        boolean flag;
                        if (!((Boolean)cu1.e()).booleanValue())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        return Boolean.valueOf(flag);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
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

            public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                cu cu1 = cu.a(Boolean.valueOf(false));
                for (Iterator iterator = matchers.iterator(); iterator.hasNext();)
                {
                    cu1 = cu1.d(parsesqlitedatabase. new ct() {

                        final _cls11 this$1;
                        final ParseSQLiteDatabase val$db;
                        final ConstraintMatcher val$matcher;
                        final ParseObject val$object;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            if (((Boolean)cu1.e()).booleanValue())
                            {
                                return cu1;
                            } else
                            {
                                return matcher.matchesAsync(object, db);
                            }
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
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

                return cu1;
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
                super(final_parseuser, final_state);
            }
        };
    }

    private cu fetchIncludeAsync(final Object container, final String path, final ParseSQLiteDatabase db)
        throws ParseException
    {
        final int index = 0;
        if (container != null) goto _L2; else goto _L1
_L1:
        Object obj = cu.a(null);
_L4:
        return ((cu) (obj));
_L2:
label0:
        {
            if (!(container instanceof JSONArray))
            {
                break label0;
            }
            final JSONArray array = (JSONArray)container;
            container = cu.a(null);
            do
            {
                obj = container;
                if (index >= array.length())
                {
                    break;
                }
                container = ((cu) (container)).d(new ct() {

                    final OfflineQueryLogic this$0;
                    final JSONArray val$array;
                    final ParseSQLiteDatabase val$db;
                    final int val$index;
                    final String val$path;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return fetchIncludeAsync(array.get(index), path, db);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
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
        if (true) goto _L4; else goto _L3
_L3:
        if (container instanceof List)
        {
            Object obj1 = (List)container;
            container = cu.a(null);
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
            {
                container = ((cu) (container)).d(new ct() {

                    final OfflineQueryLogic this$0;
                    final ParseSQLiteDatabase val$db;
                    final Object val$item;
                    final String val$path;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return fetchIncludeAsync(item, path, db);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = OfflineQueryLogic.this;
                item = obj;
                path = s;
                db = parsesqlitedatabase;
                super();
            }
                });
            }

            return ((cu) (container));
        }
        if (path == null)
        {
            if (JSONObject.NULL.equals(container))
            {
                return null;
            }
            if (container instanceof ParseObject)
            {
                container = (ParseObject)container;
                return store.fetchLocallyAsync(((ParseObject) (container)), db).j();
            } else
            {
                return cu.a(new ParseException(121, "include is invalid for non-ParseObjects"));
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
        return cu.a(null).b(new ct() {

            final OfflineQueryLogic this$0;
            final Object val$container;
            final ParseSQLiteDatabase val$db;
            final String val$key;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = null;
                if (container instanceof ParseObject)
                {
                    cu1 = fetchIncludeAsync(container, null, db).c(new ct() {

                        final _cls20 this$1;

                        public Object then(cu cu1)
                            throws Exception
                        {
                            return ((ParseObject)container).get(key);
                        }

            
            {
                this$1 = _cls20.this;
                super();
            }
                    });
                } else
                {
                    if (container instanceof Map)
                    {
                        return cu.a(((Map)container).get(key));
                    }
                    if (container instanceof JSONObject)
                    {
                        return cu.a(((JSONObject)container).opt(key));
                    }
                    if (!JSONObject.NULL.equals(container))
                    {
                        return cu.a(new IllegalStateException("include is invalid"));
                    }
                }
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = OfflineQueryLogic.this;
                container = obj;
                db = parsesqlitedatabase;
                key = s;
                super();
            }
        }).d(new ct() {

            final OfflineQueryLogic this$0;
            final ParseSQLiteDatabase val$db;
            final String val$rest;

            public cu then(cu cu1)
                throws Exception
            {
                return fetchIncludeAsync(cu1.e(), rest, db);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
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
_L9:
        return obj1;
_L6:
        throw new ParseException(102, String.format("Key %s is invalid.", new Object[] {
            s
        }));
_L4:
        return getValue(obj, as[1], i + 1);
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
        if (true) goto _L9; else goto _L8
_L8:
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
        if (obj1 != null && obj1 != JSONObject.NULL) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!(obj1 instanceof Collection) && !(obj1 instanceof JSONArray))
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
        }
        if (!(obj instanceof JSONArray))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        int i = 0;
        do
        {
            if (i >= ((JSONArray)obj).length())
            {
                break; /* Loop/switch isn't completed */
            }
            if (!matchesEqualConstraint(((JSONArray)obj).opt(i), obj1))
            {
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
        throw new IllegalArgumentException("Constraint type not supported for $all queries.");
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
            if (((ParseGeoPoint) (obj)).getLatitude() != ((ParseGeoPoint) (obj1)).getLatitude() || ((ParseGeoPoint) (obj1)).getLongitude() != ((ParseGeoPoint) (obj1)).getLongitude())
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
        boolean flag1 = false;
        if (!(obj instanceof Collection)) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            obj = ((Collection)obj).iterator();
            do
            {
                flag = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!matchesEqualConstraint(((Iterator) (obj)).next(), obj1));
            flag = true;
        }
_L4:
        return flag;
_L2:
        if (obj instanceof JSONArray)
        {
            int i = 0;
            do
            {
                flag = flag1;
                if (i >= ((JSONArray)obj).length())
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (matchesEqualConstraint(((JSONArray)obj).opt(i), obj1))
                {
                    return true;
                }
                i++;
            } while (true);
        }
        flag = flag1;
        if (obj != JSONObject.NULL)
        {
            flag = flag1;
            if (obj != null)
            {
                throw new IllegalArgumentException("Constraint type not supported for $in queries.");
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        int j = 0;
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
            j = 2;
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

    ConstraintMatcher createMatcher(ParseQuery.State state, final ParseUser final_parseuser)
    {
        return new ConstraintMatcher(createMatcher(final_parseuser, state.constraints())) {

            final OfflineQueryLogic this$0;
            final ConstraintMatcher val$constraintMatcher;
            final boolean val$ignoreACLs;

            public cu matchesAsync(ParseObject parseobject, ParseSQLiteDatabase parsesqlitedatabase)
            {
                if (!ignoreACLs && !OfflineQueryLogic.hasReadAccess(user, parseobject))
                {
                    return cu.a(Boolean.valueOf(false));
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

    cu fetchIncludes(final ParseObject object, ParseQuery.State state, ParseSQLiteDatabase parsesqlitedatabase)
    {
        Object obj = state.includes();
        state = cu.a(null);
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            state = state.d(new ct() {

                final OfflineQueryLogic this$0;
                final ParseSQLiteDatabase val$db;
                final String val$include;
                final ParseObject val$object;

                public cu then(cu cu1)
                    throws Exception
                {
                    return fetchIncludeAsync(object, include, db);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
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

        return state;
    }

    void sort(List list, ParseQuery.State state)
        throws ParseException
    {
        final ParseGeoPoint nearSphereValue = null;
        final List keys = state.order();
        for (Iterator iterator = state.order().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if (!s.matches("^-?[A-Za-z][A-Za-z0-9_]*$") && !"_created_at".equals(s) && !"_updated_at".equals(s))
            {
                throw new ParseException(105, String.format("Invalid key name: \"%s\".", new Object[] {
                    s
                }));
            }
        }

        Iterator iterator1 = state.constraints().keySet().iterator();
        final String nearSphereKey = null;
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s1 = (String)iterator1.next();
            Object obj = state.constraints().get(s1);
            if (obj instanceof ParseQuery.KeyConstraints)
            {
                obj = (ParseQuery.KeyConstraints)obj;
                if (((ParseQuery.KeyConstraints) (obj)).containsKey("$nearSphere"))
                {
                    nearSphereValue = (ParseGeoPoint)((ParseQuery.KeyConstraints) (obj)).get("$nearSphere");
                    nearSphereKey = s1;
                }
            }
        } while (true);
        if (keys.size() == 0 && nearSphereKey == null)
        {
            return;
        } else
        {
            Collections.sort(list, new Comparator() {

                final OfflineQueryLogic this$0;
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
                        String s2 = (String)iterator2.next();
                        Object obj1;
                        Object obj2;
                        boolean flag;
                        int j;
                        if (s2.startsWith("-"))
                        {
                            s2 = s2.substring(1);
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
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
                            j = OfflineQueryLogic.compareTo(obj1, obj2);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ParseObject parseobject)
                        {
                            throw new IllegalArgumentException(String.format("Unable to sort by key %s.", new Object[] {
                                s2
                            }), parseobject);
                        }
                    } while (j == 0);
                    i = j;
                    if (flag)
                    {
                        return -j;
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
                this$0 = OfflineQueryLogic.this;
                nearSphereKey = s;
                nearSphereValue = parsegeopoint;
                keys = list;
                super();
            }
            });
            return;
        }
    }







}
