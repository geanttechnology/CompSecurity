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
//            ParseFieldOperation, ParseFieldOperations, ParseObject, Parse, 
//            ParseDeleteOperation, ParseSetOperation, ParseObjectEncodingStrategy

class ParseRemoveOperation
    implements ParseFieldOperation
{

    protected HashSet objects;

    public ParseRemoveOperation(Object obj)
    {
        objects = new HashSet();
        objects.add(obj);
    }

    public ParseRemoveOperation(Collection collection)
    {
        objects = new HashSet();
        objects.addAll(collection);
    }

    public Object apply(Object obj, ParseObject parseobject, String s)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new ArrayList();
_L4:
        return obj;
_L2:
label0:
        {
            if (obj instanceof JSONArray)
            {
                return new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)obj), parseobject, s));
            }
            if (!(obj instanceof List))
            {
                break label0;
            }
            parseobject = new ArrayList((List)obj);
            parseobject.removeAll(objects);
            obj = new ArrayList(objects);
            ((ArrayList) (obj)).removeAll(parseobject);
            s = new HashSet();
            obj = ((ArrayList) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = ((Iterator) (obj)).next();
                if (obj1 instanceof ParseObject)
                {
                    s.add(((ParseObject)obj1).getObjectId());
                }
            } while (true);
            Iterator iterator = parseobject.iterator();
            do
            {
                obj = parseobject;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = iterator.next();
                if ((obj instanceof ParseObject) && s.contains(((ParseObject)obj).getObjectId()))
                {
                    iterator.remove();
                }
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException("Operation is invalid after previous operation.");
    }

    public volatile Object encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        return encode(parseobjectencodingstrategy);
    }

    public JSONObject encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("__op", "Remove");
        jsonobject.put("objects", Parse.encode(new ArrayList(objects), parseobjectencodingstrategy));
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
                return new ParseSetOperation(apply(parsefieldoperation, null, null));
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
