// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.f.c;
import com.helpshift.h.e;
import com.helpshift.i.b;
import com.helpshift.k.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, o

class a extends Handler
{

    final int a;
    final HSMessagesFragment b;

    public void handleMessage(Message message)
    {
        a a1 = (a)HSMessagesFragment.s(b).get(a);
        JSONObject jsonobject = (JSONObject)((HashMap)message.obj).get("response");
        try
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("type", "url");
            jsonobject1.put("body", jsonobject.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0).getString("url"));
            jsonobject1.put("id", com.helpshift.HSMessagesFragment.b(b));
            com.helpshift.o.a("m", jsonobject1);
            if (HSMessagesFragment.n(b) != null)
            {
                HSMessagesFragment.n(b).b("User sent a screenshot");
            }
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "Error while getting screenshot url", jsonexception);
        }
        try
        {
            com.helpshift.i.b.a(b.getActivity(), HSMessagesFragment.k(b), a1.h, a1.g, 0);
        }
        catch (IOException ioexception)
        {
            Log.d("HelpShiftDebug", "Saving uploaded screenshot", ioexception);
        }
        if (a1.g.startsWith("localRscMessage_"))
        {
            e.f(a1.g);
            HSMessagesFragment.s(b).remove(a);
        } else
        {
            a1.k = Boolean.valueOf(false);
            a1.j = Boolean.valueOf(true);
            a1.h = "";
            a1.i = Boolean.valueOf(false);
            c.b(a1.g, false);
            c.a(a1.g, true);
            c.a(a1.g, "");
        }
        HSMessagesFragment.d(b).notifyDataSetChanged();
        com.helpshift.HSMessagesFragment.a(b, message);
    }

    (HSMessagesFragment hsmessagesfragment, int i)
    {
        b = hsmessagesfragment;
        a = i;
        super();
    }
}
