// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.context;

import android.content.Context;
import android.util.Log;
import com.amazon.identity.auth.device.api.DeviceDataKeys;
import com.amazon.identity.auth.device.api.DeviceDataStore;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mobile.mash.appcontext.AppContext;
import com.amazon.mobile.mash.appcontext.CapabilityManager;
import com.amazon.rio.j2me.client.persistence.DataStore;

public class MShopAppContext extends AppContext
{

    public MShopAppContext(CapabilityManager capabilitymanager)
    {
        super(capabilitymanager);
    }

    public String getAppName()
    {
        return AndroidPlatform.getInstance().getApplicationName();
    }

    public String getAppVersion()
    {
        return AndroidPlatform.getInstance().getApplicationVersion();
    }

    public String getDebugWeinreServerHost()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("weinreServerHost");
    }

    public int getDebugWeinreServerPort()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getInt("weinreServerPort");
    }

    public boolean getDebugWeinreServerSatus()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("weinreServerStatus", false);
    }

    public String getDeviceDmsDeviceType()
    {
        Object obj;
        obj = AndroidPlatform.getInstance().getApplicationContext();
        if (!SSOUtil.isSSOSupported(((Context) (obj))))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj = DeviceDataStore.getInstance(((Context) (obj))).getValue(DeviceDataKeys.getDeviceTypeKeyForPackage(((Context) (obj)).getPackageName()));
        return ((String) (obj));
        DeviceDataStoreException devicedatastoreexception;
        devicedatastoreexception;
        Log.e("AppContext", (new StringBuilder()).append("error while retrieving device data: ").append(devicedatastoreexception.getMessage()).toString());
        return null;
    }

    public String getDeviceDmsSerialNumber()
    {
        Object obj;
        obj = AndroidPlatform.getInstance().getApplicationContext();
        if (!SSOUtil.isSSOSupported(((Context) (obj))))
        {
            break MISSING_BLOCK_LABEL_55;
        }
        obj = DeviceDataStore.getInstance(((Context) (obj))).getValue("Device Serial Number");
        return ((String) (obj));
        DeviceDataStoreException devicedatastoreexception;
        devicedatastoreexception;
        Log.e("AppContext", (new StringBuilder()).append("error while retrieving device data: ").append(devicedatastoreexception.getMessage()).toString());
        return null;
    }

    public String getOSName()
    {
        return "Android";
    }
}
