// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class CredentialMapSerializer
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/CredentialMapSerializer.getName();

    private CredentialMapSerializer()
    {
    }

    public static String toJSONString(Map map)
    {
        if (map == null || map.size() == 0)
        {
            return null;
        }
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        map = map.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        JSONObject jsonobject1;
        if (!map.hasNext())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        entry = (java.util.Map.Entry)map.next();
        jsonobject1 = new JSONObject();
        java.util.Map.Entry entry1;
        for (Iterator iterator = ((Map)entry.getValue()).entrySet().iterator(); iterator.hasNext(); jsonobject1.putOpt((String)entry1.getKey(), entry1.getValue()))
        {
            entry1 = (java.util.Map.Entry)iterator.next();
        }

        try
        {
            jsonobject.put((String)entry.getKey(), jsonobject1);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException(map);
        }
          goto _L1
        map = jsonobject.toString();
        return map;
    }

    public static Map toMap(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        HashMap hashmap;
        HashMap hashmap1;
        hashmap = new HashMap();
        JSONObject jsonobject;
        Iterator iterator;
        JSONObject jsonobject1;
        Iterator iterator1;
        String s1;
        try
        {
            jsonobject = new JSONObject(s);
            iterator = jsonobject.keys();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, "CredentialMapSerializer.toMap failed - ignoring the credentials received: %s", s);
            return hashmap;
        }
_L5:
        s = hashmap;
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        s = (String)iterator.next();
        jsonobject1 = jsonobject.getJSONObject(s);
        iterator1 = jsonobject1.keys();
        hashmap1 = new HashMap();
        for (; iterator1.hasNext(); hashmap1.put(s1, jsonobject1.getString(s1)))
        {
            s1 = (String)iterator1.next();
        }

        hashmap.put(s, hashmap1);
          goto _L5
    }

}
