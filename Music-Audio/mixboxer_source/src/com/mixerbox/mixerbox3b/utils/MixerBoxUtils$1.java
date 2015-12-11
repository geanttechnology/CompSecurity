// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.Session;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.LoginBridge;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxClient, MixerBoxUtils, MixerBoxSharedPreferences

final class ttpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final Session val$session;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        if (!MixerBoxClient.isConnectingToInternet(val$ctx))
        {
            throwable = new Intent();
            s = new Bundle();
            s.putBoolean("isLogIn", true);
            throwable.putExtras(s);
            throwable.setClass(val$ctx, com/mixerbox/mixerbox3b/LoginBridge);
            val$ctx.startActivity(throwable);
            ((Activity)val$ctx).finish();
            return;
        }
        if (MixerBoxUtils.retryCount > 0)
        {
            MixerBoxUtils.retryCount = 0;
            MixerBoxUtils.toastMsg(val$ctx, (new StringBuilder()).append(val$ctx.getResources().getString(0x7f08005e)).append(" ").append(val$ctx.getResources().getString(0x7f080049)).toString(), 1);
            return;
        } else
        {
            MixerBoxUtils.retryCount++;
            MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f08004a), 1);
            MixerBoxUtils.getAuthLoginInfo(val$ctx, val$session);
            return;
        }
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        FlurryAgent.logEvent("action:logged_in");
        MixerBoxSharedPreferences.putAuthLoginResponse(val$ctx, s);
        MixerBoxUtils.finishFetchInitData(val$ctx);
    }

    eferences(Session session1)
    {
        val$ctx = context1;
        val$session = session1;
        super(final_context);
    }
}
