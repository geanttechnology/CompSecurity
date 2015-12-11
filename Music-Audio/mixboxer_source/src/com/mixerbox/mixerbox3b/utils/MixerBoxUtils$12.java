// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.fragments.VectorFragment;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final VectorFragment val$f;

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        val$f.array = new ArrayList();
        s = (new JSONObject(s)).getJSONObject("followInfoV2").getJSONArray("items");
        int i = 0;
_L2:
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = s.getJSONObject(i);
        MixerBoxUtils.addMyItemToArray(val$f.array, jsonobject, val$ctx, i, s.length() - i - 1);
        i++;
        if (true) goto _L2; else goto _L1
        s;
        s.printStackTrace();
_L1:
        val$f.setContent();
        return;
    }

    t(Context context1)
    {
        val$f = vectorfragment;
        val$ctx = context1;
        super(final_context);
    }
}
