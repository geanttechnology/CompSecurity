// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.content.ContextWrapper;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.accounts.CentralAccountManagerCommunication;
import com.amazon.identity.auth.accounts.RegisterAccountHelper;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.features.FeatureSetCache;
import com.amazon.identity.auth.device.features.FeatureSetProvider;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.storage.DataStorageFactoryImpl;
import com.amazon.identity.auth.device.storage.LocalDataStorage;
import com.amazon.identity.auth.device.storage.TokenCacheHolder;
import com.amazon.identity.auth.device.utils.AccountManagerWrapper;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SystemWrapper, DeviceInfoHolder, AuthenticatedUrlConnectionFactory, AlarmManagerWrapper, 
//            PlatformWrapper, AmazonWebServiceCallerCreator, WifiManagerWrapper, TelephonyManagerWrapper, 
//            WindowManagerWrapper

public class ServiceWrappingContext extends ContextWrapper
{

    private FeatureSet mFeatureSet;
    private final Map mSystemServiceLookup = Collections.synchronizedMap(new HashMap());

    private ServiceWrappingContext(Context context)
    {
        super(context);
    }

    public static ServiceWrappingContext create(Context context)
    {
        if (context instanceof ServiceWrappingContext)
        {
            return (ServiceWrappingContext)context;
        } else
        {
            return new ServiceWrappingContext(context);
        }
    }

    public DataStorage getDataStorage()
    {
        return ((DataStorageFactory)getSystemService("dcp_data_storage_factory")).getDataStorage();
    }

    public FeatureSet getFeatureSet()
    {
        this;
        JVM INSTR monitorenter ;
        FeatureSet featureset;
        if (mFeatureSet == null)
        {
            mFeatureSet = FeatureSetCache.getInstance(new FeatureSetProvider(this));
        }
        featureset = mFeatureSet;
        this;
        JVM INSTR monitorexit ;
        return featureset;
        Exception exception;
        exception;
        throw exception;
    }

    public File getFilesDir()
    {
        return super.getFilesDir();
    }

    public Object getSystemService(String s)
    {
        Object obj = getBaseContext().getSystemService(s);
        if (obj != null)
        {
            return obj;
        }
        Object obj1 = mSystemServiceLookup.get(s);
        obj = obj1;
        if (obj1 == null)
        {
            if ("dcp_system".equals(s))
            {
                obj = new SystemWrapper();
            } else
            if ("dcp_http_client".equals(s))
            {
                obj = new DefaultHttpClient();
            } else
            if ("dcp_device_info".equals(s))
            {
                obj = DeviceInfoHolder.getInstance(this);
            } else
            if ("dcp_account_manager".equals(s))
            {
                obj = AccountManagerWrapper.get(this);
            } else
            if ("dcp_single_threaded_executor".equals(s))
            {
                obj = Executors.newSingleThreadExecutor(ThreadUtils.getNamedThreadFactory("MAP-ServiceWrappingContextThread"));
            } else
            if ("dcp_amazon_account_man".equals(s))
            {
                obj = new AmazonAccountManager(this);
            } else
            if ("dcp_authenticated_url_connection_factory".equals(s))
            {
                obj = new AuthenticatedUrlConnectionFactory();
            } else
            if ("dcp_token_cache_holder".equals(s))
            {
                obj = TokenCacheHolder.getInstance(this);
            } else
            if ("dcp_data_storage_factory".equals(s))
            {
                obj = DataStorageFactoryImpl.getInstance(this);
            } else
            if ("sso_map_account_manager_communicator".equals(s))
            {
                obj = new CentralAccountManagerCommunication(this);
            } else
            if ("dcp_token_mangement".equals(s))
            {
                obj = new TokenManagement(this);
            } else
            if ("dcp_account_register_helper".equals(s))
            {
                obj = new RegisterAccountHelper(this);
            } else
            if ("sso_local_datastorage".equals(s))
            {
                obj = LocalDataStorage.getInstance(this);
            } else
            if ("sso_alarm_maanger".equals(s))
            {
                obj = new AlarmManagerWrapper(this);
            } else
            if ("sso_platform".equals(s))
            {
                obj = new PlatformWrapper(this);
            } else
            if ("sso_webservice_caller_creator".equals(s))
            {
                obj = new AmazonWebServiceCallerCreator(this);
            } else
            if ("dcp_wifi".equals(s))
            {
                obj = new WifiManagerWrapper(this);
            } else
            if ("sso_telephony_service".equals(s))
            {
                obj = new TelephonyManagerWrapper(this);
            } else
            if ("sso_window_manager".equals(s))
            {
                obj = new WindowManagerWrapper(this);
            } else
            {
                obj = null;
            }
            mSystemServiceLookup.put(s, obj);
        }
        return obj;
    }
}
