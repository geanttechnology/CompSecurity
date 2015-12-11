// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.kiang;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.control.device.DeviceRegisterController;
import com.amazon.mShop.control.device.DeviceUpdateController;
import com.amazon.mShop.control.device.KiangSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.DeviceUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.concurrent.atomic.AtomicInteger;

public class KiangController
    implements KiangSubscriber
{

    private static final String TAG = com/amazon/mShop/kiang/KiangController.getSimpleName();
    private static KiangController mKiangController = new KiangController();
    private AtomicInteger mIsRegisterInProgress;

    private KiangController()
    {
        mIsRegisterInProgress = new AtomicInteger(0);
    }

    public static KiangController getInstance()
    {
        return mKiangController;
    }

    public void kiangRegister(Context context)
    {
        while (!Util.isEmpty(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("applicationInstallId")) || mIsRegisterInProgress.getAndSet(1) != 0) 
        {
            return;
        }
        try
        {
            context = new DeviceRegisterController(DeviceUtils.getKiangAppInfomation(context), null, DeviceUtils.getKiangPushInformation(), this);
            Log.i(TAG, "kiang register");
            context.kiangRegister();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            onError(null, null);
        }
    }

    public void kiangUpdate(Context context)
    {
        if (Util.isEmpty(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("applicationInstallId")))
        {
            kiangRegister(context);
            return;
        } else
        {
            context = new DeviceUpdateController(DeviceUtils.getKiangSecurity(), DeviceUtils.getKiangApplicationState(context), this);
            Log.i(TAG, "kiang update");
            context.kiangUpdate();
            return;
        }
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        Log.e(TAG, "Kiang Error", exception);
    }

    public void onRegisterCompleted()
    {
        mIsRegisterInProgress.set(0);
        kiangUpdate((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
    }

    public void onRegisterError()
    {
        mIsRegisterInProgress.set(0);
    }

    public void onResetRegister()
    {
        kiangRegister((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
    }

}
