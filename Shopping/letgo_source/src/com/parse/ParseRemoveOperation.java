// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, ParseFieldOperations, ParseObject, ParseEncoder, 
//            ParseDeleteOperation, ParseSetOperation

class ParseRemoveOperation
    implements ParseFieldOperation
{

    protected HashSet objects;

    public ParseRemoveOperation(Collection collection)
    {
        objects = new HashSet();
        objects.addAll(collection);
    }

    public Object apply(Object obj, String s)
    {
        if (obj == null)
        {
            return new ArrayList();
        }
        if (obj instanceof JSONArray)
        {
            return new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)obj), s));
        }
        if (obj instanceof List)
        {
            obj = new ArrayList((List)obj);
            ((ArrayList) (obj)).removeAll(objects);
            Object obj1 = new ArrayList(objects);
            ((ArrayList) (obj1)).removeAll(((Collection) (obj)));
            s = new HashSet();
            obj1 = ((ArrayList) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Object obj2 = ((Iterator) (obj1)).next();
                if (obj2 instanceof ParseObject)
                {
                    s.add(((ParseObject)obj2).getObjectId());
                }
            } while (true);
            obj1 = ((ArrayList) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Object obj3 = ((Iterator) (obj1)).next();
                if ((obj3 instanceof ParseObject) && s.contains(((ParseObject)obj3).getObjectId()))
                {
                    ((Iterator) (obj1)).remove();
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
        jsonobject.put("__op", "Remove");
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
        if (parsefieldoperation instanceof ParseRemoveOperation)
        {
            parsefieldoperation = new HashSet(((ParseRemoveOperation)parsefieldoperation).objects);
            parsefieldoperation.addAll(objects);
            return new ParseRemoveOperation(parsefieldoperation);
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
