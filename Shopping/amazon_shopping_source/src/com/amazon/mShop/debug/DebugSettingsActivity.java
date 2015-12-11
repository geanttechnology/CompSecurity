// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.os.Bundle;
import android.view.Menu;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.debug:
//            DebugSettingsView

public class DebugSettingsActivity extends AmazonActivity
{

    protected Map mLocaleRelatedSettings;

    public DebugSettingsActivity()
    {
        mLocaleRelatedSettings = new HashMap();
    }

    private String getSettingValueByLocale(String s, String s1)
    {
        Object obj = null;
        Map map = (Map)mLocaleRelatedSettings.get(s);
        s = obj;
        if (map != null)
        {
            s = (String)map.get(s1);
        }
        return s;
    }

    private void saveToDataStore(String s)
    {
        LocaleUtils.setCurrentAppLocale(s);
        java.util.Map.Entry entry;
        for (s = mLocaleRelatedSettings.entrySet().iterator(); s.hasNext(); saveToDataStore((String)entry.getKey(), (Map)entry.getValue()))
        {
            entry = (java.util.Map.Entry)s.next();
        }

    }

    private void saveToDataStore(String s, String s1, String s2)
    {
        AndroidPlatform.getInstance().getDataStore().putString(s1, s2, s);
    }

    private void saveToDataStore(String s, Map map)
    {
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            if ("clearSessionData".equals(s1))
            {
                if (Boolean.parseBoolean(((String) (obj))))
                {
                    AndroidPlatform.getInstance().getDataStore().removeSessionData(s);
                }
            } else
            {
                saveToDataStore(s, s1, ((String) (obj)));
            }
        } while (true);
    }

    public final boolean getClearSessionDataSettingInMap(String s)
    {
        return Boolean.parseBoolean(getSettingValueByLocale(s, "clearSessionData"));
    }

    public final String getSSOCheckLoginServerInMap(String s)
    {
        return getSettingValueByLocale(s, "currentSSOCheckLoginServer");
    }

    public final String getServiceSecureUrlInMap(String s)
    {
        return getSettingValueByLocale(s, "currentServiceSecureUrl");
    }

    public final String getServiceUrlInMap(String s)
    {
        return getSettingValueByLocale(s, "currentServiceUrl");
    }

    protected void initSettingsMap()
    {
        mLocaleRelatedSettings.clear();
        Object aobj[] = AppLocale.getInstance().getSupportedLocaleNameArray();
        for (int i = 0; i < aobj.length; i++)
        {
            String s = (String)aobj[i];
            recordInMap(s, readServiceUrlFromDataStore(s), readServiceSecureUrlFromDataStore(s), readSSOCheckLoginServerFromDataStore(s), false);
        }

    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initSettingsMap();
        pushView(new DebugSettingsView(this));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public final String readSSOCheckLoginServerFromDataStore(String s)
    {
        return AndroidPlatform.getInstance().getDataStore().getString("currentSSOCheckLoginServer", s);
    }

    public final String readServiceSecureUrlFromDataStore(String s)
    {
        return AndroidPlatform.getInstance().getDataStore().getString("currentServiceSecureUrl", s);
    }

    public final String readServiceUrlFromDataStore(String s)
    {
        return AndroidPlatform.getInstance().getDataStore().getString("currentServiceUrl", s);
    }

    public void recordInMap(String s, String s1, String s2, String s3, boolean flag)
    {
        Map map = (Map)mLocaleRelatedSettings.get(s);
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
            mLocaleRelatedSettings.put(s, obj);
        }
        ((Map) (obj)).put("currentServiceUrl", s1);
        ((Map) (obj)).put("currentServiceSecureUrl", s2);
        ((Map) (obj)).put("clearSessionData", Boolean.toString(flag));
        ((Map) (obj)).put("currentSSOCheckLoginServer", s3);
    }

    public void saveChangesAndRestart(String s)
    {
        saveToDataStore(s);
        AppUtils.restartApp();
    }
}
