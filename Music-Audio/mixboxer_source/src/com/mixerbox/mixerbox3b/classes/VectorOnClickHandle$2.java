// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
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
    final String val$s;
    final View val$v;

    public final void onFailure(Throwable throwable, String s1)
    {
        super.onFailure(throwable, s1);
        ((TextView)val$v).setText(val$s);
        MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
    }

    public final void onSuccess(String s1)
    {
        super.onSuccess(s1);
        if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
        {
            MixerBoxUtils.getDJs(ctx);
        }
        MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
        s1 = new HashMap();
        s1.put("dj_id", val$id);
        s1.put("follow", val$b);
        FlurryAgent.logEvent("action:follow", s1);
    }

    nseHandler(String s3)
    {
        val$id = s1;
        val$b = s2;
        val$v = view;
        val$s = s3;
        super(final_context);
    }
}
