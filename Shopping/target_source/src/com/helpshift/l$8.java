// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.h.a;
import com.helpshift.i.j;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, g

class  extends Handler
{

    final Handler a;
    final l b;

    public void handleMessage(Message message)
    {
        Message message1;
        message1 = a.obtainMessage();
        message = (HashMap)message.obj;
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        message = (JSONObject)message.get("response");
        s = message.getString("id");
        s1 = message.getString("publish_id");
        s2 = com.helpshift.l.a(b, message.getString("section_id"));
        s3 = message.getString("title");
        s4 = message.getString("body");
        boolean flag;
        if (message.getString("is_rtl") == "true")
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!message.has("stags"))
        {
            break MISSING_BLOCK_LABEL_163;
        }
        message = j.a(message.getString("stags"));
_L2:
        message = new g(0L, s, s1, s2, s3, s4, 0, Boolean.valueOf(flag), message);
        message1.obj = message;
        a.sendMessage(message1);
        l.d(b).a(message);
        return;
        message = new ArrayList();
        if (true) goto _L2; else goto _L1
_L1:
        message;
        Log.d("HelpShiftDebug", (new StringBuilder()).append("Exception in getting question ").append(message).toString());
    }

    (l l1, Handler handler)
    {
        b = l1;
        a = handler;
        super();
    }
}
