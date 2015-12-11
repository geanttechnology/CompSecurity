// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.dcp.settings:
//            SettingsNamespace

final class SettingsMap
{
    public static final class Builder
    {

        static final boolean $assertionsDisabled;
        private SettingsMap mBuilt;
        private Map mMap;

        public SettingsMap build()
        {
            SettingsMap settingsmap = mBuilt;
            clear();
            return settingsmap;
        }

        public void clear()
        {
            mMap = new HashMap();
            mMap.put(SettingsNamespace.AppLocal, new HashMap());
            mMap.put(SettingsNamespace.DeviceGlobal, new HashMap());
            mBuilt = new SettingsMap();
            mBuilt.mMap = new HashMap();
            mBuilt.mMap.put(SettingsNamespace.AppLocal, Collections.unmodifiableMap((Map)mMap.get(SettingsNamespace.AppLocal)));
            mBuilt.mMap.put(SettingsNamespace.DeviceGlobal, Collections.unmodifiableMap((Map)mMap.get(SettingsNamespace.DeviceGlobal)));
            mBuilt.mMap = Collections.unmodifiableMap(mBuilt.mMap);
        }

        public void setValue(SettingsNamespace settingsnamespace, String s, String s1)
        {
            settingsnamespace = SettingsMap.getNamespaceSettings(mMap, settingsnamespace);
            if (settingsnamespace == null)
            {
                throw new IllegalArgumentException();
            } else
            {
                settingsnamespace.put(s, s1);
                return;
            }
        }

        static 
        {
            boolean flag;
            if (!com/amazon/dcp/settings/SettingsMap.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
        }

        public Builder()
        {
            mMap = null;
            mBuilt = null;
            clear();
        }
    }


    private static final String TAG = com/amazon/dcp/settings/SettingsMap.getName();
    private Map mMap;

    public SettingsMap()
    {
        mMap = null;
    }

    private static Map getNamespaceSettings(Map map, SettingsNamespace settingsnamespace)
    {
        if (settingsnamespace == SettingsNamespace.Default)
        {
            return (Map)map.get(SettingsNamespace.AppLocal);
        } else
        {
            return (Map)map.get(settingsnamespace);
        }
    }

    public String getValue(SettingsNamespace settingsnamespace, String s, String s1)
    {
        settingsnamespace = getNamespaceSettings(mMap, settingsnamespace);
        if (settingsnamespace == null || !settingsnamespace.containsKey(s))
        {
            return s1;
        } else
        {
            return (String)settingsnamespace.get(s);
        }
    }





/*
    static Map access$102(SettingsMap settingsmap, Map map)
    {
        settingsmap.mMap = map;
        return map;
    }

*/
}
