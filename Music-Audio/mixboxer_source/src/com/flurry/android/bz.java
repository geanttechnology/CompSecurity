// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudApplyOperationResonseHandler;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudLoginResponseHandler;

// Referenced classes of package com.flurry.android:
//            cz, AppCloudUser

final class bz
    implements AppCloudApplyOperationResonseHandler
{

    private cz dQ;

    bz(cz cz1)
    {
        dQ = cz1;
        super();
    }

    public final void onError(AppCloudError appclouderror)
    {
        dQ.fe.onError(appclouderror);
    }

    public final void onOperationSucceed(boolean flag, String s)
    {
        dQ.fe.onOperationSucceed(AppCloudUser.getCurrentUser());
    }
}
