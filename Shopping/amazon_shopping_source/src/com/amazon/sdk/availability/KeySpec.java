// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import org.json.JSONException;
import org.json.JSONObject;

public class KeySpec
{

    private final String encryptionAlgorithm;
    private final String key;
    private long validAsOf;

    public KeySpec(String s, String s1, long l)
    {
        key = s;
        encryptionAlgorithm = s1;
        validAsOf = l;
    }

    public static KeySpec fromJSON(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        } else
        {
            return new KeySpec(jsonobject.optString("key"), jsonobject.optString("encryptionAlgorithm"), jsonobject.optLong("validAsOf"));
        }
    }

    private int getHashCode(Object obj)
    {
        if (obj == null)
        {
            return 0;
        } else
        {
            return key.hashCode();
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof KeySpec))
        {
            obj = (KeySpec)obj;
            String s = getKey();
            boolean flag;
            boolean flag1;
            if (s != null)
            {
                flag = s.equals(((KeySpec) (obj)).getKey());
            } else
            {
                flag = false;
            }
            s = getEncryptionAlgorithm();
            if (encryptionAlgorithm != null)
            {
                flag1 = s.equals(((KeySpec) (obj)).getEncryptionAlgorithm());
            } else
            {
                flag1 = false;
            }
            if (flag && flag1)
            {
                return true;
            }
        }
        return false;
    }

    public String getEncryptionAlgorithm()
    {
        return encryptionAlgorithm;
    }

    public String getKey()
    {
        return key;
    }

    public long getValidAsOf()
    {
        return validAsOf;
    }

    public int hashCode()
    {
        return (getHashCode(key) + 1554) * 37 + getHashCode(encryptionAlgorithm);
    }

    public void setValidAsOf(long l)
    {
        validAsOf = l;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("key", key).put("encryptionAlgorithm", encryptionAlgorithm).put("validAsOf", validAsOf);
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return jsonobject;
    }

    public String toString()
    {
        JSONObject jsonobject = toJSON();
        if (jsonobject != null)
        {
            return jsonobject.toString();
        } else
        {
            return "";
        }
    }
}
