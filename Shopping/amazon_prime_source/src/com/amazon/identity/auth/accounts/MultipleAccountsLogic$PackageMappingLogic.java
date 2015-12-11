// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, AmazonAccountManager

private static class e extends 
{

    public static List constructPackageMappingsForAccount(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager, String s)
    {
        Object obj = getMetadataForAccount(new BackwardsCompatiableDataStorage(servicewrappingcontext), s, "com.amazon.dcp.sso.property.account.extratokens.account_packages");
        s = new ArrayList();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.add(new <init>(servicewrappingcontext, new com.amazon.identity.auth.device.api.<init>((String)((Iterator) (obj)).next()), amazonaccountmanager))) { }
        return s;
    }

    public boolean isSupportedOnThisPlatform()
    {
        return com.amazon.identity.auth.device.api.isSupportedOnThisPlatform(mContext);
    }

    public List notifyOfChange()
    {
        return Arrays.asList(new mContext[] {
            new it>("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED", mMapping.getAccountMappingValue(), null)
        });
    }

    public e(ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api. , AmazonAccountManager amazonaccountmanager)
    {
        super(servicewrappingcontext, , amazonaccountmanager);
    }
}
