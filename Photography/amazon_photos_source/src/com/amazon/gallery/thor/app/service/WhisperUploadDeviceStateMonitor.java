// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.utils.device.DeviceUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.messaging.AutoSavePowerSettingChangedEvent;
import com.amazon.gallery.framework.data.messaging.BatteryStateChangedEvent;
import com.amazon.gallery.framework.data.messaging.NetworkStateChangedEvent;
import com.amazon.gallery.framework.data.messaging.PowerConnectionStateChanged;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploader;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.syncframework.WhisperUploadSyncScheduler;
import com.google.common.base.Joiner;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            WhisperUploadManager

public class WhisperUploadDeviceStateMonitor
{

    private static final String TAG = com/amazon/gallery/thor/app/service/WhisperUploadDeviceStateMonitor.getName();
    private Context context;
    private final AtomicBoolean isInPowerSaverMode = new AtomicBoolean(false);
    private final AtomicBoolean isLowBatteryState = new AtomicBoolean(false);
    private final AtomicBoolean isNetworkConnected = new AtomicBoolean(true);
    private final AtomicBoolean isPowerConnected = new AtomicBoolean(false);
    private final WhisperUploadSyncScheduler syncScheduler;

    public WhisperUploadDeviceStateMonitor(Context context1, WhisperUploadSyncScheduler whisperuploadsyncscheduler)
    {
        context = context1;
        syncScheduler = whisperuploadsyncscheduler;
        isLowBatteryState.set(DeviceUtil.isLowBatteryState(context1));
        isPowerConnected.set(DeviceUtil.isPowerConnected(context1));
        isInPowerSaverMode.set(DeviceUtil.isInPowerSaverMode(context1));
        context1 = (NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY);
        isNetworkConnected.set(context1.isNetworkConnected());
    }

    private void stopUploads()
    {
        syncScheduler.stopScheduledSyncs(context);
    }

    public UploadError getUploadErrorFromDeviceState()
    {
        if (!isNetworkConnected())
        {
            return UploadError.NO_NETWORK;
        }
        if (!isPowerConnected())
        {
            if (isLowBatteryState())
            {
                return UploadError.LOW_BATTERY;
            }
            if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("auto_upload_only_when_charging_key", false))
            {
                return UploadError.WAITING_FOR_POWER;
            }
        }
        return UploadError.NO_ERROR;
    }

    public boolean isLowBatteryState()
    {
        return isLowBatteryState.get();
    }

    public boolean isNetworkConnected()
    {
        return isNetworkConnected.get();
    }

    public boolean isPowerConnected()
    {
        return isPowerConnected.get();
    }

    public void onAutoSavePowerSettingChangedEvent(AutoSavePowerSettingChangedEvent autosavepowersettingchangedevent)
    {
        GLogger.d(TAG, "AutoSave power settings changed.", new Object[0]);
        updateUploadInterval(autosavepowersettingchangedevent.shouldSyncNow(), Joiner.on(".").join(TAG, "AutoSavePowerSettingsChanged", new Object[0]));
    }

    protected void onBatteryLow()
    {
        if (isLowBatteryState.getAndSet(true))
        {
            GLogger.d(TAG, "Battery low state flag already set true", new Object[0]);
            return;
        } else
        {
            GLogger.i(TAG, "Device has low battery, disabling auto-save", new Object[0]);
            updateUploadInterval(false, Joiner.on(".").join(TAG, "BatteryLow", new Object[0]));
            return;
        }
    }

    protected void onBatteryOkay()
    {
        if (!isLowBatteryState.getAndSet(false))
        {
            GLogger.d(TAG, "Battery low state flag already set false", new Object[0]);
            return;
        } else
        {
            GLogger.i(TAG, "Device battery is in an okay state, enabling auto-save", new Object[0]);
            updateUploadInterval(true, Joiner.on(".").join(TAG, "BatteryOkay", new Object[0]));
            return;
        }
    }

    public void onBatteryStateChanged(BatteryStateChangedEvent batterystatechangedevent)
    {
        if (batterystatechangedevent.isLowBattery())
        {
            onBatteryLow();
            return;
        } else
        {
            onBatteryOkay();
            return;
        }
    }

    protected void onNetworkConnected(boolean flag)
    {
        if (isNetworkConnected.getAndSet(true))
        {
            GLogger.d(TAG, "Network connected flag already set true", new Object[0]);
            return;
        } else
        {
            GLogger.i(TAG, "Network connected, enabling upload", new Object[0]);
            updateUploadInterval(true, Joiner.on(".").join(TAG, "NetworkConnected", new Object[0]));
            return;
        }
    }

    protected void onNetworkDisconnected()
    {
        if (!isNetworkConnected.getAndSet(false))
        {
            GLogger.d(TAG, "Network connected flag already set false", new Object[0]);
            return;
        } else
        {
            GLogger.i(TAG, "Network disconnected, disabling upload", new Object[0]);
            updateUploadInterval(false, Joiner.on(".").join(TAG, "NetworkDisconnected", new Object[0]));
            return;
        }
    }

    public void onNetworkStateChanged(NetworkStateChangedEvent networkstatechangedevent)
    {
        if (networkstatechangedevent.isConnected())
        {
            onNetworkConnected(networkstatechangedevent.isWan());
            return;
        } else
        {
            onNetworkDisconnected();
            return;
        }
    }

    protected void onPowerConnected()
    {
        GLogger.i(TAG, "Power Connected", new Object[0]);
        isPowerConnected.set(true);
        updateUploadInterval(true, Joiner.on(".").join(TAG, "PowerConnected", new Object[0]));
    }

    public void onPowerConnectionStateChanged(PowerConnectionStateChanged powerconnectionstatechanged)
    {
        if (powerconnectionstatechanged.isConnected())
        {
            onPowerConnected();
            return;
        } else
        {
            onPowerDisconnected();
            return;
        }
    }

    protected void onPowerDisconnected()
    {
        GLogger.i(TAG, "Power Disconnected", new Object[0]);
        isPowerConnected.set(false);
        updateUploadInterval(false, Joiner.on(".").join(TAG, "PowerDisconnected", new Object[0]));
    }

    public void registerReceivers()
    {
        GlobalMessagingBus.register(this);
    }

    public void unregisterReceivers()
    {
        GlobalMessagingBus.unregister(this);
    }

    public void updateUploadInterval(boolean flag, String s)
    {
        long l = 60L;
        UploadError uploaderror = getUploadErrorFromDeviceState();
        if (uploaderror != UploadError.NO_ERROR)
        {
            ((MultiQueueUploader)ThorGalleryApplication.getBean(Keys.MULTI_QUEUE_UPLOADER)).updateErrorState(uploaderror, QueueType.AUTO_SAVE);
            stopUploads();
            return;
        }
        if (flag)
        {
            syncScheduler.syncNow(context, s);
        }
        if (((WhisperUploadManager)ThorGalleryApplication.getBean(Keys.WHISPER_UPLOAD_MANAGER)).isForegroundUpload())
        {
            if (isPowerConnected())
            {
                l = 5L;
            }
            syncScheduler.scheduleForegroundSync(context, l, WhisperUploadManager.POLL_INTERVAL_UNIT, false);
            return;
        } else
        {
            syncScheduler.scheduleBackgroundSync(context, 60L, WhisperUploadManager.POLL_INTERVAL_UNIT);
            return;
        }
    }

}
