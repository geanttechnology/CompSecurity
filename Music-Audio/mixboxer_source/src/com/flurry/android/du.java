// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudLoginResponseHandler;

// Referenced classes of package com.flurry.android:
//            FlurryWalletHandler, FlurryWallet, AppCloudUser

final class du
    implements AppCloudLoginResponseHandler
{

    private String fD;
    private FlurryWalletHandler fE;

    du(String s, FlurryWalletHandler flurrywallethandler)
    {
        fD = s;
        fE = flurrywallethandler;
        super();
    }

    public final void onError(AppCloudError appclouderror)
    {
        fE.onError(new AppCloudError(appclouderror.getErrorCode(), appclouderror.getErrorMessage()));
    }

    public final void onOperationSucceed(AppCloudUser appclouduser)
    {
        FlurryWallet.a(appclouduser);
        appclouduser = appclouduser.getId();
        FlurryWallet.addObserverForUser(fD, appclouduser, fE);
    }
}
