// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;

import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sponsorpay.mediation:
//            SPMediationConfigurationFiles

public class SPMediationConfigurator
{

    public static SPMediationConfigurator INSTANCE = new SPMediationConfigurator();
    private static final String TAG = "SPMediationConfigurator";
    private Map mConfigurations;

    private SPMediationConfigurator()
    {
        mConfigurations = new HashMap();
        mConfigurations = parseConfiguration(SPMediationConfigurationFiles.getAdaptersConfig());
    }

    public static Object getConfiguration(String s, String s1, Class class1)
    {
        s = INSTANCE.getConfigurationForAdapter(s);
        if (s != null && !s.isEmpty())
        {
            s = ((String) (s.get(s1)));
            if (s != null && s.getClass().isAssignableFrom(class1))
            {
                return s;
            }
        }
        return null;
    }

    public static Object getConfiguration(String s, String s1, Object obj, Class class1)
    {
        s = ((String) (getConfiguration(s, s1, class1)));
        if (s == null)
        {
            return obj;
        } else
        {
            return s;
        }
    }

    public static Map parseConfiguration(String s)
    {
        HashMap hashmap;
        SponsorPayLogger.d("SPMediationConfigurator", "Reading config file");
        hashmap = new HashMap();
        if (!StringUtils.notNullNorEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1;
        int i;
        JSONObject jsonobject;
        HashMap hashmap1;
        Iterator iterator;
        String s2;
        try
        {
            SponsorPayLogger.d("SPMediationConfigurator", "Parsing configurations");
            s = (new JSONObject(s)).getJSONArray("adapters");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SponsorPayLogger.e("SPMediationConfigurator", "A JSON error occurred while parsing the configuration file, there will be no mediation configurations.", s);
            return hashmap;
        }
        i = 0;
_L10:
        if (i < s.length())
        {
            break MISSING_BLOCK_LABEL_64;
        }
        SponsorPayLogger.d("SPMediationConfigurator", "configuration loaded successfully");
        return hashmap;
        jsonobject = s.getJSONObject(i);
        s1 = jsonobject.getString("name").toLowerCase();
        if (!jsonobject.has("settings")) goto _L4; else goto _L3
_L3:
        jsonobject = jsonobject.getJSONObject("settings");
        hashmap1 = new HashMap(jsonobject.length());
        iterator = jsonobject.keys();
_L8:
        if (iterator.hasNext()) goto _L6; else goto _L5
_L5:
        hashmap.put(s1, hashmap1);
          goto _L7
_L6:
        s2 = (String)iterator.next();
        hashmap1.put(s2, jsonobject.get(s2));
          goto _L8
_L4:
        hashmap.put(s1, Collections.emptyMap());
          goto _L7
_L2:
        SponsorPayLogger.d("SPMediationConfigurator", "Configuration was not found, there will be no mediation configurations.");
        return hashmap;
_L7:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Map getConfigurationForAdapter(String s)
    {
        return (Map)mConfigurations.get(s.toLowerCase());
    }

    public Map getMediationAdapters()
    {
        Object obj;
        SponsorPayLogger.d("SPMediationConfigurator", "Getting compatible adapters for SDK v6.5.2");
        obj = SPMediationConfigurationFiles.getAdapterInfo();
        if (!StringUtils.notNullNorEmpty(((String) (obj)))) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        obj = (new JSONObject(((String) (obj)))).getJSONArray("adapters");
        hashmap = new HashMap(((JSONArray) (obj)).length());
        int i = 0;
_L7:
        if (i < ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        SponsorPayLogger.d("SPMediationConfigurator", "adapters.info file successfully loaded");
        return hashmap;
        JSONObject jsonobject;
        LinkedList linkedlist;
        JSONArray jsonarray;
        jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        linkedlist = new LinkedList();
        jsonarray = jsonobject.getJSONArray("versions");
        int j = 0;
_L3:
        if (j < jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_126;
        }
        hashmap.put(jsonobject.getString("qualifiedName"), linkedlist);
        i++;
        continue; /* Loop/switch isn't completed */
        linkedlist.add(jsonarray.getString(j));
        j++;
          goto _L3
        JSONException jsonexception;
        jsonexception;
        SponsorPayLogger.e("SPMediationConfigurator", "An JSON error occured while parsing the adapters.info file, no mediation adapters will be loaded.", jsonexception);
_L5:
        return Collections.emptyMap();
_L2:
        SponsorPayLogger.e("SPMediationConfigurator", "The adapters.info file was not found, no adapters will be loaded.");
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean setConfigurationForAdapter(String s, Map map)
    {
        return mConfigurations.put(s.toLowerCase(), map) != null;
    }

}
