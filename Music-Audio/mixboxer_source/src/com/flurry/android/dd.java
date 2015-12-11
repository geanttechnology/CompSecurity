// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudApplyOperationResonseHandler;
import com.flurry.android.responses.AppCloudError;
import java.util.HashMap;

// Referenced classes of package com.flurry.android:
//            AppCloudUser, FlurryAppCloudRequestManager, et

final class dd
    implements AppCloudApplyOperationResonseHandler
{

    private AppCloudApplyOperationResonseHandler fi;
    private AppCloudUser fj;

    dd(AppCloudUser appclouduser, AppCloudApplyOperationResonseHandler appcloudapplyoperationresonsehandler)
    {
        fj = appclouduser;
        fi = appcloudapplyoperationresonsehandler;
        super();
    }

    public final void onError(AppCloudError appclouderror)
    {
        fi.onError(appclouderror);
    }

    public final void onOperationSucceed(boolean flag, String s)
    {
        if (fj.paramMap.containsKey("APPCLOUD_USER_SESSION"))
        {
            String s1 = (String)fj.paramMap.get("APPCLOUD_USER_SESSION");
            FlurryAppCloudRequestManager.UserSession = s1;
            AppCloudUser appclouduser = new AppCloudUser();
            appclouduser.mEmail = fj.mEmail;
            appclouduser.mUsername = fj.mUsername;
            appclouduser.mId = fj.mId;
            AppCloudUser.setCurrentUser(appclouduser);
            et.z(fj.mId);
            et.d(fj.mUsername, fj.mEmail, s1);
            et.A(fj.password);
        }
        fi.onOperationSucceed(flag, s);
    }
}
