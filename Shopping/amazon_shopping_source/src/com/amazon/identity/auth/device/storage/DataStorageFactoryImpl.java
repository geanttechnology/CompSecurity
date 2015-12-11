// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.features.FeatureSetCache;
import com.amazon.identity.auth.device.features.FeatureSetProvider;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorageFactory, NonCanonicalDataStorage, CentralLocalDataStorage, CentralAccountManagerDataStorage, 
//            DistributedDataStorage, DataStorage

public final class DataStorageFactoryImpl
    implements DataStorageFactory
{

    private static DataStorageFactoryImpl sInstance = null;
    private final Context mContext;
    private final AtomicReference mDataStorage = new AtomicReference(null);
    private final FeatureSet mFeatureSet;
    private final PlatformWrapper mPlatform;

    private DataStorageFactoryImpl(Context context)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mFeatureSet = new FeatureSetCache(new FeatureSetProvider(mContext));
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
            Object obj;
            if (NonCanonicalDataStorage.shouldUseNonCanonicalDataStorage(mContext))
            {
                obj = new NonCanonicalDataStorage(mContext);
            } else
            if (CentralLocalDataStorage.shouldPlatformUseThisStore(mPlatform, mFeatureSet))
            {
                obj = CentralLocalDataStorage.getInstance(mContext);
            } else
            if (CentralAccountManagerDataStorage.shouldPlatformUseThisStore(mPlatform))
            {
                obj = CentralAccountManagerDataStorage.getInstance(mContext);
            } else
            {
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
