// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.features;

import android.content.Context;
import com.amazon.identity.auth.device.framework.SystemPropertiesWrapper;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.MetaDataUtils;
import com.amazon.identity.platform.setting.PlatformSettings;
import com.amazon.identity.platform.util.PlatformUtils;

public abstract class Feature extends Enum
{

    private static final Feature $VALUES[];
    public static final Feature CombinedDelegatedAuthenticationAndRegistration;
    public static final Feature DSNWhenNotRegistered;
    public static final Feature DirectedIdSupported;
    public static final Feature IsolateApplication;
    public static final Feature MovingAwayFromAM;
    public static final Feature OverrideDeviceAttributes;
    public static final Feature PandaExchangeRefreshToAccess;
    public static final Feature PandaRegistration;
    public static final Feature RegistrationViaAuthToken;
    public static final Feature SplitRegistration;
    public static final Feature SplitRegistrationWithDirectedId;
    public static final Feature TrustZone;
    public static final Feature UseDeviceLocaleAsLanguagePreference;

    private Feature(String s, int i)
    {
        super(s, i);
    }


    public static Feature valueOf(String s)
    {
        return (Feature)Enum.valueOf(com/amazon/identity/auth/device/features/Feature, s);
    }

    public static Feature[] values()
    {
        return (Feature[])$VALUES.clone();
    }

    abstract boolean fetchValue(Context context);

    static 
    {
        OverrideDeviceAttributes = new Feature("OverrideDeviceAttributes", 0) {

            boolean fetchValue(Context context)
            {
                return !PlatformUtils.isAmazonDevice(context);
            }

        };
        DSNWhenNotRegistered = new Feature("DSNWhenNotRegistered", 1) {

            boolean fetchValue(Context context)
            {
                return !CentralApkUtils.hasCentralAPK(context) || PlatformUtils.isAmazonDevice(context);
            }

        };
        PandaRegistration = new Feature("PandaRegistration", 2) {

            boolean fetchValue(Context context)
            {
                while ("panda".equals((new SystemPropertiesWrapper()).get("com.amazon.map.registration")) || !CentralApkUtils.hasCentralAPK(context)) 
                {
                    return true;
                }
                return false;
            }

        };
        SplitRegistration = new Feature("SplitRegistration", 3) {

            boolean fetchValue(Context context)
            {
                while ("split".equals((new SystemPropertiesWrapper()).get("com.amazon.map.registration")) || !PlatformUtils.isThirdPartyDevice(context)) 
                {
                    return true;
                }
                return false;
            }

        };
        DirectedIdSupported = new Feature("DirectedIdSupported", 4) {

            boolean fetchValue(Context context)
            {
                return PlatformUtils.isPostMergeDevice(context);
            }

        };
        SplitRegistrationWithDirectedId = new Feature("SplitRegistrationWithDirectedId", 5) {

            boolean fetchValue(Context context)
            {
                return !PlatformUtils.isThirdPartyDevice(context);
            }

        };
        RegistrationViaAuthToken = new Feature("RegistrationViaAuthToken", 6) {

            boolean fetchValue(Context context)
            {
                return PlatformUtils.isThirdPartyDevice(context);
            }

        };
        MovingAwayFromAM = new Feature("MovingAwayFromAM", 7) {

            boolean fetchValue(Context context)
            {
                return PlatformSettings.getInstance(context).getSettingBoolean("use_central_local_database", true);
            }

        };
        TrustZone = new Feature("TrustZone", 8) {

            boolean fetchValue(Context context)
            {
                return PlatformSettings.getInstance(context).getSettingBoolean("trust_zone", true);
            }

        };
        CombinedDelegatedAuthenticationAndRegistration = new Feature("CombinedDelegatedAuthenticationAndRegistration", 9) {

            boolean fetchValue(Context context)
            {
                return PlatformSettings.getInstance(context).getSettingBoolean("register_child_with_id", true);
            }

        };
        UseDeviceLocaleAsLanguagePreference = new Feature("UseDeviceLocaleAsLanguagePreference", 10) {

            boolean fetchValue(Context context)
            {
                return PlatformUtils.isAmazonDevice(context);
            }

        };
        IsolateApplication = new Feature("IsolateApplication", 11) {

            boolean fetchValue(Context context)
            {
                return MetaDataUtils.getBooleanMetaDataForAPackage$a09a196(context, context.getPackageName(), "MAPIsolateApplication").booleanValue();
            }

        };
        PandaExchangeRefreshToAccess = new Feature("PandaExchangeRefreshToAccess", 12) {

            boolean fetchValue(Context context)
            {
                return true;
            }

        };
        $VALUES = (new Feature[] {
            OverrideDeviceAttributes, DSNWhenNotRegistered, PandaRegistration, SplitRegistration, DirectedIdSupported, SplitRegistrationWithDirectedId, RegistrationViaAuthToken, MovingAwayFromAM, TrustZone, CombinedDelegatedAuthenticationAndRegistration, 
            UseDeviceLocaleAsLanguagePreference, IsolateApplication, PandaExchangeRefreshToAccess
        });
    }
}
