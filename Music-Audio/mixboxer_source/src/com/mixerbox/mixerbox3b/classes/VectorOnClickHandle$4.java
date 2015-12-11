// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.fragments.DJsFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MixerBoxAsyncHttpResponseHandler

final class nseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final String val$b;
    final String val$id;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
        {
            MixerBoxUtils.getDJs(ctx);
        }
        MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
        s = new HashMap();
        s.put("dj_id", val$id);
        s.put("follow", val$b);
        FlurryAgent.logEvent("action:follow", s);
    }

    nseHandler(String s1)
    {
        val$id = s;
        val$b = s1;
        super(final_context);
    }
}
