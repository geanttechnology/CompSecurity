// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.content.ContextWrapper;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.accounts.CentralAccountManagerCommunication;
import com.amazon.identity.auth.accounts.RegisterAccountHelper;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreFactory;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.features.FeatureSetCache;
import com.amazon.identity.auth.device.features.FeatureSetProvider;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.storage.DataStorageFactoryImpl;
import com.amazon.identity.auth.device.storage.LocalDataStorage;
import com.amazon.identity.auth.device.storage.LocalDataStorageV2;
import com.amazon.identity.auth.device.storage.TokenCacheHolder;
import com.amazon.identity.auth.device.utils.AccountManagerWrapper;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SystemWrapper, DeviceInfoHolder, AuthenticatedUrlConnectionFactory, AlarmManagerWrapper, 
//            PlatformWrapper, AmazonWebServiceCallerCreator

public final class ServiceWrappingContext extends ContextWrapper
{

    public static final String ACCOUNT_MANAGER = "dcp_account_manager";
    public static final String ACCOUNT_MANAGER_COMMUNICATOR = "sso_map_account_manager_communicator";
    public static final String ALARM_MANAGER = "sso_alarm_maanger";
    public static final String AMAZON_ACCOUNT_MANAGER = "dcp_amazon_account_man";
    public static final String AMAZON_WEBSERVICE_CALLER_CREATOR = "sso_webservice_caller_creator";
    public static final String AUTHENTICATED_URL_CONNECTION_FACTORY = "dcp_authenticated_url_connection_factory";
    public static final String CUSTOMER_ATTRIBUTE_STORE_FACTORY = "sso_customer_attribute_store_factory";
    public static final String DATA_STORAGE_FACTORY = "dcp_data_storage_factory";
    public static final String DEVICE_INFO = "dcp_device_info";
    public static final String HTTP_CLIENT = "dcp_http_client";
    public static final String LOCAL_DATA_STORAGE = "sso_local_datastorage";
    public static final String LOCAL_DATA_STORAGE_V2 = "sso_local_datastorage_v2";
    public static final String PLATFORM = "sso_platform";
    public static final String REGISTER_ACCOUNT_HELPER = "dcp_account_register_helper";
    public static final String SINGLE_THREADED_EXECUTOR = "dcp_single_threaded_executor";
    public static final String SYNCHRONIZATION_FACTORY = "dcp_synchronization_factory";
    public static final String SYSTEM = "dcp_system";
    public static final String TOKEN_CACHE_HOLDER = "dcp_token_cache_holder";
    public static final String TOKEN_MANGEMENT = "dcp_token_mangement";
    public static final String WIFI_SERVICE = "dcp_wifi";
    private FeatureSet mFeatureSet;
    private final Map mSystemServiceLookup = new HashMap();

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
            mFeatureSet = new FeatureSetCache(new FeatureSetProvider(this));
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
            if ("sso_local_datastorage_v2".equals(s))
            {
                obj = LocalDataStorageV2.getInstance(this);
            } else
            if ("sso_alarm_maanger".equals(s))
            {
                obj = new AlarmManagerWrapper(this);
            } else
            if ("sso_customer_attribute_store_factory".equals(s))
            {
                obj = new CustomerAttributeStoreFactory(this);
            } else
            if ("sso_platform".equals(s))
            {
                obj = new PlatformWrapper(this);
            } else
            if ("sso_webservice_caller_creator".equals(s))
            {
                obj = new AmazonWebServiceCallerCreator(this);
            } else
            {
                obj = null;
            }
            mSystemServiceLookup.put(s, obj);
        }
        return obj;
    }
}
