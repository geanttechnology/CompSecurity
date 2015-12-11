// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.urbanairship.Logger;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TagUtils
{

    private static final int MAX_TAG_LENGTH = 127;

    TagUtils()
    {
    }

    static Map convertToTagsMap(JsonValue jsonvalue)
    {
        HashMap hashmap = new HashMap();
        if (jsonvalue != null && jsonvalue.isJsonMap())
        {
            jsonvalue = jsonvalue.getMap().iterator();
            do
            {
                if (!jsonvalue.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)jsonvalue.next();
                HashSet hashset = new HashSet();
                Iterator iterator = ((JsonValue)entry.getValue()).getList().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    JsonValue jsonvalue1 = (JsonValue)iterator.next();
                    if (jsonvalue1.isString())
                    {
                        hashset.add(jsonvalue1.getString());
                    }
                } while (true);
                if (!hashset.isEmpty())
                {
                    hashmap.put(entry.getKey(), hashset);
                }
            } while (true);
        }
        return hashmap;
    }

    static Set normalizeTags(Set set)
    {
        if (set == null)
        {
            return null;
        }
        HashSet hashset = new HashSet();
        for (set = set.iterator(); set.hasNext();)
        {
            String s = (String)set.next();
            if (s == null)
            {
                Logger.debug("Null tag was removed from set.");
            } else
            {
                s = s.trim();
                if (s.length() <= 0 || s.length() > 127)
                {
                    Logger.error((new StringBuilder("Tag with zero or greater than max length was removed from set: ")).append(s).toString());
                } else
                {
                    hashset.add(s);
                }
            }
        }

        return hashset;
    }
}
