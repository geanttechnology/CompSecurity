// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.HashMap;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseRequestManagerHandler, FlurryAppCloudRequestManager, AppCloudResponse, AppCloudResponseHandler, 
//            gq

final class eh
    implements AppCloudResponseRequestManagerHandler
{

    eh()
    {
    }

    public final void handleResponse(AppCloudResponse appcloudresponse, AppCloudResponseHandler appcloudresponsehandler, gq gq, HashMap hashmap)
        throws Exception
    {
        FlurryAppCloudRequestManager.a(appcloudresponse, appcloudresponsehandler, gq, hashmap);
    }
}
