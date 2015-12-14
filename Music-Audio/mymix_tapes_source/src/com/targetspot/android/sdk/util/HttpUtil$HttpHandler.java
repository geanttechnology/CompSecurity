// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

// Referenced classes of package com.targetspot.android.sdk.util:
//            HttpUtil

public static class  extends Handler
{

    public static final int ERROR = 0;
    public static final int SUCCESS_JSON = 2;
    public static final int SUCCESS_STR = 1;

    public void handleError(Throwable throwable)
    {
    }

    public void handleJSONObject(JSONObject jsonobject)
    {
    }

    public void handleMessage(Message message)
    {
        if (message.what != 0) goto _L2; else goto _L1
_L1:
        if (message.obj == null) goto _L4; else goto _L3
_L3:
        if (!(message.obj instanceof Throwable)) goto _L6; else goto _L5
_L5:
        handleError((Throwable)message.obj);
_L8:
        return;
_L6:
        if (message.obj instanceof String)
        {
            handleError(new NullPointerException((String)message.obj));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        handleError(new NullPointerException());
        return;
_L2:
        if (message.what == 1)
        {
            if (message.obj == null)
            {
                handleString(null);
                return;
            }
            if (message.obj instanceof String)
            {
                handleString((String)message.obj);
                return;
            } else
            {
                handleString(null);
                return;
            }
        }
        if (message.what == 2)
        {
            if (message.obj == null)
            {
                handleJSONObject(new JSONObject());
                return;
            }
            if (message.obj instanceof JSONObject)
            {
                handleJSONObject((JSONObject)message.obj);
                return;
            }
            if (message.obj instanceof String)
            {
                JSONObject jsonobject = new JSONObject();
                try
                {
                    message = new JSONObject((String)message.obj);
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    message = jsonobject;
                }
                handleJSONObject(message);
                return;
            } else
            {
                handleJSONObject(new JSONObject());
                return;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void handleString(String s)
    {
    }

    public ()
    {
    }
}
