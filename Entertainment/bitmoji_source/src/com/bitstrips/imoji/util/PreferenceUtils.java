// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import java.util.Map;

// Referenced classes of package com.bitstrips.imoji.util:
//            MapUtils

public class PreferenceUtils
{

    private final Context context;
    private final SharedPreferences sharedPreferences;

    public PreferenceUtils(Context context1, int i)
    {
        context = context1;
        sharedPreferences = context1.getSharedPreferences(context1.getString(i), 0);
    }

    private Map getPriorityMap()
    {
        return MapUtils.asMap(getString(0x7f0600d9, null));
    }

    private void populateDefaultPriorityForPreOrdered(String as[], Map map)
    {
        int i = as.length - 1;
        while (i >= 0) 
        {
            String s = as[i];
            if (!map.containsKey(s))
            {
                map.put(s, String.valueOf(as.length - i));
            }
            i--;
        }
    }

    private void putMostRecentToFirst(Map map)
    {
        String s = getString(0x7f0600aa, null);
        if (!Strings.isNullOrEmpty(s))
        {
            map.put(s, String.valueOf(0x7fffffff));
        }
    }

    private com.google.common.collect.Maps.EntryTransformer stringToIntegerEntryTransformer()
    {
        return new com.google.common.collect.Maps.EntryTransformer() {

            final PreferenceUtils this$0;

            public Integer transformEntry(String s, String s1)
            {
                return Integer.valueOf(Integer.parseInt(s1));
            }

            public volatile Object transformEntry(Object obj, Object obj1)
            {
                return transformEntry((String)obj, (String)obj1);
            }

            
            {
                this$0 = PreferenceUtils.this;
                super();
            }
        };
    }

    public boolean getBoolean(int i, boolean flag)
    {
        return sharedPreferences.getBoolean(context.getString(i), flag);
    }

    public boolean getBoolean(String s, boolean flag)
    {
        return sharedPreferences.getBoolean(s, flag);
    }

    public Integer getInt(int i, int j)
    {
        return Integer.valueOf(sharedPreferences.getInt(context.getString(i), j));
    }

    public Map getShareImagePackagePriorityMap(String as[])
    {
        Map map = getPriorityMap();
        populateDefaultPriorityForPreOrdered(as, map);
        putMostRecentToFirst(map);
        return Maps.transformEntries(map, stringToIntegerEntryTransformer());
    }

    public String getString(int i, String s)
    {
        return sharedPreferences.getString(context.getString(i), s);
    }

    public void increaseShareImageAppPriority(String s)
    {
        Map map = getPriorityMap();
        if (!map.containsKey(s))
        {
            map.put(s, "0");
        }
        map.put(s, String.valueOf(Integer.parseInt((String)map.get(s)) + 1000));
        putString(0x7f0600d9, MapUtils.toString(map));
        putString(0x7f0600aa, s);
    }

    public void putBoolean(int i, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(i), flag);
        editor.apply();
    }

    public void putBoolean(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(s, flag);
        editor.apply();
    }

    public void putInt(int i, int j)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(context.getString(i), j);
        editor.apply();
    }

    public void putString(int i, String s)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(i), s);
        editor.apply();
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        sharedPreferences.registerOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }
}
