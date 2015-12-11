// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.dcp.settings:
//            SettingsMap, SettingsNamespace

public static final class clear
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
        SettingsMap.access$102(mBuilt, new HashMap());
        SettingsMap.access$100(mBuilt).put(SettingsNamespace.AppLocal, Collections.unmodifiableMap((Map)mMap.get(SettingsNamespace.AppLocal)));
        SettingsMap.access$100(mBuilt).put(SettingsNamespace.DeviceGlobal, Collections.unmodifiableMap((Map)mMap.get(SettingsNamespace.DeviceGlobal)));
        SettingsMap.access$102(mBuilt, Collections.unmodifiableMap(SettingsMap.access$100(mBuilt)));
    }

    public void setValue(SettingsNamespace settingsnamespace, String s, String s1)
    {
        settingsnamespace = SettingsMap.access$000(mMap, settingsnamespace);
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

    public ()
    {
        mMap = null;
        mBuilt = null;
        clear();
    }
}
