// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.os.AsyncTask;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.clouddrive.model.ListNodesResponse;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncHandler, CloudDriveServiceClientManager, ColdBootUIHandler

class this._cls0 extends AsyncTask
{

    final CDSSyncHandler this$0;

    protected transient Long doInBackground(Void avoid[])
    {
        avoid = new ListNodesRequest();
        avoid.setLimit(Integer.valueOf(1));
        long l = CDSSyncHandler.access$1300(CDSSyncHandler.this).getBackgroundCdsClient().listNodes(avoid).getCount();
        return Long.valueOf(l);
        avoid;
        GLogger.wx(CDSSyncHandler.access$000(), "Failed to request total count, will use fallback methods when updating progress", avoid);
_L2:
        return Long.valueOf(0L);
        avoid;
        GLogger.d(CDSSyncHandler.access$000(), "Failed to request total count, will use fallback methods when updating progress - interrupted", new Object[0]);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Long long1)
    {
        CDSSyncHandler.access$102(CDSSyncHandler.this, long1.longValue());
        CDSSyncHandler.access$300(CDSSyncHandler.this).setTotalCount(CDSSyncHandler.access$100(CDSSyncHandler.this));
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Long)obj);
    }

    ception()
    {
        this$0 = CDSSyncHandler.this;
        super();
    }
}
