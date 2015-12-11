// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.accounts.CentralAccountManagerCommunication;
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
    private final CentralAccountManagerCommunication mAccountManagerCommunicator;
    private final Context mContext;
    private final DataStorage mStorage;

    public LocalAppDataAwareDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
        mAccountManagerCommunicator = (CentralAccountManagerCommunication)mContext.getSystemService("sso_map_account_manager_communicator");
    }

    public LocalAppDataAwareDataStorage(Context context, DataStorage datastorage)
    {
        mContext = ServiceWrappingContext.create(context);
        mStorage = datastorage;
        mAccountManagerCommunicator = (CentralAccountManagerCommunication)mContext.getSystemService("sso_map_account_manager_communicator");
    }

    private String getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(String s, String s1, boolean flag)
    {
        if (flag && ThreadUtils.isRunningOnMainThread())
        {
            throw new IllegalStateException("Cannot get local data on the main thread");
        }
        s1 = KeyInfo.parseKey(s1);
        if (s1 == null)
        {
            return null;
        }
        String s2 = s1.getPackageName();
        if (s2 == null)
        {
            return s1.getKey();
        }
        Object obj = MAPApplicationInformationQueryer.getInstance(mContext).getAppInfo(s2);
        if (obj == null)
        {
            MAPLog.w(TAG, String.format("Key Package is invalid because there is no package %s.", new Object[] {
                s2
            }));
            return null;
        }
        String s3;
        try
        {
            s3 = ((RemoteMapInfo) (obj)).getDeviceType();
            obj = ((RemoteMapInfo) (obj)).getOverrideDSN();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, (new StringBuilder("Couldn't determine override device type/DSN for ")).append(s2).toString(), s);
            return null;
        }
        if (DeviceTypeHelpers.areAppsWithDeviceTypeUsingDeviceCredentials(mContext, s3))
        {
            return s1.getKey();
        }
        if (!flag || ChildApplicationHelpers.isChildApplicationDeviceTypeRegistered(mContext, s, s3))
        {
            s = TAG;
            (new StringBuilder("device: ")).append(s3).append(" already registered, returning key").toString();
            return StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s3, s1.getKey());
        }
        if (registerChildApplicationDeviceType(s, s3, ((String) (obj))))
        {
            return StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s3, s1.getKey());
        } else
        {
            MAPLog.e(TAG, String.format("Could not register application with the device type %s", new Object[] {
                s3
            }));
            return null;
        }
    }

    private boolean registerChildApplicationDeviceType(String s, String s1, String s2)
    {
        Tracer tracer;
        tracer = Tracer.getNewTracer("RegisterChildApplicationFromDBLayer");
        Bundle bundle = new Bundle();
        bundle.putString("override_dsn", s2);
        s = mAccountManagerCommunicator.registerChildApplication(s, s1, bundle, null, tracer);
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

    public Set getAccountNames()
    {
        return mStorage.getAccountNames();
    }

    public Set getAccounts()
    {
        return mStorage.getAccounts();
    }

    public String getDeviceData(String s, String s1)
    {
        return mStorage.getDeviceData(s, s1);
    }

    public String getDirectedId(String s)
    {
        return mStorage.getDirectedId(s);
    }

    public String getDisplayName(String s)
    {
        return mStorage.getDisplayName(s);
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

    public void setTokens(String s, Map map)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        String s1;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put(s1, entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            s1 = getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(s, (String)entry.getKey(), true);
            if (s1 == null)
            {
                MAPLog.w(TAG, "setToken failed because key does not make sense on the platform");
                return;
            }
        }

        mStorage.setTokens(s, hashmap);
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
