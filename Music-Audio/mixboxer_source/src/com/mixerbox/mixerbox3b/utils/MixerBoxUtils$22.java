// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        break MISSING_BLOCK_LABEL_5;
_L2:
        do
        {
            return;
        } while (((MainPage)val$ctx).arrayLocalNotificationList.size() >= 9 || s == null);
        s = (new JSONObject(s)).getJSONObject("getVector");
        if (s.isNull("isArtist") || !s.getBoolean("isArtist")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = s.getJSONArray("items");
        int i = 0;
_L5:
        if (i >= jsonarray.length()) goto _L2; else goto _L3
_L3:
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        JSONObject jsonobject;
        if (!jsonarray.getJSONObject(i).getString("type").equals("playlist") || !jsonarray.getJSONObject(i).getBoolean("isAlbum"))
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = jsonarray.getJSONObject(i);
        s1 = jsonobject.getString("ref");
        s2 = jsonobject.getString("owner");
        s3 = jsonobject.getString("title");
        s4 = jsonobject.getString("thumbnailHQ");
        s5 = jsonobject.getString("size");
        s = "";
        boolean flag;
        try
        {
            if (!jsonobject.isNull("ownerId"))
            {
                s = jsonobject.getString("ownerId");
            }
            flag = ((MainPage)val$ctx).addLocalNotificationList(s1, s3, s2, s4, s5, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        if (flag) goto _L2; else goto _L4
_L4:
        i++;
          goto _L5
    }

    tpResponseHandler(Context context1)
    {
        val$ctx = context1;
        super(final_context);
    }
}
