// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.os.AsyncTask;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.GetAccountQuotaRequest;
import com.amazon.clouddrive.model.GetAccountQuotaResponse;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

class loadRequest extends AsyncTask
{

    final ManualUploadAction this$0;
    final loadRequest val$uploadRequest;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new GetAccountQuotaRequest();
        try
        {
            avoid = ManualUploadAction.access$000(ManualUploadAction.this).getForegroundCdsClient().getAccountQuota(avoid);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.ex(ManualUploadAction.access$100(), "Failed to get the storage information...", avoid);
            ManualUploadAction.access$200(ManualUploadAction.this, val$uploadRequest);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.d(ManualUploadAction.access$100(), "Failed to get the storage information - interrupted", new Object[0]);
            ManualUploadAction.access$200(ManualUploadAction.this, val$uploadRequest);
            return null;
        }
        ManualUploadAction.access$300(ManualUploadAction.this, avoid.getAvailable(), val$uploadRequest);
        return null;
    }

    loadRequest()
    {
        this$0 = final_manualuploadaction;
        val$uploadRequest = loadRequest.this;
        super();
    }
}
