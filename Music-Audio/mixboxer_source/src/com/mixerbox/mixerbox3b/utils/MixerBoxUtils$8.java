// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import com.mixerbox.mixerbox3b.classes.DividerVectorItem;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.fragments.VectorFragment;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class ttpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final VectorFragment val$f;
    final String val$title;
    final String val$type;

    public final void onSuccess(String s)
    {
        int i;
        i = 0;
        super.onSuccess(s);
        val$f.array = new ArrayList();
        if (s == null) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        JSONObject jsonobject;
        s = (new JSONObject(s)).getJSONObject("getVector");
        jsonarray = s.getJSONArray("items");
        if (!jsonarray.getJSONObject(0).isNull("type") && !jsonarray.getJSONObject(0).getString("type").equals("divider") && !val$type.equals("dj"))
        {
            val$f.array.add(new DividerVectorItem(new JSONObject((new StringBuilder()).append("{\"type\":\"divider\",\"title\":\"").append(val$title).append("\"}").toString()), val$ctx));
        }
        jsonobject = new JSONObject();
        jsonobject.put("type", "dj_info");
        int k = 0;
_L13:
        if (k >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject1 = jsonarray.getJSONObject(k);
        int j = i;
        if (!val$type.equals("dj")) goto _L6; else goto _L5
_L5:
        j = i;
        if (k > 2) goto _L6; else goto _L7
_L7:
        if (k >= 2) goto _L9; else goto _L8
_L8:
        jsonobject.put((new StringBuilder()).append("").append(k).toString(), jsonobject1);
          goto _L10
_L9:
        MixerBoxUtils.addMyItemToArray(val$f.array, jsonobject, val$ctx, k, jsonarray.length() - 1);
        j = 1;
_L6:
        MixerBoxUtils.addMyItemToArray(val$f.array, jsonobject1, val$ctx, k, jsonarray.length() - k - 1 - j);
        i = j;
          goto _L10
_L11:
        val$f.setContent();
        val$f.canScroll = true;
        return;
_L4:
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (!s.isNull("isArtist"))
            {
                s.getBoolean("isArtist");
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        if (true) goto _L11; else goto _L2
_L2:
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080048), 1);
        if (true) goto _L11; else goto _L10
_L10:
        k++;
        if (true) goto _L13; else goto _L12
_L12:
    }

    nt(Context context1)
    {
        val$f = vectorfragment;
        val$type = s;
        val$title = s1;
        val$ctx = context1;
        super(final_context);
    }
}
