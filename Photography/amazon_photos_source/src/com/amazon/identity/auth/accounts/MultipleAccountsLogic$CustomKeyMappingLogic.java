// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, AmazonAccountManager

private static class init> extends init>
{

    public static List constructCustomKeyMappingsForAccount(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager, String s)
    {
        Object obj = getMetadataForAccount(new BackwardsCompatiableDataStorage(servicewrappingcontext), s, "com.amazon.dcp.sso.property.account.extratokens.custom_keys");
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
        String s = mMapping.tAccountMappingValue();
        String s1 = (new StringBuilder("com.amazon.identity.action.ACCOUNT_FOR_KEY.")).append(s).toString();
        Bundle bundle = new Bundle();
        bundle.putString("account_key", s);
        return Arrays.asList(new getAccountMappingValue[] {
            new >(s1, null, bundle), new >("com.amazon.identity.action.ACCOUNT_FOR_KEY", null, bundle)
        });
    }

    public e(ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api.X x, AmazonAccountManager amazonaccountmanager)
    {
        super(servicewrappingcontext, x, amazonaccountmanager);
    }
}
