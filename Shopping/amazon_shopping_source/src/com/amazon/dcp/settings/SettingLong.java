// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.util.Log;

// Referenced classes of package com.amazon.dcp.settings:
//            SettingString

public final class SettingLong
{

    private static final String TAG = com/amazon/dcp/settings/SettingLong.getName();
    private final long mDefaultValue;
    private final SettingString mSetting;

    public SettingLong(String s, long l)
    {
        mSetting = new SettingString(s, null);
        mDefaultValue = l;
    }

    public String getKey()
    {
        return mSetting.getKey();
    }

    public long getValue()
    {
        String s = mSetting.getValue();
        if (s == null)
        {
            return mDefaultValue;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.w(TAG, String.format("%s='%s' won't parse as long. Using default value (%d) instead.", new Object[] {
                getKey(), s, Long.valueOf(mDefaultValue)
            }));
            return mDefaultValue;
        }
        return l;
    }

}
