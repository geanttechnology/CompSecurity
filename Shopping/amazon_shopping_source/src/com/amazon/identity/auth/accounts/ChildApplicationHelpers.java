// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.MetaDataUtils;
import com.amazon.identity.auth.device.utils.Platform;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            ChildApplicationOverrideDSNHelper

public final class ChildApplicationHelpers
{

    private static final String TAG = com/amazon/identity/auth/accounts/ChildApplicationHelpers.getName();

    private ChildApplicationHelpers()
    {
    }

    public static Bundle createSuccessBundle()
    {
        return new Bundle();
    }

    private static String getIsRegisteredKeyForDeviceType(String s)
    {
        return (new StringBuilder()).append(s).append(".is_registered_key").toString();
    }

    public static boolean isChildApplication(Context context, String s)
    {
        return !DeviceTypeHelpers.areAppsWithDeviceTypeUsingDeviceCredentials(context, s);
    }

    public static boolean isChildApplicationDeviceTypeRegistered(Context context, String s, String s1)
    {
        if (!isChildApplication(context, s1))
        {
            MAPLog.e(TAG, String.format("%s is not a child application", new Object[] {
                s1
            }));
            return false;
        }
        s1 = getIsRegisteredKeyForDeviceType(s1);
        return ((DataStorageFactory)ServiceWrappingContext.create(context).getSystemService("dcp_data_storage_factory")).getDataStorage().getUserData(s, s1) != null;
    }

    public static boolean isInvalidChildDeviceType(String s)
    {
        return TextUtils.equals(s, "A1PY8QQU9P0WJV") || TextUtils.equals(s, "A17I2SKGZYX7FH") || TextUtils.equals(s, "A1MPSLFC7L5AFK");
    }

    public static boolean isOverridingDeviceAttributes(Context context, String s)
    {
        if (!Platform.hasFeature(context, Feature.OverrideDeviceAttributes))
        {
            return false;
        } else
        {
            return MetaDataUtils.getBooleanMetaDataForAPackage(context, s, "MAPDeviceAttributeRuntimeOverride", false).booleanValue();
        }
    }

    public static void setChildApplicationWithDeviceTypeRegistered(FeatureSet featureset, AccountTransaction accounttransaction, String s, String s1, String s2)
    {
        MAPLog.i(TAG, String.format("%s has registered", new Object[] {
            s
        }));
        accounttransaction.setUserData(getIsRegisteredKeyForDeviceType(s), "true");
        ChildApplicationOverrideDSNHelper.setOverridDSNChildDeviceType(accounttransaction, s2, s1, featureset);
    }

}
