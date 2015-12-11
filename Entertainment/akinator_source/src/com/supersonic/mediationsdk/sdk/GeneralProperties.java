// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralProperties
{

    public static final String APP_KEY = "app_key";
    private static GeneralProperties mInstance;
    private JSONObject mProperties;

    private GeneralProperties()
    {
        mProperties = new JSONObject();
    }

    public static GeneralProperties getProperties()
    {
        com/supersonic/mediationsdk/sdk/GeneralProperties;
        JVM INSTR monitorenter ;
        GeneralProperties generalproperties;
        if (mInstance == null)
        {
            mInstance = new GeneralProperties();
        }
        generalproperties = mInstance;
        com/supersonic/mediationsdk/sdk/GeneralProperties;
        JVM INSTR monitorexit ;
        return generalproperties;
        Exception exception;
        exception;
        throw exception;
    }

    public String get(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = mProperties.optString(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void putKey(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        try
        {
            mProperties.put(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            this;
        }
        return;
        throw s;
    }

    public void putKeys(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); putKey(s, (String)map.get(s)))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_60;
        map;
        throw map;
        this;
        JVM INSTR monitorexit ;
    }

    public JSONObject toJSON()
    {
        this;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = mProperties;
        this;
        JVM INSTR monitorexit ;
        return jsonobject;
        Exception exception;
        exception;
        throw exception;
    }
}
