// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.Context;
import android.content.SharedPreferences;
import com.aviary.android.feather.common.utils.ReflectionException;
import com.aviary.android.feather.common.utils.ReflectionUtils;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, IAviaryController

public class PreferenceService extends BaseContextService
{

    static final String BADGE_ITEM_PREFIX = "badge.item.";
    static final String BADGE_TOOL_PREFIX = "badge.tool.";
    public static final String MESSAGE_FIRST_LAUNCH = "message.service.firstLaunch";
    public static final String MESSAGE_PREFERENCE_PREFIX = "message.service.";
    public static final String MESSAGE_SHOW_TIMESTAMP = "message.service.lastMessageShowDate";
    static final String PREF_NAME = "com.aviary.android.feather.library";
    private boolean mFirstTimeCheck;
    private boolean mFirstTimeLaunch;
    private SharedPreferences mPrefs;

    public PreferenceService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
        mPrefs = iaviarycontroller.getBaseContext().getSharedPreferences("com.aviary.android.feather.library", 7);
    }

    public boolean containsSingleTimeKey(Class class1, String s)
    {
        return containsSingleTimeKey(class1, s, true);
    }

    public boolean containsSingleTimeKey(Class class1, String s, boolean flag)
    {
        boolean flag1 = containsValue((new StringBuilder()).append(class1.getName()).append(".").append(s).toString());
        if (!flag1 && flag)
        {
            putBoolean((new StringBuilder()).append(class1.getName()).append(".").append(s).toString(), true);
        }
        return flag1;
    }

    public boolean containsValue(String s)
    {
        return mPrefs.contains(s);
    }

    public void dispose()
    {
    }

    public boolean getBoolean(String s, boolean flag)
    {
        return mPrefs.getBoolean(s, flag);
    }

    public int getInt(String s, int i)
    {
        return mPrefs.getInt(s, i);
    }

    public long getLong(String s, long l)
    {
        return mPrefs.getLong(s, l);
    }

    public long getMessageLastShownDate()
    {
        return getLong("message.service.lastMessageShowDate", 0L);
    }

    public boolean getStandaloneBoolean(String s, boolean flag)
    {
        Object obj;
        boolean flag1;
        try
        {
            obj = getContext().getBaseContext();
            obj = ReflectionUtils.invokeStaticMethod("com.aviary.android.feather.utils.SettingsUtils", "getInstance", new Class[] {
                android/content/Context
            }, new Object[] {
                obj
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return flag;
        }
        flag1 = flag;
        if (obj != null)
        {
            try
            {
                s = (Boolean)ReflectionUtils.invokeMethod(obj, "getBoolean", new Class[] {
                    java/lang/String, Boolean.TYPE
                }, new Object[] {
                    s, Boolean.valueOf(flag)
                });
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return flag;
            }
            flag1 = s.booleanValue();
        }
        return flag1;
    }

    public String getString(String s, String s1)
    {
        return mPrefs.getString(s, s1);
    }

    public long getToolLastReadDate(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        return getLong((new StringBuilder()).append("badge.tool.").append(tools.name()).toString(), 0L);
    }

    public boolean isFirstTimeLaunch()
    {
        if (!mFirstTimeCheck)
        {
            mFirstTimeCheck = true;
            if (!containsValue("aviary.second.time.launch"))
            {
                putBoolean("aviary.second.time.launch", true);
                mFirstTimeLaunch = true;
            } else
            {
                mFirstTimeLaunch = false;
            }
        }
        return mFirstTimeLaunch;
    }

    public void markToolAsRead(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        putLong((new StringBuilder()).append("badge.tool.").append(tools.name()).toString(), System.currentTimeMillis());
    }

    public boolean putBoolean(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putBoolean(s, flag);
        return editor.commit();
    }

    public boolean putInt(String s, int i)
    {
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putInt(s, i);
        return editor.commit();
    }

    public boolean putLong(String s, long l)
    {
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putLong(s, l);
        return editor.commit();
    }

    public boolean putString(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(s, s1);
        return editor.commit();
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        mPrefs.registerOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }

    public void setMessageLastShownDate(long l)
    {
        putLong("message.service.lastMessageShowDate", l);
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        mPrefs.unregisterOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }
}
