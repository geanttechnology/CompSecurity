// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.caching.CachingManager;
import com.flurry.android.caching.ObjectOperationData;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, cx, FlurryAppCloud, fh, 
//            AppCloudResponse

final class fy
    implements AppCloudResponseHandler
{

    final cx ig;
    final AppCloudResponseHandler in;
    final boolean io;

    fy(cx cx1, AppCloudResponseHandler appcloudresponsehandler, boolean flag)
    {
        ig = cx1;
        in = appcloudresponsehandler;
        io = flag;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse != null && in != null)
        {
            in.handleResponse(appcloudresponse);
            return;
        }
        if (io)
        {
            appcloudresponse = new ObjectOperationData(ig.mId);
        } else
        {
            appcloudresponse = new ObjectOperationData(ig.mId, ig.mCollectionName);
        }
        FlurryAppCloud.C().getOperation(appcloudresponse, new fh(this));
    }
}
