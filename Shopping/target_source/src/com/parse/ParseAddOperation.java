// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, ParseFieldOperations, ParseEncoder, ParseDeleteOperation, 
//            ParseSetOperation

class ParseAddOperation
    implements ParseFieldOperation
{

    protected final ArrayList objects = new ArrayList();

    public ParseAddOperation(Collection collection)
    {
        objects.addAll(collection);
    }

    public Object apply(Object obj, String s)
    {
        if (obj == null)
        {
            return objects;
        }
        if (obj instanceof JSONArray)
        {
            return new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)obj), s));
        }
        if (obj instanceof List)
        {
            obj = new ArrayList((List)obj);
            ((ArrayList) (obj)).addAll(objects);
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
        jsonobject.put("__op", "Add");
        jsonobject.put("objects", parseencoder.encode(objects));
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
            if (parsefieldoperation instanceof JSONArray)
            {
                parsefieldoperation = ParseFieldOperations.jsonArrayAsArrayList((JSONArray)parsefieldoperation);
                parsefieldoperation.addAll(objects);
                return new ParseSetOperation(new JSONArray(parsefieldoperation));
            }
            if (parsefieldoperation instanceof List)
            {
                parsefieldoperation = new ArrayList((List)parsefieldoperation);
                parsefieldoperation.addAll(objects);
                return new ParseSetOperation(parsefieldoperation);
            } else
            {
                throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
            }
        }
        if (parsefieldoperation instanceof ParseAddOperation)
        {
            parsefieldoperation = new ArrayList(((ParseAddOperation)parsefieldoperation).objects);
            parsefieldoperation.addAll(objects);
            return new ParseAddOperation(parsefieldoperation);
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
