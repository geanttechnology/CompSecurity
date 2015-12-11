// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.util.Log;

// Referenced classes of package com.amazon.dcp.settings:
//            SettingLong

public final class SettingInteger
{

    private static final String TAG = com/amazon/dcp/settings/SettingInteger.getName();
    private final int mDefaultValue;
    private final SettingLong mSetting;

    public SettingInteger(String s, int i)
    {
        mSetting = new SettingLong(s, i);
        mDefaultValue = i;
    }

    public int getValue()
    {
        long l = mSetting.getValue();
        if (l > 0x7fffffffL || l < 0xffffffff80000000L)
        {
            Log.w(TAG, String.format("%s=%d is too big for SettingInteger. Using default value (%d) instead.", new Object[] {
                mSetting.getKey(), Long.valueOf(l), Integer.valueOf(mDefaultValue)
            }));
            return mDefaultValue;
        } else
        {
            return (int)l;
        }
    }

}
