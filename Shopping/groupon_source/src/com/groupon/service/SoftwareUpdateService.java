// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.activity.IntentFactory;
import com.groupon.models.status.ClientVersion;
import com.groupon.models.status.Status;
import com.groupon.service.core.StatusService;
import com.groupon.util.NotificationBuilderUtil;
import java.util.Date;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class SoftwareUpdateService
{

    private Context context;
    private Lazy deviceSettings;
    private Lazy intentFactory;
    private Lazy notificationManager;
    private Lazy packageInfo;
    private Lazy prefs;
    private Status status;
    private StatusService statusService;

    public SoftwareUpdateService()
    {
    }

    private void checkVersion(Status status1)
    {
        int i;
        int l;
label0:
        {
            i = ((PackageInfo)packageInfo.get()).versionCode;
            status1 = status1.clientVersion;
            if (status1 != null)
            {
                int j = getIntValue(((ClientVersion) (status1)).upgradeThrottle, 100);
                String s = ((ConsumerDeviceSettings)deviceSettings.get()).getDeviceID().substring(((ConsumerDeviceSettings)deviceSettings.get()).getDeviceID().length() - 2);
                l = getIntValue(s, 16, 0) % 100;
                Ln.d("UPDATE: check throttle = %d, deviceId = %s, deviceLastTwo = %s, deviceBucket = %d", new Object[] {
                    Integer.valueOf(j), ((ConsumerDeviceSettings)deviceSettings.get()).getDeviceID(), s, Integer.valueOf(l)
                });
                if (j > l)
                {
                    int k = getIntValue(((ClientVersion) (status1)).forceUpdateAt, 0);
                    l = getIntValue(((ClientVersion) (status1)).suggestUpdateAt, 0);
                    Ln.d("UPDATE: passed throttle, check version = %d against forceUpdateAt = %d, suggestUpdateAt = %d", new Object[] {
                        Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(l)
                    });
                    if (k <= i)
                    {
                        break label0;
                    }
                    Ln.d("UPDATE: force!", new Object[0]);
                    clearSuggestedUpdateNotification();
                    displayForcedUpdateDialog();
                }
            }
            return;
        }
        if (l > i)
        {
            Ln.d("UPDATE: suggest!", new Object[0]);
            showSuggestedUpdateNotification();
            return;
        } else
        {
            clearSuggestedUpdateNotification();
            return;
        }
    }

    private void clearSuggestedUpdateNotification()
    {
        ((NotificationManager)notificationManager.get()).cancel(com.groupon.Constants.Notification.SUGGESTED_UPGRADE_AVAILABLE);
    }

    private void displayUpgradeDialog(int i, final android.content.DialogInterface.OnCancelListener cancelListener)
    {
        Ln.d("UPDATE Notice: shown", new Object[0]);
        (new com.groupon.util.GrouponAlertDialog.Builder(context)).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final SoftwareUpdateService this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                context.startActivity(((IntentFactory)intentFactory.get()).newMarketDownloadIntent().addFlags(0x10004000));
            }

            
            {
                this$0 = SoftwareUpdateService.this;
                super();
            }
        }).setNegativeButton(0x7f080248, new android.content.DialogInterface.OnClickListener() {

            final SoftwareUpdateService this$0;
            final android.content.DialogInterface.OnCancelListener val$cancelListener;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
                if (cancelListener != null)
                {
                    cancelListener.onCancel(dialoginterface);
                }
            }

            
            {
                this$0 = SoftwareUpdateService.this;
                cancelListener = oncancellistener;
                super();
            }
        }).setTitle(0x7f080419).setMessage(i).setOnCancelListener(cancelListener).show();
    }

    private int getIntValue(String s, int i)
    {
        return getIntValue(s, 10, i);
    }

    private int getIntValue(String s, int i, int j)
    {
        Ln.d("UPDATE: check %s, default = %d", new Object[] {
            s, Integer.valueOf(j)
        });
        if (!Strings.notEmpty(s))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        i = Integer.parseInt(s, i);
        Ln.d("UPDATE: parsed %d", new Object[] {
            Integer.valueOf(i)
        });
        return i;
        NumberFormatException numberformatexception;
        numberformatexception;
        Ln.d("UPDATE: NumberFormatException %s", new Object[] {
            s
        });
        return j;
    }

    private void init()
    {
        status = statusService.getStatus();
        packageInfo = new Lazy(context) {

            final SoftwareUpdateService this$0;

            
            {
                this$0 = SoftwareUpdateService.this;
                super(context1);
            }
        };
        prefs = new Lazy(context) {

            final SoftwareUpdateService this$0;

            
            {
                this$0 = SoftwareUpdateService.this;
                super(context1);
            }
        };
        intentFactory = new Lazy(context) {

            final SoftwareUpdateService this$0;

            
            {
                this$0 = SoftwareUpdateService.this;
                super(context1);
            }
        };
        notificationManager = new Lazy(context) {

            final SoftwareUpdateService this$0;

            
            {
                this$0 = SoftwareUpdateService.this;
                super(context1);
            }
        };
        deviceSettings = new Lazy(context) {

            final SoftwareUpdateService this$0;

            
            {
                this$0 = SoftwareUpdateService.this;
                super(context1);
            }
        };
        prefs = new Lazy(context) {

            final SoftwareUpdateService this$0;

            
            {
                this$0 = SoftwareUpdateService.this;
                super(context1);
            }
        };
    }

    private void showSuggestedUpdateNotification()
    {
        long l = (new Date()).getTime();
        if (l - ((SharedPreferences)prefs.get()).getLong("lastSuggestedUpgradeAlertTime", 0L) < 0x240c8400L)
        {
            return;
        }
        ((SharedPreferences)prefs.get()).edit().putLong("lastSuggestedUpgradeAlertTime", l).apply();
        Object obj = (new android.support.v4.app.NotificationCompat.Builder(context)).setContentTitle(context.getString(0x7f0803fa)).setWhen(System.currentTimeMillis());
        NotificationBuilderUtil.setupNotificationIcon(context, ((android.support.v4.app.NotificationCompat.Builder) (obj)));
        obj = ((android.support.v4.app.NotificationCompat.Builder) (obj)).build();
        obj.flags = 24;
        ((Notification) (obj)).setLatestEventInfo(context, context.getString(0x7f0803fb), context.getString(0x7f0803f9), PendingIntent.getActivity(context, 0, ((IntentFactory)intentFactory.get()).newMarketDownloadIntent(), 0));
        if (!((SharedPreferences)prefs.get()).getBoolean("silentNotifications", false))
        {
            obj.defaults = ((Notification) (obj)).defaults | 6;
            obj.sound = Uri.parse("android.resource://com.groupon/2131165187");
        }
        ((NotificationManager)notificationManager.get()).notify(com.groupon.Constants.Notification.SUGGESTED_UPGRADE_AVAILABLE, ((Notification) (obj)));
    }

    public void checkForSoftwareUpdate()
    {
        checkVersion(status);
    }

    public void displayForcedUpdateDialog()
    {
        Ln.d("UPDATE: displayForcedUpdateDialog", new Object[0]);
        displayUpgradeDialog(0x7f0803f8, new android.content.DialogInterface.OnCancelListener() {

            final SoftwareUpdateService this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                context.startActivity(((IntentFactory)intentFactory.get()).newApplicationExitIntent().addFlags(32768));
            }

            
            {
                this$0 = SoftwareUpdateService.this;
                super();
            }
        });
    }


}
