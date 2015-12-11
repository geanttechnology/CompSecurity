// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.fragments.VectorFragment;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils, MixerBoxSharedPreferences

final class ttpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final VectorFragment val$f;

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        val$f.array = new ArrayList();
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        JSONObject jsonobject;
        int i;
        try
        {
            s = (new JSONObject(s)).getJSONObject("searchVideo").getJSONArray("items");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = s.getJSONObject(i);
        MixerBoxUtils.addMyItemToArray(val$f.array, jsonobject, val$ctx, i, s.length() - i - 1);
        i++;
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_44;
_L3:
        if (s.length() < 2 || s.getJSONObject(1).isNull("isArtist")) goto _L6; else goto _L5
_L5:
        flag = s.getJSONObject(1).getBoolean("isArtist");
        if (!flag) goto _L6; else goto _L7
_L7:
        flag = true;
_L9:
        val$f.setContent();
        if (!MixerBoxSharedPreferences.getTipFirstSearch(val$ctx))
        {
            ((MainPage)val$ctx).setOnboardingGuide(10, new boolean[] {
                flag
            });
        }
        return;
_L2:
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080048), 1);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L6:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    nt(Context context1)
    {
        val$f = vectorfragment;
        val$ctx = context1;
        super(final_context);
    }
}
