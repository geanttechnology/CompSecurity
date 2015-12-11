// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudLoginResponseHandler;

// Referenced classes of package com.flurry.android:
//            AppCloudUser, bz

final class cz
    implements AppCloudLoginResponseHandler
{

    final AppCloudLoginResponseHandler fe;
    private String ff;
    private String fg;
    private String fh;

    cz(AppCloudLoginResponseHandler appcloudloginresponsehandler, String s, String s1, String s2)
    {
        fe = appcloudloginresponsehandler;
        ff = s;
        fg = s1;
        fh = s2;
        super();
    }

    public final void onError(AppCloudError appclouderror)
    {
        AppCloudUser appclouduser = new AppCloudUser();
        if (appclouderror.getErrorCode() == 404 && appclouderror.getErrorMessage().equals("not found"))
        {
            appclouduser.setUsername(ff);
            appclouduser.setEmail(fg);
            appclouduser.setPassword(fh);
            try
            {
                appclouduser.saveOrCreateWithCompletionHandler(new bz(this));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AppCloudError appclouderror)
            {
                appclouderror.printStackTrace();
            }
            return;
        } else
        {
            fe.onError(appclouderror);
            return;
        }
    }

    public final void onOperationSucceed(AppCloudUser appclouduser)
    {
        fe.onOperationSucceed(appclouduser);
    }
}
