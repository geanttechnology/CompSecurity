// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Context;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.storage.MAPInformationProviderHelpers;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.DBHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.identity.auth.device:
//            CommonInfoGenerator

public class CommonInfoGetter
{

    private static final String TAG = com/amazon/identity/auth/device/CommonInfoGetter.getName();
    private static final long WAIT_FOR_COMMON_INFO_TO_BE_GENERATED;
    private static CommonInfoGetter sTheOneAndTheOnly;
    private final Context mContext;
    private final DataStorage mDataStorage;
    private final AtomicBoolean mInitialized = new AtomicBoolean(false);
    private final CountDownLatch mLatch = new CountDownLatch(1);
    private final SecureContentResolver mSecureContentResolver;

    CommonInfoGetter(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
        mSecureContentResolver = new SecureContentResolver(mContext);
    }

    public static CommonInfoGetter getInstance(Context context)
    {
        com/amazon/identity/auth/device/CommonInfoGetter;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null)
        {
            sTheOneAndTheOnly = new CommonInfoGetter(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/CommonInfoGetter;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static boolean needToGenerateCommonInfoOnThisPlatform(Context context)
    {
        if (CentralApkUtils.hasCentralAPK(context) && !CentralApkUtils.isRunningInCentralAPK(context))
        {
            context = TAG;
            return false;
        } else
        {
            return true;
        }
    }

    private void waitForInitToFinish()
    {
        try
        {
            if (!mLatch.await(WAIT_FOR_COMMON_INFO_TO_BE_GENERATED, TimeUnit.MILLISECONDS))
            {
                MAPLog.e(TAG, "We timed out waiting for common info to be generated");
            }
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            MAPLog.e(TAG, "We were interrupted waiting for common info to be generated", interruptedexception);
        }
    }

    public String getDsn()
    {
        waitForInitToFinish();
        String s = CommonInfoGenerator.getDsn(mDataStorage);
        if (s == null)
        {
            MAPLog.e(TAG, "Cannot generate the dsn", new Throwable());
        }
        return s;
    }

    public String getTokenKey()
    {
        waitForInitToFinish();
        String s = CommonInfoGenerator.getTokenKey(mDataStorage);
        if (s == null)
        {
            MAPLog.e(TAG, "Cannot generate the token key", new Throwable());
        }
        return s;
    }

    public void init()
    {
        if (mInitialized.getAndSet(true))
        {
            MAPLog.i(TAG, "Common Data has already been initialized");
            return;
        }
        if (!needToGenerateCommonInfoOnThisPlatform(mContext))
        {
            String s = TAG;
            return;
        } else
        {
            ThreadUtils.submitToBackgroundThread(new Runnable() {

                final CommonInfoGetter this$0;

                public void run()
                {
                    Object obj = null;
                    mLatch.countDown();
                    return;
                    Exception exception;
                    exception;
                    mLatch.countDown();
                    throw exception;
                }

            
            {
                this$0 = CommonInfoGetter.this;
                super();
            }
            });
            return;
        }
    }

    static 
    {
        WAIT_FOR_COMMON_INFO_TO_BE_GENERATED = TimeUnit.MILLISECONDS.convert(15L, TimeUnit.SECONDS);
    }


/*
    static void access$000(CommonInfoGetter commoninfogetter)
    {
        Object obj = null;
        if (CentralApkUtils.hasCentralAPK(commoninfogetter.mContext))
        {
            int i = CommonInfoGenerator.getInstance(commoninfogetter.mContext).generateCommonInfo();
            MAPLog.i(TAG, String.format("Central model has no race conditions in terms of common info and hence can be generated locally. Generated version %d", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            int j = CommonInfoGenerator.getCommonInfoVersion(commoninfogetter.mDataStorage);
            if (j > 0)
            {
                commoninfogetter = TAG;
                String.format("No need to generate more common info. Our needed version is %d and currently we have version %d", new Object[] {
                    Integer.valueOf(1), Integer.valueOf(j)
                });
                return;
            }
            RemoteMapInfo remotemapinfo = MAPApplicationInformationQueryer.getInstance(commoninfogetter.mContext).getLatestMapApp();
            if (remotemapinfo == null)
            {
                MAPLog.e(TAG, "Cannot find other package to generate common info from.");
                commoninfogetter = obj;
            } else
            {
                MAPLog.i(TAG, "Calling Package %s to generate common info", new Object[] {
                    remotemapinfo.getPackageName()
                });
                android.net.Uri uri = MAPInformationProviderHelpers.generateCommonInfoUri(remotemapinfo.getProviderAuthority());
                commoninfogetter = StringConversionHelpers.toInteger(DBHelpers.querySingleResult(commoninfogetter.mSecureContentResolver, uri, "value", null, null, null));
            }
            if (commoninfogetter == null || commoninfogetter.intValue() <= 0)
            {
                String s = TAG;
                if (commoninfogetter != null)
                {
                    commoninfogetter = Integer.toString(commoninfogetter.intValue());
                } else
                {
                    commoninfogetter = "<Not Found>";
                }
                MAPLog.e(s, String.format("The main MAP app cannot generate version high enough to function properly. We need version %d or higher, but got %s.", new Object[] {
                    Integer.valueOf(1), commoninfogetter
                }));
                return;
            }
        }
        return;
    }

*/

}
