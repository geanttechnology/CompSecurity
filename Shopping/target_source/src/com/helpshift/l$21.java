// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.h.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l

class <init> extends Handler
{

    final String a;
    final Boolean b;
    final Handler c;
    final Handler d;
    final l e;

    public void handleMessage(Message message)
    {
        try
        {
            if (((JSONObject)((HashMap)message.obj).get("response")).getString("status").equals("marked"))
            {
                l.d(e).a(a, b);
                message = c.obtainMessage();
                message.obj = b;
                c.sendMessage(message);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Message message1 = d.obtainMessage();
            d.sendMessage(message1);
            Log.d("HelpShiftDebug", "JSON Exception", message);
            return;
        }
    }

    ion(l l1, String s, Boolean boolean1, Handler handler, Handler handler1)
    {
        e = l1;
        a = s;
        b = boolean1;
        c = handler;
        d = handler1;
        super();
    }
}
