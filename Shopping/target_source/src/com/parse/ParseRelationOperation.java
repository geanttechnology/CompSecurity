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
//            ParseFieldOperation, ParseObject, Parse, ParseRelation, 
//            ParseEncoder, ParseDeleteOperation

class ParseRelationOperation
    implements ParseFieldOperation
{

    private final Set relationsToAdd;
    private final Set relationsToRemove;
    private final String targetClass;

    private ParseRelationOperation(String s, Set set, Set set1)
    {
        targetClass = s;
        relationsToAdd = new HashSet(set);
        relationsToRemove = new HashSet(set1);
    }

    ParseRelationOperation(Set set, Set set1)
    {
_L2:
label0:
        {
            if (set1 != null)
            {
                Iterator iterator = set1.iterator();
label1:
                do
                {
                    do
                    {
                        set1 = set;
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        set1 = (ParseObject)iterator.next();
                        addParseObjectToSet(set1, relationsToRemove);
                        if (set != null)
                        {
                            continue label1;
                        }
                        set = set1.getClassName();
                    } while (true);
                } while (set.equals(set1.getClassName()));
                throw new IllegalArgumentException("All objects in a relation must be of the same class.");
            }
            set1 = set;
        }
        if (set1 == null)
        {
            throw new IllegalArgumentException("Cannot create a ParseRelationOperation with no objects.");
        } else
        {
            targetClass = set1;
            return;
        }
        super();
        ParseObject parseobject = null;
        relationsToAdd = new HashSet();
        relationsToRemove = new HashSet();
        if (set != null)
        {
label2:
            {
                Iterator iterator1 = set.iterator();
label3:
                do
                {
                    for (set = parseobject; iterator1.hasNext(); set = parseobject.getClassName())
                    {
                        parseobject = (ParseObject)iterator1.next();
                        addParseObjectToSet(parseobject, relationsToAdd);
                        if (set != null)
                        {
                            continue label3;
                        }
                    }

                    break label2;
                } while (set.equals(parseobject.getClassName()));
                throw new IllegalArgumentException("All objects in a relation must be of the same class.");
            }
        }
        set = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void addAllParseObjectsToSet(Collection collection, Set set)
    {
        for (collection = collection.iterator(); collection.hasNext(); addParseObjectToSet((ParseObject)collection.next(), set)) { }
    }

    private void addParseObjectToSet(ParseObject parseobject, Set set)
    {
        if (Parse.getLocalDatastore() != null || parseobject.getObjectId() == null)
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
        if (Parse.getLocalDatastore() != null || parseobject.getObjectId() == null)
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

    public Object apply(Object obj, String s)
    {
        if (obj == null)
        {
            obj = new ParseRelation(targetClass);
        } else
        if (obj instanceof ParseRelation)
        {
            s = (ParseRelation)obj;
            obj = s;
            if (targetClass != null)
            {
                obj = s;
                if (!targetClass.equals(s.getTargetClass()))
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Related object object must be of class ").append(s.getTargetClass()).append(", but ").append(targetClass).append(" was passed in.").toString());
                }
            }
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
        for (s = relationsToAdd.iterator(); s.hasNext(); ((ParseRelation) (obj)).addKnownObject((ParseObject)s.next())) { }
        for (s = relationsToRemove.iterator(); s.hasNext(); ((ParseRelation) (obj)).removeKnownObject((ParseObject)s.next())) { }
        return obj;
    }

    JSONArray convertSetToArray(Set set, ParseEncoder parseencoder)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        for (set = set.iterator(); set.hasNext(); jsonarray.put(parseencoder.encode((ParseObject)set.next()))) { }
        return jsonarray;
    }

    public volatile Object encode(ParseEncoder parseencoder)
        throws JSONException
    {
        return encode(parseencoder);
    }

    public JSONObject encode(ParseEncoder parseencoder)
        throws JSONException
    {
        JSONObject jsonobject;
        JSONObject jsonobject2;
        if (relationsToAdd.size() > 0)
        {
            jsonobject = new JSONObject();
            jsonobject.put("__op", "AddRelation");
            jsonobject.put("objects", convertSetToArray(relationsToAdd, parseencoder));
        } else
        {
            jsonobject = null;
        }
        if (relationsToRemove.size() > 0)
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("__op", "RemoveRelation");
            jsonobject1.put("objects", convertSetToArray(relationsToRemove, parseencoder));
            parseencoder = jsonobject1;
        } else
        {
            parseencoder = null;
        }
        if (jsonobject != null && parseencoder != null)
        {
            jsonobject2 = new JSONObject();
            jsonobject2.put("__op", "Batch");
            JSONArray jsonarray = new JSONArray();
            jsonarray.put(jsonobject);
            jsonarray.put(parseencoder);
            jsonobject2.put("ops", jsonarray);
        } else
        {
            jsonobject2 = jsonobject;
            if (jsonobject == null)
            {
                if (parseencoder != null)
                {
                    return parseencoder;
                } else
                {
                    throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
                }
            }
        }
        return jsonobject2;
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
