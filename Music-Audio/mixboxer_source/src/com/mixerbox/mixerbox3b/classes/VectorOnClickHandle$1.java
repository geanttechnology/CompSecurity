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
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;
import com.mixerbox.mixerbox3b.fragments.DJsFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MixerBoxAsyncHttpResponseHandler, MyItem

final class nseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final String val$b;
    final String val$id;
    final JSONObject val$j;
    final View val$v;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        try
        {
            ((TextView)val$v).setText(val$j.getString("title"));
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 0);
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        if (((MainPage)ctx).fragmentDJs != null && ((MainPage)ctx).fragmentDJs.isAdded())
        {
            if (val$b.equals("true"))
            {
                MixerBoxUtils.getDJs(ctx);
            } else
            {
                int i = 0;
                while (i < ((MainPage)ctx).arrayDJs.size()) 
                {
                    try
                    {
                        if (((MyItem)((MainPage)ctx).arrayDJs.get(i)).getMyJSONObject().get("ref").equals(val$id))
                        {
                            ((MainPage)ctx).arrayDJs.remove(i);
                            ((MainPage)ctx).fragmentDJs.adapter.notifyDataSetChanged();
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s) { }
                    i++;
                }
            }
        }
        MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 0);
        s = new HashMap();
        s.put("dj_id", val$id);
        s.put("follow", val$b);
        FlurryAgent.logEvent("action:follow", s);
    }

    nseHandler(JSONObject jsonobject)
    {
        val$b = s;
        val$id = s1;
        val$v = view;
        val$j = jsonobject;
        super(final_context);
    }
}
