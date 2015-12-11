// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, k

class <init> extends Handler
{

    final JSONObject a;
    final Handler b;
    final Handler c;
    final String d;
    final String e;
    final l f;

    public void handleMessage(Message message)
    {
        message = (HashMap)message.obj;
        if (((Integer)message.get("status")).intValue() == 413)
        {
            a.remove("custom_meta");
            k k1 = f.b;
            Handler handler = b;
            Handler handler1 = c;
            String s = d;
            String s1 = e;
            message = a;
            if (!(message instanceof JSONObject))
            {
                message = message.toString();
            } else
            {
                message = JSONObjectInstrumentation.toString((JSONObject)message);
            }
            k1.a(handler, handler1, s, s1, message);
            return;
        } else
        {
            Message message1 = c.obtainMessage();
            message1.obj = message;
            c.sendMessage(message1);
            return;
        }
    }

    (l l1, JSONObject jsonobject, Handler handler, Handler handler1, String s, String s1)
    {
        f = l1;
        a = jsonobject;
        b = handler;
        c = handler1;
        d = s;
        e = s1;
        super();
    }
}
