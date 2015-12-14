// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.HashMap;
import java.util.Map;

public class DelegatedAccountHelper
{

    private static final Map CACHE = new HashMap();
    private static final String TAG = com/amazon/identity/auth/accounts/DelegatedAccountHelper.getName();

    public DelegatedAccountHelper()
    {
    }

    public String getDelegateeAccountForTheDelegatedAccount(String s, DataStorage datastorage)
    {
        String s1 = (String)CACHE.get(s);
        if (!TextUtils.isEmpty(s1))
        {
            return s1;
        }
        datastorage = datastorage.getUserData(s, "com.amazon.dcp.sso.property.account.delegateeaccount");
        if (!TextUtils.isEmpty(datastorage))
        {
            CACHE.put(s, datastorage);
        }
        return datastorage;
    }

    public String getDelegationDomainForDirectedId(String s, DataStorage datastorage)
    {
        if (TextUtils.isEmpty(s) || datastorage == null)
        {
            MAPLog.e(TAG, "Invalid Arguments in getDelegationDomainForDirectedId. Returning null.");
            return null;
        } else
        {
            return datastorage.getUserData(s, "com.amazon.dcp.sso.property.account.delegationDomain");
        }
    }

    public String getDelegationDomainFromAPIBundle(Bundle bundle)
    {
        String s = AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle);
        bundle = s;
        if (!TextUtils.isEmpty(s))
        {
            bundle = AmazonDomainHelper.getCompleteAuthPortalDomain(s);
        }
        return bundle;
    }

}
