// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, s

class <init> extends Handler
{

    final Handler a;
    final int b;
    final JSONObject c;
    final String d;
    final l e;

    public void handleMessage(Message message)
    {
        Message message1 = a.obtainMessage();
        message1.obj = message.obj;
        a.sendMessage(message1);
        message = (Integer)((HashMap)message.obj).get("status");
        if (l.a(e, message).booleanValue())
        {
            message = new JSONObject();
            message.put("t", b);
            message.put("p", c);
            e.a.a(d, message);
            return;
        }
        try
        {
            e.a.a(d, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", "JSONException", message);
        }
        return;
    }

    (l l1, Handler handler, int i, JSONObject jsonobject, String s1)
    {
        e = l1;
        a = handler;
        b = i;
        c = jsonobject;
        d = s1;
        super();
    }
}
