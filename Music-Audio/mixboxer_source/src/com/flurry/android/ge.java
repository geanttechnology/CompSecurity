// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudApplyOperationResonseHandler;
import com.flurry.android.responses.AppCloudError;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, cx

final class ge
    implements AppCloudResponseHandler
{

    private AppCloudApplyOperationResonseHandler fi;
    private cx ig;

    ge(cx cx1, AppCloudApplyOperationResonseHandler appcloudapplyoperationresonsehandler)
    {
        ig = cx1;
        fi = appcloudapplyoperationresonsehandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse.isSuccessful())
        {
            ig.createUser(appcloudresponse.getResponse());
            fi.onOperationSucceed(true, appcloudresponse.getResponseMessage());
            return;
        } else
        {
            appcloudresponse = new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage());
            fi.onError(appcloudresponse);
            return;
        }
    }
}
