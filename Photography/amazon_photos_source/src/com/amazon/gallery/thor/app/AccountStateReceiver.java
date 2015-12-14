// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.authentication.AccountStateManager;
import com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ThorGalleryApplication

public class AccountStateReceiver extends BroadcastReceiver
{

    private static final String TAG = com/amazon/gallery/thor/app/AccountStateReceiver.getName();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public AccountStateReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        AccountStateManager accountstatemanager = (AccountStateManager)((ThorGalleryApplication)context.getApplicationContext()).getApplicationBean(Keys.ACCOUNT_STATE_MANAGER);
        GLogger.d(TAG, "Intent: %s received with data: %s", new Object[] {
            intent.getAction(), intent.getData()
        });
        if (BuildFlavors.isAosp())
        {
            GLogger.d(TAG, "Received MAP account broadcast. Updating customer email.", new Object[0]);
            context.startService(new Intent(context, com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService));
        }
        if ("com.amazon.dcp.sso.action.account.removed".equals(intent.getAction()) && !intent.hasExtra("com.amazon.photos.FROM_PHOTOS"))
        {
            ((ThorGalleryApplication)context.getApplicationContext()).clearAllActivities();
        }
        accountstatemanager.processIncomingIntent(context, intent);
    }

}
