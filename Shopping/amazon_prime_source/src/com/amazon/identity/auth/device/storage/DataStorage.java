// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            AccountTransaction

public abstract class DataStorage
{
    public static interface DataPropogationCallback
    {

        public abstract void onSuccess();
    }


    public DataStorage()
    {
    }

    public abstract boolean addAccount(String s, AccountTransaction accounttransaction, DataPropogationCallback datapropogationcallback);

    public boolean doesAccountExist(String s)
    {
        return getAccounts().contains(s);
    }

    public abstract void expireToken(String s, String s1);

    public abstract Account getAccountForDirectedId(String s);

    public abstract Set getAccountNames();

    public abstract Set getAccounts();

    public abstract String getDeviceData(String s, String s1);

    public abstract String getDeviceSnapshot();

    public abstract String getToken(String s, String s1);

    public abstract String getUserData(String s, String s1);

    public abstract void initialize();

    public abstract void removeAccount(String s);

    public abstract void setData(AccountTransaction accounttransaction);

    public abstract void setDeviceData(String s, String s1, String s2);

    public void setDeviceData(String s, Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); setDeviceData(s, (String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public abstract void setToken(String s, String s1, String s2);

    public final void setTokens(String s, Map map)
    {
        setData(new AccountTransaction(s, null, map));
    }

    public abstract void setUserData(String s, String s1, String s2);

    public abstract void setup();

    public abstract void syncDirtyData();
}
