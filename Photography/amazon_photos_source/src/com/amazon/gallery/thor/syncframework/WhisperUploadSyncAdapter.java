// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SyncResult;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;
import com.amazon.gallery.framework.network.watchdog.WhisperUploadService;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.WhisperUploadDeviceStateMonitor;
import com.amazon.gallery.thor.app.service.WhisperUploadManager;
import com.amazon.gallery.thor.di.AppKeys;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            WhisperUploadSyncSchedulerWrapper, WhisperUploadSyncScheduler

public class WhisperUploadSyncAdapter extends AbstractThreadedSyncAdapter
{

    private static final String TAG = com/amazon/gallery/thor/syncframework/WhisperUploadSyncAdapter.getName();
    private boolean cloudSyncEnabled;

    public WhisperUploadSyncAdapter(Context context, BeanFactory beanfactory, boolean flag)
    {
        super(context, flag);
        cloudSyncEnabled = ((FeatureChecker)beanfactory.getBean(AppKeys.FEATURE_CHECKER)).hasCloudSync();
    }

    private void disableSyncForProfile()
    {
        SharedPreferences sharedpreferences = getContext().getSharedPreferences("galleryKindleSharedPrefs", 0);
        if (!sharedpreferences.getBoolean("sync_disabled_for_profile", false))
        {
            Object obj = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
            if (obj == null)
            {
                GLogger.e(TAG, "Cannot disable whisper upload syncs. No user manager.", new Object[0]);
            } else
            {
                obj = ((AuthenticationManager) (obj)).getAccountId();
                if (obj == null)
                {
                    GLogger.e(TAG, "Cannot disable whisper upload sync. No account.", new Object[0]);
                } else
                {
                    (new WhisperUploadSyncSchedulerWrapper(getContext(), ((String) (obj)))).disableSyncForProfile(this, getContext());
                    GLogger.i(TAG, "Disabled whisper upload sync for account %s.", new Object[] {
                        obj
                    });
                }
            }
            sharedpreferences.edit().putBoolean("sync_disabled_for_profile", true).apply();
        }
    }

    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentproviderclient, SyncResult syncresult)
    {
        GLogger.d(TAG, "onPerformSync", new Object[0]);
        if (!cloudSyncEnabled)
        {
            GLogger.d(TAG, "Not performing sync. Cloud sync not enabled.", new Object[0]);
            disableSyncForProfile();
            return;
        }
        account = ((WhisperUploadManager)ThorGalleryApplication.getBean(Keys.WHISPER_UPLOAD_MANAGER)).getDeviceStateMonitor();
        if (account == null)
        {
            GLogger.i(TAG, "Not performing sync. No device state monitor.", new Object[0]);
            return;
        }
        account = account.getUploadErrorFromDeviceState();
        if (account != UploadError.NO_ERROR)
        {
            GLogger.i(TAG, "Not performing sync. Not allowed by device state. %s", new Object[] {
                account
            });
            return;
        } else
        {
            GLogger.i(TAG, "Performing sync.", new Object[0]);
            account = new Intent(getContext(), com/amazon/gallery/framework/network/watchdog/WhisperUploadService);
            account.putExtra("start_source", TAG);
            getContext().startService(account);
            return;
        }
    }

}
