// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, ParseFieldOperations, ParseObject, ParseEncoder, 
//            ParseDeleteOperation, ParseSetOperation

class ParseAddUniqueOperation
    implements ParseFieldOperation
{

    protected LinkedHashSet objects;

    public ParseAddUniqueOperation(Collection collection)
    {
        objects = new LinkedHashSet();
        objects.addAll(collection);
    }

    public Object apply(Object obj, String s)
    {
        if (obj == null)
        {
            return new ArrayList(objects);
        }
        if (obj instanceof JSONArray)
        {
            return new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)obj), s));
        }
        if (obj instanceof List)
        {
            obj = new ArrayList((List)obj);
            s = new HashMap();
            for (int i = 0; i < ((ArrayList) (obj)).size(); i++)
            {
                if (((ArrayList) (obj)).get(i) instanceof ParseObject)
                {
                    s.put(((ParseObject)((ArrayList) (obj)).get(i)).getObjectId(), Integer.valueOf(i));
                }
            }

            Iterator iterator = objects.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj1 = iterator.next();
                if (obj1 instanceof ParseObject)
                {
                    String s1 = ((ParseObject)obj1).getObjectId();
                    if (s1 != null && s.containsKey(s1))
                    {
                        ((ArrayList) (obj)).set(((Integer)s.get(s1)).intValue(), obj1);
                    } else
                    if (!((ArrayList) (obj)).contains(obj1))
                    {
                        ((ArrayList) (obj)).add(obj1);
                    }
                } else
                if (!((ArrayList) (obj)).contains(obj1))
                {
                    ((ArrayList) (obj)).add(obj1);
                }
            } while (true);
            return obj;
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }

    public volatile Object encode(ParseEncoder parseencoder)
        throws JSONException
    {
        return encode(parseencoder);
    }

    public JSONObject encode(ParseEncoder parseencoder)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("__op", "AddUnique");
        jsonobject.put("objects", parseencoder.encode(new ArrayList(objects)));
        return jsonobject;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parsefieldoperation)
    {
        if (parsefieldoperation == null)
        {
            return this;
        }
        if (parsefieldoperation instanceof ParseDeleteOperation)
        {
            return new ParseSetOperation(objects);
        }
        if (parsefieldoperation instanceof ParseSetOperation)
        {
            parsefieldoperation = ((ParseFieldOperation) (((ParseSetOperation)parsefieldoperation).getValue()));
            if ((parsefieldoperation instanceof JSONArray) || (parsefieldoperation instanceof List))
            {
                return new ParseSetOperation(apply(parsefieldoperation, null));
            } else
            {
                throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
            }
        }
        if (parsefieldoperation instanceof ParseAddUniqueOperation)
        {
            return new ParseAddUniqueOperation((List)apply(new ArrayList(((ParseAddUniqueOperation)parsefieldoperation).objects), null));
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
