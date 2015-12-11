// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, AmazonAccountManager

private static class  extends 
{

    public static List constructProfileMappingForAccount(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager, String s)
    {
        Object obj = getMetadataForAccount(new BackwardsCompatiableDataStorage(servicewrappingcontext), s, "com.amazon.dcp.sso.property.account.extratokens.account_profiles");
        s = new ArrayList();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s1 = (String)((Iterator) (obj)).next();
            Integer integer = StringConversionHelpers.toInteger(s1);
            if (integer == null)
            {
                MAPLog.e(MultipleAccountsLogic.access$000(), "%s is not a valid profile id", new Object[] {
                    s1
                });
            } else
            {
                s.add(new <init>(servicewrappingcontext, com.amazon.identity.auth.device.api.atePrimaryMappingForProfile(integer.intValue()), amazonaccountmanager));
            }
        }

        return s;
    }

    public boolean isSupportedOnThisPlatform()
    {
        return ((PlatformWrapper)mContext.getSystemService("sso_platform")).shouldUseProfiles();
    }

    public List notifyOfChange()
    {
        return Arrays.asList(new mContext[] {
            new mContext("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED")
        });
    }

    public (ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api. , AmazonAccountManager amazonaccountmanager)
    {
        super(servicewrappingcontext, , amazonaccountmanager);
    }
}
