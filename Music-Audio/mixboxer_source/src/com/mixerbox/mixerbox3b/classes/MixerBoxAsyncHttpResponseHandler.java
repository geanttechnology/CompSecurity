// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.widget.TextView;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

public class MixerBoxAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    Context ctx;

    public MixerBoxAsyncHttpResponseHandler(Context context)
    {
        ctx = context;
    }

    public void onFailure(Throwable throwable, String s)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append(throwable.toString()).append(" / ").append(s).toString());
        if (!MixerBoxClient.isConnectingToInternet(ctx) && ctx.getClass().getSimpleName().equals("MainPage") && ((MainPage)ctx).tvNoInternet.getVisibility() == 8)
        {
            ((MainPage)ctx).tvNoInternet.setVisibility(0);
        }
    }

    public void onSuccess(String s)
    {
        if (ctx.getClass().getSimpleName().equals("MainPage") && ((MainPage)ctx).tvNoInternet.getVisibility() == 0)
        {
            ((MainPage)ctx).tvNoInternet.setVisibility(8);
        }
    }
}
