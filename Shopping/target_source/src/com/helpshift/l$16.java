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
    final l b;

    public void handleMessage(Message message)
    {
        message = (HashMap)message.obj;
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        message = (JSONObject)message.get("response");
        if (b.a.p().intValue() != message.optInt("bcl", 10))
        {
            b.a.a(Integer.valueOf(message.optInt("bcl", 10)));
        }
        Object obj;
        JSONObject jsonobject;
        obj = b.a.q().optJSONObject("pr");
        jsonobject = message.optJSONObject("pr");
        if (obj != null)
        {
            try
            {
                if (!((JSONObject) (obj)).getString("t").equals(jsonobject.getString("t")))
                {
                    b.i();
                }
            }
            catch (JSONException jsonexception)
            {
                Log.d("HelpShiftDebug", "Reseting counter", jsonexception);
            }
        }
        b.a.a(message);
        obj = a.obtainMessage();
        obj.obj = message;
        a.sendMessage(((Message) (obj)));
    }

    ion(l l1, Handler handler)
    {
        b = l1;
        a = handler;
        super();
    }
}
