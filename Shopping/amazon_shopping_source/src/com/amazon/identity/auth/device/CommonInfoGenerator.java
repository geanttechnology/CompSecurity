// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Context;
import com.amazon.identity.auth.device.framework.AESCipher;
import com.amazon.identity.auth.device.framework.DeviceInfoHolder;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import java.util.UUID;

public class CommonInfoGenerator
{

    public static final int CURRENT_INFO_VERSIONS = 1;
    public static final int INITIAL_INFO_VERSIONS = 1;
    public static final String SSO_ONLY_ENCRYPTION_KEY = "dcp.only.encrypt.key";
    public static final String SSO_ONLY_PROTECTED_STORE_NAME = "dcp.only.protected.store";
    private static final String TAG = com/amazon/identity/auth/device/CommonInfoGenerator.getName();
    private static CommonInfoGenerator sTheOneAndTheOnly;
    private final Context mContext;
    private final DataStorage mDataStorage;

    CommonInfoGenerator(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
    }

    public static int getCommonInfoVersion(DataStorage datastorage)
    {
        return StringConversionHelpers.toInt(datastorage.getDeviceData("dcp.third.party.device.state", "info.version"), 0);
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
        if (getDsn(mDataStorage) == null)
        {
            String s1 = UUID.randomUUID().toString().replace("-", "");
            mDataStorage.setDeviceData("dcp.third.party.device.state", "serial.number", s1);
            String s3 = TAG;
            (new StringBuilder("DCP generated third party serial number is ")).append(s1).toString();
        }
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
