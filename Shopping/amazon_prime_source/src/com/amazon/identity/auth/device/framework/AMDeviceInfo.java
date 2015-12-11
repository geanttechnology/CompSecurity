// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.api.MultipleAccountManager;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AmazonDeviceInfo

public class AMDeviceInfo extends AmazonDeviceInfo
{

    private static final String TAG = com/amazon/identity/auth/device/framework/AMDeviceInfo.getCanonicalName();
    private final MultipleAccountManager mMultipleAccountManager;

    public AMDeviceInfo(Context context, MultipleAccountManager multipleaccountmanager)
    {
        super(context);
        mMultipleAccountManager = multipleaccountmanager;
    }

    public String getDeviceSerialNumber()
    {
        String s = mMultipleAccountManager.getAccountForMapping(new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
            new com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType()
        });
        if (s == null)
        {
            MAPLog.e(TAG, "Cannot return DSN on this platform (Grover, Canary V1). We can only return it while the device is registered");
            throw new UnsupportedOperationException("Cannot return DSN on this platform (Grover, Canary V1). We can only return it while the device is registered");
        } else
        {
            return (new BackwardsCompatiableDataStorage(mContext)).getUserData(s, "com.amazon.dcp.sso.token.device.deviceserialname");
        }
    }

}
