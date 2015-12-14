// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.WhisperCacheBeanService;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AccountStateManager

class val.context
    implements Runnable
{

    final AccountStateManager this$0;
    final Context val$context;

    public void run()
    {
        SharedPreferences sharedpreferences = val$context.getSharedPreferences("accountpref", 0);
        if (!sharedpreferences.getBoolean("accountsync", false))
        {
            GLogger.i(AccountStateManager.access$000(), "Pre-fetching Albums", new Object[0]);
            ((SyncManager)ThorGalleryApplication.getBean(Keys.SYNC_MANAGER)).scheduleBackgroundSync();
            val$context.startService(new Intent(val$context, com/amazon/gallery/thor/app/service/WhisperCacheBeanService));
            Intent intent = new Intent("com.amazon.kindle.tablet.ftue_complete", AccountStateManager.access$200());
            val$context.sendBroadcast(intent);
            sharedpreferences.edit().putBoolean("accountsync", true).apply();
            GLogger.i(AccountStateManager.access$000(), "first time sync complete", new Object[0]);
            return;
        } else
        {
            GLogger.i(AccountStateManager.access$000(), "Already did a first-time sync - ignoring this request", new Object[0]);
            return;
        }
    }

    Manager()
    {
        this$0 = final_accountstatemanager;
        val$context = Context.this;
        super();
    }
}
