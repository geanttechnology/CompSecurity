// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.ArrayUtil;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, SessionUserChanger, AmazonAccountManager

private static class mSessionUserChanger
    implements mSessionUserChanger
{

    private final AmazonAccountManager mAmznAcctMan;
    private final ServiceWrappingContext mContext;
    private final SessionUserChanger mSessionUserChanger;

    public static List constructSessionUserMappingsForAccount(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager, String s)
    {
        ArrayList arraylist = new ArrayList();
        if (amazonaccountmanager.isSessionUserAmazonAccount(s))
        {
            arraylist.add(new <init>(servicewrappingcontext, amazonaccountmanager));
        }
        return arraylist;
    }

    private List createChangedNotification(boolean flag)
    {
        if (flag)
        {
            return Arrays.asList(new <init>[] {
                new <init>("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED")
            });
        } else
        {
            return new ArrayList();
        }
    }

    public boolean isMappingCurrentlySetForAccount(String s)
    {
        return mAmznAcctMan.isSessionUserAmazonAccount(s);
    }

    public boolean isSupportedOnThisPlatform()
    {
        return com.amazon.identity.auth.device.api.isSupportedOnThisPlatform(mContext);
    }

    public List onDeregister(String s)
    {
        if (!mAmznAcctMan.isSessionUserAmazonAccount(s))
        {
            MAPLog.w(MultipleAccountsLogic.access$000(), "Account is not a session user, so cannot remove");
            return new ArrayList();
        }
        MultipleAccountsLogic.access$000();
        mSessionUserChanger.onSessionUserDeregistered(s);
        boolean flag;
        if (!mAmznAcctMan.isSessionUserAmazonAccount(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return createChangedNotification(flag);
    }

    public List removeAndNotify(String s)
    {
        if (!mAmznAcctMan.isSessionUserAmazonAccount(s))
        {
            MAPLog.w(MultipleAccountsLogic.access$000(), "Account is not a session user, so cannot remove");
            return new ArrayList();
        } else
        {
            MultipleAccountsLogic.access$000();
            return setAndNotify(mAmznAcctMan.getDevicePrimaryAmazonAccount());
        }
    }

    public List setAndNotify(String s)
    {
        if (mAmznAcctMan.isSessionUserAmazonAccount(s))
        {
            MAPLog.w(MultipleAccountsLogic.access$000(), "Account is already a session user");
            return new ArrayList();
        } else
        {
            mSessionUserChanger.changeSessionUsers(ArrayUtil.asSet(new String[] {
                s
            }));
            return createChangedNotification(mAmznAcctMan.isSessionUserAmazonAccount(s));
        }
    }

    public e(ServiceWrappingContext servicewrappingcontext, AmazonAccountManager amazonaccountmanager)
    {
        mContext = servicewrappingcontext;
        mAmznAcctMan = amazonaccountmanager;
        mSessionUserChanger = new SessionUserChanger(amazonaccountmanager);
    }
}
