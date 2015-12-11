// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.persistence;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amazon.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice.persistence:
//            ZeroesCache

public class SharedPreferencesCache
    implements ZeroesCache
{

    private static final Logger LOG = Logger.getLogger(com/amazon/zeroes/intentservice/persistence/SharedPreferencesCache);
    private SharedPreferences sharedPreferences;

    public SharedPreferencesCache(SharedPreferences sharedpreferences)
    {
        sharedPreferences = sharedpreferences;
    }

    private static long getExpiration(long l)
    {
        long l1 = System.currentTimeMillis();
        if (l < 0L)
        {
            return 0x36ee80L + l1;
        } else
        {
            return l1 + l;
        }
    }

    private String getFromPreferences(String s)
    {
        return sharedPreferences.getString((new StringBuilder()).append("Zeroes.").append(s).toString(), null);
    }

    private boolean putIntoPreferences(String s, String s1)
    {
        return sharedPreferences.edit().putString((new StringBuilder()).append("Zeroes.").append(s).toString(), s1).commit();
    }

    private boolean removeFromPreferences(String s)
    {
        return sharedPreferences.edit().remove((new StringBuilder()).append("Zeroes.").append(s).toString()).commit();
    }

    public String get(String s)
    {
        String s1 = null;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Object obj;
        return s1;
_L2:
        if ((obj = getFromPreferences(s)) == null) goto _L1; else goto _L3
_L3:
        obj = new JSONObject(((String) (obj)));
        s1 = ((JSONObject) (obj)).getString("value");
        if (((JSONObject) (obj)).getLong("expiration") >= System.currentTimeMillis()) goto _L1; else goto _L4
_L4:
        LOG.i((new StringBuilder()).append("Removing expired cache item ").append(s).toString());
        removeFromPreferences(s);
        return null;
        JSONException jsonexception;
        jsonexception;
        LOG.e((new StringBuilder()).append("Removing malformed cache item ").append(s).toString(), jsonexception);
        removeFromPreferences(s);
        return null;
    }

    public boolean invalidate(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return removeFromPreferences(s);
        }
    }

    public boolean put(String s, String s1, long l)
    {
        if (TextUtils.isEmpty(s) || s1 == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("value", s1);
            jsonobject.put("expiration", getExpiration(l));
            flag = putIntoPreferences(s, jsonobject.toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            LOG.e((new StringBuilder()).append("Failed to construct cache the item for ").append(s).toString(), s1);
            return false;
        }
        return flag;
    }

}
