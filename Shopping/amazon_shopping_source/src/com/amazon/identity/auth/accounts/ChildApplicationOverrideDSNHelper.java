// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.text.TextUtils;
import com.amazon.identity.auth.device.api.CustomerAttributeKeys;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.StringHelpers;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ChildApplicationOverrideDSNHelper
{

    private ChildApplicationOverrideDSNHelper()
    {
    }

    public static Collection getOverridingDSNChildDeviceTypePackages(String s, DataStorage datastorage)
    {
        com/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;
        JVM INSTR monitorenter ;
        s = datastorage.getToken(s, "overriding_dsn_child_device_types_key");
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = StringHelpers.splitToSet(s, ";");
_L4:
        com/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = new HashSet();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static boolean isOverridingDSN(String s, FeatureSet featureset)
    {
        return !TextUtils.isEmpty(s) && featureset.hasFeature(Feature.OverrideDeviceAttributes);
    }

    public static void setOverridDSNChildDeviceType(AccountTransaction accounttransaction, String s, String s1, FeatureSet featureset)
    {
        if (isOverridingDSN(s, featureset))
        {
            accounttransaction.setUserData(CustomerAttributeKeys.getDsnKeyForPackage(s1), s);
            setTokenForOverridingDSNChildDeviceTypes(accounttransaction, s1);
        }
    }

    private static void setTokenForOverridingDSNChildDeviceTypes(AccountTransaction accounttransaction, String s)
    {
        com/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;
        JVM INSTR monitorenter ;
        Set set = StringHelpers.splitToSet(accounttransaction.getToken("overriding_dsn_child_device_types_key"), ";");
        set.add(s);
        accounttransaction.setToken("overriding_dsn_child_device_types_key", StringHelpers.join(";", set));
        com/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;
        JVM INSTR monitorexit ;
        return;
        accounttransaction;
        throw accounttransaction;
    }
}
