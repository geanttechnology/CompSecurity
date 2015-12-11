// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.caching.ObjectData;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            FlurryAppCloud, CacheSyncManager, at, AppCloudResponse, 
//            AppCloudResponseHandler, az

final class ev
    implements Runnable
{

    private AppCloudResponseHandler cP;
    private ObjectData gr;

    public ev(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        gr = null;
        cP = null;
        gr = objectdata;
        cP = appcloudresponsehandler;
    }

    public final void run()
    {
        if (!FlurryAppCloud.D().getPendingData().x(gr.getId())) goto _L2; else goto _L1
_L1:
        FlurryAppCloud.D().getPendingData().getObjectById(gr.getId());
_L4:
        if (!FlurryAppCloud.D().checkIfDeleted(gr.getId()))
        {
            break; /* Loop/switch isn't completed */
        }
        AppCloudResponse appcloudresponse;
        appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Object is already deleted, new one has to be created.\"}"));
        break MISSING_BLOCK_LABEL_69;
_L2:
        if (FlurryAppCloud.D().getServerData().x(gr.getId()))
        {
            FlurryAppCloud.D().getServerData().getObjectById(gr.getId());
        }
        if (true) goto _L4; else goto _L3
        try
        {
            cP.handleResponse(appcloudresponse);
            return;
        }
        catch (Exception exception)
        {
            try
            {
                exception.printStackTrace();
                return;
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        return;
_L3:
        try
        {
            cP.handleResponse(null);
            return;
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        return;
    }
}
