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
//            AppCloudObject, AppCloudResponseHandler

final class gi
    implements Runnable
{

    private AppCloudResponseHandler cP;
    private ObjectData gr;

    public gi(ObjectData objectdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        gr = null;
        gr = objectdata;
        cP = appcloudresponsehandler;
    }

    public final void run()
    {
        String s = FlurryAppCloud.D().getPendingData().a(gr);
        Log.i("CacheObjectManager", (new StringBuilder()).append("temp ID is = ").append(s).toString());
        try
        {
            AppCloudResponse appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"200\",note:\"Created in local cache.\"}"));
            AppCloudObject appcloudobject = AppCloudObject.create("testCollection2");
            appcloudobject.setId(s);
            appcloudresponse.setObject(appcloudobject);
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
        FlurryAppCloud.D().registerDirtyObject(s, cP, 1);
    }
}
