// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AmazonAccountManager
{
    public static final class AccountRegistrationStatus extends Enum
    {

        private static final AccountRegistrationStatus $VALUES[];
        public static final AccountRegistrationStatus Deregistering;
        public static final AccountRegistrationStatus NotFound;
        public static final AccountRegistrationStatus Registered;
        private final String mValue;

        public static AccountRegistrationStatus fromValue(String s)
        {
            AccountRegistrationStatus aaccountregistrationstatus[] = values();
            int j = aaccountregistrationstatus.length;
            for (int i = 0; i < j; i++)
            {
                AccountRegistrationStatus accountregistrationstatus = aaccountregistrationstatus[i];
                if (accountregistrationstatus.getValue().equals(s))
                {
                    return accountregistrationstatus;
                }
            }

            return null;
        }

        public static AccountRegistrationStatus valueOf(String s)
        {
            return (AccountRegistrationStatus)Enum.valueOf(com/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus, s);
        }

        public static AccountRegistrationStatus[] values()
        {
            return (AccountRegistrationStatus[])$VALUES.clone();
        }

        String getValue()
        {
            return mValue;
        }

        static 
        {
            Registered = new AccountRegistrationStatus("Registered", 0, "Registered");
            Deregistering = new AccountRegistrationStatus("Deregistering", 1, "Deregistering");
            NotFound = new AccountRegistrationStatus("NotFound", 2, "NotFound");
            $VALUES = (new AccountRegistrationStatus[] {
                Registered, Deregistering, NotFound
            });
        }

        private AccountRegistrationStatus(String s, int i, String s1)
        {
            super(s, i);
            mValue = s1;
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/AmazonAccountManager.getName();
    private final DataStorage mDataStorage;

    public AmazonAccountManager(Context context)
    {
        this(ServiceWrappingContext.create(context).getDataStorage());
    }

    public AmazonAccountManager(DataStorage datastorage)
    {
        mDataStorage = datastorage;
    }

    public boolean doesAccountExist(String s)
    {
        for (Iterator iterator = getAccounts().iterator(); iterator.hasNext();)
        {
            if (((String)iterator.next()).equals(s))
            {
                return true;
            }
        }

        return false;
    }

    public boolean doesAccountExistAfterDeregisteringStateCleanup(String s)
    {
        for (Iterator iterator = getAccounts().iterator(); iterator.hasNext();)
        {
            if (((String)iterator.next()).equals(s))
            {
                boolean flag;
                if (AccountRegistrationStatus.fromValue(getUserData(s, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS")) == AccountRegistrationStatus.Deregistering)
                {
                    MetricsHelper.increasePeriodicCounter("AccountRemovedBecauseDeregisteringState", new String[0]);
                    MAPLog.i(TAG, "Removing account from database since database is stuck in bad state. Account status is Deregistering and registerAccount API is called");
                    mDataStorage.removeAccount(s);
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public AccountRegistrationStatus getAccountRegistrationStatus(String s)
    {
        AccountRegistrationStatus accountregistrationstatus = AccountRegistrationStatus.fromValue(getUserData(s, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS"));
        if (accountregistrationstatus != null)
        {
            return accountregistrationstatus;
        }
        if (doesAccountExist(s))
        {
            return AccountRegistrationStatus.Registered;
        } else
        {
            return AccountRegistrationStatus.NotFound;
        }
    }

    public String getAccountValidator(String s)
    {
        return getUserData(s, "com.amazon.dcp.sso.property.account.UUID");
    }

    public Set getAccounts()
    {
        return mDataStorage.getAccounts();
    }

    public String getDevicePrimaryAmazonAccount()
    {
        Object obj = getNonDeregisteringAmazonAccounts();
        if (((Set) (obj)).size() <= 0)
        {
            return null;
        }
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s = (String)((Iterator) (obj)).next();
            if (!isSecondaryAmazonAccount(s))
            {
                return s;
            }
        }

        return null;
    }

    public Set getNonDeregisteringAmazonAccounts()
    {
        Object obj = getAccounts();
        HashSet hashset = new HashSet();
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            if (!isAccountDeregistering(s))
            {
                hashset.add(s);
            }
        } while (true);
        return hashset;
    }

    public Set getSecondaryAmazonAccounts()
    {
        Object obj = getAccounts();
        HashSet hashset = new HashSet();
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            if (isSecondaryAmazonAccount(s))
            {
                hashset.add(s);
            }
        } while (true);
        return hashset;
    }

    public Set getSessionUsers()
    {
        HashSet hashset = new HashSet();
        Iterator iterator = getAccounts().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (isSessionUserAmazonAccount(s))
            {
                hashset.add(s);
            }
        } while (true);
        return hashset;
    }

    public String getUserData(String s, String s1)
    {
        return mDataStorage.getUserData(s, s1);
    }

    public boolean hasDevicePrimaryAmazonAccount()
    {
        return getDevicePrimaryAmazonAccount() != null;
    }

    public boolean isAccountDeregistering(String s)
    {
        s = getAccountRegistrationStatus(s);
        return s == AccountRegistrationStatus.NotFound || s == AccountRegistrationStatus.Deregistering;
    }

    public boolean isDevicePrimaryAmazonAccount(String s)
    {
        return doesAccountExist(s) && !isSecondaryAmazonAccount(s);
    }

    public boolean isSecondaryAmazonAccount(String s)
    {
        return getUserData(s, "com.amazon.dcp.sso.property.secondary") != null;
    }

    public boolean isSessionUserAmazonAccount(String s)
    {
        return getUserData(s, "com.amazon.dcp.sso.property.sessionuser") != null;
    }

    public void removeAccountAsSessionUser(String s)
    {
        setUserData(s, "com.amazon.dcp.sso.property.sessionuser", null);
    }

    public void setAccountAsSessionUser(String s)
    {
        setUserData(s, "com.amazon.dcp.sso.property.sessionuser", "true");
    }

    public void setAccountRegistrationStatus(String s, AccountRegistrationStatus accountregistrationstatus)
    {
        setUserData(s, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS", accountregistrationstatus.getValue());
    }

    public void setUserData(String s, String s1, String s2)
    {
        mDataStorage.setUserData(s, s1, s2);
    }

}
