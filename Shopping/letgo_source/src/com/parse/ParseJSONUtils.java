// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSONUtils
{

    ParseJSONUtils()
    {
    }

    public static JSONObject create(JSONObject jsonobject, Collection collection)
    {
        JSONObject jsonobject1 = new JSONObject();
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!collection.contains(s))
            {
                try
                {
                    jsonobject1.put(s, jsonobject.opt(s));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    throw new RuntimeException(jsonobject);
                }
            }
        } while (true);
        return jsonobject1;
    }

    public static int getInt(JSONObject jsonobject, List list)
        throws JSONException
    {
        Iterator iterator = list.iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_36;
        }
        s = (String)iterator.next();
        int i = jsonobject.getInt(s);
        return i;
        throw new JSONException((new StringBuilder()).append("No value for ").append(list).toString());
        JSONException jsonexception;
        jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Iterable keys(JSONObject jsonobject)
    {
        return new Iterable(jsonobject) {

            final JSONObject val$finalObject;

            public Iterator iterator()
            {
                return finalObject.keys();
            }

            
            {
                finalObject = jsonobject;
                super();
            }
        };
    }
}
