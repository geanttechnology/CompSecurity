// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.experiment;

import android.content.res.Resources;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;

public class DisplaySettingsUtil
{

    public DisplaySettingsUtil()
    {
    }

    public static boolean displaySettingsEnabled(Resources resources, FeatureConfiguration featureconfiguration)
    {
        return "true".equals(resources.getString(com.amazon.retailsearch.R.string.config_rs_display_settings_enabled)) && featureconfiguration != null && featureconfiguration.isFeatureActivated("SX_mShop_Android_Dynamic_Display_Settings");
    }
}
