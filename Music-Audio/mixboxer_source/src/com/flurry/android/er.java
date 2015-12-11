// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.caching.ObjectData;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            FlurryAppCloud, CacheSyncManager, at, AppCloudResponse, 
//            AppCloudResponseHandler

final class er
    implements Runnable
{

    private AppCloudResponseHandler cP;
    private ObjectData gr;

    public er(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        gr = null;
        gr = objectdata;
        cP = appcloudresponsehandler;
    }

    public final void run()
    {
        FlurryAppCloud.D().getPendingData().b(gr);
        try
        {
            AppCloudResponse appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"200\",note:\"Updated in local cache.\"}"));
            cP.handleResponse(appcloudresponse);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        FlurryAppCloud.D().registerDirtyObject(gr.getId(), cP, 4);
    }
}
