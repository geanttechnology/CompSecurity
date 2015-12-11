// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorageFactory, NonCanonicalDataStorage, CentralLocalDataStorage, CentralAccountManagerDataStorage, 
//            DistributedDataStorage, DataStorage

public final class DataStorageFactoryImpl
    implements DataStorageFactory
{

    private static final String TAG = com/amazon/identity/auth/device/storage/DataStorageFactoryImpl.getName();
    private static DataStorageFactoryImpl sInstance = null;
    private final ServiceWrappingContext mContext;
    private final AtomicReference mDataStorage = new AtomicReference(null);
    private final FeatureSet mFeatureSet;
    private final PlatformWrapper mPlatform;

    private DataStorageFactoryImpl(Context context)
    {
        MAPLog.i(TAG, "Creating new DataStorageFactoryImpl");
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mFeatureSet = mContext.getFeatureSet();
    }

    public static DataStorageFactoryImpl getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/DataStorageFactoryImpl;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new DataStorageFactoryImpl(context);
        }
        context = sInstance;
        com/amazon/identity/auth/device/storage/DataStorageFactoryImpl;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public DataStorage getDataStorage()
    {
        if (mDataStorage.get() == null)
        {
            MAPLog.i(TAG, "Initializing new DataStorage");
            Object obj;
            if (NonCanonicalDataStorage.shouldUseNonCanonicalDataStorage(mContext))
            {
                MAPLog.i(TAG, "Creating and using new NonCanonicalDataStorage");
                obj = new NonCanonicalDataStorage(mContext);
            } else
            if (CentralLocalDataStorage.shouldPlatformUseThisStore(mPlatform, mFeatureSet))
            {
                MAPLog.i(TAG, "Creating and using new CentralLocalDataStorage");
                obj = CentralLocalDataStorage.getInstance(mContext);
            } else
            if (CentralAccountManagerDataStorage.shouldPlatformUseThisStore(mPlatform))
            {
                MAPLog.i(TAG, "Creating and using new CentralAccountManagerDataStorage");
                obj = CentralAccountManagerDataStorage.getInstance(mContext);
            } else
            {
                MAPLog.i(TAG, "Creating and using new DistributedDataStorage");
                obj = DistributedDataStorage.getInstance(mContext);
            }
            mDataStorage.compareAndSet(null, obj);
            return ((DataStorage) (obj));
        } else
        {
            return (DataStorage)mDataStorage.get();
        }
    }

}
