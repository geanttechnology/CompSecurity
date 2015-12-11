// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;


// Referenced classes of package com.amazon.dcp.settings:
//            SettingsCache, SettingsNamespace

public final class SettingString
{

    private final SettingsCache mCache;
    private final String mDefaultValue;
    private final String mKey;
    private final SettingsNamespace mNamespace;

    public SettingString(SettingsNamespace settingsnamespace, String s, String s1)
    {
        mNamespace = settingsnamespace;
        mKey = s;
        mDefaultValue = s1;
        mCache = SettingsCache.getInstance();
    }

    public SettingString(String s, String s1)
    {
        this(SettingsNamespace.Default, s, s1);
    }

    public String getKey()
    {
        return mKey;
    }

    public String getValue()
    {
        return mCache.getValue(mNamespace, mKey, mDefaultValue);
    }
}
