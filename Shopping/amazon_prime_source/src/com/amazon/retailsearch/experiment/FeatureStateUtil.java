// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.experiment;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.experimentation.WeblabClient;
import com.amazon.retailsearch.android.api.init.RetailSearchInitSettings;
import com.amazon.retailsearch.android.api.init.RetailSearchInitializer;

public class FeatureStateUtil
{

    public static final String TREATMENT_CONTROL = "C";

    private FeatureStateUtil()
    {
    }

    public static String getAdaptiveNetworkImageResolutionWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Adaptive_Nw_ImgRes");
    }

    public static String getAdaptiveSearchWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblabTreamentAndTriger("SX_mShop_Android_Adaptive_Search");
    }

    public static String getConsumableWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Consumable_Product_View");
    }

    public static String getDDSWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_DDS");
    }

    public static String getDisableConsumableAddToCartWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Disable_Consumable_Add_To_Cart");
    }

    public static String getISSPrefetchingWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_ISS_Prefetching");
    }

    public static String getImageSparkleWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblabTreamentAndTriger("SX_mShop_Android_Image_Sparkle");
    }

    public static String getInbandImageWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Inband_Image");
    }

    public static String getPastPurchaseWidgetWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Past_Purchase_Widget");
    }

    public static String getPrefetchingBudgetWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Prefetching_Budget");
    }

    public static String getPrefetchingMasterWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblabTreamentAndTriger("SX_mShop_Android_Master_Prefetching");
    }

    public static String getQueryBuilderPrefetchingWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Query_Builder_Prefetching");
    }

    public static String getSearchBoxPrefetchingWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_mShop_Android_Search_box_Prefetching");
    }

    public static String getSearchResultsCachingTreatment()
    {
        return getWeblabTreamentAndTriger("SX_mShop_Android_Search_Results_Caching");
    }

    public static String getSparkleWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblabTreamentAndTriger("SX_mShop_Android_Sparkle");
    }

    public static String getTextSparkleWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblabTreamentAndTriger("SX_mShop_Android_Text_Sparkle");
    }

    public static String getThumbSwitcherWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblab(featureconfiguration, "SX_MShop_Android_Thumb_Switcher");
    }

    public static String getTwisterRentalPriceWeblab(FeatureConfiguration featureconfiguration)
    {
        return getWeblabTreamentAndTriger("SX_mShop_Android_Twister_Rental_Price");
    }

    private static String getWeblab(FeatureConfiguration featureconfiguration, String s)
    {
        if (featureconfiguration == null) goto _L2; else goto _L1
_L1:
        featureconfiguration = featureconfiguration.getFeatureState(s);
_L4:
        s = featureconfiguration;
        if (TextUtils.isEmpty(featureconfiguration))
        {
            return "C";
        }
        break; /* Loop/switch isn't completed */
_L2:
        featureconfiguration = "C";
        if (true) goto _L4; else goto _L3
        featureconfiguration;
        s = "C";
_L3:
        return s;
    }

    private static String getWeblabTreamentAndTriger(String s)
    {
        try
        {
            s = RetailSearchInitializer.getInstance().getSettings().getWeblabClient().getTreatmentAndTrigger(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "C";
        }
        return s;
    }

    private static void postFeatureTrigger(String s)
    {
        RetailSearchInitializer.getInstance().getSettings().getWeblabClient().postFeatureTrigger(s);
    }
}
