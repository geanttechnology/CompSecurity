// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.codec.binary.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperations, ParseDateFormat, ParseFile, ParseGeoPoint, 
//            ParseObject, ParseRelation

class ParseDecoder
{

    private static final ParseDecoder INSTANCE = new ParseDecoder();

    protected ParseDecoder()
    {
    }

    public static ParseDecoder get()
    {
        return INSTANCE;
    }

    List convertJSONArrayToList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(decode(jsonarray.opt(i)));
        }

        return arraylist;
    }

    Map convertJSONObjectToMap(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, decode(jsonobject.opt(s))))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    public Object decode(Object obj)
    {
        Object obj1;
        if (obj instanceof JSONArray)
        {
            obj1 = convertJSONArrayToList((JSONArray)obj);
        } else
        {
            obj1 = obj;
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
                if (((JSONObject) (obj)).optString("__op", null) != null)
                {
                    try
                    {
                        obj = ParseFieldOperations.decode(((JSONObject) (obj)), this);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new RuntimeException(((Throwable) (obj)));
                    }
                    return obj;
                }
                String s = ((JSONObject) (obj)).optString("__type", null);
                if (s == null)
                {
                    return convertJSONObjectToMap(((JSONObject) (obj)));
                }
                if (s.equals("Date"))
                {
                    obj = ((JSONObject) (obj)).optString("iso");
                    return ParseDateFormat.getInstance().parse(((String) (obj)));
                }
                if (s.equals("Bytes"))
                {
                    return Base64.decodeBase64(((JSONObject) (obj)).optString("base64"));
                }
                if (s.equals("Pointer"))
                {
                    return decodePointer(((JSONObject) (obj)).optString("className"), ((JSONObject) (obj)).optString("objectId"));
                }
                if (s.equals("File"))
                {
                    return new ParseFile(((JSONObject) (obj)), this);
                }
                if (s.equals("GeoPoint"))
                {
                    double d;
                    double d1;
                    try
                    {
                        d = ((JSONObject) (obj)).getDouble("latitude");
                        d1 = ((JSONObject) (obj)).getDouble("longitude");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new RuntimeException(((Throwable) (obj)));
                    }
                    return new ParseGeoPoint(d, d1);
                }
                if (s.equals("Object"))
                {
                    return ParseObject.fromJSON(((JSONObject) (obj)), null, true, this);
                }
                if (s.equals("Relation"))
                {
                    return new ParseRelation(((JSONObject) (obj)), this);
                }
                if (s.equals("OfflineObject"))
                {
                    throw new RuntimeException("An unexpected offline pointer was encountered.");
                } else
                {
                    return null;
                }
            }
        }
        return obj1;
    }

    protected ParseObject decodePointer(String s, String s1)
    {
        return ParseObject.createWithoutData(s, s1);
    }

}
