// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            l, s

class <init> extends Handler
{

    final Handler a;
    final String b;
    final l c;

    public void handleMessage(Message message)
    {
        Message message1 = a.obtainMessage();
        message1.obj = message.obj;
        a.sendMessage(message1);
        try
        {
            c.a.a(b, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", "JSONException", message);
        }
    }

    ion(l l1, Handler handler, String s1)
    {
        c = l1;
        a = handler;
        b = s1;
        super();
    }
}
