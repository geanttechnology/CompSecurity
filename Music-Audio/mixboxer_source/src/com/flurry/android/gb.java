// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.caching.CachingManager;
import com.flurry.android.caching.ObjectOperationData;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, cx, FlurryAppCloud, AppCloudResponse

final class gb
    implements AppCloudResponseHandler
{

    private cx ig;
    private AppCloudResponseHandler in;
    private boolean io;

    gb(cx cx1, boolean flag, AppCloudResponseHandler appcloudresponsehandler)
    {
        ig = cx1;
        io = flag;
        in = appcloudresponsehandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse == null)
        {
            if (io)
            {
                appcloudresponse = new ObjectOperationData(ig.mId);
            } else
            {
                appcloudresponse = new ObjectOperationData(ig.mId, ig.mCollectionName);
            }
            FlurryAppCloud.C().deleteOperation(appcloudresponse, in);
            return;
        } else
        {
            in.handleResponse(appcloudresponse);
            return;
        }
    }
}
