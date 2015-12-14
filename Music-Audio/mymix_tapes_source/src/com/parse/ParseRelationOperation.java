// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, ParseObject, OfflineStore, ParseRelation, 
//            Parse, ParseDeleteOperation, ParseObjectEncodingStrategy

class ParseRelationOperation
    implements ParseFieldOperation
{

    private Set relationsToAdd;
    private Set relationsToRemove;
    private String targetClass;

    private ParseRelationOperation(String s, Set set, Set set1)
    {
        targetClass = s;
        relationsToAdd = new HashSet(set);
        relationsToRemove = new HashSet(set1);
    }

    ParseRelationOperation(Set set, Set set1)
    {
label0:
        {
            super();
            targetClass = null;
            relationsToAdd = new HashSet();
            relationsToRemove = new HashSet();
            if (set == null)
            {
                break label0;
            }
            ParseObject parseobject;
label1:
            do
            {
                for (set = set.iterator(); set.hasNext();)
                {
                    parseobject = (ParseObject)set.next();
                    addParseObjectToSet(parseobject, relationsToAdd);
                    if (targetClass != null)
                    {
                        continue label1;
                    }
                    targetClass = parseobject.getClassName();
                }

                break label0;
            } while (targetClass.equals(parseobject.getClassName()));
            throw new IllegalArgumentException("All objects in a relation must be of the same class.");
        }
label2:
        {
            if (set1 == null)
            {
                break label2;
            }
label3:
            do
            {
                for (set = set1.iterator(); set.hasNext();)
                {
                    set1 = (ParseObject)set.next();
                    addParseObjectToSet(set1, relationsToRemove);
                    if (targetClass != null)
                    {
                        continue label3;
                    }
                    targetClass = set1.getClassName();
                }

                break label2;
            } while (targetClass.equals(set1.getClassName()));
            throw new IllegalArgumentException("All objects in a relation must be of the same class.");
        }
        if (targetClass == null)
        {
            throw new IllegalArgumentException("Cannot create a ParseRelationOperation with no objects.");
        } else
        {
            return;
        }
    }

    private void addAllParseObjectsToSet(Collection collection, Set set)
    {
        for (collection = collection.iterator(); collection.hasNext(); addParseObjectToSet((ParseObject)collection.next(), set)) { }
    }

    private void addParseObjectToSet(ParseObject parseobject, Set set)
    {
        if (OfflineStore.getCurrent() != null || parseobject.getObjectId() == null)
        {
            set.add(parseobject);
            return;
        }
        Iterator iterator = set.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ParseObject parseobject1 = (ParseObject)iterator.next();
            if (parseobject.getObjectId().equals(parseobject1.getObjectId()))
            {
                set.remove(parseobject1);
            }
        } while (true);
        set.add(parseobject);
    }

    private void removeAllParseObjectsFromSet(Collection collection, Set set)
    {
        for (collection = collection.iterator(); collection.hasNext(); removeParseObjectFromSet((ParseObject)collection.next(), set)) { }
    }

    private void removeParseObjectFromSet(ParseObject parseobject, Set set)
    {
        if (OfflineStore.getCurrent() != null || parseobject.getObjectId() == null)
        {
            set.remove(parseobject);
        } else
        {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) 
            {
                ParseObject parseobject1 = (ParseObject)iterator.next();
                if (parseobject.getObjectId().equals(parseobject1.getObjectId()))
                {
                    set.remove(parseobject1);
                }
            }
        }
    }

    public Object apply(Object obj, ParseObject parseobject, String s)
    {
        if (obj == null)
        {
            obj = new ParseRelation(parseobject, s);
            ((ParseRelation) (obj)).setTargetClass(targetClass);
        } else
        if (obj instanceof ParseRelation)
        {
            parseobject = (ParseRelation)obj;
            obj = parseobject;
            if (targetClass != null)
            {
                obj = parseobject;
                if (!targetClass.equals(parseobject.getTargetClass()))
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Related object object must be of class ").append(parseobject.getTargetClass()).append(", but ").append(targetClass).append(" was passed in.").toString());
                }
            }
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
        for (parseobject = relationsToAdd.iterator(); parseobject.hasNext(); ((ParseRelation) (obj)).addKnownObject((ParseObject)parseobject.next())) { }
        for (parseobject = relationsToRemove.iterator(); parseobject.hasNext(); ((ParseRelation) (obj)).removeKnownObject((ParseObject)parseobject.next())) { }
        return obj;
    }

    JSONArray convertSetToArray(Set set, ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        for (set = set.iterator(); set.hasNext(); jsonarray.put(Parse.encode((ParseObject)set.next(), parseobjectencodingstrategy))) { }
        return jsonarray;
    }

    public volatile Object encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        return encode(parseobjectencodingstrategy);
    }

    public JSONObject encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        JSONObject jsonobject = null;
        JSONObject jsonobject1 = null;
        if (relationsToAdd.size() > 0)
        {
            jsonobject = new JSONObject();
            jsonobject.put("__op", "AddRelation");
            jsonobject.put("objects", convertSetToArray(relationsToAdd, parseobjectencodingstrategy));
        }
        if (relationsToRemove.size() > 0)
        {
            jsonobject1 = new JSONObject();
            jsonobject1.put("__op", "RemoveRelation");
            jsonobject1.put("objects", convertSetToArray(relationsToRemove, parseobjectencodingstrategy));
        }
        if (jsonobject != null && jsonobject1 != null)
        {
            parseobjectencodingstrategy = new JSONObject();
            parseobjectencodingstrategy.put("__op", "Batch");
            JSONArray jsonarray = new JSONArray();
            jsonarray.put(jsonobject);
            jsonarray.put(jsonobject1);
            parseobjectencodingstrategy.put("ops", jsonarray);
            return parseobjectencodingstrategy;
        }
        if (jsonobject != null)
        {
            return jsonobject;
        }
        if (jsonobject1 != null)
        {
            return jsonobject1;
        } else
        {
            throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
        }
    }

    String getTargetClass()
    {
        return targetClass;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parsefieldoperation)
    {
        if (parsefieldoperation == null)
        {
            return this;
        }
        if (parsefieldoperation instanceof ParseDeleteOperation)
        {
            throw new IllegalArgumentException("You can't modify a relation after deleting it.");
        }
        if (parsefieldoperation instanceof ParseRelationOperation)
        {
            Object obj = (ParseRelationOperation)parsefieldoperation;
            if (((ParseRelationOperation) (obj)).targetClass != null && !((ParseRelationOperation) (obj)).targetClass.equals(targetClass))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Related object object must be of class ").append(((ParseRelationOperation) (obj)).targetClass).append(", but ").append(targetClass).append(" was passed in.").toString());
            }
            parsefieldoperation = new HashSet(((ParseRelationOperation) (obj)).relationsToAdd);
            obj = new HashSet(((ParseRelationOperation) (obj)).relationsToRemove);
            if (relationsToAdd != null)
            {
                addAllParseObjectsToSet(relationsToAdd, parsefieldoperation);
                removeAllParseObjectsFromSet(relationsToAdd, ((Set) (obj)));
            }
            if (relationsToRemove != null)
            {
                removeAllParseObjectsFromSet(relationsToRemove, parsefieldoperation);
                addAllParseObjectsToSet(relationsToRemove, ((Set) (obj)));
            }
            return new ParseRelationOperation(targetClass, parsefieldoperation, ((Set) (obj)));
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
