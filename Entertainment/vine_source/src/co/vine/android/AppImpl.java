// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import co.vine.android.client.AppController;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.service.ResourceService;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.UploadManager;
import co.vine.android.util.Util;
import java.io.File;
import org.json.JSONObject;

// Referenced classes of package co.vine.android:
//            AppInterface, AbstractRecordingActivity, CameraWidgetConfigureActivity, ConversationActivity, 
//            UploadsListActivity

public class AppImpl
    implements AppInterface
{

    private static AppImpl sInstance;

    private AppImpl()
    {
    }

    public static AppImpl getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new AppImpl();
        }
        return sInstance;
    }

    public void appendDebugInfo(Context context, StringBuilder stringbuilder, boolean flag)
    {
        co.vine.android.recorder.RecordConfigUtils.RecordConfig recordconfig = RecordConfigUtils.getGenericConfig(context);
        stringbuilder.append("\n\nDefault Recording Configuration: ");
        stringbuilder.append((new StringBuilder()).append("\nRecording enabled: ").append(recordconfig.recordingEnabled).toString());
        stringbuilder.append((new StringBuilder()).append("\nZoom enabled: ").append(recordconfig.zoomEnabled).toString());
        stringbuilder.append((new StringBuilder()).append("\nCamera Switch enabled: ").append(recordconfig.cameraSwitchEnabled).toString());
        stringbuilder.append((new StringBuilder()).append("\nFlash Switch enabled: ").append(recordconfig.flashSwitchEnabled).toString());
        stringbuilder.append((new StringBuilder()).append("\nBuffer Pre-allocation enabled: ").append(recordconfig.preAllocateBuffer).toString());
        stringbuilder.append((new StringBuilder()).append("\nBuffer count: ").append(recordconfig.bufferCount).toString());
        stringbuilder.append((new StringBuilder()).append("\nPreview width: ").append(recordconfig.previewWidth).toString());
        stringbuilder.append((new StringBuilder()).append("\nTarget Frame Rate: ").append(recordconfig.targetFrameRate).toString());
        if (!flag)
        {
            stringbuilder.append((new StringBuilder()).append("\nProcess path: ").append(recordconfig.processDir.getPath()).toString());
        }
        stringbuilder.append((new StringBuilder()).append("\nTarget Size: ").append(recordconfig.targetSize).toString());
        context = RecordConfigUtils.getGenericConfig(context);
        stringbuilder.append("\n\nDefault Message Recording Configuration: ");
        stringbuilder.append((new StringBuilder()).append("\nBuffer count: ").append(((co.vine.android.recorder.RecordConfigUtils.RecordConfig) (context)).bufferCount).toString());
        stringbuilder.append((new StringBuilder()).append("\nPreview width: ").append(((co.vine.android.recorder.RecordConfigUtils.RecordConfig) (context)).previewWidth).toString());
        stringbuilder.append((new StringBuilder()).append("\nPreview height: ").append(((co.vine.android.recorder.RecordConfigUtils.RecordConfig) (context)).previewHeight).toString());
        stringbuilder.append((new StringBuilder()).append("\nTarget Frame Rate: ").append(((co.vine.android.recorder.RecordConfigUtils.RecordConfig) (context)).targetFrameRate).toString());
        stringbuilder.append((new StringBuilder()).append("\nTarget Size: ").append(((co.vine.android.recorder.RecordConfigUtils.RecordConfig) (context)).targetSize).toString());
    }

    public void clearUploadCaptchas(Context context)
    {
        UploadManager.clearUploadCaptchas(context);
    }

    public boolean doAddWidget(Context context, AccountManager accountmanager, Account account)
    {
        return RecordConfigUtils.loadWasEverSuccessful(context) && VineAccountHelper.needsAddwidget(accountmanager, account);
    }

    public Intent getClearNotificationsIntent(Context context)
    {
        return VineUploadService.getClearNotificationsIntent(context);
    }

    public Intent getDiscardAllIntent(Context context)
    {
        return VineUploadService.getDiscardAllIntent(context);
    }

    public Intent getNotifyFailedIntent(Context context)
    {
        return VineUploadService.getNotifyFailedIntent(context);
    }

    public Intent getRecordingIntent(Activity activity, int i, String s)
    {
        return AbstractRecordingActivity.getIntentForGeneric(activity, i, s);
    }

    public void setupWidget(Activity activity)
    {
        CameraWidgetConfigureActivity.setupShortcut(activity);
    }

    public void startCameraService(Activity activity)
    {
        activity.startService(new Intent(activity, co/vine/android/service/ResourceService));
    }

    public void startCapture(Activity activity)
    {
        Util.startActionOnRecordingAvailable(activity, AbstractRecordingActivity.getIntentForGeneric(activity, 0x20000, (new StringBuilder()).append("Base options: ").append(activity.getClass().getName()).toString()), 0);
    }

    public void startConversationActivity(Activity activity, long l, String s, long l1, boolean flag)
    {
        activity.startActivity(ConversationActivity.getIntent(activity, l, s, l1, flag, false));
    }

    public void startUploadsListActivity(Activity activity)
    {
        UploadsListActivity.start(activity);
    }

    public void updateClientProfile(Context context, AppController appcontroller, boolean flag)
    {
        if (co.vine.android.recorder.RecordConfigUtils.RecordConfig.needsUpdate(context) && !flag)
        {
            appcontroller.updateClientProfile();
        }
    }

    public void updateRecordConfigs(Context context, JSONObject jsonobject)
    {
        co.vine.android.recorder.RecordConfigUtils.RecordConfig.update(context, jsonobject);
    }
}
