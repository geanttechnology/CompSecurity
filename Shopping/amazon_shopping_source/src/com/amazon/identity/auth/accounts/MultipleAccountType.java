// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.setting.PlatformSettings;

public final class MultipleAccountType extends Enum
{

    private static final MultipleAccountType $VALUES[];
    public static final MultipleAccountType Default;
    public static final MultipleAccountType Profile;
    private static final String TAG = com/amazon/identity/auth/accounts/MultipleAccountType.getName();
    private final String mValue;

    private MultipleAccountType(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static MultipleAccountType getCurrentProfileType(Context context)
    {
        context = PlatformSettings.getInstance(context).getSettingString("multiple.account.type", "Default");
        MultipleAccountType amultipleaccounttype[] = values();
        int j = amultipleaccounttype.length;
        for (int i = 0; i < j; i++)
        {
            MultipleAccountType multipleaccounttype = amultipleaccounttype[i];
            if (multipleaccounttype.mValue.equals(context))
            {
                return multipleaccounttype;
            }
        }

        MAPLog.w(TAG, "Do not recongize %s as a profile type. Returning default", new Object[] {
            context
        });
        return Default;
    }

    public static MultipleAccountType valueOf(String s)
    {
        return (MultipleAccountType)Enum.valueOf(com/amazon/identity/auth/accounts/MultipleAccountType, s);
    }

    public static MultipleAccountType[] values()
    {
        return (MultipleAccountType[])$VALUES.clone();
    }

    static 
    {
        Profile = new MultipleAccountType("Profile", 0, "Profile");
        Default = new MultipleAccountType("Default", 1, "Default");
        $VALUES = (new MultipleAccountType[] {
            Profile, Default
        });
    }
}
