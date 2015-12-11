// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amazon.dp.logger.DPLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CrashDescriptorDedupeUtil
{

    private static final DPLogger log = new DPLogger("CrashManager.DedupeUtil");
    private final Map mDescriptorMap = new HashMap();
    private final SharedPreferences mSharedPreferences;

    public CrashDescriptorDedupeUtil(SharedPreferences sharedpreferences)
    {
        mSharedPreferences = sharedpreferences;
        loadFromSharedPreference();
    }

    private void loadFromSharedPreference()
    {
        String as[];
        int i;
        int j;
        String s = mSharedPreferences.getString("CrashDescriptors", null);
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        as = s.split(" ");
        j = as.length;
        i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        String s1 = as[i];
        int k = mSharedPreferences.getInt(s1, 0);
        if (k > 0)
        {
            try
            {
                mDescriptorMap.put(s1, Integer.valueOf(k));
            }
            catch (ClassCastException classcastexception)
            {
                log.warn("loadFromSharedPreferences", "Error retrieving descriptor.", new Object[] {
                    classcastexception
                });
            }
        }
        i++;
          goto _L3
_L2:
        log.debug("loadFromSharedPreference", (new StringBuilder()).append("finish loading, map size = ").append(mDescriptorMap.size()).toString(), new Object[0]);
        return;
    }

    public void clearAll()
    {
        mSharedPreferences.edit().clear().commit();
    }

    public boolean contains(String s)
    {
        return getCount(s) > 0;
    }

    public int getCount(String s)
    {
        return mSharedPreferences.getInt(s, 0);
    }

    public void increaseCounter(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            Map map = mDescriptorMap;
            int i;
            if (mDescriptorMap.get(s) == null)
            {
                i = 1;
            } else
            {
                i = ((Integer)mDescriptorMap.get(s)).intValue() + 1;
            }
            map.put(s, Integer.valueOf(i));
            log.debug("increaseCounter", (new StringBuilder()).append("increaseCounter, descriptor=").append(s).append(" counter=").append(mDescriptorMap.get(s)).toString(), new Object[0]);
        }
    }

    public void persistCrashDescriptors()
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = mDescriptorMap.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            log.debug("saveToSharedPreferences", "Save Key =", new Object[] {
                entry.getKey()
            });
            stringbuilder.append((String)entry.getKey()).append(" ");
            if (entry.getValue() != null)
            {
                editor.putInt((String)entry.getKey(), ((Integer)entry.getValue()).intValue());
            }
        } while (true);
        editor.putString("CrashDescriptors", stringbuilder.toString());
        editor.commit();
    }

    public void prune(String s)
    {
        mSharedPreferences.edit().remove(s).commit();
    }

}
