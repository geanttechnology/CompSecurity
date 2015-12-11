// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.opl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.util.ConfigUtils;

public class AddressPickerView
{

    public AddressPickerView()
    {
    }

    public static Intent getCVSDMapActivityIntent(Activity activity)
        throws ClassNotFoundException
    {
        return new Intent(activity, Class.forName("com.amazon.mShop.cvsd.CVSDMapActivity"));
    }

    public static boolean hasCVSD(Context context)
    {
        return ConfigUtils.isEnabled(context, com.amazon.mShop.android.lib.R.string.config_has_cvsd) && isDeviceHasGoogleMapLib();
    }

    private static boolean isDeviceHasGoogleMapLib()
    {
        Class class1 = null;
        Class class2 = Class.forName("com.amazon.mShop.cvsd.CVSDMapActivity");
        class1 = class2;
_L1:
        ClassNotFoundException classnotfoundexception;
        return class1 != null;
        classnotfoundexception;
        Log.d("AddressPickerView", classnotfoundexception.getMessage());
          goto _L1
    }
}
