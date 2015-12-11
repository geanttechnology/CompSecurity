// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.f.c;
import com.helpshift.k.a;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, o, s, l

class a extends Handler
{

    final int a;
    final HSMessagesFragment b;

    public void handleMessage(Message message)
    {
        a a1 = (a)HSMessagesFragment.s(b).get(a);
        a1.i = Boolean.valueOf(false);
        a1.j = Boolean.valueOf(true);
        a1.k = Boolean.valueOf(false);
        HSMessagesFragment.d(b).notifyDataSetChanged();
        c.b(a1.g, false);
        c.a(a1.g, true);
        com.helpshift.HSMessagesFragment.a(b, message);
        try
        {
            message = new JSONObject();
            message.put("type", "conversation");
            com.helpshift.o.a("r", message);
            if (HSMessagesFragment.n(b) != null)
            {
                HSMessagesFragment.n(b).b("User reviewed the app");
            }
            message = HSMessagesFragment.m(b).q().optString("rurl", "").trim();
            if (!TextUtils.isEmpty(message))
            {
                HSMessagesFragment.k(b).k();
                com.helpshift.HSMessagesFragment.a(b, message);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", message.getMessage(), message);
        }
    }

    (HSMessagesFragment hsmessagesfragment, int i)
    {
        b = hsmessagesfragment;
        a = i;
        super();
    }
}
