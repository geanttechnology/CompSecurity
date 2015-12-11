// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.caching.ObjectData;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            FlurryAppCloud, CacheSyncManager, at, AppCloudResponse, 
//            AppCloudResponseHandler, AppCloudSearch, az

final class go
    implements Runnable
{

    private AppCloudResponseHandler cP;
    private ObjectData gr;

    public go(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        gr = null;
        cP = null;
        gr = objectdata;
        cP = appcloudresponsehandler;
    }

    public final void run()
    {
        Object obj = null;
        if (FlurryAppCloud.D().getPendingData().x(gr.getId()))
        {
            obj = FlurryAppCloud.D().getPendingData().getObjectById(gr.getId());
        } else
        if (FlurryAppCloud.D().getServerData().x(gr.getId()))
        {
            obj = FlurryAppCloud.D().getServerData().getObjectById(gr.getId());
        }
        if (obj != null)
        {
            Log.i("CacheObjectManager", "Object marked to be deleted");
            FlurryAppCloud.D().getPendingData().a(gr);
            try
            {
                obj = new AppCloudResponse(new JSONObject("{code:\"200\",note:\"Deleted from local cache.\"}"));
                cP.handleResponse(((AppCloudResponse) (obj)));
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            AppCloudSearch.onMakeSearchNotValidForCollection(gr.getCollectionName());
            FlurryAppCloud.D().registerDirtyObject(gr.getId(), cP, 2);
            return;
        }
        try
        {
            cP.handleResponse(null);
            return;
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
    }
}
