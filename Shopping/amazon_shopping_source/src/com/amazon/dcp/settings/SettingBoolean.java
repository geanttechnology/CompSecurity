// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.util.Log;

// Referenced classes of package com.amazon.dcp.settings:
//            SettingString

public final class SettingBoolean
{

    private static final String TAG = com/amazon/dcp/settings/SettingBoolean.getName();
    private final boolean mDefaultValue;
    private final SettingString mSetting;

    public SettingBoolean(String s, boolean flag)
    {
        mSetting = new SettingString(s, null);
        mDefaultValue = flag;
    }

    public String getKey()
    {
        return mSetting.getKey();
    }

    public boolean getValue()
    {
        boolean flag = true;
        String s = mSetting.getValue();
        if (s == null)
        {
            flag = mDefaultValue;
        } else
        if (!"true".equalsIgnoreCase(s))
        {
            if ("false".equalsIgnoreCase(s))
            {
                return false;
            } else
            {
                Log.w(TAG, String.format("%s='%s' won't parse as boolean. Using default value (%s) instead.", new Object[] {
                    getKey(), s, Boolean.toString(mDefaultValue)
                }));
                return mDefaultValue;
            }
        }
        return flag;
    }

}
