// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.SetupAccountRequest;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.SetupAccountEvent;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AccountStateManager

class val.onComplete
    implements Runnable
{

    final AccountStateManager this$0;
    final Runnable val$onComplete;

    public void run()
    {
        ((CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER)).getForegroundCdsClient().setupAccount(new SetupAccountRequest());
        GlobalMessagingBus.post(new SetupAccountEvent(true));
        if (val$onComplete != null)
        {
            val$onComplete.run();
        }
        return;
        Object obj;
        obj;
_L2:
        GLogger.i(AccountStateManager.access$000(), "Exception while setting up customer's account", new Object[] {
            obj
        });
        GlobalMessagingBus.post(new SetupAccountEvent(false));
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$0 = final_accountstatemanager;
        val$onComplete = Runnable.this;
        super();
    }
}
