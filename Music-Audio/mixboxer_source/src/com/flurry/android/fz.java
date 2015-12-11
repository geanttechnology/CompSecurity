// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudApplyOperationResonseHandler;
import com.flurry.android.responses.AppCloudError;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse

final class fz
    implements AppCloudResponseHandler
{

    private AppCloudApplyOperationResonseHandler fi;

    fz(AppCloudApplyOperationResonseHandler appcloudapplyoperationresonsehandler)
    {
        fi = appcloudapplyoperationresonsehandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse != null)
        {
            if (appcloudresponse.isSuccessful())
            {
                fi.onOperationSucceed(false, appcloudresponse.getResponseMessage());
                return;
            } else
            {
                fi.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
                return;
            }
        } else
        {
            fi.onError(new AppCloudError(400, "Bad response"));
            return;
        }
    }
}
