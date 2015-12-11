// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseACL, ParseFile, ParseGeoPoint, 
//            ParseRelation, ParseFieldOperation, ParseDateFormat

abstract class ParseEncoder
{

    ParseEncoder()
    {
    }

    static boolean isValidType(Object obj)
    {
        return (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || obj == JSONObject.NULL || (obj instanceof ParseObject) || (obj instanceof ParseACL) || (obj instanceof ParseFile) || (obj instanceof ParseGeoPoint) || (obj instanceof Date) || (obj instanceof byte[]) || (obj instanceof List) || (obj instanceof Map) || (obj instanceof ParseRelation);
    }

    public Object encode(Object obj)
    {
        Object obj1;
        if (obj instanceof ParseObject)
        {
            return encodeRelatedObject((ParseObject)obj);
        }
        if (obj instanceof ParseQuery.State.Builder)
        {
            return encode(((ParseQuery.State.Builder)obj).build());
        }
        if (obj instanceof ParseQuery.State)
        {
            return ((ParseQuery.State)obj).toJSON(this);
        }
        if (obj instanceof Date)
        {
            return encodeDate((Date)obj);
        }
        if (!(obj instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_111;
        }
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("__type", "Bytes");
        ((JSONObject) (obj1)).put("base64", Base64.encodeToString((byte[])(byte[])obj, 2));
        return obj1;
        if (obj instanceof ParseFile)
        {
            return ((ParseFile)obj).encode();
        }
        if (!(obj instanceof ParseGeoPoint))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        obj = (ParseGeoPoint)obj;
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("__type", "GeoPoint");
        ((JSONObject) (obj1)).put("latitude", ((ParseGeoPoint) (obj)).getLatitude());
        ((JSONObject) (obj1)).put("longitude", ((ParseGeoPoint) (obj)).getLongitude());
        return obj1;
        if (obj instanceof ParseACL)
        {
            return ((ParseACL)obj).toJSONObject(this);
        }
        if (!(obj instanceof Map))
        {
            break MISSING_BLOCK_LABEL_285;
        }
        obj1 = (Map)obj;
        obj = new JSONObject();
        java.util.Map.Entry entry;
        for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((JSONObject) (obj)).put((String)entry.getKey(), encode(entry.getValue())))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
        }

        return obj;
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
            obj1 = new JSONObject();
            String s;
            for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); ((JSONObject) (obj1)).put(s, encode(((JSONObject) (obj)).opt(s))))
            {
                s = (String)iterator.next();
            }

            break MISSING_BLOCK_LABEL_560;
        }
        if (obj instanceof Collection)
        {
            obj1 = new JSONArray();
            for (obj = ((Collection)obj).iterator(); ((Iterator) (obj)).hasNext(); ((JSONArray) (obj1)).put(encode(((Iterator) (obj)).next()))) { }
            break MISSING_BLOCK_LABEL_562;
        }
        if (!(obj instanceof JSONArray))
        {
            break MISSING_BLOCK_LABEL_458;
        }
        obj = (JSONArray)obj;
        obj1 = new JSONArray();
        int i = 0;
        do
        {
            try
            {
                if (i >= ((JSONArray) (obj)).length())
                {
                    break;
                }
                ((JSONArray) (obj1)).put(encode(((JSONArray) (obj)).opt(i)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
            i++;
        } while (true);
        break MISSING_BLOCK_LABEL_564;
        if (obj instanceof ParseRelation)
        {
            return ((ParseRelation)obj).encodeToJSON(this);
        }
        if (obj instanceof ParseFieldOperation)
        {
            return ((ParseFieldOperation)obj).encode(this);
        }
        if (obj instanceof ParseQuery.RelationConstraint)
        {
            return ((ParseQuery.RelationConstraint)obj).encode(this);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_518;
        }
        obj = JSONObject.NULL;
        return obj;
        if (!isValidType(obj))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type for ParseObject: ").append(obj.getClass().toString()).toString());
        } else
        {
            return obj;
        }
        return obj1;
        return obj1;
        return obj1;
    }

    protected JSONObject encodeDate(Date date)
    {
        JSONObject jsonobject = new JSONObject();
        date = ParseDateFormat.getInstance().format(date);
        try
        {
            jsonobject.put("__type", "Date");
            jsonobject.put("iso", date);
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            throw new RuntimeException(date);
        }
        return jsonobject;
    }

    protected abstract JSONObject encodeRelatedObject(ParseObject parseobject);
}
