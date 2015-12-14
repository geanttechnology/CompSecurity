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
//            ParseFieldOperation, ParseFieldOperations, ParseObject, Parse, 
//            ParseDeleteOperation, ParseSetOperation, ParseObjectEncodingStrategy

class ParseAddUniqueOperation
    implements ParseFieldOperation
{

    protected LinkedHashSet objects;

    public ParseAddUniqueOperation(Object obj)
    {
        objects = new LinkedHashSet();
        if (obj instanceof Collection)
        {
            objects.addAll((Collection)obj);
            return;
        } else
        {
            objects.add(obj);
            return;
        }
    }

    public Object apply(Object obj, ParseObject parseobject, String s)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new ArrayList(objects);
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
            s = new HashMap();
            for (int i = 0; i < parseobject.size(); i++)
            {
                if (parseobject.get(i) instanceof ParseObject)
                {
                    s.put(((ParseObject)parseobject.get(i)).getObjectId(), Integer.valueOf(i));
                }
            }

            Iterator iterator = objects.iterator();
            do
            {
                obj = parseobject;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = iterator.next();
                if (obj instanceof ParseObject)
                {
                    String s1 = ((ParseObject)obj).getObjectId();
                    if (s1 != null && s.containsKey(s1))
                    {
                        parseobject.set(((Integer)s.get(s1)).intValue(), obj);
                    } else
                    if (!parseobject.contains(obj))
                    {
                        parseobject.add(obj);
                    }
                } else
                if (!parseobject.contains(obj))
                {
                    parseobject.add(obj);
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
        jsonobject.put("__op", "AddUnique");
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
        if (parsefieldoperation instanceof ParseAddUniqueOperation)
        {
            return new ParseAddUniqueOperation((List)apply(new ArrayList(((ParseAddUniqueOperation)parsefieldoperation).objects), null, null));
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
