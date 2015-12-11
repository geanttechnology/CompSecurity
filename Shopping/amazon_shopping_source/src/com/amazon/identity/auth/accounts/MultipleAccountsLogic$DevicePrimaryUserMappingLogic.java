// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, AmazonAccountManager

private static class mAmznAcctMan
    implements mAmznAcctMan
{

    private final AmazonAccountManager mAmznAcctMan;
    private final Context mContext;

    public static boolean isDevicePlatformMappingSet(AmazonAccountManager amazonaccountmanager, String s)
    {
        return amazonaccountmanager.isDevicePrimaryAmazonAccount(s);
    }

    public boolean isMappingCurrentlySetForAccount(String s)
    {
        return isDevicePlatformMappingSet(mAmznAcctMan, s);
    }

    public boolean isSupportedOnThisPlatform()
    {
        return com.amazon.identity.auth.device.api.ortedOnThisPlatform(mContext);
    }

    public List onDeregister(String s)
    {
        MultipleAccountsLogic.access$000();
        return new ArrayList();
    }

    public List removeAndNotify(String s)
    {
        MAPLog.e(MultipleAccountsLogic.access$000(), "Primary user mapping cannot be removed");
        return new ArrayList();
    }

    public List setAndNotify(String s)
    {
        MAPLog.e(MultipleAccountsLogic.access$000(), "Primary user mapping cannot be changed");
        return new ArrayList();
    }

    public (ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager)
    {
        mContext = servicewrappingcontext;
        mAmznAcctMan = amazonaccountmanager;
    }
}
