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
import org.json.JSONObject;

public interface AppInterface
{

    public abstract void appendDebugInfo(Context context, StringBuilder stringbuilder, boolean flag);

    public abstract void clearUploadCaptchas(Context context);

    public abstract boolean doAddWidget(Context context, AccountManager accountmanager, Account account);

    public abstract Intent getClearNotificationsIntent(Context context);

    public abstract Intent getDiscardAllIntent(Context context);

    public abstract Intent getNotifyFailedIntent(Context context);

    public abstract Intent getRecordingIntent(Activity activity, int i, String s);

    public abstract void setupWidget(Activity activity);

    public abstract void startCameraService(Activity activity);

    public abstract void startCapture(Activity activity);

    public abstract void startConversationActivity(Activity activity, long l, String s, long l1, boolean flag);

    public abstract void startUploadsListActivity(Activity activity);

    public abstract void updateClientProfile(Context context, AppController appcontroller, boolean flag);

    public abstract void updateRecordConfigs(Context context, JSONObject jsonobject);
}
