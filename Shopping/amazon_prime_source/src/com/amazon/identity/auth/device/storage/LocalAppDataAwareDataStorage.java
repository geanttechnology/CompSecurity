// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.accounts.AccountManagerDefinition;
import com.amazon.identity.auth.accounts.AccountManagerImplementationFactory;
import com.amazon.identity.auth.accounts.ChildApplicationHelpers;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, DataStorageFactory, StorageKeyUtils, AccountTransaction

public class LocalAppDataAwareDataStorage extends DataStorage
{

    private static final String TAG = com/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage.getName();
    private AccountManagerDefinition mAccountManagerImplementation;
    private final ServiceWrappingContext mContext;
    private final DataStorage mStorage;

    public LocalAppDataAwareDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
    }

    public LocalAppDataAwareDataStorage(Context context, DataStorage datastorage)
    {
        mContext = ServiceWrappingContext.create(context);
        mStorage = datastorage;
    }

    private String getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(String s, String s1, boolean flag)
    {
        if (flag && ThreadUtils.isRunningOnMainThread())
        {
            throw new IllegalStateException("Cannot get local data on the main thread");
        }
        KeyInfo keyinfo = KeyInfo.parseKey(s1);
        s1 = keyinfo.getPackageName();
        if (s1 == null)
        {
            return keyinfo.getKey();
        }
        Object obj = getAppInfo(s1);
        if (obj == null)
        {
            return keyinfo.getKey();
        }
        String s2;
        try
        {
            s2 = ((RemoteMapInfo) (obj)).getDeviceType();
            obj = ((RemoteMapInfo) (obj)).getOverrideDSN();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, (new StringBuilder("Couldn't determine override device type/DSN for ")).append(s1).toString(), s);
            return null;
        }
        if (isCentralDeviceType(s2))
        {
            return keyinfo.getKey();
        }
        if (!flag || isChildApplicationDeviceTypeRegistered(s, s2))
        {
            (new StringBuilder("device: ")).append(s2).append(" already registered, returning key");
            return StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s2, keyinfo.getKey());
        }
        if (registerChildApplicationDeviceType(s, s2, ((String) (obj))))
        {
            return StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s2, keyinfo.getKey());
        } else
        {
            MAPLog.e(TAG, String.format("Could not register application with the device type %s", new Object[] {
                s2
            }));
            return null;
        }
    }

    private Map mapKeysAndRegisterIfNeeded(String s, Map map)
    {
        HashMap hashmap = new HashMap();
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            String s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, (String)entry.getKey(), true);
            if (s1 == null)
            {
                MAPLog.w(TAG, (new StringBuilder("Not setting ")).append((String)entry.getKey()).append(" because the child device type could not be registered.").toString());
            } else
            {
                hashmap.put(s1, entry.getValue());
            }
        }

        return hashmap;
    }

    private boolean registerChildApplicationDeviceType(String s, String s1, String s2)
    {
        Tracer tracer;
        tracer = Tracer.getNewTracer("RegisterChildApplicationFromDBLayer");
        Bundle bundle = new Bundle();
        bundle.putString("override_dsn", s2);
        s = getAccountManagerImplementation().registerChildApplication$3b8086d2(s, s1, bundle, tracer);
        s = (Bundle)s.get();
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tracer.finishTrace();
        return flag;
        s;
        MAPLog.e(TAG, (new StringBuilder("Error registeringChildAccount. Bundle Error: ")).append(BundleUtils.toString(s.getErrorBundle())).toString(), s);
        tracer.finishTrace();
_L1:
        return false;
        s;
        MAPLog.e(TAG, "Interrupted exception while registeringChildAccount", s);
        tracer.finishTrace();
          goto _L1
        s;
        MAPLog.e(TAG, "Execution exception while registeringChildAccount", s);
        tracer.finishTrace();
          goto _L1
        s;
        tracer.finishTrace();
        throw s;
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        return mStorage.addAccount(s, accounttransaction, datapropogationcallback);
    }

    public void expireToken(String s, String s1)
    {
        s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, s1, true);
        if (s1 == null)
        {
            MAPLog.w(TAG, "expireToken failed because key does not make sense on the platform");
            return;
        } else
        {
            mStorage.expireToken(s, s1);
            return;
        }
    }

    public Account getAccountForDirectedId(String s)
    {
        return mStorage.getAccountForDirectedId(s);
    }

    AccountManagerDefinition getAccountManagerImplementation()
    {
        this;
        JVM INSTR monitorenter ;
        AccountManagerDefinition accountmanagerdefinition;
        if (mAccountManagerImplementation == null)
        {
            mAccountManagerImplementation = AccountManagerImplementationFactory.getAccountManagerImplementation(mContext);
        }
        accountmanagerdefinition = mAccountManagerImplementation;
        this;
        JVM INSTR monitorexit ;
        return accountmanagerdefinition;
        Exception exception;
        exception;
        throw exception;
    }

    public Set getAccountNames()
    {
        return mStorage.getAccountNames();
    }

    public Set getAccounts()
    {
        return mStorage.getAccounts();
    }

    RemoteMapInfo getAppInfo(String s)
    {
        return MAPApplicationInformationQueryer.getInstance(mContext).getAppInfo(s);
    }

    public String getDeviceData(String s, String s1)
    {
        return mStorage.getDeviceData(s, s1);
    }

    public String getDeviceSnapshot()
    {
        return mStorage.getDeviceSnapshot();
    }

    public String getToken(String s, String s1)
    {
        s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, s1, true);
        if (s1 == null)
        {
            MAPLog.w(TAG, "getToken failed because key does not make sense on the platform");
            return null;
        } else
        {
            return mStorage.getToken(s, s1);
        }
    }

    public String getUserData(String s, String s1)
    {
        s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, s1, true);
        if (s1 == null)
        {
            MAPLog.w(TAG, "getUserData failed because key does not make sense on the platform");
            return null;
        } else
        {
            return mStorage.getUserData(s, s1);
        }
    }

    public void initialize()
    {
        mStorage.initialize();
    }

    boolean isCentralDeviceType(String s)
    {
        return DeviceTypeHelpers.areAppsWithDeviceTypeUsingDeviceCredentials(mContext, s);
    }

    boolean isChildApplicationDeviceTypeRegistered(String s, String s1)
    {
        return ChildApplicationHelpers.isChildApplicationDeviceTypeRegistered(mContext, mStorage, s, s1);
    }

    public String peekToken(String s, String s1)
    {
        s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, s1, false);
        if (s1 == null)
        {
            MAPLog.w(TAG, "peekToken failed because key does not make sense on the platform");
            return null;
        } else
        {
            return mStorage.getToken(s, s1);
        }
    }

    public String peekUserData(String s, String s1)
    {
        s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, s1, false);
        if (s1 == null)
        {
            MAPLog.w(TAG, "peekUserData failed because key does not make sense on the platform");
            return null;
        } else
        {
            return mStorage.getUserData(s, s1);
        }
    }

    public void removeAccount(String s)
    {
        mStorage.removeAccount(s);
    }

    public void setData(AccountTransaction accounttransaction)
    {
        Object obj = accounttransaction.getDirectedId();
        Map map = mapKeysAndRegisterIfNeeded(((String) (obj)), accounttransaction.getUserData());
        obj = mapKeysAndRegisterIfNeeded(((String) (obj)), accounttransaction.getTokens());
        accounttransaction = new AccountTransaction(accounttransaction.getDirectedId(), map, ((Map) (obj)));
        mStorage.setData(accounttransaction);
    }

    public void setDeviceData(String s, String s1, String s2)
    {
        mStorage.setDeviceData(s, s1, s2);
    }

    public void setToken(String s, String s1, String s2)
    {
        s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, s1, true);
        if (s1 == null)
        {
            MAPLog.w(TAG, "setToken failed because key does not make sense on the platform");
            return;
        } else
        {
            mStorage.setToken(s, s1, s2);
            return;
        }
    }

    public void setUserData(String s, String s1, String s2)
    {
        s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, s1, true);
        if (s1 == null)
        {
            MAPLog.w(TAG, "setUserData failed because key does not make sense on the platform");
            return;
        } else
        {
            mStorage.setUserData(s, s1, s2);
            return;
        }
    }

    public void setup()
    {
        mStorage.setup();
    }

    public void syncDirtyData()
    {
        mStorage.syncDirtyData();
    }

}
