// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.AESCipher;
import com.amazon.identity.auth.device.framework.DeviceInfoHolder;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.UUID;

public class CommonInfoGenerator
{

    private static final String TAG = com/amazon/identity/auth/device/CommonInfoGenerator.getName();
    private static CommonInfoGenerator sTheOneAndTheOnly;
    private final MAPApplicationInformationQueryer mAppInfoQueryer;
    private final ServiceWrappingContext mContext;
    private final DataStorage mDataStorage;

    CommonInfoGenerator(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
        mAppInfoQueryer = MAPApplicationInformationQueryer.getInstance(mContext);
    }

    public static int getCommonInfoVersion(DataStorage datastorage)
    {
        return StringConversionHelpers.toInt$505cff29(datastorage.getDeviceData("dcp.third.party.device.state", "info.version"));
    }

    public static String getDsn(DataStorage datastorage)
    {
        return datastorage.getDeviceData("dcp.third.party.device.state", "serial.number");
    }

    public static CommonInfoGenerator getInstance(Context context)
    {
        com/amazon/identity/auth/device/CommonInfoGenerator;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null)
        {
            sTheOneAndTheOnly = new CommonInfoGenerator(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/CommonInfoGenerator;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String getTokenKey(DataStorage datastorage)
    {
        return datastorage.getDeviceData("dcp.only.protected.store", "dcp.only.encrypt.key");
    }

    public int generateCommonInfo()
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        MAPLog.i(TAG, String.format("Generating common info for version %d", new Object[] {
            Integer.valueOf(1)
        }));
        if (getTokenKey(mDataStorage) == null)
        {
            String s = TAG;
            s = AESCipher.generateAesSecureStorageKeyForDevice(DeviceInfoHolder.getInstance(mContext));
            mDataStorage.setDeviceData("dcp.only.protected.store", "dcp.only.encrypt.key", s);
            s = TAG;
        }
        s1 = getDsn(mDataStorage);
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (PlatformUtils.isIsolatedApplication(mContext))
        {
            s1 = mAppInfoQueryer.getAppOverriddenDSN(mContext.getPackageName());
        }
        String s3 = s1;
        if (TextUtils.isEmpty(s1))
        {
            s3 = UUID.randomUUID().toString().replace("-", "");
        }
        mDataStorage.setDeviceData("dcp.third.party.device.state", "serial.number", s3);
        s1 = TAG;
        (new StringBuilder("MAP generated third party serial number is ")).append(s3).toString();
        mDataStorage.syncDirtyData();
        String s2 = Integer.toString(1);
        mDataStorage.setDeviceData("dcp.third.party.device.state", "info.version", s2);
        this;
        JVM INSTR monitorexit ;
        return 1;
        Exception exception;
        exception;
        throw exception;
    }

}
