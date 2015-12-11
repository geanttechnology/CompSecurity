// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;

public class MAPDebugManager
{

    private static final String TAG = com/amazon/identity/auth/device/api/MAPDebugManager.getName();
    private final ServiceWrappingContext mContext;

    public MAPDebugManager(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
    }

    public String getDeviceSnapshot()
    {
        MAPLog.i(TAG, "GetDeviceSnapshot API called");
        return mContext.getDataStorage().getDeviceSnapshot();
    }

}
